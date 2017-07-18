package BackJun_10989;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0; i<N; i++)
			queue.offer(input.nextInt());
		input.close();

		while(!queue.isEmpty())
			System.out.println(queue.poll());
	}


}
