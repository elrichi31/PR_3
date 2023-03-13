//package com.example;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.*;

public class DatabaseInitializer {

  // JDBC driver y URL de la base de datos
  static final String DB_URL = "jdbc:derby:test2db;create=true";

  // Credenciales de acceso a la base de datos
  static final String USER = "";
  static final String PASS = "";

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try{
      //Conectarse a la base de datos
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //Crear la tabla "Faculty"
      stmt = conn.createStatement();
      String sql = "CREATE TABLE Faculty (faculty_id INT PRIMARY KEY, faculty_name VARCHAR(255), office VARCHAR(255))";
      stmt.executeUpdate(sql);

      //Crear la tabla "Course"
      sql = "CREATE TABLE Course (course_id INT PRIMARY KEY, course_name VARCHAR(255), faculty_id INT, FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id))";
      stmt.executeUpdate(sql);

      //Agregar datos de prueba a la tabla "Faculty"
      sql = "INSERT INTO Faculty (faculty_id, faculty_name, office) VALUES (1, 'Mathematics', 'Building A, Room 101')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Faculty (faculty_id, faculty_name, office) VALUES (2, 'Physics', 'Building B, Room 202')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Faculty (faculty_id, faculty_name, office) VALUES (3, 'Chemstry', 'Building C, Room 326')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Faculty (faculty_id, faculty_name, office) VALUES (4, 'Biology', 'Building F, Room 116')";
      stmt.executeUpdate(sql);



      //Agregar datos de prueba a la tabla "Course"
      sql = "INSERT INTO Course (course_id, course_name, faculty_id) VALUES (101, 'Calculus I', 1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Course (course_id, course_name, faculty_id) VALUES (102, 'Calculus II', 1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Course (course_id, course_name, faculty_id) VALUES (201, 'Mechanics I', 2)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Course (course_id, course_name, faculty_id) VALUES (202, 'Mechanics II', 2)";
      stmt.executeUpdate(sql);
      
      //Cerrar las conexiones
      stmt.close();
      conn.close();
    }catch(SQLException se){
      // Manejo de errores para JDBC
      se.printStackTrace();
    }catch(Exception e){
      // Manejo de errores para Class.forName()
      e.printStackTrace();
    }finally{
      // Cierre de las conexiones
      try{
        if(stmt!=null) stmt.close();
      }catch(SQLException se2){
      }
      try{
        if(conn!=null) conn.close();
      }catch(SQLException se){
        se.printStackTrace();
      }
    }
  }
}
