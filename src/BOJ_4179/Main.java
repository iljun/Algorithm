package BOJ_4179;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        String[][] arr = new String[R + 2][C + 2];

        Point startPoint = null;
        List<Point> firePoint = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            input = reader.readLine().split("");
            for (int j = 1; j <= C; j++) {
                arr[i][j] = input[j - 1];
                if (arr[i][j].equals("J"))
                    startPoint = new Point(i, j);

                if (arr[i][j].equals("F")) {
                    firePoint.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < R + 2; i++) {
            for (int j = 0; j < C + 2; j++) {
                if (arr[i][j] == null) {
                    arr[i][j] = "FINISH";
                }
            }
        }
        String result = BFS(arr, startPoint, firePoint, R, C);
        writer.write(result);

        reader.close();
        writer.flush();
        writer.close();
    }

    public String BFS(String[][] arr, Point startPoint, List<Point> firePoint, int row, int col) {
        int[] xMove = {1, -1, 0, 0};
        int[] yMove = {0, 0, 1, -1};

        Queue<Point> currentQueue = new LinkedList<>();
        currentQueue.add(startPoint);

        Queue<Point> fireQueue = new LinkedList<>();
        fireQueue.addAll(firePoint);

        int cnt = 0;
        while (!currentQueue.isEmpty()) {
            cnt++;

            int fireSize = fireQueue.size();
            for (int j = 0; j < fireSize; j++) {
                Point fire = fireQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = fire.x + xMove[i];
                    int nextY = fire.y + yMove[i];

                    if (1 <= nextX && nextX < row + 1 && 1 <= nextY && nextY < col + 1) {
                        if (arr[nextX][nextY].equals(".") || arr[nextX][nextY].equals("J")) {
                            fireQueue.add(new Point(nextX, nextY));
                            arr[nextX][nextY] = "F";
                        }
                    }
                }
            }

            int currentSize = currentQueue.size();
            for (int j = 0; j < currentSize; j++) {
                Point currentPoint = currentQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = currentPoint.x + xMove[i];
                    int nextY = currentPoint.y + yMove[i];

                    if (0 <= nextX && nextX < row + 2 && 0 <= nextY && nextY < col + 2) {
                        if (arr[nextX][nextY].equals(".")) {
                            currentQueue.offer(new Point(nextX, nextY));
                            arr[nextX][nextY] = "J";
                        }else if(arr[nextX][nextY].equals("FINISH")){
                            return String.valueOf(cnt);
                        }
                    }
                }
            }

        }

        return "IMPOSSIBLE";
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