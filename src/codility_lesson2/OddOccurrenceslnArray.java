package codility_lesson2;

import java.util.HashMap;

public class OddOccurrenceslnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[7];
		Solution s = new Solution();
		System.out.println(s.solution(arr));
	}

}
class Solution{
	public int solution(int[] A){
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int count=1;
		for(int i=0; i<A.length; i++){
			if(map.containsKey(A[i])==false){
				map.put(A[i], count);
			}
			else{
				int x=map.get(A[i]);
				map.put(A[i],x+1);
			}
		}
		for(int i=0; i<A.length; i++){
			if(map.get(A[i])%2==1)
				count=A[i];
		}
		return count;
	}
}
