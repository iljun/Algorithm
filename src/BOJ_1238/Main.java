package BOJ_1238;

import javafx.scene.layout.Priority;

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

        String[] input;

        input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        List<Point>[] list = new ArrayList[n+1];
        for(int i =1; i<n+1; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            input = reader.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            list[index].add(new Point(target,cost));
        }

        int max = Integer.MIN_VALUE;
        int[] result = dijkstra(n,x,list);
        for(int i=1; i<n+1; i++){
            if(i==x)
                continue;
            int[] tmp = dijkstra(n,i,list);
            max = Math.max(result[i]+tmp[x],max);
        }

        writer.write(String.valueOf(max));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int[] dijkstra(int v, int index, List<Point>[] list){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int[] cost = new int[v+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[index] = 0;

        queue.offer(new Point(index,cost[index]));

        while(!queue.isEmpty()){
            Point current = queue.poll();

            for(int i=0; i<list[current.target].size(); i++){
                int nextIndex = list[current.target].get(i).target;
                int nextCost = list[current.target].get(i).cost;
                if(cost[nextIndex]> cost[current.target] + nextCost){
                    cost[nextIndex] = cost[current.target] + nextCost;
                    queue.offer(new Point(nextIndex,cost[nextIndex]));
                }
            }
        }
        return cost;
    }
}
class Point implements Comparable<Point>{
    int target;
    int cost;

    public Point(int target, int cost){
        this.target = target;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return String.format("Point ( target = %d, cost = %d )", this.target, this.cost);
    }

    @Override
    public int compareTo(Point p){
        return this.cost - p.cost;
    }
}
