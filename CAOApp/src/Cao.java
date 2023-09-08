import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Cao extends Application {
	List<CaoBrowser> list = new ArrayList<>();
	// List of contact table properties
	float totalPoints = 0;

	private final GridPane gridPane = new GridPane();
	private final Label lblName = new Label("Search by Name");
	private ObservableList<CaoBrowser> observableNames;
	TableView<CaoBrowser> contactTableView = new TableView<>();

	public Cao() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC driver loaded");
		} catch (Exception err) {
			System.err.println("Error loading JDBC driver");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		Connection databaseConnection = null;
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//database name, user name and passowrd 
			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=ZOCao;user=sekeriye.osman@coccork.ie;password=ganey505";
			System.out.println(connectionUrl);

			databaseConnection = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected to the database");

			System.out.println("Database Connected");
			
			//selects from the module resutls table
			String queryString = "select * from ModuleResults";
			System.out.println(queryString);
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
			ResultSet rset = preparedStatement.executeQuery(); // executes query 

			while (rset.next()) {
				String name = rset.getString("PPSN");

				String cname = rset.getString("Fname");
				
				// Database collum names
				System.out.println(name + " " + cname);
				CaoBrowser p = new CaoBrowser();
				p.setPpsn(rset.getString("PPSN"));
				p.setFname(rset.getString("Fname"));
				p.setSname(rset.getString("Sname"));
				p.setMod1(rset.getFloat("5N2928"));
				totalPoints = addTotal(rset.getFloat("5N2928"));
				p.setMod2(rset.getFloat("5N2929"));
				totalPoints = addTotal(rset.getFloat("5N2929"));
				p.setMod3(rset.getFloat("5N0548"));
				totalPoints = addTotal(rset.getFloat("5N0548"));
				p.setMod4(rset.getFloat("5N2434"));
				totalPoints = addTotal(rset.getFloat("5N2434"));
				p.setMod5(rset.getFloat("5N2927"));
				totalPoints = addTotal(rset.getFloat("5N2927"));
				p.setMod6(rset.getFloat("5N18396"));
				totalPoints = addTotal(rset.getFloat("5N18396"));
				p.setMod7(rset.getFloat("5N0783"));
				totalPoints = addTotal(rset.getFloat("5N0783"));
				p.setMod8(rset.getFloat("5N0690"));
				totalPoints = addTotal(rset.getFloat("5N0690"));
				p.setMod9(rset.getFloat("5N1356"));
				totalPoints = addTotal(rset.getFloat("5N1356"));
				p.setTotpts(totalPoints);

				list.add(p);
				totalPoints = 0;
				System.out.println("found one ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		lblName.setTextFill(Color.web("#0076a3"));
		observableNames = FXCollections.observableArrayList(list);
	}

	@Override
	public void start(Stage primaryStage) {
		//Table view collum names
		observableNames = FXCollections.observableArrayList(list);
		TableView<CaoBrowser> contactsTable = new TableView<>();

		TableColumn<CaoBrowser, String> ppsn = new TableColumn<>("Exam Number");
		contactsTable.getColumns().add(ppsn);
		ppsn.setCellValueFactory(new PropertyValueFactory<>("ppsn"));
		ppsn.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<CaoBrowser, String> fname = new TableColumn<>("First Name");
		contactsTable.getColumns().add(fname);
		fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
		fname.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<CaoBrowser, String> sname = new TableColumn<>("Last Name");
		contactsTable.getColumns().add(sname);
		sname.setCellValueFactory(new PropertyValueFactory<>("sname"));
		sname.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<CaoBrowser, Float> mod1 = new TableColumn<>("Oper Sys");
		contactsTable.getColumns().add(mod1);
		mod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));

		TableColumn<CaoBrowser, Float> mod2 = new TableColumn<>("Networking");
		contactsTable.getColumns().add(mod2);
		mod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));

		TableColumn<CaoBrowser, Float> mod3 = new TableColumn<>("Hardware");
		contactsTable.getColumns().add(mod3);
		mod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));

		TableColumn<CaoBrowser, Float> mod4 = new TableColumn<>("Virtualisation");
		contactsTable.getColumns().add(mod4);
		mod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));

		TableColumn<CaoBrowser, Float> mod5 = new TableColumn<>("Programming");
		contactsTable.getColumns().add(mod5);
		mod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));

		TableColumn<CaoBrowser, Float> mod6 = new TableColumn<>("Maths for IT");
		contactsTable.getColumns().add(mod6);
		mod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));

		TableColumn<CaoBrowser, Float> mod7 = new TableColumn<>("Database");
		contactsTable.getColumns().add(mod7);
		mod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));

		TableColumn<CaoBrowser, Float> mod8 = new TableColumn<>("Communications");
		contactsTable.getColumns().add(mod8);
		mod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));

		TableColumn<CaoBrowser, Float> mod9 = new TableColumn<>("Work Experience");
		contactsTable.getColumns().add(mod9);
		mod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));

		TableColumn<CaoBrowser, Float> totpts = new TableColumn<>("Total Points");
		contactsTable.getColumns().add(totpts);
		totpts.setCellValueFactory(new PropertyValueFactory<>("totpts"));
		

		Button help = new Button("Help?"); // Creates a help Button 
		
		// Sets the help button on action to display message when pressed. 
		help.setOnAction(e -> {
			showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Help",
					"You can search for a student by their first name surname or partially,  "
							+ "you can search a student using their exam number,"
							+ "you can also delete a student from the database:");

			return;
		});
		

		Button findName = new Button("Search"); // creates a search button
		TextField enterName = new TextField(); // creates textfield 
		enterName.setPromptText("First name or Surname"); // sets the texfield to first name or surname 
		
		// sets findName button action
		findName.setOnAction(e -> {
			if (!enterName.getText().matches("[a-zA-Z\\s']+")) { // validates Name format 
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
						"Please enter a valid Name ");
				return;
			} else if (!enterName.getText().trim().isEmpty()) {
				String queryName = enterName.getText().replace("'", "`");
				String searchString = "select * from dbo.ModuleResults where Fname  = '" + queryName + "' or Sname = '"
						+ queryName + "'"; // selects from module results table to display searched first name

				readDB(searchString); // reads the select statement
				observableNames = FXCollections.observableArrayList(list);
				contactsTable.setItems(observableNames);
			} else {
				readDB("select * from dbo.ModuleResults");
				observableNames = FXCollections.observableArrayList(list);
				contactsTable.setItems(observableNames);
			}
		});

		Button findPPSN = new Button("Search"); // creates search button 

		TextField enterPPSN = new TextField(); // creates texfield
		enterPPSN.setPromptText("Exam No"); // sets textfield "Exam no"
		
		//sets button on action
		findPPSN.setOnAction(e -> {
			if (enterPPSN.getText().isEmpty()) { // validates if field is empty
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!",
						"Please enter an exam number");
				return;
			}

			String queryName = enterPPSN.getText().replace("'", "`");
			String searchString = "select * from dbo.ModuleResults where PPSN  = '" + queryName + "'"; // select statement for PPSN search
			readDB(searchString);

			observableNames = FXCollections.observableArrayList(list);
			contactsTable.setItems(observableNames);

		});



		Button partialS = new Button("Search"); // creates search button
		TextField enterPn = new TextField(); // creates textfield
		enterPn.setPromptText("Partial Search"); // sets tesxtfield "Partial search"
		Tooltip tt = new Tooltip(
				"This field will allow you to search names partially"); // displays messages when hovering over the search button 
		partialS.setTooltip(tt);
		
		// sets the button on action
		partialS.setOnAction(e -> {
			if (enterPn.getText().isEmpty()) { // validates if field is empty
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please enter a letter");
			}
			String partialsearch = enterPn.getText().replace("'", "`");
			String ps = "Select * from ModuleResults  where Fname LIKE '" + partialsearch + '%' + "' or Sname LIKE'"
					+ partialsearch + "%'"; // select statement for partial search
			readDB(ps);

			observableNames = FXCollections.observableArrayList(list);
			contactsTable.setItems(observableNames);
		});

		Button delete = new Button("Delete"); //Creates a search button
		TextField deleteP = new TextField(); // Creates textfield
		deleteP.setPromptText("Enter Exam Number"); // sets textfield "Enter exam number"
		
		//sets button on action 
		delete.setOnAction(e -> {
			Connection databaseConnection = null;
			try {
				String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=ZOCao;user=sekeriye.osman@coccork.ie;password=ganey505";
				System.out.println(connectionUrl); //database connection

				databaseConnection = DriverManager.getConnection(connectionUrl);
				String queryName = deleteP.getText().replace("'", "`");
				String deleteString = "DELETE from dbo.ModuleResults where PPSN  = '" + queryName + "'"; // deletes from database 
				System.out.println(queryName);
				PreparedStatement ps = databaseConnection.prepareStatement(deleteString);

				Alert alert = new Alert(AlertType.CONFIRMATION); // confirm warning 
				alert.setTitle("Delete");		
				alert.setHeaderText("You're about to Delete this record!");
				alert.setContentText("Are you sure you want to Delete?");
			


				 if (!deleteP.getText().matches("[/^(\\d{7})([A-Z]{1,2})$/i;']+")) { //PPSN regex 
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter a valid Exam Number "); // validates if PPSN matches the regex format 
				
				}
				 
				 else if (deleteP.getText().isEmpty()) { // validates if texfield is empty
						showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!",
								"Please enter the Exam Number");
					}
				
					else if (alert.showAndWait().get() == ButtonType.OK){ // alert 
					ps.executeUpdate(); // executing the update
					showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Success!",
							"Record has been deleted successfully, Please refresh your table for the changes to take affect ");
					list.clear();
					contactsTable.refresh();
					System.out.println("Record Deleted!");
					primaryStage.show();
				
					}

			} catch (Exception exc) {
				exc.printStackTrace();
			}
			

		});
		
		

		Button insert = new Button("Insert"); // creates button 

		insert.setOnAction(e -> Insert.show()); // sets button on action

		Button updateMarks = new Button("Update"); // creates button 

		updateMarks.setOnAction(e -> Update.show());  // sets button on action


		Button exit = new Button("Exit"); // creates button 
		exit.setOnAction(e -> primaryStage.close()); // closes screen when btn is pressed 

		contactsTable.setItems(observableNames);
		contactsTable.setEditable(true);
		contactsTable.setStyle("-fx-base: linen ;"); // table color 

		primaryStage.setTitle("Student");
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 1000, 700, true);
		scene.getStylesheets().add("Style.css");

		borderPane.setStyle("-fx-base: linen;");
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setStyle("-fx-base: white;");

		// Set a padding of 40px on each side
		gridPane.setPadding(new Insets(20, 20, 20, 20));

		// Set the horizontal gap between columns
		gridPane.setHgap(5);

		// Set the vertical gap between rows
		gridPane.setVgap(20);
		
		//sets help btn position
		gridPane.add(help, 5, 1);
		
		// sets name field position 
		gridPane.add(enterName, 0, 1); 
		gridPane.add(findName, 1, 1);
		
		//sets PPSN field position 
		gridPane.add(enterPPSN, 0, 2);
		gridPane.add(findPPSN, 1, 2);

		//sets partial search field postiton 
		gridPane.add(partialS, 1, 3);
		gridPane.add(enterPn, 0, 3);
		
		//sets delete btn/ textfeild position 
		gridPane.add(deleteP, 0, 4);
		gridPane.add(delete, 1, 4);
		delete.setStyle("-fx-base: red;");
		
		//sets insert button position 
		gridPane.add(insert, 3, 5);
		
		//Sets update btn position 
		gridPane.add(updateMarks, 4, 5);
		
		//Sets exit btn position
		gridPane.add(exit, 5, 5);

		gridPane.add(contactsTable, 0, 2);

		borderPane.setTop(contactsTable);
		borderPane.setLeft(gridPane);
		primaryStage.setScene(scene); // shows scene 
		primaryStage.show(); // shows stage 

	}
	

	public static void main(String[] args) {
		launch(args);
	}

	public void readDB(String query) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC driver loaded");
		} catch (Exception err) {
			System.err.println("Error loading JDBC driver");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		Connection databaseConnection = null;
		try {

			list.clear();

			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=ZOCao;user=sekeriye.osman@coccork.ie;password=ganey505";

			databaseConnection = DriverManager.getConnection(connectionUrl);
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
			ResultSet rset = preparedStatement.executeQuery();

			while (rset.next()) {
				CaoBrowser p = new CaoBrowser();
				p.setFname(rset.getString("Fname"));
				p.setSname(rset.getString("Sname"));
				p.setPpsn(rset.getString("PPSN"));
				p.setMod1(rset.getFloat("5N2928"));
				p.setMod2(rset.getFloat("5N2929"));
				p.setMod3(rset.getFloat("5N0548"));
				p.setMod4(rset.getFloat("5N2434"));
				p.setMod5(rset.getFloat("5N2927"));
				p.setMod6(rset.getFloat("5N18396"));
				p.setMod7(rset.getFloat("5N0783"));
				p.setMod8(rset.getFloat("5N0690"));
				p.setMod9(rset.getFloat("5N1356"));
				totalPoints = addTotal(rset.getFloat("5N1356"));
				p.setTotpts(totalPoints);

				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private float addTotal(float grade) {
		if (grade >= 80) {
			totalPoints += 38.75;
		} else if (grade >= 65) {
			totalPoints += 32.5;
		} else if (grade >= 50) {
			totalPoints += 16.35;
		}

		return totalPoints;

	}

	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}