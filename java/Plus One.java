/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * 给定一个十进制数，用数组表示每一位，要求返回加一后的结果
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + add;
            digits[i] = sum % 10;
            add = sum / 10;
            if (add == 0)
                return digits;
        }

        int[] ret = new int[digits.length + 1];
        ret[0] = add;
        for (int j = 0; j < digits.length; j++) {
            ret[j + 1] = digits[j];
        }

        return ret;
    }
}
