package BackJun_1504;

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

		list = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 1; i < M + 1; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int weight = input.nextInt();
			list[x].add(new Node(y, weight));
			list[y].add(new Node(x, weight));
		}

		int start = input.nextInt();
		int end = input.nextInt();

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		int[] cost = new int[N + 1];

		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[1] = 0;
		queue.add(new Node(1, cost[1]));
		int x = 1;
		while (!queue.isEmpty()) {
			x = queue.poll().v2;

			for (int i = 0; i < list[x].size(); i++) {
				if (cost[list[x].get(i).v2] > list[x].get(i).weight + cost[x]) {
					cost[list[x].get(i).v2] = list[x].get(i).weight + cost[x];
					queue.offer(new Node(list[x].get(i).v2, cost[list[x].get(i).v2]));
				}
			}
		}

		int[] cost2 = new int[N + 1];
		int[] cost3 = new int[N + 1];

		Arrays.fill(cost2, Integer.MAX_VALUE);
		Arrays.fill(cost3, Integer.MAX_VALUE);

		cost2[start] = 0;
		queue.add(new Node(start, cost2[start]));
		while (!queue.isEmpty()) {
			x = queue.poll().v2;
			for (int i = 0; i < list[x].size(); i++) {
				if (cost2[list[x].get(i).v2] > list[x].get(i).weight + cost2[x]) {
					cost2[list[x].get(i).v2] = list[x].get(i).weight + cost2[x];
					queue.offer(new Node(list[x].get(i).v2, cost2[list[x].get(i).v2]));
				}
			}
		}

		cost3[end] = 0;
		queue.add(new Node(end, cost3[end]));
		while (!queue.isEmpty()) {
			x = queue.poll().v2;
			for (int i = 0; i < list[x].size(); i++) {
				if (cost3[list[x].get(i).v2] > list[x].get(i).weight + cost3[x]) {
					cost3[list[x].get(i).v2] = list[x].get(i).weight + cost3[x];
					queue.offer(new Node(list[x].get(i).v2, cost3[list[x].get(i).v2]));
				}
			}
		}

		int result1 = cost[start]+cost2[end]+cost3[N];
		int result2 = cost[start]+cost3[start]+cost2[N];

		if(result1>=Integer.MAX_VALUE || result2>=Integer.MAX_VALUE)
			System.out.println(-1);
		else if(result1<result2)
			System.out.println(result1);
		else
			System.out.println(result2);
		input.close();
	}

}

class Node implements Comparable<Node> {
	int v2;
	int weight;

	public Node(int v2, int weight) {
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n) {
		if (this.weight > n.weight)
			return 1;
		else
			return -1;
	}
}