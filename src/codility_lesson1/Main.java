package codility_lesson1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("숫자를 입력하세요:");
		int num = input.nextInt();
	
		Solution s = new Solution();
		System.out.println(s.solution(num));
		
	}

}
class Solution{
	public int solution(int N){
		String s = Integer.toBinaryString(N);
		char[] array = s.toCharArray();
		int count=0;
		int max=0;
		for(int i=0; i<array.length;i++){
			if(array[i]=='1'){
				if(max<count)
					max=count;
				count=0;
			}
			else
				count++;
		}
		
		return max;
	}
}