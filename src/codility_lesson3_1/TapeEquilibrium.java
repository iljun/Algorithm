package codility_lesson3_1;

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
		int sum=0;
		int middle=0;
		int min=Integer.MAX_VALUE;
		
		for(int i=0; i<A.length; i++)
			sum += A[i];
		
		for(int i=0; i<A.length -1; i++){
			middle+=A[i];
			if(min>Math.abs(middle-(sum-middle)))
				min=Math.abs(middle-(sum-middle));
		}
		return min;
	}
}
