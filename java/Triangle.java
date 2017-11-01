/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

/*
 * 动态规划思想
 */

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] path = new int[size];

        for (int k = 0; k < size; k++) {
            path[k] = triangle.get(size - 1).get(k);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                path[j] = triangle.get(i).get(j) + Math.min(path[j], path[j + 1]);
            }
        }

        return path[0];
    }
}
