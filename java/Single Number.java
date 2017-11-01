/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class Solution {
    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }

        return ret;
    }
}
