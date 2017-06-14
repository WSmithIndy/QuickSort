import java.util.Random;
import java.util.Scanner;

public class Card implements Comparable<Card>
{   
    // STANDARD IMPLMENTATION
    //enum Suit {Hearts, Spades, Diamonds, Clubs, Joker}
    // ADVANCED ENUM IMPLMENTATION

    public static final char suitChars[] = {'\u2660','\u2661','\u2662','\u2663',
            //'\u1f0a0' 
            'J'
        };

    enum Suit {
        Spades(0),Hearts(1), Diamonds(2), Clubs(3), Joker(4);
        private int value;
        private char suitChar;
        Suit (int inVal){ 
            value = inVal; 
            suitChar = suitChars[value];
        }  

        int toInt() {return value;};

        char toChar() {return suitChar;}

        String suitString(){ 
            return  Character.toString(suitChar); 
        }
    }
    public static Suit numToSuit (int suitIndex)
    { //ARRAY IMPLEMENTATION
        //return Card.suitMap[suitIndex];

        //Advanced Enum Implementation
        return Suit.values()[suitIndex];  
    }


    //enum Suit{ Hearts, Spades, Diamonds, Clubs, Joker};   

    /* public static Suit numToSuit (int suitIndex)
    { return Card.suitMap[suitIndex];}*/

    public static int JOKER = 0;
    public static int ACE = 1;
    public static int JACK = 11;
    public static int QUEEN = 12;
    public static int KING = 13;

    public static int SHORT=1;
    public static int VERBOSE=2;

    public static Suit[] suitMap = { Suit.Joker, Suit.Spades,Suit.Hearts, Suit.Diamonds, 
            Suit.Clubs};
    private static String[] rankMap = {"Joker","Ace","Two","Three","Four",
            "Five","Six","Seven","Eight","Nine",
            "Ten","Jack","Queen","King"};  
    private static String[] shortRankMap = {"?","A","2","3","4","5","6","7",
            "8","9","10","J","Q","K"};
    private static Random rand = new Random();

    private Suit    suitValue;
    private int     rank;

    // default constructor
    // randomly create a card
    public Card()
    {
        //suitValue = suitMap [ rand.nextInt(4) ];
        suitValue = numToSuit (rand.nextInt(4));
        rank = rand.nextInt( 13 ) + 1;
    }

    public Card( Card copyCard)
    {
        this.suitValue = copyCard.suitValue;
        this.rank = copyCard.rank;
    }

    public Card(Suit newSuit, int newRank)
    {
        suitValue = newSuit;
        rank = newRank;
    }

    public int hashCode()
    {
        return this.suitValue.toInt()*100 + rank;
    }

    public int compareTo(Card other)
    {
        if (this.hashCode() == other.hashCode())
            return 0;
        if (this.hashCode() < other.hashCode())
            return -1;
        else 
            return 1;
    }

    // returns a string representation of the suit
    public String getSuitStr()
    { return suitToString( this.suitValue, SHORT ); }

    public String getSuitStr( int format )
    {
        return suitToString(suitValue, format);
    }

    public String getRankStr()
    {
        return getRankStr(SHORT);
    }

    public String getRankStr(int format)
    {
        if (format == SHORT)
        {
            return shortRankMap[this.rank];
        }
        else if (format == VERBOSE)
            return rankMap[this.rank];

        return null;
    }

    public boolean isGreater(Card compareCard, Suit trumpSuit)
    {
        if( compareCard.suitValue == this.suitValue )
        {
            if (compareCard.rank < this.rank)
                return true;
        }
        else if (this.suitValue == trumpSuit || this.suitValue == Suit.Joker )
            return true;

        return false;      
    }

    public static String suitToString(Suit inSuit)
    {
        return suitToString(inSuit, SHORT);
    }

    public int getRank()
    {
        return rank;
    }

    public static String suitToString(Suit inSuit, int format)
    {
        if (format == VERBOSE)
        {
            if ( inSuit == Suit.Hearts)
                return "Hearts";
            else if (inSuit == Suit.Spades)
                return "Spades";
            else if (inSuit == Suit.Diamonds)
                return "Diamonds";
            else if (inSuit == Suit.Clubs)
                return "Clubs";
        }
        else
        {
            return inSuit.suitString();
            /*
            if ( inSuit == Suit.Hearts)
            return "H";
            else if (inSuit == Suit.Spades)
            return "S";
            else if (inSuit == Suit.Diamonds)
            return "D";
            else if (inSuit == Suit.Clubs)
            return "C";   
             */
        }

        return null;
    }

    public String toString(){ return toString(SHORT);}

    public String toString(int format)
    { 
        // set the string color
        //String buildStr = "";

        /*
        if(this.suitValue == Suit.Hearts || this.suitValue== Suit.Diamonds)
            buildStr += ANSI_RED;
        else
            buildStr += ANSI_BLACK;
            */

        if (format == VERBOSE){

            return new String (getRankStr(VERBOSE) + " of " + getSuitStr(VERBOSE)); 
        }
        else if (format == SHORT)
        {

            return new String (getRankStr(SHORT) + getSuitStr(SHORT));
        }
        return null;
    }    

    public static Suit strToSuit(String strSuit)
    {
        if (strSuit.equalsIgnoreCase("Hearts"))
            return Suit.Hearts;
        else if (strSuit.equalsIgnoreCase("Spades"))
            return Suit.Spades;
        else if (strSuit.equalsIgnoreCase("Diamonds"))
            return Suit.Diamonds;
        else if (strSuit.equalsIgnoreCase("Clubs"))
            return Suit.Clubs;

        System.out.println("No Suit detected");
        return Suit.Joker;
    }
    /*
    public static void main(String args[])
    {
    Card currCard,highestCard = new Card (Suit.Joker, JOKER);        
    Suit    trumpSuit = Suit.Joker;

    String  playAgain = "false";
    Scanner console = new Scanner(System.in);      

    do {

    System.out.println("--------------------");
    do {
    System.out.println("What is the trump suit? (Hearts/Diamonds/Clubs/Spades)?");           
    trumpSuit = Card.strToSuit(console.next());
    System.out.println ("The trump suit is " + Card.suitToString(trumpSuit) );
    }
    while ( trumpSuit == Suit.Joker);

    System.out.println("--------------------");

    System.out.println("\nYour 20 random cards are:");        
    for (int i=0; i < 20; i++)
    {
    currCard = new Card();           
    System.out.println(i + ": " + currCard.toString());            
    if (currCard.isGreater(highestCard, trumpSuit)){            
    highestCard = currCard;         
    System.out.println("--> " + currCard.toString() + " is the highest ranking.");
    }
    }
    System.out.println("The highest ranking card was " + highestCard.toString());
    System.out.print ("Would you like to play again (Yes/No)?");
    playAgain = console.next();
    }
    while (playAgain.equalsIgnoreCase("Yes") );

    System.out.println("Goodbye");
    }//main
     */

}//class 
