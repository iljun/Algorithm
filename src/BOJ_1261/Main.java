package BOJ_1261;

import javafx.scene.layout.Priority;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j]= Integer.parseInt(input[j]);
            }
        }

        int result = BFS(0, 0, n, m, arr);
        System.out.println(result);
    }

    public int BFS(int x, int y, int n, int m, int[][] arr) {
        int[] xMove = {-1, 1, 0, 0};
        int[] yMove = {0, 0, -1, 1};

        int[][] cost = new int[n][m];
        for(int[] tmp : cost){
            Arrays.fill(tmp,Integer.MAX_VALUE);
        }
        cost[x][y] = 0;

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(x,y,0));

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            if(currentPoint.x == n-1 && currentPoint.y == m-1)
                break;

            if(cost[currentPoint.x][currentPoint.y] < currentPoint.cost)
                break;

            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + xMove[i];
                int nextY = currentPoint.y + yMove[i];

                if(nextX<0 || nextX > n-1 || nextY<0 || nextY >m-1)
                    continue;

                if(cost[nextX][nextY]>cost[currentPoint.x][currentPoint.y] + arr[nextX][nextY]){
                    cost[nextX][nextY] = cost[currentPoint.x][currentPoint.y] + arr[nextX][nextY];
                    queue.offer(new Point(nextX,nextY,cost[nextX][nextY]));
                }
            }
        }

        return cost[n-1][m-1];
    }
}
class Point implements Comparable<Point>{
    int x;
    int y;
    int cost;

    public Point(int x, int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point p){
        return this.cost - p.cost;
    }
}
