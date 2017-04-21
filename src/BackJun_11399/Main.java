package BackJun_11399;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N=input.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for(int i=0; i<N; i++){
			int x = input.nextInt();
			queue.offer(x);
		}

		int[] result= new int[queue.size()];
		int i=0;
		while(!queue.isEmpty()){
			int x =queue.poll();
			result[i]=x;
			i++;
		}

		int c =0;
		for(int j=0; j<result.length; j++){
			for(int k=0; k<=j; k++){
				c+=result[k];
			}
		}
		System.out.println(c);
	}

}
