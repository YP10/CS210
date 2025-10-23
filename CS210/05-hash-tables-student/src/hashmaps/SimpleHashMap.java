/*
 * Copyright 2023 Marc Liberatore.
 */
package hashmaps;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import hashtables.ChainingHashTable;


/**
 * An implementation of a SimpleMap, built using the ChainingHashTable and 
 * SimpleMapEntry classes. This class should behave similarly to the built-in
 * java.util.HashMap, though it is much simpler!
 */
public class SimpleHashMap<K, V> implements SimpleMap<K, V> {
    private ChainingHashTable<SimpleMapEntry<K, V>> table;

    public SimpleHashMap() {
        table= new ChainingHashTable<>();
        

        // TASK 1: Constructor for SimpleHashMap. Just like any good story, this
        // constructor sets the stage by initializing our ChainingHashTable.
    }

    @Override
    public int size() {
        return table.size();
        // TASK 2: Time to count how many key-value pairs are partying in your
        // SimpleHashMap. Return the current guest count
    }

    @Override
    public void put(K k, V v) {
        SimpleMapEntry<K,V> entry=new SimpleMapEntry<>(k,v);
        table.add(entry);
        




        // TASK 3: Add a new key-value pair to the map, or update it if the
        // key’s already there. Think of it like updating a name tag at a
        // conference—swap the old value out for the new one!
    }

    @Override
    public V get(K k) {
        if(k==null){
            return null;
        }
        SimpleMapEntry<K,V>entry=new SimpleMapEntry<>(k,null);
        SimpleMapEntry<K,V>result=table.get(entry);
        if(result==null){
            return null;
        }
        return result.v;

        

        // TASK 4: Retrieve the value for the given key. If it's not there,
        // return `null` like a disappointed parent searching for their missing
        // car keys.
    }

    @Override
    public V getOrDefault(K k, V defaultValue) {
        V value=get(k);
        if(value==null){
            return defaultValue;
        }
        return value;
    
        // TASK 5: A close cousin to `get()`, but with a safety net! If the key
        // isn't there, return the `defaultValue`. It’s like having a fallback
        // playlist when your favorite song isn’t on Spotify.
    }

    @Override
    public V remove(K k) {
        V value=get(k);
        SimpleMapEntry<K,V>entry=new SimpleMapEntry<>(k,value);
        boolean removed=table.remove(entry);
        if(removed){
            return value;
        }
        
        // TASK 6: Remove the key-value pair from the map like deleting an
        // embarrassing old tweet. Return the value if successful, otherwise
        // return `null`—no harm, no foul.
        return null;
    }

    @Override
    public Set<K> keys() {
        Set<K> collectedKeys = new HashSet<>();
        Iterator<SimpleMapEntry<K, V>> iteration = table.iterator();
        while(iteration.hasNext()){
            collectedKeys.add(iteration.next().k);
        }

        // TASK 7: Collect all the keys like you're on a treasure hunt. Store
        // them in a Set, because duplicates are for amateurs. Return your
        // shiny key collection!
        return collectedKeys;
    }    
}