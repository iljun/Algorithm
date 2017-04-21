package BackJun_1786;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static char[] P;//pattern
	static char[] T;//text
	static int[] fail;//전처리 배열
	static List<Integer> list;//결과값 배열
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String t = input.nextLine();
		String p = input.nextLine();
		T=t.toCharArray();
		P=p.toCharArray();
		fail = new int[P.length+1];
		list = new ArrayList<Integer>();
		fail();

		solve();
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).toString());
		}
	}

	public static void fail(){
		int j=0;
		for(int i=1; i<P.length; i++){
			j=fail[i-1];
			while(j>0 && P[i]!=P[j]){
				j = fail[j-1];
			}
			if(P[i]==P[j]){
				fail[i]=++j;
			}else{
				fail[i]=0;
			}
		}
	}

	public static void solve(){
		for(int i=0, j=0; i<T.length; i++){
			while(j>0 && P[j]!=T[i]){
				j=fail[j-1];
			}

			if(T[i]==P[j]){
				if(j==P.length-1){
					list.add(i - P.length +2);
					j=fail[j];
				}else{
					j++;
				}
			}
		}
	}

}
