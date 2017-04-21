package BackJun_1149;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		result = new int[N][4];

		for (int i = 0; i < N; i++) {
			int r=input.nextInt();
			int g=input.nextInt();
			int b=input.nextInt();

			if(i==0){
				result[i][0]=r;
				result[i][1]=g;
				result[i][2]=b;
			}else{
				result[i][0]= Math.min(result[i-1][1]+r,result[i-1][2]+r);
				result[i][1]= Math.min(result[i-1][0]+g,result[i-1][2]+g);
				result[i][2]= Math.min(result[i-1][0]+b,result[i-1][1]+b);
			}
		}
		int min = Math.min(result[N-1][0], Math.min(result[N-1][1], result[N-1][2]));

		System.out.println(min);
	}
}
