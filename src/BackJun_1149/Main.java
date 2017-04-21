package BackJun_1149;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		arr = new int[N][N];

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				int x = input.nextInt();
				arr[i][j]=x;
			}
		}
		int[][] result = new int[N][N];

		for(int i=0; i<N; i++){
			result[i][0]=arr[0][i];
		}

		for(int i=1; i<N; i++){

		}
	}

}
