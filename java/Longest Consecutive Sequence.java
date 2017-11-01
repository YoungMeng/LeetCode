/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        for (int n : nums)
            used.put(n, false);

        int longest = 0;

        for (int i : nums) {
            if (used.get(i)) continue;

            int length = 1;
            used.put(i, true);

            for (int j = i + 1; used.containsKey(j); j++) {
                used.put(j, true);
                length++;
            }
            for (int j = i - 1; used.containsKey(j); j--) {
                used.put(j, true);
                length++;
            }

            longest = Integer.max(longest, length);
        }

        return longest;
    }
}
