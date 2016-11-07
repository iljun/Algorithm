package codility_lesson3_1;

import java.util.HashMap;

public class TapeEquilibrium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[5];
		A[0]=3;
		A[1]=1;
		A[2]=2;
		A[3]=4;
		A[4]=3;
		Solution s = new Solution();
		System.out.println(s.solution(A));
	}

}
class Solution{//절대값이 제일 작은것을 출력
	public int solution(int[] A){
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int P=1;
		int max=0;
		int min=0;
		for(int i=0; i<A.length; i++){
			max+=A[i];
		}
		max=max-A[0];
		
		return min;
	}
}
