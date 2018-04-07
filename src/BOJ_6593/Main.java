package BOJ_6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int L;
    static int R;
    static int C;
    static String[][][] arr;
    static boolean[][][] visited;
    static int[] xMove = {1, -1, 0, 0, 0, 0};
    static int[] yMove = {0, 0, 1, -1, 0, 0};
    static int[] kMove = {0, 0, 0, 0, 1, -1};
    static long[][][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = reader.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

            if (L == 0 && R == 0 && C == 0)
                return;

            arr = new String[L][R][C];
            visited = new boolean[L][R][C];
            result = new long[L][R][C];

            int startX = -1;
            int startY = -1;
            int startZ = -1;
            int endX = -1;
            int endY = -1;
            int endZ = -1;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    input = reader.readLine().split("");
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = input[k];
                        if (input[k].equals("S")) {
                            startX = i;
                            startY = j;
                            startZ = k;
                        }

                        if (input[k].equals("E")) {
                            endX = i;
                            endY = j;
                            endZ = k;
                        }
                    }
                }
                reader.readLine();
            }

            DFS(startX, startY, startZ);


            if (result[endX][endY][endZ] == 0) {
                System.out.println("Trapped!");
            } else
                System.out.printf("Escaped in %d minute(s).\n", result[endX][endY][endZ]);
        }
    }

    public static void DFS(int x, int y, int z) {
        visited[x][y][z] = true;
        for (int i = 0; i < 6; i++) {
            int nextX = x + kMove[i];
            int nextY = y + xMove[i];
            int nextZ = z + yMove[i];

            if (0 <= nextX && nextX < L && 0 <= nextY && nextY < R && 0 <= nextZ && nextZ < C) {
                if (!visited[nextX][nextY][nextZ] && !arr[nextX][nextY][nextZ].equals("#")) {
                    result[nextX][nextY][nextZ] = result[x][y][z] + 1;
                    DFS(nextX, nextY, nextZ);
                }
            }
        }
    }

}
