import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StartGameFrame {
	JFrame frame;
	JLabel label;
	ImageIcon icon;

	StartGameFrame() {	
		  JLabel label = new JLabel();	//create a label
		  label.setText("Tic - Tac - Toe");	//set text to the label
		  ImageIcon imgage = new ImageIcon("logo.png");
		  label.setIcon(imgage);
		  label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of imageicon
		  label.setVerticalTextPosition(JLabel.BOTTOM);	//set text TOP, CENTER, BOTTOM, of imageicon
		  label.setForeground(Color.green);	//set font color of text
		  label.setFont(new Font("alzebrian", Font.BOLD, 60));  //set font of text
		  label.setIconTextGap(10);	//set gap of text to image
		  label.setBackground(Color.black);	//set background color
		  label.setOpaque(true);  //display background color
		  Border border = BorderFactory.createLineBorder(Color.green, 5, true);
		  label.setBorder(border);
		  label.setVerticalAlignment(JLabel.CENTER);  //set vertical position of image+text within label
		  label.setHorizontalAlignment(JLabel.CENTER);  //set horizontal position of image+text within label
		  
		  JFrame frame = new JFrame(); //creates a frame
		  frame.setTitle("Tic Tac Toe"); //sets title of frame
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
		  //frame.setResizable(false); //prevent frame from being resized
		  frame.setSize(800,800); //sets the x-dimension, and y-dimension of frame
		  frame.setVisible(true); //make frame visible
		  
		  frame.setLayout(new BorderLayout());
		  frame.setLocationRelativeTo(null);
		  frame.add(label);
		  
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  frame.dispose();
		  new TicTacToe();

	}

}
