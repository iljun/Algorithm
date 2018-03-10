package BOJ_2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static int N;
    static int[] arr;
    static List<Input> list;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        arr = new int[999];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String[] input = reader.readLine().split(" ");
            int number = Integer.parseInt(input[0]);
            int strike = Integer.parseInt(input[1]);
            int ball = Integer.parseInt(input[2]);
            list.add(new Input(number,strike,ball));
        }

        int cnt=0;

        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                for(int k=1; k<10; k++){
                    if(i==j || i==k || j==k)
                        continue;

                    boolean check = true;
                    for(Input input : list){
                        int n1 = input.number/100;
                        int n2 = input.number%100/10;
                        int n3 = input.number%100%10;

                        int strCnt=0;
                        int balCnt=0;

                        if(n1 == i){
                            strCnt++;
                        }else if(i == n2 || i == n3) {
                            balCnt++;
                        }

                        if(n2 ==j){
                            strCnt++;
                        }else if(j==n1 || j ==n3)
                            balCnt++;

                        if(n3 == k){
                            strCnt++;
                        }else if(k==n1 || k==n2){
                            balCnt++;
                        }

                        if(strCnt!=input.strike || balCnt!=input.ball) {
                            check = false;
                            break;
                        }
                    }

                    if(check)
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean validate(int o1, int o2, int o3, int n1, int n2, int n3, int strike, int ball) {

        int strCnt = 0;
        int balCnt = 0;

        if (o1 == n1 || o2 == n2 || o3 == n3)
            strCnt++;

        if (o1 == n2 || o1 == n3 || o2 == n1 || o2 == n3 || o3 == n1 || o3 == n2) {
            balCnt++;
        }

        if (strCnt == strike && balCnt == ball) {
            return true;
        }

        return false;
    }
}

class Input{
    int number;
    int strike;
    int ball;

    public Input(int number, int strike, int ball){
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}
