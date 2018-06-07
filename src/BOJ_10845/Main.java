package BOJ_10845;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 7
 * Time: 오후 2:40
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    static List<Integer> list = new LinkedList<>();
    static final String POP = "pop";
    static final String PUSH = "push";
    static final String SIZE = "size";
    static final String FRONT = "front";
    static final String BACK = "back";
    static final String EMPTY = "empty";

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        String[] input;
        StringBuilder builder = new StringBuilder();
        while(t-->0){
            input = reader.readLine().split(" ");
            int result;
            switch (input[0]){
                case POP :
                    result = pop();
                    builder.append(result).append("\n");
                    break;
                case PUSH :
                    push(Integer.parseInt(input[1]));
                    break;
                case SIZE :
                    result = size();
                    builder.append(result).append("\n");
                    break;
                case FRONT :
                    result = front();
                    builder.append(result).append("\n");
                    break;
                case BACK :
                    result = back();
                    builder.append(result).append("\n");
                    break;
                case EMPTY :
                    result = empty();
                    builder.append(result).append("\n");
                    break;
            }
        }
        writer.write(builder.toString());

        reader.close();
        writer.flush();
        writer.close();
    }

    public void push(Integer key){
        list.add(key);
    }

    public Integer pop(){
        if(list.isEmpty()){
            return -1;
        }
        return list.remove(0);
    }

    public Integer size(){
        return list.size();
    }

    public Integer empty(){
        if(list.isEmpty())
            return 1;
        return 0;
    }

    public Integer front(){
        if(list.isEmpty())
            return -1;
        return list.get(0);
    }

    public Integer back(){
        if(list.isEmpty())
            return -1;
        return list.get(list.size()-1);
    }
}
