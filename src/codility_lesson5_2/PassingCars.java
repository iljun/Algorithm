package codility_lesson5_2;

public class PassingCars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {0,1,0,1,1};
		System.out.println(s.solution(A));
	}

}
class Solution{
	public int solution(int[] A){
		int count=0;
		int count2=0;
		int max=Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++){
			if(A[i]==0)
				count++;
			else{
				count2 += count;
				if(count2>max){
					count=-1;
					break;
				}
			}
		}
		return count2;
	}
}
