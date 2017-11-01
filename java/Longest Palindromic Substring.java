public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return null;

        int length = s.length();
        String res = "";
        for (int i = 0; i < length; i++) {
            /*回文字符串为奇数*/
            String palindrome = getPalindrome(s, i, i);
            if (palindrome.length() > res.length()) {
                res = palindrome;
            }
            
            /*回文字符串为偶数*/
            palindrome = getPalindrome(s, i, i + 1);
            if (palindrome.length() > res.length()) {
                res = palindrome;
            }
        }

        return res;
    }

    public String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
