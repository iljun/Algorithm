package BOJ_1920;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        N = Integer.parseInt(reader.readLine());
        input = reader.readLine().split(" ");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(Integer.parseInt(input[i]), 1);
        }

        N = Integer.parseInt(reader.readLine());
        input = reader.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (map.get(Integer.parseInt(input[i]))!=null)
                writer.write(String.valueOf(1) + "\n");
            else
                writer.write(String.valueOf(0) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

}

