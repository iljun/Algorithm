package BackJun_1431;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static String[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		arr = new String[N];

		for(int i=0; i<N; i++){
			arr[i]=input.next();
		}

		Arrays.sort(arr,new ComapreInteger());
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i].toString());
		}
	}
}

class ComapreInteger implements Comparator<String>{

	@Override
	public int compare(String A, String B) {
		int ALength = A.length();
		int BLength = B.length();

		if(ALength!=BLength){
			if(ALength < BLength)
				return -1;
		}else if(ALength == BLength){
			int num1 = 0;
			int num2 = 0;
			for(int i=0; i<ALength; i++){
				int num = Character.getNumericValue(A.charAt(i));
				if(0<= num && num<=9)
					num1 += num;
			}

			for(int i=0; i<BLength; i++){
				int num = Character.getNumericValue(B.charAt(i));
				if(0 <= num && num <= 9)
					num2 += num;
			}
			if(num1<num2)
				return -1;
			else if(num1==num2)
				return A.compareTo(B);
			else
				return 1;
		}
		return 1;
	}
}