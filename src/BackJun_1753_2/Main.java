package BackJun_1753_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int V;
	static List<Node>[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		V = input.nextInt();

		list = new ArrayList[N+1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<Node>();
		}

		for(int i=0; i<M; i++){
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int weight = input.nextInt();
			list[v1].add(new Node(v2,weight));
		}

		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[V]=0;

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(V,cost[V]));

		while(!queue.isEmpty()){
			V = queue.poll().v2;

			for(int i=0; i<list[V].size(); i++){
				if(cost[list[V].get(i).v2]> cost[V] + list[V].get(i).weight){
					cost[list[V].get(i).v2] = cost[V] + list[V].get(i).weight;
					queue.offer(new Node(list[V].get(i).v2,cost[list[V].get(i).v2]));
				}
			}
		}

		for(int i=1; i<cost.length; i++){
			if(cost[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(cost[i]);
		}
		input.close();
	}

}
class Node implements Comparable<Node>{
	int v2;
	int weight;

	public Node(int v2, int weight){
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n){
		if(this.weight > n.weight)
			return 1;
		else
			return -1;
	}
}