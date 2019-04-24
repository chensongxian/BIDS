package com.csx.forwardlist;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 循环队列
 * @author: csx
 * @Date: 2019-04-10
 */
public class Buffer {

    public static void main(String[] args) {

        // 容量取10
        int c = 10;
        // 真实buffer长度n
        int n = c + 1;

        List<Integer> buffer = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            buffer.add(0);
        }

        // 初值任选buffer中的一个有效位置
        int front = n / 2;
        // 这里都取 n/2
        int rear = n / 2;

        int x = 0;

        // 当buffer不满时，持续放入元素
        while (rear + 1 < n ? rear + 1 != front : 0 != front) {
            buffer.set(rear, x++);
            // 下面操作比 rear = (rear + 1) % n 更快
            if (rear < c) {
                ++rear;
            } else {
                rear = 0;
            }
        }

        // 当buffer不空，持续输出队首元素并出队
        while (front != rear) {
            System.out.println(buffer.get(front));
            if (front < c) {
                ++front;
            } else {
                front = 0;
            }
        }
        Deque[] deques = new Deque[20];
        deques[0].pop();
    }
}
