package BackJun_2042;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int K;
	static long[] arr;
	static long[] segment;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		M = input.nextInt();
		K = input.nextInt();

		arr = new long[N + 1];
		segment = new long[4 * N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = input.nextInt();

		init(segment, arr, 1, 1, N);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			 long b=input.nextLong();
	         long c=input.nextLong();
	         long d=input.nextLong();

	         if(b==1){
	               long diff = d - arr[(int) c];
	               update(segment,1,1,N,c,diff);
	               arr[(int)c]=d;
	         }
	         if(b==2){

	            builder.append(sum(segment,1,1,N,c,d)).append("\n");
	         }
		}

		System.out.println(builder);
		input.close();
	}

	static long init(long[] tree, long[] arr, int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = init(tree, arr, node * 2, start, mid) + init(tree, arr, node * 2 + 1, mid + 1, end);
	}

	static void update(long[] tree, int node, int start, int end, long index, long diff) {
		if (!(start <= index && index <= end)) {
			return;
		}
		tree[node] += diff;
		if (start != end) {
			int mid = (start + end) / 2;
			update(tree, node * 2, start, mid, index, diff);
			update(tree, node * 2 + 1, start, mid, index, diff);
		}
	}

	static long sum(long[] tree, int node, int start, int end, long left, long right) {
		if (end < left || start > right) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(tree, node * 2, start, mid, left, right) + sum(tree, node * 2 + 1, mid + 1, end, left, right);
	}

}
