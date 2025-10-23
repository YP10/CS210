/*
 * Copyright 2023 Marc Liberatore.
 */

 package treaps;

 import java.util.ArrayList;
 import java.util.List;

 
 
 public class Treap<E extends Comparable<E>> {
     Node<E> root;
     int size;
 
     public int size() {
         return size;
     }
 
     /**
      * Return true iff the tree contains the value e.
      * 
      * @param e
      * @return true iff the tree contains the value e
      */
     public boolean contains(E e) {
         return find(e) != null;
     }
 
     private Node<E> find(E e, Node<E> n) {
         if (n == null) {
             return null;
         } else if (e.equals(n.data)) {
             return n;
         } else if (e.compareTo(n.data) < 0) { // left
             return find(e, n.left);
         } else { // right
             return find(e, n.right);
         }
     }
 
     private Node<E> find(E e) {
         return find(e, root);
     }
 
 
     /**
      * Perform an in-order traversal of the tree rooted at the given node, and
      * return a list of the elements in the order they were visited.
      * 
      * @param node
      * @return a list of elements from the tree from an in-order traversal starting
      *         at node
      */
     static <E> List<E> inOrder(Node<E> node) {
         ArrayList<E>result=new ArrayList<>();
         return inOrderHelper(node,result);
         
         // TASK 1: Add your implementation here.
     }
     static <E>List<E> inOrderHelper(Node<E>node,List<E>elements){
         if(node==null){
            return elements;
         }
        inOrderHelper(node.left,elements);
        elements.add(node.data);
        inOrderHelper(node.right,elements);
         return elements;
     }
 
     /**
      * Returns true iff the tree rooted at n is a Binary Search Tree (based on
      * its data values).
      * 
      * It must have no more than two children per node.
      * 
      * Each node's data value must be greater than all the values in its left
      * subtree, and smaller
      * than all the values in its right subtree. (This implies duplicate values
      * are not allowed.)
      * 
      * @param n true iff the tree rooted at n is a Binary Search Tree
      * @return
      */
     static <E extends Comparable<E>> boolean isBST(Node<E> n) {
         List<E>test=inOrder(n);
         for(int i=0;i<test.size()-1;i++){
             if(test.get(i).compareTo(test.get(i+1))>=0){ //Checks both sorted and duplicates
                 return false;
             }
         }
         return true;
         
         // TASK 2: Add your implementation here.
     }
     
 
     /**
      * Returns true iff the tree rooted at n is heap (based on its priority
      * values). It must have no more than two children per node.
      * 
      * Each node's priority value must be greater than or equal to all the
      * values in its children.
      * 
      * @param n true iff the tree rooted at n is a Binary Search Tree
      * @return
      */
     static <E extends Comparable<E>> boolean isHeap(Node<E> n) {
         if(n==null){
             return true;
         }
         if(n.left!=null){
             if(n.left.priority>n.priority){
                 return false;
 
             }
         }
         if(n.right!=null){
             if(n.right.priority>n.priority){
                 return false;
             }
         }
         return isHeap(n.left)&&isHeap(n.right);
     }
 
         // TASK 3: Add your implementation here.    }
 
     /**
      * Adjust the treap to restore the max-heap property
      * by rotating node n up, if needed, and then repeating, if needed.
      * 
      * This is the method that takes the place of siftUp() for a Treap.
      * 
      * Note that duplicate *priority* values *are* allowed.
      * 
      * @param n
      */
     void adjustUp(Node<E> n) {
         if(n==null||n==root||n.parent==null){
             return;
         }

         else if(n.parent.left==n){
             if(n.parent.priority<(n.priority)){
                rotateLL(n.parent);
            }
             else{
                 return;
             }
         }
         else{
             if(n.parent.priority<(n.priority)){
                rotateRR(n.parent);
            }
        
             else{
                 return;
             }
 
         }
         adjustUp(n);
         
         
         // TASK 4A: Add your implementation here.
         // Review the code below for `add(E e)` and `add(E e, Node<E> node)`. 
         // After you have implemented `adjustUp(Node<E> n)`, you should be able
         // to call it from the appropriate place(s) in the `add(E e, Node<E> 
         // node)` method. This will complete the implementation for `add`.
     }
 
     /**
      * Add the value e to the treap, maintaining the BST and heap properties.
      * 
      * @param e
      */
     public void add(E e) {
         // Do not modify this method.
         if (root == null) {
             root = new Node<>(e);
             size = 1;
             return;
         }
         add(e, root);
     }
 
     /**
      * Add the value e to the treap rooted at the given node,
      * maintaining the BST and heap properties.
      * 
      * @param e
      * @param node
      */
     public void add(E e, Node<E> node) {
         // TASK 4B: This is the second part to TASK 4. You need to add a call to
         // adjustUp() in the code below in the appropriate place(s).
         if (e.equals(node.data)) {
             node.data = e;
         }
         if (e.compareTo(node.data) < 0) {
             if (node.left == null) {
                 node.left = new Node<>(e, node);
                 size++;
                 adjustUp(node.left);
             } else {
                 add(e, node.left);
             }
         } else {
             if (node.right == null) {
                 node.right = new Node<>(e, node);
                 size++;
                 adjustUp(node.right);
             } else {
                 add(e, node.right);
             }
         }
     }
 
     /**
      * Perform an LL rotation around n.
      * 
      * @param n
      */
     private void rotateLL(Node<E> n) {
         Node<E> A, B, T1, T2, T3, p; // p is B's parent ; note we never use T1 or T3!
         
         B = n;
         p = B.parent;
         A = B.left;
         T1 = A.left;
         T2 = A.right;
         T3 = B.right;
         
         
         // making A the root of the subtree
         if (B == root) { // special case: B was the root of the *whole* tree
             root = A;
             A.parent = null;
         } else { // otherwise, B was just a node in the tree, not its root
             if (p.left == B) {
                 p.left = A;
             } else {
                 p.right = A;
             }
             A.parent = p;
         }
 
         // now let's make B into A's right subchild
         A.right = B;
         B.parent = A;
 
         // finally, let's move T2 to B's new left subchild
         B.left = T2;
         if (T2 != null) {
             T2.parent = B;
         }
     }
 
     /**
      * Perform an RR rotation around n.
      * 
      * @param n
      */
     private void rotateRR(Node<E> n) {
        Node<E> a, b, parent, t1,t2,t3;
         

         a = n;
         parent = a.parent;
         b = a.right;
         t1=a.left;
         t2 = b.left;
         t3=b.right;
         
        
         if(a==root){
             root=b;
             b.parent=null;
         }
         else{
             if(parent.left==a){
                 parent.left=b;
             }
             else{
                 parent.right=b;
             }
             b.parent=parent;
         }
         b.left=a;
         a.parent=b;

         a.right=t2;
         if(t2!=null){
             t2.parent=a;
         }
         // TaSK 5: Add your implementation here.
     }
 
     public static void main(String[] args) {
         Treap<Integer> t = new Treap<>();
 
         for (int i = 0; i < 15; i++) {
             t.add(i);
             TreePrinter.print(t.root);
             System.out.println(isBST(t.root) + "/" + isHeap(t.root));
         }
     }
 }