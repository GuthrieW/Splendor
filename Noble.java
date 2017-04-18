package Splendor;

/**********************************************************************
 * This class maintains Noble Card objects.
 * @author David Brown, Wesley Guthrie
 **********************************************************************/
public class Noble {

	/** the number of white chips required to buy the noble. */
	private int whiteRequired;

	/** the number of red chips required to buy the noble. */
	private int redRequired;

	/** the number of green chips required to buy the noble. */
	private int greenRequired;

	/** the number of blue chips required to buy the noble. */
	private int blueRequired;

	/** the number of black chips required to buy the noble. */
	private int blackRequired;

	/** the number of points the noble is worth. */
	private int prestigePoints;

	/** the image file for the noble. */
	private String imageFile;

	/*****************************************************
	 * Constructor for a noble, creates a noble object.
	 * @param pPrestigePoints the number of points
	 * the noble is worth.
	 * @param pWhiteRequired how many white cards you
	 * need to buy this noble.
	 * @param pRedRequired how many red cards you
	 * need to buy this noble.
	 * @param pGreenRequired how many green cards you
	 * need to buy this noble.
	 * @param pBlueRequired how many blue cards you
	 * need to buy this noble.
	 * @param pBlackRequired how many black cards you
	 * need to buy this noble.
	 * @param pImageFile where the image for the noble
	 * is saved
	 *****************************************************/
	public Noble(final int pPrestigePoints,
			final int pWhiteRequired, final int pRedRequired,
			final int pGreenRequired, final int pBlueRequired,
			final int pBlackRequired, final String pImageFile) {
		this.prestigePoints = pPrestigePoints;
		this.whiteRequired = pWhiteRequired;
		this.redRequired = pRedRequired;
		this.greenRequired = pGreenRequired;
		this.blueRequired = pBlueRequired;
		this.blackRequired = pBlackRequired;
		this.imageFile = pImageFile;
	}

	/**
	 * Return the number of white cards required to buy the noble.
	 * @return whiteRequired
	 */
	public int getWhiteRequired() {
		return whiteRequired;
	}

	/**
	 * Return the number of red cards required to buy the noble.
	 * @return redRequired
	 */
	public int getRedRequired() {
		return redRequired;
	}

	/**
	 * Return the number of green cards required to buy the noble.
	 * @return greenRequired
	 */
	public int getGreenRequired() {
		return greenRequired;
	}

	/**
	 * Return the number of blue chips required to buy the noble.
	 * @return blueRequired
	 */
	public int getBlueRequired() {
		return blueRequired;
	}

	/**
	 * Return the number of black chips required to buy the noble.
	 * @return blackRequired
	 */
	public int getBlackRequired() {
		return blackRequired;
	}

	/**
	 * Return the number of point that a player will
	 * receive if they buy this noble.
	 * @return prestigePoints
	 */
	public int getPrestigePoints() {
		return prestigePoints;
	}

	/**
	 * Return the name of the file where the noble image can be found.
	 * @return imageFile
	 */
	public String getImageFile() {
		return imageFile;
	}
}
