package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {
	
	
	 public ArrayList<Integer> slidingMaximumUsingDequeue(final List<Integer> A, int B) {
	        Deque<Integer> window = new LinkedList<Integer>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for (int i = 0; i < A.size(); i++) {
	            int val = A.get(i);
	            // Remove all elements smaller than the current one from the queue
	            while (!window.isEmpty() && val >= A.get(window.getLast())) {
	                window.removeLast();
	            }
	            // Add the current element's index to the queue. It is important that we
	            // store the indicies rather than the values.
	            window.add(i);
	            // The first element of the queue is always the largest. If the index of 
	            // this number is smaller than the window's stating index then we remove it
	            if (window.getFirst() < (i + 1) - B) {
	                window.removeFirst();
	            }
	            // Ignores the first few interations
	            if (i >= B - 1)
	                result.add(A.get(window.getFirst()));
	        }
	        return result;
	    }

	/**
	 *
	 * @param A
	 * @param B
	 * @return
	 */

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (A.isEmpty()) {
			return result;
		}

		// If window size is 1 or greater than list size
		if (B <= 1) {
			return new ArrayList<Integer>(A);
		} else if (B > A.size()) {
			return new ArrayList<Integer>();
		} else {
			// Add the max Value to the First Window
			int max_index = findMaxIndexWithinWindow(A, 0, B - 1);
			result.add(A.get(max_index));

			int totalWindows = A.size() - B + 1;
			for (int windowStartIndex = 1; windowStartIndex < totalWindows; windowStartIndex++) {

				/*
				 * If prevMax Value index fall in the new shifted window then compare with last
				 * value of the new Window
				 */
				if (indexFallInWindow(windowStartIndex, windowStartIndex + B - 1, max_index)) {
					int currentMaxElementOfWindow = A.get(windowStartIndex + B - 1);
					int prevMaxElementOfWindow = result.get(windowStartIndex - 1);
					result.add(Math.max(currentMaxElementOfWindow, prevMaxElementOfWindow));
				} else {
					/*
					 * Else If PrevMax Value index does not fall in the new shifted window. Then
					 * compare value of the entire new window
					 */
					max_index = findMaxIndexWithinWindow(A, windowStartIndex, windowStartIndex + B - 1);
					result.add(A.get(max_index));
				}

			}
			return result;
		}
	}

	public boolean indexFallInWindow(int start, int end, int index) {
		return index >= start && index <= end;
	}

	public int findMaxIndexWithinWindow(final List<Integer> list, int start, int end) {
		int max_index = start;

		for (int i = start + 1; i <= end; i++) {
			if (list.get(i) > list.get(max_index)) {
				max_index = i;
			}
		}

		return max_index;
	}

	public static void main(String args[]) {
		Integer[] arr = { 1, 3, -1, -3, 5, 3, 6, 7};
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(arr));

		int B = 3;
		ArrayList<Integer> result = new SlidingWindow().slidingMaximumUsingDequeue(A, B);
		System.out.println(result.toString());
	}
}