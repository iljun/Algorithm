package codility_lesson6_1;

import java.util.Arrays;

public class Distinct {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {2,1,1,2,3,1};
		Solution s = new Solution();
		System.out.println(s.solution(A));
	}
}
class Solution{
	public static int solution(int[] A){
		if(A.length==0)
			return 0;
		Arrays.sort(A);
		int count=1;
		int s=A[0];
		
		for(int i=0; i<A.length; i++){
			if(A[i]!=s){
				s=A[i];
				count++;
			}
		}
		return count;
	}
}
