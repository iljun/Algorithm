package BackJun_1202;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	// M 보석의무게
	// V 보석의가격
	// C 가방의 무게
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		Long N = input.nextLong();
		Long K = input.nextLong();

		PriorityQueue<Item> queue = new PriorityQueue<>();
		PriorityQueue<Long> min = new PriorityQueue<>();

		for (long i = 0; i < N; i++) {
			queue.offer(new Item(input.nextLong(), input.nextLong()));
		}

		for (long i = 0; i < K; i++) {
			Long test = input.nextLong();
			min.offer(test);
		}

		long result = 0;
		Item temp = null;

		while (!min.isEmpty()) {
			Long temp2 = min.poll();
			temp = queue.poll();
			while (temp2 < temp.weight) {
				temp = queue.poll();
			}
			result += temp.price;
		}

		System.out.println(result);
	}

}

class Item implements Comparable<Item> {
	long price;
	long weight;

	public Item(long weight, long price) {
		this.price = price;
		this.weight = weight;
	}

	@Override
	public int compareTo(Item i) {
		if (this.price == i.price)
			return this.weight > i.weight ? -1 : 1;
		else
			return this.weight > i.weight ? -1 : 1;
	}
}