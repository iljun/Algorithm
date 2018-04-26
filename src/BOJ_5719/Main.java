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
        queue.offer(new Point(start, start, cost[start]));
        Queue<Point>[] mincostQueue = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            mincostQueue[i] = new LinkedList<>();
        }

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int startPoint = currentPoint.start;
            int endPoint = currentPoint.target;
            int pointCost = currentPoint.cost;

            if (cost[endPoint] < currentPoint.cost)
                continue;

            if (endPoint == end)
                break;

            for (int i = 0; i < arr[currentPoint.target].size(); i++) {
                int index = arr[currentPoint.target].get(i).target;//다음 index
                int nextCost = arr[currentPoint.target].get(i).cost;//다음 이동cost

                if (cost[index] > cost[endPoint] + nextCost) {
                    System.out.println(currentPoint.toString());
                    cost[index] = cost[endPoint] + nextCost;
                    queue.offer(new Point(startPoint, index, cost[index]));

                    mincostQueue[endPoint].clear();
                    mincostQueue[endPoint].offer(new Point(startPoint, index, cost[index]));
                } else {
                    mincostQueue[endPoint].offer(new Point(startPoint, index, cost[index]));
                }
            }
        }

        System.out.println(Arrays.toString(cost));
        for (int i = 0; i < n; i++) {
            System.out.println(mincostQueue[i].toString());
        }
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