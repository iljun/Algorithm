package BOJ_7453;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{ // 다시시도
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];

        String[] input;
        for(int i=0; i<n; i++){
            input = reader.readLine().split(" ");
            A[i] = Integer.parseInt(input[0]);
            B[i] = Integer.parseInt(input[1]);
            C[i] = Integer.parseInt(input[2]);
            D[i] = Integer.parseInt(input[3]);
        }


        List<Long> X = new ArrayList<>();
        List<Long> Y = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                X.add(A[i]+B[j]);
                Y.add(C[i]+D[j]);
            }
        }

        Collections.sort(X);
        Collections.sort(Y,Collections.reverseOrder());

        writer.write(solve(X,Y));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(List<Long> X, List<Long> Y){
        long cnt=0;
        int YIndex = 0;

        for(int i=0; i<X.size(); i++){
            for(int j=YIndex; j<Y.size(); j++){
                if(X.get(i)+Y.get(j)==0){
                    cnt++;
                    YIndex=j;
                    break;
                }
            }
            if(YIndex==Y.size()-1)
                break;
        }

        return String.valueOf(cnt);
    }
}
