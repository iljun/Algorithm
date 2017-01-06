package codility_lesson5_3;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		int A[] = { 4, 2, 2, 5, 1, 5, 8 };
		Solution s = new Solution();
		System.out.println(s.Solution(A));
	}

}

class Solution {
	public int Solution(int []A){
		int index=0;
		int[] sum = new int[A.length+1];
		double min = Integer.MAX_VALUE;
		double avg =0;
		
		for(int i=0; i<A.length; i++){
			sum[i+1]=sum[i]+A[i];
		}

		for(int n=2;n<A.length; n++){
			for(int i=0; i<A.length-n; i++){
				avg=(sum[i+n]-sum[i])/n;
				if(avg<min){
					min=avg;
					index=i;
				}
			}
		}
		return index;
	}
}
