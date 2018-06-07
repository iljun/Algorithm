package BOJ_10866;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 7
 * Time: 오후 3:04
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Deck deck = new Deck();
        int t = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        String[] input;
        while(t-->0){
            input = reader.readLine().split(" ");

            switch (input[0]){
                case "push_back" :
                    deck.pushBack(Integer.parseInt(input[1]));
                    break;
                case "push_front" :
                    deck.pushFront(Integer.parseInt(input[1]));
                    break;
                case "pop_front" :
                    builder.append(deck.popFront()).append("\n");
                    break;
                case "pop_back" :
                    builder.append(deck.popBack()).append("\n");
                    break;
                case "size" :
                    builder.append(deck.size()).append("\n");
                    break;
                case "empty" :
                    builder.append(deck.empty()).append("\n");
                    break;
                case "front" :
                    builder.append(deck.front()).append("\n");
                    break;
                case "back" :
                    builder.append(deck.back()).append("\n");
                    break;
            }
        }

        writer.write(builder.toString());
        reader.close();
        writer.flush();
        writer.close();
    }
}

class Deck{
    private List<Integer> list;

    public Deck(){
        this.list = new ArrayList<>();
    }

    public void pushFront(int value){
        list.add(0,value);
    }

    public void pushBack(int value){
        list.add(list.size(),value);
    }

    public Integer popFront(){
        if(list.isEmpty())
            return -1;
        return list.remove(0);
    }

    public Integer popBack(){
        if(list.isEmpty())
            return -1;
        return list.remove(list.size()-1);
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