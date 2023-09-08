import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Update {

	public static void show() {
		Stage window = new Stage();

		Button updateMarks = new Button("Update");//Update BTN
		
		//Creating Labels, Textfileds 
		Label newR = new Label("Exam Number : "); //Creates label 
		TextField newMarks = new TextField(); // creates textfield
		newMarks.setPromptText("Exam Number"); // sets texfield 
		newMarks.setStyle("-fx-base: white;"); // color of txt field 

		Label newR1 = new Label("Operating System : ");
		TextField newcourseResult1 = new TextField(); 
		newcourseResult1.setPromptText(" New Result"); 

		newcourseResult1.setStyle("-fx-base: white;");

		Label newR2 = new Label("Networking : ");
		TextField newcourseResult2 = new TextField();
		newcourseResult2.setPromptText("New Result");
		newcourseResult2.setStyle("-fx-base: white;");

		Label newR3 = new Label("Harware : ");
		TextField newcourseResult3 = new TextField();
		newcourseResult3.setPromptText("New Result");
		newcourseResult3.setStyle("-fx-base: white;");

		Label newR4 = new Label("Virtualisation : ");
		TextField newcourseResult4 = new TextField();
		newcourseResult4.setPromptText("New Result");
		newcourseResult4.setStyle("-fx-base: white;");

		Label newR5 = new Label("Programming : ");
		TextField newcourseResult5 = new TextField();
		newcourseResult5.setPromptText("New Result");
		newcourseResult5.setStyle("-fx-base: white;");

		Label newR6 = new Label("Maths for IT : ");
		TextField newcourseResult6 = new TextField();
		newcourseResult6.setPromptText("New Result");
		newcourseResult6.setStyle("-fx-base: white;");

		Label newR7 = new Label("Databse : ");
		TextField newcourseResult7 = new TextField();
		newcourseResult7.setPromptText("New Result");
		newcourseResult7.setStyle("-fx-base: white;");

		Label newR8 = new Label("Communications : ");
		TextField newcourseResult8 = new TextField();
		newcourseResult8.setPromptText("New Result");
		newcourseResult8.setStyle("-fx-base: white;");

		Label newR9 = new Label("Work Experience : ");
		TextField newcourseResult9 = new TextField();
		newcourseResult9.setPromptText("New Result");
		newcourseResult9.setStyle("-fx-base: white;");

		GridPane gridPane = new GridPane();

		Button updateMarks1 = new Button("Update"); // update btn 
		updateMarks1.setStyle("-fx-base: white;");

		Button help = new Button("Help?"); // creates help btn
		help.setStyle("-fx-base: white;");

		help.setOnAction(e -> {
			showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Help",
					"Please enter the students exam number and the new results you want to update: "); // displays message when btn is selected

			return;
		});

		Button exit = new Button("Exit"); // creates btn 
		exit.setOnAction(e -> window.close());

		exit.setStyle("-fx-base: white;"); // color 
		
		
		//Adds All fields on the gridpane 
		gridPane.add(newR, 2, 8);
		gridPane.add(newMarks, 3, 8);
		newR.setStyle("-fx-base: red;");

		gridPane.add(newR1, 2, 9);
		newR1.setStyle("-fx-base: red;");
		gridPane.add(newcourseResult1, 3, 9);
		newR2.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult2, 3, 10);
		gridPane.add(newR2, 2, 10);
		newR3.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult3, 3, 11);
		gridPane.add(newR3, 2, 11);
		newR4.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult4, 3, 12);
		gridPane.add(newR4, 2, 12);
		newR5.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult5, 3, 13);
		gridPane.add(newR5, 2, 13);
		newR6.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult6, 3, 14);
		gridPane.add(newR6, 2, 14);
		newR7.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult7, 3, 15);
		gridPane.add(newR7, 2, 15);
		newR8.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult8, 3, 16);
		gridPane.add(newR8, 2, 16);
		newR9.setStyle("-fx-base: red;");
		
		gridPane.add(newcourseResult9, 3, 17);
		gridPane.add(newR9, 2, 17);
		gridPane.add(updateMarks1, 2, 20);
		gridPane.setStyle("-fx-base: black;");
		
		
		gridPane.add(help, 4, 7);
		
		gridPane.add(exit, 4, 20);
		
		// Set the Horizontal gap between rows
		gridPane.setHgap(5);
		// Set the vertical gap between rows
		gridPane.setVgap(5);

		Scene scene = new Scene(gridPane, 500, 650);
		window.setTitle("Add record");
		window.setScene(scene);
		window.show();
		scene.getStylesheets().add("Style.css");
		
		//sets btn on action 
		updateMarks1.setOnAction(e -> {
			Connection databaseConnection = null;
			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=ZOCao;user=sekeriye.osman@coccork.ie;password=ganey505"; 
			System.out.println(connectionUrl);//databse connection 
			
			try {
				databaseConnection = DriverManager.getConnection(connectionUrl);
				String mark = newMarks.getText().replace("'", "`");
				String mark1 = newcourseResult1.getText().replace("'", "`");  
				String mark2 = newcourseResult2.getText().replace("'", "`");
				String mark3 = newcourseResult3.getText().replace("'", "`");
				String mark4 = newcourseResult4.getText().replace("'", "`");
				String mark5 = newcourseResult5.getText().replace("'", "`");
				String mark6 = newcourseResult6.getText().replace("'", "`");
				String mark7 = newcourseResult7.getText().replace("'", "`");
				String mark8 = newcourseResult8.getText().replace("'", "`");
				String mark9 = newcourseResult9.getText().replace("'", "`");
				String updateM = "UPDATE dbo.ModuleResults set [5N2928] = '" + mark1 + "', [5N2929] = '" + mark2
						+ "', [5N0548] = '" + mark3 + "', [5N2434] = '" + mark4 + "', [5N2927] = '" + mark5
						+ "', [5N18396] = '" + mark6 + "', [5N0783] = '" + mark7 + "', [5N0690] =  '" + mark8
						+ "', [5N1356] = '" + mark9 + "'  where PPSN = '" + mark + "'"; // Updates databse with new values. 

				PreparedStatement ps = databaseConnection.prepareStatement(updateM);

				if (newMarks.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the sudents exam number");
					return;
				}

				if (newcourseResult1.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for operating systems!");
					return;
				}

				if (newcourseResult2.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Networking!");
					return;
				}

				if (newcourseResult3.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Hardware!");
					return;
				}

				if (newcourseResult4.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Virtualisation!");
					return;
				}

				if (newcourseResult5.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Programming!");
					return;
				}

				if (newcourseResult6.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Maths for IT!");
					return;
				}

				if (newcourseResult7.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Database!");
					return;
				}

				if (newcourseResult8.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Communications!");
					return;
				}

				if (newcourseResult9.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter the new mark for Work Experience!");
					return;
				}

				else {
					ps.executeUpdate(); // executing the update
					showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Success!",
							"Record has been updated successfully");
					System.out.println("Record updated");
				}

			} catch (Exception exc) {
				exc.printStackTrace();
			}
		});
	}
	
	

	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

}
