package BOJ_10026;

import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static boolean[][] visited;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        arr = new String[n][n];
        visited = new boolean[n][n];

        String[] input;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt1++;
                    DFS(n, i, j);
                }
            }
        }

        for (boolean[] b : visited) {
            Arrays.fill(b, false);
        }

        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt2++;
                    DFS(n, i, j, "R", "G");
                }
            }
        }
        writer.write(String.valueOf(cnt1) + " " + String.valueOf(cnt2));

        reader.close();
        writer.flush();
        writer.close();
    }

    public void DFS(int n, int x, int y, String... color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (nextX < 0 || n - 1 < nextX || nextY < 0 || n - 1 < nextY)
                continue;

            if (visited[nextX][nextY])
                continue;

            if(color.length == 0){
                if(arr[x][y].equals(arr[nextX][nextY]))
                    DFS(n,nextX,nextY);
            }else{
                if(arr[x][y].equals(color[0]) || arr[x][y].equals(color[1])){
                    if(arr[nextX][nextY].equals(color[0]) || arr[nextX][nextY].equals(color[1])) {
                        DFS(n, nextX, nextY, "R", "G");
                    }
                }else{
                    if(arr[x][y].equals(arr[nextX][nextY])){
                        DFS(n,nextX,nextY,"R","G");
                    }
                }
            }
        }
    }
}
