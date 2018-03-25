package BOJ_1072;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s =null;
        while((s = reader.readLine()) != null){
            StringTokenizer stk =new StringTokenizer(s);

            long x = Long.parseLong(stk.nextToken());
            long y = Long.parseLong(stk.nextToken());

            long z = y*100/x;

            if(z==99){
                System.out.println(-1);
                continue;
            }


            int cnt=0;
            for(long i=0; x+i<=1000000000; i++){
                if(z<calcurate(x+i,y+i))
                    break;
                cnt++;
            }
            System.out.println(cnt);
        }

    }

    static long calcurate(long x, long y){
        return (y*100/x);
    }
}
