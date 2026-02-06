package com.example.java_qa4.db;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            // Student table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS student (
                    student_id INTEGER PRIMARY KEY,
                    name TEXT,
                    email TEXT
                )
            """);

            // Course table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS course (
                    course_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    course_name TEXT
                )
            """);

            // Enrollment table
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS enrollment (
                    enroll_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    student_id INTEGER,
                    course_name TEXT
                )
            """);

            System.out.println("Student tables created successfully!");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
