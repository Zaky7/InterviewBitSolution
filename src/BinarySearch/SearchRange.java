
package BinarySearch;

import java.util.List;
import java.util.ArrayList;

class SearchRange {

    public static int binarySearch(List<Integer> arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) < target) {
                // Move Right
                start = mid + 1;
            } else {
                // Move Left
                end = mid - 1;
            }
        }

        return -1;
    }

    public static ArrayList<Integer> rangeSearch(final List<Integer> arr, int target) {
        int firstOccur = binarySearch(arr, 0, arr.size() - 1, target);
        int leftMostOccurance = -1, rightMostOccurance = -1;
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (firstOccur == -1) {
            result.add(leftMostOccurance);
            result.add(rightMostOccurance);
            return result;
        } else {

            // Find the leftmost occurance of Target
            int leftOccur = firstOccur;
            int prevOccur = leftOccur;
            if (firstOccur > 0 && arr.get(firstOccur - 1) != target) {
                leftMostOccurance = firstOccur;
            } else {
                while (leftOccur != -1) {
                    prevOccur = leftOccur;
                    leftOccur = binarySearch(arr, 0, leftOccur - 1, target);
                }
                leftMostOccurance = prevOccur;
            }

            // Find the rightmost occurance of Target
            int rightOccur = firstOccur;
            int prevRightOccur = rightOccur;
            int n = arr.size();
            if (firstOccur < n-1 && arr.get(firstOccur + 1) != target) {
                rightMostOccurance = firstOccur;
            } else {
                while (rightOccur != -1) {
                    prevRightOccur = rightOccur;
                    rightOccur = binarySearch(arr, rightOccur + 1, n - 1, target);
                }

                rightMostOccurance = prevRightOccur;
            }

            result.add(leftMostOccurance);
            result.add(rightMostOccurance);
            return result;
        }
    }

    public static void main(String[] args) {
        Integer arr[] = { 5, 7, 7, 8, 8, 9};
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0, n = arr.length; i < n; i++) {
            list.add(arr[i]);
        }
        System.out.println(list.toString());

        ArrayList<Integer> result = rangeSearch(list, 9);

        System.out.println("Ans: " + result.toString());

    }

}