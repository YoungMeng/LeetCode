public class Solution {
    public int reverse(int x) {
        if (x == -2147483648)
            return 0;

        int ori = Math.abs(x);
        long res = 0;

        while (ori != 0) {
            int remainder = ori % 10;
            res = res * 10 + remainder;
            ori /= 10;
        }

        if (res > 0x7fffffff || -res < 0x80000000)
            return 0;

        if (x < 0)
            return (int) -res;
        return (int) res;
    }
}
