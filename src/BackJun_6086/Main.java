package BackJun_6086;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] flow;
	static int[][] capacity;
	static List<Integer>[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();

		list = new ArrayList[52];
		flow = new int[52][52];
		capacity = new int[52][52];

		for(int i=0; i<52; i++)
			list[i] = new ArrayList<Integer>();

		for(int i=0; i<N; i++){
			String temp = input.next();
			String s = input.next();
			char[] c1 = temp.toCharArray();
			char[] c2 = s.toCharArray();
			int a = input.nextInt();
			int b = change(c1[0]);
			int c = change(c2[0]);
			capacity[b][c]+=a;//같은경로에 두개의 경로가있을때 유류량을 더해준다.
			list[b].add(c);
			list[c].add(b);
			//역방향 저장
		}
		input.close();

		int total=0;
		int S = change('A');
		int E = change('Z');

		while(true){
			int[] prev = new int[53];
			Arrays.fill(prev,-1);
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(S);
			while(!queue.isEmpty()){//BFS
				int front = queue.poll();
				for(int x : list[front]){
					if(capacity[front][x]-flow[front][x] > 0 && prev[x] == -1){
						queue.add(x);
						prev[x] = front;//이전경로 저장
						if(x == E){//끝점 도달시 루프 탈출
							break;
						}
					}
				}
			}

			if(prev[E] == -1)//끝점에 도달하지 못하면 루프 탈출
				break;

			int minValue = 100000;

			for(int i=E; i!=S; i=prev[i]){//최소 유류량
				minValue=Math.min(minValue, capacity[prev[i]][i] - flow[prev[i]][i]);
			}

			for(int i=E; i!=S; i=prev[i]){//유류량 추가
				flow[prev[i]][i] += minValue;
				flow[i][prev[i]] -= minValue;
			}

			total += minValue;

		}

		System.out.println(total);

	}

	static int change(char s){
		if(s <= 'Z')
			return s - 'A';
		return s - 'a' +26;
	}

}
