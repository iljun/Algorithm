package BackJun_2989;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int K;
	static int N;
	static Node[] list;
	static int[][] dp;
	static int lastX;
	static int lastY;
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		list = new Node[N];
		int max = 0;
		for(int i=0; i<N; i++){
			int x = input.nextInt();
			int y = input.nextInt();
			int k = input.nextInt();
			Node newNode = new Node(x,y,k);
			list[i]=newNode;
			if(x>max ||y>max){
				if(x>max)
					max=x;
				else
					max=y;
			}

		}

		Arrays.sort(list, new CompareFlower());

		StringBuilder builder = new StringBuilder();

		dp = new int[max+1][max+1];
		dp[list[0].x][list[0].y]=list[0].k;
		builder.append(list[0].x+ " ").append(list[0].y+ " ").append("\n");
		count =1;
		for(int i=1; i<list.length; i++){
			check(list[i],builder);
		}

		System.out.println(dp[lastX][lastY]-((count-1)*K));
		System.out.println(count);
		System.out.println(builder.toString());
	}

	public static void check(Node x,StringBuilder builder){
		for(int i=x.x; i>0; i--){
			if(dp[i][x.y]!=0 && x.k>=K){
				dp[x.x][x.y]=dp[i][x.y]+x.k;
				lastX=x.x;
				lastY=x.y;
				count++;
				builder.append(lastX + " ").append(lastY + " ").append("\n");
				return;
			}
		}

		for(int i=x.y; i>0; i--){
			if(dp[x.x][i]!=0 && x.k>=K){
				dp[x.x][x.y]=dp[x.x][i]+x.k;
				lastY=x.y;
				lastX=x.x;
				count++;
				builder.append(lastX + " ").append(lastY + " ").append("\n");
				return;
			}
		}
	}
}
class Node{
	int x;
	int y;
	int k;

	public Node(int x, int y, int k){
		this.x=x;
		this.y=y;
		this.k=k;
	}
}

class CompareFlower implements Comparator<Node>{
	@Override
	public int compare(Node n, Node n1){
		if(n.x<n1.x && n.y==n1.y)
			return -1;
		else if(n.x==n1.x && n.y<n1.y)
			return -1;
		return 1;
	}
}