package dp;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
	public void print2DArray(int[][] arr, int n, int W) {
		for(int i=0; i <= n; i++) {
			for(int j=0; j <=W; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
   
	public List<Integer> knapsack(int W, int[] wt, int[] val, int n) {
		
		int[][] dp = new int[n+1][W+1];
		
		System.out.println("Value: " + dp[n][W]);
		
		for(int i=0; i<= n; i++) {
			for(int j=0; j <= W; j++) {
				if(j == 0 || i == 0) {
					continue;
				}
				
				if(wt[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], wt[i-1] + dp[i-1][j - wt[i-1]]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		
		print2DArray(dp, n, W);
		return traceOutListFrom2DArray(dp, wt, val, W);
	}
	
	
	public List<Integer> traceOutListFrom2DArray(int[][] dp, int[] wt, int[] val, int W) {
		int i = wt.length;
		int j = W;
		List<Integer> result = new ArrayList<Integer>();
		int sum = 0;
		
		while(i != 0) {
			if(dp[i][j] > dp[i-1][j]) {
				result.add(wt[i-1]);
				sum += val[i-1];
				j = j - wt[i-1];
			}
			i--;
		}
		
		System.out.println(sum);
		System.out.println(result.toString());
		
		return result;
	}
	
	public static void main(String args[]) {
		int[] wt  = {10, 20, 30};
		int[] val = {60, 100, 120};
		int W = 50;
		int n = wt.length;
		
		Knapsack kp = new Knapsack();
		
		kp.knapsack(W, wt, val, n);
	}
}
