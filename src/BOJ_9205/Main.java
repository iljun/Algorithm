package BOJ_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T;
    static int N;
    static boolean[] visited;
    static List<Point> list;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());

        while(T-->0){
            N = Integer.parseInt(reader.readLine());
            list = new ArrayList<>();
            String[] input = reader.readLine().split(" ");
            list.add(new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
            for(int i=0; i<N; i++){
                input = reader.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                list.add(new Point(x,y));
            }
            input = reader.readLine().split(" ");
            list.add(new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
            visited = new boolean[list.size()];
            DFS(0);

            if(!visited[list.size()-1])
                System.out.println("sad");
            else
                System.out.println("happy");
        }

    }

    public static void DFS(int index){
        visited[index] = true;
        Point currentPoint = list.get(index);
        for(int i=1; i<list.size(); i++){
            if(!visited[i]){
                Point nextPoint = list.get(i);
                if(Math.abs(currentPoint.x-nextPoint.x) + Math.abs(currentPoint.y-nextPoint.y) <= 50*20){
                    visited[i] = true;
                    DFS(i);
                }
            }
        }
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