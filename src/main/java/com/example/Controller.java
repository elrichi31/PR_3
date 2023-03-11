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
        //         int id = rs.getInt("id");
        //         String firstName = rs.getString("first_name");
        //         String lastName = rs.getString("last_name");
        //         String email = rs.getString("email");
    
        //         Person person = new Person(id, firstName, lastName, email);
        //         people.add(person);
        //     }
        // } catch (SQLException ex) {
        //     ex.printStackTrace();
        // }
    
        return people;
    }
    
    public ObservableList<Person> addPerson(TextField id, TextField firstNameField, TextField lastNameField, TextField emailField, 
    ObservableList<Person> data) {
        data.add(new Person(Integer.parseInt(id.getText()), firstNameField.getText(), lastNameField.getText(), emailField.getText()));
        return data;
        // Insertar un nuevo registro en la tabla
    //     try {
    //         int id = Integer.parseInt(idField.getText());
    //         String firstName = firstNameField.getText();
    //         String lastName = lastNameField.getText();
    //         String email = emailField.getText();
    
    //         insert.setInt(1, id);
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

    public ObservableList<Person> updatePerson(TextField id, TextField firstNameField, TextField lastNameField, TextField emailField, 
    ObservableList<Person> data){
        data.forEach(e -> {
            if(e.getId() == Integer.parseInt(id.getText())){
                System.out.println(e.getFirstName());
                e.setFirstName(firstNameField.getText());
                e.setLastName(lastNameField.getText());
                e.setEmail(emailField.getText());
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }

        });
        return data;
    }

    public ObservableList<Person> deletePerson(TextField id, TextField firstNameField, TextField lastNameField, TextField emailField, 
    ObservableList<Person> data){
        return data;
    }
}
