package com.csx.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-24
 */
public class LevelOrder {
    void levelOrderPrint(Node p) {
        Deque<Node> q = new ArrayDeque<>();
        if (p!=null) {
            q.offer(p);
        }

        while (!q.isEmpty()) {
            Node f = q.getFirst();
            System.out.println(f.data);

            if (f.left != null) {
                q.offer(f.left);
            }

            if (f.right != null) {
                q.offer(f.right);
            }

            q.poll();
        }
    }
}
