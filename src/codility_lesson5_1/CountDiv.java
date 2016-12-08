package codility_lesson5_1;
public class CountDiv {

	public static void main(String[] args) {
			int A = 0;
			int B = 14;
			int K = 2;
			Solution s = new Solution();
			System.out.println(s.Solution(A,B,K));
		}

	}
	class Solution{
		public int Solution(int A, int B, int K){
			int first=A/K;
			int second = B/K;
			if(first==0)
				first--;
			return second-first;
		}
	}