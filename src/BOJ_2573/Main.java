package BOJ_2573;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static boolean[][] check;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(tokenizer.nextToken());
                arr[i][j] = value;
                if (value != 0) {
                    check[i][j] = true;
                }
            }
        }

        int result = BFS(check);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public static int BFS(boolean[][] check) {//빙하가 녹는 기준
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j])
                    queue.offer(new Point(i, j));
            }
        }

        int cnt = 0;
        int[][] tmp = new int[N][M];
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                Point currentPoint = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = currentPoint.x + xMove[j];
                    int nextY = currentPoint.y + yMove[j];

                    if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                        if (arr[nextX][nextY] == 0) {
                            tmp[currentPoint.x][currentPoint.y]++;
                        }
                    }
                }

            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] -= tmp[i][j];
                    if (arr[i][j] < 0)
                        arr[i][j] = 0;

                    if (arr[i][j] != 0) {
                        queue.offer(new Point(i, j));
                    }

                }
            }

            for (int[] t : tmp) {
                Arrays.fill(t, 0);
            }

            int result = 0;
            for (boolean[] t : visited) {
                Arrays.fill(t, false);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        DFS(arr, i, j);
                        result++;
                    }
                }
            }

            boolean as = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j]!=0) {
                        as = true;
                        break;
                    }
                }
            }
            if(!as)
                return 0;

            if (result >= 2) {
                return cnt;
            }

        }

        return -1;
    }

    public static void DFS(int[][] arr, int x, int y) {//떨어진 빙하 찾기
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                if (!visited[nextX][nextY] && arr[nextX][nextY] != 0) {
                    DFS(arr, nextX, nextY);
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Point ( x = %d, y = %d)", this.x, this.y);
    }
}