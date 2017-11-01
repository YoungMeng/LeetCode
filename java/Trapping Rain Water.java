/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int max = 0;//最高柱子的位置
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max])
                max = i;
        }

        int water = 0;

        //左边
        for (int i = 0, peak = 0; i < max; i++) {
            if (height[i] > peak)
                peak = height[i];
            else
                water += peak - height[i];
        }

        //右边,倒序扫描
        for (int j = height.length - 1, top = 0; j > max; j--) {
            if (height[j] > top)
                top = height[j];
            else
                water += top - height[j];
        }

        return water;
    }
}
