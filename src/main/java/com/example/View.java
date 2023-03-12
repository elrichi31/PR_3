package com.example;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class View {
    private TableView<Course> tableCourseView;
    private TextField facultyIdField;
    private TextField courseField;
    private TextField courseIdField;

    private TableView<Faculty> tableFacultyView;
    private TextField facultyIdField2;
    private TextField facultyField;
    private TextField officeField;

    public Controller controller = new Controller();

    public BorderPane createView (){

        tableCourseView = new TableView<Course>();
        tableFacultyView = new TableView<Faculty>();

        final ObservableList<Course> dataCourse = controller.getCourses();
        final ObservableList<Faculty> dataFaculty = controller.getFaculties();

        tableFacultyView.setEditable(false);
        tableCourseView.setEditable(false);
    
        TableColumn<Course, Integer> facultyIdColumn = new TableColumn<Course, Integer>("Course ID");
        TableColumn<Course, String> courseColumn = new TableColumn<Course, String>("Course");
        TableColumn<Course, Integer> courseIdColumn = new TableColumn<Course, Integer>("Faculty ID");

        TableColumn<Faculty, Integer> facultyIdColumn2 = new TableColumn<Faculty, Integer>("Faculty ID");
        TableColumn<Faculty, String> facultyNameColumn = new TableColumn<Faculty, String>("Faculty Name");
        TableColumn<Faculty, String> officeColumn = new TableColumn<Faculty, String>("Office");

    
        facultyIdColumn.setMinWidth(25);
        facultyIdColumn.setCellValueFactory(
                new PropertyValueFactory<Course, Integer>("facultyId"));
        courseColumn.setMinWidth(150);
        courseColumn.setCellValueFactory(
                new PropertyValueFactory<Course, String>("course"));
        courseIdColumn.setMinWidth(100);
        courseIdColumn.setCellValueFactory(
                new PropertyValueFactory<Course, Integer>("courseId"));

        // Faculty
        facultyIdColumn2.setMinWidth(25);
        facultyIdColumn2.setCellValueFactory(
               new PropertyValueFactory<Faculty, Integer>("facultyId"));
        facultyNameColumn.setMinWidth(150);
        facultyNameColumn.setCellValueFactory(
                new PropertyValueFactory<Faculty, String>("facultyName"));
        officeColumn.setMinWidth(25);
        officeColumn.setCellValueFactory(
                new PropertyValueFactory<Faculty, String>("office"));
 
 
        tableCourseView.setItems(dataCourse);
        tableCourseView.getColumns().addAll(courseIdColumn, courseColumn, facultyIdColumn);

        tableFacultyView.setItems(dataFaculty);
        tableFacultyView.getColumns().addAll(facultyIdColumn2, facultyNameColumn, officeColumn);

        facultyIdField = new TextField();
        facultyIdField.setPromptText("Faculty Id");
    
        courseField = new TextField();
        courseField.setPromptText("Course");

        courseIdField = new TextField();
        courseIdField.setPromptText("Course Id");



        facultyIdField2 = new TextField();
        facultyIdField2.setPromptText("Faculty Id");

        facultyField = new TextField();
        facultyField.setPromptText("Faculty");

        officeField = new TextField();
        officeField.setPromptText("Office");




        Button addCurseButton = new Button("Add");
        addCurseButton.setOnAction(e -> {
            ObservableList<Course> newData = controller.addPerson(facultyIdField ,courseField, courseIdField, dataCourse);
            tableCourseView.setItems(newData);
        });

        Button updateCurseButton = new Button("Update");
        updateCurseButton.setOnAction(e -> {
            ObservableList<Course> newData =  controller.updatePerson(facultyIdField, courseField, courseIdField, dataCourse);
            tableCourseView.setItems(newData);
            tableCourseView.refresh();
        });

        Button deleteCourseButton = new Button("Delete");
        deleteCourseButton.setOnAction(e -> {
            controller.getFaculties();
        });
        

        Button clearCourseButton = new Button("Clear");
        clearCourseButton.setOnAction(e -> {
            facultyIdField.clear();
            courseField.clear();
            courseIdField.clear();
        });

        Button addFacultyButton = new Button("Add");
        addCurseButton.setOnAction(e -> {
            ObservableList<Course> newData = controller.addPerson(facultyIdField ,courseField, courseIdField, dataCourse);
            tableCourseView.setItems(newData);
        });

        Button updateFacultyButton = new Button("Update");
        updateCurseButton.setOnAction(e -> {
            ObservableList<Course> newData =  controller.updatePerson(facultyIdField, courseField, courseIdField, dataCourse);
            tableCourseView.setItems(newData);
            tableCourseView.refresh();
        });

        Button deleteFacultyButton = new Button("Delete");
        

        Button clearFacultyButton = new Button("Clear");
        clearCourseButton.setOnAction(e -> {
            facultyIdField.clear();
            courseField.clear();
            courseIdField.clear();
        });


        // Crear el panel de entrada de datos
        GridPane inputGridPane = new GridPane();
        inputGridPane.setHgap(10);
        inputGridPane.setVgap(10);
        inputGridPane.setPadding(new Insets(10, 10, 10, 10));
        inputGridPane.add(facultyIdField, 0, 0);
        inputGridPane.add(courseField, 0, 1);
        inputGridPane.add(courseIdField, 0, 2);


        GridPane inputGridPane2 = new GridPane();
        inputGridPane2.setHgap(10);
        inputGridPane2.setVgap(10);
        inputGridPane2.setPadding(new Insets(10, 10, 10, 10));
        inputGridPane2.add(facultyIdField2, 0, 0);
        inputGridPane2.add(facultyField, 0, 1);
        inputGridPane2.add(officeField, 0, 2);

        // Crear el panel de botones
        GridPane buttonGridPane = new GridPane();
        buttonGridPane.setHgap(10);
        buttonGridPane.setVgap(10);
        buttonGridPane.setPadding(new Insets(10, 10, 10, 10));
        buttonGridPane.add(addCurseButton, 0, 0);
        buttonGridPane.add(updateCurseButton, 1, 0);
        buttonGridPane.add(deleteCourseButton, 2, 0);
        buttonGridPane.add(clearCourseButton, 3, 0);

        GridPane buttonGridPane2 = new GridPane();
        buttonGridPane2.setHgap(10);
        buttonGridPane2.setVgap(10);
        buttonGridPane2.setPadding(new Insets(10, 10, 10, 10));
        buttonGridPane2.add(addFacultyButton, 0, 0);
        buttonGridPane2.add(updateFacultyButton, 1, 0);
        buttonGridPane2.add(deleteFacultyButton, 2, 0);
        buttonGridPane2.add(clearFacultyButton, 3, 0);

        // Crear el panel principal
        VBox vBoxCourse = new VBox(10);
        VBox vBoxFaculty = new VBox(10);

        HBox hBox = new HBox(20); 
        hBox.setAlignment(Pos.CENTER);
        vBoxCourse.getChildren().addAll(tableCourseView,inputGridPane, buttonGridPane);
        vBoxFaculty.getChildren().addAll(tableFacultyView, inputGridPane2, buttonGridPane2);
        hBox.getChildren().addAll(vBoxFaculty, vBoxCourse);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(hBox);
        return mainPane;
    }
}
