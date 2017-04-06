package Backjun_11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int size = input.nextInt();

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		StringBuilder builder = new StringBuilder();

		int x;

		for(int i=0; i<size; i++){
			x=input.nextInt();
			if(x==0){
				if(queue.isEmpty())
					builder.append(0).append("\n");
				else
					builder.append(queue.poll().value).append("\n");
			}else{
				queue.offer(new Node(x));
			}
		}
		System.out.println(builder.toString());
	}

}
class Node implements Comparable<Node>{
	int value;
	int absoluteValue;

	public Node(int value){
		this.value=value;
		this.absoluteValue=Math.abs(value);
	}

	@Override
	public int compareTo(Node n){
		if(this.absoluteValue == n.absoluteValue){
			return this.value > n.value ? 1 : -1;
		}
		return this.absoluteValue > n.absoluteValue ? 1 : -1;
	}
}