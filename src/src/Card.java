package org.wtsmith.cards;

import java.util.Random;
import java.util.Scanner;

import static org.wtsmith.cards.Card.Suit.*;

/**
 *
 */
public class Card implements Comparable<Card> {

   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_RESET = "\u001B[0m";
   // STANDARD IMPLEMENTATION
   //enum Suit {Hearts, Spades, Diamonds, Clubs, Joker}
   // ADVANCED ENUM IMPLMENTATION

   public static final char suitChars[] = {'\u2660', '\u2661', '\u2662', '\u2663',
         //'\u1f0a0'
         'J'
   };

   public enum Suit {
      Spades(0), Hearts(1), Diamonds(2), Clubs(3), Joker(4);
      private final int  value;
      private       char suitChar;

      Suit(int inVal) {
         value = inVal;
         suitChar = suitChars[value];
      }

      int toInt() {
         return value;
      }

      char toChar() {
         return suitChar;
      }

      String suitString() {
         return Character.toString(suitChar);
      }

      // TODO ... try to make this work with a switch statment.
      public static Suit numToSuit(int suitInt) {
         Object[] enumVals = Suit.values();

         if( suitInt>=enumVals.length )
            return Joker;
         else
            return (Suit) enumVals[suitInt];

      }

      /*
      public static Suit numToSuit(int suitIndex) { //ARRAY IMPLEMENTATION
         //return Card.suitMap[suitIndex];

         //Advanced Enum Implementation
         return values()[suitIndex];
      } */
   }


   //enum Suit{ Hearts, Spades, Diamonds, Clubs, Joker};

    /* public static Suit numToSuit (int suitIndex)
    { return Card.suitMap[suitIndex];}*/

   public static int JOKER = 0;
   public static int ACE = 1;
   public static int JACK = 11;
   public static int QUEEN = 12;
   public static int KING = 13;

   public static int SHORT = 1;
   public static int VERBOSE = 2;

   /*
   public static Suit[] suitMap = {Joker, Spades, Hearts, Diamonds,
         Clubs
   };*/
   private static String[] rankMap = {"Joker", "Ace", "Two", "Three", "Four",
         "Five", "Six", "Seven", "Eight", "Nine",
         "Ten", "Jack", "Queen", "King"
   };
   private static String[] shortRankMap = {"?", "A", "2", "3", "4", "5", "6", "7",
         "8", "9", "10", "J", "Q", "K"
   };
   private static Random rand = new Random();

   private Suit suitValue;
   private int rank;

   // default constructor
   // randomly create a card
   public Card() {
      //suitValue = suitMap [ rand.nextInt(4) ];
      suitValue = Suit.numToSuit(rand.nextInt(4));
      rank = rand.nextInt(13) + 1;
   }

   public Card(Card copyCard) {
      this.suitValue = copyCard.suitValue;
      this.rank = copyCard.rank;
   }

   public Card(Suit newSuit, int newRank) {
      suitValue = newSuit;
      rank = newRank;
   }

   public int hashCode() {
      return this.suitValue.toInt() * 100 + rank;
   }

   // TODO: Fix this replace with a Comparator that can be customized !!!! Improper use of a
   // hashCode
   public int compareTo(Card other) {
      if (this.hashCode() == other.hashCode())
         return 0;
      if (this.hashCode() < other.hashCode())
         return -1;
      else
         return 1;
   }

   // returns a string representation of the suit
   public String getSuitStr() {
      return suitToString(this.suitValue, SHORT);
   }

   public String getSuitStr(int format) {
      return suitToString(suitValue, format);
   }

   public String getRankStr() {
      return getRankStr(SHORT);
   }

   public String getRankStr(int format) {
      if (format == SHORT) {
         return shortRankMap[this.rank];
      } else if (format == VERBOSE)
         return rankMap[this.rank];

      return null;
   }

   public boolean isGreater(Card compareCard, Suit trumpSuit) {
      if (compareCard.suitValue == this.suitValue) {
         if (compareCard.rank < this.rank)
            return true;
      } else if (this.suitValue == trumpSuit || this.suitValue == Joker)
         return true;

      return false;
   }

   public static String suitToString(Suit inSuit) {
      return suitToString(inSuit, SHORT);
   }

   public int getRank() {
      return rank;
   }

   public static String suitToString(Suit inSuit, int format) {
      StringBuilder outStr = new StringBuilder();

      if (format == VERBOSE) {
         if (inSuit == Hearts)
            outStr.append("Hearts");
         else if (inSuit == Spades)
            outStr.append("Spades");
         else if (inSuit == Diamonds)
            outStr.append("Diamonds");
         else if (inSuit == Clubs)
            outStr.append("Clubs");
      } else {
         outStr.append(inSuit.suitString());
      }
      return new String(outStr);
   }

   public String toString() {
      return toString(SHORT);
   }

   public String toString(int format) {
      // set the string color

      StringBuilder outStr = new StringBuilder();
      switch (this.suitValue) {
         case Hearts:
         case Diamonds:
            outStr.append(ANSI_RED);
            break;
      }

      if (format == VERBOSE) {

         outStr.append(getRankStr(VERBOSE) + " of "
                             + getSuitStr(VERBOSE));
      } else if (format == SHORT) {
         outStr.append(getRankStr(SHORT)
                             + getSuitStr(SHORT));
      }
      outStr.append(ANSI_RESET);
      return new String(outStr);
   }

   public static Suit strToSuit(String strSuit) {
      if (strSuit.equalsIgnoreCase("Hearts"))
         return Hearts;
      else if (strSuit.equalsIgnoreCase("Spades"))
         return Spades;
      else if (strSuit.equalsIgnoreCase("Diamonds"))
         return Diamonds;
      else if (strSuit.equalsIgnoreCase("Clubs"))
         return Clubs;

      System.out.println("No Suit detected");
      return Joker;
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
