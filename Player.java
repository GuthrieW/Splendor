package Splendor;

/**********************************************************************
 * This class maintains Player objects.
 * @author David Brown, Wesley Guthrie
 **********************************************************************/
public class Player {

	/** number of gold chips player has. */
	private int goldChips;

	/** number of red chips player has. */
	private int redChips;

	/** number of blue chips player has.*/
	private int blueChips;

	/** number of green chips player has. */
	private int greenChips;

	/** number of black chips player has. */
	private int blackChips;

	/** number of white chips player has. */
	private int whiteChips;

	/** number of red cards chips player has. */
	private int redCards;

	/** number of blue cards player has. */
	private int blueCards;

	/** number of green cards player has. */
	private int greenCards;

	/** number of black cards player has. */
	private int blackCards;

	/** number of white cards player . */
	private int whiteCards;

	/** total number of red player has. */
	private int redTotal;

	/** total number of blue player has. */
	private int blueTotal;

	/** total number of green player has. */
	private int greenTotal;

	/** total number of black player has. */
	private int blackTotal;

	/** total number of white player has. */
	private int whiteTotal;

	/** total number chips player has. */
	private int chipTotal;

	/** players held card. */
	private Card holdCard;

	/** number of points player has. */
	private int points;

	/*** player number. */
	private int playerNum;

	/*****************************************************
	 * Constructor for objects of class DevelopmentCard.
	 * @param pPlayerNum .
	 *****************************************************/
	public Player(final int pPlayerNum) {
		this.playerNum = pPlayerNum;
		this.goldChips = 0;
		this.redChips = 0;
		this.blueChips = 0;
		this.greenChips = 0;
		this.blackChips = 0;
		this.whiteChips = 0;
		this.redCards = 0;
		this.blueCards = 0;
		this.greenCards = 0;
		this.blackCards = 0;
		this.whiteCards = 0;
		this.redTotal = 0;
		this.blueTotal = 0;
		this.greenTotal = 0;
		this.blackTotal = 0;
		this.whiteTotal = 0;
		this.holdCard = null;
		this.points = 0;

	}

	/******************************************************************
	 * return player number.
	 * @return playerNum the player's number.
	 ******************************************************************/
	public int getPlayerNum() {
		return this.playerNum;
	}

	/******************************************************************
	 * change amount of gold that player has.
	 * @param pGold the amount of gold chips a player has.
	 ******************************************************************/
	public void changeGold(final int pGold) {
		this.goldChips += pGold;
	}

	/******************************************************************
	 * change amount of red that player has.
	 * @param pRed the number of red chips.
	 ******************************************************************/
	public void changeRed(final int pRed) {
		this.redChips += pRed;
	}

	/******************************************************************
	 * change amount of blue that player has.
	 * @param pBlue the number of blue chips.
	 ******************************************************************/
	public void changeBlue(final int pBlue) {
		this.blueChips += pBlue;
	}

	/******************************************************************
	 * change amount of green that player has.
	 * @param pGreen the number of green chips.
	 ******************************************************************/
	public void changeGreen(final int pGreen) {
		this.greenChips += pGreen;
	}

	/******************************************************************
	 * change amount of black that player has.
	 * @param pBlack the number of black chips.
	 ******************************************************************/
	public void changeBlack(final int pBlack) {
		this.blackChips += pBlack;
	}

	/******************************************************************
	 * change amount of white that player has.
	 * @param pWhite the number of white chips.
	 ******************************************************************/
	public void changeWhite(final int pWhite) {
		this.whiteChips += pWhite;
	}

	/******************************************************************
	 * adds points to player.
	 * @param pPoints the number of points a player has.
	 ******************************************************************/
	public void addPoints(final int pPoints) {
		this.points += pPoints;
	}

	/******************************************************************
	 * return player points.
	 * @return points the number of points a player has.
	 ******************************************************************/
	public int getPoints() {
		return points;
	}

	/******************************************************************
	 * return amount of red chips player has.
	 * @return redChips the number of red chips a player has.
	 ******************************************************************/
	public int getRedChips() {
		return redChips;
	}

	/******************************************************************
	 * return amount of blue chips player has.
	 * @return blueChips the number of blue chips a player has.
	 ******************************************************************/
	public int getBlueChips() {
		return blueChips;
	}

	/******************************************************************
	 * return amount of green chips player has.
	 * @return greenChips the number of green chips a player has.
	 ******************************************************************/
	public int getGreenChips() {
		return greenChips;
	}

	/******************************************************************
	 * return amount of black chips player has.
	 * @return blackChips the number of black chips a player has.
	 ******************************************************************/
	public int getBlackChips() {
		return blackChips;
	}

	/******************************************************************
	 * return amount of white chips player has.
	 * @return whiteChips the number of white chips a player has.
	 ******************************************************************/
	public int getWhiteChips() {
		return whiteChips;
	}

	/******************************************************************
	 * return amount of red cards player has.
	 * @return redCards the number of red cards a player has.
	 ******************************************************************/
	public int getRedCards() {
		return redCards;
	}

	/******************************************************************
	 * sets amount of red cards player has.
	 * @param pRedCards the number of red cards a player has.
	 ******************************************************************/
	public void setRedCards(final int pRedCards) {
		this.redCards = pRedCards;
	}

	/******************************************************************
	 * return amount of blue cards player has.
	 * @return blueCards the number of blue cards a player has.
	 ******************************************************************/
	public int getBlueCards() {
		return blueCards;
	}

	/******************************************************************
	 * sets amount of blue cards player has.
	 * @param pBlueCards the number of blue cards a player has.
	 ******************************************************************/
	public void setBlueCards(final int pBlueCards) {
		this.blueCards = pBlueCards;
	}

	/******************************************************************
	 * return amount of green cards player has.
	 * @return greenCards the number of green cards a player has.
	 ******************************************************************/
	public int getGreenCards() {
		return greenCards;
	}

	/******************************************************************
	 * sets amount of green cards player has.
	 * @param pGreenCards the number of green cards a player has.
	 ******************************************************************/
	public void setGreenCards(final int pGreenCards) {
		this.greenCards = pGreenCards;
	}

	/******************************************************************
	 * return amount of black cards player has.
	 * @return blackCards the number of black cards a player has.
	 ******************************************************************/
	public int getBlackCards() {
		return blackCards;
	}

	/******************************************************************
	 * sets amount of black cards player has.
	 * @param pBlackCards the number of black cards a player has.
	 ******************************************************************/
	public void setBlackCards(final int pBlackCards) {
		this.blackCards = pBlackCards;
	}

	/******************************************************************
	 * return amount of white cards player has.
	 * @return whiteCards the number of white cards a player has.
	 ******************************************************************/
	public int getWhiteCards() {
		return whiteCards;
	}

	/******************************************************************
	 * sets amount of white cards player has.
	 * @param pWhiteCards the number of white cards a player has.
	 ******************************************************************/
	public void setWhiteCards(final int pWhiteCards) {
		this.whiteCards = pWhiteCards;
	}

	/******************************************************************
	 * return total amount of red player has.
	 * @return redTotal the number of red resources
	 * a player has.
	 ******************************************************************/
	public int getRedTotal() {
		setRedTotal();
		return redTotal;
	}

	/******************************************************************
	 * sets amount of red total for player.
	 ******************************************************************/
	public void setRedTotal() {
		this.redTotal = redCards + redChips;
	}

	/******************************************************************
	 * return total amount of blue player has.
	 * @return blueTotal the number of blue resources
	 * a player has.
	 ******************************************************************/
	public int getBlueTotal() {
		setBlueTotal();
		return blueTotal;
	}

	/******************************************************************
	 * sets amount of blue total for player.
	 ******************************************************************/
	public void setBlueTotal() {
		this.blueTotal = blueCards + blueChips;
	}

	/******************************************************************
	 * return total amount of green player has.
	 * @return greenTotal the number of green resources
	 * a player has.
	 ******************************************************************/
	public int getGreenTotal() {
		setGreenTotal();
		return greenTotal;
	}

	/******************************************************************
	 * sets amount of green total for player.
	 ******************************************************************/
	public void setGreenTotal() {
		this.greenTotal = greenCards + greenChips;
	}

	/******************************************************************
	 * return total amount of black player has.
	 * @return blackTotal the number of black resources
	 * a player has.
	 ******************************************************************/
	public int getBlackTotal() {
		setBlackTotal();
		return blackTotal;
	}

	/******************************************************************
	 * sets amount of black total for player.
	 ******************************************************************/
	public void setBlackTotal() {
		this.blackTotal = blackCards + blackChips;
	}

	/******************************************************************
	 * return total amount of white player has.
	 * @return whiteTotal the number of white resources
	 * a player has.
	 ******************************************************************/
	public int getWhiteTotal() {
		setWhiteTotal();
		return whiteTotal;
	}

	/******************************************************************
	 * sets amount of white total for player.
	 ******************************************************************/
	public void setWhiteTotal() {
		this.whiteTotal = whiteCards + whiteChips;
	}

	/******************************************************************
	 * return total amount of chips player has.
	 * @return chipTotal the total number of chips a player has.
	 ******************************************************************/
	public int getChipTotal() {
		setChipTotal();
		return chipTotal;
	}

	/******************************************************************
	 * sets total amount of chips for player.
	 ******************************************************************/
	public void setChipTotal() {
		this.chipTotal = whiteChips + redChips + greenChips
				+ blueChips + blackChips;
	}

	/******************************************************************
	 * return held card player has.
	 * @return holdCard the card the player is holding.
	 ******************************************************************/
	public Card getHoldCard() {
		return holdCard;
	}

	/******************************************************************
	 * sets held card for player.
	 * @param pHoldCard the card the player is holding.
	 ******************************************************************/
	public void setHoldCard(final Card pHoldCard) {
		this.holdCard = pHoldCard;
	}
}
