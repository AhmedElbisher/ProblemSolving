/*
Given a collection of numbers, return all possible permutations.
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
 */

import java.util.ArrayList;

public class Permutations {

    public static void calPremutaion(ArrayList<Integer> A ,int position , ArrayList<Integer> result ){
        if(A.size() == 1){
            result.set(position,A.get(0));
            System.out.println(result);
            return;
        }
        for(int i=0 ;i< A.size() ;i++){
            result.set(position,A.get(i));
            ArrayList<Integer>  newArray = new ArrayList<>();
            for(int j=0 ;j<A.size() ;j++){
                if(A.get(j) != A.get(i)) newArray.add(A.get(j));
            }
            calPremutaion(newArray,position+1,result);
        }

    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        result.addAll(A);
        calPremutaion(A,0,result);
    }
}
