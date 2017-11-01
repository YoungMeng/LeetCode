/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 */

/*
 *---1.从外到内，一圈一圈移动元素
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - first - 1;

            for (int k = first; k < last; k++) {
                int offset = k - first;

                //缓冲顶部元素
                int top = matrix[first][k];

                //将左边元素移到顶部
                matrix[first][k] = matrix[last - offset][first];

                //将底部元素移到左边
                matrix[last - offset][first] = matrix[last][last - offset];

                //将右边元素移到底部
                matrix[last][last - offset] = matrix[k][last];

                //将顶部元素赋给右边
                matrix[k][last] = top;
            }
        }
    }
}

/*
 *---2.从外到内，一圈一圈移动元素
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //沿着副对角线反转
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++)
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
        }

        //沿着水平中线翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++)
                swap(matrix, i, j, n - 1 - i, j);
        }
    }

    //交换元素
    private void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
