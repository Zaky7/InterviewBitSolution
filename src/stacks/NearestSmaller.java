package stacks;

import java.util.ArrayList;
import java.util.Arrays;

public class NearestSmaller {

	public static void main(String args[]) {
		Integer[] arr = { 8, 23, 22, 16, 22, 7, 7, 27, 35, 27 };
		// Integer[] arr = {};

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(arr));

		ArrayList<Integer> result = new NearestSmaller().prevSmaller(A);
		System.out.println(result.toString());
	}

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		ArrayList<Integer> prevSmallerArr = new ArrayList<Integer>();

		// push -1 since element smaller than first element is -1
		if (!A.isEmpty())
			prevSmallerArr.add(-1);

		for (int i = 1, size = A.size(); i < size; i++) {
			if (A.get(i - 1) < A.get(i)) {
				prevSmallerArr.add(A.get(i - 1));
			} else {
				int j = i - 1;

				/*
				 * Iterate until you find element in prevSmaller array smaller than current
				 * element in A
				 */
				while (j >= 0 && prevSmallerArr.get(j) >= A.get(i)) {
					j--;
				}

				// Reached the end of the List no match Found
				if (j < 0) {
					prevSmallerArr.add(-1);
				} else {
					prevSmallerArr.add(prevSmallerArr.get(j));
				}
			}
		}

		return prevSmallerArr;
	}
}
