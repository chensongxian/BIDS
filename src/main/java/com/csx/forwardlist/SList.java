package com.csx.forwardlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-08
 */
public class SList {
    public static void main(String[] args) {
        SNode sentinal = new SNode();
        SNode header = sentinal;

        SNode a = new SNode(1, null);
        SNode b = new SNode(2, null);
        SNode c = new SNode(3, null);

        SNode p = header;

        p.next = a;
        p = p.next;

        p.next = b;
        p = p.next;

        p.next = c;

        for (p = header.next; p != null; p = p.next) {
            System.out.println(p.data);
        }

        List<SNode> sNodes = new LinkedList<SNode>();
        sNodes.add(new SNode());
        sNodes.add(new SNode(1, null));
        sNodes.add(new SNode(2, null));
        sNodes.add(new SNode(3, null));
        header = p = sNodes.get(0);

        for (int i = 1; i < sNodes.size(); ++i) {
            p.next = sNodes.get(i);
            p = p.next;
        }

        System.out.println("---------");

        for (p = header.next; p != null; p = p.next) {
            System.out.println(p.data);
        }

    }
}

