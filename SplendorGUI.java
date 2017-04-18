package splendor;

import javax.swing.JFrame;

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
		
		SplendorPanel panel = new SplendorPanel();
		frame.getContentPane().add(panel);
		frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}
}
