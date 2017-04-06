package codingdojang_18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int x = input.nextInt();
		StringBuilder builder = new StringBuilder();

		for(int i=1; i<=x; i++){
			builder.append(Integer.toString(i));
		}

		char[] arr = builder.toString().toCharArray();

		HashMap<Character,Integer> map = new HashMap<Character,Integer>();

		for(int i=0; i<arr.length; i++){
			if(!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else{
				int key = arr[i];
				int value = map.get(arr[i]).intValue();
				map.remove(arr[i]);
				map.put((char) key, value+1);
			}
		}

		Iterator<Character> list = map.keySet().iterator();

		while(list.hasNext()){
			char key= list.next();
			System.out.println(key + " : " + map.get(key));
		}
	}

}
