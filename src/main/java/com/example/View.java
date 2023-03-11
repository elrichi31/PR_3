package com.example;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
public class View {
    private TableView<Person> tableView;
    private TextField idField;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField emailField;
    public Controller controller = new Controller();
    public BorderPane createView (){
        tableView = new TableView<Person>();

        final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person(1,"Jacob", "Smith", "jacob.smith@example.com"),
            new Person(2,"Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person(3,"Ethan", "Williams", "ethan.williams@example.com"),
            new Person(4,"Emma", "Jones", "emma.jones@example.com"),
            new Person(5,"Michael", "Brown", "michael.brown@example.com")
        );
        //tableView.setItems(getPeople());
        tableView.setEditable(false);
    
        TableColumn<Person, Integer> idColumn = new TableColumn<Person, Integer>("ID");

        //idColumn.setCellValueFactory(cellData );
    
        TableColumn<Person, String> firstNameColumn = new TableColumn<Person, String>("First Name");
        //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    
        TableColumn<Person, String> emailColumn = new TableColumn<>("Email");
        //emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
 
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
 
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));

        tableView.setItems(data);
        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, emailColumn);

        Label idLabel = new Label("ID:");
        idField = new TextField();
        //idField.setEditable(false);

        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField();

        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();

        Label emailLabel = new Label("Email:");
        emailField = new TextField();


        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                ObservableList <Person> newData = controller.addPerson(firstNameField, lastNameField, emailField, data);
                tableView.setItems(newData);
            }    
        });
        //addButton.setOnAction(e -> addPerson());

        Button updateButton = new Button("Update");
        //updateButton.setOnAction(e -> updatePerson());

        Button deleteButton = new Button("Delete");
        //deleteButton.setOnAction(e ->

        Button clearButton = new Button("Clear");
        //clearButton.setOnAction(e -> clearFields());
        // Crear el panel de entrada de datos
        GridPane inputGridPane = new GridPane();
        inputGridPane.setHgap(10);
        inputGridPane.setVgap(10);
        inputGridPane.setPadding(new Insets(10, 10, 10, 10));
        inputGridPane.add(idLabel, 0, 0);
        inputGridPane.add(idField, 1, 0);
        inputGridPane.add(firstNameLabel, 0, 1);
        inputGridPane.add(firstNameField, 1, 1);
        inputGridPane.add(lastNameLabel, 0, 2);
        inputGridPane.add(lastNameField, 1, 2);
        inputGridPane.add(emailLabel, 0, 3);
        inputGridPane.add(emailField, 1, 3);

        // Crear el panel de botones
        GridPane buttonGridPane = new GridPane();
        buttonGridPane.setHgap(10);
        buttonGridPane.setVgap(10);
        buttonGridPane.setPadding(new Insets(10, 10, 10, 10));
        buttonGridPane.add(addButton, 0, 0);
        buttonGridPane.add(updateButton, 1, 0);
        buttonGridPane.add(deleteButton, 2, 0);
        buttonGridPane.add(clearButton, 3, 0);

        // Crear el panel principal
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(tableView);
        mainPane.setBottom(inputGridPane);
        mainPane.setRight(buttonGridPane);
        return mainPane;
    }



        // Crear los campos de texto
    // Label idLabel = new Label("ID:");
    // idField = new TextField();
    // idField.setEditable(false);

    // Label firstNameLabel = new Label("First Name:");
    // firstNameField = new TextField();

    // Label lastNameLabel = new Label("Last Name:");
    // lastNameField = new TextField();

    // Label emailLabel = new Label("Email:");
    // emailField = new TextField();

    //     // Crear los botones
    // Button addButton = new Button("Add");
    // //addButton.setOnAction(e -> addPerson());

    // Button updateButton = new Button("Update");
    // //updateButton.setOnAction(e -> updatePerson());

    // Button deleteButton = new Button("Delete");
    // //deleteButton.setOnAction(e ->
}
