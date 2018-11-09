package it.polito.teaching.cv;

import java.io.IOException;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * The main class for a JavaFX application. It creates and handle the main
 * window with its resources (style, graphics, etc.).
 * 
 * This application handles a video stream and try to find any possible human
 * face in a frame. It can use the Haar or the LBP classifier.
 * 
 * @author <a href="mailto:luigi.derussis@polito.it">Luigi De Russis</a>
 * @version 2.0 (2017-03-10)
 * @since 1.0 (2014-01-10)
 * 
 */
public class FaceDetectionMain extends Application {
	static Stage stage;
	static Scene scene;

	@Override
	public void start(Stage primaryStage) {

		try {
			stage = primaryStage;
			// load the FXML resource
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
			BorderPane root = (BorderPane) loader.load();
			// set a whitesmoke background
			root.setStyle("-fx-background-color: whitesmoke;");
			// create and style a scene
			scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// create the stage with the given title and the previously created
			// scene
			stage.setTitle("Face Detection home page");
			stage.setScene(scene);
			// show the GUI
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// load the native OpenCV library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		launch(args);
	}

	public static void startReco() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FaceDetectionMain.class.getResource("FaceDetection.fxml"));
		BorderPane FaceDetection = (BorderPane) loader.load();
		scene = new Scene(FaceDetection, 800, 600);
		stage.setTitle("Face Detection and Tracking");
		stage.setScene(scene);
		// show the GUI
		stage.show();
		// init the controller
		FaceDetectionController controller = loader.getController();
		controller.init();

		// set the proper behavior on closing the application
		stage.setOnCloseRequest((new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				controller.setClosed();
			}
		}));
	}
	
}
