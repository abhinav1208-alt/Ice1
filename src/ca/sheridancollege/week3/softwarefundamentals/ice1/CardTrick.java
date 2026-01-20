package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. 
 * * @author Abhinav abhinav
 * @modifier Abhinav abhinav [Jan 20, 2026]
 * @studentNumber 991810107
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7]; // Models a hand of seven cards as an array [cite: 12]
        Random random = new Random();
        
        // Fill magicHand with random cards
        for (int i = 0; i < magicHand.length; i++)
        {
            Card c = new Card();
            // Choose random number values (1-13) and random suits 
            c.setValue(random.nextInt(13) + 1); 
            c.setSuit(Card.SUITS[random.nextInt(4)]); 
            magicHand[i] = c;
        }
        
        // Ask the user to pick a card (value and suit) 
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a card value (1-13): ");
        int userValue = input.nextInt();
        
        System.out.println("Pick a suit index (0-Hearts, 1-Diamonds, 2-Spades, 3-Clubs): ");
        int userSuitIndex = input.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];
        
        // Create the user's card object
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        // Search the array for the user's card 
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && 
                card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // Report whether the user's card is in the magic hand 
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}