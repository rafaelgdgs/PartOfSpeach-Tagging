import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private final List<String> words;
    private final List<Integer> tags;

    public Sentence() {
        this.words = new ArrayList<String>();
        this.tags = new ArrayList<Integer>();
    }

    public List<String> getWords() {
        return this.words;
    }

    public List<Integer> getTags() {
        return this.tags;
    }

    public String[] getWordArray() {
        return this.words.toArray(String[]::new);
    }

    public Integer[] getTagArray() {
        return this.tags.toArray(Integer[]::new);
    }

    public void addWord(String word, Integer tag) {
        this.words.add(word);
        this.tags.add(tag);
    }

    public int getWordIndex(String word) {
        return this.words.indexOf(word);
    }
}
