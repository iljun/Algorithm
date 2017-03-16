package BackJun_1932;

import java.util.Scanner;

public class DP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int size=input.nextInt();
		int[][] array = new int[size][size];
		int value;

		for(int i=0; i<size; i++){
			for(int j=0; j<=i; j++){
				value=input.nextInt();
				array[i][j]=value;
			}
		}

		for(int i=1 ; i<size; i++){
			for(int j=0; j<=i; j++){
				if(j==0){
					array[i][j] += array[i-1][j];
				}else if(j==i){
					array[i][j] += array[i-1][j-1];
				}else{
					array[i][j] = max(array[i][j]+array[i-1][j-1],array[i][j]+array[i-1][j]);
				}
			}
		}

		int max=0;

		for(int i=0; i<size; i++){
			if(max < array[size-1][i]){
				max = array[size-1][i];
			}
		}

		System.out.println(max);
	}
	public static int max(int x, int j){
		if(x>j)
			return x;
		else
			return j;
	}
}
