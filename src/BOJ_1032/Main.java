package BOJ_1032;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        String[] inputs = new String[n];

        for(int i=0; i<n;i++){
            inputs[i] = reader.readLine();
        }
        if(n==1)
            writer.write(inputs[0]);
        else
            writer.write(solve(n,inputs));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n,String[] inputs){
        boolean[] check = new boolean[inputs[0].length()];
        Arrays.fill(check,true);

        for(int i=0; i<check.length; i++){
            for(int j=0;j<n-1; j++){
                if(inputs[j].charAt(i)!=inputs[j+1].charAt(i)){
                    check[i] = false;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<check.length; i++){
            if(check[i]){
                builder.append(inputs[0].charAt(i));
            }else{
                builder.append("?");
            }
        }
        return builder.toString();
    }
}
