package BackJun_1946;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int T;
	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();

		T = input.nextInt();
		for (int i = 0; i < T; i++) {
			N = input.nextInt();
			arr = new int[N][2];
			for (int j = 0; j < N; j++) {
				arr[j][0] = input.nextInt();
				arr[j][1] = input.nextInt();
			}

			Arrays.sort(arr, new Comparator<int[]>(){
				@Override
				public int compare(int[] arr1, int[] arr2) {
					int item1 = arr1[0];
					int item2 = arr2[0];
					if (item1 < item2)
						return -1;
					else
						return 1;
				}
			});
			int count=1;
			int l=0;
			for(int k=0 ; k<N-1; k++){
				if(arr[l][1] > arr[k+1][1]){
					count++;
					l=k+1;
				}
			}
			builder.append(count).append("\n");
		}

		System.out.println(builder.toString());
		input.close();
	}

}
