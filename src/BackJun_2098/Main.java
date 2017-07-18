package BackJun_2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static int[] cost;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new int[N + 1][N + 1];
		cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		for (int i = 0; i < cost.length; i++) {
			int j = i;
			int count = 1;
			boolean[] check = new boolean[N + 1];
			Arrays.fill(check, false);
			while (count < N) {
				int min = -1;
				int k = 0;
				for (; k < N; k++) {
					if (min < arr[j][k] && arr[j][k] != 0 && check[k] == false) {
						min = arr[j][k];
					}
				}
				check[k] = true;
				cost[i] += min;

				System.out.println(i + " : " + min);
				count++;
				j = k;
			}
		}
		System.out.println(Arrays.toString(cost));
		input.close();
	}

}

class City {
	int x;
	int y;
	int weight;

	public City(int x, int y, int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
}