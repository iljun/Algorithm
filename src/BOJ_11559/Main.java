package BOJ_11559;

import java.io.*;
import java.util.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 6
 * Time: 오후 3:31
 */
public class Main {
    //BFS를 이용해 먼저 지울곳을 표시 한번에 지운후 다시 BFS 반복하다가 지울게 없으면 return
    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] arr = new String[12][6];

        String[] input;
        for (int i = 0; i < 12; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < 6; j++) {
                arr[i][j] = input[j];
            }
        }

        writer.write(String.valueOf(BFS(arr, 0)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int BFS(String[][] arr, int cnt) {
        int[] xMove = {-1, 1, 0, 0};
        int[] yMove = {0, 0, -1, 1};

        boolean[][] check = new boolean[12][6];

        int tmp = 0;
        for (int i = 11; i > -1; i--) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j].equals("."))
                    continue;

                Queue<Block> queue = new LinkedList<>();
                queue.add(new Block(i, j, arr[i][j]));
                check[i][j] = true;

                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int q = 0; q < size; q++) {
                        Block currentBock = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = currentBock.x + xMove[k];
                            int nextY = currentBock.y + yMove[k];

                            if (0 > nextX || 11 < nextX || nextY < 0 || 5 < nextY)
                                continue;

                            if (check[nextX][nextY])
                                continue;

                            if (!arr[nextX][nextY].equals(arr[i][j]))
                                continue;

                            System.out.println(arr[nextX][nextY] + " " + arr[i][j]);
                            tmp++;
                            check[nextX][nextY] = true;
                            queue.add(new Block(nextX, nextY, currentBock.color));

                        }
                    }
                }

                if (true)
                    break;

            }
        }

        if (tmp >= 4) {
            arr = down(arr, check);
            System.out.println(Arrays.deepToString(arr));
        } else
            return cnt;
        for (boolean[] t : check) {
            Arrays.fill(t, false);
        }

        return BFS(arr, cnt + 1);
    }

    public String[][] down(String[][] arr, boolean[][] check) {
        Queue<String> colBlocks = new LinkedList<>();
        System.out.println(Arrays.deepToString(check));
        for (int col = 0; col < 6; col++) {
            for (int row = 11; row >= 0; row--) {

                if (!check[row][col])
                    colBlocks.add(arr[row][col]);
            }

            for (int row = 11; row >= 0; row--) {

                if (!colBlocks.isEmpty())
                    arr[row][col] = colBlocks.poll();
                else
                    arr[row][col] = ".";
            }
        }
        return arr;
    }
}

class Block {
    int x;
    int y;
    String color;

    public Block(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Color( x = %d, y = %d, color = %s)", this.x, this.y, this.color);
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