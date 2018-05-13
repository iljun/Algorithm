package BOJ_1764;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 13
 * Time: 오후 4:06
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int m;

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            list1.add(reader.readLine());
        }

        for(int i=0; i<m; i++){
            list2.add(reader.readLine());
        }

        writer.write(solve(list1,list2));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(List<String> list1, List<String> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        List<String> result = new ArrayList<>();
        for(int i=0; i<list1.size(); i++){
            if(Collections.binarySearch(list2,list1.get(i))>-1)
                result.add(list1.get(i));
        }

        StringBuilder builder = new StringBuilder();
        builder.append(result.size()).append("\n");

        for(int i=0; i<result.size(); i++){
            builder.append(result.get(i)).append("\n");
        }


        return builder.toString();
    }
}
