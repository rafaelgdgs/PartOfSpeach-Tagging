import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static PoSData readFromFile(String path) {

        PoSData pdata = new PoSData();

        try {
            File file = new File(path);
            Scanner scanner;
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                Sentence sent = new Sentence();

                String line = scanner.nextLine();
                String[] lineElement = line.split(" ");

                for (String i: lineElement) {
                    String[] pair = i.split("_");
                    sent.addWord(pair[0], pdata.addTags(pair[1]));
                }

                pdata.addSentence(sent);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo Invalido!");
            e.printStackTrace();
        }

        return pdata;
    }
}
