package src.main.java.de.uulm.sp.oop.exercises.e06;

import java.util.HashMap;

public class HashMapArray<T> {
    private HashMap<Integer, T> map;
    private int size;

    public HashMapArray() {
        map = new HashMap<>();
    }

    public void add(int key, T value){
        if(key < 0){
            throw new IndexOutOfBoundsException();
        }
        map.put(key, value);
    }

    public <T> T get(int key){
        if(key < 0 || key >= map.size()){
            throw new IndexOutOfBoundsException();
        }
        return (T) map.get(key);
    }

    public int size(){
       return map.size();
    }

}
