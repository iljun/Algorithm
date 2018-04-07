package BOJ_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] arr;

    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            String[] input = reader.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);
            arr = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                input = reader.readLine().split(" ");
                arr[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    DFS(nextX, nextY);
                }
            }
        }
    }
}
