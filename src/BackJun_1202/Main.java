package BackJun_1202;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	//M 보석의무게
	//V 보석의가격
	//C 가방의 무게
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int K = input.nextInt();

		PriorityQueue<Item> maxQueue = new PriorityQueue<Item>();
		PriorityQueue<Integer> backQueue = new PriorityQueue<Integer>();
		PriorityQueue<Item> tempQueue = new PriorityQueue<Item>();

		for(int i=0; i<N; i++){
			int M = input.nextInt();
			int V = input.nextInt();
			maxQueue.offer(new Item(V,M));
		}

		for(int i=0; i<K; i++){
			int C = input.nextInt();
			backQueue.offer(C);
		}

		int result=0;

		while(!backQueue.isEmpty()){
			int size = backQueue.peek();
			Item item = null;
			List<Item> temp2 = new ArrayList<Item>();
			if(tempQueue.isEmpty()){
				item=maxQueue.poll();
				if(item.weight<=size){
					result+=item.price;
					backQueue.poll();
					break;
				}else{
					temp2.add(item);
				}
			}else{
				item=tempQueue.poll();
				if(item.weight<=size){
					result+=item.price;
					backQueue.poll();
					break;
				}else{
					temp2.add(item);
				}
			}
			tempQueue.addAll(temp2);
		}

		System.out.println(result);

	}

}

class Item implements Comparable<Item>{
	int price;
	int weight;

	public Item(int price, int weight){
		this.price = price;
		this.weight = weight;
	}

	@Override
	public int compareTo(Item i){
		return this.price > i.price ? -1 : 1;
	}
}