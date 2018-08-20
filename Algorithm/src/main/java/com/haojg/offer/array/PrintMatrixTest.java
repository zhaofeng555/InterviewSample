package com.haojg.offer.array;

import java.util.ArrayList;

/**
 * @Author: 146477
 * @Date: 2018/8/10 10:52
 */
public class PrintMatrixTest {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= r2) {
            for (int i = c1; i < c2; i++) {
                ret.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }

            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return ret;
    }

    public static int[][] configMatrix(int n) {
        int[][] matrix = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;

        int num = 1;

        while (r1 <= r2 && c1 <= r2) {
            for (int i = c1; i <= c2; i++) {
                matrix[r1][i] = num++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                matrix[i][c2] = num++;
            }

            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    matrix[r2][i] = num++;
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    matrix[i][c1] = num++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return matrix;
    }

    public static void printArr() {
        int m = 5;
        int n = 5;
        int[][] pos = new int[m][n];
        int count = 0;
        int r = 0, c = 0;/* r:行下标 c:列下标 pos[r][c]对应以上位置 */

        /* 赋值方向，先向右c++，再向下r++，再向左c--，再向上r-- */
        final int up = 1;
        final int down = -1;
        final int left = 2;
        final int right = -2;
        int dir = right;/* 开始方向 */
        int cir = 1;/* 第几圈赋值 */
        while (count < m * n) {
            count++;
            pos[r][c] = count;
            switch (dir) {
                case right:
                    if (c < n - cir) {
                        c++;
                    } else {
                        dir = down;
                        r++;
                    }
                    break;
                case down:
                    if (r < m - cir) {
                        r++;
                    } else {
                        dir = left;
                        c--;
                    }
                    break;
                case left:
                    if (c > cir - 1) {
                        c--;
                    } else {
                        dir = up;
                        r--;
                    }
                    break;
                case up:
                    if (r > cir) {
                        r--;
                    } else {
                        cir++;
                        dir = right;
                        c++;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("脚本之家测试结果：");
        /* 输出 */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pos[i][j] < 10) {
                    System.out.print(pos[i][j] + " " + " ");
                } else {
                    System.out.print(pos[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> arrList = printMatrix(matrix);
        System.out.println(arrList);

        int[][] arr = configMatrix(4);
        System.out.println(arr);

    }
}
