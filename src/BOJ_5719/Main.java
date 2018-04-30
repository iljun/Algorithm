package BOJ_5719;

import java.io.*;
import java.util.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 26
 * Time: 오후 2:00
 */
public class Main {

    public static void main(String[] args) throws IOException { //다음에 풀기
        new Main().input();
        //TODO dijkstra를 이용해 최단거리를 삭제후 다시 dijkstra를 이용해 거의 최단거리 구하기
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int start;
        int end;
        int u;
        int v;
        int p;
        List<Point>[] arr;
        while (n != 0 && m != 0) {
            input = reader.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);

            arr = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                input = reader.readLine().split(" ");
                u = Integer.parseInt(input[0]);
                v = Integer.parseInt(input[1]);
                p = Integer.parseInt(input[2]);
                arr[u].add(new Point(u, v, p));
            }

            dijkstra(n, start, end, arr);
            input = reader.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

        }

    }

    public void dijkstra(int n, int start, int end, List<Point>[] arr) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(-1, start, cost[start]));
        Queue<Point>[] minCostQueue = new LinkedList[n];
        for (int i = 0; i < n; i++)
            minCostQueue[i] = new LinkedList<>();

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            if (currentPoint.target == end)
                break;

            for (int i = 0; i < arr[currentPoint.target].size(); i++) {
                int index = arr[currentPoint.target].get(i).target;
                int nextCost = arr[currentPoint.target].get(i).cost;

                if (cost[index] > cost[currentPoint.target] + nextCost) {
                    cost[index] = cost[currentPoint.target] + nextCost;
                    Point p = new Point(currentPoint.target, index, cost[index]);
                    queue.offer(p);
                    System.out.println(p.toString());
                    minCostQueue[index].clear();
                    minCostQueue[index].add(p);
                } else if (cost[index] == cost[currentPoint.target] + nextCost) {
                    minCostQueue[index].add(new Point(currentPoint.target, index, cost[index]));
                }
            }
        }

        while(!minCostQueue[end].isEmpty()){
            Point rootPoint = minCostQueue[end].poll();
            int deleteIndex = rootPoint.start;
            for(int i=0; i<arr[deleteIndex].size(); i++){

            }

        }
        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i].toString());
            System.out.println(Arrays.toString(cost));
        }
        System.out.println("finish");
    }

}

class Point implements Comparable<Point> {
    int start;
    int target;
    int cost;

    public Point(int start, int target, int cost) {
        this.start = start;
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point p) {
        return this.cost - p.cost;
    }

    @Override
    public String toString() {
        return String.format("Point(start = %d, target = %d, cost = %d)", this.start, this.target, this.cost);
    }
}