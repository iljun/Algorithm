package BOJ_1916;

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

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        List<Bus>[] list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++)
            list[i]=new ArrayList<>();

        String[] input;
        for(int i=0; i<m; i++){
            input = reader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            list[start].add(new Bus(target,cost));
        }

        input = reader.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        writer.write(String.valueOf(dijkstra(n,start,end,list)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int dijkstra(int v, int start, int end, List<Bus>[] list){
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        int[] cost = new int[v+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[start] = 0;

        queue.add(new Bus(start,cost[start]));

        while(!queue.isEmpty()){
            Bus current = queue.poll();

            for(int i=0; i<list[current.target].size(); i++){
                int index = list[current.target].get(i).target;
                int w = list[current.target].get(i).cost;
                if(cost[index]> cost[current.target] + w){
                    cost[index] = cost[current.target] + w;
                    queue.offer(new Bus(index,cost[index]));
                }
            }
        }

        return cost[end];

    }
}
class Bus implements Comparable<Bus>{
    int target;
    int cost;

    public Bus(int target, int cost){
        this.target = target;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return String.format("Bus( target = %d, cost = %d )",this.target,this.cost);
    }

    @Override
    public int compareTo(Bus b){
        return this.cost = b.cost;
    }
}