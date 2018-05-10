package BOJ_10448;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 10
 * Time: 오후 4:45
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    static int[] arr = new int[45];
    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<45; i++){
            arr[i] = i + arr[i-1];
        }

        int t = Integer.parseInt(reader.readLine());
        int k;

        while(t-->0){
            k = Integer.parseInt(reader.readLine());

            writer.write(String.valueOf(solve(k))+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int k){
        for(int i=1; i<45; i++){
            for(int j=1; j<45; j++){
                for(int z=1; z<45; z++){
                    if(arr[i]+arr[j]+arr[z]==k)
                        return 1;
                }
            }
        }

        return 0;
    }
}
