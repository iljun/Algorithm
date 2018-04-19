package BOJ_9466;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    static int[] team;
    static boolean[] visited;
    static boolean[] finished;
    static int result;
    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        while(t-->0){
            int n = Integer.parseInt(reader.readLine());

            team = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];

            String[] input = reader.readLine().split(" ");
            for(int i=1 ;i<n+1; i++){
                int student = Integer.parseInt(input[i-1]);
                team[i] = student;
            }

            result = 0;
            for(int i=1 ; i<n+1; i++) {
                if(!visited[i])
                    DFS(i);
            }

            writer.write(String.valueOf(n-result)+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    private void DFS(int me){
        visited[me] = true;
        int next = team[me];

        if(visited[next]){
            if(!finished[next]){
                for(int tmp = next; tmp!=me; tmp = team[tmp]) {
                    result++;
                }
                result++;
            }
        }else
            DFS(next);

        finished[me] = true;
    }
}
