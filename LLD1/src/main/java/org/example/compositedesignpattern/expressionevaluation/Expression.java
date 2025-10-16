package org.example.compositedesignpattern.expressionevaluation;

public class Expression implements MathematicsExpression {

    private final MathematicsExpression leftMathematicsExp;
    private final MathematicsExpression rightMathematicsExp;

    private final Operator operator;

    public Expression(MathematicsExpression leftMathematicsExp, MathematicsExpression rightMathematicsExp, Operator operator) {
        this.leftMathematicsExp = leftMathematicsExp;
        this.rightMathematicsExp = rightMathematicsExp;
        this.operator = operator;
    }

    @Override
    public int evaluate() {

        return switch (operator) {
            case ADD -> leftMathematicsExp.evaluate() + rightMathematicsExp.evaluate();
            case SUB -> leftMathematicsExp.evaluate() - rightMathematicsExp.evaluate();
            case DIVIDE -> leftMathematicsExp.evaluate() / rightMathematicsExp.evaluate();
            case MULTIPLY -> leftMathematicsExp.evaluate() * rightMathematicsExp.evaluate();
            default -> 0;
        };
    }
}
