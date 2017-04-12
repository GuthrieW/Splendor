package splendor;

//import java.awt.Color;
//import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;
//import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**********************************************************************
 * This class handles the logic for the SplendorPanel class for the game
 * of Splendor.
 *
 * @author David Brown, Wesley Guthrie
 **********************************************************************/
public class SplendorGame {

	/** constant for low deck. */
	public static final int LOW_DECK = 1;

	/** constant for middle deck. */
	public static final int MIDDLE_DECK = 2;

	/** constant for high deck. */
	public static final int HIGH_DECK = 3;

	//	private JButton redButton;
	//	private JButton blueButton;
	//	private JButton greenButton;
	//	private JButton blackButton;
	//	private JButton whiteButton;

	/** final integer for number THREE. */
	private static final int THREE = 3;

	/** final integer for number FOUR. */
	private static final int FOUR = 4;

	/** final integer for number FIVE. */
	private static final int FIVE = 5;

	/** final integer for number SIX. */
	private static final int SIX = 6;

	/** final integer for number SEVEN. */
	private static final int SEVEN = 7;

	/** final integer for number TEN. */
	private static final int TEN = 10;

	/** the number of points needed to win the game. */
	private static final int WINPOINTS = 15;

	/** amount of gold chips at initialization of game. */
	private int goldChips = FIVE;

	/** amount of white chips at initialization of game. */
	private int whiteChips = 0;

	/** amount of red chips at initialization of game. */
	private int redChips = 0;

	/** amount of green chips at initialization of game. */
	private int greenChips = 0;

	/** amount of blue chips at initialization of game. */
	private int blueChips = 0;

	/** amount of black chips at initialization of game. */
	private int blackChips = 0;

	/** the current player's turn. */
	private Player currentPlayer;

	/** array of players in the game. */
	private Player[] players;

	/** instantiate game status. */
	private GameStatus status;

	/** deck of low level cards. */
	private ArrayList<Card> lowDeck;

	/** deck of middle level cards. */
	private ArrayList<Card> middleDeck;

	/** deck of high level cards. */
	private ArrayList<Card> highDeck;

	/** deck of nobles. */
	private ArrayList<Noble> nobleDeck;

	/** noble card in first slot. */
	private Noble noble1;

	/** noble card in second slot. */
	private Noble noble2;

	/** noble card in third slot. */
	private Noble noble3;

	/** high card in first slot. */
	private Card highCard1;

	/** high card in second slot. */
	private Card highCard2;

	/** high card in third slot. */
	private Card highCard3;

	/** high card in FOURth slot. */
	private Card highCard4;

	/** middle card in first slot. */
	private Card middleCard1;

	/** middle card in second slot. */
	private Card middleCard2;

	/** middle card in third slot. */
	private Card middleCard3;

	/** middle card in FOURth slot. */
	private Card middleCard4;

	/** low card in first slot. */
	private Card lowCard1;

	/** low card in second slot. */
	private Card lowCard2;

	/** low card in third slot. */
	private Card lowCard3;

	/** low card in FOURth slot. */
	private Card lowCard4;

	/** number of players in game. */
	private int numPlayers;


	/******************************************************************
	 * Constructor for SplendorGame class.
	 * @param pNumPlayers .
	 ******************************************************************/
	public SplendorGame(final int pNumPlayers) {
		if (pNumPlayers > 4 || pNumPlayers < 2) {
			throw new IllegalArgumentException();
		}
		this.numPlayers = pNumPlayers;
		players = new Player[numPlayers];
		for (int i = 1; i <= numPlayers; i++) {
			Player player = new Player(i);
			this.players[i - 1] = player;
		}
		this.status = GameStatus.IN_PROGRESS;
		this.currentPlayer = this.players[0];
		makeLowCards();
		makeMiddleCards();
		makeHighCards();
		makeNobles();
		shuffleDeckCards(lowDeck);
		shuffleDeckCards(middleDeck);
		shuffleDeckCards(highDeck);
		shuffleDeckNobles(nobleDeck);
		noble1 = nobleDeck.get(1);
		noble2 = nobleDeck.get(2);
		noble3 = nobleDeck.get(THREE);
		this.setCards();

		// set number of chips for 2 or 3 players
		if ((numPlayers == 2)
				|| (numPlayers == THREE)) {
			redChips = numPlayers + 2;
			greenChips = numPlayers + 2;
			blueChips = numPlayers + 2;
			blackChips = numPlayers + 2;
			whiteChips = numPlayers + 2;
		} else { // sets number of chips for 4 players
			redChips = SEVEN;
			greenChips = SEVEN;
			blueChips = SEVEN;
			blackChips = SEVEN;
			whiteChips = SEVEN;
		}
	}

	/**
	 * Set the status of the game.
	 * @param pStatus the status you want to set the current game status to.
	 */
	public void setGameStatus(final String pStatus) {
		switch (pStatus) {
		case "WON":
			this.status = GameStatus.WON;
			break;
		case "IN_PROGRESS":
			this.status = GameStatus.IN_PROGRESS;
			break;
		case "FINAL_TURN":
			this.status = GameStatus.FINAL_TURN;
			break;
		default:
			System.err.println("Error changing GameStatus");
			break;
		}
	}

	/**
	 * This is not a trailing space.
	 * @return THIS IS A COMMENT FOR THE RETURN
	 */
	public int getWinner() {
		int highest = 0;
		for (int i = 0; i < numPlayers; i++) {
			if (players[i].getPoints() > highest) {
				highest = players[i].getPoints();
				return i;
			}
		}
		return 0;
	}

	/**
	 * Checks to see if the game has been won by a player.
	 */
	public void checkWinGame() {
		for (int i = 0; i < numPlayers; i++) {
			if ((players[i].getPoints() >= this.WINPOINTS)
				&& (currentPlayer == players[numPlayers - 1])) {
				status = GameStatus.WON;
			}
		}
	}

	/**
	 * Checks if a player can buy a noble.
	 * @return return true if a player can buy a noble,
	 * otherwise return false.
	 */
	public boolean buyNoble() {
		boolean bought = false;
		ArrayList<Noble> temp = new ArrayList<Noble>();
		temp.add(noble1);
		temp.add(noble2);
		temp.add(noble3);

		for (int i = 0; i <= 2; i++) {
			if (temp.get(i) == null) {
				Object nothing = null;
				// checks if current player can take noble card
			} else if ((currentPlayer.getRedCards()
					>= temp.get(i).getRedRequired())
					&& (currentPlayer.getGreenCards()
					>= temp.get(i).getGreenRequired())
					&& (currentPlayer.getBlueCards()
					>= temp.get(i).getBlueRequired())
					&& (currentPlayer.getBlackCards()
					>= temp.get(i).getBlackRequired())
					&& (currentPlayer.getWhiteCards()
					>= temp.get(i).getWhiteRequired())) {
				currentPlayer.addPoints(temp.get(i)
						.getPrestigePoints());
				temp.set(i, null);

				if (temp.get(1) == null) {
					noble1 = null;
				}

				if (temp.get(2) == null) {
					noble2 = null;
				}

				if (temp.get(THREE) == null) {
					noble3 = null;
				}
				bought = true;
			}
		}
		return bought;
	}

	/**
	 * Makes sure the user can buy the resource card.
	 * @param check The card that is trying to be bought.
	 * @return return true if the card is bought,
	 * otherwise return false.
	 */
	public boolean buyResourceCard(final Card check) {
		// checks if current player can buy card
		// and then subtracts amount of chips appropriate
		if ((currentPlayer.getRedTotal() >= check.getRed())
				&& (currentPlayer.getGreenTotal()
						>= check.getGreen())
				&& (currentPlayer.getBlueTotal()
						>= check.getBlue())
				&& (currentPlayer.getBlackTotal()
						>= check.getBlack())
				&& (currentPlayer.getWhiteTotal()
						>= check.getWhite())) {

			// subtracts appropriate number of
			// red chips from currentPlayer
			if (check.getRed() != 0) {
				if ((currentPlayer.getRedCards()
						- check.getRed()) < 0) {
					currentPlayer.changeRed(
						currentPlayer.getRedCards()
							- check.getRed());
					redChips += check.getRed()
						- currentPlayer.getRedCards();
				}
			}
			// subtracts appropriate number
			// of blue chips from currentPlayer
			if (check.getBlue() != 0) {
				if ((currentPlayer.getBlueCards()
						- check.getBlue()) < 0) {
					currentPlayer.changeBlue(
						currentPlayer.getBlueCards()
							- check.getBlue());
					blueChips += check.getBlue()
						- currentPlayer.getBlueCards();
				}
			}

			// subtracts appropriate number
			// of green chips from currentPlayer
			if (check.getGreen() != 0) {
				if ((currentPlayer.getGreenCards()
						- check.getGreen()) < 0) {
					currentPlayer.changeGreen(
						currentPlayer.getGreenCards()
							- check.getGreen());
					greenChips += check.getGreen()
						- currentPlayer.getGreenCards();
				}
			}

			// subtracts appropriate number
			// of black chips from currentPlayer
			if (check.getBlack() != 0) {
				if ((currentPlayer.getBlackCards()
						- check.getBlack()) < 0) {
					currentPlayer.changeBlack(
						currentPlayer.getBlackCards()
							- check.getBlack());
					blackChips += check.getBlack()
						- currentPlayer.getBlackCards();
				}
			}

			// subtracts appropriate number
			// of white chips from currentPlayer
			if (check.getWhite() != 0) {
				if ((currentPlayer.getWhiteCards()
						- check.getWhite()) < 0) {
					currentPlayer.changeWhite(
						currentPlayer.getWhiteCards()
							- check.getWhite());
					whiteChips += check.getWhite()
						- currentPlayer.getWhiteCards();
				}
			}

			// adds card to currentPlayer
			if ((check.getColor().equals("red"))) {
				currentPlayer.setRedCards(
					currentPlayer.getRedCards() + 1);
			} else if ((check.getColor().equals("blue"))) {
				currentPlayer.setBlueCards(
					currentPlayer.getBlueCards() + 1);
			} else if ((check.getColor().equals("green"))) {
				currentPlayer.setGreenCards(
					currentPlayer.getGreenCards() + 1);
			} else if ((check.getColor().equals("black"))) {
				currentPlayer.setBlackCards(
					currentPlayer.getBlackCards() + 1);
			} else if ((check.getColor().equals("white"))) {
				currentPlayer.setWhiteCards(
					currentPlayer.getWhiteCards() + 1);
			}

			currentPlayer.addPoints(check.getPrestige());

			return true;
		}
		return false;
	}

	/**
	 * Adds the number of chips given to the user. Does error checking.
	 * @param red the number of red chips being picked up.
	 * @param blue the number of blue chips being picked up.
	 * @param green the number of green chips being picked up.
	 * @param black the number of black chips being picked up.
	 * @param white the number of white chips being picked up.
	 * @return Whether or not the chips were picked up.
	 */
	public boolean pickUpChips(final int red, final int blue,
			final int green, final int black, final int white) {
		// add the number of chips the player bought to their piles
		int total = red + blue + green + black + white;

		if (total == 0) { // if no chips selected
			JOptionPane.showMessageDialog(null,
					"Invalid Move: No Chips Selected");
			return false;
		}
		if (total > THREE) { // if more than 3 chips are selected
			JOptionPane.showMessageDialog(null,
					"Invalid Move: Too "
					+ "Many Chips Selected");
			return false;
		}
		// if 2 red chips are selected
		// and at least 1 other chip is selected
		if ((red == 2) && (total != 2)) {
			JOptionPane.showMessageDialog(null,
					"Invalid Move: When Red "
					+ "Has 2 Selected, No "
					+ "Other Chip Can Be "
					+ "Selected");
			return false;
		}
		// if 2 blue chips are selected
		// and at least 1 other chip is selected
		if ((blue == 2) && (total != 2)) {
			JOptionPane.showMessageDialog(null,
					"Invalid Move: "
					+ "When Blue Has 2 "
					+ "Selected, No Other "
					+ "Chip Can Be Selected");
			return false;
		}
		// if 2 green chips are selected
		// and at least 1 other chip is selected
		if ((green == 2) && (total != 2)) {
			JOptionPane.showMessageDialog(null,
					"Invalid Move: "
					+ "When Green Has 2 Selected, "
					+ "No Other Chip Can Be Selected");
			return false;
		}

		// if 2 black chips are selected
		// and at least 1 other chip is selected
		if ((black == 2) && (total != 2)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "When Black Has 2 Selected, "
					+ "No Other Chip Can Be Selected");
			return false;
		}

		// if 2 white chips are selected
		// and at least 1 other chip is selected
		if ((white == 2) && (total != 2)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "When White Has 2 Selected, "
					+ "No Other Chip Can Be Selected");
			return false;
		}

		// if 2 red chips are selected
		// when there are less than 4 red chips left
		if ((red == 2) && (redChips < FOUR)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Not Enough Red Chips Left");
			return false;
		}

		// if 2 blue chips are selected
		// when there are less than 4 blue chips left
		if ((blue == 2) && (blueChips < FOUR)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Not Enough Blue Chips Left");
			return false;
		}

		// if 2 green chips are selected
		// when there are less than 4 green chips left
		if ((green == 2) && (greenChips < FOUR)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Not Enough Green Chips Left");
			return false;
		}

		// if 2 black chips are selected
		// when there are less than 4 black chips left
		if ((black == 2) && (blackChips < FOUR)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Not Enough Black Chips Left");
			return false;
		}

		// if 2 white chips are selected
		// when there are less than 4 white chips left
		if ((white == 2) && (whiteChips < FOUR)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Not Enough White Chips Left");
			return false;
		}

		// when more than 2 of 1 chips kind is selected
		if ((red > 2)
				|| (blue > 2)
				|| (green > 2)
				|| (black > 2)
				|| (white > 2)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Too Many Chips of "
					+ "1 Kind Selected");
			return false;
		}

		// when there are negative numbers
		if ((red < 0)
				|| (blue < 0)
				|| (green < 0)
				|| (black < 0)
				|| (white < 0)) {
			JOptionPane.showMessageDialog(null, "Invalid Move: "
					+ "Cannot Have a Negative Input");
			return false;
		}

		// when there are not enough of the selected chips left
		if ((red > redChips)
				|| (blue > blueChips)
				|| (green > greenChips)
				|| (black > blackChips)
				|| (white > whiteChips)) {
			JOptionPane.showMessageDialog(null,
					"Invalid Move: "
						+ "Not Enough Chips Left");
			return false;
		}

		// if currentPlayer has more than 10 chips
		if ((currentPlayer.getChipTotal() + total) > TEN) {
			boolean check10 = false;
			while (!check10) {
				JTextField redField =
						new JTextField("0", FIVE);
				JTextField blueField =
						new JTextField("0", FIVE);
				JTextField greenField =
						new JTextField("0", FIVE);
				JTextField blackField =
						new JTextField("0", FIVE);
				JTextField whiteField =
						new JTextField("0", FIVE);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Red:"));
				myPanel.add(redField);
				myPanel.add(Box.createHorizontalStrut(TEN));
				myPanel.add(new JLabel("Blue:"));
				myPanel.add(blueField);
				myPanel.add(Box.createHorizontalStrut(TEN));
				myPanel.add(new JLabel("Green:"));
				myPanel.add(greenField);
				myPanel.add(Box.createHorizontalStrut(TEN));
				myPanel.add(new JLabel("Black:"));
				myPanel.add(blackField);
				myPanel.add(Box.createHorizontalStrut(TEN));
				myPanel.add(new JLabel("White:"));
				myPanel.add(whiteField);


				JOptionPane.showConfirmDialog(null, myPanel,
						"Which Chips "
						+ "Do You Want To Get Rid Of?",
						JOptionPane.OK_CANCEL_OPTION);
				int tempRed = Integer.parseInt(
						redField.getText());
				int tempBlue = Integer.parseInt(
						blueField.getText());
				int tempGreen = Integer.parseInt(
						greenField.getText());
				int tempBlack = Integer.parseInt(
						blackField.getText());
				int tempWhite = Integer.parseInt(
						whiteField.getText());

				total = tempRed + tempBlue + tempGreen
						+ tempBlack + tempWhite;

				if (total > THREE) {
					check10 = false;
				} else {
					if (currentPlayer.getRedChips()
							>= 0) {
						currentPlayer.changeRed(
								-tempRed);
					}
					if (currentPlayer.getBlueChips()
							>= 0) {
						currentPlayer.changeBlue(
								-tempBlue);
					}
					if (currentPlayer.getGreenChips()
							>= 0)	{
						currentPlayer.changeGreen(
								-tempGreen);
					}
					if (currentPlayer.getBlackChips()
							>= 0) {
						currentPlayer.changeBlack(
								-tempBlack);
					}
					if (currentPlayer.getWhiteChips()
							>= 0) {
						currentPlayer.changeWhite(
								-tempWhite);
					}
					return true;
				}
			}
		}

		currentPlayer.changeRed(red);
		currentPlayer.changeBlue(blue);
		currentPlayer.changeGreen(green);
		currentPlayer.changeBlack(black);
		currentPlayer.changeWhite(white);

		redChips = redChips - red;
		blueChips = blueChips - blue;
		greenChips = greenChips - green;
		blackChips = blackChips - black;
		whiteChips = whiteChips - white;

		return true;
	}

	/**
	 *  The player tries to hold a card for later.
	 * @param toBeHeld The card the player is trying
	 * to hold
	 * @return Whether or not the player can hold the card
	 */
	public boolean holdCard(final Card toBeHeld) {
		if (currentPlayer.getHoldCard() == null) {
			currentPlayer.setHoldCard(toBeHeld);
			currentPlayer.changeGold(1);
			return true;
		}
		JOptionPane.showMessageDialog(null,
				"Invalid Move: You Already Have a Card Held");

		return false;
	}

	/**
	 * Draws a card from the top of the deck.
	 * @param deck The deck of cards.
	 * @return the card that was drawn.
	 */
	private Card takeCard(final ArrayList<Card> deck) {
		if (deck.isEmpty()) {
			return null;
		}
		Card returnCard = deck.get(0);
		deck.remove(0);
		return returnCard;
	}

	/**
	 * Draws a card from the top of the deck.
	 * @param deck The deck of cards.
	 * @return the card that was drawn.
	 */
	public Card takeCard(final int deck) {
		Card returnCard;
		// low deck
		if (deck == 1) {
			if (lowDeck.isEmpty()) {
				return null;
			}
			returnCard = lowDeck.get(0);
			lowDeck.remove(0);
			return returnCard;
		} else if (deck == 2) {
			if (middleDeck.isEmpty()) {
				return null;
			}
			returnCard = middleDeck.get(0);
			middleDeck.remove(0);
			return returnCard;
		} else {
			if (highDeck.isEmpty()) {
				return null;
			}
			returnCard = highDeck.get(0);
			highDeck.remove(0);
			return returnCard;
		}
	}

	/**
	 * Set the cards on the card panel.
	 */
	private void setCards() {
		lowCard1 = takeCard(lowDeck);
		lowCard2 = takeCard(lowDeck);
		lowCard3 = takeCard(lowDeck);
		lowCard4 = takeCard(lowDeck);
		middleCard1 = takeCard(middleDeck);
		middleCard2 = takeCard(middleDeck);
		middleCard3 = takeCard(middleDeck);
		middleCard4 = takeCard(middleDeck);
		highCard1 = takeCard(highDeck);
		highCard2 = takeCard(highDeck);
		highCard3 = takeCard(highDeck);
		highCard4 = takeCard(highDeck);
	}

	/**
	 * Shuffle the given deck.
	 * @param deck The deck that is going to be shuffled.
	 */
	private void shuffleDeckCards(final ArrayList<Card> deck) {
		Collections.shuffle(deck);
	}

	/**
	 * Shuffle the given deck.
	 * @param deck The deck that is going to be shuffled.
	 */
	private void shuffleDeckNobles(final ArrayList<Noble> deck) {
		Collections.shuffle(deck);
	}

	/**
	 * Creates a deck of low level cards.
	 */
	private void makeLowCards() {
		lowDeck = new ArrayList<Card>();
		Card black11 = new Card("black", 1, 0, 1,
				1, 1, 1, 0, "pictures/black11.JPG");
		Card black12 = new Card("black", 1, 0, 1,
				1, 1, 2, 0, "pictures/black12.JPG");
		Card black13 = new Card("black", 1, 0, 2,
				1, 0, 2, 0, "pictures/black13.JPG");
		Card black14 = new Card("black", 1, 0, 0,
				THREE, 1, 0, 1, "pictures/black14.JPG");
		Card black15 = new Card("black", 1, 0, 0,
				1, 2, 0, 0, "pictures/black15.JPG");
		Card black16 = new Card("black", 1, 0, 2,
				0, 2, 0, 0, "pictures/black16.JPG");
		Card black17 = new Card("black", 1, 0, 0,
				0, THREE, 0, 0, "pictures/black17.JPG");
		Card black18 = new Card("black", 1, 1, 0,
				0, 0, FOUR, 0, "pictures/black18.JPG");
		Card blue11 = new Card("blue", 1, 0, 1,
				1, 1, 0, 1, "pictures/blue11.JPG");
		Card blue12 = new Card("blue", 1, 0, 1,
				2, 1, 0, 1, "pictures/blue12.JPG");
		Card blue13 = new Card("blue", 1, 0, 1,
				2, 2, 0, 0, "pictures/blue13.JPG");
		Card blue14 = new Card("blue", 1, 0, 0,
				1, THREE, 1, 0, "pictures/blue14.JPG");
		Card blue15 = new Card("blue", 1, 0, 1,
				0, 0, 0, 2, "pictures/blue15.JPG");
		Card blue16 = new Card("blue", 1, 0, 0,
				0, 2, 0, 2, "pictures/blue16.JPG");
		Card blue17 = new Card("blue", 1, 0, 0,
				0, 0, 0, THREE, "pictures/blue17.JPG");
		Card blue18 = new Card("blue", 1, 1, 0,
				FOUR, 0, 0, 0, "pictures/blue18.JPG");
		Card white11 = new Card("white", 1, 0, 0,
				1, 1, 1, 1, "pictures/white11.JPG");
		Card white12 = new Card("white", 1, 0, 0,
				1, 2, 1, 1, "pictures/white12.JPG");
		Card white13 = new Card("white", 1, 0, 0,
				0, 2, 2, 1, "pictures/white13.JPG");
		Card white14 = new Card("white", 1, 0, THREE,
				0, 0, 1, 1, "pictures/white14.JPG");
		Card white15 = new Card("white", 1, 0, 0,
				2, 0, 0, 1, "pictures/white15.JPG");
		Card white16 = new Card("white", 1, 0, 0,
				0, 0, 2, 2, "pictures/white16.JPG");
		Card white17 = new Card("white", 1, 0, 0,
				0, 0, THREE, 0, "pictures/white17.JPG");
		Card white18 = new Card("white", 1, 1, 0,
				0, FOUR, 0, 0, "pictures/white18.JPG");
		Card green11 = new Card("green", 1, 0, 1,
				1, 0, 1, 1, "pictures/green11.JPG");
		Card green12 = new Card("green", 1, 0, 1,
				1, 0, 1, 2, "pictures/green12.JPG");
		Card green13 = new Card("green", 1, 0, 0,
				2, 0, 1, 2, "pictures/green13.JPG");
		Card green14 = new Card("green", 1, 0, 1,
				0, 1, THREE, 0, "pictures/green14.JPG");
		Card green15 = new Card("green", 1, 0, 2,
				0, 0, 1, 0, "pictures/green15.JPG");
		Card green16 = new Card("green", 1, 0, 0,
				2, 0, 2, 0, "pictures/green16.JPG");
		Card green17 = new Card("green", 1, 0, 0,
				THREE, 0, 0, 0, "pictures/green17.JPG");
		Card green18 = new Card("green", 1, 1, 0,
				0, 0, 0, FOUR, "pictures/green18.JPG");
		Card red11 = new Card("red", 1, 0, 1,
				0, 1, 1, 1, "pictures/red11.JPG");
		Card red12 = new Card("red", 1, 0, 2,
				0, 1, 1, 1, "pictures/red12.JPG");
		Card red13 = new Card("red", 1, 0, 2,
				0, 1, 0, 2, "pictures/red13.JPG");
		Card red14 = new Card("red", 1, 0, 1,
				1, 0, 0, THREE, "pictures/red14.JPG");
		Card red15 = new Card("red", 1, 0, 0,
				0, 1, 2, 0, "pictures/red15.JPG");
		Card red16 = new Card("red", 1, 0, 2,
				2, 0, 0, 0, "pictures/red16.JPG");
		Card red17 = new Card("red", 1, 0, THREE,
				0, 0, 0, 0, "pictures/red17.JPG");
		Card red18 = new Card("red", 1, 1, FOUR,
				0, 0, 0, 0, "pictures/red18.JPG");
		lowDeck.add(black11);
		lowDeck.add(black12);
		lowDeck.add(black13);
		lowDeck.add(black14);
		lowDeck.add(black15);
		lowDeck.add(black16);
		lowDeck.add(black17);
		lowDeck.add(black18);
		lowDeck.add(blue11);
		lowDeck.add(blue12);
		lowDeck.add(blue13);
		lowDeck.add(blue14);
		lowDeck.add(blue15);
		lowDeck.add(blue16);
		lowDeck.add(blue17);
		lowDeck.add(blue18);
		lowDeck.add(white11);
		lowDeck.add(white12);
		lowDeck.add(white13);
		lowDeck.add(white14);
		lowDeck.add(white15);
		lowDeck.add(white16);
		lowDeck.add(white17);
		lowDeck.add(white18);
		lowDeck.add(green11);
		lowDeck.add(green12);
		lowDeck.add(green13);
		lowDeck.add(green14);
		lowDeck.add(green15);
		lowDeck.add(green16);
		lowDeck.add(green17);
		lowDeck.add(green18);
		lowDeck.add(red11);
		lowDeck.add(red12);
		lowDeck.add(red13);
		lowDeck.add(red14);
		lowDeck.add(red15);
		lowDeck.add(red16);
		lowDeck.add(red17);
		lowDeck.add(red18);
	}

	/**
	 * Creates a deck of middle level cards.
	 */
	private void makeMiddleCards() {
		middleDeck = new ArrayList<Card>();
		Card black21 = new Card("black", 2, 1, THREE,
				0, 2, 2, 0, "pictures/black21.JPG");
		Card black22 = new Card("black", 2, 1, THREE,
				0, THREE, 0, 2, "pictures/black22.JPG");
		Card black23 = new Card("black", 2, 2, 0,
				2, FOUR, 1, 0, "pictures/black23.JPG");
		Card black24 = new Card("black", 2, 2, 0,
				THREE, FIVE, 0, 0, "pictures/black24.JPG");
		Card black25 = new Card("black", 2, 2, FIVE,
				0, 0, 0, 0, "pictures/black25.JPG");
		Card black26 = new Card("black", 2, THREE, 0,
				0, 0, 0, SIX, "pictures/black26.JPG");
		Card blue21 = new Card("blue", 2, 1, 0,
				THREE, 2, 2, 0, "pictures/blue21.JPG");
		Card blue22 = new Card("blue", 2, 1, 0,
				0, THREE, 2, THREE, "pictures/blue22.JPG");
		Card blue23 = new Card("blue", 2, 2, FIVE,
				0, 0, THREE, 0, "pictures/blue23.JPG");
		Card blue24 = new Card("blue", 2, 2, 2,
				1, 0, 0, FOUR, "pictures/blue24.JPG");
		Card blue25 = new Card("blue", 2, 2, 0,
				0, 0, FIVE, 0, "pictures/blue25.JPG");
		Card blue26 = new Card("blue", 2, THREE, 0,
				0, 0, SIX, 0, "pictures/blue26.JPG");
		Card white21 = new Card("white", 2, 1, 0,
				2, THREE, 0, 2, "pictures/white21.JPG");
		Card white22 = new Card("white", 2, 1, 2,
				THREE, 0, THREE, 0, "pictures/white22.JPG");
		Card white23 = new Card("white", 2, 2, 0,
				FOUR, 1, 0, 2, "pictures/white23.JPG");
		Card white24 = new Card("white", 2, 2, 0,
				FIVE, 0, 0, THREE, "pictures/white24.JPG");
		Card white25 = new Card("white", 2, 2, 0,
				FIVE, 0, 0, 0, "pictures/white25.JPG");
		Card white26 = new Card("white", 2, THREE, SIX,
				0, 0, 0, 0, "pictures/white26.JPG");
		Card green21 = new Card("green", 2, 1, THREE,
				THREE, 2, 0, 0, "pictures/green21.JPG");
		Card green22 = new Card("green", 2, 1, 2,
				0, 0, THREE, 2, "pictures/green22.JPG");
		Card green23 = new Card("green", 2, 2, FOUR,
				0, 0, 2, 1, "pictures/green23.JPG");
		Card green24 = new Card("green", 2, 2, 0,
				0, THREE, FIVE, 0, "pictures/green24.JPG");
		Card green25 = new Card("green", 2, 2, 0,
				0, FIVE, 0, 0, "pictures/green25.JPG");
		Card green26 = new Card("green", 2, THREE, 0,
				0, SIX, 0, 0, "pictures/green26.JPG");
		Card red21 = new Card("red", 2, 1, 2,
				2, 0, 0, THREE, "pictures/red21.JPG");
		Card red22 = new Card("red", 2, 1, 0,
				2, 0, THREE, THREE, "pictures/red22.JPG");
		Card red23 = new Card("red", 2, 2, 1,
				0, 2, FOUR, 0, "pictures/red23.JPG");
		Card red24 = new Card("red", 2, 2, THREE,
				0, 0, 0, FIVE, "pictures/red24.JPG");
		Card red25 = new Card("red", 2, 2, 0,
				0, 0, 0, FIVE, "pictures/red25.JPG");
		Card red26 = new Card("red", 2, THREE, 0,
				SIX, 0, 0, 0, "pictures/red26.JPG");
		middleDeck.add(black21);
		middleDeck.add(black22);
		middleDeck.add(black23);
		middleDeck.add(black24);
		middleDeck.add(black25);
		middleDeck.add(black26);
		middleDeck.add(blue21);
		middleDeck.add(blue22);
		middleDeck.add(blue23);
		middleDeck.add(blue24);
		middleDeck.add(blue25);
		middleDeck.add(blue26);
		middleDeck.add(green21);
		middleDeck.add(green22);
		middleDeck.add(green23);
		middleDeck.add(green24);
		middleDeck.add(green25);
		middleDeck.add(green26);
		middleDeck.add(white21);
		middleDeck.add(white22);
		middleDeck.add(white23);
		middleDeck.add(white24);
		middleDeck.add(white25);
		middleDeck.add(white26);
		middleDeck.add(red21);
		middleDeck.add(red22);
		middleDeck.add(red23);
		middleDeck.add(red24);
		middleDeck.add(red25);
		middleDeck.add(red26);
	}

	/**
	 * Creates a deck of high level cards.
	 */
	private void makeHighCards() {
		highDeck = new ArrayList<Card>();
		Card black31 = new Card("black", THREE, THREE, THREE,
				THREE, FIVE, THREE, 0, "pictures/black31.JPG");
		Card black32 = new Card("black", THREE, FOUR, 0,
				SEVEN, 0, 0, 0, "pictures/black32.JPG");
		Card black33 = new Card("black", THREE, FOUR, 0,
				SIX, THREE, 0, THREE, "pictures/black33.JPG");
		Card black34 = new Card("black", THREE, FIVE, 0,
				SEVEN, 0, 0, THREE, "pictures/black34.JPG");
		Card blue31 = new Card("blue", THREE, THREE, THREE,
				THREE, THREE, 0, FIVE, "pictures/blue31.JPG");
		Card blue32 = new Card("blue", THREE, FOUR, SEVEN,
				0, 0, 0, 0, "pictures/blue32.JPG");
		Card blue33 = new Card("blue", THREE, FOUR, SIX,
				0, 0, THREE, THREE, "pictures/blue33.JPG");
		Card blue34 = new Card("blue", THREE, FIVE, SEVEN,
				0, 0, THREE, 0, "pictures/blue34.JPG");
		Card white31 = new Card("white", THREE, THREE, 0, FIVE,
				THREE, THREE, THREE, "pictures/white31.JPG");
		Card white32 = new Card("white", THREE, FOUR, 0,
				0, 0, 0, SEVEN, "pictures/white32.JPG");
		Card white33 = new Card("white", THREE, FOUR, THREE,
				THREE, 0, 0, SIX, "pictures/white33.JPG");
		Card white34 = new Card("white", THREE, FIVE, THREE,
				0, 0, 0, SEVEN, "pictures/white34.JPG");
		Card green31 = new Card("green", THREE, THREE, FIVE,
				THREE, 0, THREE, THREE, "pictures/green31.JPG");
		Card green32 = new Card("green", THREE, FOUR,
				0, 0, 0, SEVEN, 0, "pictures/green32.JPG");
		Card green33 = new Card("green", THREE, FOUR, THREE,
				0, THREE, SIX, 0, "pictures/green33.JPG");
		Card green34 = new Card("green", THREE, FIVE,
				0, 0, THREE, SEVEN, 0, "pictures/green34.JPG");
		Card red31 = new Card("red", THREE, THREE, THREE,
				0, THREE, FIVE, THREE, "pictures/red31.JPG");
		Card red32 = new Card("red", THREE, FOUR, 0,
				0, SEVEN, 0, 0, "pictures/red32.JPG");
		Card red33 = new Card("red", THREE, FOUR, 0,
				THREE, SIX, THREE, 0, "pictures/red33.JPG");
		Card red34 = new Card("red", THREE, FIVE, 0,
				THREE, SEVEN, 0, 0, "pictures/red34.JPG");
		highDeck.add(black31);
		highDeck.add(black32);
		highDeck.add(black33);
		highDeck.add(black34);
		highDeck.add(blue31);
		highDeck.add(blue32);
		highDeck.add(blue33);
		highDeck.add(blue34);
		highDeck.add(white31);
		highDeck.add(white32);
		highDeck.add(white33);
		highDeck.add(white34);
		highDeck.add(green31);
		highDeck.add(green32);
		highDeck.add(green33);
		highDeck.add(green34);
		highDeck.add(red31);
		highDeck.add(red32);
		highDeck.add(red33);
		highDeck.add(red34);
	}

	/**
	 * Creates a deck of nobles.
	 */
	public void makeNobles() {
		nobleDeck = new ArrayList<Noble>();
		// Noble(prestigePoints, whiteRequired,
		// redRequired, greenRequired, blueRequired,
		//		blackRequired, imageFile)
		Noble tempNoble1 = new Noble(THREE, 0, THREE,
				THREE, THREE, 0, "pictures/noble1.JPG");
		Noble tempNoble2 = new Noble(THREE, THREE, 0,
				0, THREE, THREE, "pictures/noble2.JPG");
		Noble tempNoble3 = new Noble(THREE, FOUR, 0,
				0, 0, FOUR, "pictures/noble3.JPG");
		Noble noble4 = new Noble(THREE, FOUR, 0,
				0, FOUR, 0, "pictures/noble4.JPG");
		Noble noble5 = new Noble(THREE, 0, 0,
				FOUR, FOUR, 0, "pictures/noble5.JPG");
		Noble noble6 = new Noble(THREE, THREE, 0,
				THREE, THREE, 0, "pictures/noble6.JPG");
		Noble noble7 = new Noble(THREE, THREE, THREE,
				0, 0, THREE, "pictures/noble7.JPG");
		Noble noble8 = new Noble(THREE, 0, THREE,
				THREE, 0, THREE, "pictures/noble8.JPG");
		Noble noble9 = new Noble(THREE, 0, FOUR,
				0, 0, FOUR, "pictures/noble9.JPG");
		Noble noble10 = new Noble(THREE, 0, FOUR,
				FOUR, 0, 0, "pictures/noble10.JPG");
		nobleDeck.add(tempNoble1);
		nobleDeck.add(tempNoble2);
		nobleDeck.add(tempNoble3);
		nobleDeck.add(noble4);
		nobleDeck.add(noble5);
		nobleDeck.add(noble6);
		nobleDeck.add(noble7);
		nobleDeck.add(noble8);
		nobleDeck.add(noble9);
		nobleDeck.add(noble10);
	}

	/**
	 * Returns the number of gold chips the game has.
	 * @return the number of gold chips in the game.
	 */
	public int getGoldChips() {
		return goldChips;
	}

	/**
	 * Set the number of gold chips in the game.
	 * @param pGoldChips set the number of gold chips in the game.
	 */
	public void setGoldChips(final int pGoldChips) {
		this.goldChips = pGoldChips;
	}

	/**
	 * Returns the number of white chips the game has.
	 * @return the number of white chips in the game.
	 */
	public int getWhiteChips() {
		return whiteChips;
	}

	/**
	 * Set the number of white chips in the game.
	 * @param pWhiteChips set the number of white chips in the game.
	 */
	public void setWhiteChips(final int pWhiteChips) {
		this.whiteChips = pWhiteChips;
	}

	/**
	 * Returns the number of red chips the game has.
	 * @return the number of red chips in the game.
	 */
	public int getRedChips() {
		return redChips;
	}

	/**
	 * Set the number of red chips in the game.
	 * @param pRedChips set the number of red chips in the game.
	 */
	public void setRedChips(final int pRedChips) {
		this.redChips = pRedChips;
	}

	/**
	 * Returns the number of green chips the game has.
	 * @return the number of green chips in the game.
	 */
	public int getGreenChips() {
		return greenChips;
	}

	/**
	 * Set the number of green chips in the game.
	 * @param pGreenChips set the number of green chips in the game.
	 */
	public void setGreenChips(final int pGreenChips) {
		this.greenChips = pGreenChips;
	}

	/**
	 * Returns the number of blue chips the game has.
	 * @return the number of blue chips in the game.
	 */
	public int getBlueChips() {
		return blueChips;
	}

	/**
	 * Set the number of blue chips in the game.
	 * @param pBlueChips set the number of blue chips in the game.
	 */
	public void setBlueChips(final int pBlueChips) {
		this.blueChips = pBlueChips;
	}

	/**
	 * Returns the number of black chips the game has.
	 * @return the number of black chips in the game.
	 */
	public int getBlackChips() {
		return blackChips;
	}

	/**
	 * Set the number of black chips in the game.
	 * @param pBlackChips set the number of black chips in the game.
	 */
	public void setBlackChips(final int pBlackChips) {
		this.blackChips = pBlackChips;
	}

	/**
	 * Return the current player object.
	 * @return return the current player object.
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Set the current player to the given player object.
	 * @param pCurrentPlayer the object current player should be set to.
	 */
	public void setCurrentPlayer(final Player pCurrentPlayer) {
		this.currentPlayer = pCurrentPlayer;
	}

	/**
	 * Returns an array of player objects.
	 * @return an array of player objects.
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * Set the array of player objects to an array of players.
	 * @param pPlayers an array of player objects.
	 */
	public void setPlayers(final Player[] pPlayers) {
		this.players = pPlayers;
	}

	/**
	 * Return the game status.
	 * @return the current game status.
	 */
	public GameStatus getStatus() {
		return status;
	}

	/**
	 * Set the game status to a GameStatus.
	 * @param pStatus a GameStatus type.
	 */
	public void setStatus(final GameStatus pStatus) {
		this.status = pStatus;
	}

	/**
	 * Return an arraylist lowdeck.
	 * @return an arraylist lowdeck.
	 */
	public ArrayList<Card> getLowDeck() {
		return lowDeck;
	}

	/**
	 * Set the lowdeck to a new arraylist.
	 * @param pLowDeck an arraylist of low cards.
	 */
	public void setLowDeck(final ArrayList<Card> pLowDeck) {
		this.lowDeck = pLowDeck;
	}

	/**
	 * Return an arraylist highdeck.
	 * @return an arraylist middledeck.
	 */
	public ArrayList<Card> getMiddleDeck() {
		return middleDeck;
	}

	/**
	 * Set the middledeck to a new arraylist.
	 * @param pMiddleDeck an arraylist of middle cards.
	 */
	public void setMiddleDeck(final ArrayList<Card> pMiddleDeck) {
		this.middleDeck = pMiddleDeck;
	}

	/**
	 * Return an arraylist highdeck.
	 * @return an arraylist highdeck.
	 */
	public ArrayList<Card> getHighDeck() {
		return highDeck;
	}

	/**
	 * set the highdeck to a new arraylist.
	 * @param pHighDeck an arraylist of high cards.
	 */
	public void setHighDeck(final ArrayList<Card> pHighDeck) {
		this.highDeck = pHighDeck;
	}

	/**
	 * Return an arraylist of nobles.
	 * @return an arraylist of nobles.
	 */
	public ArrayList<Noble> getNobleDeck() {
		return nobleDeck;
	}

	/**
	 * Set the nobledeck to a new arraylist.
	 * @param pNobleDeck an arraylist of nobles
	 */
	public void setNobleDeck(final ArrayList<Noble> pNobleDeck) {
		this.nobleDeck = pNobleDeck;
	}

	/**
	 * Return the first noble.
	 * @return the first noble.
	 */
	public Noble getNoble1() {
		return noble1;
	}

	/**
	 * Set the first noble.
	 * @param pNoble1 the new first noble.
	 */
	public void setNoble1(final Noble pNoble1) {
		this.noble1 = pNoble1;
	}

	/**
	 * Return the second noble.
	 * @return the second noble.
	 */
	public Noble getNoble2() {
		return noble2;
	}

	/**
	 * Set the second noble.
	 * @param pNoble2 the new second noble
	 */
	public void setNoble2(final Noble pNoble2) {
		this.noble2 = pNoble2;
	}

	/**
	 * Return the third noble.
	 * @return the third noble.
	 */
	public Noble getNoble3() {
		return noble3;
	}

	/**
	 * Set the third noble.
	 * @param pNoble3 the new third noble.
	 */
	public void setNoble3(final Noble pNoble3) {
		this.noble3 = pNoble3;
	}

	/**
	 * Return the first high card.
	 * @return the first high card.
	 */
	public Card getHighCard1() {
		return highCard1;
	}

	/**
	 * Set the first high card.
	 * @param pHighCard1 the new first high card.
	 */
	public void setHighCard1(final Card pHighCard1) {
		this.highCard1 = pHighCard1;
	}

	/**
	 * Return the second high card.
	 * @return the second high card.
	 */
	public Card getHighCard2() {
		return highCard2;
	}

	/**
	 * Set the second high card.
	 * @param pHighCard2 the new second high card.
	 */
	public void setHighCard2(final Card pHighCard2) {
		this.highCard2 = pHighCard2;
	}

	/**
	 * Return the third high card.
	 * @return the third high card.
	 */
	public Card getHighCard3() {
		return highCard3;
	}

	/**
	 * Set the third high card.
	 * @param pHighCard3 the new third high card.
	 */
	public void setHighCard3(final Card pHighCard3) {
		this.highCard3 = pHighCard3;
	}

	/**
	 * Return the FOURth high card.
	 * @return the FOURth high card.
	 */
	public Card getHighCard4() {
		return highCard4;
	}

	/**
	 * Set the FOURth high card.
	 * @param pHighCard4 the new FOURth high card.
	 */
	public void setHighCard4(final Card pHighCard4) {
		this.highCard4 = pHighCard4;
	}

	/**
	 * Return the first middle card.
	 * @return the first middle card.
	 */
	public Card getMiddleCard1() {
		return middleCard1;
	}

	/**
	 * Set the first middle card.
	 * @param pMiddleCard1 the new first middle card.
	 */
	public void setMiddleCard1(final Card pMiddleCard1) {
		this.middleCard1 = pMiddleCard1;
	}

	/**
	 * Return the second middle card.
	 * @return the second middle card.
	 */
	public Card getMiddleCard2() {
		return middleCard2;
	}

	/**
	 * Set the second middle card.
	 * @param pMiddleCard2 the new second middle card.
	 */
	public void setMiddleCard2(final Card pMiddleCard2) {
		this.middleCard2 = pMiddleCard2;
	}

	/**
	 * Return the third middle card.
	 * @return the third middle card.
	 */
	public Card getMiddleCard3() {
		return middleCard3;
	}

	/**
	 * Set the third middle card.
	 * @param pMiddleCard3 the new third middle card.
	 */
	public void setMiddleCard3(final Card pMiddleCard3) {
		this.middleCard3 = pMiddleCard3;
	}

	/**
	 * Return the FOURth middle card.
	 * @return the FOURth middle card.
	 */
	public Card getMiddleCard4() {
		return middleCard4;
	}

	/**
	 * Set the FOURth middle card.
	 * @param pMiddleCard4 the new FOURth middle card.
	 */
	public void setMiddleCard4(final Card pMiddleCard4) {
		this.middleCard4 = pMiddleCard4;
	}

	/**
	 * Return the first low card.
	 * @return the first low card.
	 */
	public Card getLowCard1() {
		return lowCard1;
	}

	/**
	 * Set the first low card.
	 * @param pLowCard1 the new first low card.
	 */
	public void setLowCard1(final Card pLowCard1) {
		this.lowCard1 = pLowCard1;
	}

	/**
	 * Return the second low card.
	 * @return the second low card.
	 */
	public Card getLowCard2() {
		return lowCard2;
	}

	/**
	 * Set the second low card.
	 * @param pLowCard2 the new second low card.
	 */
	public void setLowCard2(final Card pLowCard2) {
		this.lowCard2 = pLowCard2;
	}

	/**
	 * Return the third low card.
	 * @return the third low card.
	 */
	public Card getLowCard3() {
		return lowCard3;
	}

	/**
	 * Set the third low card.
	 * @param pLowCard3 the third low card.
	 */
	public void setLowCard3(final Card pLowCard3) {
		this.lowCard3 = pLowCard3;
	}

	/**
	 * Return the fourth low card.
	 * @return the fourth low card.
	 */
	public Card getLowCard4() {
		return lowCard4;
	}

	/**
	 * Set the fourth low card.
	 * @param pLowCard4 the new fourth low card.
	 */
	public void setLowCard4(final Card pLowCard4) {
		this.lowCard4 = pLowCard4;
	}

	/**
	 * Return the number of players.
	 * @return the number of players in the game.
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * Set the number of players.
	 * @param pNumPlayers the new number of players.
	 */
	public void setNumPlayers(final int pNumPlayers) {
		this.numPlayers = pNumPlayers;
	}
}