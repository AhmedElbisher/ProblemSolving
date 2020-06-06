/*
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
 */

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        Collections.reverse(A);

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == i) return 1;
            while ((i + 1) < A.size() && A.get(i) == A.get(i + 1)) {
                i++;
            }
        }
        return -1;
    }
}
