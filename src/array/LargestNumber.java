package array;/*package whatever //do not write package name here */

import java.util.List;
import java.util.ArrayList;


class LargestNumber {
	public static void main (String[] args){
	      ArrayList<Integer> arr = new ArrayList<Integer>();
	      arr.add(49);
	      arr.add(37);
	      arr.add(39);
	      arr.add(12);


        LargestNumber gfs = new LargestNumber();
	      System.out.println(gfs.findNthPlace(49, 2));
	      System.out.println(gfs.findDigits(485));
	   //   gfs.printArr(arr);
	}
	
	void printArr(ArrayList<Integer> arr) {
	    System.out.println("Array Elements are: ");
	    for(Integer ele: arr) {
	        System.out.print(ele + " ");
	    }
	    System.out.println();
	}
   
    int findMaxList(List<Integer> list) {
        int size = list.size();
        int result = 0;
        
        if(size > 0) {
            result = list.get(0);
            for(int i=1; i< size; i++) {
                if(result < list.get(i)) {
                    result = list.get(i);
                }
            }
        }
        
        return result;
    }
    
    int findDigits(int num) {
        int digits = 0;
        while(num >= 0) {
           digits++;
           num = num / 10;
        }
        return digits;
    }
    
    int findNthPlace(int num, int pos) {
        for(int i=0; i < pos - 1; pos--) {
            // System.out.println("Num: " + num + " Pos: " + pos);
            num = num / 10;
        }
        return num % 10;
    }

   
    // String reverseRadixSort(final List<Integer> list) {
        
    //     int maxDigits = findDigits(findMaxList(list));
    // }
}