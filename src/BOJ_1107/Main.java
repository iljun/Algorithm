package BOJ_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    static int N;
    static int M;

    static int channel = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        HashMap<Integer,Boolean> hashMap = new LinkedHashMap<>();

        if (N == channel) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < 10; i++) {
            hashMap.put(i,true);
        }

        if(M!=0) {
            String[] input = reader.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                hashMap.put(Integer.parseInt(input[i]), false);
            }
        }
        long result = plusMinus();

        for(int i=0; i<=999999; i++){
            boolean flag = false;
            String current = String.valueOf(i);
            int len = current.length();

            for (int j = 0; j < len; j++) {
                int value=current.charAt(j)-48;
                if(!hashMap.get(value)){
                    flag=true;
                    break;
                }
            }

            if(!flag){
                if(result>Math.abs(i-N)+len){
                    result = Math.abs(i - N) + len;
                }
            }

        }
        System.out.println(result);
    }

    static int plusMinus(){
        return Math.abs(N-channel);
    }

}
