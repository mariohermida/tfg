package hashing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
	
	private File file;
	private List<String> fileExtensions;

	@FXML
	private TextArea nameField;
	
	@FXML
	private TextField digestField;
	
	@FXML
	private TextField truncationField;

	@FXML
	private ToggleGroup SHS;

	@FXML
	void generateDigest(ActionEvent event) {
		if (SHS.getSelectedToggle() == null) {
			digestField.setText("Error. No algorithm chosen!");
			// Report error: No algorithm chosen
		} else {
			HashFunction sh = null;
			RadioButton option = (RadioButton) SHS.getSelectedToggle();

			String truncationValue = truncationField.getText();
			int endIndex = Integer.MAX_VALUE;
			// Check if truncation is an integer number
			if (!truncationValue.equals("")) {
				try {
					endIndex = Integer.parseInt(truncationValue);
				} catch (NumberFormatException exception) {
					// Report error: Bit truncation must be an integer value
					endIndex = Integer.MIN_VALUE;
				}
			}

			if (option.getText().equals("SHA-1")) {
				sh = new SHA_1(nameField.getText());
			} else if (option.getText().equals("SHA-224")) {
				sh = new SHA_224(nameField.getText());
			} else if (option.getText().equals("SHA-256")) {
				sh = new SHA_256(nameField.getText());
			} else if (option.getText().equals("SHA-384")) {
				sh = new SHA_384(nameField.getText());
			} else if (option.getText().equals("SHA-512")) {
				sh = new SHA_512(nameField.getText());
			} else if (option.getText().equals("SHA-512/224")) {
				sh = new SHA_512_224(nameField.getText());
			} else if (option.getText().equals("SHA-512/256")) {
				sh = new SHA_512_256(nameField.getText());
			} else if (option.getText().equals("SHA3-224")) {
				// Still to be implemented
			} else if (option.getText().equals("SHA3-256")) {
				// Still to be implemented
			} else if (option.getText().equals("SHA3-384")) {
				// Still to be implemented
			} else if (option.getText().equals("SHA3-512")) {
				// Still to be implemented
			}

			if (endIndex == Integer.MAX_VALUE) {
				digestField.setText(sh.computeHash());
			} else {
				if (endIndex % 4 == 0 && endIndex > 0 && endIndex <= sh.messageDigestLength) {
					digestField.setText(sh.computeHash().substring(0, endIndex / 4));
				} else {
					// Report error: Bit truncation must be %4 == 0 and within the range
				}
			}
		}
	}
	
	@FXML
	void fileChooser(ActionEvent event) {
		addFileExtensions();
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Files", fileExtensions));
		file = fc.showOpenDialog(null);
		digestField.setText(file.getAbsolutePath());
		// Label with the absolute path
	}
	
	private void addFileExtensions() {
		fileExtensions = new ArrayList<>();
		fileExtensions.add("*.pdf");
		fileExtensions.add("*.txt");
		fileExtensions.add("*.doc");
		fileExtensions.add("*.docx");
	}

}