package com.haojg.offer.NumberArrFind;

public class ArrFind {
    public static boolean find(int target, int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(matrix);

        boolean b = find(5, matrix);
        System.out.println(b);

    }
}
