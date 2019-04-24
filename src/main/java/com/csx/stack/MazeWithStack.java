package com.csx.stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2019-04-17
 */
public class MazeWithStack {
    /**可行方向总数**/
    static int d = 4;

    public static Status findNext(Status current) {
        Status next = new Status();
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        next.x = current.x + delta[current.direction][0];
        next.y = current.y + delta[current.direction][1];
        return next;
    }


    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        // 未访问过标记
        char unvisited = '0';
        // 访问过标记
        char visited = 'V';

        char[][] maze = {
            {'*', '*', '*', '*', '*', '*', '*'},
            {'*', '0', '*', '0', '0', '0', '*'},
            {'*', '0', '*', '0', '*', '0', '*'},
            {'*', '0', '0', '0', '*', '0', '*'},
            {'*', '*', '*', '*', '*', '*', '*'}
        };
        Status source = new Status(1, 1, 0);
        Status destination = new Status(3, 5, 0);

        Stack<Status> path = new Stack<>();
        path.push(source);

        while (!path.isEmpty()) {
            if (path.peek().direction < d) {
                Status next = findNext(path.peek());
                ++path.peek().direction;
                if (maze[next.x][next.y] == unvisited) {
                    maze[next.x][next.y] = visited;
                    // 设置next的初始方向
                    next.direction = 0;
                    path.push(next);

                    // 放到路径栈后再判断该点是否为终点并及时跳出循环
                    if (next.x == destination.x && next.y == destination.y) {
                        break;
                    }
                }

            } else {
                path.pop();
            }
        }

        for (Status status : path) {
            System.out.println(status.x + "----" + status.y);
        }


    }

}
