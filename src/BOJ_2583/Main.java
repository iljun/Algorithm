package BOJ_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int K;
    static int[][] arr;
    static boolean[][] visited;

    static int[] xMove = {1, -1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int x1, y1, x2, y2;
            tokenizer = new StringTokenizer(reader.readLine());
            x1 = Integer.parseInt(tokenizer.nextToken());
            y1 = Integer.parseInt(tokenizer.nextToken());
            x2 = Integer.parseInt(tokenizer.nextToken());
            y2 = Integer.parseInt(tokenizer.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    arr[x][y] = 1;
                }
            }
        }
        List<Integer> size = new ArrayList<>();

        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && arr[i][j]==0){
                    cnt++;
                    DFS(i,j);
                    size.add(result);
                    result=0;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(size);
        for(int i=0; i<size.size(); i++){
            System.out.print(size.get(i) + " ");
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        result++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                if (!visited[nextX][nextY] && arr[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    DFS(nextX, nextY);
                }

            }
        }

    }
}
