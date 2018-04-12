package BOJ_13913;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int N;
    static int K;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Arrays.fill(arr,-1);
        if(N==K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }
        int result = BFS();
        writer.write(String.valueOf(result)+"\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(K);

        while(K!=N){
            stack.push(arr[K]);
            K = arr[K];
        }

        while(!stack.isEmpty()){
            writer.write(String.valueOf(stack.pop())+" ");
        }

        reader.close();

        writer.flush();
        writer.close();
    }

    public static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = N;

        int cnt=-1;
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            for(int i=0; i<size; i++){
                Integer currentPoint = queue.poll();
                if(currentPoint==K)
                    return cnt;

                if(currentPoint+1<100001 && arr[currentPoint+1]==-1){
                    arr[currentPoint+1] = currentPoint;
                    queue.offer(currentPoint+1);
                }

                if(currentPoint-1 >=0 && arr[currentPoint-1]==-1){
                    arr[currentPoint-1] = currentPoint;
                    queue.offer(currentPoint-1);
                }

                if(currentPoint*2<100001 && arr[currentPoint*2]==-1){
                    arr[currentPoint*2] = currentPoint;
                    queue.offer(currentPoint*2);
                }
            }
        }
        return cnt;
    }
}
