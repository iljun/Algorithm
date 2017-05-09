package BackJun_1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();

		int[] list = new int[N];
		stack = new Stack<Integer>();

		StringBuilder builder = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			list[i] = input.nextInt();
		}

		int count = 1;
		int index = 0;
		while(index!= N && count!=N+2){
			if(!stack.isEmpty()){
				if(stack.peek() == list[index]){
					stack.pop();
					index++;
					builder.append("-").append("\n");
				}else{
					stack.push(count);
					count++;
					builder.append("+").append("\n");
				}
			}else{
				stack.push(count);
				count++;
				builder.append("+").append("\n");
			}
		}

		if (index == N)
			System.out.println(builder.toString());
		else
			System.out.println("NO");

		input.close();
	}

}
