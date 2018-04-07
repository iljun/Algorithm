package DFS;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    static List<List<Integer>> list;//인접 리스트
    static int N;
    static boolean[] visited;
    public void DFS(int x){
        visited[x] = true;

        for(int i=0; i<list.get(x).size(); i++){
            if(!visited[list.get(x).get(i)]){
                DFS(list.get(x).get(i));
            }
        }
    }
}
