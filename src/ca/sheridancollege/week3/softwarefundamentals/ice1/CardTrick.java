package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then searches the array of cards for the match to the luckyCard.
 * * @author Abhinav
 * @modifier Abhinav Jan 20, 2026
 * @studentNumber 991810107
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        // 1. Create a hand of seven cards as an array 
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        // 2. Fill magicHand with random cards 
        for (int i = 0; i < magicHand.length; i++)
        {
            Card c = new Card();
            // Algorithm to choose random values 1-13 and random suits 
            c.setValue(random.nextInt(13) + 1); 
            c.setSuit(Card.SUITS[random.nextInt(4)]); 
            magicHand[i] = c;
        }
        
        // 3. Task: Add a set Card Object called luckyCard 
        Card luckyCard = new Card();
        luckyCard.setValue(7); // Hard-coded value 
        luckyCard.setSuit("Hearts"); // Hard-coded suit 
        
        // 4. Search the array for the luckyCard 
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && 
                card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // 5. Report whether the luckyCard is in the magic hand 
        if (found) {
            System.out.println("Congratulations! The lucky card (7 of Hearts) is in the magic hand. You win!");
        } else {
            System.out.println("Sorry, the lucky card is not in the magic hand this time.");
        }
    }
}
