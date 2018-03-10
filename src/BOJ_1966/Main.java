package BOJ_1966;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = reader.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            Queue<Document> queue = new LinkedList<>();

            input = reader.readLine().split(" ");

            List<Integer> maxValue = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int important = Integer.parseInt(input[j]);
                maxValue.add(important);
                Document tmp = new Document(j, important);
                queue.add(tmp);
            }
            Collections.sort(maxValue,Collections.reverseOrder());

            int result = 0;
            while (true) {
                ++result;
                queue = relocation(queue,maxValue.get(result-1));

                Document tmp = queue.poll();
                if (tmp.index == M) {
                    break;
                }

            }

            System.out.println(result);
        }

        reader.close();
    }

    static Queue<Document> relocation(Queue<Document> queue ,int maxValue){

        while (true) {
            Document tmp = queue.peek();
            if (tmp.important == maxValue) {
                break ;
            } else {
                tmp = queue.poll();
                queue.offer(tmp);
            }
        }

        return queue;
    }
}

class Document implements Comparable<Document> {
    int index;
    int important;

    public Document(int index, int important) {
        this.index = index;
        this.important = important;
    }

    @Override
    public int compareTo(Document d1) {
        return d1.important - this.important;
    }

    @Override
    public String toString() {
        return String.format("Document(index = %d, important = %d)", this.index, this.important);
    }
}
