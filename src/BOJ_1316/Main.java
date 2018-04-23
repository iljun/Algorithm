package BOJ_1316;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String input;

        int result=0;
        while(n-->0){
            input = reader.readLine();
            result+=solve(input);
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(String input){
        boolean[] visited = new boolean[26];
        // a==97
        int index=0;
        char ch;
        while(true){
            ch = input.charAt(index);
            if(visited[ch-97])
                return 0;

            if(index+1 ==input.length())
                break;

            if(ch!=input.charAt(index+1))
                visited[ch-97] = true;

            index++;
        }

        return 1;
    }
}
