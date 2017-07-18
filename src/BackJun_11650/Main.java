package BackJun_11650;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		arr = new int[N][2];

		for(int i=0; i<N; i++){
			arr[i][0] = input.nextInt();
			arr[i][1] = input.nextInt();
		}

		input.close();

		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[0]==b[0])
					return Integer.compare(a[1], b[1]);
				else
					return Integer.compare(a[0], b[0]);
			}
		});
		for(int i=0; i<N; i++){
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}