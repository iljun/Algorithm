package BackJun_1197;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V;
	static int E;

	public static void main(String[] args) {//크루스칼 알고리즘 이용
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		E = input.nextInt();

		PriorityQueue<Node> queue= new PriorityQueue<>();

		for (int i = 1; i <= E; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int w = input.nextInt();
			queue.offer(new Node(v1,v2,w));
		}

		int result = 0;
		int v = 0;
		UnionFind unionFind = new UnionFind(V);

		while(!queue.isEmpty() && v<V){
			Node temp = queue.poll();
			if(unionFind.find(temp.v1) == unionFind.find(temp.v2)){
				continue;
			}else{
				unionFind.union(temp.v1, temp.v2);
				result+=temp.weight;
				v++;
			}
		}// cycle 확인 추가 --> tree형식

		System.out.println(result);

		input.close();
	}

}

class Node implements Comparable<Node>{
	int v1;
	int v2;
	int weight;

	public Node(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n) {
		if(this.weight > n.weight)
			return 1;
		return -1;
	}


}
class UnionFind {

    int[] root;

    public UnionFind(int V) {

        root = new int[V + 1];

        initialize();
    }

    public int find(int a) {

        if (root[a] < 0) {

            return a;
        }

        return root[a] = find(root[a]);
    }

    public void union(int a, int b) {

        int root1 = find(a);
        int root2 = find(b);

        // 이미 같은 그룹이라면
        if (root1 == root2) {

            return;
        }

        // 다른 그룹이라면

        // root1의 그룹이 더 작다면 (root1 < root2)
        if (root[root1] > root[root2]) {

            root1 ^= root2;//같으면 0 다르면 1을 대입
            root2 ^= root1;
            root1 ^= root2;
        }

        // root1과 root2를 결합하고, root2의 부모를 roo1로 설정
        root[root1] += root[root2];
        root[root2] = root1;

    }

    private void initialize() {

        for (int i = 0; i < root.length; i++) {

            root[i] = -1;
        }
    }

    // a를 포함하는 그룹의 정점의 개수를 확인하는 함수
    public int size(int a) {

        return -root[find(a)];
    }
}
