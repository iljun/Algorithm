package BOJ_2644;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] family;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        family = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            family[i] = new ArrayList<>();
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int child = Integer.parseInt(tokenizer.nextToken());
        int parent = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        M = Integer.parseInt(tokenizer.nextToken());

        for(int i=0; i<M;i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int parent1 = Integer.parseInt(tokenizer.nextToken());
            int child1 = Integer.parseInt(tokenizer.nextToken());
            family[parent1].add(child1);
            family[child1].add(parent1);
        }

        int result = BFS(child,parent);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public static int BFS(int child, int parent){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(child);
        boolean[] visited = new boolean[N+1];
        visited[child] = true;

        int cnt=-1;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                Integer currentInteger = queue.poll();
                if(currentInteger==parent){
                    return cnt;
                }

                for(int j=0; j<family[currentInteger].size();j++){
                    if(!visited[family[currentInteger].get(j)]){
                        queue.offer(family[currentInteger].get(j));
                        visited[family[currentInteger].get(j)]=true;
                    }
                }
            }
        }

        return -1;
    }
}