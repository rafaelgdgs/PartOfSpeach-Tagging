public class ConfMatrix {
    private final Tags tags;
    private final int[][] confMatrix;
    private final WordTagFrequency wtf;
    private final PoSData val;

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
                confMatrix[pair.second()][wtf.probableTagInt(pair.first())] += 1;
            }
        }
    }

    public void showConfMatrix() {
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
