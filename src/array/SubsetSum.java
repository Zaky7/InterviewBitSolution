package array;

public class SubsetSum {
	
	public boolean subsetSum(int input[], int total) {
        boolean T[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }
        
//        print2DArray(T);
        
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        
        
        print2DArray(T);
        return T[input.length][total];

    }
	
	
	public static void print2DArray(boolean[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		
		for(int i=0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		int[] input = {2, 3, 7, 8};
		SubsetSum ss = new SubsetSum();
		boolean subsetExist = ss.subsetSum(input, 7);
		System.out.println("SubsetSum Exist: " + subsetExist);
	}
}
