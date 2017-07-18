package BackJun_9426;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		N = input.nextInt();
		K = input.nextInt();
		arr = new int[N+1];

		for(int i=1 ;i<arr.length; i++){
			arr[i]=input.nextInt();
		}

		input.close();

		long sum=0;
		int i=1;
		while(i+K<=N+1){
			sum+=arr[search(i,i+K-1,((K+1)/2))];
			i++;
		}

		System.out.println(sum);
	}

	static int search(int start, int end, int index){
		int[][] temp =new int[K+2][2];
		int j=0;
		for(int i=start; i<end+1; i++){
			temp[j][0]=i;
			temp[j][1]=arr[i];
			j++;
		}
		Arrays.sort(temp,new Comparator<int[]>(){
			@Override
			public int compare(int[] arr1, int[] arr2){
				if(arr1[1]>arr2[1])
					return 1;
				else
					return -1;
			}
		});

		return temp[index+1][0];
	}
}
