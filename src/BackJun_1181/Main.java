package BackJun_1181;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static String[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		arr = new String[N];

		for(int i=0; i<N; i++)
			arr[i]=input.next();
		input.close();

		Arrays.sort(arr, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				if(s1.length()>s2.length())
					return 1;
				else if(s1.length()<s2.length())
					return -1;
				else{
					return s1.compareTo(s2);
				}
			}

		});

		System.out.println(arr[0]);
		for(int i=1; i<N; i++){
			if(!arr[i].equals(arr[i-1]))
				System.out.println(arr[i]);
		}
	}

}
