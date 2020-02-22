package array;

import java.util.Arrays;

public class SquaresOfSortedArray {
	
	public static void swap(int[] A, int index1, int index2) {
		A[index1] = A[index1] + A[index2];
		A[index2] = A[index1] - A[index2];
		A[index1] = A[index1] - A[index2];
	}
	
	public static int[] reverseArray(int[] A) {
		int start = 0;
		int end = A.length - 1;
		
		while(start < end) {
			swap(A, start, end);
			start++;
			end--;
		}
		
		return A;
	}
	
	public int[] sortedSquares(int[] A) {
        int firstPosNumIndex = getFirstPosNumIndex(A);
        int N = A.length;
        
        System.out.print("FirstPosNumIndex: " + firstPosNumIndex);
        
        // Find squares of A
        A = Arrays.stream(A).map(ele -> ele * ele).toArray();
        
        if(firstPosNumIndex == 0) {
        	return A;
        } else if(firstPosNumIndex == N) {
        	return reverseArray(A);
        } else {
        	int[] newArray = new int[N];
        	int endIndexOfNegArray = firstPosNumIndex - 1;
        	int newArrayIndex = 0;
        	
        	while(firstPosNumIndex < N && endIndexOfNegArray >= 0) {
        		if(A[firstPosNumIndex] <= A[endIndexOfNegArray]) {
        			newArray[newArrayIndex++] = A[firstPosNumIndex++];
        		} else {
        			newArray[newArrayIndex++] = A[endIndexOfNegArray--];
        		}
        	}
        	
        	while(endIndexOfNegArray >= 0) {
        		newArray[newArrayIndex++] = A[endIndexOfNegArray--]; 
        	}
        	
        	while(firstPosNumIndex < N) {
        		newArray[newArrayIndex++] = A[firstPosNumIndex++];
        	}
        	return newArray;
        }
        
       
    }
	
	
	public static void printArray(int[] A) {
		System.out.println();
		for(int i=0, size=A.length; i < size; i++) {
			System.out.print(A[i] + " ");
		}
	}
    
    
    public int getFirstPosNumIndex(int[] A) {
        int firstPosNumIndex = 0;
        
        while(firstPosNumIndex < A.length && A[firstPosNumIndex] < 0) {
            firstPosNumIndex++;
        }
        
        return firstPosNumIndex;
    }
	
	public static void main(String args[]) {
	   int[] A = {-2, -1, 3};
	   
	   SquaresOfSortedArray s = new SquaresOfSortedArray();
	   int[] newArray = s.sortedSquares(A);
	   
	   printArray(newArray);
	}
}
