import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PoS {

    public static void main(String[] args) {

        String path = "data/Secs0-18 - training";
		/*
		if (args[0].isEmpty()) {
			path = "/data/Secs0-18 - training";
		}
		else {
			path = args[0];
		}*/

        PoSData data = FileReader.readFromFile(path);
        WordTagFrequency wtf = new WordTagFrequency(data);

        //System.out.println(Arrays.toString(data.getWordsArray()));
        System.out.println(Arrays.toString(data.getTagsArray()));
        System.out.println(Arrays.toString(data.getTagsIndex()));

        for (String key: wtf.getFrequency().keySet()) {
            //String value = Arrays.toString(wtf.getFrequency().get(key));
            System.out.println(key + " " + Arrays.toString(wtf.getFrequency().get(key)));
        }

        try (Scanner scanner = new Scanner(System.in)) {
            String s;

            try {
                do {
                    s = scanner.nextLine();

                } while (!s.isEmpty());
            } catch(IllegalStateException | NoSuchElementException e) {
                System.out.println("System.in was closed; exiting");
            }
        }

    }

}
