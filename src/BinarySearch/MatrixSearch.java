package BinarySearch;

import java.util.ArrayList;

class MatrixSearch {

    public int searchMatrix(ArrayList<ArrayList<Integer>> arr, int target) {
        int R = arr.size();
        int C = arr.get(0).size();
        int startRow = 0, startCol = 0, endRow = R - 1, endCol = C - 1;

        while (startRow <= endRow) {
            int midRowIndex = (startRow + endRow) / 2;

            if (target == arr.get(midRowIndex).get(startCol)) {
                return midRowIndex;
            } else if (target < arr.get(midRowIndex).get(startCol)) {
                // Move Up
                endRow = midRowIndex - 1;
            } else if (target > arr.get(midRowIndex).get(startCol)) {
                if (target <= arr.get(midRowIndex).get(endCol)) {
                    // Search between Range [midRowIndex][0] to [midRowIndex][endCol];
                    return binarySearchRow(arr, midRowIndex, target, endCol);
                } else {
                    // Move Down
                    startRow = midRowIndex + 1;
                }
            }
        }

        return -1;
    }

    public int binarySearchRow(ArrayList<ArrayList<Integer>> mat, int midRowIndex, int target, int endCol) {
        int start = 0;
        int end = endCol;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mat.get(midRowIndex).get(mid) == target) {
                return mid;
            } else if (mat.get(midRowIndex).get(mid) > target) {
                end = mid - 1;
            } else if (mat.get(midRowIndex).get(mid) < target) {
                start = mid + 1;
            }
        }

        return -1;
    }

    public void printMat(ArrayList<ArrayList<Integer>> mat) {
        int R = mat.size();
        int C = mat.get(0).size();

        System.out.println("Row: " + R + " Column: " + C);

        for(int i=0; i < R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        MatrixSearch ms = new MatrixSearch();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
        int[][] matArr = {
            {1,   3,  3,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
          };
        int R = 3, C = 4;

        for(int i=0; i< R; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j =0; j < C; j++) {
                temp.add(matArr[i][j]);
            }
            mat.add(new ArrayList<>(temp));
        }
        

        ms.printMat(mat);

        System.out.println("Target Found at Index: " + ms.searchMatrix(mat, 3));
        
    }
}