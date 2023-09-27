import java.util.ArrayList;
import java.util.List;

public class PoSData {

    private List<Sentence> words;
    private Tags tags;

    public PoSData() {
        this.words = new ArrayList<Sentence>();
        this.tags = new Tags();
    }

    public List<Sentence> getSentences() {
        return this.words;
    }

    public String[] getTagsArray() {
        return this.tags.getTagsArray();
    }

    public Integer[] getTagsIndex() {
        return this.tags.getTagsIndex();
    }

    public Integer addTags(String tag) {
        return this.tags.addTag(tag);
    }

    public void addSentence(Sentence sent) {
        this.words.add(sent);
    }
}
