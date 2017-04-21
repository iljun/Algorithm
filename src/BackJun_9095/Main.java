package BackJun_9095;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();

		N = input.nextInt();
		for(int i=0; i<N; i++){
			int x = input.nextInt();
			int[] result = new int[x+1];
			result[0]=1;
			for(int j=1; j<=x ; j++){
				if(j-1>=0){
					result[j]+=result[j-1];
				}
				if(j-2 >= 0){
					result[j]+=result[j-2];
				}
				if(j-3 >= 0){
					result[j]+=result[j-3];
				}
			}
			builder.append(result[x]).append("\n");
		}
		System.out.println(builder.toString());
	}

}
