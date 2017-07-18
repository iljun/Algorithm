package BackJun_1038;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int cnt;
	static long[] dp = new long[1500];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();

		Arrays.fill(dp, Long.MAX_VALUE);//초기화
		find(0,10);
		Arrays.sort(dp);//정렬

		if(N>=cnt)
			System.out.println("-1");
		else
			System.out.println(dp[N]);

		input.close();
	}

	static void find(long startNum, long endNum){
		  // 0 , 10  0<10  / 0 , i=1-> 10 , 1 , i=2-> 20 , 210 , 21 , 2 i=3->30 , 310 , 31 , 320 , 3210 , 321 , 32 , 3 ...
		for(long i = startNum; i<startNum+endNum; i++){
			if(i%10 > 0){
				find(i*10,i%10);
			}
			dp[cnt]=i;
			cnt++;
		}
	}
}
