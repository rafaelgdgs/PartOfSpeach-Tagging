public class PoS {

    public static void main(String[] args) {

        String path = "data/Secs0-18 - training";

        PoSData data = FileReader.readFromFile(path);
//        WordTagFrequency wtf = new WordTagFrequency(data);

//        System.out.println(Arrays.toString(data.getTagsArray()));
//        System.out.println(Arrays.toString(data.getTagsIndex()));

        DriverIO.readFromFile("out/PoS Output.txt");

//        try (Scanner scanner = new Scanner(System.in)) {
//            String s;
//
//            try {
//                do {
//                    s = scanner.nextLine();
//                    System.out.println(wtf.probableTag(s));
//                } while (!s.isEmpty());
//            } catch(IllegalStateException | NoSuchElementException e) {
//                System.out.println("System.in was closed; exiting");
//            }
//        }

    }

}
