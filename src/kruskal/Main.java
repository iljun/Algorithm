package kruskal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

    }

    public void kruskal(PriorityQueue<Edge> queue){

    }
}
class Edge implements Comparable<Edge> {
    int x;
    int y;
    int cost;

    public Edge(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
