package com.example;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

                Course course = new Course(facultyId, courseName, courseId);
                result.add(course);
            }
        
        } catch (SQLException e){
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        }
        return result;
    }

    boolean courseExists;
    public void addCourse(TextField faculty_id, TextField courseField, TextField course_idField, ObservableList<Course> data) {
        data.forEach(e -> {
            System.out.println(e.getCourse() + " " +  e.getCourseId() + " " + e.getFacultyId());
            if (e.getCourseId() == Integer.parseInt(course_idField.getText())){
                courseExists = true;
            }
        });
        if(!courseExists){
            Connection conn = null;
            PreparedStatement stmt = null;
            try{
                conn = DriverManager.getConnection(DB_URL);
                String sql = "INSERT INTO Course (course_id, course_name, faculty_id) VALUES (?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(course_idField.getText()));
                stmt.setString(2, courseField.getText());
                stmt.setInt(3, Integer.parseInt(faculty_id.getText()));
                stmt.executeUpdate();
                System.out.println("El curso ha sido agregado exitosamente.");
            } catch(SQLException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("Curso con id repetido ingresa otro id para continuar");
        }
    }

    public void updateCourse(TextField faculty_id, TextField courseField, TextField course_idField){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            String sql = "UPDATE Course SET course_name = ?, faculty_id = ? WHERE course_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, courseField.getText());
            stmt.setInt(2, Integer.parseInt(faculty_id.getText()));
            stmt.setInt(3, Integer.parseInt(course_idField.getText()));
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
              System.out.println("Se actualizaron " + rowsAffected + " filas.");
            } else {
              System.out.println("No se actualizaron filas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void deleteCourse(TextField course_idField){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            String sql = "DELETE FROM Course WHERE course_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(course_idField.getText()));
            stmt.executeUpdate();
            System.out.println("Curso " + course_idField.getText() + " eliminado" );
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //for Faculties

    public void addFaculty(TextField faculty_id, TextField facultyName, TextField office) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DriverManager.getConnection(DB_URL);
            String sql = "INSERT INTO Faculty (faculty_id, faculty_name, office) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(faculty_id.getText()));
            stmt.setString(2, facultyName.getText());
            stmt.setString(3, office.getText());
            stmt.executeUpdate();
            System.out.println("La facultad ha sido agregado exitosamente.");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateFaculty(TextField faculty_id, TextField facultyName, TextField office){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            String sql = "UPDATE Faculty SET faculty_name = ?, office = ? WHERE faculty_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, facultyName.getText());
            stmt.setString(2, office.getText());
            stmt.setInt(3, Integer.parseInt(faculty_id.getText()));
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
              System.out.println("Se actualizaron " + rowsAffected + " filas.");
            } else {
              System.out.println("No se actualizaron filas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFaculty(TextField faculty_id){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL);

            // Paso 3: Preparar la consulta
            String sql = "DELETE FROM Faculty WHERE faculty_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(faculty_id.getText()));
    
            // Paso 4: Ejecutar la consulta
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("No se encontró una fila con faculty_id = " + faculty_id.getText());
            } else {
                System.out.println("Se borró la fila con faculty_id = " + faculty_id.getText());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Label> getCoursesByFaculty(String facultyName){
        Connection conn = null;
        Statement stmt = null;
        ObservableList<Label> results = FXCollections.observableArrayList();

        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
    
            // Obtener el ID de la facultad
            String facultyIDQuery = "SELECT faculty_id FROM Faculty WHERE faculty_name = '" + facultyName + "'";
            ResultSet facultyIDResult = stmt.executeQuery(facultyIDQuery);
            int facultyID = 0;
            if (facultyIDResult.next()) {
                facultyID = facultyIDResult.getInt("faculty_id");
            } else {
                //System.out.println("Facultad no encontrada");
                results.add(new Label("Facultad no encontrada"));
                return results;
            }
    
            // Obtener los cursos de la facultad
            String coursesQuery = "SELECT course_id, course_name, faculty_id FROM Course WHERE faculty_id = " + facultyID;
            ResultSet coursesResult = stmt.executeQuery(coursesQuery);
    
            // Imprimir los resultados
            System.out.println("Cursos de la facultad " + facultyName + ":");
            System.out.println("Course ID" + "\t" + "Course name" + "\t" + "Faculty ID");
            results.add(new Label("Cursos de la facultad " + facultyName + ":"));
            while (coursesResult.next()) {
                int courseID = coursesResult.getInt("course_id");
                int facultyIDres = coursesResult.getInt("faculty_id");
                String courseName = coursesResult.getString("course_name");
                results.add(new Label("Course ID: " + courseID + " Course Name: " + courseName + " Faculty Id: " + facultyIDres));
                //System.out.println(courseID + "\t" + "\t" + courseName + "\t" + facultyIDres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    public ObservableList<Label> searchCoursesByKeyWord(String keyword){
        Connection conn = null;
        Statement stmt = null;
        ObservableList<Label> results = FXCollections.observableArrayList();

        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Course WHERE course_name LIKE '%" + keyword + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            results.add(new Label("Resultados para " + keyword));
            while (rs.next()) {
                int course_id = rs.getInt("course_id");
                String course_name = rs.getString("course_name");
                int faculty_id = rs.getInt("faculty_id");
                results.add(new Label("Course ID: " + course_id + ", Course Name: " + course_name + ", Faculty ID: " + faculty_id));
                //System.out.println("Course ID: " + course_id + ", Course Name: " + course_name + ", Faculty ID: " + faculty_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
