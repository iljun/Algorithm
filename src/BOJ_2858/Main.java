package BOJ_2858;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int r;
        int b;

        String[] input = reader.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        writer.write(solve(r,b));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int r, int b){
        long rowSize = 2;
        long colSize = 1;

        List<Measure> measureList = new ArrayList<>();
        for(int i=1; i<=b; i++){
            if(b%i==0){
                measureList.add(new Measure(i,b/i));
            }
        }

        for(Measure measure : measureList){
            if((measure.measure2+2)*2+(measure.measure1*2)==r){
                rowSize = measure.measure2+2;
                colSize = measure.measure1+2;
                break;
            }
        }
        return String.valueOf(rowSize + " " + colSize);
    }
}

class Measure{
    long measure1;
    long measure2;

    public Measure(long m1, long m2){
        this.measure1 = m1;
        this.measure2 = m2;
    }

    @Override
    public String toString(){
        return String.format("Measure( measure1 = %d , measure2 = %d)",this.measure1,this.measure2);
    }
}