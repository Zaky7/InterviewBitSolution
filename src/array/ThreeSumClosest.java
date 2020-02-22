package array;

public class ThreeSumClosest {
		
	
	public int threeSumClosest(int[] nums, int target) {
        
	    int n = nums.length;
	    int closest_sum = Integer.MAX_VALUE;
	    
	    for(int i=0; i<n-2; i++) {
	    	int sum1 = nums[i];
	    	for(int j=i+1; j<n-1; j++) {
	    		int sum2 = nums[j];
	    		for(int k=j+1; k<n; k++) {
	    			int sum3 = nums[k];
	    			int current_sum = sum1 + sum2 + sum3;
	    			System.out.println("Nums[i]: "+ nums[i] + " Nums[j]: " + nums[j] + " Nums[k]: " + nums[k] + " Current Sum: " + current_sum);
	    			
	    			int diff_from_closest_sum = Math.abs((target - closest_sum));
	    			int diff_from_current_sum = Math.abs((target - current_sum));
	    			
	    			if(diff_from_current_sum < diff_from_closest_sum) 	{
	    				closest_sum = current_sum;
	    			}
	    		}
	    	}
	    }
	    
	    return closest_sum;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();

		ThreeSumClosest tc = new ThreeSumClosest();
		int closest_sum = tc.threeSumClosest(nums, 1);
		System.out.println("Closest Sum: " + closest_sum);
	}
}
