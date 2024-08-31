public class Solution {
    
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        
        System.out.println("Longest Palindromic Substring of \"" + s1 + "\": " + longestPalindrome(s1));
        System.out.println("Longest Palindromic Substring of \"" + s2 + "\": " + longestPalindrome(s2));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = expandAroundCenter(s, i, i);
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
