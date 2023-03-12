package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class Controller {

    private Connection conn;
    static final String DB_URL = "jdbc:derby:test2db";


    public ObservableList<Faculty> getFaculties() {
        ObservableList<Faculty> result = FXCollections.observableArrayList();
        // Obtener todos los registros de la tabla
        try{
            conn = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * FROM Faculty";

      //Ejecutar la consulta
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int facultyId = rs.getInt("faculty_id");
                String facultyName = rs.getString("faculty_name");
                String office = rs.getString("office");

                Faculty faculty = new Faculty(facultyId, facultyName, office);
                result.add(faculty);
            }
        
        } catch (SQLException e){
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public ObservableList<Course> getCourses() {
        ObservableList<Course> result = FXCollections.observableArrayList();
        // Obtener todos los registros de la tabla
        try{
            conn = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * FROM Course";

      // Ejecutar la consulta
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String courseName = rs.getString("course_name");
                int facultyId = rs.getInt("faculty_id");

                Course course = new Course(courseId, courseName, facultyId);
                result.add(course);

            }
        
        } catch (SQLException e){
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ObservableList<Course> addPerson(TextField faculty_id, TextField courseField, TextField course_idField, 
    ObservableList<Course> data) {
        data.add(new Course(Integer.parseInt(faculty_id.getText()), courseField.getText(), Integer.parseInt(course_idField.getText())));
        return data;
        // Insertar un nuevo registro en la tabla
    //     try {
    //         int faculty_id = Integer.parseInt(faculty_idField.getText());
    //         String firstName = firstNameField.getText();
    //         String lastName = lastNameField.getText();
    //         String email = emailField.getText();
    
    //         insert.setInt(1, faculty_id);
    //         insert.setString(2, firstName);
    //         insert.setString(3, lastName);
    //         insert.setString(4, email);
    //         insert.executeUpdate();
    
    //         clearFields();
    //         tableView.setItems(getPeople());
    //     } catch (SQLException ex) {
    //         ex.printStackTrace();
    //     }
    // }
    }

    public ObservableList<Course> updatePerson(TextField faculty_id, TextField courseField, TextField course_idField, 
    ObservableList<Course> data){
        data.forEach(e -> {
            if(e.getFacultyId() == Integer.parseInt(faculty_id.getText())){
                System.out.println(e.getCourse());
                e.setCourse(courseField.getText());
                e.setCourseId(Integer.parseInt(course_idField.getText()));
                //e.setEmail(emailField.getText());
                System.out.println(e.getCourse() + " " + e.getCourseId());
            }

        });
        return data;
    }

    public ObservableList<Course> deletePerson(TextField faculty_id, TextField courseField, TextField course_idField, 
    ObservableList<Course> data){
        return data;
    }
}
