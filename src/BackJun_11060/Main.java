package BackJun_11060;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[][] list;
	static int[]dist;
	static final int inf = 1000000;
	static boolean[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
	    dist = new int[N+1];
	    visit = new boolean[N+1];

		list = new int[N + 1][N + 1];
		arr = new int[N + 1];
	    for(int i = 1; i <= N; i++){
            dist[i] = inf;   //임의의 무한한 값으로 거리값 초기화
        }

		for (int i = 1; i < N + 1; i++)
			arr[i] = input.nextInt();

		for (int i = 1; i < N + 1; i++) {
			for (int j = i; j < arr[i] + i && j + 1 < N + 1; j++) {
				list[i][j + 1] = 1;
				list[j + 1][i] = 1;
			}
		}
		input.close();
		ssp(1,N);
	}

	public static void ssp(int start, int end){
        dist[start] = 0;    // 최초 시작 값 distance 초기화
        String s = "";
        for( int j = 1; j < N+1; j++) // dist 값을 한번 초기화 했으므로 n-1번만 진행
        {
            int min = inf+1;    // dist 최소값 찾기 위한 임시 값 초기화
            int index = -1;
            for(int k = 1; k <= N; k++){
                if(visit[k] == false && min > dist[k]){
                    min = dist[k];
                    index = k;
                }
            }
            visit[index] = true;
            s += index + " ";  // 경로를 체크하는 방법

            for(int l = 1; l < N+1; l++){
                if(list[index][l] != 0 && dist[l] > dist[index] + list[index][l]){ //인접 행렬을 검사하여 최적의 값을 찾아
                        dist[l] = dist[index] + list[index][l];
                }

            }
        }
        if(dist[N]!=inf)
        	System.out.println(dist[N]);
        else
        	System.out.println("-1");
    }

}
