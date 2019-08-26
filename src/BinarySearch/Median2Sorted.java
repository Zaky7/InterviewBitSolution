package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Median2Sorted {

    public double findMedianSortedArrays(final List<Integer> input1, final List<Integer> input2) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.size() > input2.size()) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.size();
        int y = input2.size();

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1.get(partitionX - 1);
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1.get(partitionX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2.get(partitionY - 1);
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2.get(partitionY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }


    public int findMedian(List<Integer> list) {
        int size = list.size();       
        int mid = size / 2;
        if(size % 2 == 0) {
            return (list.get(mid) + list.get(mid-1)) / 2;
        } else {
            return list.get(mid);
        }
    }


    public double computeMedian(int maxLeftX, int maxLeftY, int minRightX, int minRightY, boolean isEven) {
        if(isEven ==  true) {
            return (double) ((Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0);
        } else {
           return (double) Math.max(maxLeftX, maxLeftY);
        }
    }

  
    // public double findMedianSortedArrays(final List<Integer> arr1, final List<Integer> arr2) {
    //     int m = arr1.size();
    //     int n = arr2.size();

    //     // If arr1 is greater than arr2 swap them and call Function Again
    //     if(m > n) {
    //         return findMedianSortedArrays(arr2, arr1);
    //     }

    //     if(m == 0) {
    //         return findMedian(arr2);
    //     } else if(n == 0) {
    //         return findMedian(arr1);
    //     } else {

    //         int start = 0, end = n - 1;
    //         boolean isEven =  ((m + n) % 2) == 0 ? true : false;

    //         while(start <= end) {
    //             int partitionX = (start + end) / 2;
    //             int partitionY = ((m + n + 1) / 2) - partitionX;
    
    //             int maxLeftX  = partitionX == 0 ? Integer.MIN_VALUE : arr1.get(partitionX - 1);
    //             int minRightX = partitionX == m ? Integer.MAX_VALUE : arr1.get(partitionX);
    
    //             int maxLeftY  = partitionY == 0 ? Integer.MIN_VALUE : arr2.get(partitionY - 1);
    //             int minRightY = partitionY == n ? Integer.MAX_VALUE : arr2.get(partitionY);

    //                 // System.out.println("start: " + start + " End: " + end + " partitionX: " + partitionX + " partitionY: " + partitionY + " maxLeftX: " + maxLeftX + " minRightY: " + minRightY + " maxLeftY: " + maxLeftY + " minRightX: " + minRightX);

    //             if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
    //                 return computeMedian(maxLeftX, maxLeftY, minRightX, minRightY, isEven);
    //             } else if(maxLeftX > minRightY) {
    //                 // Move Left
    //                 end = partitionX - 1;
    //             } else {
    //                 start = partitionX + 1;
    //             }
    //         }   
    //     }

    //     throw new IllegalArgumentException();
    // }

    public static void main(String[] args) {
        Integer arr[] = {-43, -25, -18, -15, -10, 9, 39, 40 };
        Integer arr2[] = { -2};

        // -40, -25, 5, 10, 14, 28, 29, 48
        // -48, -31, -15, -6, 1, 8

        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(arr));
        final List<Integer> arrList = list;
        
        List<Integer> list2 = new ArrayList<Integer>();
        list2.addAll(Arrays.asList(arr2));
        final List<Integer> arrList1 = list2;
        
        Median2Sorted m2s = new Median2Sorted();
        System.out.println(arrList.toString());
        System.out.println(arrList1.toString());
        // double ans = m2s.findMedianSortedArrays(arrList, arrList1);
        // System.out.println(ans);

        System.out.println("--- Tushar Roy Answer ---");
        int input1[] = {-43, -25, -18, -15, -10, 9, 39, 40};
        int input2[] = { -2};
        double ans2 = m2s.findMedianSortedArrays(arrList, arrList1);
        System.out.println(ans2);
    }
}