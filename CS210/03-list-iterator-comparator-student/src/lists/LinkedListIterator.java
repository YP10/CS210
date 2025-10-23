package lists;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {
  private Node<E> currentNode;

  // PART 2 Iterators and Comparators
  // TASK: Initialize the Node reference for the iterator to track the current
  // position in the linked list.

  LinkedListIterator(Node<E> head) {
    currentNode=head;

    // PART 2 Iterators
    // TASK: Complete the LinkedListIterator constructor to initialize the
    // current node to the head of the linked list, allowing iteration to begin
    // at the start of the list.
  }

  @Override
  public boolean hasNext() {
    if(currentNode!=null){
      return true;
    }
    else{
      return false;
    }
    // PART 2 Iterators
    // TASK: Implement the hasNext method to return true if there are more nodes
    // to iterate over in the linked list. Check whether the current node has a
    // valid reference to continue the iteration.
  }

  @Override
  public E next() {
    E temp=currentNode.data;
    currentNode=currentNode.next;
    return temp;
    
    // PART 2 Iterators
    // TASK: Implement the next method to return the current element in the
    // iteration and advance to the next node. Ensure that a
    // NoSuchElementException is thrown if there are no more elements to return.
  }

}