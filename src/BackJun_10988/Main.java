package BackJun_10988;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String N = input.next();
		char[] temp = N.toCharArray();

		boolean s = true;
		for(int i=0; i<temp.length/2 && s!=false; i++){
			if(temp[i]!=temp[temp.length-1-i])
				s=false;
		}

		if(s==true)
			System.out.println(1);
		else
			System.out.println(0);
	}

}