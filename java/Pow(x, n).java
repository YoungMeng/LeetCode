/**
 * Implement pow(x, n).
 */

public class Solution {
    public double myPow(double x, int n) {
        return n < 0 ? 1 / powHelper(x, -n) : powHelper(x, n);
    }

    private double powHelper(double x, int n) {
        if (n == 0)
            return 1;

        int m = n / 2;
        double val = powHelper(x, m);
        if (n % 2 != 0) {
            val = val * val * x;
        } else {
            val = val * val;
        }
        return val;
    }
}
