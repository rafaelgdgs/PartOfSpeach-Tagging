import java.util.*;

public class WordTagFrequency {
    private Tags tags;

    private Map<String, int[]> frequency;

    public WordTagFrequency() {
        this.tags = new Tags();
        this.frequency = new HashMap<>();
    }

    public void addPosData(PoSData pd) {
        this.tags = pd.getTags();
        this.frequency = new HashMap<>();

        for (Sentence s : pd.getSentences()) {
            List<String> a = s.getWords();
            List<Integer> b = s.getTags();
            for (int i = 0; i < a.size(); i++) {
                addWord(a.get(i), b.get(i));
            }
        }
    }

    public void addWordArray(String word, int[] array) {
        this.frequency.put(word, array);
    }

    public void addWord(String word, int n) {
        if (!this.frequency.containsKey(word)) {
            int[] al = new int[tags.getSize()];
            this.frequency.put(word, al);
        }
        this.frequency.get(word)[n]++;
    }

    public Map<String, int[]> getFrequency() {
        return this.frequency;
    }

    public String probableTag(String word) {
        if (!frequency.containsKey(word)) {
            return "UNK";
        }
        //List<Integer> l = new ArrayList<>(Arrays.stream(this.frequency.get(word)).boxed().toList());
        int [] val = this.frequency.get(word);
        int maxValuePos = 0;
        for (int i = 0; i < val.length; i++) {
            maxValuePos = val[i] > val[maxValuePos] ? i : maxValuePos;
        }
        if (val[maxValuePos] < 5) {
            return "UNK";
        }
        return tags.getKey(maxValuePos);
    }

    public int probableTagInt(String word) {
        if (!frequency.containsKey(word)) {
            return -1;
        }
        int [] val = this.frequency.get(word);
        int maxValuePos = 0;
        for (int i = 0; i < val.length; i++) {
            maxValuePos = val[i] > val[maxValuePos] ? i : maxValuePos;
        }
        if (val[maxValuePos] < 5) {
            return -1;
        }
        return maxValuePos;
    }

    public Tags getTags() {
        return this.tags;
    }

    public void setTags(Tags t) {
        this.tags = t;
    }
}
