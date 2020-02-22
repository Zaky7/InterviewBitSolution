package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        List<Integer> singleSet = new ArrayList<Integer>();
        Arrays.sort(nums);
        threeSumUtil(nums, singleSet, subsets, 0);
        return subsets;
    }
	
	
	public void threeSumUtil(int[] nums, 
			List<Integer> singleSet, 
			List<List<Integer>> subsets, int index) {
		
		if(singleSet.size() == 3) {
			int sum = singleSet.get(0) + singleSet.get(1) + singleSet.get(2);
			if(sum == 0) {
			  if(!subsets.contains(singleSet))
				subsets.add(new ArrayList<>(singleSet));
			}
		}


		for(int i=index; i < nums.length; i++) {
			singleSet.add(nums[i]);
			threeSumUtil(nums, singleSet, subsets, i + 1);
			singleSet.remove(singleSet.size() - 1);
		}
	}
	
	
	public int binarySearchRecursive(int[] arr, int start, int end, int search_item) {
		// Base cases handle
		if(start < 0 || start > end) {
		   return -1;
		}
		
		int midIndex = ((start + end) / 2);
		
		if(arr[midIndex] == search_item) {
			return midIndex;
		} else if(arr[midIndex] < search_item) {
			return binarySearchRecursive(arr, midIndex+1, end, search_item);
		} else {
			return binarySearchRecursive(arr, start, midIndex-1, search_item);
		}
	}
	
	
	public List<List<Integer>> threeSumUsingTwoPointer(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int n = nums.length;
		
		for(int i=0; i<n - 1; i++) {
			for(int j=i+1; j < n; j++) {
				int sum = nums[i] + nums[j];
				sum = -sum;

				int[] slicedArray = Arrays.copyOfRange(nums, j+1, n); 
				
				System.out.print("Sliced Array: ");
				for(int k=0; k< slicedArray.length; k++)
					System.out.print(slicedArray[k] +  " ");
				
				System.out.print(" Search Item: " + sum);

				

				int foundIndex = binarySearchRecursive(slicedArray, 0, slicedArray.length - 1, sum);
				
				System.out.print(" Found: " + foundIndex);
				System.out.println();
				
				if(foundIndex != -1) {
					List<Integer> singleSet = new ArrayList<Integer>();
					singleSet.add(nums[i]);
					singleSet.add(nums[j]);
					singleSet.add(nums[foundIndex + (j + 1)]);
				  if(!subsets.contains(singleSet))
					subsets.add(singleSet);
				}
			}
		}
		
		
		return subsets;
	}
	
	
	public List<List<Integer>> threeSumUsingHashSet(int[] nums) {
		int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		
		for(int i=0; i< n -1; i++) {
            HashSet<Integer> s = new HashSet<Integer>(); 
			for(int j=i+1; j<n; j++) {
				int sum = -(nums[i] + nums[j]);	
				
				System.out.print("arr[i]: " + nums[i] + " arr[j]: " + nums[j]);
				
				if(s.contains(sum)) {
				   List<Integer> singleSet = new ArrayList<Integer>();
				   singleSet.add(nums[i]);
				   singleSet.add(nums[j]);
				   singleSet.add(sum);

				   if(!subsets.contains(singleSet)) {
					   subsets.add(singleSet);
				   }
				} else {
				   s.add(nums[j]);
				}
				
				System.out.println(" sum: " + sum + " HashSet: " + s.toString());
			}
		}
		
		return subsets;
	}
	
	public static void main(String args[]) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> result = ts.threeSumUsingHashSet(arr);
		System.out.println(result.toString());
		
	}

}
