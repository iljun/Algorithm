package BackJun_1766;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] list; // i 이후에 풀어야 되는 문제
	static int[] prev;// i 이전에 풀어야 문제
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int size = input.nextInt();
		list = new ArrayList[size+1];
		prev = new int[size+1];

		for(int i=1; i<=size; i++){
			list[i]= new ArrayList<Integer>();
		}

		int data = input.nextInt();
		int info1;
		int info2;

		for(int i=0; i<data; i++){
			info1 = input.nextInt();
			info2 = input.nextInt();
			list[info1].add(info2);
			prev[info2]++;
		}

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i=1; i<list.length; i++){
			if(prev[i]==0)
				q.add(i);
		}

		int temp;
		while(!q.isEmpty()){
			temp=q.peek();
			System.out.println(q.poll());

			for(int next : list[temp]){
				prev[next]--;
				if(prev[next]==0)
					q.add(next);
			}
		}

	}
}
