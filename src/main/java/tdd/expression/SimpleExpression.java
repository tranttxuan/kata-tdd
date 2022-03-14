package tdd.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression implements Expression{

    private static class Expr{
        private final Operator operator;
        private final double leftOperand;
        private final double rightOperand;

        private final static String regexp = "^(\\d+)([\\+|\\-|\\*|\\/])(\\d+)$";

        private final static Pattern pattern = Pattern.compile(regexp);


        public  Expr(Operator operator, double leftOperand, double rightOperand){
            this.operator = operator;
            this.leftOperand = leftOperand;
            this.rightOperand = rightOperand;
        }

        static Expr of(Operator operator, double leftOperand, double rightOperand){
            return new Expr(operator, leftOperand, rightOperand);
        }

        static Expr of(String expression){

            final Matcher matcher = pattern.matcher(expression);

            if(!matcher.matches()){
                throw new IllegalArgumentException("Illegal expression");
            }

            final var exp =   of(Operator.getOperator(matcher.group(2)), Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(3)));

            if(exp.getOperator() == Operator.DIVIDE && exp.getRightOperand() == 0){
                throw new IllegalArgumentException("The divisor could not be zero");
            }

            return exp;

           /*  final String[] operand;
           if(expression.contains("+")){
                operand = expression.split("\\+");
                return of(Operator.ADD, Double.parseDouble(operand[0]),  Double.parseDouble(operand[1]));
            }
            else if (expression.contains("-")){
                operand = expression.split("\\-");
                return of(Operator.SUBTRACT, Double.parseDouble(operand[0]),  Double.parseDouble(operand[1]));
            }
            else if (expression.contains("*")){
                operand = expression.split("\\*");
                return of(Operator.MULTIPLE, Double.parseDouble(operand[0]),  Double.parseDouble(operand[1]));
            }
            else if (expression.contains("/")){
                operand = expression.split("/");
                return of(Operator.DIVIDE, Double.parseDouble(operand[0]),  Double.parseDouble(operand[1]));
            }
            else {
                throw new IllegalArgumentException("Unrecognized operator");
            }*/
        }

        public Operator getOperator() {
            return operator;
        }

        public double getLeftOperand() {
            return leftOperand;
        }

        public double getRightOperand() {
            return rightOperand;
        }

        enum Operator{
            ADD("+"),
            SUBTRACT("-"),
            MULTIPLE("*"),
            DIVIDE("/");
            private final String opt;

            private static final Map<String, Operator> typeMapping = new HashMap<>();

            static {
                typeMapping.put(ADD.opt, ADD);
                typeMapping.put(SUBTRACT.opt, SUBTRACT);
                typeMapping.put(MULTIPLE.opt, MULTIPLE);
                typeMapping.put(DIVIDE.opt, DIVIDE);
            }

            Operator(String opt){
                this.opt = opt;
            }

            public static Operator getOperator(String opt) {
                return typeMapping.get(opt);
            }

            @Override
            public String toString() {
                return "Operator: opt=" + opt;
            }
        }
    }

    @Override
    public double eval(String expression) {
        if(expression == null || expression.trim().isEmpty()){
            throw new IllegalArgumentException("The expression is illegal.");
        }
        final var expr = Expr.of(expression);

       switch (expr.operator){
           case ADD:
               return expr.leftOperand + expr.rightOperand;
           case SUBTRACT:
               return expr.leftOperand - expr.rightOperand;
           case MULTIPLE:
               return expr.leftOperand * expr.rightOperand;
           case DIVIDE:
               return  expr.leftOperand / expr.rightOperand;
       }
       throw new IllegalArgumentException("Unsupport the operator");
    }
}
