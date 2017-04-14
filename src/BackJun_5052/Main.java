package BackJun_5052;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		for(int i=0; i<N; i++){
			int M = input.nextInt();
			String [] arr = new String[M];
			for(int j=0; j<M; j++){
				arr[j]=input.next();
			}
			System.out.println(solve(arr));
		}
	}

	public static String solve(String[] arr){
		Arrays.sort(arr,new CompareLength());
		String compareA = arr[0];
		for(int i=1; i<arr.length; i++){
			String compareB = arr[i].substring(0,compareA.length());
			if(compareA.equals(compareB))
				return "NO";
		}
		return "Yes";
	}

}
class CompareLength implements Comparator<String>{
	@Override
	public int compare(String A, String B){
		return A.length() >= B.length() ? 1 : -1 ;
	}
}