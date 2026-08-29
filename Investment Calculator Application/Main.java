package application;
/*Author: Kel Knight and Kendall Ward-Hill
Date: 10/16/2025
Purpose: Dress up game*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;

public class Main extends Application {
	//Set up the labels font, weight, and size
	private static final Font LABEL_FONT = Font.font("Arial", FontWeight.BOLD,11);
	//the start method which contains everything to make the application
	@Override
	public void start(Stage primaryStage) {
		try {
			//setting up the grid and formatting
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(2);
			grid.setVgap(5);
			grid.setPadding(new Insets(15,15,15,15));
			//set up the investment info level via label and editable textfield, center them accordingly
			Label investLabel = new Label("Investment Amount");
			investLabel.setFont(LABEL_FONT);
			investLabel.setAlignment(Pos.CENTER_LEFT);
			grid.add(investLabel, 1,0);
			TextField investInput = new TextField();
			investInput.setAlignment(Pos.CENTER_RIGHT);
			grid.add(investInput, 4,0);
			//set up the years level with a label and editable textfield, center them accordingly
			Label years = new Label("Years");
			years.setFont(LABEL_FONT);
			years.setAlignment(Pos.CENTER_LEFT);
			grid.add(years, 1,1);
			TextField yearsInput = new TextField();
			yearsInput.setAlignment(Pos.CENTER_RIGHT);
			grid.add(yearsInput, 4,1);
			//set up the interest level with a label and editable textfield, center accordingly
			Label annualInterest = new Label("Annual Interest Rate");
			annualInterest.setFont(LABEL_FONT);
			annualInterest.setAlignment(Pos.CENTER_LEFT);
			grid.add(annualInterest, 1,2);
			TextField interestInput = new TextField();
			interestInput.setAlignment(Pos.CENTER_RIGHT);
			grid.add(interestInput, 4,2);
			//set up the future value level with a label and editable textfield, center accoridingly. all of this is done to get a vertical stack look
			Label futureValue = new Label("Future value");
			futureValue.setFont(LABEL_FONT);
			futureValue.setAlignment(Pos.CENTER_LEFT);
			grid.add(futureValue, 1,3);
			TextField futureDisplay = new TextField();
			futureDisplay.setAlignment(Pos.CENTER_RIGHT);
			grid.add(futureDisplay, 4,3);
			//set up the calculate button and position it correctly
			Button calcButton = new Button("Calculate");
			HBox calcButtonBox = new HBox(10);
			calcButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
	        calcButtonBox.getChildren().add(calcButton);
	        grid.add(calcButtonBox,4,4);
	        
	        //make the textfields editable, except for the future one
			investInput.setEditable(true);
			yearsInput.setEditable(true);
			interestInput.setEditable(true);
			futureDisplay.setEditable(false);
			//set up the calculate button action to where it takes the input from the text fields, converts it the ints/doubles, calculates it, formats it and goes back to string
			//to display in that text field
			calcButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if(!investInput.getText().equals("")&&!yearsInput.getText().equals("")
							&&!interestInput.getText().equals("")) {
						int amount = Integer.parseInt(investInput.getText());
						int yearsNum = Integer.parseInt(yearsInput.getText());
						double annualInterest = Double.parseDouble(interestInput.getText());
						double monthlyInterest = annualInterest/12;
						double future = amount * Math.pow(((1 + (monthlyInterest/100))),(yearsNum*12));
						String showFuture = String.format("%.2f",future);
						futureDisplay.setText(showFuture);
						
					}
				}
			});
			;
			//set up the scene based on the grid, then launch
			Scene scene = new Scene(grid,300,200);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
