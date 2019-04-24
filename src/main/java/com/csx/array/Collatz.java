package com.csx.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 3n + 1问题
 * @author: csx
 * @Date: 2019-03-20
 */
public class Collatz {
    public static int iterativeCollatz(int n) {
        if (n < 1) {
            return 0;
        }
        int l = 1;
        while (n != 1) {
            /*
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            */

            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            ++l;
        }
        return l;
    }

    public static int memoizedCollatz(List<Integer> v, int n) {
        int d = 0;
        // 如果n大于存储已经算出来的数值集合，则将n计算到已经算出的集合范围内
        while (n >= v.size()) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            ++d;
        }

        if (v.get(n) == 0 && n > 0) {
            // 对n处的数值，进行递归计算并加上1
            int l = memoizedCollatz(v, (n % 2 == 0) ? n / 2 : 3 * n + 1) + 1;
            v.set(n, l);
        }
        // n对应的序列长度，加上偏移量d
        return v.get(n) + d;
    }

    public static void main(String[] args) {
        int m = 10000;
        // 利用备忘录保存已经算出的值，适合多次求解
        List<Integer> v = new ArrayList<Integer>(Collections.nCopies(m, 0));

        v.set(1, 1);

        int max = 100000;
        boolean equal = true;
        for (int i = 1; i <= max; ++i) {
            if (iterativeCollatz(i) != memoizedCollatz(v, i)) {
                equal = false;
                System.out.println(i);
            }
        }

        if (!equal) {
            System.out.println("不相符");
        }
    }
}
