package hashtables;

import com.sun.source.tree.CompilationUnitTree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An implementation of HashTable.
 * 
 * This implementation uses chaining to resolve collisions. Chaining means 
 * the underlying array stores references to growable structures (like 
 * LinkedLists) that we expect to remain small in size. When there is a 
 * collision, the element is added to the end of the growable structure. It
 * must search the entire growable structure whenever checking membership
 * or removing elements.
 * 
 * This implementation maintains a capacity equal to 2^n - 1 for some positive
 * integer n. When the load factor exceeds 0.75, the next add() triggers a
 * resize by incrementing n (by one). For example, when n=3, then capacity=7.
 * When size=6, then load factor ~=0.86. The addition of the seventh item would
 * trigger a resize, increasing the capacity of the array to 15.
 */
public class ChainingHashTable<E> implements HashTable<E> {
    private LinkedList<E>[] table;
    private int size;
    private int n;
    private int capacity;
    /**
     * Instantiate a new hash table. The initial capacity should be 7.
     */
    public ChainingHashTable() {
        
        this.n=3;
        this.size=0;
        this.capacity=computeCapacity();
        table=(LinkedList<E>[])new LinkedList[this.capacity];
        

        // TASK 1: Ah, the humble constructor. Set `n` to 3.         
        // Initialize the table with just enough room for now — think of it as the
        // cozy starter home of hash tables.
    }

    /**
     * Instantiate a new hash table. The initial capacity should be 
     * at least sufficient to hold n elements, but must be one less
     * than a power of two.
     */
    public ChainingHashTable(int n) {
        this.n=1;
        while(computeCapacity()<n){
            this.n++;
        }
        this.capacity=computeCapacity();
        this.size=0;
        table=(LinkedList<E>[])new LinkedList[this.capacity];
        // TASK 2: This constructor requires some mathematical magic. Compute
        // `n` as if you were a sorcerer seeking the perfect table size.
        // The result? A capacity that’s *just right* for your element-hungry
        // table.
    }

    @Override
    public int capacity() {   
        return this.capacity;     
        // TASK 3: Here’s the easy one. Return the capacity like a proud parent
        // showing off their child's height chart.        
    }

    @Override
    public int size() {
        return this.size;
        // TASK 4: How big is your hash table? This method knows.         
        // Return the size like you're counting jellybeans in a jar — except the
        // jar is your data structure.        
    }

    @Override
    public double loadFactor() {
        return (double) this.size/(double) this.capacity;

        // TASK 5: Calculate the load factor like you're a weather forecaster,
        // predicting the chance of resizing.        
        // Hint: if it’s above 0.75, it’s going to be a resize storm!
    }
    public void enlarge(){
        this.n++;
        this.capacity=computeCapacity();
        LinkedList<E>[] newTable=(LinkedList<E>[])new LinkedList[this.capacity];
        for(int i=0;i<table.length;i++){
            if(table[i]!=null){
                for(E element:table[i]){
                    int index=Math.abs(element.hashCode())%this.capacity;
                    if(newTable[index]==null){
                        newTable[index]=new LinkedList<E>();
                    }
                    newTable[index].add(element);

                }

            }
        }
        table=newTable;
    }
    
    @Override
    public boolean add(E e) {
        if(loadFactor()>0.75){
            enlarge();
        }
        boolean added=true;
        int hash=Math.abs(e.hashCode());
        int index=hash%this.capacity;
        if(table[index]==null){
            table[index]=new LinkedList<E>();
        }

        if(table[index].contains(e)){
            remove(e);
            added=false;
        }
        table[index].add(e);
        this.size++;
        return added;
        // TASK 6: Add an element to the hash table. If things get too crowded
        // (load factor > 0.75), sound the alarm and call `enlarge()`.        
        // Think of it like adding chairs to a party—don't let guests (elements)
        // stand!        
    }

    @Override
    public boolean remove(E e) {
        int hash=Math.abs(e.hashCode()); 
        int index=hash%this.capacity;
        if(table[index]==null){
            return false;
        }
        if(table[index].contains(e)){
            table[index].remove(e);
            this.size--;
            return true;
        }
        // TASK 7: Attempt to remove an element. If it’s not there, shrug and
        // return false. If you find it, remove it like a piece of old code that
        // no longer sparks joy.        
        return false;
    }
    
    @Override
    public boolean contains(E e) {
        int hash=Math.abs(e.hashCode());
        int index=hash%this.capacity;
        if(table[index]==null){
            return false;
        }
        return table[index].contains(e);      
        // TASK 8: Is your element in the table? Find out! If it's there,
        // celebrate with a triumphant return `true`. If not, return `false`
        // like a disappointed treasure hunter.
    }
    
    @Override
    public E get(E e) {
        int hash=Math.abs(e.hashCode());
        int index=hash%this.capacity;

        if(table[index]!=null){
            for(E element:table[index]){
                if(e.equals(element)){
                    return element;
                }
            }
        }
        return null;

        // TASK 9: Retrieve the element from your hash table—like searching for
        // a needle in a haystack, if your haystack had neat little slots. If
        // it's there, return it with a flourish. If not, return `null` with a
        // sigh.
    }

    @Override
    public Iterator<E> iterator() {
        return new HashTableIterator(table,size());
    }
    
    public class HashTableIterator implements Iterator<E>{
        private int tableIndex;
        private int listIndex;
        private int count;
        private int size;
        private LinkedList<E>[] table;

        public HashTableIterator(LinkedList<E>[] table,int size){
            this.count=0;
            this.size=size;
            this.table=table;
        }
        @Override
        public boolean hasNext(){
            return (count<size);
        }
        @Override
        public E next(){

            if(!hasNext()){
                throw new NoSuchElementException();
            }
            while(tableIndex<table.length&&(table[tableIndex]==null||table[tableIndex].isEmpty())){
                tableIndex++;
                listIndex=0;
            }
            E value=table[tableIndex].get(listIndex);
            if(listIndex==table[tableIndex].size()-1){
                tableIndex++;
                listIndex=0;
                count++;
                return value;
            }
            listIndex++;
            count++;
            return value;
        } 
    }
        // TASK 10: Time for some iteration magic. Hand back an iterator that
        // will bravely traverse your hash table, item by item.
    
    /**
     * Computes the capacity of the hash table as 2^n - 1, where n is an integer
     * representing the growth factor of the table.
     * 
     * This method serves several key purposes:
     * 
     * 1. **Prime-Like Capacity**: By setting the capacity to 2^n - 1, the table
     *    avoids even capacities, reducing the likelihood of hash collisions and
     *    improving the distribution of elements across the buckets.
     * 
     * 2. **Controlled Resizing**: `computeCapacity` is used during resizing when
     *    the load factor exceeds the threshold (0.75). Each time `n` increments,
     *    the capacity approximately doubles, balancing memory usage and
     *    performance by keeping the load factor within an optimal range.
     * 
     * 3. **Improved Hashing**: The computed capacity is used as the modulus in the
     *    hash function, helping to distribute elements more evenly. Using a
     *    non-even divisor reduces clustering in buckets, especially with keys
     *    that have sequential or similar hash codes.
     * 
     * 4. **Dynamic Growth**: Setting the capacity to powers of two minus one 
     *    allows for efficient, consistent doubling of capacity, ensuring the
     *    hash table scales smoothly with the number of elements added.
     * 
     * @return the computed capacity as 2^n - 1
     */
    private int computeCapacity() {
        return (int) (Math.pow(2, n) - 1);
    }
}

    