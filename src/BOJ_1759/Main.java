package BOJ_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int L;
    static int C;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        list = new ArrayList<>();

        input = reader.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            list.add(input[i]);
        }
        Collections.sort(list);
        DFS(0, 0, "");

    }

    public static void DFS(int start, int cnt, String tmp) {
        if (start == C) {
            if (cnt == L) {
                if (check(tmp)) {
                    System.out.println(tmp);
                }
            }
            return;
        }

        DFS(start + 1, cnt + 1, tmp + list.get(start));
        DFS(start + 1, cnt, tmp);
    }

    public static boolean check(String tmp) {
        int cnt = 0;
        for (int i = 0; i < tmp.length(); i++) {
            char character = tmp.charAt(i);
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
                cnt++;
        }

        if (0 < cnt && 1 < tmp.length() - cnt)
            return true;
        return false;
    }
}
