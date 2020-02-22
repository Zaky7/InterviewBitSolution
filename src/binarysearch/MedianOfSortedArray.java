package binarysearch;

public class MedianOfSortedArray {
	
	public static double max(int a, int b) {
		return Math.max(a, b);
	}
	
	public static double min(int a, int b) {
		return Math.min(a, b);
	}
	
	public static double avg(double a, double b) {
		return (a + b) / 2;
	}
	
	public double medianOfSortedArr(int[] arr1, int[] arr2) {
		int x = arr1.length;
		int y = arr2.length;
		double median = 0;
		
		
		if(x > y) {
			return medianOfSortedArr(arr2, arr1);
		}
		
		int start = 0;
		int end = x - 1;
		
		while(start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY  = ((x + y + 1) / 2) - partitionX;
			
			int maxLeftX = arr1[partitionX - 1];
			int minRightX = arr1[partitionX];
			int maxLeftY = arr2[partitionY - 1];
			int minRightY = arr2[partitionY];
			
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// Found
				if((x + y) % 2 == 0) {
					return (double) avg(max(maxLeftX, maxLeftY), max(minRightX, minRightY));
				} else {
					return (double) max(maxLeftX, maxLeftY);
				}
			} else if(maxLeftX > minRightY) {
				// Move left
			    end = partitionX - 1;
			} else {
				// Move right
				start = partitionX + 1;
			}
		}

		throw new IllegalArgumentException();
	}
	
	
	public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        MedianOfSortedArray mm = new MedianOfSortedArray();
        System.out.println(mm.medianOfSortedArr(x, y));
	}
}
