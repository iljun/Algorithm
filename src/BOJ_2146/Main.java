package BOJ_2146;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    static int[][] arr;
    static int[] xMove = { -1,1,0,0};
    static int[] yMove = {0,0,-1,1};
    static boolean[][] visited;
    static ArrayList<ArrayList<Point>> contry = new ArrayList<ArrayList<Point>>();
    static int n;
    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        String[] input;
        for(int i=0; i<n; i++){
            input = reader.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int index = 0;
        contry.add(new ArrayList<Point>());
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && arr[i][j]!=0){
                    index++;
                    contry.add(new ArrayList<>());

                    DFS(i,j,index,contry.get(index));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<index+1; i++){
            for(Point point : contry.get(i)){
                min = Math.min(min,BFS(point));
            }
        }

        writer.write(String.valueOf(min-1));

        reader.close();
        writer.flush();
        writer.close();
    }

    public void DFS(int x, int y,int index, ArrayList<Point> contry){
        visited[x][y] = true;
        contry.add(new Point(index,x,y));
        arr[x][y] = index;

        for(int i=0; i<4; i++){
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if(nextX < 0 || n-1 < nextX || nextY < 0 || n-1 < nextY)
                continue;

            if(visited[nextX][nextY])
                continue;

            if(arr[nextX][nextY]==0)
                continue;

            DFS(nextX,nextY,index,contry);

        }
    }

    public int BFS(Point point){
        for(int i=0; i<n; i++)
            Arrays.fill(visited[i],false);

        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visited[point.row][point.col] = true;

        int cnt=-1;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for(int j=0; j<size; j++) {
                Point currentPoint = queue.poll();

                if(arr[currentPoint.row][currentPoint.col]!=0 && arr[currentPoint.row][currentPoint.col]!=currentPoint.index)
                    return cnt;

                for (int i = 0; i < 4; i++) {
                    int nextX = currentPoint.row + xMove[i];
                    int nextY = currentPoint.col + yMove[i];

                    if (nextX < 0 || n - 1 < nextX || nextY < 0 || n - 1 < nextY)
                        continue;

                    if (visited[nextX][nextY])
                        continue;

                    if (arr[nextX][nextY] != 0 && arr[nextX][nextY] == arr[currentPoint.row][currentPoint.col])
                        continue;

                    queue.add(new Point(currentPoint.index, nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
class Point{
    int index;
    int row;
    int col;

    public Point(int index, int row, int col){
        this.index = index;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString(){
        return String.format("Point( index = %d, row = %d, col = %d )",this.index,this.row,this.col);
    }
}