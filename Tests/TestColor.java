package Tests;

/**
 * Write a description of class Tests.TestColor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestColor
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // instance variables - replace the example below with your own

    public static void main(String args[])
    {
        System.out.println( " This will be purple: " + ANSI_PURPLE + "Purple!" 
            + ANSI_RESET + "normal color text");
        System.out.println(" This will be red: " + ANSI_RED + "Red!!");
    }

}
