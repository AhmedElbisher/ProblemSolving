/*
Given an array of integers,
find two numbers such that they add up to a specific target number.
The function twoSum should return indices of
the two numbers such that they add up to the target,
where index1 < index2. Please note that your returned answers
(both index1 and index2 ) are not zero-based.
Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public class Pair implements Comparable<Pair>{
        int first ;
        int second;
        public Pair(int a, int b){
            first= a;
            second= b;
        }



        @Override
        public int compareTo(Pair o) {
            if(this.second > o.second || (this.second ==  o.second && this.first > o.first))
                return 1;
            else if(this.second ==  o.second && this.first == o.first)
                return 0;
            else return -1;
        }
    }

    public  ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> helper = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        if(A.size() < 2) return result;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =A.size()-1 ; i >= 0 ;i--){
            map.put(A.get(i) , i);
        }
        helper.addAll(A);
        Collections.sort(helper);
        int j = helper.size()-1;
        for(int i=0 ;i<j;){
            int sum = helper.get(i)+ helper.get(j);
            if(sum < B) i++;
            else if (sum>B) j--;
            else {
                int firest=map.get(helper.get(i));
                int second = map.get(helper.get(j));
                if(helper.get(i) == helper.get(j)){
                    for(int x=0;x<A.size();x++){
                        if(A.get(x) == helper.get(i) && x != firest){
                            second=x;
                            break;
                        }
                    }
                }
                Pair x = new Pair(firest,second);
                pairs.add(x);
                i++;
            }
        }
        Collections.sort(pairs);
        if(pairs.size()>0) {
            result.add(pairs.get(0).first+1);
            result.add(pairs.get(0).second+1);
        }
        return  result;
    }


    public static void main(String[] args) {
        ArrayList<Integer>  A = new ArrayList<>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        TwoSum to = new TwoSum();
        System.out.println( to.twoSum(A,2).toString());
    }
}
