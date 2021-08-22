package score;

/**
 *
 * @author Lucas de Castro
 */
public class MergeTest {

    public static void main(String[] args) {
        Score[] teacher1 = {
            new Score("andre", 4),
            new Score("mariana", 5),
            new Score("carlos", 8.5),
            new Score("paulo", 9)

        };
        Score[] teacher2 = {
            new Score("jonas", 3),
            new Score("juliana", 6.7),
            new Score("guilherme", 7),
            new Score("lucia", 9.3),
            new Score("ana", 10)

        };

        Score[] rank = merge(teacher1, teacher2);
        for (Score nota : rank) {
            System.out.println(nota.getStudent() + " " + nota.getValue());
        }
    }

    private static Score[] merge(Score[] teacher1, Score[] teacher2) {
        int total = teacher1.length + teacher2.length;
        Score[] finalScore = new Score[total];
        int actual1 = 0;
        int actual2 = 0;
        int actual = 0;

        while (actual1 < teacher1.length && actual2 < teacher2.length) {
            Score score1 = teacher1[actual1];
            Score score2 = teacher2[actual2];
            if (score1.getValue() < score2.getValue()) {
                finalScore[actual] = score1;
                actual1++;
            } else {
                finalScore[actual] = score2;
                actual2++;
            }
            actual++;
        }

        while (actual1 < teacher1.length) {
            finalScore[actual] = teacher1[actual1];
            actual++;
            actual1++;
        }
        while (actual2 < teacher2.length) {
            finalScore[actual] = teacher2[actual2];
            actual++;
            actual2++;
        }

        return finalScore;
    }
}
