package BackJun_1655;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();

		PriorityQueue<Integer> right = new PriorityQueue<>();
		PriorityQueue<Integer> left = new PriorityQueue<>(1,Collections.reverseOrder());

		StringBuilder builder = new StringBuilder();

		int mid;

		int x = input.nextInt();
		mid = x;
		builder.append(mid).append("\n");
		for(int i=1; i<size; i++){
			x=input.nextInt();

			if(x<mid)
				left.offer(x);
			else
				right.offer(x);

			if(i%2==0){
				if(left.size()>right.size()){
					right.offer(mid);
					mid=left.poll();
				}else if(left.size()<right.size()){
					left.offer(mid);
					mid=right.poll();
				}
				builder.append(mid).append("\n");
			}else if(i%2!=0){
				if(left.size() > right.size()){
					builder.append(left.peek()).append("\n");
				}else if(left.size() < right.size())
					builder.append(mid).append("\n");
			}

		}

		System.out.println(builder.toString());
	}
}
