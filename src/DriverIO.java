import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DriverIO {

    public static void writeToFile(WordTagFrequency wtf, String path) {
        Tags tags = wtf.getTags();
        List<String> ks = new ArrayList<>(tags.getTagsMap().keySet());
        List<Integer> kv = new ArrayList<>(tags.getTagsMap().values());

        List<Pair<String, Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < ks.size(); i++) {
            pairs.add(new Pair<>(ks.get(i), kv.get(i)));
        }
        pairs.sort(Comparator.comparing(Pair::second));
        for (int i = 0; i < pairs.size(); i++) {
            ks.set(i, pairs.get(i).first());
        }

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write("Tags " + ks + "\n");
            for (String key: wtf.getFrequency().keySet()) {
                myWriter.write(key + " " + Arrays.toString(wtf.getFrequency().get(key)) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static WordTagFrequency readFromFile(String path) {
        WordTagFrequency wtf = new WordTagFrequency();
        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);

            String tagsString = myReader.nextLine();
            Tags tags = new Tags();

            Pattern pattern = Pattern.compile("(.*?) \\[(.*?)\\]");
            Matcher matcher = pattern.matcher(tagsString);

            int sizeTags = 0;
            if (matcher.find()) {
                for (String t: matcher.group(2).split(", ")) {
                    tags.addTag(t);
                    sizeTags++;
                }
            }
            wtf.setTags(tags);

            while (myReader.hasNextLine()) {
                String cString = myReader.nextLine();
                matcher = pattern.matcher(cString);

                if (matcher.find()) {
                    int[] freq = new int[sizeTags];
                    int i = 0;
                    for (String t: matcher.group(2).split(", ")) {
                        freq[i++] = Integer.parseInt(t);
                    }
                    wtf.addWordArray(matcher.group(1), freq);
                }
            }

            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred in the file reader.");
            e.printStackTrace();
        }
        return wtf;
    }
}
