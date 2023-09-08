import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Insert {

	public static void show() {
		Stage window = new Stage();

		Label PPSNLabel = new Label("Exam Number : ");
		TextField PPSN = new TextField();
		PPSN.setPromptText("Exam Number");

		Label name = new Label("First Name : ");
		TextField Fname = new TextField();
		Fname.setPromptText("First Name");

		Label Surname = new Label("Surname : ");
		TextField Sname = new TextField();
		Sname.setPromptText("Surname");

		Label code2 = new Label("Operating System : ");
		TextField courseResult2 = new TextField();
		courseResult2.setPromptText("Result");

		Label code3 = new Label("Networking : ");
		TextField courseResult3 = new TextField();
		courseResult3.setPromptText("Result");

		Label code4 = new Label("Harware : ");
		TextField courseResult4 = new TextField();
		courseResult4.setPromptText("Result");

		Label code5 = new Label("Vitualisation : ");
		TextField courseResult5 = new TextField();
		courseResult5.setPromptText("Result");

		Label code6 = new Label("Programming : ");
		TextField courseResult6 = new TextField();
		courseResult6.setPromptText("Result");

		Label code7 = new Label("Maths for IT : ");
		TextField courseResult7 = new TextField();
		courseResult7.setPromptText("Result");

		Label code8 = new Label("Databse : ");
		TextField courseResult8 = new TextField();
		courseResult8.setPromptText("Result");

		Label code9 = new Label("Communications : ");
		TextField courseResult9 = new TextField();
		courseResult9.setPromptText("Result");

		Label code10 = new Label("Work Experience : ");
		TextField courseResult10 = new TextField();
		courseResult10.setPromptText("Result");

		GridPane gridPane = new GridPane();

		gridPane.add(PPSNLabel, 0, 8);
		gridPane.add(PPSN, 1, 8);
		PPSN.setStyle("-fx-base: white;");

		gridPane.add(Fname, 1, 9);
		gridPane.add(name, 0, 9);
		Fname.setStyle("-fx-base: white;");

		gridPane.add(Sname, 1, 10);
		gridPane.add(Surname, 0, 10);
		Sname.setStyle("-fx-base: white;");

		gridPane.add(code2, 0, 11);
		gridPane.add(courseResult2, 1, 11);
		courseResult2.setStyle("-fx-base: white;");

		gridPane.add(code3, 0, 12);
		gridPane.add(courseResult3, 1, 12);
		courseResult3.setStyle("-fx-base: white;");

		gridPane.add(code4, 0, 13);
		gridPane.add(courseResult4, 1, 13);
		courseResult4.setStyle("-fx-base: white;");

		gridPane.add(code5, 0, 14);
		gridPane.add(courseResult5, 1, 14);
		courseResult5.setStyle("-fx-base: white;");

		gridPane.add(code6, 0, 15);
		gridPane.add(courseResult6, 1, 15);
		courseResult6.setStyle("-fx-base: white;");

		gridPane.add(code7, 0, 16);
		gridPane.add(courseResult7, 1, 16);
		courseResult7.setStyle("-fx-base: white;");

		gridPane.add(code8, 0, 17);
		gridPane.add(courseResult8, 1, 17);
		courseResult8.setStyle("-fx-base: white;");

		gridPane.add(code9, 0, 18);
		gridPane.add(courseResult9, 1, 18);
		courseResult9.setStyle("-fx-base: white;");

		gridPane.add(code10, 0, 19);
		gridPane.add(courseResult10, 1, 19);
		courseResult10.setStyle("-fx-base: white;");

		gridPane.setStyle("-fx-base: black;");
		gridPane.setAlignment(Pos.TOP_LEFT);

		gridPane.setHgap(5);
		gridPane.setVgap(5);

		Scene scene = new Scene(gridPane, 500, 650);
		window.setTitle("Add record");
		window.setScene(scene);
		window.show();
		scene.getStylesheets().add("Style.css");

		Button insert = new Button("Insert");
		gridPane.add(insert, 0, 22);
		insert.setStyle("-fx-base: white;");

		Button help = new Button("Help?");
		help.setStyle("-fx-base: white;");

		help.setOnAction(e -> {
			showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Help",
					"Please enter the new student's details, "
					+ "once complete press the insert button for the new student to be addes into the database: ");

			return;
		});

		gridPane.add(help, 5, 7);

		Button exit = new Button("Exit");
		exit.setOnAction(e -> window.close());
		gridPane.add(exit, 5, 22);
		exit.setStyle("-fx-base: white;");

		insert.setOnAction(e -> {

			Connection databaseConnection = null;

			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=ZOCao;user=sekeriye.osman@coccork.ie;password=ganey505";
			System.out.println(connectionUrl);
			try {
				databaseConnection = DriverManager.getConnection(connectionUrl);
				String insertName = PPSN.getText().replace("'", "`");
				String insertName2 = Fname.getText().replace("'", "`");
				String insertName3 = Sname.getText().replace("'", "`");
				String insertName4 = courseResult2.getText().replace("'", "`");
				String insertName5 = courseResult3.getText().replace("'", "`");
				String insertName6 = courseResult4.getText().replace("'", "`");
				String insertName7 = courseResult5.getText().replace("'", "`");
				String insertName8 = courseResult6.getText().replace("'", "`");
				String insertName9 = courseResult7.getText().replace("'", "`");
				String insertName10 = courseResult8.getText().replace("'", "`");
				String insertName11 = courseResult9.getText().replace("'", "`");
				String insertName12 = courseResult10.getText().replace("'", "`");
				// String insertName13 = code11.getText().replace("'", "`");

				String insertString = "INSERT INTO dbo.ModuleResults " + "VALUES('" + insertName + "', '" + insertName2
						+ "', '" + insertName3 + "', '" + insertName4 + "', '" + insertName5 + "', '" + insertName6
						+ "', '" + insertName7 + "', '" + insertName8 + "', '" + insertName9 + "', '" + insertName10
						+ "', '" + insertName11 + "', '" + insertName12 + "')"; // inserts new record into the database. 
				PreparedStatement ps = databaseConnection.prepareStatement(insertString);

				if (PPSN.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the record you wish to add");
					return;

				}

				if (Fname.getText().isEmpty()) { // validates if field is empty  
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the first name");
					return;

				}

				if (Sname.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the Surname");
					return;

				}

				if (courseResult2.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the operating system result");
					return;

				}

				if (courseResult3.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the networking result");
					return;

				}

				if (courseResult4.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the hardware result");
					return;

				}

				if (courseResult5.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the virtualisation result");
					return;

				}

				if (courseResult6.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the programming result");
					return;

				}

				if (courseResult7.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the maths for IT result");
					return;

				}

				if (courseResult8.getText().isEmpty()) { // validates if field is empty  
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the databse result");
					return;

				}

				if (courseResult9.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the communications result");
					return;

				}

				if (courseResult10.getText().isEmpty()) { // validates if field is empty 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please Enter the Work Experience result");
					return;

				}

				else {
					ps.executeUpdate(); // executing the update
					showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Success!",
							"Record has been inserted successfully");
					System.out.println("Records inserted");

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
