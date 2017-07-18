package BackJun_1260;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int V;
	static ArrayList<ArrayList<Integer>> list;
	static StringBuilder builder;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		builder = new StringBuilder();

		N = input.nextInt();
		M = input.nextInt();
		V = input.nextInt();

		list = new <ArrayList<Integer>>ArrayList();

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}

		visited = new boolean[N + 1];
		DFS(V);
		builder.append("\n");
		visited = new boolean[N +1];
		BFS(V);

		System.out.println(builder.toString());
		input.close();
	}

	static void DFS(int v) {
		builder.append(v + " ");
		visited[v] = true;
		for (int i = 0; i < list.get(v).size(); i++) {
			if (visited[list.get(v).get(i)] == false) {
				DFS(list.get(v).get(i));
			}
		}
	}

	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		while (!queue.isEmpty()) {
			v = queue.poll();
			builder.append(v + " ");
			visited[v] = true;

			for (int i = 0; i < list.get(v).size(); i++) {
				if (visited[list.get(v).get(i)] == false) {
					queue.offer(list.get(v).get(i));
					visited[list.get(v).get(i)] = true;
				}
			}
		}
	}

}