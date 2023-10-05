import java.util.*;

public class PoS {

    public static void main(String[] args) {

        String path = "/home/jhin/workdata/Secs0-18 - training";
        String drivepath = "/home/jhin/workdata/PoS Output.txt";

        //PoSData data = FileReader.readFromFile(path);
        //WordTagFrequency wtf = new WordTagFrequency();
        //wtf.addPosData(data);

        //System.out.println(Arrays.toString(data.getTagsArray()));
        //System.out.println(Arrays.toString(data.getTagsIndex()));

        //DriverIO.writeToFile(wtf, drivepath);
        WordTagFrequency wtf = DriverIO.readFromFile(drivepath);
        System.out.println(Arrays.toString(wtf.getTags().getTagsArray()));

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
