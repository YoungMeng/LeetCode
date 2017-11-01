/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int count = 0;
        int i = 0;
        int j = 0;
        int length = s.length();
        while (j < length) {
            char temp = s.charAt(j);
            if (!hm.containsKey(temp)) {
                hm.put(temp, j);
            } else {
                int len = j - i;
                if (len > count) {
                    count = len;
                }
                i = Math.max(i, hm.get(temp) + 1);
                hm.put(temp, j);
            }
            j++;
        }

        if (count < j - i)
            return j - i;
        else
            return count;
    }
}
