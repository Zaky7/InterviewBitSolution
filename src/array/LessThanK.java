package array;

public class LessThanK {

	 public int largestSumLessThanK(int[] arr, int K) {
	        int sum =0;
	        int n = arr.length;
	        int ptr1=0, ptr2=n-1;

	        if(K < arr[0]) {
	            return sum;
	        } else {

	            sum = arr[ptr1] + arr[ptr2];

	            while(ptr1 < ptr2 && sum > K) {
	                if(sum >= K) {
	                    ptr2--;
	                } else {
	                    ptr1++;
	                }
	                sum = arr[ptr1] + arr[ptr2]; 
	            }


	            if(ptr1 < n && ptr2 < n && arr[ptr1+1] + arr[ptr2] < K) {
	                while(ptr1 < ptr2 && sum > K) {
	                    sum = arr[ptr1] + arr[ptr2];
	                    if(sum >= K) {
	                        ptr2--;
	                    } else {
	                        ptr1++;
	                    } 
	                }
	            }
	        }
	  
	        return sum;
	    }


	    public static void main(String args[]) {

	        LessThanK lk = new LessThanK();
	        int[] arr = {5, 10, 20, 100, 110};
	        int K = 85;
	        System.out.println(lk.largestSumLessThanK(arr, K));
	    }

}
