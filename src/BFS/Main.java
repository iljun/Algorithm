package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

    }

    static List<List<Integer>> list;//정점 인접리스트
    static int N;//정점 리스트 갯수

    public void BFS(Integer start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visited = new boolean[N];
        visited[start] = true;

        while(!queue.isEmpty()){
            Integer currentPoint = queue.poll();

            for(int i=0; i<list.get(currentPoint).size(); i++){
                Integer nextPoint = currentPoint + list.get(currentPoint).get(i);

                if(!visited[nextPoint]){
                    queue.offer(nextPoint);
                    visited[nextPoint] = true;
                }
            }
        }
    }
}

class Point{
    int x;
    Point nextPoint;

    public Point(int x){
        this.x = x;
        this.nextPoint = null;
    }
}
