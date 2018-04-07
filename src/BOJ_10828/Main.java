package BOJ_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();

        String[] input;
        for(int i=0; i<N; i++){
            input = reader.readLine().split(" ");
            if(input[0].equals("push")) {
                int number = Integer.parseInt(input[1]);
                stack.push(number);
            }else if(input[0].equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else
                    System.out.println(stack.pop());
            }else if(input[0].equals("size")){
                System.out.println(stack.size());
            }else if(input[0].equals("empty")){
                if(stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }else if(input[0].equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else
                    System.out.println(stack.peek());
            }
        }
    }
}
