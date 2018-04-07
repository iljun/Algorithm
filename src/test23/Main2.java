package test23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int TC;
    static int W;
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(reader.readLine());
        String[] input;
        int cnt=1;

        while(--TC>0){
            System.out.println("#"+(cnt++));

            W = Integer.parseInt(reader.readLine());
            N = Integer.parseInt(reader.readLine());
            dp = new int[N+1][W+1];

            List<Weight> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                input = reader.readLine().split(" ");
                list.add(new Weight(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
            }


//            dp[0][0] = 1;
//
//            for(int i=1; i<=list.size(); i++){//추 종류
//                for(int j=0; j<=list.get(i-1).count; j++){//추 갯수
//                    for(int k=0; k<=W; k++){// 추로 만들수 있는 무게
//                        if(k+list.get(i-1).weight*j>W)
//                            break;
//
//                        dp[i][k+list.get(i-1).weight*j]+=dp[i-1][k];
//                        if(k==W){
//                            System.out.println(i + " " + j + " " + k);
////                            System.out.println(k+list.get(i-1).weight*j);
//                        }
//                    }
//                }
//            }


        }
    }
}
class Weight {
    int weight;
    int count;

    public Weight(int weight, int count){
        this.weight = weight;
        this.count = count;
    }

    @Override
    public String toString(){
        return String.format("Weight(weight = %d, count = %d)",this.weight,this.count);
    }
}