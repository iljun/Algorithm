package BackJun_1238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int X;
	static List<Node>[] list;
	static List<Node>[] list2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		X = input.nextInt();

		list = new ArrayList[N + 1];
		list2 = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Node>();
			list2[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int weight = input.nextInt();
			list[x].add(new Node(y, weight));
			list2[y].add(new Node(x, weight));
		}

		int[] cost = new int[N + 1];

		Arrays.fill(cost, Integer.MAX_VALUE);
		int Xtemp = X;
		cost[Xtemp] = 0;

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(Xtemp, cost[Xtemp]));

		while (!queue.isEmpty()) {
			Xtemp = queue.poll().v2;

			for (int i = 0; i < list[Xtemp].size(); i++) {
				if (cost[list[Xtemp].get(i).v2] > list[Xtemp].get(i).weight + cost[Xtemp]) {
					cost[list[Xtemp].get(i).v2] = list[Xtemp].get(i).weight + cost[Xtemp];
					queue.offer(new Node(list[Xtemp].get(i).v2, cost[list[Xtemp].get(i).v2]));
				}
			}
		}


		int[] cost2 = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			if(i == X)
				continue;
			int start = i;
			Arrays.fill(cost2, Integer.MAX_VALUE);
			cost2[start] = 0;
			queue.offer(new Node(start, cost2[start]));

			while (!queue.isEmpty()) {
				start = queue.poll().v2;
				for (int j = 0; j < list[start].size(); j++) {
					if (cost2[list[start].get(j).v2] > list[start].get(j).weight + cost2[start]) {
						cost2[list[start].get(j).v2] = list[start].get(j).weight + cost2[start];
						queue.offer(new Node(list[start].get(j).v2, cost2[list[start].get(j).v2]));
					}
				}
			}

		}

		int maxIndex = 1;
		for(int i=2; i<cost.length; i++){
			if(cost[maxIndex]<cost[i])
				maxIndex = i;
		}

		System.out.println(cost[maxIndex]+cost2[X]);
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