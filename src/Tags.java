import java.util.HashMap;
import java.util.Map;

public class Tags {

    private final Map<String, Integer> tags;
    private Integer size;

    public Tags() {
        this.tags = new HashMap<String, Integer>();
        this.size = 0;
    }

    public Integer addTag(String tag) {
        if (!this.tags.containsKey(tag)) {
            this.tags.put(tag, size++);
        }
        return this.tags.get(tag);
    }

    public int getTagValue(String tag) {
        return this.tags.get(tag);
    }

    public String[] getTagsArray() {
        return this.tags.keySet().toArray(String[]::new);
    }

    public Integer[] getTagsIndex() {
        return this.tags.values().toArray(Integer[]::new);
    }

    public Map<String, Integer> getTagsMap() {
        return this.tags;
    }

    public int getSize() {
        return this.size;
    }
}
