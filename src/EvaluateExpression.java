/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.



Input Format

The only argument given is character array A.
Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.
For Example

Input 1:
    A =   ["2", "1", "+", "3", "*"]
Output 1:
    9
Explaination 1:
    starting from backside:
    *: ( )*( )
    3: ()*(3)
    +: ( () + () )*(3)
    1: ( () + (1) )*(3)
    2: ( (2) + (1) )*(3)
    ((2)+(1))*(3) = 9

Input 2:
    A = ["4", "13", "5", "/", "+"]
Output 2:
    6
Explaination 2:
    +: ()+()
    /: ()+(() / ())
    5: ()+(() / (5))
    1: ()+((13) / (5))
    4: (4)+((13) / (5))
    (4)+((13) / (5)) = 6
 */

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public   int cal(String operation , int b,int a){
        switch (operation){
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
            default: return 0;
        }
    }

    public  int evalRPN(ArrayList<String> A) {
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
}
