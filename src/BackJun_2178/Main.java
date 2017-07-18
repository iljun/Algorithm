package BackJun_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String tempLine = input.nextLine();
		N = Integer.parseInt(tempLine.split(" ")[0]);
		M = Integer.parseInt(tempLine.split(" ")[1]);
		arr = new int[N+1][M+1];
		visited = new int[N+1][M+1];

		for(int i =1; i < N+1; i++){
			String line = input.nextLine();
			for(int j=0 ; j<M; j++){
				arr[i][j+1] = Integer.parseInt(line.substring(j,j+1));
			}
		}

		Queue<Map> queue = new LinkedList<Map>();
		queue.offer(new Map(1,1));
		visited[1][1] =1;

		while(!queue.isEmpty()){
			Map temp = queue.poll();

			if(temp.x-1 > 0 && arr[temp.x-1][temp.y]==1 && visited[temp.x-1][temp.y]==0){
				queue.offer(new Map(temp.x-1,temp.y));
				visited[temp.x-1][temp.y] += visited[temp.x][temp.y]+1;
			}

			if(temp.x+1<=N && arr[temp.x+1][temp.y]==1 && visited[temp.x+1][temp.y]==0){
				queue.offer(new Map(temp.x+1,temp.y));
				visited[temp.x+1][temp.y] += visited[temp.x][temp.y]+1;
			}

			if(temp.y-1 > 0 && arr[temp.x][temp.y-1]==1 && visited[temp.x][temp.y-1]==0){
				queue.offer(new Map(temp.x,temp.y-1));
				visited[temp.x][temp.y-1] += visited[temp.x][temp.y]+1;
			}

			if(temp.y+1 <= M && arr[temp.x][temp.y+1]==1 && visited[temp.x][temp.y+1]==0){
				queue.offer(new Map(temp.x,temp.y+1));
				visited[temp.x][temp.y+1] += visited[temp.x][temp.y]+1;
			}
		}

		System.out.println(visited[N][M]);
		input.close();
	}

}
class Map{
	int x;
	int y;

	public Map(int x, int y){
		this.x = x;
		this.y = y;
	}
}