package BOJ_1753;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int startPoint = Integer.parseInt(reader.readLine());

        List<Point>[] list = new ArrayList[v+1];
        for(int i=1; i<v+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            input = reader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            list[start].add(new Point(end,cost));
        }

        int[] result = dijkstra(v,startPoint,list);

        for(int i=1; i<result.length; i++){
            if(result[i]==Integer.MAX_VALUE)
                writer.write("INF\n");
            else
                writer.write(String.valueOf(result[i])+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public int[] dijkstra(int v, int start, List<Point>[] list){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int[] cost = new int[v+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[start] = 0;

        queue.offer(new Point(start,cost[start]));

        while(!queue.isEmpty()){
            Point target = queue.poll();

            for(int i=0; i<list[target.end].size(); i++){
                int index = list[target.end].get(i).end;
                if(cost[index]> cost[target.end] + list[target.end].get(i).cost){
                    cost[index] = cost[target.end] + list[target.end].get(i).cost;
                    queue.offer(new Point(index,cost[index]));
                }
            }
        }

        return cost;
    }
}

class Point implements Comparable<Point>{
    int end;
    int cost;

    public Point(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return String.format("Point( end = %d, cost = %d)",this.end,this.cost);
    }

    @Override
    public int compareTo(Point p){
        return this.cost-p.cost;
    }
}