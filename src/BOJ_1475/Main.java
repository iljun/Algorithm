package BOJ_1475;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();

        writer.write(String.valueOf(solve(input)));

        reader.close();
        writer.flush();
        writer.close();
    }

    static int[] set = {1,1,1,1,1,1,1,1,1,1};//6과 9는 공통
    public int solve(String input){
        char[] tmp = input.toCharArray();
        int[] count = new int[10];

        for(int i=0; i<count.length; i++)
            count[i] = set[i];

        int result = 1;
        for(int i=0; i<tmp.length; i++){
            int t = tmp[i]-48;

            if(count[t]==0){
                if(t==6){
                    if(count[9]==0){
                        for(int j=0; j<count.length; j++){
                            count[j] += set[j];
                        }
                        result++;
                        count[t]--;
                    }else{
                        count[9]--;
                    }
                }else if(t==9){
                    if(count[6]==0){
                        for(int j=0; j<count.length; j++){
                            count[j] += set[j];
                        }
                        result++;
                        count[t]--;
                    }else
                        count[6]--;
                }else{
                    for(int j=0; j<count.length; j++){
                        count[j] += set[j];
                    }
                    result++;
                    count[t]--;
                }
            }else{
                count[t]--;
            }

        }

        return result;
    }
}
