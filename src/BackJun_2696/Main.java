package BackJun_2696;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();

		StringBuilder builder = new StringBuilder();
		for(int k=0; k<size; k++){
			N = input.nextInt();

			builder.append((N+1)/2);
			builder.append("\n");

			PriorityQueue<Integer> q = new PriorityQueue<>();
			for(int i=1; i<=N; i++){
				int temp=input.nextInt();
				q.offer(temp);
				if(i%2!=0){
					int[] temps = new int[i+1];
					for(int j=1; j<=i; j++){
						int x = q.poll();
						if(j==(i+1)/2){
							builder.append(x).append(" ");
						}
						temps[j]=x;
					}

					for(int j=1; j<temps.length; j++){
						q.offer(temps[j]);
					}
				}
			}
			q.clear();
			builder.append("\n");
		}

		System.out.println(builder.toString());
	}

}
