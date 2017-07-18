package BackJun_3640;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int v;
	static int e;
	static ArrayList<Ship> list;
	static int[] cost;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		v = input.nextInt();
		e = input.nextInt();

		list = new ArrayList<Ship>();

		for (int i = 0; i < e; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int weight = input.nextInt();
			list.add(new Ship(v1, v2, weight));

		}

		cost = new int[v + 1];

		Arrays.fill(cost, (int) 1e9);
		cost[1] = 0;
		boolean update = false;
		boolean[] check = new boolean[v + 1];
		int x = 0;

		int first = 0;
		int second = 0;

		for (int i = 0; i <= v; i++) {
			update = false;
			for (Ship ship : list) {
				if (cost[ship.v2] > ship.weight + cost[ship.v1]) {
					if (check[ship.v2] == false) {
						check[ship.v2] = true;
					} else {
						x = ship.v2;
						first = cost[ship.v2];
					}
					cost[ship.v2] = ship.weight + cost[ship.v1];
					update = true;
				}

			}
		}
		System.out.println(x);
		System.out.println(first);
		input.close();
	}

}

class Ship {
	int v1;
	int v2;
	int weight;

	public Ship(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
}