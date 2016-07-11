package com.mrsun.stack;

import java.util.Stack;

public class ExpEvaluation {

    /*
    Pseudo Code:
    Take two Stacks, one each for Operands and Operators.
    Parse the expression character by character.
    For each character:
        Case 1: If <white space> Then <Skip it>.
        Case 2: If <number> Then <Push it into Operands Stack>.
        Case 3: If <( Open bracket> Then <Push it into Operator Stack>.
        Case 4: If <+-/* Operators> Then <Push it into Operator Stack>.
        Case 5: If <) Closed bracket> Then <Pop operator.While it is not equal to (,
                store the operator in a variable, pop two operands, evaluate them 
                and push it into operand stack.>
    While there are still values in Operands Stack and operator stack is empty, 
        evaluate all the operands with the stored operator.
     */
    public static void main(String[] args) {
        
        String exp1 = "(+ 5 4 6)";
        String exp2 = "(* 2 (- 7 3) 4)";
        String exp3 = "(+ 3 (* 5 2) (- 6 3))";
        
        evaluate(exp1);
        evaluate(exp2);
        evaluate(exp3);
    }

    public static void evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        //Old operator stored to evalute all the final values
        char oldOp = '\0';

        for (int i = 0; i < tokens.length; i++) {
            char token = tokens[i];
            //Skip the white spaces
            if (token == ' ') {
                continue;
            }
            //If token is a number, push it into values stack
            if (token >= '0' && token <= '9') {
                values.push(Character.getNumericValue(token));
            } //If token is (, push it into ops stack
            else if (token == '(') {
                ops.push(token);
            } //If token is ), solve the expression till (, and store the op
            else if (token == ')') {
                while (ops.peek() != '(') {
                    oldOp = ops.pop();
                    values.push(calculate(oldOp, values.pop(), values.pop()));
                }
                ops.pop();
            } //If token is operator, push it into ops stack
            else if (token == '+' || token == '-' || token == '*' || token == '/') {
                ops.push(token);
            }
        }
        //If ops stack is empty, and still there are numbers in values stack, 
        //apply the old operator to all the remaining numbers and
        //push the result into values stack
        while (values.size() > 1 && ops.isEmpty()) {
            if (oldOp != '\0') {
                values.push(calculate(oldOp, values.pop(), values.pop()));
            }
        }
        System.out.println(expression +" ==> " + values.pop());
    }

    public static int calculate(char op, int v2, int v1) {
        switch (op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v2 == 0 ? 0 : v1 / v2;
        }
        return 0;
    }

}
