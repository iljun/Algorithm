package codility_lesson5_4;

import java.util.HashMap;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String S = "CAGCCTA";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		System.out.println(s.solution(S, P, Q));
	}

}
class Solution{
	public int[] solution(String S, int[] P, int[] Q){
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		hash.put('A', 1);
		hash.put('C', 2);
		hash.put('G', 3);
		hash.put('T', 4);
		char[] array = S.toCharArray();
		int[] result = new int[P.length];
		for(int i=0; i<P.length; i++){
			int min=Integer.MAX_VALUE;
			for(int j=P[i];j<=Q[i];j++){
				if(min>hash.get(array[j]))
					min=hash.get(array[j]);
			}
			result[i]=min;
		}

		return result;
	}
}