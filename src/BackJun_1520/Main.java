package BackJun_1520;

import java.util.Scanner;

public class Main {
	static int[][] list;
	static int count;
	static int N;
	static int M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		list = new int[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				int x = input.nextInt();
				list[i][j]=x;
			}
		}
		count =0;
		solve(N-1,M-1);

		System.out.println(count);
	}
	public static void solve(int x, int y){

	}
}
