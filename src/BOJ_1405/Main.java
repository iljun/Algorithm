package BOJ_1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static double[] probability = new double[4];
    static boolean[][] visited = new boolean[30][30];
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        probability[0] = Double.parseDouble(input[1]) / 100;
        probability[1] = Double.parseDouble(input[2]) / 100;
        probability[2] = Double.parseDouble(input[3]) / 100;
        probability[3] = Double.parseDouble(input[4]) / 100;

        double result = Double.parseDouble(String.format("%.9f",DFS(15, 15, N)));

        System.out.println(result);
    }

    static double DFS(int x, int y, int limit) {
        if (limit == 0)
            return 1.0;

        visited[x][y] = true;

        double result = 0.0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (visited[nextX][nextY])
                continue;

            result += DFS(nextX, nextY, limit-1) * probability[i];
        }

        visited[x][y] = false;

        return result;
    }
}
