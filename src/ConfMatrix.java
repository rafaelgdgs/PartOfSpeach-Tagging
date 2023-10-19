public class ConfMatrix {
    private Tags tags;
    private int[][] confMatrix;
    private WordTagFrequency wtf;
    private PoSData val;

    public ConfMatrix(WordTagFrequency wtf, PoSData val) {
        this.wtf = wtf;
        this.val = val;
        this.tags = wtf.getTags();

        confMatrix = new int[this.tags.getSize()][this.tags.getSize()];
        calculate();
    }

    private void calculate() {
        for (Sentence sent: val.getSentences()) {
            for (Pair<String, Integer> pair: sent.getPairs()) {
                //System.out.println("Valores: " + pair.second() + ", " + wtf.probableTagInt(pair.first()));
                confMatrix[pair.second()][wtf.probableTagInt(pair.first())] += 1;
            }
        }
    }

    public void showConfMatrix() {
        //System.out.println(Arrays.toString(tags.getTagsArray()));
        System.out.print("      ");
        for (int l = 0; l < tags.getSize(); l++) {
            System.out.printf("%5s ", tags.getKey(l));
        }
        System.out.println();
        int k = 0;
        for (int[] i: confMatrix) {
            System.out.printf("%5s ", tags.getKey(k++));
            for (int j: i) {
                System.out.printf("%5d ", j);
            }
            System.out.println();
        }

    }
}
