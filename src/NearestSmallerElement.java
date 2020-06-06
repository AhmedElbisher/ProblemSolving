/*
 G[i] for an element A[i] = an element A[j] such that
    j is maximum possible AND
    j < i AND
    A[j] < A[i]
*/
import java.util.ArrayList;
import java.util.Stack;
public class NearestSmallerElement {
    public static  ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> G = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        if(A == null || A.size() < 1) return null;
        stack.push(A.get(0));
        G.add(-1);
        if(A.size()==1 ) return G;


        for(int i =1 ; i < A.size(); i++){
            while (!stack.isEmpty()){
                if(stack.peek() < A.get(i)){
                    int x = stack.pop();
                    G.add(x);
                    stack.push(x);
                    stack.push(A.get(i));
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                G.add(-1);
                stack.push(A.get(i));
            }

        }
        return G;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<>();
        A.add(4);
        A.add(3);
        A.add(5);
        A.add(3);
        A.add(4);
        A.add(1);
        System.out.println(prevSmaller(A));
    }

}
