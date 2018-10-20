package BOJ_11967;

import java.io.*;
import java.util.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 6. 15
 * Time: 오후 5:18
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int m;

        String[] input = reader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        Set<Point> pointSet = new TreeSet<>();

        for(int i=0; i<m; i++){
            input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int nextX = Integer.parseInt(input[2]);
            int nextY = Integer.parseInt(input[3]);
            Point newPoint = new Point(x,y);
        }
    }
}

class Point{
    int x;
    int y;
    List<Point> nextPoint;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.nextPoint = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x,this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point))
            return false;

        Point point = (Point)obj;

        if(this.x == point.x && this.y == point.y)
            return true;

        return false;
    }
}