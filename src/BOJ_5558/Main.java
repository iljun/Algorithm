package BOJ_5558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int H;
    static int W;
    static int N;
    static String[][] graph;
    static boolean[][] visited;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);
        graph = new String[H][W];
        visited = new boolean[H][W];

        Point startPoint = null;
        for (int i = 0; i < H; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < W; j++) {
                graph[i][j] = input[j];
                if ("S".equals(input[j])) {
                    startPoint = new Point(i, j);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            startPoint = BFS(startPoint, i);
            for (int j = 0; j < H; j++)
                Arrays.fill(visited[j], false);
        }

        System.out.println(result);
    }

    static Point BFS(Point startPoint, int cheese) {
        visited[startPoint.x][startPoint.y] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(startPoint);

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int k = 0; k < size; k++) {
                Point currentPoint = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = currentPoint.x + xMove[i];
                    int nextY = currentPoint.y + yMove[i];
                    if (0 <= nextX && nextX < H && 0 <= nextY && nextY < W && !graph[nextX][nextY].equals("X")) {//이동가능
                        if (!visited[nextX][nextY]) {//방문하지 않은 점
                            if (!graph[nextX][nextY].equals(".") && !graph[nextX][nextY].equals("S")) {//치즈발견
                                if (Integer.parseInt(graph[nextX][nextY]) == cheese) {//먹을수있는 치즈
                                    result += time;
                                    return new Point(nextX, nextY);
                                } else {
                                    queue.offer(new Point(nextX, nextY));
                                }
                            } else {
                                visited[nextX][nextY] = true;
                                queue.offer(new Point(nextX, nextY));

                            }
                        }
                    }
                }
            }

        }
        return null;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}