package au.edu.usc.bict_explorer.rules;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private static Degree getUIData() {
		File careers = new File("F:\\workspace\\JavaFX\\src\\au\\edu\\usc\\bict_explorer\\resources\\careers.options");
	    File minors = new File("F:\\workspace\\JavaFX\\src\\au\\edu\\usc\\bict_explorer\\resources\\minors.options");
	    File courses = new File("F:\\workspace\\JavaFX\\src\\au\\edu\\usc\\bict_explorer\\resources\\courses.options");
	    Degree degree = null;
		try {
			degree = new Degree(careers, minors, courses);
			System.out.println("Number of careers is: " + degree.careers().size());
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return degree;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Course Application");
		
		Degree degree = getUIData();
		List<String> courseCodes = new ArrayList<String>();
		List<String> careerNames = new ArrayList<String>();
		for(String courseKey : degree.courses().keySet()) {
			Option course = degree.courses().get(courseKey);
			courseCodes.add(course.getCode());
		}
		
		/*for(String careerKey : degree.courses().keySet()) {
			Option career = degree.careers().get(careerKey);
			careerNames.add(career.getName());
		}*/
		
		Label label1 = new Label("Course Code");
		Label label2 = new Label("Career Name");

	    ComboBox<String> courseCodeComboBox = new ComboBox<String>();
	    courseCodeComboBox.getItems().addAll(courseCodes);
	    
	   /* ComboBox<String> careerNameComboBox = new ComboBox<String>();
	    careerNameComboBox.getItems().addAll(careerNames);
	    careerNameComboBox.setMinHeight(50);*/
	    
	    
	    HBox hBox1 = new HBox();
	    hBox1.getChildren().addAll(courseCodeComboBox,label1);
	    /*root.getChildren().add(courseCodeComboBox);
	    root.getChildren().add(label1);*/
	    
	   /* HBox hBox2 = new HBox();
	    hBox2.getChildren().addAll(careerNameComboBox,label2);*/
	    
	    VBox vBox = new VBox();

	    // Add the details to the VBox

	    vBox.getChildren().addAll(hBox1);

	    // Set the vertical spacing between children to 10px

	    vBox.setSpacing(10);



	    // Set the Style-properties of the VBox

	    vBox.setStyle("-fx-padding: 10;" +

	            "-fx-border-style: solid inside;" +

	            "-fx-border-width: 2;" +

	            "-fx-border-insets: 5;" +

	            "-fx-border-radius: 5;" +

	                "-fx-border-color: blue;");
	    Scene scene = new Scene(vBox, 450, 250);
	    
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}

}
