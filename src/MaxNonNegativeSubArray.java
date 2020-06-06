/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
*/
import java.util.ArrayList;
public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> arr) {
        int maxsum =0,maxlength=0,maxStart=0 ;
        int currIndex=0,currSum=0;
        int i;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(i=0 ; i< arr.size() ; i++) {
            if(arr.get(i) >= 0) {
                currSum +=arr.get(i);
            }else {
                if(currSum >= maxsum  ) {
                    if(currSum > maxsum ){
                        maxsum=currSum;
                        maxStart=currIndex;
                        maxlength=i-currIndex;}
                    else  if(i-currIndex > maxlength){
                        maxsum=currSum;
                        maxStart=currIndex;
                        maxlength=i-currIndex;
                    }
                }
                while( i<arr.size() &&arr.get(i)<0 ) {
                    i++;
                }
                if(!(i<arr.size())){
                    break;
                }
                currIndex=i;
                currSum=arr.get(i);
            }

        }
        if(currSum > maxsum) {
            maxsum=currSum;
            maxStart=currIndex;
            maxlength=i-currIndex;
        }

        for(int j =maxStart;j<maxlength+maxStart;j++){
            result.add(arr.get(j));
        }


        return result;
    }


}
