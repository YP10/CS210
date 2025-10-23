/*
 * Copyright 2023 Marc Liberatore.
 */

package heaps;

import java.util.Arrays;
import java.util.Random;

public class HeapUtilities {
    /**
     * Returns true iff the subtree of a starting at index i is a max-heap.
     * 
     * @param a an array representing a mostly-complete tree, possibly a heap
     * @param i an index into that array representing a subtree rooted at i
     * @return true iff the subtree of a starting at index i is a max-heap
     */
    static boolean isHeap(double[] a, int i) {
        // TASK 1: Add your implementation here.
        if(a.length==0){
            return true;
        }
        while(i<a.length){
            double root=a[i];
            int left=2*i+1;
            int right=2*i+2;

            if(left<a.length){
                if(a[left]>root){
                    return false;
                }
            }
            if(right<a.length){
                if(a[right]>root){
                    return false;
                }
            }
            i++;
        }
        return true;
    }
    /**
     * Swap the elements at indices i and j in the array a.
     * 
     * @param a the array
     * @param i the first index
     * @param j the second index
     */
    static void swap(double[] a, int i, int j) {
        double temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        // TASK 2: Add your implementation here.
    }

    /**
     * Perform the heap siftdown operation on index i of the array a.
     * 
     * This method assumes the subtrees of i are already valid max-heaps.
     * 
     * This operation is bounded by n (exclusive)! In a regular heap,
     * n = a.length, but in some cases (for example, heapsort), you will
     * want to stop the sifting at a particular position in the array.
     * siftDown should stop before n, in other words, it should not
     * sift down into any index great than (n-1).
     * 
     * @param a the array being sifted
     * @param i the index of the element to sift down
     * @param n the bound on the array (that is, where to stop sifting)
     */
    static void siftDown(double[] a, int i, int n) {
        while(i<n){
            int left=2*i+1;
            int right=2*i+2;
            int compare=i;
            if(left<n&&a[left]>a[compare]){
                compare=left;
            }

            if(right<n&&a[right]>a[compare]){
                compare=right;
            }
            
            if(compare!=i){
                swap(a,i,compare);
                i=compare;
            }
            else{
                return;
            }

        }
        // TASK 3: Add your implementation here.
    }

    /**
     * Heapify the array a in-place in linear time as a max-heap.
     * 
     * @param a an array of values
     */
    static void heapify(double[] a) {
        int n=a.length;
        int i=(n/2)-1;
        while(i>=0){
            siftDown(a, i, n);
            i--;
        }
        
        // TASK 4: Add your implementation here.
    }

    /**
     * Heapsort the array a in-place, resulting in the elements of
     * a being in ascending order.
     * 
     * @param a
     */
    static void heapSort(double[] a) {
        heapify(a);
        int n=a.length-1;
        int i=0;
        while(n>0){
            swap(a,i,n);
            n--;
            siftDown(a, i, n+1);
        }



        // TASK 5: Add your implementation here.
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        Random r = new Random(0);
        int length = 15;
        double[] l = new double[length];
        for (int i = 0; i < length; i++) {
            l[i] = r.nextInt(20);
        }
        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(l));
        heapSort(l);
        System.out.println(Arrays.toString(l));
    }
}