package BOJ_5214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N + M +1; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M ; i++) {
            int dummy = N + i;
            input = reader.readLine().split(" ");
            for (int k = 0; k < K; k++) {
                int node = Integer.parseInt(input[k]);
                list.get(dummy).add(node);
                list.get(node).add(dummy);
            }
        }
        int result = BFS(list);
        System.out.println(result);
    }

    public static int BFS(ArrayList<ArrayList<Integer>> list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[M + N + 1];
        visited[1] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                Integer current = queue.poll();

                if (current == N) {
                    return cnt;
                }

                for (int x : list.get(current)) {
                    if (!visited[x]) {
                        visited[x] = true;
                        queue.offer(x);
                    }
                }
            }
        }

        return -1;
    }
}

class Point {
    int nextPoint;

    public Point(int nextPoint) {
        this.nextPoint = nextPoint;
    }

    @Override
    public String toString() {
        return String.format("Point( x = %d )", this.nextPoint);
    }
}