package BOJ_2211;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 27
 * Time: 오후 1:19
 */
public class Main {
    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<Point>[] arr = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1; i<m+1; i++){
            input = reader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            arr[start].add(new Point(target,cost));
//            arr[target].add(new Point(start,cost));
        }

        writer.write(solve(n,m,arr));
        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, int m, List<Point>[] arr){
        int[][] result = new int[n+1][n+1];
        List<Result> list = new ArrayList<>();
        for(int i=1; i<n+1; i++){
            result[i] = dijkstra(n,i,n+1,arr);
        }


        for(int i=1; i<n+1;i++)
            System.out.println(Arrays.toString(result[i]));

        for(int i=2; i<n+1; i++){
            int min = Integer.MAX_VALUE;
            Result tmp = null;
            for(int j=1; j<n+1; j++){
                if(min>result[j][i] && result[j][i]!=0){
                    min = result[j][i];
                    tmp = new Result(j,i);
                }
            }
            if(tmp!=null)
                list.add(tmp);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(list.size()).append("\n");
        for(int i=0; i<list.size();i++){
            builder.append(list.get(i).start + " " + list.get(i).end+"\n");
        }
        return builder.toString();
    }

    public int[] dijkstra(int n, int start, int end, List<Point>[] arr){
        int[] cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[start] = 0;

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(start,cost[start]));

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            if(currentPoint.target==end)
                break;

            if(cost[currentPoint.target] > currentPoint.cost)
                continue;

            for(int i=0; i<arr[currentPoint.target].size(); i++){
                int nextIndex = arr[currentPoint.target].get(i).target;
                int nextCost = arr[currentPoint.target].get(i).cost;

                if(cost[nextIndex] > cost[currentPoint.target] + nextCost){
                    cost[nextIndex] = cost[currentPoint.target] + nextCost;
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
    public int compareTo(Point p){
        return this.cost - cost;
    }
}

class Result{
    int start;
    int end;
    public Result(int start, int end){
        this.start = start;
        this.end = end;
    }
}