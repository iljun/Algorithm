package BackJun_5585;

import java.util.Scanner;

public class Main {
	static int[] cost;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		cost = new int[6];
		cost[0]=500;
		cost[1]=100;
		cost[2]=50;
		cost[3]=10;
		cost[4]=5;
		cost[5]=1;

		int N = input.nextInt();
		N=1000-N;
		int count=0;
		while(N>0){
			N=minus(N);
			count++;
		}

		System.out.println(count);
	}

	public static int minus(int N){
		for(int i=0; i<cost.length; i++){
			if(N-cost[i]>=0){
				N-=cost[i];
				break;
			}else
				continue;

		}
		return N;
	}

}
