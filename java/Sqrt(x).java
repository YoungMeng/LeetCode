/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 */

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1;
        int right = x / 2;
        int mid = 0;
        int last_mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (x / mid > mid) {
                left = mid + 1;
                last_mid = mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return last_mid;
    }
}
