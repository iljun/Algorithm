package BackJun_1931;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		PriorityQueue<Node> queue = new PriorityQueue<Node>();

		for (int i = 0; i < N; i++) {
			int start = input.nextInt();
			int end = input.nextInt();
			queue.offer(new Node(start, end));
		}

		Node node = queue.poll();
		int x = node.end;

		int count = 1;

		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.start >= x) {
				x = node.end;
				count++;
			}
			System.out.print(node.start + " ");
			System.out.println(node.end);
		}

		System.out.println(count);
	}

}

class Node implements Comparable<Node> {
	int start;
	int end;

	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Node n) {
		if (this.end != n.end)
			return this.end > n.end ? 1 : -1;
		else {
			return this.start > n.start ? 1 : -1;
		}
	}
}
