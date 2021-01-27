package shs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerSHS implements ActionListener {

	public ControllerSHS() {
		new ViewSHS(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("generateHash")) {
			System.out.println("You pressed generateHash button");
		}
	}

}
