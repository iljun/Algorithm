package BackJun_1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Long x = input.nextLong();
		int count=0;

		while(x!=1){
			if(x%3==0){
				x=x/3;
			}else if(x%3==1){
				x=x-1;
			}else if(x%2==0){
				x=x/2;
			}else if(x%3==2){
				if(x%2==0){
					x=x/2;
				}else
					x--;
			}
			count++;
		}
		System.out.println(count);
	}

}
