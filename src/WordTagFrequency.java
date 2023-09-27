import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordTagFrequency {
    private final Tags tags;

    private final PoSData pdata;
    private final Map<String, int[]> frequency;

    public WordTagFrequency(PoSData pd) {
        this.pdata = pd;
        this.tags = this.pdata.getTags();
        this.frequency = new HashMap<>();

        for (Sentence s : this.pdata.getSentences()) {
            List<String> a = s.getWords();
            List<Integer> b = s.getTags();
            for (int i = 0; i < a.size(); i++) {
                addWord(a.get(i), b.get(i));
            }
        }
    }

    public void addWord(String word, int n) {
        if (!this.frequency.containsKey(word)) {
            int[] al = new int[tags.getSize()];
            this.frequency.put(word, al);
        }
        this.frequency.get(word)[n]++;// = this.frequency.get(word)[n]+1;
    }

    public Map<String, int[]> getFrequency() {
        return this.frequency;
    }
}
