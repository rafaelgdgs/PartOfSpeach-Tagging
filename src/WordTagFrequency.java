import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordTagFrequency {
    private final Tags tags;

    private final PoSData pdata;
    private final Map<String, List<Integer>> frequency;

    public WordTagFrequency(PoSData pd) {
        this.pdata = pd;
        this.tags = this.pdata.getTags();
        this.frequency = new HashMap<>();

        for (Sentence s : this.pdata.getSentences()) {
            System.out.print("");
        }
    }

    public void addWord(String word, int n) {
        if (!this.frequency.containsKey(word)) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            this.frequency.put(word, al);
        }
        int value = this.frequency.get(word).get(n);
        this.frequency.get(word).set(n, ++value);
    }
}
