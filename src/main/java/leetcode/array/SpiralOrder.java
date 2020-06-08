package leetcode.array;

import java.util.Arrays;

/**
 * @author machenggong
 * @date 2020/06/05
 */
public class SpiralOrder {

    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; // top to bottom.
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // right to left.
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(spiralOrder(arr)));
    }

}
