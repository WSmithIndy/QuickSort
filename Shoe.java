
/**
 * In a casino, multiple decks are combined to make a shoe.
 * The Shoe class extends the deck class to include MULTIPLE decks
 * 
 * @author WT Smith 
 * @version 2/17
 */

import java.util.Random;
import java.util.PriorityQueue;

public class Shoe 
{
    protected int numSortChecks = 0; // a counter of the number of checks required to sort the shoe
    protected int numCards;   // the number of cards in the shoe
    protected int numDecks;   // the number of decks in the shoe
    public Card[] cardAry; // an array to store the cards
    protected Random  rand = new Random();

    protected CardStack myCardStack = new CardStack();
    protected MinCardHeap myCardHeap = new MinCardHeap();
    protected int topCard=0;  // a pointer to the card on to of the "top" of the stack

    protected int nqSortComparisons = 0;

    public boolean debugOn = false;

    /**
     * Create the specified number of decks
     * 
     * @param numDecks - the number of decks to create in this shoe.
     */
    public Shoe(int numDecks)
    {

        // this will construct the remaining decks.

        cardAry = new Card[numDecks*52];
        // create the cards ....
        for (int deckIdx=0; deckIdx<numDecks; deckIdx++)
        {
            for (int suit=0; suit<4; suit++) {
                for( int rank = 1; rank < 14; rank++) {
                    cardAry[(deckIdx*52)+(suit*13+rank-1)] = new Card (Card.numToSuit(suit), rank);
                }
            }
        }
        this.numDecks = numDecks;
        this.numCards = 52*numDecks;
    }

    /**
     * Constructs a partial deck of a particular suit
     * 
     * @param   suit - specifies which suit
     * @param   numCards - specifies a number of cards to make <=13
     * */
    public Shoe(Card.Suit suit, int numCards)
    { 
        cardAry = new Card[numCards];

        int numSuits = numCards / 13;

        for(int deckIdx = 0; deckIdx<= numSuits; deckIdx++)
        {
            int cardsInSuit;
            if(deckIdx == numSuits)
                cardsInSuit = numCards % 13;
            else
                cardsInSuit = 13;
            for(int rankIdx = 1; rankIdx<=cardsInSuit; rankIdx++)
            {
                cardAry[deckIdx*13 + rankIdx-1] = new Card(suit, rankIdx);
            }
        }

        this.numDecks = 0;
        this.numCards = numCards;
    }

    public int bubbleSort()
    {
        /// FOR OLDER PROJECT .... IGNORE
        // ***************** put your code here ******************/
        // OUTER LOOP 
        //loop through each position the number of elements in the loop

        // INNER LOOP, check the sort Position and the index position here.
        // since we will be comparing two cards ... we will only go up to size()-1

        // Compare the check Position to the next position. 
        // If they are out of order ...                              

        // increment the checking counter (so we can gauge the algorithm efficiency)

        // switch the cards ...                 
        // define a temporary card reference, assign the checkPos card to a temp

        // assign the subsequent card to the card a checkPos

        // assign the subsequent position to a temp card

        // ^^^^^^^^^^^^^^  Your code goes above here ^^^^^^^^^^^^^^^^^^^ */

        return numSortChecks;

    }

    public int selectionSort()
    {
        int numSortChecks = 0;
        // make a reference to a temporary Card
        // LEAVE THIS IN STUDENT VERSION
        //Card tempCard = new Card (Card.Suit.Joker, Card.JOKER);
        Card tempCard = null;
        int tempCardPos = -1;

        //******************** OLDER PROJECT ... IGORE *********************
        // OUTER LOOP, this must be done n times 
        // n is the length of the array

        // loop through the array find the LARGEST ITEM 

        // make sure the current position isn't null

        // check to see if this is the smallest card 
        // or if the tempCard is null, then this is the "larget" card

        // set the MAXIMUM card
        // record it's position so we can set that position to null in the array

        // now we've found the LARGEST card
        // push the temporary card onto the stack
        // this is the "LARGEST" card

        // set the old card to null in the array

        // sorting is all done now, we need to put the cards BACK into the array            
        // assign a temporary card to a value popped off the stack

        // put the card into the array based on the count

        return numSortChecks;
    }

    /**
     * Sorts the deck using a heap
     * 
     * @ 
     */
    public int insertionSort()
    {
        // initialize the number of sort checks to 0
        int numSortChecks = 0;

        /**  FOR INSERTION SORT, EPUT YOUR CODE HERE **/

        // Loop through the array of cards ... put each one in the heap
        // add to the heap ... increase the number of sort checks based
        // on the number returned from myCardHeap.add(  )

        // Loop over all the card in the heap, keep a counter as to which card 
        // number we are on
        // use extractMin() to remove a card from the heap
        // place this card into the array at the appropriate position.
        // iuncrement the numChecks variable

        return numSortChecks;
    }

    public int beginQuickSort()
    {
        this.nqSortComparisons =0;

        quickSort(0, cardAry.length-1);

        if(this.debugOn) {
            System.err.println("After Completed Sort");
            System.err.println(this.toString());
        }

        return this.nqSortComparisons;
    }

    private void quickSort(int leftPos, int rightPos)
    {

        int pivotIndex;

        if (leftPos == rightPos)
            return;

        this.nqSortComparisons++;

        // check to see if the difference in the indexes is 1 (2 elements) ... if so sort and return
        this.nqSortComparisons++;
        if(rightPos-leftPos == 1){
            qSort2(leftPos, rightPos);
            return;
        }

        // sort groups of 3 cards
        // check to see if the length of this partition is 2, if so sort and return
        this.nqSortComparisons++;
        if(rightPos-leftPos==2) {
            qSort3(leftPos, rightPos);
            return;
        }

        // choose a pivot element
        // choose pivot will choose the MEDIAN element

        pivotIndex = choosePivot(leftPos, rightPos);

        // partition the data
        int newPivotIndex = partition(leftPos, rightPos, pivotIndex);

        // quick sort over the two left partition        
        // remember to leave out the pivot index
        //#DEBUG
        if(this.debugOn) {
            System.err.println("Printing Deck State AFTER Partitioning");
            System.err.println(this.toStringMarkPivot(leftPos, rightPos, newPivotIndex));
        }

        quickSort(leftPos, newPivotIndex-1);
        // quick sort over the right partition
        quickSort(newPivotIndex+1, rightPos);
    }

    /**
     * Partitions a range of value into low and high values
     * 
     * @return the position of the new pivot position
     */
    private int partition(int leftPos, int rightPos, int pivotPos)
    {

        int leftScan = leftPos;
        int rightScan = rightPos;

        // place the pivot at the start of the sequence
        this.swapCards(pivotPos, leftPos);

        boolean isPartitioned = false;
        while( !isPartitioned )
        {
            if (rightScan > leftScan) {
                //leftScan++;
                this.nqSortComparisons++;
            }
            // scan from the left and find an element greater than the pivot element
            // note the pivot element is temporarily at the left position
            // remember to check to see if we have hit the right Scan position
            while( leftScan<rightScan && 
            cardAry[leftScan].hashCode() <= cardAry[leftPos].hashCode()) {
                leftScan++;
                this.nqSortComparisons+=1;
            }
            // scan from the right right and find an element less than the pivot 
            // not the pivot element is temporarily in the left position.
            while( rightScan>leftScan &&
            cardAry[rightScan].hashCode() > cardAry[leftPos].hashCode()) {
                rightScan--;
                this.nqSortComparisons += 1;
            }

            // #DEBUG    
            if( this.debugOn == true && rightScan < leftScan) {
                System.err.println("found instance where left/right scanners crossed");
            }

            if( rightScan == leftScan)
                isPartitioned = true;
            else
                swapCards(leftScan, rightScan);

        }

        // remember to put the pivot element at the right/left scan position - 1
        int newPivotPos = rightScan - 1;

        this.swapCards(leftPos, newPivotPos);

        return (newPivotPos);
    }

    /**
     * Identify the median element amongst the possibilities.
     * 
     * @return the position of the new pivot element
     */
    private int choosePivot(int leftPos, int rightPos)
    {
        // iden        
        int midPos = (leftPos+rightPos)/2;

        int firstCode = cardAry[leftPos].hashCode();
        int midCode = cardAry[midPos].hashCode();        
        int lastCode = cardAry[rightPos].hashCode();

        int medianCode = pickMedian(firstCode,midCode,lastCode);

        this.nqSortComparisons+=4;
        if( medianCode==firstCode)
            return leftPos;
        if(medianCode==midCode)
            return midPos;

        return rightPos;   
    } 

    /** 
     * Chooses the median element given
     * 
     * @return the median of the three elements given
     *          if two of the elements are the same, it will return the smallest element
     */
    public static int pickMedian(int a, int b, int c)
    {
        if(a==b || b==c || a==c)
            return Math.min(a, Math.min(b,c));

        int x = a-b;
        int y = b-c;
        int z = a-c;

        if(x*y > 0)
            return b;
        if (x*z > 0)
            return c;

        return a;
    }

    private void swapCards(int leftPos, int rightPos)
    {
        Card tempCard = cardAry[leftPos];
        cardAry[leftPos] = cardAry[rightPos];
        cardAry[rightPos] = tempCard;
    }

    private int qSort3(int leftPos, int rightPos)
    {
        int numComparisons = 0;

        // create a temporary card to hold the initialize a "smallest card"
        // find the smallest element ... put it in the left position
        // be sure to use the hash code for comparison
        int smallCardPos = leftPos;
        for(int cPos=leftPos; cPos<= rightPos; cPos++)
        {
            // increment the number of comparisons
            numComparisons++;
            // check to see if the card at the current position is less than the 
            // current smallest card, remember to compare with hashCode()
            if (cardAry[cPos].hashCode() < cardAry[smallCardPos].hashCode() )
                smallCardPos = cPos;
        }

        // if necessary put the smallest card in the left position.
        if(cardAry[smallCardPos].hashCode() < cardAry[leftPos].hashCode()) {
            // swap the small card into the left position
            this.swapCards(leftPos,smallCardPos);
        } 

        this.nqSortComparisons++;

        return  qSort2(leftPos+1,rightPos);
    }

    private int qSort2(int leftPos, int rightPos)
    {
        int leftHashCode = cardAry[leftPos].hashCode();
        int rightHashCode = cardAry[rightPos].hashCode();

        // check if these two cards are out of order .  Use hashcodes for comparison
        if( rightHashCode < leftHashCode ) {
            // ... if they are ... swap these two cards.
            swapCards(rightPos, leftPos);
        }

        return 1;
    }

    /*
     *  Gets the card at the indicated position.
     *  @param index - indicates the integer of the card to return.
     */
    public Card getCard(int index)
    {
        if( index <0 || index >=52)
            return null;

        return cardAry[index];
    }

    /*
     * Shuffles the cards
     * @param numShuffles - indicates the number of switches 
     * to perform in this shuffle
     */
    public void shuffle(int numShuffles)
    {   
        Card tempCard;
        int switchOne, switchTwo;

        for (int i=0; i<numCards; i++){
            switchOne = rand.nextInt(numCards);
            switchTwo = rand.nextInt(numCards);

            tempCard = cardAry[switchOne];
            cardAry[switchOne] = cardAry[switchTwo];
            cardAry[switchTwo] = tempCard;   
        }

        if(cardAry.length > 1 && cardAry.length <=5 && isSorted()==true)
            shuffle(2);
    }

    public String toString()
    {
        return toString(Card.SHORT);
    }

    public String toString(int format)
    {      
        String outString = new String();
        //outString.ensureCapacity(cardAry.length+2);

        for (int i=0; i<cardAry.length; i++)
        {
            if (i%13 == 0 )
                outString += "\n";

            //System.err.println("cardNum is " + i);
            if( cardAry[i] != null) {

                if(i>0 && cardAry[i-1].hashCode() > cardAry[i].hashCode())
                    outString += "*";

                outString += cardAry[i].toString(format);
                if (format == Card.VERBOSE)
                    outString += "\n";
                else if (format == Card.SHORT)
                    outString +=", ";
            }

            else 
            {
                outString += " nul ";
            }
        }

        return outString;
    }

    public Card popCard()
    {
        return cardAry[topCard++];
    }

    public boolean isSorted()
    {
        boolean bSorted = true;
        int firstCode;
        int secondCode;

        for(int cardPos=0; cardPos<this.numCards-1; cardPos++)
        {
            firstCode = cardAry[cardPos].hashCode();
            secondCode = cardAry[cardPos+1].hashCode();
            if(firstCode >  secondCode) {
                bSorted = false;
                break;
            }
        }
        return bSorted;
    }

    /**
     * Prints the entire deck.  But ... it puts ((( ))) around the section being sorted
     * and [[[  ]]] around the pivot element
     * 
     * @param   leftPos - the left position of the series being quick sorted
     * @param   rightPos - the right position of the series being quick sorted
     * 
     * @return  A string representing the deck state with ((( ))) around 
     *          the section being sorted and [[[  ]]] around the pivot element
     */
    public String toStringMarkPivot(int leftPos, int rightPos, int pivotNum)
    {      
        String outString = new String();
        //outString.ensureCapacity(cardAry.length+2);

        for (int i=0; i<cardAry.length; i++)
        {
            if (i%13 == 0 )
                outString += "\n";

            //System.err.println("cardNum is " + i);
            if( cardAry[i] != null) {

                if(i== leftPos)
                    outString += "((((";

                if(i==pivotNum) {
                    outString += "[[[";
                    outString += cardAry[i].toString(Card.SHORT); 
                    outString += "]]]";

                }
                else
                    outString += cardAry[i].toString(Card.SHORT);

                if(i==rightPos)
                    outString += ")))))";

                if((i+1)%13 !=0 )
                    outString += ", ";

            }

            else 
            {
                outString += " nul ";
            }
        }

        return outString;
    }
}

