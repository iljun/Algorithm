package BOJ_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        List<Point> list = new ArrayList<>();
        List<Point> birus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if(arr[i][j]==0){
                    list.add(new Point(i,j));
                }else if(arr[i][j]==2){
                    birus.add(new Point(i,j));
                }
            }
        }

        int result = 0;

        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                for(int k=j+1; k<list.size();k++){
                    Point point1 = list.get(i);
                    Point point2 = list.get(j);
                    Point point3 = list.get(k);

                    arr[point1.x][point1.y] = 1;
                    arr[point2.x][point2.y] = 1;
                    arr[point3.x][point3.y] = 1;

                    result = Math.max(result, BFS(birus));

                    arr[point1.x][point1.y] = 0;
                    arr[point2.x][point2.y] = 0;
                    arr[point3.x][point3.y] = 0;
                }
            }
        }
        System.out.println(result);
    }

    public static int BFS(List<Point> birus) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.addAll(birus);
        for(int i=0; i<birus.size(); i++){
            Point tmp = birus.get(i);
            visited[tmp.x][tmp.y] = true;
        }

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + xMove[i];
                int nextY = currentPoint.y + yMove[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !visited[i][j])
                    cnt++;
            }
        }
        return cnt;
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