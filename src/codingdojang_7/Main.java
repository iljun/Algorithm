package codingdojang_7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=0;

		for(int i=10; i<=1000; i++){
			String temp = Integer.toString(i);
			char[] tmp = temp.toCharArray();
			int multiple=1;
			for(int j=0; j<tmp.length; j++)
				multiple*=tmp[j]-48;
			result+=multiple;
		}

		System.out.println(result);
	}

}