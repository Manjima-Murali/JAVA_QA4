package com.example.java_qa4;

import com.example.java_qa4.db.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudentController {

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField courseField;
    @FXML private Label messageLabel;

    public void saveStudent() {
        try {
            Connection con = DBConnection.getConnection();

            String studentSQL =
                    "INSERT INTO student(student_id, name, email) VALUES(?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(studentSQL);
            ps1.setInt(1, Integer.parseInt(idField.getText()));
            ps1.setString(2, nameField.getText());
            ps1.setString(3, emailField.getText());
            ps1.executeUpdate();

            String enrollSQL =
                    "INSERT INTO enrollment(student_id, course_name) VALUES(?,?)";
            PreparedStatement ps2 = con.prepareStatement(enrollSQL);
            ps2.setInt(1, Integer.parseInt(idField.getText()));
            ps2.setString(2, courseField.getText());
            ps2.executeUpdate();

            messageLabel.setText("Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();           // shows error in console
            messageLabel.setText(e.getMessage()); // shows error in UI
        }

    }
}
