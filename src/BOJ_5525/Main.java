package BOJ_5525;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        String characterString = reader.readLine();

        int result=0;
        for(int i=0; i<M; i++){
            if(characterString.charAt(i+1)=='I' && characterString.charAt(i+2)=='O'){

            }

        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }
}
