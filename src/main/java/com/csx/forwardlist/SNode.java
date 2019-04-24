package com.csx.forwardlist;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-08
 */
class SNode {
    int data = -1;
    SNode next;


    public SNode() {
    }

    public SNode(int data, SNode next) {
        this.data = data;
        this.next = next;
    }
}
