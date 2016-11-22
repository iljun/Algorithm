package codility_lesson4_2;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,1,3,2};
		Solution s = new Solution();
		System.out.println(s.Solution(A));
	}

}
class Solution{
	public int Solution(int[] A){
		Arrays.sort(A);
		for(int i=0;i<A.length; i++){
			if(A[i]!=i+1)
				return 0;
		}
		return 1;
	}
}