package BackJun_1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] A;
	static int[] B;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		A = new int[N];
		B = new int[N];

		for(int i=0; i<N; i++){
			A[i] = input.nextInt();
		}

		for(int i=0; i<N; i++){
			B[i] = input.nextInt();
		}

		input.close();

		Arrays.sort(A);
		Arrays.sort(B);

		long sum=0;
		for(int i=0; i<N; i++){
			sum+= A[i]*B[N-i-1];
		}

		System.out.println(sum);
	}

}
