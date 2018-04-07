package LRUcache;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        LRU cache = new LRU();
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

class LRU{
    List<Integer> list;
    private static final int SIZE = 5;

    public LRU(){
        list = new ArrayList<>();
    }

    public void put(int value){
        if(list.size()>5){
            list.remove(0);
            if(contains(value)==-1)
                list.add(value);
        }else{
            if(contains(value)==-1)
                list.add(value);
        }
    }

    public Integer get(int value){
        Integer result = null;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==value){
                result = value;
                back(i);
            }
        }

        return result;
    }

    public void back(int index){
        Integer tmp = list.get(index);
        list.remove(index);
        list.add(tmp);
    }

    public int contains(int value){
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        return String.format("LRU( list = %s )",this.list.toString());
    }
}
