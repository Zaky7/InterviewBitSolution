package binarysearch;

import java.util.ArrayList;
import java.util.List;

class RotatedArraySearch {


    public int search(final List<Integer> arr, int target, int start , int end) {
        
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if (arr.get(mid) == target) {
            return mid;
        } 


        if(arr.get(start) <= arr.get(mid)) {
            if(target >= arr.get(start) && target <= arr.get(mid)){
                return search(arr, target, start, mid-1);
            }
            return search(arr, target, mid+1, end);
        }


        if(target >= arr.get(mid) && target <= arr.get(end)) {
            return search(arr, target, mid+1, end);
        }

        return search(arr, target, start, mid - 1);
    }


    public static void main(String[] args) {
        Integer a [][] ={
            // {7, 0, 1, 2, 3, 4 , 5, 6},
            // {2, 3, 4, 5, 6, 17, 0, 1},
            {2, 1},
            {2, 3, 4 ,5, 1}
        };
        
        
        for(int j =0; j < a.length; j++) {
            int target = 1;
            final List<Integer> arr = new ArrayList<Integer>();
            
            for(int i=0; i< a[j].length; i++)  {
                arr.add(a[j][i]);
            }

            // System.out.println(arr.toString());

            RotatedArraySearch rsearch = new RotatedArraySearch();
            int index = rsearch.search(arr, target, 0, arr.size() - 1) ;
            
            System.out.println("J: " + j + " Element Found at Index: " + index); 
        }
    }
}