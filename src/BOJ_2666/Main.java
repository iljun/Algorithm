package BOJ_2666;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException{//다시 도전
        new Main().input();
    }

    static int[] open;
    static int n;
    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());

        open = new int[2];
        String[] input = reader.readLine().split(" ");
        open[0] = Integer.parseInt(input[0]);
        open[1] = Integer.parseInt(input[1]);

        int m = Integer.parseInt(reader.readLine());

        int[] visited = new int[m];
        for(int i=0; i<m; i++){
            visited[i] = Integer.parseInt(reader.readLine());
        }

        int result = 0;
        for(int i=0; i<m ;i++){
            result+=BFS(visited[i]);
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int BFS(int target){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,open[0]));
        queue.add(new Point(1,open[1]));
        boolean[] visited = new boolean[n+1];
        visited[open[0]] = true;
        visited[open[1]] = true;

        int cnt=-1;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point openDore = queue.poll();

                System.out.println(target+ " "+openDore.number +" " +Arrays.toString(open));
                if (openDore.number == target) {
                    open[openDore.idx] = openDore.number;
                    return cnt;
                }

                int next = openDore.number + 1;
                if (next <= n && next >= 0) {
                    if (!visited[next]) {
                        queue.add(new Point(openDore.idx, next));
                        visited[next] = true;
                    }
                }

                next = openDore.number - 1;

                if (next <= n && next >= 0) {
                    if (!visited[next]) {
                        queue.add(new Point(openDore.idx, next));
                        visited[next] = true;
                    }
                }
            }
        }

        return 0;
    }
}

class Point{
    int idx;
    int number;

    public Point(int idx, int number){
        this.idx = idx;
        this.number = number;
    }
}
