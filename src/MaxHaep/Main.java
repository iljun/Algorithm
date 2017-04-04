package MaxHaep;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		maxHeap heap = new maxHeap(size);
		int x;
		for(int i=0; i<size; i++){
			x=input.nextInt();
			if(x==0){
				System.out.println(heap.remove());
			}else{
				heap.add(x);
			}
		}
	}

}
class maxHeap{
	static int[] arr;
	int lastIndex;

	public maxHeap(int size){
		arr = new int[size];
		lastIndex=0;
	}

	public void add(int value){
		arr[lastIndex]=value;
		lastIndex++;
		sort();
	}

	public int print(){
		return arr[0];
	}

	private void sort(){
		int i=0;
		while(i*2+2<=lastIndex){
			if(arr[i] < arr[i*2] && arr[i] < arr[(i*2) - 1]){
				if(arr[i] < arr[i*2]){
					swap(i,i*2+1);
					i=i*2;
				}else{
					swap(i,(i*2)+2);
					i=(i*2)-1;
				}
			}else if(arr[i] < arr[i*2+1]){
				swap(i,i*2+1);
				i=i*2;
			}else if(arr[i] < arr[(i*2)+2]){
				swap(i,(i*2)+2);
				i= (i*2)+2;
			}else
				i++;
		}
	}

	private void swap(int index1, int index2){
		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}

	public int pool(){
		int temp=arr[0];
		return temp;
	}

	public int remove(){
		if(arr[0]==0)
			return 0;
		int temp = arr[lastIndex--];
		int value = arr[0];
		arr[0] = temp;
		sort();
		return value;
	}

}
