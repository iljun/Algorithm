package BackJun_1126;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Stack stack = new Stack();
		N = input.nextInt();

		arr = new int[N];

		for(int i=0; i<N; i++){
			arr[i]=input.nextInt();
		}

		Arrays.sort(arr);

		for(int i=0; i<arr.length; i++)
			stack.push(arr[i]);

		int max=0;
		int min=0;

		while(!stack.isEmpty()){
			if(max==min){
				max+=(int)stack.pop();
			}else{
				min+=(int)stack.pop();
			}
		}

		if(max==min)
			System.out.println(max);
		else
			System.out.println(-1);
	}
}
