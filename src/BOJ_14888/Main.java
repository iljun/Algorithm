package BOJ_14888;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    static int n;
    static int[] arr;
    static Operator[] operators;
    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        String[] input;
        operators = new Operator[4];
        operators[0] = new Operator("+");
        operators[1] = new Operator("-");
        operators[2] = new Operator("*");
        operators[3] = new Operator("/");

        input = reader.readLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        input = reader.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i].cnt = Integer.parseInt(input[i]);
        }

        DFS(1,arr[0]);

        writer.write(String.valueOf(max)+"\n");
        writer.write(String.valueOf(min)+"\n");
        reader.close();
        writer.flush();
        writer.close();
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public void DFS(int depth, int sum){
        if(depth == n){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
        }

        for(int i=0; i<4; i++){
            if(operators[i].cnt!=0){
                operators[i].cnt--;
                switch (operators[i].operator){
                    case "+" :
                        DFS(depth+1, sum+arr[depth]);
                        break;
                    case "-" :
                        DFS(depth +1 , sum-arr[depth]);
                        break;
                    case "*" :
                        DFS(depth+1, sum*arr[depth]);
                        break;
                    case "/" :
                        DFS(depth+1, sum/arr[depth]);
                        break;
                }
                operators[i].cnt++;
            }
        }
    }

}

class Operator {
    String operator;
    int cnt;

    public Operator(String operator) {
        this.operator = operator;
        this.cnt = 0;
    }

    @Override
    public String toString() {
        return String.format("Operator( operator = %s, cnt = %d)", this.operator, this.cnt);
    }
}