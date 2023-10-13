import java.util.*;

public class PoS {

    public static void main(String[] args) {

        String defaultPath = "/home/jhin/workdata/Secs0-18 - training";
        String defaultDrivePath = "/home/jhin/workdata/PoS Output.txt";
        String defaultValidationPath = "/home/jhin/workdata/Secs22-24 - testing";

        WordTagFrequency wtf = null;

        Scanner input = new Scanner(System.in);
        int choice;
        String trash;
        String pathChoice;

        while(true) {
            System.out.println("PoS Main Menu\n");
            System.out.print("1.) Read training data. \n");
            System.out.print("2.) Write WordTagFrequency to file.\n");
            System.out.print("3.) Read WordTagFrequency from file.\n");
            System.out.print("4.) Test training data by words.\n");
            System.out.print("5.) List Tags vector.\n");
            System.out.print("6.) Verify WTF accuracy.\n");
            System.out.print("9.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();
            trash = input.nextLine();




            switch(choice){

                case 1:
                    pathChoice = "";
                    System.out.print("Enter the path to the training data, or leave it blank to load default path = '" + defaultPath + "' :");
                    pathChoice = input.nextLine();
                    if (pathChoice.isEmpty()) {
                        pathChoice = defaultPath;
                    }
                    wtf = new WordTagFrequency();
                    wtf.addPosData(FileReader.readFromFile(pathChoice));
                    System.out.println("Training data read");
                    break;

                case 2:
                    if (wtf == null) {
                        System.out.println("WordTagFrequency is empty, cannot save to file\n");
                        break;
                    }
                    pathChoice = "";
                    System.out.print("Enter the path to the WordTagFrequency data, or leave it blank to save to default path = '" + defaultDrivePath + "' :");
                    pathChoice = input.nextLine();
                    if (pathChoice.isEmpty()) {
                        pathChoice = defaultDrivePath;
                    }
                    DriverIO.writeToFile(wtf, pathChoice);
                    System.out.println("WordTagFrequency wrote to file");
                    break;

                case 3:
                    pathChoice = "";
                    System.out.print("Enter the path to the WordTagFrequency data, or leave it blank to load default path = '" + defaultDrivePath + "' :");
                    pathChoice = input.nextLine();
                    if (pathChoice.isEmpty()) {
                        pathChoice = defaultDrivePath;
                    }
                    wtf = DriverIO.readFromFile(pathChoice);
                    System.out.println("WordTagFrequency Read from file successful");
                    break;

                case 4:
                    if (wtf == null) {
                        System.out.println("WordTagFrequency not initialized, Try another option.\n");
                        break;
                    }
                    System.out.println("Insert word to check predicted tag, leave blank to leave");
                    String s;
                    try {
                        do {
                            s = input.nextLine();
                            System.out.println(wtf.probableTag(s));
                        } while (!s.isEmpty());
                    } catch(IllegalStateException | NoSuchElementException e) {
                        System.out.println("System.in was closed; exiting");
                    }
                    break;

                case 5:
                    if (wtf == null) {
                        System.out.println("WordTagFrequency not loaded, no tags to show.\n");
                        break;
                    }
                    System.out.println(Arrays.toString(wtf.getTags().getTagsArray()));
                    break;

                case 6:
                    if (wtf == null) {
                        System.out.println("WordTagFrequency not initialized, Try another option.\n");
                        break;
                    }
                    pathChoice = "";
                    System.out.print("Enter the path to the WordTagFrequency data, or leave it blank to save to default path = '" + defaultDrivePath + "' :");
                    pathChoice = input.nextLine();
                    if (pathChoice.isEmpty()) {
                        pathChoice = defaultValidationPath;
                    }
                    Validation.validateWTF(wtf, pathChoice);
                    break;

                case 9:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default :
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;

            }

        }

        //System.out.println(Arrays.toString(data.getTagsArray()));
        //System.out.println(Arrays.toString(data.getTagsIndex()));

        //System.out.println(Arrays.toString(wtf.getTags().getTagsArray()));


    }

}
