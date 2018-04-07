package BOJ_7569;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int H;
    static int[][][] arr;
    static boolean[][][] visited;

    static int[] xMove = {1, -1, 0, 0, 0, 0};
    static int[] yMove = {0, 0, 1, -1, 0, 0};
    static int[] zMove = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        arr = new int[H][M][N];
        visited = new boolean[H][M][N];

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                input = reader.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    arr[i][j][k] = Integer.parseInt(input[k]);
                    if(arr[i][j][k]==1) {
                        list.add(new Point(i, j, k));
                        visited[i][j][k] = true;
                    }else if(arr[i][j][k]==-1){
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int result = BFS(list);

        boolean check = true;
        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    if(!visited[i][j][k]){
                        check = false;
                        break;
                    }
                }
            }
        }

        if(check)
            writer.write(String.valueOf(result));
        else
            writer.write("-1");

        reader.close();
        writer.flush();
        writer.close();
    }

    public static int BFS(List<Point> list){
        Queue<Point> queue = new LinkedList<>();
        queue.addAll(list);

        int result=-1;

        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i=0; i<size; i++) {
                Point currentPoint = queue.poll();
                for(int j=0; j<6; j++){
                    int nextX = currentPoint.x + xMove[j];
                    int nextY = currentPoint.y + yMove[j];
                    int nextZ = currentPoint.z + zMove[j];

                    if(0<=nextX && nextX<H && 0<=nextY && nextY <M && 0<=nextZ && nextZ<N){
                        if(!visited[nextX][nextY][nextZ] && arr[nextX][nextY][nextZ]==0){
                            queue.offer(new Point(nextX,nextY,nextZ));
                            visited[nextX][nextY][nextZ] = true;
                        }
                    }
                }
            }
        }

        return result;
    }
}
class Point{
    int x;
    int y;
    int z;

    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}