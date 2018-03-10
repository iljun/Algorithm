package BOJ_1938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] arr;

    static int[] moveX = {0, -1, 0, 1};
    static int[] moveY = {-1, 0, 1, 0};

    static final int VERTICAL = 0;
    static final int HORIZON = 1;

    static boolean[][][] visited;

    static Point start;
    static Point target;

    static final int TREE = 1;
    static final int BLANK = 0;
    static final int TARGET = 2;

        public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N][2];

        int startCnt = 0;
        int targetCnt = 0;

        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            for (int j = 0; j < N; j++) {
                char c = input.charAt(j);

                if ('B' == c) {
                    startCnt++;
                    arr[i][j] = BLANK;
                    if (startCnt == 1)
                        start = new Point(i, j, 0);
                    else if (startCnt == 2) {
                        if (start.x == i) {
                            start = new Point(i, j, HORIZON);
                        } else {
                            start = new Point(i, j, VERTICAL);
                        }
                    }
                }

                if ('E' == c) {
                    targetCnt++;
                    arr[i][j] = TARGET;
                    if (targetCnt == 1) {
                        target = new Point(i, j, 0);
                    } else if (targetCnt == 2) {
                        if (target.x == i) {
                            target = new Point(i, j, HORIZON);
                        } else
                            target = new Point(i, j, VERTICAL);
                    }

                }

                if ('1' == c) {
                    arr[i][j] = TREE;
                }

                if ('0' == c) {
                    arr[i][j] = BLANK;
                }
            }
        }

        BFS();

        reader.close();
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][start.dir] = true;

        boolean finish = false;
        int cnt = -1;
        while (!queue.isEmpty() && !finish) {
            cnt++;
            int size = queue.size();
            for (int z = 0; z < size; z++) {

                Point currentPoint = queue.poll();
                if (arr[currentPoint.x][currentPoint.y] == TARGET) {
                    if (currentPoint.x == target.x && currentPoint.y == target.y && currentPoint.dir == target.dir) {
                        System.out.println(cnt);
                        finish = true;
                        break;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = currentPoint.x + moveX[i];
                    int nextY = currentPoint.y + moveY[i];

                    if (currentPoint.dir == HORIZON) {
                        if (nextX < 0 || nextX >= N || nextY - 1 < 0 || nextY + 1 >= N)
                            continue;

                        if (visited[nextX][nextY][currentPoint.dir])
                            continue;

                        if (arr[nextX][nextY] == TREE || arr[nextX][nextY - 1] == TREE || arr[nextX][nextY + 1] == TREE)
                            continue;

                        queue.add(new Point(nextX, nextY, currentPoint.dir));
                        visited[nextX][nextY][currentPoint.dir] = true;

                    }

                    if (currentPoint.dir == VERTICAL) {
                        if (nextX - 1 < 0 || nextX + 1 >= N || nextY < 0 || nextY >= N)
                            continue;

                        if (visited[nextX][nextY][currentPoint.dir])
                            continue;

                        if (arr[nextX - 1][nextY] == TREE || arr[nextX][nextY] == TREE || arr[nextX + 1][nextY] == TREE)
                            continue;

                        queue.add(new Point(nextX, nextY, currentPoint.dir));
                        visited[nextX][nextY][currentPoint.dir] = true;

                    }

                }

                if (currentPoint.x - 1 < 0 || currentPoint.x + 1 >= N || currentPoint.y - 1 < 0 || currentPoint.y + 1 >= N)
                    continue;


                if (visited[currentPoint.x][currentPoint.y][currentPoint.dir ^ 1])
                    continue;

                boolean rotateFree = true;
                for (int j = currentPoint.x - 1; j <= currentPoint.x + 1 && rotateFree; j++) {

                    for (int k = currentPoint.y - 1; k <= currentPoint.y + 1; k++) {

                        if (arr[j][k] == TREE) {

                            rotateFree = false;
                            break;
                        }
                    }
                }

                if (rotateFree) {
                    currentPoint.dir ^= 1;
                    queue.add(currentPoint);
                    visited[currentPoint.x][currentPoint.y][currentPoint.dir] = true;
                }
            }

        }
        if (!finish) {
            System.out.println(0);
        }
    }

}

class Point {

    int x;
    int y;
    int dir;

    public Point(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public String toString() {
        return String.format("Point(x = %d, y = %d, dir = %d)", this.x, this.y, this.dir);
    }
}