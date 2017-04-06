package Backjun_1715;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int size = input.nextInt();

		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

		int x;

		for(int i=0; i<size; i++){
			x=input.nextInt();
			minQueue.offer(x);
		}


		int result = 0 ;
		int temp1=0;
		int temp2 =0;

		while(minQueue.size()>1){
			temp1 = minQueue.poll();
			temp2 = minQueue.poll();
			result= result + temp1+temp2;
			minQueue.offer(temp1+temp2);
		}

		System.out.println(result);
	}
}
