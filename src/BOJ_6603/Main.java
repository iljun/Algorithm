package BOJ_6603;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        while(true){
            input = reader.readLine().split(" ");
            if(input[0].equals("0'"))
                break;

            List<Integer> list = new ArrayList<>();

            for(int i=1; i<input.length; i++){
                list.add(Integer.parseInt(input[i]));
            }


        }
    }
}
