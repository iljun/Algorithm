package BackJun_11657_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static ArrayList<City> list;
	static int[] cost;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		cost = new int[N + 1];
		list = new ArrayList<City>();

		for (int i = 0; i < M; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			int weight = input.nextInt();
			list.add(new City(x, y, weight));
		}

		Arrays.fill(cost, (int)1e9);

		cost[1] = 0;

		boolean update = false;

		for (int i = 0; i < N; i++) {
			update = false;
			for (City city : list) {
				if (cost[city.v2] > city.weight + cost[city.v1]) {
					cost[city.v2] = city.weight + cost[city.v1];
					update = true;
				}
			}
		}

		if (update) {
			System.out.println(-1);
		} else {
			for (int i = 2; i < N + 1; i++) {
				System.out.println(cost[i] >= (int)1e9 - (int)1e8 ? -1 : cost[i]);
			}
		}

		input.close();
	}

}

class City {
	int v1;
	int v2;
	int weight;

	public City(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
}