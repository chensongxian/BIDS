package com.csx.queue;

import com.csx.stack.Status;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-17
 */
public class MazeWithQueue {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        // 未访问过标记
        char unvisited = '0';
        // 访问过标记
        char visited = 'V';

        // 迷宫字符数组
        char[][] maze = {
                {'*', '*', '*', '*', '*', '*', '*'},
                {'*', '0', '*', '0', '0', '0', '*'},
                {'*', '0', '*', '0', '*', '0', '*'},
                {'*', '0', '0', '0', '*', '0', '*'},
                {'*', '*', '*', '*', '*', '*', '*'}
        };

        // 可行方向总数
        int d = 4;
        Point[] delta = {new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};

        Point source = new Point(1, 1);
        Point destination = new Point(3, 5);
        // 用户保存父亲所在位置
        Point[][] parent = new Point[m][n];
        // 搜索时所用队列
        Queue<Point> q = new ArrayDeque<>();
        // 保存最终路径
        Stack<Point> p = new Stack<>();
        // 初始点设为出口点
        q.offer(destination);
        boolean solved = false;
        int length = 0;
        while (!q.isEmpty()) {
            // length每次增量为increment,如果有新点入队则increment为1
            int increment = 0;
            for (int i = 0; i < d;++i) {
                Point neighbor = new Point(q.peek().x + delta[i].x, q.peek().y + delta[i].y);
                if (maze[neighbor.x][neighbor.y] == unvisited) {
                    increment = 1;
                    maze[neighbor.x][neighbor.y] = visited;
                    parent[neighbor.x][neighbor.y] = q.peek();
                    q.offer(neighbor);
                    if (neighbor.x == source.x && neighbor.y == source.y) {
                        solved = true;
                        break;
                    }
                }
            }
            length += increment;
            if (solved) {
                p.push(source);
                while (p.peek().x != destination.x || p.peek().y != destination.y) {
                    p.push(parent[p.peek().x][p.peek().y]);
                }
                break;
            }
            q.poll();
        }

        for (Point point : p) {
            System.out.println(point.x + "----" + point.y);
        }

    }

}

