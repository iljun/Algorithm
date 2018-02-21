package BackJun_7469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int Q;
    static List<Arr> arr;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        Q = input.nextInt();
        arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            arr.add(new Arr(i+1,input.nextInt()));
        }

        Collections.sort(arr);

        String result ="";
        for(int i=0; i<Q; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int index = input.nextInt();
            int cnt = 0;
            for(int j=0; j<N; j++){
                Arr a = arr.get(j);
                if(a.index>=start && a.index<=end)
                    cnt++;
                if(cnt==index) {
                    result += a.number + "\n";
                    break;
                }
            }
        }
        System.out.println(result);

    }
}
class Arr implements Comparable<Arr>{
    int index;
    int number;

    public Arr(int index, int number){
        this.index = index;
        this.number = number;
    }

    @Override
    public int compareTo(Arr arr){
        return this.number-arr.number;
    }

    @Override
    public String toString(){
        return String.format("index: %d, number: %d",this.index,this.number);
    }
}