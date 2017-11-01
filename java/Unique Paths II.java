/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < m; i++)
            path[i][0] = obstacleGrid[i][0] == 1 ? 0 : path[i - 1][0];
        for (int j = 1; j < n; j++)
            path[0][j] = obstacleGrid[0][j] == 1 ? 0 : path[0][j - 1];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                path[i][j] = obstacleGrid[i][j] == 1 ? 0 : path[i - 1][j] + path[i][j - 1];

        return path[m - 1][n - 1];
    }
}
