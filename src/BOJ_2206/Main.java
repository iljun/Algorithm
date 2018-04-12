package BOJ_2206;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};
    static boolean[][] visited;
    static List<Wall> wallList;
    public static void main(String[] args) throws IOException { // 시간초과
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        wallList = new ArrayList<>();
        wallList.add(new Wall(0,0));

        for (int i = 1; i < N+1; i++) {
            String[] input  = reader.readLine().split("");
            for (int j = 1; j < M+1; j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
                if(arr[i][j]==1){
                    wallList.add(new Wall(i,j));
                }
            }
        }

        int min = BFS();

        writer.write(String.valueOf(min));

        reader.close();
        writer.flush();
        writer.close();
    }

    public static int BFS() {
        int min=Integer.MAX_VALUE;
        for(int k=0; k<wallList.size(); k++) {
            int cnt = 0;
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(1,1));
            boolean[][] visited = new boolean[N+1][M+1];
            arr[wallList.get(k).x][wallList.get(k).y]=0;
            visited[1][1] = true;

            while (!queue.isEmpty()) {
                cnt++;
                int size = queue.size();
                for(int i=0; i<size; i++){
                    Point currentPoint = queue.poll();
                    if(currentPoint.x == N && currentPoint.y ==M) {
                        min = Math.min(min, cnt);
                        break;
                    }

                    for(int j=0; j<4; j++){
                        int nextX = currentPoint.x + xMove[j];
                        int nextY = currentPoint.y + yMove[j];

                        if(1<= nextX && nextX<N+1 && 1<=nextY && nextY<M+1){
                            if(!visited[nextX][nextY] && arr[nextX][nextY]==0){
                                visited[nextX][nextY] = true;
                                queue.offer(new Point(nextX,nextY));
                            }
                        }
                    }
                }
            }

            arr[wallList.get(k).x][wallList.get(k).y]=1;
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }


}
class Wall{
    int x;
    int y;
    public Wall(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
