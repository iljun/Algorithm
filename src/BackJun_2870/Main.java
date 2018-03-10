package BackJun_2870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<BigDecimal> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        for(int i=0; i<N; i++){
            char[] tmp = reader.readLine().toCharArray();
            StringBuilder builder = new StringBuilder();
            for(int j=0; j<tmp.length; j++) {
                if (Character.isAlphabetic(tmp[j])) {
                    if(builder.length()!=0){
                        arr.add(new BigDecimal(builder.toString()));
                        builder.delete(0,builder.length());
                    }
                }else{
                    builder.append(tmp[j]);
                }

                if(j==tmp.length-1 && builder.length()!=0){
                    arr.add(new BigDecimal(builder.toString()));
                }
            }
        }

        Collections.sort(arr);
        for(BigDecimal s : arr){
            System.out.println(s);
        }
    }
}
