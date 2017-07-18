package BackJun_2624;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int T;
	static int K;
	static int arr[][];
	static int dp[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		T = input.nextInt();
		K = input.nextInt();
		arr = new int[K + 1][3];
		dp = new int[T + 1];

		for (int i = 1; i <= K; i++) {
			arr[i][1] = input.nextInt();
			arr[i][2] = input.nextInt();
		}

		input.close();

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				int item1 = arr1[1];
				int item2 = arr2[1];
				if (item1 < item2)
					return -1;
				else
					return 1;
			}
		});

		dp[0] = 1;

		for (int i = 1; i <= K; i++) {//동전의 갯수
			for (int j = T; j >= 0; j--) {//동전의 최대크기부터 줄어들기
				for (int k = 1; k <= arr[i][2]; k++) {
					if (j + k * arr[i][1] > T)
						break;
					dp[j + k * arr[i][1]] += dp[j];
				}
			}
		}

		System.out.println(dp[T]);

	}

}
