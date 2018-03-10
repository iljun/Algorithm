package BOJ_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String N;
    static List<String> arr;
    static int[] alphanet;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = reader.readLine();
        arr = new ArrayList<>();
        alphanet = new int[26];
        int odd = 0;
        int oddIndex = -1;
        for (int i = 0; i < N.length(); i++) {
            alphanet[N.charAt(i) - 65]++;
        }

        for (int i = 0; i < alphanet.length; i++) {
            if (alphanet[i] % 2 != 0) {
                odd++;
                oddIndex = i;
            }
        }


        if (odd > 1 || (N.length() % 2 != 0 && odd == 0)) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < alphanet.length; i++) {
                int cnt = alphanet[i]/2;
                for (int j = 0; j < cnt; j++) {
                    if(i==oddIndex && alphanet[i]==1) {
                        break;
                    }else{
                        builder.append(Character.toString((char) (i + 65)));
                        alphanet[i]--;

                    }
                }
            }

            if(odd==1) {
                builder.append((char) (oddIndex + 65));
                alphanet[oddIndex]--;
            }

            for (int i = alphanet.length-1; i >= 0; i--) {
                if(alphanet[i]>0) {
                    while(alphanet[i]!=0){
                        builder.append(Character.toString((char)(i+65)));
                        alphanet[i]--;
                    }
                }
            }
            System.out.println(builder.toString());
        }

        reader.close();
    }

}
