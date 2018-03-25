package test;

import sun.misc.LRUCache;

import java.util.*;

public class Main {
    public static void main(String[] args){
        LFU lru = new LFU();
        lru.put("A");
        lru.put("B");
        lru.put("C");
        lru.get("A");
        System.out.println(lru.toString());
        lru.put("B");
        System.out.println(lru.toString());
        lru.put("C");
        System.out.println(lru.toString());
        lru.put("D");
        lru.put("E");
        System.out.println(lru.toString());
        lru.put("D");
        System.out.println(lru.toString());
        lru.put("Z");
        System.out.println(lru.toString());
    }

}
class Node{
    String name;
    int cnt;
    public Node(String name){
        this.name = name;
        this.cnt = 1;
    }

    @Override
    public boolean equals(Object obj){
        if(obj.getClass()!=Node.class)
            return false;

        Node node = (Node)obj;
        if(node.name.equals(this.name))
            return true;
        return false;
    }
}
class LFU{//가장 적게 사용된것
    private static final int SIZE = 5;
    Map<String,Integer> map = new HashMap<>();

    public String get(String obj){
        if(map.containsKey(obj)){
            map.put(obj,map.get(obj)+1);
            return obj;
        }
        return null;
    }

    public void put(String obj){
        if(!map.containsKey(obj)){
            if(map.size()>=SIZE){
                Set<String> key = map.keySet();
                int min = Integer.MAX_VALUE;
                String minKey = null;
                for(String t : key){
                    if(min>map.get(t)){
                        min = map.get(t);
                        minKey = t;
                    }
                }

                map.remove(minKey);
                map.put(obj,1);
            }else{
                map.put(obj,1);
            }
        }
    }

    @Override
    public String toString(){
        return String.format("LFU( %s )",this.map.toString());
    }
}

class LRU{//가장 오랫동안 사용되지 않은것
    Map<String,String> map = new HashMap<>();
    List<String> list = new LinkedList<>();
    private static final int SIZE = 5;

    public String get(String obj){
        String value = map.get(obj);
        if(value!=null){
            list.remove(value);
            list.add(value);
            return value;
        }
        return null;
    }

    public void put(String obj){
        if(map.containsKey(obj)){
            list.remove(obj);
            list.add(obj);
        }else{
            if(list.size()>=SIZE){
                map.remove(list.remove(0));
            }
            map.put(obj,obj);
            list.add(obj);
        }
    }

    @Override
    public String toString(){
        return String.format("LRU( %s )",this.list.toString());
    }
}
