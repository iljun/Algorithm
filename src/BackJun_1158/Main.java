package BackJun_1158;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int M = input.nextInt();

		list = new LinkedList<Integer>();

		for(int i=1; i<=N; i++){
			list.add(i);
		}

		System.out.print("<");

		int i = 0;

		while(!list.isEmpty()){
			i = (i+M-1)%N;
			System.out.print(list.get(i).intValue() + ", ");
			list.remove(i);
			i--;
		}

		System.out.print(">");
	}

}
