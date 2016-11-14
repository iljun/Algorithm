package codility_lession3_3;

public class PermMissingElem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A ={2,3,1,5};
		Solution s = new Solution();
		
		System.out.println(s.solution(A));
	}

}
class Solution{
	public int solution(int[] A){
		if(A.length==0)
			return 1;
		
		int sum=0;
		int total=0;
		for(int i=0; i<A.length; i++){
			sum+=A[i];
			total+=i+1;
		}
		total+=A.length+1;
		return total-sum;
	}
}