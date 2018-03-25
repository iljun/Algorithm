package BOJ_1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        if(N<100){
            System.out.println(N);
            return ;
        }
        int cnt=0;
        for(int i=100; i<=N;i++){
            List<Integer> list = new ArrayList<>();
            String s = String.valueOf(i);
            for(int j=0; j<s.length();j++){
                list.add(s.charAt(j)-'0');
            }

            boolean t = true;
            int r = list.get(0) - list.get(1);
            for(int j=1; j<list.size()-1; j++){
                if(list.get(j)-list.get(j+1)!=r){
                    t = false;
                    break;
                }
            }
            if(t) {
                cnt++;
            }
        }

        System.out.println(cnt+99);
    }
}
