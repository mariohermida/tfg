package shs;

import java.awt.BorderLayout;
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
		JLabel labelWelcome = new JLabel();
		labelWelcome.setText("Welcome! Choose the algorithm you want to use:");
		labelWelcome.setBounds(70, 10, 350, 50);
		this.add(labelWelcome);

		// JButton buttonGenerateHash
		JButton buttonGenerateHash = new JButton();
		buttonGenerateHash.setText("Generate hash");
		buttonGenerateHash.setBounds(125, 80, 200, 50);
		buttonGenerateHash.setBackground(Color.CYAN);
		buttonGenerateHash.addActionListener(controllerSHS);
		buttonGenerateHash.setActionCommand("generateHash");
		this.add(buttonGenerateHash);
		
		// It allows setting bounds to objects
		this.setLayout(new BorderLayout());

		// Window
		this.setTitle("Secure Hash Generator");
		this.setResizable(false);
		this.setBounds(350, 120, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
