package score;

/**
 *
 * @author Lucas de Castro
 */
public class MergeTestOneArray {

    public static void main(String[] args) {
        Score[] scores = {
            new Score("andre", 4),
            new Score("carlos", 8.5),
            new Score("ana", 10),
            new Score("jonas", 3),
            new Score("juliana", 6.7),
            new Score("guilherme", 7),
            new Score("paulo", 9),
            new Score("mariana", 5),
            new Score("lucia", 2.1),};

//        merge(scores, 0, 1, 2);//first pair
//        merge(scores, 2, 3, 4);//second pair
//        merge(scores, 0, 2, 4);//merge between them
//
//        merge(scores, 4, 5, 6);//first pair
//        merge(scores, 6, 7, 8);//second pair
//        merge(scores, 4, 6, 8);//merge between them
//
//        merge(scores, 0, 4, 8);//merge between the 2 first group
//
//        merge(scores, 0, 8, 9);//merge between the 8 sorted elements and the last one
        sort(scores, 0, scores.length);

        printArray(scores);

    }

    /**
     * Recursive method to divide by 2 and after merge
     * 
     * @param scores
     * @param initial
     * @param end 
     */
    private static void sort(Score[] scores, int initial, int end) {
        int quantity = end - initial;//quantity of elements

        if (quantity > 1) {//the limit to avoid stackoverflow
            int middle = (initial + end) / 2;
            sort(scores, initial, middle);
            sort(scores, middle, end);
            merge(scores, initial, middle, end);
        }
    }

    /**
     * Merge the scores only using the requested range
     *
     * @param scores
     * @param initial
     * @param middle
     * @param end
     * @return
     */
    private static void merge(Score[] scores, int initial, int middle, int end) {
        System.out.println("Merging initial: " + initial + ", middle: " + middle +", end: " + end);
        Score[] rank = new Score[end - initial];
        int actual = 0;

        int actual1 = initial;
        int actual2 = middle;

        while (actual1 < middle && actual2 < end) {
            Score score1 = scores[actual1];
            Score score2 = scores[actual2];
            if (score1.getValue() < score2.getValue()) {
                rank[actual] = score1;
                actual1++;
            } else {
                rank[actual] = score2;
                actual2++;
            }
            actual++;
        }

        while (actual1 < middle) {
            rank[actual] = scores[actual1];
            actual++;
            actual1++;
        }
        while (actual2 < end) {
            rank[actual] = scores[actual2];
            actual++;
            actual2++;
        }

        for (int counter = 0; counter < actual; counter++) {
            scores[initial + counter] = rank[counter];
        }
    }

    private static void printArray(Score[] scores) {
        for (Score score : scores) {
            System.out.println(score);
        }
    }
}
