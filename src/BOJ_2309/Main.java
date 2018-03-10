package BOJ_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Integer> list;
    static final int TOTAL_HEIGHT = 100;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        list= new ArrayList<>();

        int sum = 0;
        for(int i=0; i<9; i++){
            int height = Integer.parseInt(reader.readLine());
            list.add(height);
            sum+=height;
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(i==j)
                    continue;
                if(sum - list.get(i) - list.get(j)==TOTAL_HEIGHT){
                    list.set(i,-1);
                    list.set(j,-1);
                    break;
                }

            }
        }

        Collections.sort(list);
        for(int i = 2; i<9 ;i++)
            System.out.println(list.get(i));
    }
}
