package BOJ_2533;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 2
 * Time: 오후 12:09
 */
public class Main {

    public static void main(String[] args) throws IOException{
        //해당 노드가 얼리어답터라면 자식은 모두 얼리어답터가 아니다.
        //해당 노드가 얼리어답터가 아니라면 자식은 모두 얼리어답터이어야 하다.
        //재귀가 편할듯
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<SNS>[] list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++)
            list[i] = new ArrayList<>();

        String[] input;
        for(int i=0; i<n-1; i++){
            input = reader.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            list[u].add(new SNS(u,v));
            list[v].add(new SNS(v,u));
        }

        long result = Integer.MAX_VALUE;
        for(int i=1; i<n+1;i++){
            result = Math.min(result,solve(n,list,i));
            System.out.println(list[i].toString());
        }
    }

    public static int solve(int n,List<SNS>[] list, int i){//i번이 얼리어답터가 아닌경우
        int cnt=0;
        boolean[] visited = new boolean[n+1];
        visited[i] = true;
        for(int j=0;j<list[i].size(); j++){
            cnt++;
            visited[list[i].get(j).v]=true;
        }

        for(int index=1; index<list.length; index++){

        }
        return cnt;
    }

//    public static List<SNS>
}
class SNS{
    int u;
    int v;

    public SNS(int u, int v){
        this.u= u;
        this.v= v;
    }

    @Override
    public String toString(){
        return String.format("SNS( v = %d)",this.v);
    }
}