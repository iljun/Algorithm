package BackJun_2188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] capacity;
	static int[][] flow;
	static List<Integer>[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		list = new ArrayList[N + M + 2];
		capacity = new int[N + M + 2][N + M + 2];
		flow = new int[N + M + 2][N + M + 2];

		for (int i = 0; i < N + M + 2; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N + 1; i++)
			list[0].add(i);

		for (int i = N + 1; i < M + N + 2; i++){
			list[i].add(N + M + 2);
		}

		for (int i = 1; i < N + 1; i++) {
			int temp = input.nextInt();
			for (int j = 1; j < temp + 1; j++) {
				int x = input.nextInt();
				list[i].add(x+N);
				list[x+N].add(i);
				capacity[i][x+N] = 1;
			}
		}

		input.close();

		int total = 0;
		int start = 0;
		int end = N + M + 2;

		while (true) {
			int[] prev = new int[200];
			Arrays.fill(prev, -1);
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(start);
			while (!queue.isEmpty()) {
				int front = queue.poll();
				for (int x : list[front]) {
					if (capacity[front][x] - flow[front][x] > 0 && prev[x] == -1) {
						queue.add(x);
						prev[x] = front;
						if (x == end)
							break;
					}
				}
			}

			System.out.println("Break");

			if (prev[end] == -1)//prev[end]가 무조건 -1 끝점 방문 X
				break;

			System.out.println("break2");

			for (int i = end; i != start; i = prev[i]) {
				flow[prev[i]][i]++;
				flow[i][prev[i]]--;
			}

			total++;
			System.out.println(Arrays.deepToString(flow));
		}

		System.out.println(total);
	}

}
