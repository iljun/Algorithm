package BOJ_9372;

import java.awt.image.ImagingOpException;
import java.io.*;
import java.util.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 6
 * Time: 오후 2:55
 */
public class Main {

    //굳이 BFS가 필요없는 문제
    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());

        while(t-->0){
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            List<Contry>[] arr = new ArrayList[n+1];
            for(int i=1; i<n+1; i++)
                arr[i]=new ArrayList<>();

            for(int i=0; i<m; i++){
                input = reader.readLine().split(" ");
                int begin = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                Contry contry = new Contry(begin,end);
                Contry contry1 = new Contry(end,begin);
                arr[begin].add(contry);
                arr[end].add(contry1);
            }
//
//            int result=Integer.MAX_VALUE;
//            for(int i=1; i<n+1; i++){
//                result = Math.min(result,BFS(n,m,arr,i));
//                System.out.println("result : "+ " " + i +" : " + result);
//            }
            writer.write(String.valueOf(n-1)+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

//    public int BFS(int n, int m, List<Contry>[] arr, int start){
//        Queue<Contry> queue = new LinkedList<>();
//        queue.addAll(arr[start]);
//        boolean[] visited = new boolean[n+1];
//        visited[start] = true;
//
//        while(!queue.isEmpty()){
//
//            int size = queue.size();
//            for(int i=0; i<size; i++){
//
//                Contry currentContry = queue.poll();
//
//                Contry nextContry = new Contry(currentContry.x,arr[currentContry.y],currentContry.cnt+1);
//                queue.add(new Contry(currentContry.x,currentContry.y,currentContry.cnt+1));
//
//                visited[currentContry.y] = true;
//
//                if(checkVistied(visited))
//            }
//        }
//        return -1;
//    }
//
//    public boolean checkVistied(boolean[] visited){
//        for(int i=1 ; i<visited.length; i++){
//            if(!visited[i])
//                return false;
//        }
//        return true;
//    }

}

class Contry{
    int x;
    int y;
    int cnt;
    public Contry(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Contry(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}