package BackJun_1774;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static List<Node>[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		Arrays.fill(visited, false);

		list = new ArrayList[N+1];
		for(int i=1; i<list.length; i++)
			list[i] = new ArrayList();

		for(int i=0; i<N; i++){
			int x = input.nextInt();
			int y = input.nextInt();
			Node temp = new Node(x,y);
			list[x].add(temp);
			list[y].add(temp);
		}

		for(int i=0; i<M; i++){
			int x = input.nextInt();
			int y = input.nextInt();
			visited[x]=true;
			visited[y]=true;
		}

		int count=M;
		int start = 1;
		while(visited[start]){
			start++;
		}

		double result = 0.0;

		for(int i=1; i<visited.length; i++){
			if(visited[i]==false){
				for(int j=0; j<list[i].size(); j++){
					if(!queue.contains(list[i].get(j)))
						queue.offer(list[i].get(j));
				}
			}
		}

		while(count<N-1){//큐에서 작은값을 계산

		}

		System.out.printf("%.2f", result);
		input.close();
	}

}

class Node implements Comparable<Node>{
	double x;
	double y;

	public Node(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node n){
		if(this.y-this.x > n.y-n.x)
			return 1;
		return -1;
	}
}
