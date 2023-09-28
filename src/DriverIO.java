import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DriverIO {

    public static void writeToFile(WordTagFrequency wtf, Tags tags) {
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
            FileWriter myWriter = new FileWriter("out/PoS Output.txt");
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

    public static void readFromFile(String path) {
        WordTagFrequency wtf = null;
        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);

            String tagsString = myReader.nextLine();
            Tags tags = new Tags();

            tagsString = tagsString.replace("Tags [", "");
            tagsString = tagsString.replace("]", ", ");
            for (String t: tagsString.split(", ")) {
                tags.addTag(t);
            }

            //Pattern pattern = Pattern.compile("(\\[?.+?,[ |\\]])");
            //Matcher matcher = pattern.matcher(tagsString);

            //boolean primeiro = true;

            //while (matcher.find()) {
            //    String tag = matcher.group();
            //    if (primeiro) {
            //        //System.out.println(tag);
            //    }
            //    primeiro = false;
            //    System.out.println(tag);
            //}

            //while (myReader.hasNextLine()) {
            //    String data = myReader.nextLine();
            //}

            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred in the file reader.");
            e.printStackTrace();
        }
        //return wtf;
    }
}
