package BOJ_7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;
    static List<Human> list = new ArrayList<>();
    static List<Human> result = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        for(int i=0; i<N; i++){
            String[] input = reader.readLine().split(" ");
            list.add(new Human(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
        }

       for(int i=0; i<N; i++){
           Human tmp = list.get(i);
           int cnt=1;
           for(int j=0; j<N; j++){
               if(list.get(j).height>tmp.height && list.get(j).weight>tmp.weight){
                   cnt++;
               }
           }
           tmp.rank=cnt;
           list.set(i,tmp);
       }

       for(Human human : list){
           System.out.print(human.rank+ " ");
       }
    }
}

class Human {
    int height;
    int weight;
    int rank;

    public Human(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return String.format("Human(height = %d, weight = %d, rank = %d)",this.height,this.weight,this.rank);
    }
}