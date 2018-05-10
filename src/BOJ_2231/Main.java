package BOJ_2231;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 10
 * Time: 오후 4:25
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.parseInt(reader.readLine());

        writer.write(String.valueOf(solve(n)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(Integer n){
        int[] arr = new int[1000001];

        for(int i=1; i<10; i++){
            arr[i] = i;
        }

        for(int i=10; i<1000001; i++){
            int tmp=i;
            int result=i;
            while(tmp!=0){
                result+=tmp%10;
                tmp/=10;
            }
            arr[i] = result;
        }

        for(int i=1; i<n+1; i++){
            if(arr[i]==n)
                return i;
        }

        return 0;
    }
}
