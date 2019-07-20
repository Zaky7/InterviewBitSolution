package Algorithm.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {


    public static void quickSort(ArrayList<Integer> arr, int start, int end) {
        if(start < end) {
            int pivotIndex = findPivotIndex(arr, start, end);
            quickSort(arr, start, pivotIndex-1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }


    public static int findPivotIndex(ArrayList<Integer> arr, int start, int end) {
        int pivot =  arr.get(end);
        int pIndex = start;

        for(int i=start; i<end; i++) {
            if(arr.get(i) <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }

        swap(arr, pIndex, end);
        return pIndex;
    }


    public static void swap(ArrayList<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }


    public static void print(ArrayList<Integer> arr) {
        System.out.println();
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }


    public static void main(String args[]) {
        Integer[] arr = {1, 3, 5, 7, 14, 17, 1};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));

        quickSort(a, 0, arr.length-1);
        print(a);
    }
}
