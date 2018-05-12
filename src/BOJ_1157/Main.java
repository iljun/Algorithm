package BOJ_1157;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오전 11:48
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Alphabet> list = new ArrayList<>();
        for(char i='a'; i<='z';i++){
            list.add(new Alphabet(String.valueOf(i)));
        }

        String[] input = reader.readLine().split("");
        for(int i=0; i<input.length; i++){
            char tmp = Character.valueOf(input[i].toLowerCase().charAt(0));
            list.get(tmp-97).cnt++;
        }

        Collections.sort(list);

        if(list.get(0).cnt==list.get(1).cnt){
            writer.write("?");
        }else{
            writer.write(list.get(0).index.toUpperCase());
        }

        reader.close();
        writer.flush();
        writer.close();

    }
}
class Alphabet implements Comparable<Alphabet>{
    String index;
    int cnt;

    public Alphabet(String index){
        this.index = index;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Alphabet o) {
        return o.cnt - this.cnt;
    }

    @Override
    public String toString(){
        return String.format("Alphabet( index = %s, cnt = %d)",this.index,this.cnt);
    }
}