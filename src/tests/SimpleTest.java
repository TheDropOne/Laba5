package tests;

/**
 * Created by Semen on 07-Oct-16.
 */
public class SimpleTest {
    private String expression;
    private boolean isCorrect;

    public SimpleTest(String expression, boolean isCorrect) {
        this.expression = expression;
        this.isCorrect = isCorrect;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return this.getExpression();
    }
}
