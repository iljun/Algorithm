package BOJ_13549;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;
    static final int SIZE = 100001;
    static int[] arr = new int[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        Arrays.fill(arr, -1);
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        Queue<Integer> queue = new LinkedList<>();

        arr[N] = 0;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int j=0; j<size; j++) {
                Integer currentPoint = queue.poll();

                if (currentPoint == K) {
                    break;
                }

                if (currentPoint*2 < SIZE) {
                    if(arr[currentPoint*2]==-1){
                        arr[currentPoint*2] = arr[currentPoint];
                        queue.offer(currentPoint*2);
                    }
                }

                if (currentPoint + 1 < SIZE) {
                    if (arr[currentPoint + 1] == -1) {
                        arr[currentPoint + 1] = arr[currentPoint] + 1;
                        queue.offer(currentPoint + 1);
                    }
                }

                if (0 <= currentPoint - 1) {
                    if (arr[currentPoint - 1] == -1) {
                        arr[currentPoint - 1] = arr[currentPoint] + 1;
                        queue.offer(currentPoint - 1);
                    }
                }
            }
        }

        writer.write(String.valueOf(arr[K]));

        reader.close();
        writer.flush();
        writer.close();

    }
}