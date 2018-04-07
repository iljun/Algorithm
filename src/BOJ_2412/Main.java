package BOJ_2412;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int T;
    static List<Point> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException { // 시간초과
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);

        list = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            list.add(new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        Collections.sort(list, new PointComparator());

        int result = BFS(new Point(0, 0));

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public static int BFS(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Point currentPoint = queue.poll();

            if (currentPoint.y == T)
                return result;

            result++;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < list.size(); j++) {
                    Point nextPoint = new Point(Math.abs(list.get(j).x - currentPoint.x), Math.abs(list.get(j).y - currentPoint.y));

                    if (nextPoint.x <= 2 && nextPoint.y <= 2 && !visited[j]) {
                        queue.add(list.get(j));
                        visited[j] = true;
                    }
                }
            }

        }

        return -1;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Point( x = %d, y = %d)", this.x, this.y);
    }


}

class PointComparator implements Comparator<Point>{
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.y == p2.y) {
            return p1.x - p2.x;
        }
        return p1.y - p2.y;
    }
}