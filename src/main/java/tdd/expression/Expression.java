package tdd.expression;

public interface Expression {
    double eval(String expression);
    static Expression build(){
        return new SimpleExpression();
    }
}
