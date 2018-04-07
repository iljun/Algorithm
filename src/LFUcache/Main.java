package LFUcache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LFU cache = new LFU();
        cache.put(1);
        System.out.println(cache.toString());
        cache.put(2);
        cache.put(3);
        cache.put(4);
        cache.put(5);
        System.out.println(cache.toString());
        cache.get(3);
        System.out.println(cache.toString());
        cache.put(6);
        System.out.println(cache.toString());
        cache.put(8);
        System.out.println(cache.toString());
        cache.get(2);
        System.out.println(cache.toString());
        cache.put(9);
        System.out.println(cache.toString());

    }
}

class LFU{
    Map<Integer,Integer> map;
    private static final int SIZE = 5;
    public LFU(){
        map = new HashMap<>();
    }

    public void put(Integer value){
        if(map.size()>SIZE){
            this.delete();
            map.put(value,1);
        }else{
            map.put(value,1);
        }
    }

    public void delete(){
        Set<Integer> set = map.keySet();

        int min = Integer.MAX_VALUE;
        for(Integer i : set){
            min = Math.min(map.get(i),min);
        }

        map.remove(min);
    }

    public int get(int value){
        Integer key = map.get(value);
        map.put(value,map.get(value)+1);
        return key;
    }

    @Override
    public String toString(){
        return String.format("LFU( map = %s )",this.map.toString());
    }
}