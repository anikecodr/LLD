package org.example.compositedesignpattern.expressionevaluation;

public class Number implements MathematicsExpression {

    int num;
    public Number(int num) {
        this.num = num;
    }

    @Override
    public int evaluate() {
        return num;
    }
}
