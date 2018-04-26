package BOJ_4485;

import javafx.scene.layout.Priority;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] arr;
        String[] input;
        int cnt=0;

        while(n!=0){
            cnt++;
            arr= new int[n][n];

            for(int i=0; i<n;i++){
                input = reader.readLine().split(" ");
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            writer.write("Problem " + String.valueOf(cnt)+": ");
            writer.write(dijkstra(n,arr)+"\n");
            n = Integer.parseInt(reader.readLine());
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public String dijkstra(int n, int[][] arr){
        int[] xMove = {-1,1,0,0};
        int[] yMove = {0,0,-1,1};
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int[][] cost = new int[n][n];
        for(int[] tmp : cost){
            Arrays.fill(tmp,Integer.MAX_VALUE);
        }
        cost[0][0] = arr[0][0];

        queue.offer(new Point(0,0,cost[0][0]));

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            if(currentPoint.x == n-1 && currentPoint.y == n-1)
                break;

            if(cost[currentPoint.x][currentPoint.y] < currentPoint.cost)
                continue;

            for(int i=0; i<4; i++){
                int nextX = currentPoint.x + xMove[i];
                int nextY = currentPoint.y + yMove[i];

                if(0 > nextX || n-1 < nextX || 0 > nextY || n-1 < nextY)
                    continue;

                if(cost[nextX][nextY] > cost[currentPoint.x][currentPoint.y] + arr[nextX][nextY]){
                    cost[nextX][nextY] = cost[currentPoint.x][currentPoint.y] + arr[nextX][nextY];
                    queue.offer(new Point(nextX,nextY,cost[nextX][nextY]));
                }
            }

        }

        return String.valueOf(cost[n-1][n-1]);
    }
}
class Point implements Comparable<Point>{
    int x;
    int y;
    int cost;

    public Point(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point p){
        return this.cost - p.cost;
    }
}