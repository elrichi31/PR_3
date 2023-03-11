package com.example;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    private ObservableList<Person> getPeople() {
        // Obtener todos los registros de la tabla
        ObservableList<Person> people = FXCollections.observableArrayList();
    
        // try {
        //     ResultSet rs = selectAll.executeQuery();
        //     while (rs.next()) {
        //         int faculty_id = rs.getInt("faculty_id");
        //         String firstName = rs.getString("first_name");
        //         String lastName = rs.getString("last_name");
        //         String email = rs.getString("email");
    
        //         Person person = new Person(faculty_id, firstName, lastName, email);
        //         people.add(person);
        //     }
        // } catch (SQLException ex) {
        //     ex.printStackTrace();
        // }
    
        return people;
    }
    
    public ObservableList<Person> addPerson(TextField faculty_id, TextField courseField, TextField course_idField, 
    ObservableList<Person> data) {
        data.add(new Person(Integer.parseInt(faculty_id.getText()), courseField.getText(), course_idField.getText()));
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

    public ObservableList<Person> updatePerson(TextField faculty_id, TextField courseField, TextField course_idField, 
    ObservableList<Person> data){
        data.forEach(e -> {
            if(e.getFacultyId() == Integer.parseInt(faculty_id.getText())){
                System.out.println(e.getCourse());
                e.setCourse(courseField.getText());
                e.setCourseId(course_idField.getText());
                //e.setEmail(emailField.getText());
                System.out.println(e.getCourse() + " " + e.getCourseId());
            }

        });
        return data;
    }

    public ObservableList<Person> deletePerson(TextField faculty_id, TextField courseField, TextField course_idField, 
    ObservableList<Person> data){
        return data;
    }
}
