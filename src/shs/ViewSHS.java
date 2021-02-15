package shs;

import java.awt.Color;
import javax.swing.*;

/**
 * 
 * @author Mario Hermida
 *
 */
@SuppressWarnings("serial")
public class ViewSHS extends JFrame {

	private ControllerSHS controllerSHS;
	private ButtonGroup buttonGroup;
	private JTextArea textAreaTextToBeHashed;
	private JTextField textFieldHash;
	private JTextField textFieldBits;

	public ViewSHS(ControllerSHS controllerSHS) {
		this.controllerSHS = controllerSHS;
		showWindow();
	}

	private void showWindow() {
		// JLabel labelWelcome
		JLabel labelWelcome = new JLabel();
		labelWelcome.setText("Welcome! Choose the hashing algorithm you want to use:");
		labelWelcome.setBounds(330, 0, 350, 50);
		add(labelWelcome);

		// RadioButtons regarding all the algorithms
		// First row algorithms
		int initialPosition = 130;
		JRadioButton radioButtonSHA1 = new JRadioButton("SHA-1");
		radioButtonSHA1.setBounds(initialPosition, 50, 60, 50);
		radioButtonSHA1.addActionListener(controllerSHS);
		radioButtonSHA1.setActionCommand("radioButtonSHA1");
		add(radioButtonSHA1);

		JRadioButton radioButtonSHA224 = new JRadioButton("SHA-224");
		radioButtonSHA224.setBounds(100 + initialPosition, 50, 80, 50);
		radioButtonSHA224.addActionListener(controllerSHS);
		radioButtonSHA224.setActionCommand("radioButtonSHA224");
		add(radioButtonSHA224);

		JRadioButton radioButtonSHA256 = new JRadioButton("SHA-256");
		radioButtonSHA256.setBounds(200 + initialPosition, 50, 80, 50);
		radioButtonSHA256.addActionListener(controllerSHS);
		radioButtonSHA256.setActionCommand("radioButtonSHA256");
		add(radioButtonSHA256);

		JRadioButton radioButtonSHA384 = new JRadioButton("SHA-384");
		radioButtonSHA384.setBounds(300 + initialPosition, 50, 80, 50);
		radioButtonSHA384.addActionListener(controllerSHS);
		radioButtonSHA384.setActionCommand("radioButtonSHA384");
		add(radioButtonSHA384);

		JRadioButton radioButtonSHA512 = new JRadioButton("SHA-512");
		radioButtonSHA512.setBounds(400 + initialPosition, 50, 80, 50);
		radioButtonSHA512.addActionListener(controllerSHS);
		radioButtonSHA512.setActionCommand("radioButtonSHA512");
		add(radioButtonSHA512);

		JRadioButton radioButtonSHA512_224 = new JRadioButton("SHA-512/224");
		radioButtonSHA512_224.setBounds(500 + initialPosition, 50, 100, 50);
		radioButtonSHA512_224.addActionListener(controllerSHS);
		radioButtonSHA512_224.setActionCommand("radioButtonSHA512_224");
		add(radioButtonSHA512_224);

		JRadioButton radioButtonSHA512_256 = new JRadioButton("SHA-512/256");
		radioButtonSHA512_256.setBounds(625 + initialPosition, 50, 100, 50);
		radioButtonSHA512_256.addActionListener(controllerSHS);
		radioButtonSHA512_256.setActionCommand("radioButtonSHA512_256");
		add(radioButtonSHA512_256);

		// Include all the radioButtons within the same button group
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonSHA1);
		buttonGroup.add(radioButtonSHA224);
		buttonGroup.add(radioButtonSHA256);
		buttonGroup.add(radioButtonSHA384);
		buttonGroup.add(radioButtonSHA512);
		buttonGroup.add(radioButtonSHA512_224);
		buttonGroup.add(radioButtonSHA512_256);

		// JLabel labelTextToBeHashed
		JLabel labelTextToBeHashed = new JLabel();
		labelTextToBeHashed.setText("Introduce the text you want to hash:");
		labelTextToBeHashed.setBounds(365, 135, 350, 50);
		add(labelTextToBeHashed);

		// TextArea for the text to be hashed plus the ScrollPane
		textAreaTextToBeHashed = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textAreaTextToBeHashed);
		scrollPane.setBounds(40, 175, 900, 100);
		add(scrollPane);

		// JLabel labelHash
		JLabel labelHash = new JLabel();
		labelHash.setText("Resulting hash value:");
		labelHash.setBounds(410, 280, 350, 50);
		add(labelHash);

		// TextField for the text to be hashed
		textFieldHash = new JTextField();
		textFieldHash.setBounds(40, 320, 900, 100);
		textFieldHash.setEditable(false);
		textFieldHash.setBackground(Color.WHITE);
		add(textFieldHash);

		// JButton buttonGenerateHash
		JButton buttonGenerateHash = new JButton();
		buttonGenerateHash.setText("Generate hash");
		buttonGenerateHash.setBounds(550, 440, 200, 50);
		buttonGenerateHash.setBackground(Color.CYAN);
		buttonGenerateHash.addActionListener(controllerSHS);
		buttonGenerateHash.setActionCommand("generateHash");
		add(buttonGenerateHash);

		// JLabel labelBits
		JLabel labelBits = new JLabel();
		labelBits.setText("Enter the desired number of bits to truncate the hash (if empty, length by default):");
		labelBits.setBounds(40, 440, 500, 20);
		add(labelBits);

		// JTextField textFieldBits
		textFieldBits = new JTextField();
		textFieldBits.setBounds(170, 470, 200, 20);
		add(textFieldBits);

		// Window properties
		setLayout(null);
		setTitle("Secure Hash Generator");
		setResizable(false);
		setBounds(175, 100, 1000, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void showNoAlgorithmChosenAlert() {
		JOptionPane.showMessageDialog(this, "An algorithm must be selected");
	}
	
	public void showTruncationMustBeAnIntegerNumber() {
		JOptionPane.showMessageDialog(this, "Truncation input value must be an integer value");
	}
	
	public void showTruncationNotValidNumber(int range) {
		JOptionPane.showMessageDialog(this, "Truncation input value must be a positive integer, within the range (4 - " + range + "), and multiple of 4");
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public JTextArea getTextAreaTextToBeHashed() {
		return textAreaTextToBeHashed;
	}

	public JTextField getTextFieldHash() {
		return textFieldHash;
	}

	public JTextField getTextFieldBits() {
		return textFieldBits;
	}

}
