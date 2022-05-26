import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_Turn;

	TicTacToe() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Arial", Font.BOLD, 65));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setVerticalAlignment(JLabel.CENTER);
		textField.setOpaque(true);

		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1_Turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1_Turn = false;
						textField.setText("O - Turn");
						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1_Turn = true;
						textField.setText("X - Turn");
						check();
					}
				}

			}
		}
	}

	public void firstTurn() {
		if (random.nextInt(2) == 0) {
			player1_Turn = true;
			textField.setText("X - Turn");
		} else {
			player1_Turn = false;
			textField.setText("O - Turn");
		}

	}

//	check winning condition or any player currently won or not
	public void check() {

//		check x win conditions
		if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
			xWins(0, 1, 2);
		} else if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
			xWins(3, 4, 5);
		} else if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
			xWins(6, 7, 8);
		}

		else if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
			xWins(0, 3, 6);
		} else if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
			xWins(1, 4, 7);
		} else if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
			xWins(2, 5, 8);
		}

		else if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
			xWins(0, 4, 8);
		} else if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
			xWins(2, 4, 6);
		}

//		check y win conditions
		else if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
			oWins(0, 1, 2);
		} else if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
			oWins(3, 4, 5);
		} else if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
			oWins(6, 7, 8);
		}

		else if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
			oWins(0, 3, 6);
		} else if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
			oWins(1, 4, 7);
		} else if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
			oWins(2, 5, 8);
		}

		else if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
			oWins(0, 4, 8);
		} else if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
			oWins(2, 4, 6);
		}

//		draw conditions
		else {
			int i = 0;
			while (buttons[i].getText() != "") {
				if (i == 8) {
					draw();
					break;
				}
				i++;
			}
		}
	}

	private void draw() {
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		if (textField.getText() != "X-Wins" || textField.getText() != "O-Wins") {
			textField.setText("Game Draw");
		}
	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X-Wins");
	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);

		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("O-Wins");
	}
}
