package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetWithGivenSum {


    public void subsetUtil(
            ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> dummy,
            ArrayList<Integer> arr,
            int start,
            int end,
            int currentSum,
            int expectedSum) {

        System.out.println("Start: " + start + " Dummy: " + dummy.toString() + " currentSum: " + currentSum);


        if(currentSum == expectedSum && !dummy.isEmpty()){
            result.add(new ArrayList<>(dummy));
            return;
        }


        while(start <= end) {
            dummy.add(arr.get(start));
            currentSum += arr.get(start);
            subsetUtil(result, dummy, arr, start+1, end, currentSum, expectedSum);
            start++;
            currentSum -= dummy.get(dummy.size() -1);
            dummy.remove(dummy.size() - 1);

        }
    }



    public ArrayList<ArrayList<Integer>> subsetWithGiveSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> dummy = new ArrayList<Integer>();
        subsetUtil(result, dummy, arr, 0, arr.size()-1, 0, sum);
        return result;
    }


    public static void main(String[] args) {
        Integer[] arr = {1, -4, 2, 3, -2};
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));

        SubsetWithGivenSum ssgs = new SubsetWithGivenSum();

        ArrayList<ArrayList<Integer>> result = ssgs.subsetWithGiveSum(list, 0);


        for(ArrayList<Integer> innerList: result) {
            for(Integer a: innerList) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
