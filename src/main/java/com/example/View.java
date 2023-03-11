package com.example;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TextField faculty_idField;//idField
    private TextField courseField;//firstNameField
    private TextField course_idField;//lastNameField
    //private TextField emailField;
    public Controller controller = new Controller();
    public BorderPane createView (){
        tableView = new TableView<Person>();

        final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person(1,"Jacob", "Smith"),
            new Person(2,"Isabella", "Johnson"),
            new Person(3,"Ethan", "Williams"),
            new Person(4,"Emma", "Jones"),
            new Person(5,"Michael", "Brown")
        );
        //tableView.setItems(getPeople());
        tableView.setEditable(false);
    
        //TableColumn<Person, Integer> idColumn = new TableColumn<Person, Integer>("ID");
        TableColumn<Person, Integer> faculty_idColumn = new TableColumn<Person, Integer>("faculty_id");
        //idColumn.setCellValueFactory(cellData );
    
        //TableColumn<Person, String> firstNameColumn = new TableColumn<Person, String>("First Name");
        TableColumn<Person, String> courseColumn = new TableColumn<Person, String>("course");
        //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    
        //TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Person, String> course_idColumn = new TableColumn<>("course_id");
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    
        //TableColumn<Person, String> emailColumn = new TableColumn<>("Email");
        //emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        //idColumn.setMinWidth(20);
        //idColumn.setCellValueFactory(
        //        new PropertyValueFactory<Person, Integer>("id"));
        faculty_idColumn.setMinWidth(20);
        faculty_ididColumn.setCellValueFactory(
                new PropertyValueFactory<Person, Integer>("faculty_id"));
        
        //firstNameColumn.setMinWidth(100);
        //firstNameColumn.setCellValueFactory(
        //        new PropertyValueFactory<Person, String>("firstName"));
        courseColumn.setMinWidth(100);
        courseColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("course"));
 
        //lastNameColumn.setMinWidth(100);
        //lastNameColumn.setCellValueFactory(
        //        new PropertyValueFactory<Person, String>("lastName"));
        course_idColumn.setMinWidth(100);
        course_idColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("course_id"));
 
 
        //emailColumn.setMinWidth(250);
        //emailColumn.setCellValueFactory(
        //        new PropertyValueFactory<Person, String>("email"));

        tableView.setItems(data);
        //tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, emailColumn);
        tableView.getColumns().addAll(faculty_idColumn, courseColumn, course_idColumn);

        //Label idLabel = new Label("ID:");
        //idField = new TextField();
        Label faculty_idLabel = new Label("faculty_id:");
        faculty_idField = new TextField();

        //Label firstNameLabel = new Label("First Name:");
        //firstNameField = new TextField();
        Label courseLabel = new Label("course:");
        courseField = new TextField();

        //Label lastNameLabel = new Label("Last Name:");
        //lastNameField = new TextField();
        Label course_idLabel = new Label("course_id:");
        course_idField = new TextField();

        //Label emailLabel = new Label("Email:");
        //emailField = new TextField();


        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            //ObservableList<Person> newData = controller.addPerson(idField ,firstNameField, lastNameField, emailField, data);
            ObservableList<Person> newData = controller.addPerson(faculty_idField ,courseField, course_Field, data);
            tableView.setItems(newData);
        });

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            //ObservableList<Person> newData =  controller.updatePerson(idField, firstNameField, lastNameField, emailField, data);
            ObservableList<Person> newData =  controller.updatePerson(faculty_idField, courseField, course_idField, data);
            tableView.setItems(newData);
            tableView.refresh();
        });

        Button deleteButton = new Button("Delete");
        

        Button clearButton = new Button("Clear");
            clearButton.setOnAction(e -> {
            //idField.clear();
            //firstNameField.clear();
            //lastNameField.clear();
            //emailField.clear();
            faculty_idField.clear();
            courseField.clear();
            course_idField.clear();
        });


        // Crear el panel de entrada de datos
        GridPane inputGridPane = new GridPane();
        inputGridPane.setHgap(10);
        inputGridPane.setVgap(10);
        inputGridPane.setPadding(new Insets(10, 10, 10, 10));
        inputGridPane.add(faculty_idLabel, 0, 0);//idLabel
        inputGridPane.add(faculty_idField, 1, 0);//idField
        inputGridPane.add(courseLabel, 0, 1);//firstNameLabel
        inputGridPane.add(courseField, 1, 1);//firstNameField
        inputGridPane.add(course_idLabel, 0, 2);//lastNameLabel
        inputGridPane.add(course_idField, 1, 2);//lastNameField
        //inputGridPane.add(emailLabel, 0, 3);
        //inputGridPane.add(emailField, 1, 3);

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
}
