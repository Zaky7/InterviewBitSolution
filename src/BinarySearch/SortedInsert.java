package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

class SortedInsert {


    public int searchInsert(ArrayList<Integer> nums, int target) {
        int n = nums.size();
        int start = 0, end = n -1;
        int ans = 0;
            
        while(start <= end) {
            int mid = ((start + end) / 2);
                
            if(nums.get(mid) == target) {
                ans = mid;
                break;
            }
            // Target value is greater than Mid Value
            // We should move to right
            else if(nums.get(mid)  < target) {
                if((mid + 1) < n) {
                     int nextElement = nums.get(mid+ 1);
                     if(target < nextElement) {
                          ans = mid + 1;
                          break;
                     } else {
                         // Move Right
                         start = mid + 1;
                     }
                } else {
                    // Reach the End of The Array
                    // return lastIndex + 1
                    ans = end + 1;
                    break;
                }
            }
            // Target value is smaller than MId Value
            // We should move to right
            else if(target < nums.get(mid)) {
                if((mid - 1)  >= 0) {
                     int prevElement = nums.get(mid - 1);
                     if((prevElement < target)) {
                         ans = mid;
                         break;
                     } else {
                         // Move Left
                         end = mid - 1;
                     }
                } else {
                    // Reach the starting Index;
                    ans = 0;
                    break;
                }
            }            
        }
    
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5};
        int target = 4;

        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.addAll(Arrays.asList(arr));
        SortedInsert si = new SortedInsert();
        int ans = si.searchInsert(nums, target);

        System.out.println("Ans: " + ans);
    }
}