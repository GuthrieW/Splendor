package splendor;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**********************************************************************
 * This class is used to test the functionality of the Splendor.
 * class by utilizing JUnit Tests. Author: Wesley Guthrie and David
 * Brown.
 **********************************************************************/
public class SplendorTest {

	/** test for player values below the minimum. */
	@Test(expected = IllegalArgumentException.class)
	public void tooManyPlayers() {
		new SplendorGame(5);
	}

	/** test for player values below the minimum. */
	@Test(expected = IllegalArgumentException.class)
	public void tooFewPlayers() {
		new SplendorGame(1);
	}
//
	/** tests for the right amount of chips. */
	@Test
	public void getChipMethods() {
		SplendorGame tempGame = new SplendorGame(2);

		assertEquals(4, tempGame.getBlackChips());
		assertEquals(4, tempGame.getBlueChips());
		assertEquals(4, tempGame.getGreenChips());
		assertEquals(4, tempGame.getBlackChips());
		assertEquals(4, tempGame.getWhiteChips());

		tempGame = new SplendorGame(3);
		assertEquals(5, tempGame.getBlackChips());
		assertEquals(5, tempGame.getBlueChips());
		assertEquals(5, tempGame.getGreenChips());
		assertEquals(5, tempGame.getBlackChips());
		assertEquals(5, tempGame.getWhiteChips());

		tempGame = new SplendorGame(4);
		assertEquals(7, tempGame.getBlackChips());
		assertEquals(7, tempGame.getBlueChips());
		assertEquals(7, tempGame.getGreenChips());
		assertEquals(7, tempGame.getBlackChips());
		assertEquals(7, tempGame.getWhiteChips());
	}

	
	/** tests all the set methods. */
	@Test
	public void setMethods() {
		SplendorGame tempGame = new SplendorGame(2);
		tempGame.setBlackChips(tempGame.getBlackChips());
		tempGame.setBlueChips(tempGame.getBlueChips());
		tempGame.setGoldChips(tempGame.getGoldChips());
		tempGame.setGreenChips(tempGame.getGreenChips());
		tempGame.setRedChips(tempGame.getRedChips());
		tempGame.setWhiteChips(tempGame.getWhiteChips());
		
		tempGame.setCurrentPlayer(tempGame.getCurrentPlayer());
		
		tempGame.setHighCard1(tempGame.getHighCard1());
		tempGame.setHighCard2(tempGame.getHighCard2());
		tempGame.setHighCard3(tempGame.getHighCard3());
		tempGame.setHighCard4(tempGame.getHighCard4());
		tempGame.setHighDeck(tempGame.getHighDeck());
		
		tempGame.setMiddleCard1(tempGame.getMiddleCard1());
		tempGame.setMiddleCard2(tempGame.getMiddleCard2());
		tempGame.setMiddleCard3(tempGame.getMiddleCard3());
		tempGame.setMiddleCard4(tempGame.getMiddleCard4());
		tempGame.setMiddleDeck(tempGame.getMiddleDeck());
		
		tempGame.setLowCard1(tempGame.getLowCard1());
		tempGame.setLowCard2(tempGame.getLowCard2());
		tempGame.setLowCard3(tempGame.getLowCard3());
		tempGame.setLowCard4(tempGame.getLowCard4());
		tempGame.setLowDeck(tempGame.getLowDeck());
		
		tempGame.setNoble1(tempGame.getNoble1());
		tempGame.setNoble2(tempGame.getNoble2());
		tempGame.setNoble3(tempGame.getNoble3());
		tempGame.setNobleDeck(tempGame.getNobleDeck());
		
		tempGame.setNumPlayers(tempGame.getNumPlayers());
		
		tempGame.setPlayers(tempGame.getPlayers());
		
		tempGame.setGameStatus("IN PROGRESS");
		tempGame.getStatus();
	}
	
	/** tests the red card methods. */
	@Test
    public void testCardRed() {
        Card redCard = new Card("red", 1, 1, 3, 0, 0, 1, 1, null);
        assertEquals(redCard.getColor(), "red");
        assertEquals(redCard.getLevel(), 1);
        assertEquals(redCard.getPrestige(), 1);
        assertEquals(redCard.getWhite(), 3);
        assertEquals(redCard.getRed(), 0);
        assertEquals(redCard.getGreen(), 0);
        assertEquals(redCard.getBlue(), 1);
        assertEquals(redCard.getBlack(), 1);
        assertEquals(redCard.getImageFile(), null);
    }
   
	/** tests the blue card methods. */
    @Test
    public void testCardBlue() {
        Card blueCard = new Card("blue", 3, 2, 1, 1, 1, 2, 1, null);
        assertEquals(blueCard.getColor(), "blue");
        assertEquals(blueCard.getLevel(), 3);
        assertEquals(blueCard.getPrestige(), 2);
        assertEquals(blueCard.getWhite(), 1);
        assertEquals(blueCard.getRed(), 1);
        assertEquals(blueCard.getGreen(), 1);
        assertEquals(blueCard.getBlue(), 2);
        assertEquals(blueCard.getBlack(), 1);
        assertEquals(blueCard.getImageFile(), null);
    }
   
    /** tests the green card methods. */
    @Test
    public void testCardGreen() {
        Card greenCard = new Card("green", 2, 2, 0, 0, 0, 1, 1, null);
        assertEquals(greenCard.getColor(), "green");
        assertEquals(greenCard.getLevel(), 2);
        assertEquals(greenCard.getPrestige(), 2);
        assertEquals(greenCard.getWhite(), 0);
        assertEquals(greenCard.getRed(), 0);
        assertEquals(greenCard.getGreen(), 0);
        assertEquals(greenCard.getBlue(), 1);
        assertEquals(greenCard.getBlack(), 1);
        assertEquals(greenCard.getImageFile(), null);
    }
   
    /** tests the white card methods. */
    @Test
    public void testCardWhite() {
        Card whiteCard = new Card("white", 1, 1, 2, 1, 3, 2, 1, null);
        assertEquals(whiteCard.getColor(), "white");
        assertEquals(whiteCard.getLevel(), 1);
        assertEquals(whiteCard.getPrestige(), 1);
        assertEquals(whiteCard.getWhite(), 2);
        assertEquals(whiteCard.getRed(), 1);
        assertEquals(whiteCard.getGreen(), 3);
        assertEquals(whiteCard.getBlue(), 2);
        assertEquals(whiteCard.getBlack(), 1);
        assertEquals(whiteCard.getImageFile(), null);
    }
   
    /** tests the black card methods. */
    @Test
    public void testCardBlack() {
        Card blackCard = new Card("black", 1, 1, 1, 1, 1, 1, 1, "THIS.JPG");
        assertEquals(blackCard.getColor(), "black");
        assertEquals(blackCard.getLevel(), 1);
        assertEquals(blackCard.getPrestige(), 1);
        assertEquals(blackCard.getWhite(), 1);
        assertEquals(blackCard.getRed(), 1);
        assertEquals(blackCard.getGreen(), 1);
        assertEquals(blackCard.getBlue(), 1);
        assertEquals(blackCard.getBlack(), 1);
        assertEquals(blackCard.getImageFile(), "THIS.JPG");
    }

    /** tests the noble card methods. */
    @Test
    public void testNoble1() {
        Noble noble1 = new Noble(3, 0, 3, 3, 3, 0, null);
        assertEquals(noble1.getPrestigePoints(), 3);
        assertEquals(noble1.getWhiteRequired(), 0);
        assertEquals(noble1.getRedRequired(), 3);
        assertEquals(noble1.getGreenRequired(), 3);
        assertEquals(noble1.getBlueRequired(), 3);
        assertEquals(noble1.getBlackRequired(), 0);
        assertEquals(noble1.getImageFile(), null);
    }
   
    /** tests the noble card methods. */
    @Test
    public void testNoble2() {
        Noble noble2 = new Noble(3, 3, 3, 3, 0, 0, "THIS.JPG");
        assertEquals(noble2.getPrestigePoints(), 3);
        assertEquals(noble2.getWhiteRequired(), 3);
        assertEquals(noble2.getRedRequired(), 3);
        assertEquals(noble2.getGreenRequired(), 3);
        assertEquals(noble2.getBlueRequired(), 0);
        assertEquals(noble2.getBlackRequired(), 0);
        assertEquals(noble2.getImageFile(), "THIS.JPG");
    }
   
    /** tests the player methods. */
    @Test
    public void testPlayer1() {
        Player player1 = new Player(1);
        assertEquals(player1.getPlayerNum(), 1);
        assertEquals(player1.getBlackCards(), 0);
        assertEquals(player1.getRedCards(), 0);
        assertEquals(player1.getBlueCards(), 0);
        assertEquals(player1.getGreenCards(), 0);
        assertEquals(player1.getWhiteCards(), 0);
        assertEquals(player1.getBlackChips(), 0);
        assertEquals(player1.getRedChips(), 0);
        assertEquals(player1.getBlueChips(), 0);
        assertEquals(player1.getGreenChips(), 0);
        assertEquals(player1.getWhiteChips(), 0);
        assertEquals(player1.getBlackTotal(), 0);
        assertEquals(player1.getRedTotal(), 0);
        assertEquals(player1.getBlueTotal(), 0);
        assertEquals(player1.getGreenTotal(), 0);
        assertEquals(player1.getWhiteTotal(), 0);
        assertEquals(player1.getHoldCard(), null);
        assertEquals(player1.getPoints(), 0);
    }
   
    /** tests the player methods. */
    @Test
    public void testPlayer2() {
        Player player2 = new Player(2);
        assertEquals(player2.getPlayerNum(), 2);
        player2.setBlackCards(3);
        player2.setRedCards(2);
        player2.setBlueCards(5);
        player2.setGreenCards(7);
        player2.setWhiteCards(1);
        player2.setHoldCard(null);
        player2.changeBlack(4);
        player2.changeRed(7);
        player2.changeGreen(5);
        player2.changeBlue(3);
        player2.changeWhite(2);
        player2.changeGold(1);
        player2.addPoints(11);
        player2.setChipTotal();
       
        int redCheck = player2.getRedCards() + player2.getRedChips();
        int blackCheck = player2.getBlackCards() + player2.getBlackChips();
        int blueCheck = player2.getBlueCards() + player2.getBlueChips();
        int greenCheck = player2.getGreenCards() + player2.getGreenChips();
        int whiteCheck = player2.getWhiteCards() + player2.getWhiteChips();
       
        assertEquals(player2.getPlayerNum(), 2);
        assertEquals(player2.getBlackCards(), 3);
        assertEquals(player2.getRedCards(), 2);
        assertEquals(player2.getBlueCards(), 5);
        assertEquals(player2.getGreenCards(), 7);
        assertEquals(player2.getWhiteCards(), 1);
        assertEquals(player2.getBlackChips(), 4);
        assertEquals(player2.getRedChips(), 7);
        assertEquals(player2.getBlueChips(), 3);
        assertEquals(player2.getGreenChips(), 5);
        assertEquals(player2.getWhiteChips(), 2);
        assertEquals(player2.getBlackTotal(), blackCheck);
        assertEquals(player2.getRedTotal(), redCheck);
        assertEquals(player2.getBlueTotal(), blueCheck);
        assertEquals(player2.getGreenTotal(), greenCheck);
        assertEquals(player2.getWhiteTotal(), whiteCheck);
        assertEquals(player2.getHoldCard(), null);
        assertEquals(player2.getPoints(), 11);
        assertEquals(player2.getChipTotal(), 21);
    }
}
