package BOJ_12761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int A;
    static int B;
    static long result = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);
        M = Integer.parseInt(input[3]);
        visited = new boolean[100001];
        BFS();
        if(N==M)
            System.out.println(0);
        else
            System.out.println(result-1);
    }

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            for(int i=0; i<size; i++){
                Integer currentPoint = queue.poll();

                if(currentPoint==M)
                    return ;

                if(currentPoint+1<=100000 && !visited[currentPoint+1]) {
                    visited[currentPoint+1] = true;
                    queue.offer(currentPoint + 1);
                }

                if(0 <= currentPoint-1 && !visited[currentPoint-1]) {
                    visited[currentPoint-1] = true;
                    queue.offer(currentPoint - 1);
                }

                if(currentPoint+A<=100000 && !visited[currentPoint+A]) {
                    visited[currentPoint+A] = true;
                    queue.offer(currentPoint + A);
                }

                if(currentPoint+B<=100000 && !visited[currentPoint+B]) {
                    visited[currentPoint+B] = true;
                    queue.offer(currentPoint + B);
                }

                if(0<=currentPoint-A && !visited[currentPoint-A]) {
                    visited[currentPoint-A] = true;
                    queue.offer(currentPoint - A);
                }

                if(0<=currentPoint-B && !visited[currentPoint-B]) {
                    visited[currentPoint-B] = true;
                    queue.offer(currentPoint - B);
                }

                if(currentPoint*A<=100000 && !visited[currentPoint*A]) {
                    visited[currentPoint*A] = true;
                    queue.offer(currentPoint * A);
                }

                if(currentPoint*B<=100000 && !visited[currentPoint*B]) {
                    visited[currentPoint*B] = true;
                    queue.offer(currentPoint * B);
                }

                if(0<=-currentPoint*A && !visited[-currentPoint*A]) {
                    visited[-currentPoint*A] = true;
                    queue.offer(-currentPoint * A);
                }

                if(0<=-currentPoint*B && !visited[-currentPoint*B]) {
                    visited[-currentPoint*B] = true;
                    queue.offer(-currentPoint * B);
                }
            }
        }

    }
}
