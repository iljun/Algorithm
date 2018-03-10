package BOJ_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final String EMPTY = ".";
    private static final String WATER = "*";
    private static final String STONE = "X";
    private static final String BEAVER = "D";
    private static final String HEDGEHOG = "S";

    private static int R;
    private static int C;
    private static String[][] arr;

    private static int[] xMove = {-1, 0, 0, 1};
    private static int[] yMove = {0, 1, -1, 0};

    private static Queue<Point> waterQueue = new LinkedList<>();
    private static Queue<Point> hedgehogQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] RC = reader.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        arr = new String[R][C];

        for (int i = 0; i < R; i++) {
            String[] input = reader.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = input[j];
                if (input[j].equals(HEDGEHOG)) {
                    hedgehogQueue.add(new Point(i, j));
                }
                if (input[j].equals(WATER)) {
                    waterQueue.add(new Point(i, j));
                }
            }
        }

        int result = BFS();
        System.out.println(result == -1 ? "KAKTUS" : result);

        reader.close();
    }

    public static int BFS() {

        int cnt = 0;
        while (!hedgehogQueue.isEmpty()) {
            cnt++;
            int waterSize = waterQueue.size();
            while (waterSize-- >0) {
                Point currentWaterPoint = waterQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = currentWaterPoint.getX() + xMove[i];
                    int nextY = currentWaterPoint.getY() + yMove[i];

                    if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C) {
                        if (arr[nextX][nextY].equals(EMPTY)) {
                            arr[nextX][nextY] = WATER;
                            waterQueue.add(new Point(nextX, nextY));
                        }
                    }
                }

            }
            int hedgehogSize = hedgehogQueue.size();
            while(hedgehogSize-- >0) {
                Point currentBeaverPoint = hedgehogQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = currentBeaverPoint.getX() + xMove[i];
                    int nextY = currentBeaverPoint.getY() + yMove[i];

                    if (0 <= nextX && nextX < R && 0 <= nextY && nextY < C) {
                        if (arr[nextX][nextY].equals(BEAVER)) {
                            hedgehogQueue.add(new Point(nextX, nextY));
                            return cnt;
                        } else if (arr[nextX][nextY].equals(EMPTY)) {
                            arr[nextX][nextY] = HEDGEHOG;
                            hedgehogQueue.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
        }
        return -1;
    }

}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}