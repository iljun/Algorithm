package test23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int TC;

    public static void main(String[] args) throws IOException { //O(N+M)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(reader.readLine());

        String n;
        String pattern;
        String[] input;

        for (int i = 0; i < TC; i++) {
            input = reader.readLine().split(" ");
            pattern = input[0];
            n = input[1];

            String result = match(n, pattern);
            System.out.println(result);
        }
    }

    public static String match(String n, String pattern) {
        int j = 0;
        for (int i = 0; i < pattern.length() && j < n.length(); i++) {
            if ('a' <= pattern.charAt(i) && pattern.charAt(i) <= 'z') {
                if (n.charAt(j) != pattern.charAt(i))
                    return "X";
                j++;
            } else if (pattern.charAt(i) == '?') {
                j++;
            } else if (pattern.charAt(i) == '*') {
                if (pattern.charAt(i + 1) == '?') {
                    if(i+2==pattern.length())
                        return "O";

                    for (; j < n.length(); j++) {

                        if (pattern.charAt(i + 2) == n.charAt(j)) {
                            i++;
                            break;
                        }
                    }

                } else {
                    for (; j < n.length(); j++) {
                        if (pattern.charAt(i + 1) != n.charAt(j) || j == n.length() - 1)
                            break;
                    }
                    i = i + 1;
                    continue;
                }
            }else
                return "X";
        }

        return "O";
    }

}