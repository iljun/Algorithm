package codingdojang_98;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int x = input.nextInt();

		for(int i=1; i<=x; i++){
			Integer result = solve(i);
			if(result!=null)
				System.out.println(result);
		}
	}

	public static Integer solve(int x){
		List<Integer> temp = new ArrayList<Integer>();
		for(int i=1; i<x; i++){
			if(x%i==0)
				temp.add(i);
		}

		int result = 0;

		for(int i=0; i<temp.size(); i++){
			result+=temp.get(i).intValue();
		}
		if(result==x)
			return result;
		else
			return null;
	}
}
