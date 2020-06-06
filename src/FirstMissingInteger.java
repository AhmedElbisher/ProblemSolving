/*
Given an unsorted integer array, find the first missing positive integer.
 */


import java.util.ArrayList;

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> a) {
        for(int i=0 ; i < a.size() ;i++) {
            int n=a.get(i);
            if(n < 0 || n > a.size()) {
                a.set(i, 0);
            }
        }

        for(int i=0 ; i < a.size() ;i++) {
            int n=a.get(i);
            if(n == 0 || n == i+1 ){
                continue;
            }else if (a.get(n-1) == n) {
                a.set(i, 0);
            }else{
                while(!(a.get(i)== i+1 || a.get(i) == 0)  ){
                    int temp = a.get(a.get(i)-1);
                    a.set(a.get(i)-1, a.get(i));
                    a.set(i,temp);

                }
            }
        }

        for(int i=0 ; i < a.size() ;i++) {
            if(a.get(i)!=i+1) return i+1;
        }
        if( a.get(a.size()-1) == a.size()) return a.size()+1;
        else return 1;

    }
}
