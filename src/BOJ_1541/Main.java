package BOJ_1541;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 3
 * Time: 오후 1:49
 */
public class Main{
    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = reader.readLine().split("-");
        writer.write(String.valueOf(solve(arr)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(String[] arr){
        List<Integer> resultList = new ArrayList<>();

        for(int i=0; i<arr.length;i++){
            int tmp=0;
            if(arr[i].contains("+")){
                String[] t = arr[i].split("\\+");
                for(int j=0; j<t.length; j++){
                    tmp+=Integer.valueOf(t[j]);
                }
                resultList.add(tmp);
            }else{
                resultList.add(Integer.parseInt(arr[i]));
            }
        }

        int result = resultList.get(0);
        for(int i=1;i<resultList.size(); i++){
            result-=resultList.get(i);
        }

        return result;
    }
}
