package array;

import java.util.Scanner;

public class PallindromePairs {

    public static boolean isPallindrome(String str) {
        int len = str.length(); 
        str = str.toLowerCase();

        if(len < 1) {
            return false;
        }
        
        int start = 0;
        int end = len - 1;
        
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }


    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        

        String testString = "abav";

        System.out.println("You Entered String: " + testString);

        boolean isPallindrome = isPallindrome(testString);

        System.out.println("IsPallindrome : " + isPallindrome);

        sc.close();
    }
}