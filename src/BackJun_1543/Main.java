package BackJun_1543;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static String S;
	static String pattern;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		S = input.next();
		pattern = input.next();

		input.close();

		HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();

		char[] arr = pattern.toCharArray();

		for(int i=0; i<arr.length; i++){
			hashMap.put(arr[i], arr.length-i);
		}

		char[] s = S.toCharArray();

		int i=0;
		int count=0;
		while(i<=S.length()-pattern.length()+1){
			int j=pattern.length();
			int k = i+S.length()-1;
			while(j>0 && arr[j-1]==s[k-1]){
				j--;
				k--;
			}
			if(j==0)
				count++;
			i = i+hashMap.get(arr[i+pattern.length()-1]);
		}

		System.out.println(count);
	}

}
