package org.example.compositedesignpattern;

public class ClientCode {

    public static void main(String[] args){
        MathematicsExpression expleft = new Number(6);

        MathematicsExpression rightleft  = new Number(1);
        MathematicsExpression rightright = new Number(3);
        MathematicsExpression expright = new Expression(rightleft, rightright, Operator.SUB);
        MathematicsExpression finalExp = new Expression(expleft, expright, Operator.MULTIPLY);
    System.out.println(finalExp.evaluate());
    }
}
