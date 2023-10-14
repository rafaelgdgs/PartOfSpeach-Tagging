import java.util.List;

public class Validation {

    public static void validateWTF(WordTagFrequency wtf, String valPath) {

        PoSData valDB = FileReader.readFromFile(valPath);
        int wordsAmount = 0;
        int correctWordsAmount = 0;

        for (Sentence s: valDB.getSentences()) {
            List<String> words = s.getWords();
            List<Integer> tags = s.getTags();

            for (int i = 0; i < words.size(); i++) {
                wordsAmount++;
                if (wtf.probableTagInt(words.get(i)) == tags.get(i)) {
                    correctWordsAmount++;
                }
            }
        }
        System.out.println("Total words: " + wordsAmount + ", total correct: " + correctWordsAmount + ", Percent: " + String.format("%.2f", ((double)correctWordsAmount/wordsAmount) * 100) + "%.");
    }
}
