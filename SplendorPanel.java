package Splendor;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**********************************************************************
 * This class handles the logic for the GUI class for the game
 * of Splendor.
 *
 * @author David Brown, Wesley Guthrie
 **********************************************************************/
public class SplendorPanel extends JPanel {
	/** final integer for number THREE. */
	private static final int THREE = 3;

	/** final integer for number FOUR. */
	private static final int FOUR = 4;

	/** final integer for number FIVE. */
	private static final int FIVE = 5;

	/** final integer for number SIX. */
	private static final int SIX = 6;

	/** final integer for number TEN. */
	private static final int TEN = 10;

	/** final integer for number TWENTY. */
	private static final int TWENTY = 20;

	/** final integer for number one hundred. */
	private static final int ONEHUNDRED = 100;

	/** final integer for number one hundred fifteen. */
	private static final int ONEFIFTEEN = 115;

	/** final integer for number one hundred forty. */
	private static final int ONEFORTY = 140;

	/** final integer for number one hundred fifty. */
	private static final int ONEFIFTY = 150;

	/** used to call pick up chips method. */
	private JButton pickChips;

	/** displays noble1 card. */
	private JButton noble1;

	/** displays noble2 card. */
	private JButton noble2;

	/** displays noble3 card. */
	private JButton noble3;

	/** used to buy highCard1. */
	private JButton highCard1;

	/** used to buy highCard2. */
	private JButton highCard2;

	/** used to buy highCard3. */
	private JButton highCard3;

	/** used to buy highCard4. */
	private JButton highCard4;

	/** used to buy middleCard1. */
	private JButton middleCard1;

	/** used to buy middleCard2. */
	private JButton middleCard2;

	/** used to buy middleCard3. */
	private JButton middleCard3;

	/** used to buy middleCard4. */
	private JButton middleCard4;

	/** used to buy lowCard1. */
	private JButton lowCard1;

	/** used to buy lowCard2. */
	private JButton lowCard2;

	/** used to buy lowCard3. */
	private JButton lowCard3;

	/** used to buy lowCard4. */
	private JButton lowCard4;

	/** number of red chips. */
	private JButton redChips;

	/** number of blue chips. */
	private JButton blueChips;

	/** number of green chips. */
	private JButton greenChips;

	/** number of black chips. */
	private JButton blackChips;

	/** number of white chips. */
	private JButton whiteChips;

	/** player 1 buy a held card. */
	private JButton player1Held;

	/** player 2 buy a held card. */
	private JButton player2Held;

	/** player 3 buy a held card. */
	private JButton player3Held;

	/** player 4 buy a held card. */
	private JButton player4Held;

	/** the game logic. */
	private SplendorGame game;

	/** the button listener. */
	private ButtonListener listener;

	/** picture of noble1. */
	private ImageIcon inoble1;

	/** picture of noble2. */
	private ImageIcon inoble2;

	/** picture of inoble3. */
	private ImageIcon inoble3;

	/** picture of iHighCard1. */
	private ImageIcon iHighCard1;

	/** picture of iHighCard2. */
	private ImageIcon iHighCard2;

	/** picture of iHighCard3. */
	private ImageIcon iHighCard3;

	/** picture of iHighCard4. */
	private ImageIcon iHighCard4;

	/** picture of iMiddleCard1. */
	private ImageIcon iMiddleCard1;

	/** picture of iMiddleCard2. */
	private ImageIcon iMiddleCard2;

	/** picture of iMiddleCard3. */
	private ImageIcon iMiddleCard3;

	/** picture of iMiddleCard4. */
	private ImageIcon iMiddleCard4;

	/** picture of ilowCard1. */
	private ImageIcon ilowCard1;

	/** picture of iLowCard2. */
	private ImageIcon iLowCard2;

	/** picture of iLowCard3. */
	private ImageIcon iLowCard3;

	/** picture of iLowCard4. */
	private ImageIcon iLowCard4;

	/** picture of noble2. */
	private JTabbedPane players;

	/** player 1s red chips. */
	private JTextField player1Red;

	/** player 1s blue chips. */
	private JTextField player1Blue;

	/** player 1s green chips. */
	private JTextField player1Green;

	/** player 1s black chips. */
	private JTextField player1Black;

	/** player 1s white chips. */
	private JTextField player1White;

	/** player 2s red chips. */
	private JTextField player2Red;

	/** player 2s blue chips. */
	private JTextField player2Blue;

	/** player 2s green chips. */
	private JTextField player2Green;

	/** player 2s black chips. */
	private JTextField player2Black;

	/** player 2s white chips. */
	private JTextField player2White;

	/** player 3s red chips. */
	private JTextField player3Red;

	/** player 3s blue chips. */
	private JTextField player3Blue;

	/** player 3s green chips. */
	private JTextField player3Green;

	/** player 3s black chips. */
	private JTextField player3Black;

	/** player 3s white chips. */
	private JTextField player3White;

	/** player 4s red chips. */
	private JTextField player4Red;

	/** player 4s blue chips. */
	private JTextField player4Blue;

	/** player 4s green chips. */
	private JTextField player4Green;

	/** player 4s black chips. */
	private JTextField player4Black;

	/** player 4s white chips. */
	private JTextField player4White;

	/**  .*/
	private JTextField redField;

	/**  .*/
	private JTextField blueField;

	/**  .*/
	private JTextField greenField;

	/**  .*/
	private JTextField blackField;

	/**  .*/
	private JTextField whiteField;

	/**  .*/
	private JMenuItem quit;

	/**  .*/
	private JMenuItem help;

	private JMenuItem song;

	private boolean playingMusic; 
	
	private Clip clip;

	/**********************************************************************
	 * This class handles the logic for the GUI class for the game
	 * of Splendor.
	 *
	 * @author David Brown, Wesley Guthrie
	 **********************************************************************/
	public SplendorPanel(JMenuItem mQuit, JMenuItem mHelp, JMenuItem agario) {
		// an array with different numbers of possible players
		String[] possiblePlayerAmount = {"2", "3", "4"};

		// get the number of players that are playing
		String sNumberOfPlayers = (String) JOptionPane.showInputDialog(
				null, "How many players are there?",
				"NUMBER OF PLAYERS", JOptionPane.
				QUESTION_MESSAGE, null, possiblePlayerAmount,
				possiblePlayerAmount[0]);
		if (sNumberOfPlayers == null) 
			System.exit(0);
		int iNumberOfPlayers = Integer.parseInt(sNumberOfPlayers);
		// create a new SplendorGame object
		game = new SplendorGame(iNumberOfPlayers);
		// instantiate the button listener
		listener = new ButtonListener();
		// set the layout for actionPanel
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new GridLayout(2, 1));
		JPanel actionButtons = new JPanel();
		actionButtons.setLayout(new GridLayout(1, FIVE));
		JPanel actionPickChips = new JPanel();
		actionPickChips.setLayout(new GridLayout(1, 1));
		chipsAndTextSetup();

		actionButtons.add(redChips);
		actionButtons.add(blueChips);
		actionButtons.add(greenChips);
		actionButtons.add(blackChips);
		actionButtons.add(whiteChips);
		actionPickChips.add(pickChips);
		actionPanel.add(actionButtons);
		actionPanel.add(actionPickChips);
		// set the layout for buttonPanel
		JPanel cardPanel = new JPanel();
		cardPanel = setupButtons();

		// set player tabs on JTabbedPane
		//		JTabbedPane tabbedPane = new JTabbedPane();
		players = new JTabbedPane();

		// player1 panel
		JPanel player1Panel = new JPanel();
		player1Panel.setLayout(new GridLayout(SIX, 1));

		player1TextFields();
		// instantiate player1held button
		player1Held = new JButton("HELD CARD");
		player1Held.addActionListener(listener);

		// add the components to player1panel
		player1Panel.add(player1Red);
		player1Panel.add(player1Blue);
		player1Panel.add(player1Green);
		player1Panel.add(player1Black);
		player1Panel.add(player1White);
		player1Panel.add(player1Held);

		// add player 1 to the JTabbedPane
		players.add("Player 1", player1Panel);

		// player2 panel
		JPanel player2Panel = new JPanel();
		player2Panel.setLayout(new GridLayout(SIX, 1));

		player2TextFields();

		// instantiate player2held button
		player2Held = new JButton("HELD CARD");
		player2Held.addActionListener(listener);

		// add the components to player2panel
		player2Panel.add(player2Red);
		player2Panel.add(player2Blue);
		player2Panel.add(player2Green);
		player2Panel.add(player2Black);
		player2Panel.add(player2White);
		player2Panel.add(player2Held);

		// add player 2 to the JTabbedPane
		players.add("Player 2", player2Panel);
		players.setEnabledAt(0, true);
		players.setEnabledAt(1, false);

		// player3 panel
		if (iNumberOfPlayers > 2) {
			JPanel player3Panel = new JPanel();
			player3Panel.setLayout(new GridLayout(SIX, 1));
			player3TextFields();
			// instantiate player3held button
			player3Held = new JButton("HELD CARD");
			player3Held.addActionListener(listener);
			// add the components to player3panel
			player3Panel.add(player3Red);
			player3Panel.add(player3Blue);
			player3Panel.add(player3Green);
			player3Panel.add(player3Black);
			player3Panel.add(player3White);
			player3Panel.add(player3Held);
			// add player 3 to the JTabbedPane
			players.add("Player 3", player3Panel);
			players.setEnabledAt(2, false);
		}
		// player4 panel
		if (iNumberOfPlayers > THREE) {
			JPanel player4Panel = new JPanel();
			player4Panel.setLayout(new GridLayout(SIX, 1));
			player4TextFields();
			// instantiate player4held button
			player4Held = new JButton("HELD CARD");
			player4Held.addActionListener(listener);
			// add the components to player4panel
			player4Panel.add(player4Red);
			player4Panel.add(player4Blue);
			player4Panel.add(player4Green);
			player4Panel.add(player4Black);
			player4Panel.add(player4White);
			player4Panel.add(player4Held);
			// add player 4 to the JTabbedPane
			players.add("Player 4", player4Panel);
			players.setEnabledAt(THREE, false);
		}
		updateTabPane();
		// set the layout for the JPanel
		this.setLayout(new GridLayout(2, 1));
		// add the components to the JPanel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 1));
		topPanel.add(cardPanel);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 2));
		bottomPanel.add(actionPanel);
		bottomPanel.add(players);

		quit = mQuit;
		help = mHelp;
		song = agario;

		song.addActionListener(listener);
		quit.addActionListener(listener);
		help.addActionListener(listener);
		addKeyListener(listener);
		setFocusable(true);
		add(topPanel);
		add(bottomPanel);
	}

	/**
	 * Returns a jpanel of cards.
	 * @return a jpanel of the cards.
	 */
	private JPanel setupButtons() {
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout(THREE, FIVE));
		// instantiate noble1 noble1 does not require an
		// action listener add noble1 to buttonPanel
		noble1 = new JButton();
		inoble1 = new ImageIcon(game.getNoble1().getImageFile());
		Image temp1 = inoble1.getImage().getScaledInstance(
				ONEFIFTY, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		inoble1 = new ImageIcon(temp1);
		noble1.setIcon(inoble1);
		cardPanel.add(noble1);
		// instantiate highCard1 and add an action listener
		// add highCard1 to buttonPanel
		highCard1 = new JButton();
		iHighCard1 = new ImageIcon(game.getHighCard1().getImageFile());
		temp1 = iHighCard1.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iHighCard1 = new ImageIcon(temp1);
		highCard1.setIcon(iHighCard1);
		highCard1.addActionListener(listener);
		cardPanel.add(highCard1);
		// instantiate highCard2 and add an action listener
		highCard2 = new JButton();
		iHighCard2 = new ImageIcon(game.getHighCard2().getImageFile());
		temp1 = iHighCard2.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iHighCard2 = new ImageIcon(temp1);
		highCard2.setIcon(iHighCard2);
		highCard2.addActionListener(listener);
		cardPanel.add(highCard2);
		// instantiate highCard3 and add an action listener
		highCard3 = new JButton();
		iHighCard3 = new ImageIcon(game.getHighCard3().getImageFile());
		temp1 = iHighCard3.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iHighCard3 = new ImageIcon(temp1);
		highCard3.setIcon(iHighCard3);
		highCard3.addActionListener(listener);
		cardPanel.add(highCard3);
		// instantiate highCard4 and add an action listener
		highCard4 = new JButton();
		iHighCard4 = new ImageIcon(game.getHighCard4().getImageFile());
		temp1 = iHighCard4.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iHighCard4 = new ImageIcon(temp1);
		highCard4.setIcon(iHighCard4);
		highCard4.addActionListener(listener);
		cardPanel.add(highCard4);
		// instantiate noble2 noble1 does not require an action listener
		// add noble2 to buttonPanel
		noble2 = new JButton();
		inoble2 = new ImageIcon(game.getNoble2().getImageFile());
		temp1 = inoble2.getImage().getScaledInstance(
				ONEFIFTY, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		inoble2 = new ImageIcon(temp1);
		noble2.setIcon(inoble2);
		cardPanel.add(noble2);
		// instantiate middleCard1 and add an action listener
		middleCard1 = new JButton(); // add middleCard1 to buttonPanel
		iMiddleCard1 = new ImageIcon(
				game.getMiddleCard1().getImageFile());
		temp1 = iMiddleCard1.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iMiddleCard1 = new ImageIcon(temp1);
		middleCard1.setIcon(iMiddleCard1);
		middleCard1.addActionListener(listener);
		cardPanel.add(middleCard1);
		// instantiate middleCard2 and add an action listener
		// add middleCard2 to buttonPanel
		middleCard2 = new JButton();
		iMiddleCard2 = new ImageIcon(
				game.getMiddleCard2().getImageFile());
		temp1 = iMiddleCard2.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iMiddleCard2 = new ImageIcon(temp1);
		middleCard2.setIcon(iMiddleCard2);
		middleCard2.addActionListener(listener);
		cardPanel.add(middleCard2);
		// instantiate middleCard3 and add an action listener
		// add middleCard3 to buttonPanel
		middleCard3 = new JButton();
		iMiddleCard3 = new ImageIcon(
				game.getMiddleCard3().getImageFile());
		temp1 = iMiddleCard3.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iMiddleCard3 = new ImageIcon(temp1);
		middleCard3.setIcon(iMiddleCard3);
		middleCard3.addActionListener(listener);
		cardPanel.add(middleCard3);
		// instantiate middleCard4 and add an action listener
		// add middleCard4 to buttonPanel
		middleCard4 = new JButton();
		iMiddleCard4 = new ImageIcon(
				game.getMiddleCard4().getImageFile());
		temp1 = iMiddleCard4.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iMiddleCard4 = new ImageIcon(temp1);
		middleCard4.setIcon(iMiddleCard4);
		middleCard4.addActionListener(listener);
		cardPanel.add(middleCard4);
		// instantiate noble3 noble1 does not require an action listener
		// add noble2 to buttonPanel
		noble3 = new JButton();
		inoble3 = new ImageIcon(game.getNoble3().getImageFile());
		temp1 = inoble3.getImage().getScaledInstance(
				ONEFIFTY, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		inoble3 = new ImageIcon(temp1);
		noble3.setIcon(inoble3);
		cardPanel.add(noble3);
		// instantiate lowCard1 and add an action listener
		lowCard1 = new JButton();
		ilowCard1 = new ImageIcon(game.getLowCard1().getImageFile());
		temp1 = ilowCard1.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		ilowCard1 = new ImageIcon(temp1);
		lowCard1.setIcon(ilowCard1);
		lowCard1.addActionListener(listener);
		cardPanel.add(lowCard1);
		// instantiate lowCard2 and add an action listener
		lowCard2 = new JButton();
		iLowCard2 = new ImageIcon(game.getLowCard2().getImageFile());
		temp1 = iLowCard2.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iLowCard2 = new ImageIcon(temp1);
		lowCard2.setIcon(iLowCard2);
		lowCard2.addActionListener(listener);
		cardPanel.add(lowCard2);
		// instantiate lowCard3 and add an action listener
		lowCard3 = new JButton();
		iLowCard3 = new ImageIcon(game.getLowCard3().getImageFile());
		temp1 = iLowCard3.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iLowCard3 = new ImageIcon(temp1);
		lowCard3.setIcon(iLowCard3);
		lowCard3.addActionListener(listener);
		cardPanel.add(lowCard3);
		// instantiate lowCard4 and add an action listener
		lowCard4 = new JButton();
		iLowCard4 = new ImageIcon(game.getLowCard4().getImageFile());
		temp1 = iLowCard4.getImage().getScaledInstance(
				ONEFIFTEEN, ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
		iLowCard4 = new ImageIcon(temp1);
		lowCard4.setIcon(iLowCard4);
		lowCard4.addActionListener(listener);
		cardPanel.add(lowCard4);
		return cardPanel;
	}

	/**
	 * Instantiate player 1's textfields.
	 */
	private void player1TextFields() {
		// set JTextFields and make them not editable
		player1Red = new JTextField();
		player1Red.setEditable(false);
		player1Blue = new JTextField();
		player1Blue.setEditable(false);
		player1Green = new JTextField();
		player1Green.setEditable(false);
		player1Black = new JTextField();
		player1Black.setEditable(false);
		player1White = new JTextField();
		player1White.setEditable(false);
	}

	/**
	 * Instantiate player 2's textfields.
	 */
	private void player2TextFields() {
		// set JTextFields and make them not editable
		player2Red = new JTextField();
		player2Red.setEditable(false);
		player2Blue = new JTextField();
		player2Blue.setEditable(false);
		player2Green = new JTextField();
		player2Green.setEditable(false);
		player2Black = new JTextField();
		player2Black.setEditable(false);
		player2White = new JTextField();
		player2White.setEditable(false);
	}

	/**
	 * Instantiate player 3's textfields.
	 */
	private void player3TextFields() {
		// set JTextFields and make them not editable
		player3Red = new JTextField();
		player3Red.setEditable(false);
		player3Blue = new JTextField();
		player3Blue.setEditable(false);
		player3Green = new JTextField();
		player3Green.setEditable(false);
		player3Black = new JTextField();
		player3Black.setEditable(false);
		player3White = new JTextField();
		player3White.setEditable(false);
	}

	/**
	 * Instantiate player 4's textfields.
	 */
	private void player4TextFields() {
		// set JTextFields and make them not editable
		player4Red = new JTextField();
		player4Red.setEditable(false);
		player4Blue = new JTextField();
		player4Blue.setEditable(false);
		player4Green = new JTextField();
		player4Green.setEditable(false);
		player4Black = new JTextField();
		player4Black.setEditable(false);
		player4White = new JTextField();
		player4White.setEditable(false);
	}

	/**
	 * Sets up the chips buttons and textfields.
	 */
	private void chipsAndTextSetup() {
		// instantiate pickChips and add an action listener
		// add pickChips to the action panel
		pickChips = new JButton("PICK CHIPS");
		pickChips.addActionListener(listener);

		redChips = new JButton(Integer.toString(game.getRedChips()));
		redChips.setFont(new Font("Monospaced", Font.PLAIN, TWENTY));
		redChips.setBackground(Color.RED);
		redChips.setEnabled(false);


		blueChips = new JButton(Integer.toString(game.getBlueChips()));
		blueChips.setFont(new Font("Monospaced", Font.PLAIN, TWENTY));
		blueChips.setBackground(Color.BLUE);
		blueChips.setEnabled(false);


		greenChips = new JButton(Integer.toString(
				game.getGreenChips()));
		greenChips.setFont(new Font("Monospaced", Font.PLAIN, TWENTY));
		greenChips.setBackground(Color.GREEN);
		greenChips.setEnabled(false);


		blackChips = new JButton(Integer.toString(
				game.getBlackChips()));
		blackChips.setFont(new Font("Monospaced", Font.PLAIN, TWENTY));
		blackChips.setBackground(Color.BLACK);
		blackChips.setEnabled(false);

		whiteChips = new JButton(Integer.toString(
				game.getWhiteChips()));
		whiteChips.setFont(new Font("Monospaced", Font.PLAIN, TWENTY));
		whiteChips.setBackground(Color.WHITE);
		whiteChips.setEnabled(false);
	}

	/**********************************************************************
	 * This method updates the Tab Pane.
	 **********************************************************************/
	private void updateTabPane() {
		// update player one's chip and card amounts
		player1Red.setText("Red Chips: " + game.getPlayers()[0]
				.getRedChips() + "\t\t\tRed Cards: "
				+ game.getPlayers()[0].getRedCards()
				+ "\t\t\tPoints: "
				+ game.getPlayers()[0].getPoints());
		player1Blue.setText("Blue Chips: " + game.getPlayers()[0]
				.getBlueChips() + "\t\t\tBlue Cards: "
				+ game.getPlayers()[0].getBlueCards());
		player1Green.setText("Green Chips: " + game.getPlayers()[0]
				.getGreenChips() + "\t\tGreen Cards: "
				+ game.getPlayers()[0].getGreenCards());
		player1Black.setText("Black Chips: " + game.getPlayers()[0]
				.getBlackChips() + "\t\t\tBlack Cards: "
				+ game.getPlayers()[0].getBlackCards());
		player1White.setText("White Chips: " + game.getPlayers()[0]
				.getWhiteChips() + "\t\tWhite Cards: "
				+ game.getPlayers()[0].getWhiteCards());

		// update player two's chip and card amounts
		player2Red.setText("Red Chips: " + game.getPlayers()[1]
				.getRedChips() + "\t\t\tRed Cards: "
				+ game.getPlayers()[1].getRedCards()
				+ "\t\t\tPoints: "
				+ game.getPlayers()[1].getPoints());
		player2Blue.setText("Blue Chips: " + game.getPlayers()[1]
				.getBlueChips() + "\t\t\tBlue Cards: "
				+ game.getPlayers()[1].getBlueCards());
		player2Green.setText("Green Chips: " + game.getPlayers()[1]
				.getGreenChips() + "\t\tGreen Cards: "
				+ game.getPlayers()[1].getGreenCards());
		player2Black.setText("Black Chips: " + game.getPlayers()[1]
				.getBlackChips() + "\t\t\tBlack Cards: "
				+ game.getPlayers()[1].getBlackCards());
		player2White.setText("White Chips: " + game.getPlayers()[1]
				.getWhiteChips() + "\t\tWhite Cards: "
				+ game.getPlayers()[1].getWhiteCards());

		// if there is a third player update their chip and card amounts
		if (game.getPlayers().length > 2) {
			player3Red.setText("Red Chips: " + game.getPlayers()[2]
					.getRedChips() + "\t\t\tRed Cards: "
					+ game.getPlayers()[2].getRedCards()
					+ "\t\t\tPoints: "
					+ game.getPlayers()[2].getPoints());

			player3Blue.setText("Blue Chips: " + game.getPlayers()
			[2].getBlueChips() + "\t\t\tBlue Cards: "
			+ game.getPlayers()[2].getBlueCards());

			player3Green.setText("Green Chips: " + game.getPlayers()
			[2].getGreenChips() + "\t\tGreen Cards: "
			+ game.getPlayers()[2].getGreenCards());

			player3Black.setText("Black Chips: " + game.getPlayers()
			[2].getBlackChips() + "\t\t\tBlack Cards: "
			+ game.getPlayers()[2].getBlackCards());

			player3White.setText("White Chips: " + game.getPlayers()
			[2].getWhiteChips() + "\t\tWhite Cards: "
			+ game.getPlayers()[2].getWhiteCards());
		}

		// if there is a player FOUR update their chip and card amounts
		if (game.getPlayers().length > THREE) {

			player4Red.setText("Red Chips: " + game.getPlayers()
			[THREE].getRedChips() + "\t\t\tRed Cards: "
			+ game.getPlayers()[THREE].getRedCards()
			+ "\t\t\tPoints: "
			+ game.getPlayers()[THREE].getPoints());

			player4Blue.setText("Blue Chips: " + game.getPlayers()
			[THREE].getBlueChips() + "\t\t\tBlue Cards: "
			+ game.getPlayers()[THREE]
					.getBlueCards());

			player4Green.setText("Green Chips: " + game.getPlayers()
			[THREE].getGreenChips() + "\t\tGreen Cards: "
			+ game.getPlayers()[THREE]
					.getGreenCards());

			player4Black.setText("Black Chips: " + game.getPlayers()
			[THREE].getBlackChips() + "\t\t\tBlack Cards: "
			+ game.getPlayers()[THREE]
					.getBlackCards());

			player4White.setText("White Chips: " + game.getPlayers()
			[THREE].getWhiteChips() + "\t\tWhite Cards: "
			+ game.getPlayers()[THREE]
					.getWhiteCards());
		}

	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean highCard1Button() {
		boolean turn = false;
		// ask the player what they want to do with the card
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"High Card 1", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getHighCard1())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setHighCard1(game.takeCard(
						SplendorGame.HIGH_DECK));

				iHighCard1 = new ImageIcon(game.getHighCard1()
						.getImageFile());
				Image temp1 = iHighCard1.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt
								.Image.SCALE_SMOOTH);
				iHighCard1 = new ImageIcon(temp1);
				highCard1.setIcon(iHighCard1);
				turn = true;
			} else { // if the player cannot buy the card
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}
		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getHighCard1())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setHighCard1(game.takeCard(
						SplendorGame.HIGH_DECK));
				iHighCard1 = new ImageIcon(game
						.getHighCard1().getImageFile());
				Image temp1 = iHighCard1.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iHighCard1 = new ImageIcon(temp1);
				highCard1.setIcon(iHighCard1);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean highCard2Button() {
		boolean turn = false;
		// ask the player what they want to do with the card
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"High Card 2", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getHighCard2())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setHighCard2(game.takeCard(
						SplendorGame.HIGH_DECK));

				iHighCard2 = new ImageIcon(game.getHighCard2()
						.getImageFile());
				Image temp1 = iHighCard2.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFIFTY, java.awt.Image.SCALE_SMOOTH);
				iHighCard2 = new ImageIcon(temp1);
				highCard2.setIcon(iHighCard2);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getHighCard2())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setHighCard2(game.takeCard(
						SplendorGame.HIGH_DECK));
				iHighCard2 = new ImageIcon(game
						.getHighCard2().getImageFile());
				Image temp1 = iHighCard2.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iHighCard2 = new ImageIcon(temp1);
				highCard2.setIcon(iHighCard2);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean highCard3Button() {
		boolean turn = false;
		// ask the player what they want to do with the card
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"High Card 3", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getHighCard3())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setHighCard3(game.takeCard(
						SplendorGame.HIGH_DECK));

				iHighCard3 = new ImageIcon(game
						.getHighCard3().getImageFile());
				Image temp1 = iHighCard3.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iHighCard3 = new ImageIcon(temp1);
				highCard3.setIcon(iHighCard3);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getHighCard3())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setHighCard3(game.takeCard(
						SplendorGame.HIGH_DECK));
				iHighCard3 = new ImageIcon(game
						.getHighCard3().getImageFile());
				Image temp1 = iHighCard3.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iHighCard3 = new ImageIcon(temp1);
				highCard3.setIcon(iHighCard3);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean highCard4Button() {
		boolean turn = false;
		// ask the player what they want to do with the card
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"High Card 4", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getHighCard4())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setHighCard4(game.takeCard(
						SplendorGame.HIGH_DECK));

				iHighCard4 = new ImageIcon(game
						.getHighCard4().getImageFile());
				Image temp1 = iHighCard4.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iHighCard4 = new ImageIcon(temp1);
				highCard4.setIcon(iHighCard4);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getHighCard4())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setHighCard4(game.takeCard(
						SplendorGame.HIGH_DECK));
				iHighCard4 = new ImageIcon(game
						.getHighCard4().getImageFile());
				Image temp1 = iHighCard4.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iHighCard4 = new ImageIcon(temp1);
				highCard4.setIcon(iHighCard4);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean middleCard1Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Middle Card 1", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getMiddleCard1())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setMiddleCard1(game.takeCard(
						SplendorGame.MIDDLE_DECK));

				iMiddleCard1 = new ImageIcon(
						game.getMiddleCard1().getImageFile());
				Image temp1 = iMiddleCard1.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard1 = new ImageIcon(temp1);
				middleCard1.setIcon(iMiddleCard1);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getMiddleCard1())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setMiddleCard1(game.takeCard(
						SplendorGame.MIDDLE_DECK));
				iMiddleCard1 = new ImageIcon(
						game.getMiddleCard1().getImageFile());
				Image temp1 = iMiddleCard1.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard1 = new ImageIcon(temp1);
				middleCard1.setIcon(iMiddleCard1);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean middleCard2Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Middle Card 2", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getMiddleCard2())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setMiddleCard2(game.takeCard(
						SplendorGame.MIDDLE_DECK));

				iMiddleCard2 = new ImageIcon(
						game.getMiddleCard2().getImageFile());
				Image temp1 = iMiddleCard2.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard2 = new ImageIcon(temp1);
				middleCard2.setIcon(iMiddleCard2);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getMiddleCard2())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setMiddleCard2(game.takeCard(
						SplendorGame.MIDDLE_DECK));
				iMiddleCard2 = new ImageIcon(
						game.getMiddleCard2().getImageFile());
				Image temp1 = iMiddleCard2.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard2 = new ImageIcon(temp1);
				middleCard2.setIcon(iMiddleCard2);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean middleCard3Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Middle Card 3", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getMiddleCard3())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setMiddleCard3(game.takeCard(
						SplendorGame.MIDDLE_DECK));

				iMiddleCard3 = new ImageIcon(
						game.getMiddleCard3().getImageFile());
				Image temp1 = iMiddleCard3.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard3 = new ImageIcon(temp1);
				middleCard3.setIcon(iMiddleCard3);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getMiddleCard3())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setMiddleCard3(game.takeCard(
						SplendorGame.MIDDLE_DECK));
				iMiddleCard3 = new ImageIcon(
						game.getMiddleCard3().getImageFile());
				Image temp1 = iMiddleCard3.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard3 = new ImageIcon(temp1);
				middleCard3.setIcon(iMiddleCard3);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean middleCard4Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Middle Card 4", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getMiddleCard4())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setMiddleCard4(game.takeCard(
						SplendorGame.MIDDLE_DECK));

				iMiddleCard4 = new ImageIcon(
						game.getMiddleCard4().getImageFile());
				Image temp1 = iMiddleCard4.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard4 = new ImageIcon(temp1);
				middleCard4.setIcon(iMiddleCard4);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
			return turn;
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getMiddleCard4())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setMiddleCard4(game.takeCard(
						SplendorGame.MIDDLE_DECK));

				iMiddleCard4 = new ImageIcon(
						game.getMiddleCard4().getImageFile());
				Image temp1 = iMiddleCard4.getImage()
						.getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.SCALE_SMOOTH);
				iMiddleCard4 = new ImageIcon(temp1);
				middleCard4.setIcon(iMiddleCard4);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean lowCard1Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Low Card 1", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getLowCard1())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setLowCard1(game.takeCard(
						SplendorGame.LOW_DECK));

				ilowCard1 = new ImageIcon(
						game.getLowCard1().
						getImageFile());
				Image temp1 = ilowCard1.getImage().
						getScaledInstance(ONEHUNDRED,
								ONEFORTY, java.awt.Image.
								SCALE_SMOOTH);
				ilowCard1 = new ImageIcon(temp1);
				lowCard1.setIcon(ilowCard1);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getLowCard1())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setLowCard1(game.takeCard(
						SplendorGame.LOW_DECK));
				ilowCard1 = new ImageIcon(game.
						getLowCard1().getImageFile());
				Image temp1 = ilowCard1.getImage().
						getScaledInstance(ONEHUNDRED,
								ONEFORTY,
								java.awt.Image.
								SCALE_SMOOTH);
				ilowCard1 = new ImageIcon(temp1);
				lowCard1.setIcon(ilowCard1);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean lowCard2Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Low Card 2", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getLowCard2())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setLowCard2(game.takeCard(
						SplendorGame.LOW_DECK));

				iLowCard2 = new ImageIcon(game.
						getLowCard2().getImageFile());
				Image temp1 = iLowCard2.getImage().
						getScaledInstance(ONEHUNDRED,
								ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iLowCard2 = new ImageIcon(temp1);
				lowCard2.setIcon(iLowCard2);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getLowCard2())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setLowCard2(game.takeCard(
						SplendorGame.LOW_DECK));
				iLowCard2 = new ImageIcon(
						game.getLowCard2().
						getImageFile());
				Image temp1 = iLowCard2.
						getImage().getScaledInstance(
								ONEHUNDRED,
								ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iLowCard2 = new ImageIcon(temp1);
				lowCard2.setIcon(iLowCard2);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean lowCard3Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Low Card 3", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getLowCard3())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setLowCard3(game.takeCard(
						SplendorGame.LOW_DECK));

				iLowCard3 = new ImageIcon(
						game.getLowCard3().
						getImageFile());
				Image temp1 = iLowCard3.
						getImage().getScaledInstance(
								ONEHUNDRED, ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iLowCard3 = new ImageIcon(temp1);
				lowCard3.setIcon(iLowCard3);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getLowCard3())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setLowCard3(
						game.takeCard(SplendorGame.LOW_DECK));
				iLowCard3 = new ImageIcon(
						game.getLowCard3().getImageFile());
				Image temp1 = iLowCard3.
						getImage().getScaledInstance(
								ONEHUNDRED,
								ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iLowCard3 = new ImageIcon(temp1);
				lowCard3.setIcon(iLowCard3);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player did action.
	 * @return whether or not player did an action.
	 */
	private boolean lowCard4Button() {
		boolean turn = false;
		String[] cardOptions = {"BUY CARD", "HOLD CARD", "CANCEL" };
		String answer = (String) JOptionPane.showInputDialog(null,
				"What would you like to do with the card?",
				"Low Card 4", JOptionPane.QUESTION_MESSAGE,
				null, cardOptions, cardOptions[0]);

		// if the player wants to buy the card
		if (answer == "BUY CARD") {
			// if the player can buy the card
			if (game.buyResourceCard(game.getLowCard4())) {
				playMusic(1);
				JOptionPane.showMessageDialog(null,
						"You bought the card!");

				game.setLowCard4(
						game.takeCard(SplendorGame.LOW_DECK));

				iLowCard4 = new ImageIcon(
						game.getLowCard4().getImageFile());
				Image temp1 = iLowCard4.
						getImage().getScaledInstance(
								ONEHUNDRED, ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iLowCard4 = new ImageIcon(temp1);
				lowCard4.setIcon(iLowCard4);
				turn = true;
				// if the player cannot buy the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You cannot buy that card");
			}
		}

		// if the player wants to hold the card
		if (answer == "HOLD CARD") {
			// if the player is not already holding a card
			if (game.holdCard(game.getLowCard4())) {
				JOptionPane.showMessageDialog(null,
						"You are now holding the card!");
				game.setLowCard4(
						game.takeCard(SplendorGame.LOW_DECK));
				iLowCard4 = new ImageIcon(
						game.getLowCard4().getImageFile());
				Image temp1 = iLowCard4.getImage().
						getScaledInstance(ONEHUNDRED,
								ONEFORTY,
								java.awt.Image.SCALE_SMOOTH);
				iLowCard4 = new ImageIcon(temp1);
				lowCard4.setIcon(iLowCard4);
				turn = true;
				// if the player cannot hold the card
			} else {
				JOptionPane.showMessageDialog(null,
						"You can only hold one card"
								+ "at time!\nYou are already holding a card!");
			}
		}
		return turn;
	}

	/**
	 * Return true if player bought the card.
	 * @return whether or not player bought the card.
	 */
	private boolean hold1() {
		boolean turn = false;
		if (game.getPlayers()[0].getHoldCard() == null) {
			JOptionPane.showMessageDialog(null,
					"You are not holding a card");
		} else {
			int checkBuy = JOptionPane.showConfirmDialog(null,
					"Would you like to buy your held card?");
			if (checkBuy == JOptionPane.YES_OPTION) {
				if (game.buyResourceCard(game.
						getPlayers()[0].getHoldCard())) {
					JOptionPane.showMessageDialog(null,
							"You bought the card!");
					turn = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"You cannot buy that card");
				}
			}
		}
		return turn;
	}

	/**
	 * Return true if player bought the card.
	 * @return whether or not player bought the card.
	 */
	private boolean hold2() {
		boolean turn = false;
		if (game.getPlayers()[1].getHoldCard() == null) {
			JOptionPane.showMessageDialog(null,
					"You are not holding a card");
		} else {
			int checkBuy = JOptionPane.showConfirmDialog(null,
					"Would you like to buy your held card?");
			if (checkBuy == JOptionPane.YES_OPTION) {
				if (game.buyResourceCard(game.
						getPlayers()[1].getHoldCard())) {
					JOptionPane.showMessageDialog(null,
							"You bought the card!");
					turn = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"You cannot buy that card");
				}
			}
		}
		return turn;
	}

	/**
	 * Return true if player bought the card.
	 * @return whether or not player bought the card.
	 */
	private boolean hold3() {
		boolean turn = false;
		if (game.getPlayers()[2].getHoldCard() == null) {
			JOptionPane.showMessageDialog(null,
					"You are not holding a card");
		} else {
			int checkBuy = JOptionPane.showConfirmDialog(null,
					"Would you like to buy your held card?");
			if (checkBuy == JOptionPane.YES_OPTION) {
				if (game.buyResourceCard(game.
						getPlayers()[2].getHoldCard())) {
					JOptionPane.showMessageDialog(null,
							"You bought the card!");
					turn = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"You cannot buy that card");
				}
			}
		}
		return turn;
	}

	/**
	 * Return true if player bought the card.
	 * @return whether or not player bought the card.
	 */
	private boolean hold4() {
		boolean turn = false;
		if (game.getPlayers()[THREE].getHoldCard() == null) {
			JOptionPane.showMessageDialog(null,
					"You are not holding a card");
		} else {
			int checkBuy = JOptionPane.
					showConfirmDialog(null,
							"Would you like to buy your held card?");
			if (checkBuy == JOptionPane.YES_OPTION) {
				if (game.buyResourceCard(game.
						getPlayers()[THREE].getHoldCard())) {
					JOptionPane.showMessageDialog(null,
							"You bought the card!");
					turn = true;
				} else {
					JOptionPane.showMessageDialog(null,
							"You cannot buy that card");
				}
			}
		}
		return turn;
	}

	/**
	 * Returns whether or not chips were picked up.
	 * @return if chips were picked up.
	 */
	private boolean pickChipsHelp() {
		boolean turn = false;
		int pickRed = 0;
		int pickBlue = 0;
		int pickGreen = 0;
		int pickBlack = 0;
		int pickWhite = 0;

		redField = new JTextField("0", FIVE);
		blueField = new JTextField("0", FIVE);
		greenField = new JTextField("0", FIVE);
		blackField = new JTextField("0", FIVE);
		whiteField = new JTextField("0", FIVE);

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
				"What Chips Do You Want?",
				JOptionPane.OK_CANCEL_OPTION);
		// convert the text to integers
		// catch the error if the player
		// entered non integer text
		try {
			pickRed = Integer.parseInt(redField.getText());
			pickBlue = Integer.parseInt(blueField.getText());
			pickGreen = Integer.parseInt(greenField.getText());
			pickBlack = Integer.parseInt(blackField.getText());
			pickWhite = Integer.parseInt(whiteField.getText());

			// call the pick up chips method
			turn = game.pickUpChips(pickRed,
					pickBlue, pickGreen,
					pickBlack, pickWhite);
		} catch (NumberFormatException exception) {
			// tell the user they must enter valid numbers
			JOptionPane.showMessageDialog(null,
					"You must enter valid numbers!");
			turn = false;
		}
		return turn;
	}

	/**
	 * Plays a song as background music for the game.
	 * @param choice which music to play.
	 */
	private void playMusic(int choice) {
		if (choice == 1) {
			try {
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("buy.wav").getAbsoluteFile());
				Clip mus = AudioSystem.getClip();
				mus.open(audioStream);
				mus.start();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Music file not found", "ERROR: Invalid file", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Disables all JButtons.
	 */
	private void endGame() {
		pickChips.setEnabled(false);
		noble1.setEnabled(false);
		noble2.setEnabled(false);
		noble3.setEnabled(false);
		lowCard1.setEnabled(false);
		lowCard2.setEnabled(false);
		lowCard3.setEnabled(false);
		lowCard4.setEnabled(false);
		middleCard1.setEnabled(false);
		middleCard2.setEnabled(false);
		middleCard3.setEnabled(false);
		middleCard4.setEnabled(false);
		highCard1.setEnabled(false);
		highCard2.setEnabled(false);
		highCard3.setEnabled(false);
		highCard4.setEnabled(false);
		redChips.setEnabled(false);
		blueChips.setEnabled(false);
		greenChips.setEnabled(false);
		blackChips.setEnabled(false);
		whiteChips.setEnabled(false);
	}

	/**
	 * Sets the JTabbedPane to the correct pane
	 * when there are two players.
	 */
	private void twoPlayers() {
		if (game.getCurrentPlayer().equals(
				game.getPlayers()[0])) {
			game.setCurrentPlayer(game.getPlayers()[1]);
			players.setSelectedIndex(1);
			players.setEnabledAt(0, false);
			players.setEnabledAt(1, true);
		} else if (game.getCurrentPlayer().equals(
				game.getPlayers()[1])) {
			game.setCurrentPlayer(game.getPlayers()[0]);
			players.setSelectedIndex(0);
			players.setEnabledAt(0, true);
			players.setEnabledAt(1, false);
		}
	}

	/**
	 * Sets the JTabbedPane to the correct pane
	 * when there are THREE players.
	 */
	private void threePlayers() {
		if (game.getCurrentPlayer().equals(game.getPlayers()[0])) {
			game.setCurrentPlayer(game.getPlayers()[1]);
			players.setSelectedIndex(1);
			players.setEnabledAt(0, false);
			players.setEnabledAt(1, true);
			players.setEnabledAt(2, false);
		} else if (game.getCurrentPlayer().equals(
				game.getPlayers()[1])) {
			game.setCurrentPlayer(game.getPlayers()[2]);
			players.setSelectedIndex(2);
			players.setEnabledAt(0, false);
			players.setEnabledAt(1, false);
			players.setEnabledAt(2, true);
		} else if (game.getCurrentPlayer().equals(
				game.getPlayers()[2])) {
			game.setCurrentPlayer(game.getPlayers()[0]);
			players.setSelectedIndex(0);
			players.setEnabledAt(0, true);
			players.setEnabledAt(1, false);
			players.setEnabledAt(2, false);
		}
	}

	/**
	 * Sets the JTabbedPane to the correct pane
	 * when there are FOUR players.
	 */
	private void fourPlayers() {
		if (game.getCurrentPlayer() == game.getPlayers()[0]) {
			game.setCurrentPlayer(game.getPlayers()[1]);
			players.setSelectedIndex(1);
			players.setEnabledAt(0, false);
			players.setEnabledAt(1, true);
			players.setEnabledAt(2, false);
			players.setEnabledAt(THREE, false);
		} else if (game.getCurrentPlayer().
				equals(game.getPlayers()[1])) {
			game.setCurrentPlayer(game.getPlayers()[2]);
			players.setSelectedIndex(2);
			players.setEnabledAt(0, false);
			players.setEnabledAt(1, false);
			players.setEnabledAt(2, true);
			players.setEnabledAt(THREE, false);
		} else if (game.getCurrentPlayer().
				equals(game.getPlayers()[2])) {
			game.setCurrentPlayer(game.getPlayers()[THREE]);
			players.setSelectedIndex(THREE);
			players.setEnabledAt(0, false);
			players.setEnabledAt(1, false);
			players.setEnabledAt(2, false);
			players.setEnabledAt(THREE, true);
		} else if (game.getCurrentPlayer().
				equals(game.getPlayers()[THREE])) {
			game.setCurrentPlayer(game.getPlayers()[0]);
			players.setSelectedIndex(0);
			players.setEnabledAt(0, true);
			players.setEnabledAt(1, false);
			players.setEnabledAt(2, false);
			players.setEnabledAt(THREE, false);
		}
	}

	/**
	 * Test the JPanel class.
	 */
	public void runTests() {
		fourPlayers();
		fourPlayers();
		fourPlayers();
		fourPlayers();
		threePlayers();
		threePlayers();
		threePlayers();
		twoPlayers();
		twoPlayers();
		hold1();
		hold2();
		hold3();
		hold4();
		lowCard1Button();
		lowCard2Button();
		lowCard3Button();
		lowCard4Button();
		middleCard1Button();
		middleCard2Button();
		middleCard3Button();
		middleCard4Button();
		highCard1Button();
		highCard2Button();
		highCard3Button();
		highCard4Button();
		pickChipsHelp();
		updateTabPane();
		endGame();
	}

	/**********************************************************************
	 * ActionListener Class.
	 **********************************************************************/
	private class ButtonListener implements ActionListener, KeyListener {
		/** whether or not turn is completed. */
		private boolean turnTaken = false;
		@Override
		public void actionPerformed(final ActionEvent e) {
			// if highCard1 is clicked
			if (e.getSource() == highCard1) {
				turnTaken = highCard1Button();
			}
			// if highCard2 is clicked
			if (e.getSource() == highCard2) {
				turnTaken = highCard2Button();
			}
			// if highCard3 is clicked
			if (e.getSource() == highCard3) {
				turnTaken = highCard3Button();
			}
			// if highCard4 is clicked
			if (e.getSource() == highCard4) {
				turnTaken = highCard4Button();
			}
			// if middleCard1 is clicked
			if (e.getSource() == middleCard1) {
				turnTaken = middleCard1Button();
			}
			// if middleCard2 is clicked
			if (e.getSource() == middleCard2) {
				turnTaken = middleCard2Button();
			}
			// if middleCard3 is clicked
			if (e.getSource() == middleCard3) {
				turnTaken = middleCard3Button();
			}
			// if middleCard4 is clicked
			if (e.getSource() == middleCard4) {
				turnTaken = middleCard4Button();
			}
			// if lowCard1 is clicked
			if (e.getSource() == lowCard1) {
				turnTaken = lowCard1Button();
			}
			// if lowCard2 is clicked
			if (e.getSource() == lowCard2) {
				turnTaken = lowCard2Button();
			}
			// if lowCard3 is clicked
			if (e.getSource() == lowCard3) {
				turnTaken = lowCard3Button();
			}
			// if lowCard4 is clicked
			if (e.getSource() == lowCard4) {
				turnTaken = lowCard4Button();
			}
			// if the player chooses to pick up chips
			if (e.getSource() == pickChips) {
				turnTaken = pickChipsHelp();
			}
			if (e.getSource() == player1Held) {
				turnTaken = hold1();
			}
			if (e.getSource() == player2Held) {
				turnTaken = hold2();
			}
			if (e.getSource() == player3Held) {
				turnTaken = hold3();
			}
			if (e.getSource() == player4Held) {
				turnTaken = hold4();
			}

			if (e.getSource() == quit) {
				System.exit(0);
			}

			if (e.getSource() == help) {
				try {
					JFrame frame = new JFrame("Help");
					JPanel panel = new JPanel();
					JTextPane area = new JTextPane();
					area.setPreferredSize(new Dimension(500, 600));
					JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					//scroll.setEditable(false);
					panel.add(scroll);
					frame.add(panel);
					Scanner scan = new Scanner(new File("help.txt"));
					String content = "";
					while (scan.hasNextLine()) {
						content += scan.nextLine();
						content += "\n";
					}
					area.setText(content);
					scan.close();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Could not find help file", "ERROR: File not found", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			if (e.getSource() == song) {
				if (!playingMusic) {
					try {
						AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("music.wav").getAbsoluteFile());
						clip = AudioSystem.getClip();
						clip.open(audioStream);
						clip.start();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Music file not found", "ERROR: Invalid file", JOptionPane.ERROR_MESSAGE);
					}
					playingMusic = true;
				} else {
					clip.stop();
					clip.close();
					playingMusic = false;
				}
			}

			// check to see if the current player can buy a noble
			if (game.buyNoble()) {
				Noble first = game.getNoble1();
				Noble second = game.getNoble2();
				Noble third = game.getNoble3();
				if (first == null) {
					noble1.setEnabled(false);
				}
				if (second == null) {
					noble2.setEnabled(false);
				}
				if (third == null) {
					noble3.setEnabled(false);
				}
			}
			updateTabPane();
			game.checkWinGame();
			if (game.getStatus() == GameStatus.WON) {
				endGame();
			}
			// update the bank chip amounts
			redChips.setText(Integer.toString(game.getRedChips()));
			blueChips.setText(Integer.toString(
					game.getBlueChips()));
			greenChips.setText(Integer.toString(
					game.getGreenChips()));
			blackChips.setText(Integer.toString(
					game.getBlackChips()));
			whiteChips.setText(Integer.toString(
					game.getWhiteChips()));
			if (turnTaken) {
				if (game.getNumPlayers() == 2) {
					twoPlayers();
				}
				if (game.getNumPlayers() == THREE) {
					threePlayers();
				}
				if (game.getNumPlayers() == FOUR) {
					fourPlayers();
				}
			}
		}
		@Override
		public void keyTyped(final KeyEvent e) {
			int code = e.getKeyChar();
			if (code == KeyEvent.VK_H) {
				try {
					JFrame frame = new JFrame("Help");
					JPanel panel = new JPanel();
					JTextPane area = new JTextPane();
					area.setEditable(false);
					panel.add(area);
					frame.add(panel);
					Scanner scan = new Scanner(new File("help.txt"));
					String content = "";
					while (scan.hasNextLine()) {
						content += scan.nextLine();
						content += "\n";
					}
					area.setText(content);
					scan.close();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Could not find help file", "ERROR: File not found", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

			if (code == KeyEvent.VK_Q) {
				int decision = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.INFORMATION_MESSAGE);
				if (decision == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		}
		@Override
		public void keyPressed(KeyEvent e) { }
		@Override
		public void keyReleased(KeyEvent e) { }
	}
}