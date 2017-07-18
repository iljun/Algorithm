package BackJun_2352;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();

		arr = new int[N + 1];
		list = new int[N+1];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = input.nextInt();
		}

		for(int i=1; i<N+1; i++){
			int count=0;
			for(int j=i; j<N+1; j++){

			}
		}
		input.close();
	}

}
