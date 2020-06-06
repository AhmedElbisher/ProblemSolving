import java.util.ArrayList;

/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        if(a == null || a.size() <1 ) return 0;
        int j =1;
        for (int i=1 ; i< a.size() ; i++) {
            if( (a.get(i)-a.get(i-1)) == 0) continue;
            else {
                a.set(j, a.get(i));
                j++;
            }
        }
        int temp = a.size()-1 ;
        for(;temp>=j;temp-- ) a.remove(temp);
        return j;
    }
}
