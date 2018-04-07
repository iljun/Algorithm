package BOJ_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int T;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException { // 시간초과
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine());

        String[] input;
        while (T-- > 0) {
            input = reader.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            List<Node> list = new ArrayList<>();
            input = reader.readLine().split(" ");

            for (int i = 1; i < N + 1; i++) {
                list.add(new Node(i, Integer.parseInt(input[i - 1])));
            }

            for (int i = 0; i < K; i++) {
                input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]) - 1;
                int end = Integer.parseInt(input[1]) - 1;
                list.get(end).parentNode.add(list.get(start));
            }

            int finishNumber = Integer.parseInt(reader.readLine());

            Queue<Node> queue = new LinkedList<>();
            queue.offer(list.get(finishNumber - 1));
            long result = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max=0;
                for (int i = 0; i < size; i++) {
                    Node tmp = queue.poll();
                    max = Math.max(max,tmp.time);

                    if (tmp.parentNode.size() == 0)
                        continue;

                    List<Node> t = tmp.parentNode;

                    for (Node n : t) {
                        queue.offer(n);
                    }
                }
                result+=max;
            }

            System.out.println(result);
        }
    }
}

class Node {
    int index;
    int time;
    List<Node> parentNode;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
        this.parentNode = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Node( index = %d, time = %d , childNode = %s", this.index, this.time, this.parentNode.toString());
    }
}