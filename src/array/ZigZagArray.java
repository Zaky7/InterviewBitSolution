package array;

import java.util.Arrays;

public class ZigZagArray {
    
	public static final int INCREASING = 0;
	public static final int DECREASING = 1;
	
	
	public static void swap(int[] arr, int index1, int index2) {
	    arr[index1] = arr[index1] + arr[index2];
		arr[index2] = arr[index1] - arr[index2];
		arr[index1] = arr[index1] - arr[index2];
		return;
	}
	
	
	
	
	public static void printArray(int[] arr) {
		for(int i=0, size=arr.length; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void convertToZigZagArray(int[] arr) {
		int actionToggle = INCREASING;
		
		for(int i=0, size=arr.length; i < size - 1; i++) {
			if(actionToggle == INCREASING) {
				if(arr[i] > arr[i+1]) 
					swap(arr, i , i+1);
			} else if(actionToggle == DECREASING) {
				if(arr[i] < arr[i+1]) 
					swap(arr, i, i+1);
			}
			actionToggle = 1 - actionToggle;
		}
	}
	
	
	public static boolean isArraysEqual(int[] arr1, int[] arr2) {
		int len1 =  arr1.length;
		int len2 =  arr2.length;
		boolean result = false;
		
		if(len1 != len2) {
			result = false;
			return result;
		}
		
		for(int i=0; i<len1; i++) {
			if(arr1[i] != arr2[i]) {
				result = false;
				return result;
			}
		}
		
		result = true;
		return result;
	}
	
	
	public static void main(String args[]) {
		int[][] testcases = {{4, 3, 7, 8, 6, 2, 1}, {1, 4, 3, 2}, {6, 5, 4, 3, 2, 1}};
		int[][] solution = {{3, 7, 4, 8, 2, 6, 1}, {1, 4, 2, 3}, { 1, 7, 3, 11, 9}};
		int T = testcases.length;
		
		for(int i=0; i<T; i++) {
			convertToZigZagArray(testcases[i]);
			printArray(testcases[i]);
		    boolean isEqual = isArraysEqual(testcases[i], solution[i]);
		    
		    if(isEqual == true) {
				System.out.print(" Two Arrays are Equal \n");
			} else {
				System.out.print(" Two Arrays are not Equalc \n");
			}
		}
	}
	
	
}
