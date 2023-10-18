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
                System.out.println("Valores: " + pair.second() + ", " + wtf.probableTagInt(pair.first()));
                confMatrix[pair.second()][wtf.probableTagInt(pair.first())] += 1;
            }
        }
    }

    public void showConfMatrix() {
        for (int[] i: confMatrix) {
            for (int j: i) {
                System.out.print("" + j + " ");
            }
            System.out.println();
        }

    }
}
