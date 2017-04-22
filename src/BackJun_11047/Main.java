package BackJun_11047;

import java.util.Scanner;

public class Main {
	static int N;
	static long K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		K = input.nextLong();

		int[] cost = new int[N];

		for(int i=0; i<N; i++){
			cost[i]=input.nextInt();
		}

		int count=0;

		while(K>0){
			for(int i=cost.length-1; i>-1; i--){
				if(K-cost[i]>=0){
					K-=cost[i];
					count++;
					break;
				}
			}

		}

		System.out.println(count);
	}

}
