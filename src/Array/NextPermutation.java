package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import algorithm.sorting.QuickSort;

public class NextPermutation {

    public void nextPermutation(ArrayList<Integer> a) {
        int n = a.size();
        boolean isSwapped = false;

        for(int i=n-1; i>0; i--) {
            if(a.get(i-1) < a.get(i)) {
                QuickSort.quickSort(a, i, n-1);
                isSwapped = true;
                int swapIndex = -1;
                int start = i-1;

                for(int j=n-1; j>start; j--) {
                    if(a.get(j) < a.get(start)) {
                        swapIndex = j + 1;
                        break;
                    }
                }

                if(swapIndex != -1) {
                    swap(a, start, swapIndex);
                } else {
                    swap(a, start, start + 1);
                }

                break;
            }
        }

        if(isSwapped == false) {
            Collections.sort(a);
        }

    }

    public static void swap(ArrayList<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static void main(String args[]) {
        Integer[] arr = {1, 7 , 9, 11, 13, 2};
        ArrayList<Integer> a = new ArrayList<Integer>();

        a.addAll(Arrays.asList(arr));
        print(a);
        NextPermutation np = new NextPermutation();

        for(int i=0; i< a.size(); i++)  {
            np.nextPermutation(a);
            print(a);
        }

    }

    public static void print(ArrayList<Integer> a) {
        System.out.println();
        for(Integer i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
