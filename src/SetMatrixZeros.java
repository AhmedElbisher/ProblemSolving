/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

 */


import java.util.ArrayList;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rowsSize=0;
        int colmSize=0;
        int row=-1;
        int colm= -1;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> temp2= new ArrayList<Integer>();

        if(a != null && a.size() > 0 ) {
            rowsSize = a.get(0).size();
            colmSize = a.size();
        }else {
            return;
        }


        for(int j=0;j< colmSize ; j++) {
            temp = a.get(j);
            for(int i =0 ;i <rowsSize ; i++) {
                if(temp.get(i)==0) {
                    if(row  == -1 && colm == -1) {
                        row = i;
                        colm = j;
                    }else {
                        a.get(colm).set(i, 0);
                        a.get(j).set(row, 0);
                    }
                }
            }
        }
        if(row != -1 ){

            temp = a.get(colm);
            for(int j=0;j< temp.size() ; j++) {
                if(temp.get(j)==0) {
                    if(j == row) continue;
                    for(int i = 0 ;i<colmSize ; i ++ ) {
                        a.get(i).set(j, 0);
                    }
                }
            }

            for(int i = 0 ;i<colmSize ; i ++ ) {
                if(a.get(i).get(row) == 0) {
                    for(int j=0;j< a.get(i).size(); j++) {
                        a.get(i).set(j, 0);
                    }
                }
            }

            for(int i = 0 ;i<colmSize ; i ++ ) {
                a.get(i).set(row, 0);
            }
        }


    }
}
