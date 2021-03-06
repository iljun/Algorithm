package BOJ_1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static List<Point>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N + 1; i++) {
            input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            Point tmp = new Point(x,y,z);
            list[x].add(tmp);
        }

        input = reader.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        System.out.println(BFS(start,end));
    }

    public static int BFS(int start, int end){
        Queue<Point> queue = new LinkedList<>();
        queue.addAll(list[start]);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        int result=0;
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
        }

        return result;
    }
}

class Point {
    int x;
    int y;
    int weight;

    public Point(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return String.format("Point( x = %d, y=%d, weight=%d)",this.x,this.y,this.weight);
    }
}
