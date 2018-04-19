package BOJ_2602;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = reader.readLine();

        String angel = reader.readLine();
        String devil = reader.readLine();

        writer.write(String.valueOf(solve(string, angel, devil)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public long solve(String string, String angel, String devil) {
        int[][] dp = new int[2][angel.length()];
        // 0 angel
        // 1 devil

        String[] index = string.split("");
        String[] angelList = angel.split("");
        String[] devilList = devil.split("");

        for (int j = 0; j < angelList.length; j++) {
            if (index[0].equals(angelList[j])) {
                dp[0][j]++;
            }
            if (index[0].equals(devilList[j])) {
                dp[1][j]++;
            }
        }

        for(int i=1; i<index.length; i++){
            for(int j=0; j<angelList.length; j++){
                if(index[i].equals(angelList[j])) {
                    int cnt = 0;
                    for(int k=j-1; k>=0; k--){
                        if(index[i-1].equals(devilList[k]) && dp[1][k]!=0)
                            cnt++;
                    }
                    dp[0][j] = cnt;
                }

                if(index[i].equals(devilList[j])){
                    int cnt = 0;
                    for(int k=j-1; k>=0; k--){
                        if(index[i-1].equals(angelList[k]) && dp[0][k]!=0)
                            cnt++;
                    }
                    dp[1][j] = cnt;
                }
            }
        }
        long result=0;

        for(int i=0; i<angelList.length; i++){
            if(angelList[i].equals(index[index.length-1])){
                result+= dp[0][i];
            }
            if(devilList[i].equals(index[index.length-1])){
                result+= dp[1][i];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return result;
    }
}
