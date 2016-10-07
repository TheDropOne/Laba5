package tests;

/**
 * Created by Semen on 08-Oct-16.
 */
public class ComplexTest {
    private String expression;
    private String correctExpression;

    public ComplexTest(String expression, String correctExpression) {
        this.expression = expression;
        this.correctExpression = correctExpression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getCorrectExpression() {
        return correctExpression;
    }

    public void setCorrectExpression(String correctExpression) {
        this.correctExpression = correctExpression;
    }

    @Override
    public String toString() {
        return this.getExpression();
    }
}
