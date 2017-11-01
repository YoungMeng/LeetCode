/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/*
 * 第一种解法：用大小为 32的数组来记录所有 位上的和。
 *
 * 考虑全部用二进制表示，如果我们把 第i个位置上所有数字的和对3取余，
 * 那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0). 
 * 因此取余的结果就是那个 “Single Number”.
 */

public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) != 0)
                    count[i]++;
            }
            ret |= (count[i] % 3) << i;
        }
        return ret;
    }
}

/*
 * 第二种解法
 *
 * ones：代表第ith 位只出现一次的掩码变量
 * twos：代表第ith 位只出现两次的掩码变量
 * threes：代表第ith 位只出现三次的掩码变量
 * 当第 i 位出现3次时，我们就 ones  和 twos  的第 i 位设置为0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i++) {
            twos |= (ones & nums[i]);
            ones ^= nums[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
