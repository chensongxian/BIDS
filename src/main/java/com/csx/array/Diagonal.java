package com.csx.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 对角线问题
 * @author: csx
 * @Date: 2019-02-28
 */
public class Diagonal {
    public static void main(String[] args) {
        // 矩阵大小
        int n = 32;
        int x = 4;
        int y = 2;

        int[][] m = new int[n][n];

        /*
         * 方法1:
         */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    m[i][j] = x;
                } else {
                    m[i][j] = y;
                }
            }
        }

//        print(m);

        /*
         * 方法2：
         */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                m[i][j] = y;
            }
        }
        for (int i = 0; i < n; ++i) {
            m[i][i] = x;
        }
//        print(m);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                m[i][j] = y;
            }
            m[i][i] = x;
            for (int j = i + 1; j < n; ++j) {
                m[i][j] = y;
            }
        }
        print(m);

    }

    public static void print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
