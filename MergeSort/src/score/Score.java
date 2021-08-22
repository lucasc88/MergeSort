package score;

/**
 *
 * @author Lucas de Castro
 */
public class Score {

    private String student;
    private double value;

    public Score(String student, double value) {
        this.student = student;
        this.value = value;
    }

    String getStudent() {
        return student;
    }

    double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Student: " + student + ", score: " + value;
    }

    
}
