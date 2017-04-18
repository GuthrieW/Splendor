package splendor;

import javax.swing.*;

public class asdf {
   public static void main(String[] args) {
      JTextField redField = new JTextField(5);
      JTextField blueField = new JTextField(5);
      JTextField greenField = new JTextField(5);
      JTextField blackField = new JTextField(5);
      JTextField whiteField = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Red:"));
      myPanel.add(redField);
      myPanel.add(Box.createHorizontalStrut(10)); // a spacer
      myPanel.add(new JLabel("Blue:"));
      myPanel.add(blueField);
      myPanel.add(Box.createHorizontalStrut(10)); // a spacer
      myPanel.add(new JLabel("Green:"));
      myPanel.add(greenField);
      myPanel.add(Box.createHorizontalStrut(10)); // a spacer
      myPanel.add(new JLabel("Black:"));
      myPanel.add(blackField);
      myPanel.add(Box.createHorizontalStrut(10)); // a spacer
      myPanel.add(new JLabel("White:"));
      myPanel.add(whiteField);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         System.out.println("x value: " + redField.getText());
         System.out.println("y value: " + blueField.getText());
         System.out.println("y value: " + greenField.getText());
         System.out.println("y value: " + blackField.getText());
         System.out.println("y value: " + whiteField.getText());
      }
   }
}

//							JOptionPane.showMessageDialog(null, "Too Many Chips Selected: Try Again");

//				int pickRed = 0;
//				int pickBlue = 0;
//				int pickGreen = 0;
//				int pickBlack = 0;
//				int pickWhite = 0;
//
//				try {
//					// convert the text to integers
//					// catch the error if the player entered non integer text
//					pickRed = Integer.parseInt(redField.getText());
//					pickBlue = Integer.parseInt(blueField.getText());
//					pickGreen = Integer.parseInt(greenField.getText());
//					pickBlack = Integer.parseInt(blackField.getText());
//					pickWhite = Integer.parseInt(whiteField.getText());
//
//					// call the pick up chips method
//					//				turnTaken = game.pickUpChips(pickRed, pickBlue, pickGreen, pickBlack, pickWhite);
//				} 
//				catch (NumberFormatException exception){
//					// tell the user they must enter valid numbers
//					JOptionPane.showMessageDialog(null, "Heebeegeebeez!");
//				}