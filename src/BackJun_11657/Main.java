package BackJun_11657;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static ArrayList<City> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		list = new ArrayList<City>();

		for(int i=0; i<M; i++){
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			list.add(new City(a,b,c));
		}

		boolean update = false;

		int[] cost = new int[N+1];

		Arrays.fill(cost, (int)1e9);
		cost[1] = 0;
		for(int i=0; i<N; i++){
			update = false;
			for(City city : list){
				if(cost[city.A] + city.C < cost[city.B]){
					cost[city.B] = cost[city.A] + city.C;
					update = true;
				}
			}
		}

		if(update){
			System.out.println(-1);
			return;
		}

		for(int i=2; i<=N; i++){
			System.out.println(cost[i] >= (int)1e9 - (int)1e8 ? -1 : cost[i] );
		}

		input.close();
	}

}

class City{
	int A,B,C;

	public City(int A, int B, int C){
		this.A = A;
		this.B = B;
		this.C = C;
	}
}