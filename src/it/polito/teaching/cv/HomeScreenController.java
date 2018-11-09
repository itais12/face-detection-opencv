package it.polito.teaching.cv;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;

public class HomeScreenController {
	@FXML
	private Button startRecoButton;

	// Event Listener on Button[#startRecoButton].onMouseClicked
	@FXML
	public void startRecoClick(MouseEvent event) throws IOException {
		FaceDetectionMain.startReco();
	}
}
