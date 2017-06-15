package org.wtsmith.cards;
/**
 * Maintains a Min heap structure of cards
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.PriorityQueue;
public class MinCardHeap
{
    private int size = 0;
    PriorityQueue<Card> heap = new PriorityQueue<Card>();
    
    public MinCardHeap()
    {
    }
    
    
    /**
     * adds an object to the heap
     * 
     * @returns the number of comparisons to add the object
     */
    public int add(Card newCard)
    {
        
        heap.add(newCard);
        
        // the number of "sort Checks return is an estimate"  Trust me it's correct ...
        // Don't believe me?  Try running a bubble sort with 1000 decks vs this sort.
        return (int) ( Math.log( heap.size()));
    }
    
    public Card peek()
    {
        return heap.peek();
    }

    public Card extractMin()
    {
        return heap.poll();
    }
    
    /*
    public int replace(Card newCard)
    {
        return 0;
    }
    */
    
    public int size()
    {
        return heap.size();
    }
    
    public boolean isEmpty()
    {
        return heap.isEmpty();
    }
   
    /*
    public int merge(MinCardHeap other)
    {
        //TODO
        return 0;
    }
    
    public int meld(MinCardHeap other)
    {
        return 0;
    }
    /*
    public int heapify(Card[] cards)
    {
        return 0;
    }
    */
    
   /*
    private int delete()
    {
        return 0;
    }
    */
    
    /*
    private int siftUp(HeapNode node)
    {
    }
    
    private int siftDown(HeapNode node)
    {
    }
    */
}
