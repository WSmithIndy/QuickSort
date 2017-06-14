
/**
 * Write a description of class CardTester here.
 * 
 * @author  Mr. William T Smith
 * @version 10/10/16
 */
import java.util.Scanner;
import java.text.*;

public class ShoeTester
{
    // instance variables - replace the example below with your own@
    /*
     * @method main
     * /
     */
    public static void main(String args[])
    {
        boolean debugModeOn = false;
        
        if(args.length > 0 && args[0].equalsIgnoreCase("debug"))
            debugModeOn = true;
            
            
        System.out.println("First ... let's test sorting just a few cards");

        Shoe tempShoe;
        // Test with 3 cards
        for(int i=1; i<8; i++)
        {
            //tempShoe = new Shoe(Card.Suit.Spades, i);
            tempShoe = new Shoe(Card.suitMap[i%4+1],i);
            tempShoe.debugOn = debugModeOn;
            
            System.out.println("_______ TEST " + i + " CARD(s) _________");
            System.out.println("The Deck begins like this.\n" + tempShoe.toString());
            tempShoe.shuffle(i-1);
            System.out.println("The Deck is now shuffled like this.\n" + tempShoe.toString()); 
            System.out.println("Now we shuffle.");
            tempShoe.beginQuickSort();
            System.out.println("Now the deck looks like this. \n" + tempShoe.toString());
            tempShoe.toString();

            if(tempShoe.isSorted() == true)
                System.out.println("The shoe SORTED CORRECTLY");
            else {           
                System.out.println("********************************");
                System.out.println("The shoe DID NOT sort correctly");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }

        
        System.out.println("_-------------------------------------");
        System.out.println("*****Large Scale Testing**********");
        System.out.println("--------------------------------------");
        Scanner console = new Scanner(System.in);

        do {
            System.out.println("How many decks in the shoe?");
            int numDecks = console.nextInt();

            if(numDecks<=0){
                System.out.println("You must have at least one deck");
                System.out.println("Exiting");
                System.exit(-1);
            }

            Shoe cardDeck = new Shoe(numDecks);
            cardDeck.debugOn = debugModeOn;

            System.out.println ("OK, we are printing out a fresh shoe of " 
                + numDecks + " decks.");

            if (args.length>0 && args[0].equalsIgnoreCase("Test"))
            {
                System.out.println("Testing the state of the deck");
                System.out.println( cardDeck.toString());
                return;
            }
            // test deck

            System.out.println( cardDeck.toString());

            System.out.println("Now we will shuffle the shoe");
            cardDeck.shuffle(100);

            System.out.println("\nNow the deck looks like this.");
            System.out.println( cardDeck.toString());

        
            System.out.println();

            System.out.println("-----------------------------------------");
            System.out.println("Now we will sort the deck using QUICK sort");

            //int numChecks = cardDeck.bubbleSort();
            int numChecks = cardDeck.beginQuickSort();

            NumberFormat decFormat = new DecimalFormat("#0.0000");     
            // Test to make sure number formatting works
            //System.out.println(decFormat.format(4.0));

            System.out.println("Now the deck looks like this");
            System.out.println(cardDeck.toString());
            
           if(cardDeck.isSorted() == true)
                System.out.println("The shoe SORTED CORRECTLY");
            else
                System.out.println("The shoe DID NOT sort correctly");

            int numCards = numDecks *52;
            System.out.println("\nSORT STATS\n");
            System.out.println("Numbers close to one indicate proportionality");
            System.out.println("n is the file size");
            System.out.println("---------------------------------------------------------------------");

            System.out.println("DATA SIZE(n):   " + numCards);
            System.out.println("NUM CHECKS:     " + numChecks);
            System.out.println("vs log(n):      " + decFormat.format(numChecks / (Math.log(numCards)/Math.log(2))));
            System.out.println("vs DataSize(n): " + decFormat.format(numChecks / (numCards)));        
            System.out.println("vs n*log(n)     " + decFormat.format(numChecks / ( numCards*Math.log(numCards)/Math.log(2))) ) ;
            System.out.println("vs n^2          " + decFormat.format(numChecks / (Math.pow(numCards,2))));

            System.out.println("Would you like to shuffle and sort again? (Yes/No)");
        } while ( console.next().equalsIgnoreCase("Yes") );
        System.out.println("All done, goodbye");
    }
}
