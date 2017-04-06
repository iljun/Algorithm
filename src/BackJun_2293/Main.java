package BackJun_2293;

import java.util.Scanner;

public class Main {
	//TODO DP문제는 점화식을 구해보자
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int size = input.nextInt();//입력되는 동전의 갯수
		int result = input.nextInt();//합을 맞춰야되는 값

		int[] arr = new int[result+1];//
		int[] coin = new int[size];//동전을 저장하는 배열

		for(int i=0; i<size; i++){
			coin[i]=input.nextInt();
		}

		arr[0]=1;
		for(int i=0; i<coin.length; i++){
			for(int j=1; j<result +1 ; j++){
				if(coin[i]<=j){
					arr[j] = arr[j] + arr[j - coin[i]];
				}
			}
		}

		System.out.println(arr[result]);
	}

}
