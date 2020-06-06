/*
Given a matrix of integers A of size N x M and an integer B.

Write an efficient algorithm that searches for integar B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


 */

import java.util.ArrayList;
import java.util.List;

public class MatrixSearch {
    public static int binarySearch(List<Integer> A , int key) {
        int left =0;
        int right = A.size()-1;
        while(left <= right) {
            int mid = (right+left)/2;
            if(A.get(mid) ==  key) return 1;
            else if(A.get(mid) > key) right = mid-1;
            else left = mid+1;
        }
        return 0 ;
    }

    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {

        for(ArrayList<Integer> row : A) {
            if(B <=  row.get(row.size()-1) && B >= row.get(0)) {
                return binarySearch(row,B);
            }

        }
        return 0;
    }
}
