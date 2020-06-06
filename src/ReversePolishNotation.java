/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.


 */

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotation {
    public  static  int cal(String operation , int b,int a){
        switch (operation){
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
            default: return 0;
        }
    }

    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> operands = new Stack<>();
        for(String s : A){
            try {
                int temp = Integer.parseInt(s);
                operands.push(temp);
            }catch (Exception e){
                int temp = cal(s,operands.pop(),operands.pop());
                operands.push(temp);
            }
        }
        if (operands.isEmpty()) return 0;
        return operands.pop();
    }


    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("4");
        A.add("13");
        A.add("5");
        A.add("/");
        A.add("+");

        System.out.println(evalRPN(A));

    }

}
