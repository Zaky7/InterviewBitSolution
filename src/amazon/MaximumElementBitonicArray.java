package amazon;

public class MaximumElementBitonicArray {

	public static int maximumElementFromBitonicArray(int[] arr) {
		int low = 0, end = arr.length - 1;

		while(low <= end) {
			int mid = (low + end) / 2;
			// Range Check
			if(mid < 0 || mid > end) {
				continue;
			}

			// Found the Peak Point
			if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
				return arr[mid];
			} else if(arr[mid - 1] <= arr[mid] && arr[mid] <= arr[mid + 1]) {
				// Increasing Subsequence move to the Right
				low = mid + 1;
			} else if(arr[mid - 1] >= arr[mid] && arr[mid] >= arr[mid + 1]) {
				// Decreasing Subsequence move to the Left
				end = mid - 1;
			}
		}

		return -1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 6, 5, 4, 3, 2, 1};
		System.out.println("Ans" + maximumElementFromBitonicArray(arr));

	}

}
