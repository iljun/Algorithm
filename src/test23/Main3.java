package test23;

import java.io.*;
import java.util.Stack;

public class Main3 {
    static int N;
    static Stack<Integer> enqueue;
    static Stack<Integer> dequeue;
    public static void main(String[] args) throws IOException{//O(N)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());

        enqueue = new Stack<>();
        dequeue = new Stack<>();

        String[] input;
        for(int i=0; i<N; i++){
            input = reader.readLine().split(" ");
            if(input[0].equals("ENQUEUE")){
                enqueue(input[1]);
            }else{
                writer.write(String.valueOf(dequeue())+"\n");
            }
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public static void enqueue(String input){
        enqueue.push(Integer.parseInt(input));
    }

    public static int dequeue(){
        while(enqueue.size()>1){
            dequeue.push(enqueue.pop());
        }

        int result = enqueue.pop();

        while(!dequeue.isEmpty()){
            enqueue.push(dequeue.pop());
        }

        return result;
    }
}
