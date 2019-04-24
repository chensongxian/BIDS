package com.csx.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-24
 */
public class GenerationTree {
    static float alpha = 0.3f;
    static int size = 20;
    static TNode[] nodes = new TNode[size];

    static {
        for (int i=0;i<size;i++) {
            nodes[i] = new TNode(i);
        }
    }

    static TNode treeGenenration(int start, int n) {
        if (n < 1) {
            return null;
        }
        int pivot = (int) ((n - 1) * alpha);
        int l = pivot;
        int r = n - 1 - pivot;

        TNode current = nodes[start + pivot];
        TNode leftRoot = treeGenenration(start, l);
        TNode rightRoot = treeGenenration(start + pivot + 1, r);
        current.left = leftRoot;
        current.right = rightRoot;

        if (leftRoot != null) {
            leftRoot.parent = current;
        }

        if (rightRoot != null) {
            rightRoot.parent = current;
        }

        return current;
    }


    static void preOrderPrint(TNode p) {
        if (p != null) {
            System.out.println(p.data);
            preOrderPrint(p.left);
            preOrderPrint(p.right);
        }
    }

    static void levelOrderPrint(TNode p) {
        Deque<TNode> q = new ArrayDeque<>();
        if (p!=null) {
            q.offer(p);
        }

        while (!q.isEmpty()) {
            TNode f = q.getFirst();
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

    public static void main(String[] args) {
        TNode current = treeGenenration(0, size);
        levelOrderPrint(current);
    }
}
