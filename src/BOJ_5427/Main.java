package BOJ_5427;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException { // 틀림
        new Main().input();
    }

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        int w;
        int h;
        String[] input;

        while (t-- > 0) {
            input = reader.readLine().split(" ");

            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            String[][] arr = new String[h][w];

            Point start = null;
            List<Point> fire = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                input = reader.readLine().split("");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = input[j];
                    if (arr[i][j].equals("@"))
                        start = new Point(i, j);

                    if (arr[i][j].equals("*"))
                        fire.add(new Point(i, j));

                }
            }

            writer.write(BFS(w, h, arr, start, fire) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public String BFS(int w, int h, String[][] arr, Point start, List<Point> fire) {
        Queue<Point> startQueue = new LinkedList<>();
        Queue<Point> fireQueue = new LinkedList<>();

        startQueue.add(start);
        fireQueue.addAll(fire);

        int cnt = 0;
        while (!startQueue.isEmpty()) {
            cnt++;

            int size = fireQueue.size();

            while(size-->0){
                Point currentFire = fireQueue.poll();

                for(int i=0; i<4; i++){
                    int nextX = currentFire.x + xMove[i];
                    int nextY = currentFire.y + yMove[i];

                    if(0>nextX || nextX>=h || 0>nextY || nextY>=w)
                        continue;

                    if(arr[nextX][nextY].equals("#") || arr[nextX][nextY].equals("*"))
                        continue;

                    fireQueue.add(new Point(nextX,nextY));
                    arr[nextX][nextY] = "*";
                }

            }
            size = startQueue.size();

            while(size-->0){
                Point currentPoint = startQueue.poll();

                for(int i=0; i<4; i++){
                    int nextX = currentPoint.x + xMove[i];
                    int nextY = currentPoint.y + yMove[i];

                    if(0>nextX || nextX>=h || 0>nextY || nextY >=w)
                        return String.valueOf(cnt);

                    if(!arr[nextX][nextY].equals("."))
                        continue;

                    startQueue.add(new Point(nextX,nextY));
                    arr[nextX][nextY]="@";
                }
            }
        }

        return IMPOSSIBLE;
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
        return String.format("Point( x = %d, y = %d)", this.x, this.y);
    }
}