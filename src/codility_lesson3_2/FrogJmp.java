package codility_lesson3_2;

public class FrogJmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X=10;
		int Y=85;
		int D=30;
		solution s = new solution(); 
		System.out.println(s.solution(X,Y,D));
	}

}
class solution{
	public int solution(int X,int Y, int D){
		return (int) Math.ceil((double)(Y-X)/D);		
	}
}