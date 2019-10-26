package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;   

public class FirstMissingInteger {
    
    public int firstMissingPositive(ArrayList<Integer> list) {
        int N = list.size();
        int missingInteger = 0;
        boolean debug = false;

        if(N == 1) {
            int firstElement = list.get(0);
            if(firstElement == 1) {
                return firstElement + 1;
            } else {
                return 1;
            }
        }

        for(int currentIndex = 0; currentIndex < N; currentIndex++) {
            int bucketIndex = findBucketIndex(list.get(currentIndex), N);
            sout("Outer: CurrentIndex: " + currentIndex + " Value: " + list.get(currentIndex) + " bucketIndex: " + bucketIndex, debug);
            // Number out of range 1 to N; set as 0
            if(bucketIndex == -1) {
                list.set(currentIndex, 0);
                continue;
            } else if(bucketIndex == currentIndex) {
                continue;
            } else if(list.get(bucketIndex) == list.get(currentIndex)){
                list.set(currentIndex, 0);
                continue;
            }
            else {
                while(currentIndex != bucketIndex && bucketIndex != -1) {
                    Collections.swap(list, currentIndex, bucketIndex);
                    bucketIndex = findBucketIndex(list.get(currentIndex), N);
                    sout("Inner: CurrentIndex: " + currentIndex + " Value: " + list.get(currentIndex) + " bucketIndex: " + bucketIndex, debug);
                
                   
                }
                if(bucketIndex == -1) {
                    list.set(currentIndex, 0);
                }
           }
        }

        
        for(int i=0; i<N; i++) {
            if(list.get(i) == 0) {
                missingInteger = i+1;
                return missingInteger;
            }
        }
        return N + 1;
    }

    public int findBucketIndex(int num, int N) {
        if(num >= 1 && num <= N) {
            return num - 1;
        } else {
            return -1;
        }
    }

    public void printList(ArrayList<Integer> list) {
        System.out.println();
        for(Integer a: list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] test1 = {-4, -7, 4, 3, 2 ,1 , 6}; // Ans 5
        Integer[] test2 = {1, 2, 3, 4 ,5}; // Ans 6
        Integer[] test3 = {1, 1, 1}; // Ans 2
        Integer[] test4 = {1}; // Ans 2

        Integer[][] testSuite = {test1, test2, test3, test4};
        FirstMissingInteger fmp = new FirstMissingInteger();

        for(int i=0; i< testSuite.length; i++) {
            Integer[] arr = testSuite[i];
            ArrayList<Integer>  list = new ArrayList<Integer>();
            list.addAll(Arrays.asList(arr));
            int missingInteger = fmp.firstMissingPositive(list);
            System.out.println("MissingInteger: " + missingInteger);
            fmp.printList(list);
        }
    }

    public static void sout(Object msg, boolean debug) {
        if(debug == true) {
            System.out.println(msg.toString());
        }
    }
}