package string;

public class LongestPalindromeSubstring {

    public static String longestPalindrome(String str) {
        int n = str.length();
        boolean[][] table = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // All the single Letter Substrings are Palindrome
        for (int i = 0; i < n; ++i) {
            table[i][i] = true;
        }

        // Substring of size 2
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // Substrings of size > 2
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (maxLen < k) {
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }

        return str.substring(start, (start + maxLen));
    }

    public static void main(String[] args) {
        String str = "caba";
        longestPalindrome(str);
    }
}