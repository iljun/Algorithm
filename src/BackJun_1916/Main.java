package BackJun_1916;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	static List<Node>[] list;
	static int[] minPrice;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int v = input.nextInt();
		int e = input.nextInt();

		list = new ArrayList[v+1];
		minPrice = new int[v+1];
		for(int i=1; i<=v; i++){
			list[i] = new ArrayList<Node>();
			minPrice[i]=Integer.MAX_VALUE;
		}

		int start;
		int end;
		int price;

		for(int i=1; i<=e; i++){
			start = input.nextInt();
			end = input.nextInt();
			price = input.nextInt();
			list[start].add(new Node(end,price));
		}

		start = input.nextInt();
		end = input.nextInt();

		PriorityBlockingQueue<Node> q = new PriorityBlockingQueue<Node>();
		minPrice[start] = 0;
		q.offer(new Node(start,minPrice[start]));

		while(!q.isEmpty()){
			start = q.poll().cityNumber;
			for(int i=0; i<list[start].size(); i++){
				int temp = list[start].get(i).cityNumber;
				if(minPrice[temp]>minPrice[start]+list[start].get(i).price){
					minPrice[temp]=minPrice[start]+list[start].get(i).price;
					q.offer(new Node(temp,minPrice[temp]));
				}
			}
		}
		System.out.println(minPrice[end]);
	}

}
class Node implements Comparable<Node>{
	int cityNumber;
	int price;

	public Node(int cityNumber, int price){
		this.cityNumber=cityNumber;
		this.price=price;
	}

	@Override
	public int compareTo(Node n){
		return this.price> n.price ? 1 : -1;
	}
}