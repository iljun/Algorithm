package MaxHeap_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
	}

}
class Node{
	int value;
	Node left;
	Node right;

	public Node(int value){
		this.value=value;
		this.left = null;
		this.right = null;
	}
}
class MaxHeap{
	static Node root;
	static Node lastNode;

	public MaxHeap(){
		root=null;
	}

	public void add(int value){
		Node newNode = new Node(value);
		if(root==null){
			root=newNode;
		}else{
			Node temp =search(root);
			temp=newNode;
		}
	}

	public Node search(Node temp){
		if(temp.left!=null && temp.right!=null){
			search(temp.left);
			search(temp.right);
		}else if(temp.left!=null && temp.right==null)
			return temp.left;
		else
			return temp.right;
		return null;
	}
	public int remove(){

		return 0;
	}

	public void sort(){
		Node temp = root;
		while(true){

		}
	}
}