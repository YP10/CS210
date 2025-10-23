/*
 * Copyright 2023 Marc Liberatore.
 */

package lists;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {
    // Note: do not declare any additional instance variables
    Node<E> head;
    Node<E> tail;
    int size;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Node<E> n = head;
        while (n != null) {
            result = prime * result + n.data.hashCode();
            n = n.next;
        }
        result = prime * result + size;
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof List))
            return false;
        List other = (List) obj;
        if (size != other.size())
            return false;
        if(hashCode()!=other.hashCode()){
            return false;
        }
        // Part 1 List Data Type and Implementations
        // TASK: Complete the equals method to ensure all corresponding
        // elements in both lists are equal before confirming the lists as
        // identical.
        return true;
    }

    @Override
    public int size() {
        // Part 1 List Data Type and Implementations
        // TASK: Implement the size method to correctly return the current
        // number of elements in the list.
        return size;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        if(index==0){
            return head.data;
        }
        if(index==size-1){
            return tail.data;
        }
        Node<E>indexNode=head;
        for(int i=0;i<index;i++){
            indexNode=indexNode.next;
        }
        return indexNode.data;
        // Part 1 List Data Type and Implementations
        // TASK: Implement the get method to retrieve the element at the
        // specified index, checking for bounds and utilizing tail optimization
        // for the last element.
    }

    @Override
    public void add(E e) {
        if(size==0){
            head=new Node<E>(e);
        }
        else{
            Node<E> lastNode=head;
            while(lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=new Node<E>(e);
            tail=lastNode.next;
            
        }
        size++;
        // Part 1 List Data Type and Implementations
        // TASK: Implement the add method to append a new element to the end of
        // the list. Ensure the head and tail pointers are correctly managed in
        // cases where the list is initially empty or already contains elements.
    }

    @Override
    public void add(int index, E e) throws IndexOutOfBoundsException {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        else if(index==size){
            add(e);
            return;
        }
        else if(size==0){
            head=new Node<>(e);
            tail=head;
        }
        else if(index==0){
            Node<E>newNode=new Node<>(e);
            newNode.next=head;
            head=newNode;
        }
        else{
            Node<E>indexNode=head;
            for(int i=0;i<index-1;i++){
                indexNode=indexNode.next;
            }
            Node<E>newNode=new Node<>(e);
            newNode.next=indexNode.next;
            indexNode.next=newNode;

        }
        size++;
        // Part 1 List Data Type and Implementations
        // TASK: Implement the add method to insert an element at a specified
        // index within the list. Handle several cases:
        // 1. Index bounds: Throw IndexOutOfBoundsException if the index is out
        // of bounds.
        // 2. Append: If adding at the end of the list,
        // simply append the element.
        // 3. Empty list: If the list is empty, initialize both head and tail
        // properly.
        // 4. Insert at head: If adding at the start (index 0), update the head
        // properly.
        // 5. General insertion: If inserting elsewhere, navigate to the node
        // currently at the position before the desired index, insert the new
        // node, and adjust pointers accordingly. Ensure size is incremented
        // after insertion to reflect the new total number of elements in the
        // list.
        //
        // NOTE: In class we studied a version of this `add` method that threw
        // an exception when add(size of list, e) was called. In this version,
        // we are asking you to allow add(size of list, e) to work.
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        Node<E>tempNode;
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        else if(size==1){
            tempNode=head;
            head=null;
            tail=null;
        }
        else if(index==0){
            tempNode=head;
            head=head.next;
        }
        else{
            Node<E>indexNode=head;
            for(int i=0;i<index-1;i++){
                indexNode=indexNode.next;
            }
            if(indexNode.next==tail){
                tempNode=tail;
                tail=indexNode;
                indexNode.next=null;
            }
            else{
                tempNode=indexNode.next;
                indexNode.next=indexNode.next.next;
            } 
        }
        size--;
        return tempNode.data;
        // Part 1 List Data Type and Implementations
        // TASK: Implement the remove method to properly handle the deletion of
        // an element at a given index. Consider the following:
        // 1. Validate the index to ensure it falls within acceptable bounds. If
        // not, throw an IndexOutOfBoundsException.
        // 2. Consider special cases based on the size and structure of the
        // list:
        // - Handle scenarios where the list is reduced to an empty state.
        // - Address removals from the beginning of the list, adjusting head
        // and potentially tail if needed.
        // - Manage removals from other positions within the list, ensuring
        // to maintain proper linkages and tail position if the last
        // element is removed.
        // 3. Always update the list size accordingly and return the data of the
        // removed element. This approach requires careful pointer
        // manipulation and consideration of list integrity at every step.
    }

    @Override
    public E set(int index, E e) throws IndexOutOfBoundsException {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<E>indexNode=head;
        for(int i=0;i<index;i++){
            indexNode=indexNode.next;
        }
        E temp=indexNode.data;
        indexNode.data=e;
        return temp;
        // Part 1 List Data Type and Implementations
        // TASK: Implement the set method to update an element at a specified
        // index with a new value and return the old value. Consider the
        // following:
        // 1. Ensure the index is within the valid range of the list. If it is
        // out of bounds, throw an IndexOutOfBoundsException.
        // 2. Traverse the list to locate the node at the given index.
        // 3. Replace the existing data at that node with the new element and
        // return the old data. Careful consideration of list traversal and
        // data manipulation is required to maintain list integrity and
        // functionality.
    }

    @Override
    public int indexOf(E e) {
        if(size==0){
            return -1;
        }
        int index=0;
        Node<E>indexOfNode=head;
        while(indexOfNode!=null){
            if(indexOfNode.data.equals(e)){
                return index;
            }
            indexOfNode=indexOfNode.next;
            index++;
        }
        // Part 1 List Data Type and Implementations
        // TASK: Implement the indexOf method to find and return the index of
        // the first occurrence of the specified element in the list. If the
        // element is not found, return -1. Consider iterating through the list
        // from the head, checking each element for equality with the provided
        // value. Ensure the method handles cases where the list may be empty or
        // the element does not exist in the list.
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        // PART 2 Iterators
        // TASK: Implement the iterator method to return an Iterator for the
        // current collection. Ensure that the Iterator allows sequential access
        // to elements in the correct order.
        return new LinkedListIterator<>(head);
    }
}