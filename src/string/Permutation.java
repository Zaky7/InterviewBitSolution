package string;

import java.util.ArrayList;

public class Permutation {


    public static void findPermutation(String str, int start, int end, ArrayList<String> result) {
        if(start > end) {
            result.add(str);
            return;
        }

        for(int i=start; i<=end; i++) {
            str = swap(str, start, i);
            findPermutation(str, start+1, end, result);
            // Back track the Result
            str = swap(str, start, i);
        }
    }


    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }


   public static void main(String args[]) {
       String str = "123";
//       System.out.println(str = swap(str, 0, 2));
//       System.out.println(str);
       ArrayList<String> result = new ArrayList<>();
       findPermutation(str, 0, str.length() -1, result);

       for(String s: result) {
           System.out.println(s);
       }
   }
}
