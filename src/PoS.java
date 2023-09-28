import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PoS {

    public static void main(String[] args) {

        String path = "data/Secs0-18 - training";

        PoSData data = FileReader.readFromFile(path);
        WordTagFrequency wtf = new WordTagFrequency(data);

        System.out.println(Arrays.toString(data.getTagsArray()));
        System.out.println(Arrays.toString(data.getTagsIndex()));

        List<String> ks = new ArrayList<>(data.getTags().getTagsMap().keySet());
        List<Integer> kv = new ArrayList<>(data.getTags().getTagsMap().values());

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

        try (Scanner scanner = new Scanner(System.in)) {
            String s;

            try {
                do {
                    s = scanner.nextLine();
                    System.out.println(wtf.probableTag(s));
                } while (!s.isEmpty());
            } catch(IllegalStateException | NoSuchElementException e) {
                System.out.println("System.in was closed; exiting");
            }
        }

    }

}
