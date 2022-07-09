/**Blackjack Project
 * Michael Ha
 * Spring 2021
 * CSCI 2001-51
 */

package tests;

import deck.Deck;
import game.Game;
import players.Player;

public class TestBlackjack {

    public static void main(String[] args) {
        //creating deck, player, dealer, and game
        Deck d = new Deck();
        Player player = new Player("Player");
        Player dealer = new Player("Dealer");
        Game game = new Game(d, player, dealer);

        //running the game
        game.runGame();
    }
}
