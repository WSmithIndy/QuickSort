

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShoeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ShoeTest
{
    /**
     * Default constructor for test class ShoeTest
     */
    public ShoeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSorting3()
    {
        Shoe shoe1 = new Shoe(Card.Suit.Spades, 3);
        shoe1.shuffle(2);
        shoe1.beginQuickSort();
        assertEquals(shoe1.isSorted(),true);
    }

    @Test
    public void Sort2()
    {
        Shoe shoe2 = new Shoe(Card.Suit.Spades, 2);
        shoe2.shuffle(1);
        shoe2.beginQuickSort();
        assertEquals(shoe2.getCard(0).getRank(),1);
        assertEquals(shoe2.getCard(1).getRank(),2);
        assertEquals(shoe2.isSorted(), true);
    }
    
    @Test
    public void sort4()
    {
        Shoe shoe4 = new Shoe(Card.Suit.Hearts, 4);
        shoe4.shuffle(3);
        shoe4.beginQuickSort();
        assertEquals(shoe4.getCard(0).getRank(),1);
        assertEquals(shoe4.getCard(1).getRank(),2);
        assertEquals(shoe4.getCard(2).getRank(),3);
        assertEquals(shoe4.getCard(3).getRank(),4);
        assertEquals(shoe4.isSorted(), true);
        
        
    }

    @Test
    public void Sort5()
    {
        Shoe shoe5 = new Shoe(Card.Suit.Clubs, 5);
        shoe5.shuffle(10);
        shoe5.beginQuickSort();
        assertEquals(shoe5.getCard(0).getRank(),1);
        assertEquals(shoe5.getCard(1).getRank(),2);
        assertEquals(shoe5.getCard(2).getRank(),3);
        assertEquals(shoe5.getCard(3).getRank(),4);
        assertEquals(shoe5.getCard(4).getRank(),5);
        assertEquals(shoe5.isSorted(), true);

    }
        @Test
    public void Sort6()
    {
        Shoe shoe6 = new Shoe(Card.Suit.Clubs, 6);
        shoe6.shuffle(10);
        shoe6.beginQuickSort();
        assertEquals(shoe6.getCard(0).getRank(),1);
        assertEquals(shoe6.getCard(1).getRank(),2);
        assertEquals(shoe6.getCard(2).getRank(),3);
        assertEquals(shoe6.getCard(3).getRank(),4);
        assertEquals(shoe6.getCard(4).getRank(),5);
        assertEquals(shoe6.getCard(5).getRank(),6);
        assertEquals(shoe6.isSorted(), true);


    }
        @Test
    public void Sort7()
    {
        Shoe shoe7 = new Shoe(Card.Suit.Clubs, 7);
        shoe7.shuffle(10);
        shoe7.beginQuickSort();

        assertEquals(shoe7.isSorted(), true);
    }
    @Test
    public void Sort13()
    {
        Shoe shoe = new Shoe(Card.Suit.Clubs, 13);
        shoe.shuffle(26);
        shoe.beginQuickSort();

        assertEquals(shoe.isSorted(), true);
    }
    @Test
    public void Sort14()
    {
        Shoe shoe = new Shoe(Card.Suit.Clubs, 14);
        shoe.shuffle(26);
        shoe.beginQuickSort();

        assertEquals(shoe.isSorted(), true);
    }
        @Test
    public void sortDeck1()
    {
        Shoe deck1 = new Shoe(1);
        deck1.shuffle(80);
        deck1.beginQuickSort();
        assertEquals(deck1.isSorted(), true);
    }
    @Test
    public void sortDeck2()
    {
        Shoe deck2 = new Shoe(2);
        deck2.shuffle(160);
        deck2.beginQuickSort();
        assertEquals(deck2.isSorted(), true);
    }
        @Test
    public void sortDeck3()
    {
        Shoe deck3 = new Shoe(3);
        deck3.shuffle(320);
        deck3.beginQuickSort();
        assertEquals(deck3.isSorted(), true);
    }
            @Test
    public void sortDeck4()
    {
        Shoe deck = new Shoe(4);
        deck.shuffle(400);
        deck.beginQuickSort();
        assertEquals(deck.isSorted(), true);
    }
                @Test
    public void sortDeck5()
    {
        Shoe deck = new Shoe(5);
        deck.shuffle(500);
        deck.beginQuickSort();
        assertEquals(deck.isSorted(), true);
    }


}



