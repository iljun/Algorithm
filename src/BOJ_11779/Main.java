package BOJ_11779;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Point>[] list;
    static List<Point>[] result;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        list = new ArrayList[N + 1];
        result = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int index = input.nextInt();
            int end = input.nextInt();
            int cost = input.nextInt();
            list[index].add(new Point(end, cost));
        }

        int start = input.nextInt();
        int end = input.nextInt();

        dijkstra(start, end);

    }

    public static void dijkstra(int start, int end) {
        long[] distance = new long[N + 1];
        int[] route = new int[N + 1];

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start,0));

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for(Point point : list[currentPoint.end]){
                if(distance[point.end] > distance[currentPoint.end] + point.cost){
                    distance[point.end] = distance[currentPoint.end] + point.cost;
                    route[point.end] = currentPoint.end;
                    queue.offer(point);
                }
            }

        }
        System.out.println(distance[end]);
        Stack<Integer> stack = new Stack<>();
        int tmp = end;
        while(tmp>=start){
            stack.push(tmp);
            tmp = route[tmp];
        }
        System.out.println(stack.size());
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pop()+" ");
        }
        System.out.println(builder.toString());
    }
}

class Point implements Comparable<Point> {
    int end;//도착점
    int cost;//비용

    public Point(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point p1) {
        return this.cost - p1.cost;
    }

    @Override
    public String toString() {
        return String.format("Point( end = %d , cost = %d)", this.end, this.cost);
    }
}
