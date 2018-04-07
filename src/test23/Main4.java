package test23;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main4 {
    static int TC;
    static int N;
    static int[] E;
    static int[] C;

    public static void main(String[] args) throws IOException {//O(N^2)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = Integer.parseInt(reader.readLine());

        String[] input;
        while (TC-- > 0) {
            N = Integer.parseInt(reader.readLine());

            E = new int[N];
            C = new int[N];

            input = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                E[i] = Integer.parseInt(input[i]);
            }

            input = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                C[i] = Integer.parseInt(input[i]);
            }

            int result = -1;

            for (int i = 0; i < N; i++) {
                int tmp = BFS(i);
                if (tmp != -1) {
                    result = i;
                    break;
                }
            }


            writer.write(String.valueOf(result) + "\n");

        }
        reader.close();
        writer.flush();
        writer.close();
    }

    public static int BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        int min = E[x];
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            cnt++;
            if (cnt != 1) {
                if (current == x) {
                    return x;
                }
            }

            if (current + 1 == N) {
                current = 0;
            }

            if (current + 1 < N + 1) {
                if (min - C[current] >= 0) {
                    queue.offer(current + 1);
                    min = min - C[current] + E[current + 1];
                }
            }

        }

        return -1;
    }
}

class Recharger {
    int index;
    int charge;

    public Recharger(int index, int charge) {
        this.index = index;
        this.charge = charge;
    }
}