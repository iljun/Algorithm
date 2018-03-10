package BackJun_1389;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static List<Integer>[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        result = new int[N+1];
        arr = new ArrayList[N+1];
        for(int i=0; i<M+1; i++){
            arr[i]= new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] tmp = reader.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);

            arr[x].add(y);
            arr[y].add(x);
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++) {
                check = new boolean[N + 1];
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                check[i] = true;
                int cnt = 1;
                while (!queue.isEmpty()) {
                    int tmp = queue.poll();
                    for (int k = 0; k < arr[tmp].size(); k++) {
                        if (!check[arr[tmp].get(k)]) {
                            queue.offer(arr[tmp].get(k));
                            check[arr[tmp].get(k)] = true;
                            if (result[arr[tmp].get(k)] < cnt)
                                result[tmp] = cnt;
                        }
                    }
                    cnt++;
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
