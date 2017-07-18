package BackJun_1562;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		input.close();
		long count=0;
		for(int i=0; i<N; i++){
			if(i==0)
				count=9;
			else
				count=count*2;
		}

		System.out.println(count%1000000000);
	}

}
