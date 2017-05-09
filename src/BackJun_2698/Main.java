package BackJun_2698;

import java.util.Scanner;

public class Main {
	static int[][][] arr;
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[105][105][2];

		arr[0][0][0] = arr[0][0][1] = 0;
		arr[1][0][0] = arr[1][0][1] = 1;

		StringBuilder builder = new StringBuilder();
		for(int j=2; j<105; j++){
			for(int h = 0; h<j; h++){
				arr[j][h][0] = arr[j-1][h][0] +arr[j-1][h][1];
		        arr[j][h][1] = arr[j-1][h][0] + ((h>0) ? arr[j-1][h-1][1] : 0);
			}
		}

		for(int i=0; i<N; i++){
			int n = input.nextInt();
			int k = input.nextInt();
			builder.append(arr[n][k][0]+arr[n][k][1]).append("\n");
		}

		System.out.println(builder.toString());
		input.close();
	}

}
