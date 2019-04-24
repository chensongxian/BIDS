package com.csx.tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-24
 */
public class TNode {
    int data;
    TNode left;
    TNode right;
    TNode parent;

    public TNode(int data) {
        this.data = data;
    }

    public TNode() {
    }
}
