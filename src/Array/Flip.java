package Array;

import java.util.ArrayList;

public class Flip {


    public ArrayList<Integer> flip(String str) {
        char[] charArr = str.toCharArray();
        int n = str.length();
        int once = 0;
        int maximumOnce = n;
        ArrayList<Integer> result = new ArrayList<Integer>();

        int currentMaximumOnce = 0;

        for (int i = 0; i < n; i++) {
            if (charArr[i] == '1') {
                ++once;
            }
        }


        System.out.println("Total number of initial once " + once + " and n: " + n);
        // All digits are 1
        if (once == n) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currentOnce = once;

                for (int k = i; k <= j; k++) {
                    if (charArr[k] == '0') {
                        ++currentOnce;
                    } else {
                        --currentOnce;
                    }
                }

                // Maximum Value reached then break the loop
                // System.out.println("CurrentOnce: " + currentOnce + " Range (" + i + "," + j + ") ");
                if (currentOnce == maximumOnce) {
                    result = new ArrayList<Integer>();
                    result.add(i + 1);
                    result.add(j + 1);
                    return result;
                } else {
                    // If list empty add the current Range and upgrade onceCount
                    if (result.isEmpty()) {
                        result.add(i + 1);
                        result.add(j + 1);
                        currentMaximumOnce = currentOnce;
                    } else {
                        // Add lexiographically Smaller Range if count is equal
                        if (currentOnce == currentMaximumOnce) {
                            if (isLexioGraphicallySmaller(result, i, j)) {
                                result.set(0, i + 1);
                                result.set(1, j + 1);
                                currentMaximumOnce = currentOnce;
                            }
                        } else if (currentOnce > currentMaximumOnce) {
                            result.set(0, i+1);
                            result.set(1, j+1);
                            currentMaximumOnce = currentOnce;
                        }
                    }
                }
            }
        }

        return result;
    }

    public boolean isLexioGraphicallySmaller(ArrayList<Integer> result, int i, int j) {
        i = i + 1;
        j = j + 1;

        if (i < result.get(0)) {
            return true;
        } else if (i == result.get(0)) {
            if (j < result.get(1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    
    public int getNormalizedValue(char ch) {
        return ch == '0' ? 1: -1;
    }

    public ArrayList<Integer> flipFaster(String str) {
        char[] charArr = str.toCharArray();
        int n = str.length();
        ArrayList<Integer> result = new ArrayList<Integer>();

        int maxSum = Integer.MIN_VALUE;
        int cumulative = 0, left=0, leftAns=0,
        rightAns=0;

        for(int i = 0; i < n; i++) {
            int val = getNormalizedValue(charArr[i]);
            cumulative += val;

            // System.out.println("i: " + i + " Cumulative: " + cumulative + " leftAns: " + leftAns + " rightAns: " + rightAns + " maxSum: " + maxSum);

            if(cumulative < 0) {
                left = i+1;
                cumulative = 0;
            } else if(cumulative > maxSum) {
                leftAns = left;
                rightAns = i;
                maxSum = cumulative;
            }
        }

        if(maxSum < 0) {
            return result;
        } else {
            result.add(leftAns + 1);
            result.add(rightAns + 1);
            return result;
        }

    }

    public static void main(String[] args) {
        String binaryString = "0101001010101101100110";
        Flip fp = new Flip();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        long start = System.currentTimeMillis();
        result = fp.flip(binaryString);
        for (Integer a : result) {
            System.out.print(a + " ");
        }
        System.out.println();

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time for Slower Flip: " + (timeElapsed));


        start = System.currentTimeMillis();
        result = fp.flipFaster(binaryString);
        for (Integer a : result) {
            System.out.print(a + " ");
        }
        System.out.println();


        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Time for Faster Flip: " + (timeElapsed));


    }
}
