import java.util.HashMap;
import java.util.Map;

public class Tags {

    private final Map<String, Integer> tags;
    private Integer size;
    private static Tags instance;
    public static final String unknownTag = "UNK";

    public Tags() {
        this.tags = new HashMap<>();
        this.size = 0;
        this.addTag(Tags.unknownTag);
    }

    public static Tags get() {
        if (Tags.instance == null) {
            Tags.instance = new Tags();
        }
        return Tags.instance;
    }

    public Integer addTag(String tag) {
        if (!this.tags.containsKey(tag)) {
            this.tags.put(tag, size++);
        }
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

    public int getTagValue(String tag) {
        if (!this.tags.containsKey(tag)) {
            return this.tags.get("UNK");
        }
        return this.tags.get(tag);
    }

    public int getSize() {
        return this.size;
    }

    public String getKey(int value) {
        for (Map.Entry<String, Integer> entry: tags.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return "";
    }
}
