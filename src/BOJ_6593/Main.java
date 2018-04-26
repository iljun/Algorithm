package BOJ_6593;

import javafx.scene.layout.Priority;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        String[][][] arr;
        while (L!=0 && R!=0 && C!=0) {

            arr = new String[L][R][C];

            Point startPoint = null;
            Point endPoint = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    input = reader.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = input[k];
                        if (input[k].equals("S")) {
                            startPoint = new Point(i, j, k);
                        }

                        if (input[k].equals("E")) {
                            endPoint = new Point(i, j, k);
                        }
                    }
                }
                reader.readLine();
            }
            int result = dijkstra(L, R, C, startPoint, endPoint, arr);
            if(result!=Integer.MAX_VALUE){
                writer.write("Escaped in "+String.valueOf(result)+" minute(s).\n");
            }else{
                writer.write("Trapped!\n");
            }

            input = reader.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

        }

        reader.close();
        writer.flush();
        writer.close();

    }

    public int dijkstra(int l, int r, int c, Point startPoint, Point endPoint, String[][][] arr) {
        int[] lMove = {-1, 1, 0, 0, 0, 0};
        int[] xMove = {0, 0, -1, 1, 0, 0};
        int[] yMove = {0, 0, 0, 0, -1, 1};

        int[][][] cost = new int[l][r][c];
        for (int[][] tmp : cost) {
            for (int[] tmp2 : tmp) {
                Arrays.fill(tmp2, Integer.MAX_VALUE);
            }
        }

        cost[startPoint.l][startPoint.x][startPoint.y] = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        Point p = new Point(startPoint.l, startPoint.x, startPoint.y);
        p.cost = cost[startPoint.l][startPoint.x][startPoint.y];
        queue.offer(p);


        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextL = currentPoint.l + lMove[i];
                int nextX = currentPoint.x + xMove[i];
                int nextY = currentPoint.y + yMove[i];

                if (0 > nextL || nextL > l - 1 || 0 > nextX || nextX > r - 1 || 0 > nextY || nextY > c - 1)
                    continue;

                if (arr[nextL][nextX][nextY].equals("E")) {
                    return currentPoint.cost+1;
                }

                if (!arr[nextL][nextX][nextY].equals("."))
                    continue;

                if (cost[nextL][nextX][nextY] < currentPoint.cost)
                    continue;

                if (cost[nextL][nextX][nextY] > cost[currentPoint.l][currentPoint.x][currentPoint.y] + 1) {
                    cost[nextL][nextX][nextY] = cost[currentPoint.l][currentPoint.x][currentPoint.y] + 1;
                    Point nextPoint = new Point(nextL, nextX, nextY);
                    nextPoint.cost = cost[nextL][nextX][nextY];
                    queue.offer(nextPoint);
                }
            }
        }
        return cost[endPoint.l][endPoint.x][endPoint.y];
    }

}

class Point implements Comparable<Point> {
    int l;
    int x;
    int y;
    int cost;

    public Point(int l, int x, int y) {
        this.l = l;
        this.x = x;
        this.y = y;
        this.cost = 1;
    }

    @Override
    public int compareTo(Point p) {
        return this.cost - p.cost;
    }

    @Override
    public String toString() {
        return String.format("Point( l = %d, x = %d, y = %d, cost = %d)", this.l, this.x, this.y, this.cost);
    }
}