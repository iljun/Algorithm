package BOJ_1325;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    static List<Computer>[] arr;
    static int n;
    private void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new ArrayList[n+1];

        for(int i=1; i<n+1; i++)
            arr[i] = new ArrayList<>();

        int[] result = new int[n+1];

        for(int i=0; i<m; i++){
            input = reader.readLine().split(" ");
            int me = Integer.parseInt(input[0]);
            int next = Integer.parseInt(input[1]);
            arr[next].add(new Computer(next,me));
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++){
            result[i] = BFS(i);
            max = Math.max(result[i],max);
        }

        for(int i=1; i<n+1; i++){
            if(result[i]==max)
                writer.write(i + " ");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    private int BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        int cnt=0;
        while(!queue.isEmpty()){
            Integer current = queue.poll();

            for(int i=0; i<arr[current].size(); i++){
                if(!visited[arr[current].get(i).next]){
                    queue.add(arr[current].get(i).next);
                    visited[arr[current].get(i).next]=true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
class Computer{
    int me;
    int next;

    public Computer(int me, int next){
        this.me = me;
        this.next = next;
    }

    @Override
    public String toString(){
        return String.format("Computer( me = %d , next = %d )",this.me,this.next);
    }
}