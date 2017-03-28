package BackJun_1753;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Dijkstra {
	static List<Node>[] list;
	static int[] min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int v = input.nextInt();
		int e = input.nextInt();
		int start = input.nextInt();

		list= new ArrayList[v+1];
		min = new int[v+1];

		for(int i=1; i<=v; i++)
			list[i]=new ArrayList<Node>();

		int target;
		int w;
		int x;
		for(int i=1; i<=e; i++){
			x = input.nextInt();
			target = input.nextInt();
			w=input.nextInt();
			list[x].add(new Node(target,w));
		}

		for(int i=1; i<=v; i++)
			min[i]=Integer.MAX_VALUE;

		PriorityBlockingQueue<Node> q = new PriorityBlockingQueue<Node>();
		min[start]=0;
		q.offer(new Node(start,min[start]));

		while(!q.isEmpty()){
			start = q.peek().target;
			q.poll();

			for(int j=0; j<list[start].size(); j++){
				int index = list[start].get(j).target;
				if(min[index]>min[start]+list[start].get(j).w){
					min[index]=min[start]+list[start].get(j).w;
					q.offer(new Node(index,min[index]));
				}
			}
		}

		for(int i=1; i<=v; i++){
			if(min[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(min[i]);
		}
	}
}

class Node implements Comparable<Node>{
	int target;
	int w;

	public Node(int target, int w){
		this.target = target;
		this.w = w;
	}

	@Override
	public int compareTo(Node n){
		if(this.w <= n.w){
			return -1;
		}else
			return 1;
	}

}