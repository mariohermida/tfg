package hashing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Mario Hermida
 *
 */
public class ControllerSHS implements ActionListener {

	private ViewSHS viewSHS;

	public ControllerSHS() {
		this.viewSHS = new ViewSHS(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("generateHash")) {
			if (viewSHS.getButtonGroup().getSelection() == null) {
				viewSHS.showNoAlgorithmChosenAlert();
			} else {
				HashFunction sh = null;
				String option = viewSHS.getButtonGroup().getSelection().getActionCommand();
				String truncationValue = viewSHS.getTextFieldBits().getText();
				int endIndex = Integer.MAX_VALUE;
				// Check if truncation is an integer number
				if (!truncationValue.equals("")) {
					try {
						endIndex = Integer.parseInt(truncationValue);
					} catch (NumberFormatException exception) {
						viewSHS.showTruncationMustBeAnIntegerNumber();
						endIndex = Integer.MIN_VALUE;
					}
				}
				if (endIndex != Integer.MIN_VALUE) {
					if (option.equals("radioButtonSHA1")) {
						sh = new SHA_1(viewSHS.getTextAreaTextToBeHashed().getText());
					} else if (option.equals("radioButtonSHA224")) {
						sh = new SHA_224(viewSHS.getTextAreaTextToBeHashed().getText());
					} else if (option.equals("radioButtonSHA256")) {
						sh = new SHA_256(viewSHS.getTextAreaTextToBeHashed().getText());
					} else if (option.equals("radioButtonSHA384")) {
						sh = new SHA_384(viewSHS.getTextAreaTextToBeHashed().getText());
					} else if (option.equals("radioButtonSHA512")) {
						sh = new SHA_512(viewSHS.getTextAreaTextToBeHashed().getText());
					} else if (option.equals("radioButtonSHA512_224")) {
						sh = new SHA_512_224(viewSHS.getTextAreaTextToBeHashed().getText());
					} else if (option.equals("radioButtonSHA512_256")) {
						sh = new SHA_512_256(viewSHS.getTextAreaTextToBeHashed().getText());
					}
					if (endIndex == Integer.MAX_VALUE) {
						viewSHS.getTextFieldHash().setText(sh.computeHash());
					} else {
						if (endIndex % 4 == 0 && endIndex > 0 && endIndex <= sh.messageDigestLength) {
							viewSHS.getTextFieldHash().setText(sh.computeHash().substring(0, endIndex/4));	
						} else {
							viewSHS.showTruncationNotValidNumber(sh.messageDigestLength);
						}
					}
				}
			}
		}
	}

}
