package shs;

import java.awt.Color;
import javax.swing.*;

@SuppressWarnings("serial")
public class ViewSHS extends JFrame {

	private ControllerSHS controllerSHS;

	public ViewSHS(ControllerSHS controllerSHS) {
		this.controllerSHS = controllerSHS;
		showWindow();
	}

	private void showWindow() {
		// JLabel labelWelcome
		JLabel labelWelcome = new JLabel();
		labelWelcome.setText("Welcome! Choose the algorithm you want to use:");
		labelWelcome.setBounds(100, 0, 350, 50);
		add(labelWelcome);

		// RadioButtons regarding all the algorithms
		// First row algorithms
		JRadioButton radioButtonSHA1 = new JRadioButton("SHA-1");
		radioButtonSHA1.setBounds(50, 50, 60, 50);
		radioButtonSHA1.addActionListener(controllerSHS);
		radioButtonSHA1.setActionCommand("radioButtonSHA1");
		add(radioButtonSHA1);

		JRadioButton radioButtonSHA224 = new JRadioButton("SHA-224");
		radioButtonSHA224.setBounds(150, 50, 80, 50);
		radioButtonSHA224.addActionListener(controllerSHS);
		radioButtonSHA224.setActionCommand("radioButtonSHA224");
		add(radioButtonSHA224);

		JRadioButton radioButtonSHA256 = new JRadioButton("SHA-256");
		radioButtonSHA256.setBounds(250, 50, 80, 50);
		radioButtonSHA256.addActionListener(controllerSHS);
		radioButtonSHA256.setActionCommand("radioButtonSHA256");
		add(radioButtonSHA256);

		JRadioButton radioButtonSHA384 = new JRadioButton("SHA-384");
		radioButtonSHA384.setBounds(350, 50, 80, 50);
		radioButtonSHA384.addActionListener(controllerSHS);
		radioButtonSHA384.setActionCommand("radioButtonSHA384");
		add(radioButtonSHA384);

		// Second row algorithms
		JRadioButton radioButtonSHA512 = new JRadioButton("SHA-512");
		radioButtonSHA512.setBounds(75, 100, 80, 50);
		radioButtonSHA512.addActionListener(controllerSHS);
		radioButtonSHA512.setActionCommand("radioButtonSHA512");
		add(radioButtonSHA512);

		JRadioButton radioButtonSHA512_224 = new JRadioButton("SHA-512/224");
		radioButtonSHA512_224.setBounds(200, 100, 100, 50);
		radioButtonSHA512_224.addActionListener(controllerSHS);
		radioButtonSHA512_224.setActionCommand("radioButtonSHA512_224");
		add(radioButtonSHA512_224);

		JRadioButton radioButtonSHA512_256 = new JRadioButton("SHA-512/256");
		radioButtonSHA512_256.setBounds(325, 100, 100, 50);
		radioButtonSHA512_256.addActionListener(controllerSHS);
		radioButtonSHA512_256.setActionCommand("radioButtonSHA512_256");
		add(radioButtonSHA512_256);

		// Include all the radioButtons within the same button group
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonSHA1);
		buttonGroup.add(radioButtonSHA224);
		buttonGroup.add(radioButtonSHA256);
		buttonGroup.add(radioButtonSHA384);
		buttonGroup.add(radioButtonSHA512);
		buttonGroup.add(radioButtonSHA512_224);
		buttonGroup.add(radioButtonSHA512_256);

		// JLabel labelText
		JLabel labelText = new JLabel();
		labelText.setText("Introduce the text you want to hash:");
		labelText.setBounds(130, 135, 350, 50);
		add(labelText);

		// TextField for the text to be hashed
		JTextArea textAreaText = new JTextArea();
		textAreaText.setBounds(40, 175, 400, 100);
		JScrollPane scrollPane = new JScrollPane(textAreaText);
		scrollPane.setBounds(40, 175, 400, 100);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
		//add(textAreaText);

		// JLabel labelHash
		JLabel labelHash = new JLabel();
		labelHash.setText("Resulting hash:");
		labelHash.setBounds(190, 280, 350, 50);
		add(labelHash);

		// TextField for the text to be hashed
		JTextField textFieldHash = new JTextField();
		textFieldHash.setBounds(40, 320, 400, 100);
		add(textFieldHash);

		// JButton buttonGenerateHash
		JButton buttonGenerateHash = new JButton();
		buttonGenerateHash.setText("Generate hash");
		buttonGenerateHash.setBounds(140, 450, 200, 50);
		buttonGenerateHash.setBackground(Color.CYAN);
		buttonGenerateHash.addActionListener(controllerSHS);
		buttonGenerateHash.setActionCommand("generateHash");
		add(buttonGenerateHash);

		// Window properties
		setLayout(null);
		setTitle("Secure Hash Generator");
		setResizable(false);
		setBounds(350, 120, 500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
