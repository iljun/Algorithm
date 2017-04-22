package Backjun_10610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {//3의 배수의 조건은 각자리수의 합이 3인것
	static String N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.next();

		char[] t = N.toCharArray();
		int sum=0;
		int count=0;
		for(int i=0; i<t.length; i++){
			sum+=t[i]-48;
			if(t[i]-48==0)
				count++;
		}

		if(sum%3!=0){
			System.out.println(-1);
		}else if(count==0){
			System.out.println(-1);
		}else{
			Arrays.sort(t);
			StringBuilder builder = new StringBuilder();
			for(int i=t.length-1 ; i>-1; i--){
				int x = t[i]-48;
				builder.append(x);
			}
			System.out.println(builder.toString());
		}

	}
}
