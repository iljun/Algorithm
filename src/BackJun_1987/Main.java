package BackJun_1987;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static String[][] arr;
	static HashMap<String,Boolean> hash;
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		hash = new HashMap<String,Boolean>();
		String line = input.nextLine();

		N = Integer.parseInt(line.split(" ")[0]);
		M = Integer.parseInt(line.split(" ")[1]);
		arr = new String[N+1][M+1];

		for(int i=1; i<=N; i++){
			line = input.nextLine();
			for(int j=0; j<M;j++){
				arr[i][j+1] = line.substring(j,j+1);
			}
		}

		dfs();
		System.out.println(Arrays.deepToString(arr));
		input.close();
	}

	static void dfs(){

	}
}
