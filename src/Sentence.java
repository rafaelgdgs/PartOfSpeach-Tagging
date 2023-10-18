import java.util.ArrayList;
import java.util.List;

public class Sentence {

    //private final List<String> words;
    //private final List<Integer> tags;
    private final List<Pair<String, Integer>> wordTagPair;

    public Sentence() {
        //this.words = new ArrayList<String>();
        //this.tags = new ArrayList<Integer>();
        this.wordTagPair = new ArrayList<>();
    }

    public List<String> getWords() {
        //return this.words;
        List<String> retArray = new ArrayList<String>();
        for (Pair<String, Integer> p: wordTagPair) {
            retArray.add(p.first());
        }
        return retArray;
    }

    public List<Integer> getTags() {
        //return this.tags;
        List<Integer> retArray = new ArrayList<Integer>();
        for (Pair<String, Integer> p: wordTagPair) {
            retArray.add(p.second());
        }
        return retArray;
    }

    public void addWord(String word, Integer tag) {
        //this.words.add(word);
        //this.tags.add(tag);
        wordTagPair.add(new Pair<>(word, tag));
    }

    public List<Pair<String, Integer>> getPairs() {
        return this.wordTagPair;
    }
}
