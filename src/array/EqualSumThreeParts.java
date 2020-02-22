package array;

public class EqualSumThreeParts {
	
	
	public boolean canThreePartsEqualSum(int[] A) {
		int n = A.length;
		
		// If Length of Array is less than 3 no split Possible
		if(n < 3) {
			return false;
		}
		
		int total_sum = 0;	
		for(int i=0; i<n; i++) {
			total_sum += A[i];
		}
		
		System.out.println("Total Sum: " + total_sum);

		// If total sum of element of Array is not divisible by 3
		if((total_sum % 3) != 0) {
			return false;
		}
			
		int sum1;
		int sum2;
		int sum3;
		
		for(int p1=0; p1 < n-2; p1++) {
			for(int p2 =p1+1; p2 < n-1; p2++) {
				for(int p3 =p2+1; p3 < n; p3++) {
					
					sum1=0;
					for(int i=p1; i<p2; i++) {
						sum1+= A[i];
					}
					
					sum2=0;
					for(int j=p2; j<p3; j++) {
						sum2+=A[j];
					}
					
					sum3=0;
					for(int k=p3; k<n; k++) {
						sum3+=A[k];
					}
					
					System.out.println("P1: " + p1 + " P2: " + p2 + " P3: " + p3 + " Sum1: " + sum1 + " Sum2: " + sum2 + " Sum3: " + sum3);
					
					if(sum1 == sum2 && sum2 == sum3) {
						return true;
					}
				}
			}
		}		
		
		return false;
    }
	
	
	public boolean canThreePartsEqualSumEfficient(int[] A) {
		int n = A.length;
		int total_sum = 0;
		
		for(int i=0; i<n; i++)
			total_sum += A[i];
		
		System.out.println("Total Sum: " + total_sum);
		
		
		if((total_sum % 3) != 0) {
			return false;
		}
		
		int preSum = 0;
		int index1 = -1, index2= -1;
		int S1 = total_sum / 3;
		int S2 = 2*S1;
		
		
		for(int i=0; i<n; i++) {
			preSum += A[i];
			
			System.out.println("PreSum: " + preSum + " S1: " + S1 + " S2: " + S2);
			
			if(preSum == S1 && index1 == -1) {
				index1 = i;	
				preSum = 0;
			} else if(preSum == S2 && index1 != -1) {
				index2 = i;
				break;
			}
			
		}
		
		
		if(index1 != -1 && index2 != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String args[]) {
		int[] arr = {29,31,27,-10,-67,22,15,-1,-16,-29,59,-18,48};
//		int[] arr = {0,2,1,-6,6,7,9,-1,2,0,1};
		
		EqualSumThreeParts eq = new EqualSumThreeParts();
		boolean equalSumExist = eq.canThreePartsEqualSumEfficient(arr);
		System.out.println("Efficient: " + equalSumExist);
		
//		boolean equalSumExist2 = eq.canThreePartsEqualSum(arr);
//		System.out.println("Normal: " + equalSumExist2);
	}
}
