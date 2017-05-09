package BackJun_1197_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V;
	static int E;
	static PriorityQueue<Node> queue;
	static List<Node>[] list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		V = input.nextInt();
		E = input.nextInt();
		queue = new PriorityQueue<>();
		list = new ArrayList[V + 1];

		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList();

		for (int i = 0; i < E; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int weight = input.nextInt();
			Node temp = new Node(v1, v2, weight);
			list[v1].add(temp);
			list[v2].add(temp);
		}

		int start = 1;
		int count = 0;
		int result = 0;
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(visited, false);

		while (list[start].isEmpty()) {
			start++;
		}

		queue.addAll(list[start]);

		while (count<V-1) {

			for (int i = 0; i < list[start].size(); i++) {
				if (visited[list[start].get(i).v2] == false)
					queue.offer(list[start].get(i));
			}

			while(!queue.isEmpty()){
				Node min = queue.poll();
				if(visited[min.v2]==false){
					result += min.weight;
					start = min.v2;
					visited[min.v2] = true;
					count++;
					break;
				}
			}
		}

		System.out.println(result);
		input.close();

	}

}

class Node implements Comparable<Node> {
	int v1;
	int v2;
	int weight;

	public Node(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n) {
		if (this.weight > n.weight)
			return 1;
		return -1;
	}
}
