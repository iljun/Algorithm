package BackJun_1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size=input.nextInt();

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		arr = new int[size];

		for(int i=0; i<size; i++)
			arr[i]=input.nextInt();

		for(int i=0; i<size; i++){
			if(arr[i]==0 && minHeap.isEmpty())
				System.out.println(0);
			else if(arr[i]==0 && !minHeap.isEmpty())
				System.out.println(minHeap.poll());
			else
				minHeap.add(arr[i]);
		}

	}

}
