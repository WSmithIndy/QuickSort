package org.wtsmith.cards;
/**
 * Creates a stack of Cards use the push/pop paradigm
 * 

 * Note a stack is a Last in First out ... this is NOT a sorted
 * data set
 * 
 * @author WT Smith 
 * @version 1/4/17
 */
import java.util.ArrayList;
public class CardStack
{
    protected ArrayList<Card> cardStack = new ArrayList<Card>();
    
    public void push(Card newCard)
    {
        //add a card to the end ... this is the (top) of the stack
        cardStack.add(newCard);
    }
    
    public Card pop()
    {  
        if( cardStack.size() >0) {
            // remove the last card in the list ... this is the (top) of a stack
            return cardStack.remove(cardStack.size()-1);
        }
        else
            return null;
    }

}
