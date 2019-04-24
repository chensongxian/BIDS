package com.csx.forwardlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 单链表逆置
 * @author: csx
 * @Date: 2019-04-08
 */
public class Reverse {
    public static void main(String[] args) {
        List<SNode> sNodes = new LinkedList<SNode>();
        sNodes.add(new SNode());
        sNodes.add(new SNode(1, null));
        sNodes.add(new SNode(2, null));
        sNodes.add(new SNode(3, null));

        for (int i = 0; i + 1 < sNodes.size(); ++i) {
           sNodes.get(i).next = sNodes.get(i + 1);
        }

        reverseFun(sNodes.get(0));

        for (SNode p = sNodes.get(0); p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    public static void reverseFun(SNode header) {
        SNode pre = null;
        SNode curr = header.next;

        while (curr != null) {
            SNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        header.next = pre;
    }
}


