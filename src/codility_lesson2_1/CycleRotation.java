package codility_lesson2_1;


public class CycleRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,8,9,7,6};
		Solution s = new Solution();
		array=s.solution(array, 3);
		for(int i=0; i<array.length; i++)
			System.out.println(array[i]);
	}

}
class Solution{
	public int[] solution(int[]A,int K){
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++)
		{
			B[(K+i)%A.length] = A[i];
		}
		return B;
	}
}