package Splendor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**********************************************************************
 * This class maintains the GUI.
 * @author David Brown, Wesley Guthrie
 **********************************************************************/
public final class SplendorGUI {
	/**
	 * This does nothing and cannot be called outside the class.
	 */
	private SplendorGUI() {
		// do nothing
	}
	/**********************************************************************
	 * This class maintains the GUI.
	 * @param args .
	 **********************************************************************/
	public static void main(final String[] args) {
		JFrame frame = new JFrame("Splendor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/** Menu items */
	    JMenuBar menus;
	    JMenu menu;
	    JMenuItem quitItem;
	    JMenuItem openRules;  
	    
		SplendorPanel panel = new SplendorPanel();
		frame.getContentPane().add(panel);
		frame.setResizable(true);
		frame.pack();
		frame.setSize(1200,1500);
		frame.setVisible(true);
		
		// set up File menu
        menu = new JMenu("Menu");
        quitItem = new JMenuItem("Quit");
        openRules = new JMenuItem("Rules");
        menu.add(openRules);
        menu.add(quitItem);
        menus = new JMenuBar();
        frame.setJMenuBar(menus);
        menus.add(menu);
	}
}
