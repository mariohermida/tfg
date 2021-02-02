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
			System.out.println("You pressed generateHash button");
			if (viewSHS.getButtonGroup().getSelection() == null) {
				viewSHS.showAlgorithmAlert();
			} else {
				System.out.println("The algorithm " + viewSHS.getButtonGroup().toString() + " has been selected.");
				// A method has to be implemented for selecting the algorithm you want to work with
			}
		}
	}

}
