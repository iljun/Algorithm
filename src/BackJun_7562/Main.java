package BackJun_7562;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[][] panel;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static List<Move> move = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        move.add(new Move(1,2));
        move.add(new Move(1,-2));
        move.add(new Move(2,1));
        move.add(new Move(2,-1));
        move.add(new Move(-1,2));
        move.add(new Move(-1,-2));
        move.add(new Move(-2,1));
        move.add(new Move(-2,-1));

        T = Integer.parseInt(reader.readLine());

        for(int i=0 ;i<T; i++){
            int l = Integer.parseInt(reader.readLine());
            panel = new int[l][l];

            String[] start = reader.readLine().split(" ");
            startX = Integer.parseInt(start[0]);
            startY = Integer.parseInt(start[1]);

            String[] end = reader.readLine().split(" ");
            endX = Integer.parseInt(end[0]);
            endY = Integer.parseInt(end[1]);

            Queue<Panel> queue = new LinkedList<>();
            queue.add(new Panel(startX,startY));

            for(int j=0; j<l; j++)
                Arrays.fill(panel[j],99999);

            panel[startX][startY] = 0;

            while(!queue.isEmpty()){
                Panel currentPanel = queue.poll();
                for(int j=0; j<8; j++){
                    int nextX= currentPanel.x + move.get(j).x;
                    int nextY= currentPanel.y + move.get(j).y;

                    if(0<=nextX && nextX< l && 0<=nextY && nextY<l){
                        if(panel[nextX][nextY]>panel[currentPanel.x][currentPanel.y]+1){
                            queue.add(new Panel(nextX, nextY));
                            panel[nextX][nextY] = panel[currentPanel.x][currentPanel.y] + 1;
                        }
                    }
                }
            }
            writer.write(panel[endX][endY]+"\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
class Panel{
    int x;
    int y;

    public Panel(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("Panel[ x = %d, y = %d ]",this.x,this.y);
    }
}
class Move{
    int x;
    int y;

    public Move(int x, int y){
        this.x = x;
        this.y = y;
    }
}