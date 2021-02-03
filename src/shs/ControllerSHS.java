package shs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				HashFunction sh;
				String option = viewSHS.getButtonGroup().getSelection().getActionCommand();
				if (option.equals("radioButtonSHA1")) {
					sh = new SHA_1(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				} else if (option.equals("radioButtonSHA224")) {
					sh = new SHA_224(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				} else if (option.equals("radioButtonSHA256")) {
					sh = new SHA_256(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				} else if (option.equals("radioButtonSHA384")) {
					sh = new SHA_384(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				} else if (option.equals("radioButtonSHA512")) {
					sh = new SHA_512(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				} else if (option.equals("radioButtonSHA512_224")) {
					sh = new SHA_512_224(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				} else if (option.equals("radioButtonSHA512_256")) {
					sh = new SHA_512_256(viewSHS.getTextAreaTextToBeHashed().getText());
					viewSHS.getTextFieldHash().setText(sh.computeHash());
				}
			}
		}
	}

}
