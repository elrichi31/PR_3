//package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    ObservableList<Label> facultyResultConsult = FXCollections.observableArrayList();
    ObservableList<Label> courseResultConsult = FXCollections.observableArrayList();
    ObservableList<Course> dataCourse = FXCollections.observableArrayList();
    ObservableList<Faculty> dataFaculty = FXCollections.observableArrayList();

    public void clearFacultyFields(){
        facultyIdField2.clear();
        facultyField.clear();
        officeField.clear();
    }

    public void clearCourseFields(){
        facultyIdField.clear();
        courseField.clear();
        courseIdField.clear();
    }

    public Controller controller = new Controller();

    public BorderPane createView (){

        dataCourse = controller.getCourses();
        dataFaculty = controller.getFaculties();

        tableCourseView = new TableView<Course>();
        tableFacultyView = new TableView<Faculty>();

        tableFacultyView.setEditable(false);
        tableCourseView.setEditable(false);
    
        TableColumn<Course, Integer> facultyIdColumn = new TableColumn<Course, Integer>("Faculty ID");
        TableColumn<Course, String> courseColumn = new TableColumn<Course, String>("Course");
        TableColumn<Course, Integer> courseIdColumn = new TableColumn<Course, Integer>("Course ID");

        TableColumn<Faculty, Integer> facultyIdColumn2 = new TableColumn<Faculty, Integer>("Faculty ID");
        TableColumn<Faculty, String> facultyNameColumn = new TableColumn<Faculty, String>("Faculty Name");
        TableColumn<Faculty, String> officeColumn = new TableColumn<Faculty, String>("Office");

        facultyIdColumn.setMinWidth(110);
        facultyIdColumn.setCellValueFactory(
                new PropertyValueFactory<Course, Integer>("facultyId"));
        courseColumn.setMinWidth(150);
        courseColumn.setCellValueFactory(
                new PropertyValueFactory<Course, String>("course"));
        courseIdColumn.setMinWidth(110);
        courseIdColumn.setCellValueFactory(
                new PropertyValueFactory<Course, Integer>("courseId"));

        // Faculty
        facultyIdColumn2.setMinWidth(110);
        facultyIdColumn2.setCellValueFactory(
               new PropertyValueFactory<Faculty, Integer>("facultyId"));
        facultyNameColumn.setMinWidth(150);
        facultyNameColumn.setCellValueFactory(
                new PropertyValueFactory<Faculty, String>("facultyName"));
        officeColumn.setMinWidth(110);
        officeColumn.setCellValueFactory(
                new PropertyValueFactory<Faculty, String>("office"));
 
 
        tableCourseView.setItems(dataCourse);
        tableCourseView.getColumns().addAll(facultyIdColumn, courseColumn, courseIdColumn);

        tableFacultyView.setItems(dataFaculty);
        tableFacultyView.getColumns().addAll(facultyIdColumn2, facultyNameColumn, officeColumn);

        
        
        facultyIdField = new TextField();
        facultyIdField.setPrefWidth(110);
        facultyIdField.setPromptText("Faculty Id");
    
        courseField = new TextField();
        courseField.setPrefWidth(150);
        courseField.setPromptText("Course");

        courseIdField = new TextField();
        courseIdField.setPrefWidth(110);
        courseIdField.setPromptText("Course Id");



        facultyIdField2 = new TextField();
        facultyIdField2.setPromptText("Faculty Id");
        facultyIdField2.setPrefWidth(110);

        facultyField = new TextField();
        facultyField.setPromptText("Faculty");
        facultyField.setPrefWidth(150);

        officeField = new TextField();
        officeField.setPromptText("Office");
        officeField.setPrefWidth(110);



        // Course button controllers
        Button addCurseButton = new Button("Add");
        addCurseButton.setOnAction(e -> {
            if(facultyIdField.getText().isEmpty() || courseField.getText().isEmpty() || courseIdField.getText().isEmpty()){
                Alert a = new Alert(AlertType.WARNING);
                a.setTitle("Warning");
                a.setHeaderText("Empty field");
                a.showAndWait();
            } else {
                controller.addCourse(facultyIdField ,courseField, courseIdField, dataCourse, dataFaculty);
                tableCourseView.setItems(controller.getCourses());
                dataCourse = controller.getCourses();
                clearCourseFields();
            }
        });

        Button updateCurseButton = new Button("Update");
        updateCurseButton.setOnAction(e -> {
            if(facultyIdField.getText().isEmpty() || courseField.getText().isEmpty() || courseIdField.getText().isEmpty()){
                Alert a = new Alert(AlertType.WARNING);
                a.setTitle("Warning");
                a.setHeaderText("Empty field");
                a.showAndWait();
            } else {
                controller.updateCourse(facultyIdField, courseField, courseIdField);
                tableCourseView.setItems(controller.getCourses());
                tableCourseView.refresh();
                dataCourse = controller.getCourses();
                clearCourseFields();
            }
        });

        Button deleteCourseButton = new Button("Delete");
        deleteCourseButton.setOnAction(e -> {
            if(facultyIdField.getText().isEmpty() || courseField.getText().isEmpty() || courseIdField.getText().isEmpty()){
                Alert a = new Alert(AlertType.WARNING);
                a.setTitle("Warning");
                a.setHeaderText("Empty field");
                a.showAndWait();
            } else {
                controller.deleteCourse(courseIdField);
                tableCourseView.setItems(controller.getCourses());
                tableCourseView.refresh();
                dataCourse = controller.getCourses();
                clearCourseFields();
            }
        });

        Button clearCourseButton = new Button("Clear");
        clearCourseButton.setOnAction(e -> {
            facultyIdField.clear();
            courseField.clear();
            courseIdField.clear();
        });

        // Faculty button controller
        Button addFacultyButton = new Button("Add");
        addFacultyButton.setOnAction(e -> {
            if(facultyIdField2.getText().isEmpty() || facultyField.getText().isEmpty() || officeField.getText().isEmpty()){
                Alert a = new Alert(AlertType.WARNING);
                a.setTitle("Warning");
                a.setHeaderText("Empty field");
                a.showAndWait();
            } else {
                controller.addFaculty(facultyIdField2,facultyField, officeField, dataFaculty);
                tableFacultyView.setItems(controller.getFaculties());
                dataFaculty = controller.getFaculties();
                clearFacultyFields();
            }
            
        });

        Button updateFacultyButton = new Button("Update");
        updateFacultyButton.setOnAction(e -> {
            if(facultyIdField2.getText().isEmpty() || facultyField.getText().isEmpty() || officeField.getText().isEmpty()){
                Alert a = new Alert(AlertType.WARNING);
                a.setTitle("Warning");
                a.setHeaderText("Empty field");
                a.showAndWait();
            } else {
                controller.updateFaculty(facultyIdField2,facultyField, officeField);
                tableFacultyView.setItems(controller.getFaculties());
                tableFacultyView.refresh();
                dataFaculty = controller.getFaculties();
                clearFacultyFields();
            }
        });

        Button deleteFacultyButton = new Button("Delete");
        deleteFacultyButton.setOnAction(e -> {
            if(facultyIdField2.getText().isEmpty() || facultyField.getText().isEmpty() || officeField.getText().isEmpty()){
                Alert a = new Alert(AlertType.WARNING);
                a.setTitle("Warning");
                a.setHeaderText("Empty field");
                a.showAndWait();
            } else {
                controller.deleteFaculty(facultyIdField2);
                tableFacultyView.setItems(controller.getFaculties());
                tableCourseView.setItems(controller.getCourses());
                tableFacultyView.refresh();
                dataFaculty = controller.getFaculties();
                clearFacultyFields();
            }
        });

        Button clearFacultyButton = new Button("Clear");
        clearFacultyButton.setOnAction(e -> {
            facultyIdField2.clear();
            facultyField.clear();
            officeField.clear();
        });

        

        // Crear el panel de entrada de datos
        GridPane gridPaneFaculty = new GridPane();
        gridPaneFaculty.setHgap(10);
        gridPaneFaculty.setVgap(10);
        TextField facultyConsult = new TextField();
        facultyConsult.setPromptText("Ingrese una facultad");
        Button execute = new Button("Execute");
        Button clearFacultyConsult = new Button("Clear");
        Button clearCourseConsult = new Button("Clear");

        gridPaneFaculty.setPadding(new Insets(10, 10, 10, 10));
        gridPaneFaculty.add(facultyConsult, 0, 0);
        gridPaneFaculty.add(execute, 1, 0);
        gridPaneFaculty.add(clearFacultyConsult, 2, 0);
        VBox resultConsultFaculty = new VBox(10);
        execute.setOnAction(e -> {
            facultyResultConsult = controller.getCoursesByFaculty(facultyConsult.getText());
            facultyResultConsult.forEach(e1 -> {
                resultConsultFaculty.getChildren().add(e1);
            });
        });
        clearFacultyConsult.setOnAction(e ->{
            facultyConsult.setText("");
            resultConsultFaculty.getChildren().clear();
        });


        GridPane gridPaneCourse = new GridPane();
        gridPaneCourse.setHgap(10);
        gridPaneCourse.setVgap(10);
        TextField courseConsult = new TextField();
        courseConsult.setPromptText("Palabras comunes");
        Button execute2 = new Button("Execute");
        gridPaneCourse.setPadding(new Insets(10, 10, 10, 10));
        gridPaneCourse.add(courseConsult, 0, 0);
        gridPaneCourse.add(execute2, 1, 0);
        gridPaneCourse.add(clearCourseConsult, 2, 0);
        VBox resultConsultCourse = new VBox(10);


        execute2.setOnAction(e -> {
            courseResultConsult = controller.searchCoursesByKeyWord(courseConsult.getText());
            courseResultConsult.forEach(e1 -> {
                resultConsultCourse.getChildren().addAll(e1);
            });
        });
        clearCourseConsult.setOnAction(e ->{
            courseConsult.setText("");
            resultConsultCourse.getChildren().clear();
        });

        GridPane inputGridPane = new GridPane();
        inputGridPane.setHgap(5);
        inputGridPane.setVgap(5);
        inputGridPane.setPadding(new Insets(4, 0, 4, 0));
        inputGridPane.add(facultyIdField, 0, 0);
        inputGridPane.add(courseField, 1, 0);
        inputGridPane.add(courseIdField, 2, 0);


        GridPane inputGridPane2 = new GridPane();
        inputGridPane2.setHgap(5);
        inputGridPane2.setVgap(5);
        inputGridPane2.setPadding(new Insets(4, 0, 4, 0));
        inputGridPane2.add(facultyIdField2, 0, 0);
        inputGridPane2.add(facultyField, 1, 0);
        inputGridPane2.add(officeField, 2, 0);

        // Crear el panel de botones
        GridPane buttonGridPane = new GridPane();
        buttonGridPane.setHgap(5);
        buttonGridPane.setVgap(5);
        //buttonGridPane.setPadding(new Insets(5, 5, 5, 5));
        buttonGridPane.add(addCurseButton, 0, 0);
        buttonGridPane.add(updateCurseButton, 1, 0);
        buttonGridPane.add(deleteCourseButton, 2, 0);
        buttonGridPane.add(clearCourseButton, 3, 0);

        GridPane buttonGridPane2 = new GridPane();
        buttonGridPane2.setHgap(5);
        buttonGridPane2.setVgap(5);
        //buttonGridPane2.setPadding(new Insets(10, 10, 10, 10));
        buttonGridPane2.add(addFacultyButton, 0, 0);
        buttonGridPane2.add(updateFacultyButton, 1, 0);
        buttonGridPane2.add(deleteFacultyButton, 2, 0);
        buttonGridPane2.add(clearFacultyButton, 3, 0);

        // Crear el panel principal
        VBox vBoxCourse = new VBox(5);
        VBox vBoxFaculty = new VBox(5);
        VBox vBoxTotal = new VBox(10);

        VBox vBoxCourseConsult = new VBox(10);
        VBox vBoxFacultyConsult = new VBox(10);

        Label title = new Label("Consultas");

        title.setAlignment(Pos.CENTER);
        HBox hBoxConsult = new HBox(10);
        HBox hBox = new HBox(20); 
        hBox.setAlignment(Pos.CENTER);
        vBoxTotal.setAlignment(Pos.CENTER);
        hBoxConsult.setAlignment(Pos.CENTER);
        vBoxCourse.getChildren().addAll(tableCourseView,inputGridPane, buttonGridPane);
        vBoxFaculty.getChildren().addAll(tableFacultyView, inputGridPane2, buttonGridPane2);
        hBox.getChildren().addAll(vBoxFaculty, vBoxCourse);

        vBoxFacultyConsult.getChildren().addAll(gridPaneFaculty, resultConsultFaculty);
        vBoxCourseConsult.getChildren().addAll(gridPaneCourse, resultConsultCourse);
        hBoxConsult.getChildren().addAll(vBoxFacultyConsult, vBoxCourseConsult);

        vBoxTotal.getChildren().addAll(hBox, title, hBoxConsult);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(vBoxTotal);
        return mainPane;
    }
}
