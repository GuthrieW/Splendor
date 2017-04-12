package splendor;

/**********************************************************************
 * This class maintains Development Card objects.
 * @author David Brown, Wesley Guthrie
 **********************************************************************/
public class Card {

	/** color of the development card. */
	private String color;

	/** prestige points of the development card. */
	private int prestige;

	/** level of the development card. */
	private int level;

	/** number of white required to buy the development card. */
	private int white;

	/** number of red required to buy the development card. */
	private int red;

	/** number of green required to buy the development card. */
	private int green;

	/** number of blue required to buy the development card. */
	private int blue;

	/** number of black required to buy the development card. */
	private int black;

	/** image of development card. */
	private String imageFile;

	/*****************************************************
	 * Constructor for objects of class DevelopmentCard.
	 * @param pColor the color of the card.
	 * @param pLevel the level of the card.
	 * @param pPrestige how many points the card is 
	 * worth.
	 * @param pWhite how many white chips it takes
	 * to buy the card.
	 * @param pRed how many red chips it takes
	 * to buy the card.
	 * @param pGreen how many green chips it takes
	 * to buy the card.
	 * @param pBlue how many blue chips it takes
	 * to buy the card.
	 * @param pBlack how many black chips it takes
	 * to buy the card.
	 * @param pImageFile where the image file is saved
	 *****************************************************/
	public Card(final String pColor, final int pLevel,
			final int pPrestige, final int pWhite,
			final int pRed, final int pGreen,
			final int pBlue, final int pBlack,
			final String pImageFile) {
		this.color = pColor;
		this.level = pLevel;
		this.prestige = pPrestige;
		this.white = pWhite;
		this.red = pRed;
		this.green = pGreen;
		this.blue = pBlue;
		this.black = pBlack;
		this.imageFile = pImageFile;
	}

	/******************************************************************
	 * return color of Resource Card.
	 * @return color
	 ******************************************************************/
	public String getColor() {
		return color;
	}

	/******************************************************************
	 * return prestige or Resource Card.
	 * @return prestige
	 ******************************************************************/
	public int getPrestige() {
		return prestige;
	}

	/******************************************************************
	 * return level of Resource Card.
	 * @return level
	 ******************************************************************/
	public int getLevel() {
		return level;
	}

	/******************************************************************
	 * return white required to buy Resource Card.
	 * @return white
	 ******************************************************************/
	public int getWhite() {
		return white;
	}

	/******************************************************************
	 * return red required to buy Resource Card.
	 * @return red
	 ******************************************************************/
	public int getRed() {
		return red;
	}

	/******************************************************************
	 * return green required to buy Resource Card.
	 * @return green
	 ******************************************************************/
	public int getGreen() {
		return green;
	}

	/******************************************************************
	 * return blue required to buy Resource Card.
	 * @return blue
	 ******************************************************************/
	public int getBlue() {
		return blue;
	}

	/******************************************************************
	 * return black required to buy Resource Card.
	 * @return black
	 ******************************************************************/
	public int getBlack() {
		return black;
	}

	/******************************************************************
	 * return imageFile of Resource Card.
	 * @return imageFile
	 ******************************************************************/
	public String getImageFile() {
		return imageFile;
	}
}