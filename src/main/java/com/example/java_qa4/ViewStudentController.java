package com.example.java_qa4;

import com.example.java_qa4.db.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStudentController {

    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, Integer> idCol;

    @FXML
    private TableColumn<Student, String> nameCol;

    @FXML
    private TableColumn<Student, String> emailCol;

    @FXML
    private TableColumn<Student, String> courseCol;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        loadStudents();
    }

    private void loadStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql =
                    "SELECT s.student_id, s.name, s.email, e.course_name " +
                            "FROM student s JOIN enrollment e " +
                            "ON s.student_id = e.student_id";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                table.getItems().add(
                        new Student(
                                rs.getInt("student_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("course_name")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
