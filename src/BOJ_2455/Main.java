package BOJ_2455;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int result=0;
        int max = Integer.MIN_VALUE;

        String[] inputs;
        for(int i=0; i<4; i++){
            inputs = reader.readLine().split(" ");
            result-=Integer.parseInt(inputs[0]);
            result+=Integer.parseInt(inputs[1]);
            max = Math.max(result,max);
        }

        writer.write(String.valueOf(max));

        reader.close();
        writer.flush();
        writer.close();
    }
}
