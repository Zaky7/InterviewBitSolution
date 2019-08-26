package Math;

import java.util.ArrayList;


public class NumLessThanK {

    public boolean zeroPresent(ArrayList<Integer> A, int num) {
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == num) {
                return true;
            }
        }
        return false;
    }

    public int calculate(ArrayList<Integer> A, ArrayList<Integer> number, int index, int B) {
        if (index == B) {
            return 0;
        }
        int lessthan = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < number.get(index)) {
                if (A.get(i) == 0 && index == 0 && B > 1)
                    lessthan--;
                lessthan++;
            }
        }
        int result = lessthan * ((int) Math.pow(A.size(), B - index - 1));
        boolean isPresent = zeroPresent(A, number.get(index));
        if (isPresent) {
            result = result + (calculate(A, number, index + 1, B));
        }
        return result;
    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> number = new ArrayList<Integer>();
        while (C != 0) {
            number.add(0, C % 10);
            C /= 10;
        }
        if (number.size() < B) {
            return 0;
        } else if (number.size() > B) {
            boolean isZero = zeroPresent(A, 0);
            if (isZero && B > 1) {
                return (A.size() - 1) * ((int) Math.pow(A.size(), B - 1));
            } else {
                return (int) Math.pow(A.size(), B);
            }
        } else {
            return calculate(A, number, 0, B);
        }
    }

    public static void main(String args[]) {
        Integer[] arr = { 1, 4, 7, 8 };
        ArrayList<Integer> A = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            A.add(arr[i]);
        }

        
        NumLessThanK nk = new NumLessThanK();
        int ans = nk.solve(A, 3, 275);
        System.out.print(ans);
    }
}
