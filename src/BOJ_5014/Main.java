package BOJ_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        F = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        G = Integer.parseInt(tokenizer.nextToken());
        U = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken());

        visited = new boolean[F+1];

        BFS();
        if(!visited[G])
            System.out.println("use the stairs");
    }

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;

        int cnt=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            for(int i=0; i<size; i++){
                Integer current = queue.poll();

                if(current==G){
                    System.out.println(cnt-1);
                    return ;
                }

                if(current+U<F+1 && !visited[current+U]){
                    visited[current+U] = true;
                    queue.offer(current+U);
                }

                if(0<=current-D && !visited[current-D]){
                    visited[current-D] = true;
                    queue.offer(current-D);
                }
            }
        }
    }
}
