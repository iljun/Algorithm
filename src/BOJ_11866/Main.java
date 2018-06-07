package BOJ_11866;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 7
 * Time: 오후 2:52
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<n+1; i++)
            queue.add(i);

        StringBuilder builder = new StringBuilder();
        builder.append("<");
        int size = queue.size();
        for(int i=0; i<size; i++){
            for(int j=0; j<m-1; j++){
                queue.offer(queue.poll());
            }
            builder.append(queue.poll());
            if(!queue.isEmpty())
                builder.append(", ");
        }
        builder.append(">");
        System.out.println(builder.toString());
    }
}
