package BackJun_10868;

import java.util.Scanner;

//2*N*2
public class Main {
	static int N;
	static int M;
	static long[] arr;
	static long[] segment;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();

		arr = new long[N + 1];

		for (int i = 1; i < arr.length; i++)
			arr[i] = input.nextLong();

		segment = new long[N * 4 + 1];
		init(arr, segment, 1, 1, N);

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int prev = input.nextInt();
			int next = input.nextInt();

			builder.append(min(segment,1,1,N,prev,next)).append("\n");
		}

		System.out.println(builder.toString());

		input.close();
	}

	public static long init(long[] arr, long[] segment, int node, int start, int end) {
		if (start == end)
			return segment[node] = arr[start];

		int mid = (start + end) / 2;

		return segment[node] = Math.min(init(arr, segment, node * 2, start, mid), init(arr, segment, node * 2 + 1, mid + 1, end));
	}

	public static Long min(long[] segment, int node, int start, int end, int left, int right) {

		if (end < left || start > right) {
			return (long) Integer.MAX_VALUE;
		}

		if (left <= start && end <= right) {
			return segment[node];
		}

		int mid = (start + end) / 2;

		return Math.min(min(segment, node * 2, start, mid, left, right) , min(segment, node * 2 + 1, mid + 1, end, left, right));
	}
}
