package hashing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {

	private File file;

	@FXML
	private TextArea nameField;

	@FXML
	private TextField digestField;

	@FXML
	private TextField outputField;

	@FXML
	private ToggleGroup SHS;

	@FXML
	void generateDigest(ActionEvent event) {
		if (SHS.getSelectedToggle() == null) {
			showAlert("No algorithm chosen!");
		} else {
			HashFunction sh = computeHashDependingOnAlgorithmChosen("");
			if (sh != null) {
				digestField.setText(sh.computeHash());
			}
		}
	}

	private HashFunction computeHashDependingOnAlgorithmChosen(String fileMessage) {
		RadioButton option = (RadioButton) SHS.getSelectedToggle();

		if (option.getText().equals("SHA-1")) {
			if (fileMessage.equals("")) {
				return new SHA_1(nameField.getText());
			} else {
				return new SHA_1(fileMessage, true);
			}
		} else if (option.getText().equals("SHA-224")) {
			if (fileMessage.equals("")) {
				return new SHA_224(nameField.getText());
			} else {
				return new SHA_224(fileMessage, true);
			}
		} else if (option.getText().equals("SHA-256")) {
			if (fileMessage.equals("")) {
				return new SHA_256(nameField.getText());
			} else {
				return new SHA_256(fileMessage, true);
			}
		} else if (option.getText().equals("SHA-384")) {
			if (fileMessage.equals("")) {
				return new SHA_384(nameField.getText());
			} else {
				return new SHA_384(fileMessage, true);
			}
		} else if (option.getText().equals("SHA-512")) {
			if (fileMessage.equals("")) {
				return new SHA_512(nameField.getText());
			} else {
				return new SHA_512(fileMessage, true);
			}
		} else if (option.getText().equals("SHA-512/224")) {
			if (fileMessage.equals("")) {
				return new SHA_512_224(nameField.getText());
			} else {
				return new SHA_512_224(fileMessage, true);
			}
		} else if (option.getText().equals("SHA-512/256")) {
			if (fileMessage.equals("")) {
				return new SHA_512_256(nameField.getText());
			} else {
				return new SHA_512_256(fileMessage, true);
			}
		} else if (option.getText().equals("SHA3-224")) {
			if (fileMessage.equals("")) {
				return new SHA_3_224(nameField.getText());
			} else {
				return new SHA_3_224(fileMessage, true);
			}
		} else if (option.getText().equals("SHA3-256")) {
			if (fileMessage.equals("")) {
				return new SHA_3_256(nameField.getText());
			} else {
				return new SHA_3_256(fileMessage, true);
			}
		} else if (option.getText().equals("SHA3-384")) {
			if (fileMessage.equals("")) {
				return new SHA_3_384(nameField.getText());
			} else {
				return new SHA_3_384(fileMessage, true);
			}
		} else if (option.getText().equals("SHA3-512")) {
			if (fileMessage.equals("")) {
				return new SHA_3_512(nameField.getText());
			} else {
				return new SHA_3_512(fileMessage, true);
			}
		} else {
			if (isOutputLengthAnInteger() && isOutputLengthAValidInteger()) {
				int outputLength = Integer.parseInt(outputField.getText());
				// XOF functions
				if (option.getText().equals("SHAKE128")) {
					if (fileMessage.equals("")) {
						return new SHAKE128(nameField.getText(), outputLength);
					} else {
						return new SHAKE128(fileMessage, outputLength, true);
					}
				} else {
					if (fileMessage.equals("")) {
						return new SHAKE256(nameField.getText(), outputLength);
					} else {
						return new SHAKE256(fileMessage, outputLength, true);
					}
				}
			} else {
				// Output value is not an integer or the output field is empty
				showAlert("Output length must be an integer number, greater than zero and multiple of 4.");
				return null;
			}
		}
	}

	private boolean isOutputLengthAnInteger() {
		try {
			Integer.parseInt(outputField.getText());
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}

	private boolean isOutputLengthAValidInteger() {
		int output = Integer.parseInt(outputField.getText());
		if (output % 4 == 0 && output > 0) {
			return true;
		} else {
			return false;
		}
	}

	@FXML
	void fileChooser(ActionEvent event) {
		if (SHS.getSelectedToggle() == null) {
			showAlert("No algorithm chosen!");
		} else {
			// Open fileChooser
			FileChooser fc = new FileChooser();
			fc.getExtensionFilters().add(new ExtensionFilter("Files", "*.*"));
			file = fc.showOpenDialog(null);

			// Obtain the bytes from the file read
			byte[] bytes;
			try {
				bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
			} catch (IOException e) {
				bytes = null;
				e.printStackTrace();
			}

			// Convert the bytes to binary
			HashFunction sh;
			String binaryCharacter, binaryMessage = "";
			for (byte b : bytes) {
				// First 24 bits are ignored, due to 8 bit string is wanted
				binaryCharacter = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
				binaryMessage += binaryCharacter;
			}

			// Compute and show the hash
			sh = computeHashDependingOnAlgorithmChosen(binaryMessage);
			if (sh != null) {
				digestField.setText(sh.computeHash());
			}
		}
	}

	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR, message);
		alert.showAndWait();
	}

}