package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumGap {

    public int maximumGap(final List<Integer> A) {
        int n = A.size();

        // Corner cases
        if(n < 2) {
            return 0;
        }

        int max = Integer.MIN_VALUE, min= Integer.MAX_VALUE;

        // Find the Max and Min Value among the Array
        for(int i=0; i<n; i++) {
            int ele = A.get(i);
            if(ele < min) {
                min = ele;
            }

            if(ele > max) {
                max = ele;
            }
        }


        // Create two buckets with max and min values
        // Initialize the buckets as follows
        // bucket_min with Integer.MAX_VALUE and
        // bucket_max with Integer.MIN_VALUE
        int[] bucket_min = new int[n-1];
        int[] bucket_max = new int[n-1];

        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        Arrays.fill(bucket_min, Integer.MAX_VALUE);



        // Delta which is gap if we divide elements on the basis
        // of the Range
        float delta = (float) (max - min) / (n-1);


        // Since elements are not strictly incrementing
        // There would be gap created when we fill the elements on
        // the basis of the Range
        // Now as you get the hole subtract the min of bucket after hole and max of bucket before hole
        for(int i=0; i<n; i++) {
            if(A.get(i) == max || A.get(i) == min) {
                continue;
            }

            int element = A.get(i);
            int index = (int) Math.floor(((element - min) / delta));

            System.out.println("Element: " + element + " index: " + index);

            bucket_max[index] = bucket_max[index] == Integer.MIN_VALUE ? element : Math.max(element, bucket_max[index]);
            bucket_min[index] = bucket_min[index] == Integer.MAX_VALUE ? element : Math.min(element, bucket_min[index]);
        }


        int prev = min;
        int maxGap = 0;

        for(int i=0; i<n-1; i++) {
            if(bucket_min[i] == Integer.MAX_VALUE) {
                continue;
            }

            maxGap = Math.max(maxGap, bucket_min[i] - prev);
            prev = bucket_max[i];
        }


        maxGap = Math.max(maxGap, max-prev);
        printArr(bucket_max);
        printArr(bucket_min);
        return maxGap;

    }


    public void printArr(int[] arr) {
        int n = arr.length;
        System.out.println();

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }


    public int maximumGapNew(final List<Integer> A) {
        int N = A.size();
        
        // Find the min and max Element from the Array
        int MIN_VALUE = Integer.MAX_VALUE;
        int MAX_VALUE = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            if(A.get(i) < MIN_VALUE) {
                MIN_VALUE = A.get(i);
            }
            if(A.get(i) > MAX_VALUE) {
                MAX_VALUE = A.get(i);
            }
        }
        System.out.println("Max: " + MAX_VALUE + " Min: " + MIN_VALUE);

        int[] bucket_min = new int[N-1];
        int[] bucket_max = new int[N-1];
        int gap = (int) Math.ceil((MAX_VALUE - MIN_VALUE) / (N-1));
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        Arrays.fill(bucket_min, Integer.MAX_VALUE);

        System.out.println("Gap: " + gap);

        for(int i=0; i<N; i++) {
            int ele = A.get(i);
            int bucket_index = (int) Math.ceil((ele - MIN_VALUE) / gap);
            bucket_index = bucket_index > 0 ? bucket_index - 1 : bucket_index;

            System.out.println("Ele: " + ele + " Index: " + bucket_index);

            if(ele > bucket_max[bucket_index]) {
                bucket_max[bucket_index] = ele;
            }

            if(ele < bucket_min[bucket_index]) {
                bucket_min[bucket_index] = ele;
            }
        }

        printArr(bucket_min);
        printArr(bucket_max);

        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 7, 13, 2, 4, 1, 6};
        // MaxConsGap.java

        final List<Integer> A = new ArrayList<Integer>(Arrays.asList(arr));

//        for(Integer a: A) {
//            System.out.println(a);
//        }

        MaximumGap mg = new MaximumGap();

        // System.out.println(mg.maximumGapNew(A));
        double val = (4 - 1) / 2;
        System.out.println(val);
    }
}


