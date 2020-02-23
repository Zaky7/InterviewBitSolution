package string;

public class PallindromeSubString {

	public String longestPalindrome(String s) {

		int n = s.length();
		int STRING_MAX_LEN = Integer.MIN_VALUE;
		String maxlen_substring = Character.toString(s.charAt(0));
		
		// Find all the substring and check if pallindrome
		for (int size = n-1; size >= 0; size--) {
			for (int start = 0; start < n; start++) {
//				System.out.println("Start: " + start + " Size: " + size);
				if (size + start > n) {
					break;
				}

				StringBuilder sb = new StringBuilder();
				for (int k = start; k <= size; k++) {
					sb.append(s.charAt(k));
				}

				String subString = sb.toString();
//				System.out.println("String: " + subString);
				if (isPallindrome(subString)) {
					System.out.println("Pallindrome String: " + subString);
					if (subString.length() > STRING_MAX_LEN) {
						maxlen_substring = subString;
						STRING_MAX_LEN = maxlen_substring.length();
					}
				}
			}

		}
		
		return maxlen_substring;
	}

	public boolean isPallindrome(String str) {
		char[] chArray = str.toCharArray();
		int n = str.length();
		int i = 0, j = n - 1;
		boolean pallindrome = true;

		while (i < j) {
			if (chArray[i] != chArray[j]) {
				pallindrome = false;
				break;
			}
			i++;
			j--;
		}

		return pallindrome;
	}

	public static void main(String args[]) {
		PallindromeSubString psb = new PallindromeSubString();
		
		System.out.println(psb.longestPalindrome("babaabc"));
	}
}
