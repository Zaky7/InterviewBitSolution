package Array;

import java.util.ArrayList;

public class RotateMatrix {

    public void rotateMatrix(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int m = mat.get(0).size();

        if (m != n) {
            return;
        }


        if(n == 2) {
            for (int j = 0, i=0; j < n - 1; j++) {
                System.out.println("I: " + i + " J: " + j);
                int prevI = i;
                int prevJ = j;
    
                int newI = prevJ;
                int newJ = n - 1 - prevI;
                int prevTemp = mat.get(prevI).get(prevJ);
    
                while ((newI < n) && (newJ < n) && (newI != i || newJ != j)) {
                    int newTemp = mat.get(newI).get(newJ);
                    mat.get(newI).set(newJ, prevTemp);
                    prevTemp = newTemp;
                    prevI = newI;
                    prevJ = newJ;
    
                    newI = prevJ;
                    newJ = n - 1 - prevI;
                }
                
                
                mat.get(newI).set(newJ, prevTemp);
                displayMatrix(mat);
            }   
        } else {
            for(int  i = 0; i<= n - 3; i++) {    
                for (int j = i; j < n - 1- i; j++) {
                    System.out.println("I: " + i + " J: " + j);
                    int prevI = i;
                    int prevJ = j;
        
                    int newI = prevJ;
                    int newJ = n - 1 - prevI;
                    int prevTemp = mat.get(prevI).get(prevJ);
        
                    while ((newI < n) && (newJ < n) && (newI != i || newJ != j)) {
                        int newTemp = mat.get(newI).get(newJ);
                        mat.get(newI).set(newJ, prevTemp);
                        prevTemp = newTemp;
                        prevI = newI;
                        prevJ = newJ;
        
                        newI = prevJ;
                        newJ = n - 1 - prevI;
                    }
                    
                    
                    mat.get(newI).set(newJ, prevTemp);
                    displayMatrix(mat);
                }      
            }
        }        

       
    }

    public static void displayMatrix(ArrayList<ArrayList<Integer>> mat) {
        System.out.println();
        for (ArrayList<Integer> list : mat) {
            System.out.println();
            for (Integer ele : list) {
                if(ele < 10) {
                    System.out.print("0" + ele + " ");
                } else {
                    System.out.print(ele + " ");
                }
                
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int n = 2   ;

        ArrayList<ArrayList<Integer>> matList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0, counter=0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                counter++;
                list.add(counter);
            }
            matList.add(list);
        }

        displayMatrix(matList);

        RotateMatrix rm = new RotateMatrix();
        rm.rotateMatrix(matList);

        displayMatrix(matList);
    }
}