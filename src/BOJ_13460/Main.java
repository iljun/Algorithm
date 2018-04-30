package BOJ_13460;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 30
 * Time: 오후 1:04
 */
public class Main {
    //TODO 중복코드 제거 및 다시풀기
    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[][] arr = new String[n][m];

        Ball redBall = null;
        Ball blueBall = null;
        Ball finished = null;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = input[j];
                if (arr[i][j].equals("R")) {
                    redBall = new Ball(i, j);
                }

                if (arr[i][j].equals("B")) {
                    blueBall = new Ball(i, j);
                }

                if (arr[i][j].equals("O")) {
                    finished = new Ball(i, j);
                }
            }
        }

        writer.write(String.valueOf(solve(n, m, arr, redBall, blueBall, finished)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int n, int m, String[][] arr, Ball redBall, Ball blueBall, Ball finished) {
        int[] xMove = {-1, 1, 0, 0};//상하
        int[] yMove = {0, 0, -1, 1};//좌우
        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[redBall.x][redBall.y][blueBall.x][blueBall.y]=true;

        Queue<Ball> redBallQueue = new LinkedList<>();
        Queue<Ball> blueBallQueue = new LinkedList<>();
        redBallQueue.add(redBall);
        blueBallQueue.add(blueBall);
        int cnt = 0;
        while (cnt < 11) {
            cnt++;

            Ball currentRedBall = redBallQueue.poll();//나가야됨
            Ball currentBlueBall = blueBallQueue.poll();
            if(arr[currentRedBall.x][currentRedBall.y].equals("O"))
                return cnt;

            for (int i = 0; i < 4; i++) {// i==0 상 i==1 하 i==2 좌 i==3 우
                int redBallNextX = currentRedBall.x;
                int redBallNextY = currentRedBall.y;
                int blueBallNextX = currentBlueBall.x;
                int blueBallNextY = currentBlueBall.y;

                while (!arr[redBallNextX+xMove[i]][redBallNextY+yMove[i]].equals("#") && !arr[redBallNextX+xMove[i]][redBallNextY+yMove[i]].equals("O")) {//한번에 이동하는 최대 수
                    redBallNextX += xMove[i];
                    redBallNextY += yMove[i];
                }

                while (!arr[blueBallNextX+xMove[i]][blueBallNextY+yMove[i]].equals("#") && !arr[blueBallNextX+xMove[i]][blueBallNextY+yMove[i]].equals("O")) {
                    blueBallNextX += xMove[i];
                    blueBallNextY += yMove[i];
                }

                if(redBallNextX==blueBallNextX && redBallNextY==blueBallNextY) {
                    if(arr[redBallNextX][redBallNextY].equals("O"))
                        continue;
                    if((Math.abs(redBallNextX-blueBallNextX)+Math.abs(redBallNextY-blueBallNextY)) > (Math.abs(blueBallNextX-redBallNextX)+Math.abs(blueBallNextY-redBallNextY))) {
                        redBallNextX -= xMove[i];
                        redBallNextY -= yMove[i];
                    } else {
                        blueBallNextX -= xMove[i];
                        blueBallNextY -= yMove[i];
                    }
                }
                if(arr[blueBallNextX][blueBallNextY].equals("O"))
                    continue;

                if(!visited[redBallNextX][redBallNextY][blueBallNextX][blueBallNextY]) {
                    visited[redBallNextX][redBallNextY][blueBallNextX][blueBallNextY] = true;
                    redBallQueue.add(new Ball(redBallNextX,redBallNextY));
                    blueBallQueue.add(new Ball(blueBallNextX,blueBallNextY));
                }
            }
        }

        return -1;
    }
}

class Ball {
    int x;
    int y;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("Ball( x = %s, y = %d)",this.x,this.y);
    }
}