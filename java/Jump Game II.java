/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */

public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int last = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = cur;
                step++;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return step;
    }
}
