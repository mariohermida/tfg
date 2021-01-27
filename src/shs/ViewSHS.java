package shs;

import java.awt.Color;
import javax.swing.*;

@SuppressWarnings("serial")
public class ViewSHS extends JFrame{

	private ControllerSHS controllerSHS;

	public ViewSHS(ControllerSHS controllerSHS) {
		this.controllerSHS = controllerSHS;
		showWindow();
	}

	private void showWindow() {
		// JLabel labelWelcome
		/*JLabel labelWelcome = new JLabel();
		labelWelcome.setText("Welcome! Choose the algorithm you want to use:");
		labelWelcome.setBounds(70, 10, 350, 50);
		this.add(labelWelcome);*/

		// JButton buttonGenerateHash
		JButton buttonGenerateHash = new JButton();
		buttonGenerateHash.setText("Generate hash");
		buttonGenerateHash.setBounds(125, 80, 200, 50);
		buttonGenerateHash.setBackground(Color.YELLOW);
		buttonGenerateHash.addActionListener(controllerSHS);
		buttonGenerateHash.setActionCommand("generateHash");
		this.add(buttonGenerateHash);

		// Window
		this.setTitle("Secure Hash Generator");
		this.setResizable(false);
		this.setBounds(458, 234, 450, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
