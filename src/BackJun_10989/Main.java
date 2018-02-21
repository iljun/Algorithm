package BackJun_10989;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] result= new int[10001];
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		for(int i = 0 ; i < N; i++)
			result[input.nextInt()]++;

		for(int i = 0; i < 10001; i++){
			if(result[i]>0){
				for(int j=0; j<result[i]; j++){
					System.out.println(i);
				}
			}
		}

	}


}
