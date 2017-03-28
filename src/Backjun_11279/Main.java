package Backjun_11279;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		arr = new int[size];

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,Collections.reverseOrder());

		for(int i=0; i<size; i++){
			arr[i]=input.nextInt();
		}

		for(int i=0; i<size; i++){
			if(arr[i]==0 && maxHeap.isEmpty()){
				System.out.println(0);
			}else if(arr[i]==0 && !maxHeap.isEmpty()){
				System.out.println(maxHeap.poll());
			}else{
				maxHeap.add(arr[i]);
			}
		}


	}

}
