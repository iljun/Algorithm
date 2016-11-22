package codility_lesson4_1;

import java.util.HashMap;

public class MissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,6,4,1,2};
		Solution s = new Solution();
		System.out.println(s.solution(A));
	}

}
class Solution{
	public int solution(int[] A){
		HashMap<Integer,Boolean> hash = new HashMap<Integer,Boolean>();
		for(int i=0; i<A.length; i++){
			if(A[i]>0)
				hash.put(A[i],true);
		}
		for(int i=1; i<Integer.MAX_VALUE; i++){
			if(!hash.containsKey(i))
				return i;
		}
		return 1;
	}
}