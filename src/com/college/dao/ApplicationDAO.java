package com.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import com.college.db.DBConnection;

public class ApplicationDAO {

    // 1️⃣ Apply for course
    public void applyForCourse(int studentId, int courseId) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO applications(student_id, course_id, status) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        ps.setString(3, "PENDING");

        ps.executeUpdate();
    }

    // 2️⃣ View applications
    public void viewApplications() throws Exception {

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM applications");

        System.out.println("AppID | StudentID | CourseID | Status");

        while (rs.next()) {
            System.out.println(
                rs.getInt("app_id") + " | " +
                rs.getInt("student_id") + " | " +
                rs.getInt("course_id") + " | " +
                rs.getString("status")
            );
        }
    }

    // 3️⃣ Update status (Admin approval)
    public void updateApplicationStatus(int studentId, int courseId, String status) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE applications SET status=? WHERE student_id=? AND course_id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, status);
        ps.setInt(2, studentId);
        ps.setInt(3, courseId);

        ps.executeUpdate();
    }

    // 4️⃣ Generate admission list (placeholder for now)
    public void generateAdmissionList() throws Exception {

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        String sql = """
            SELECT s.name, c.course_name, a.status
            FROM applications a
            JOIN students s ON a.student_id = s.student_id
            JOIN courses c ON a.course_id = c.course_id
            WHERE a.status = 'APPROVED'
            """;

        ResultSet rs = st.executeQuery(sql);

        // 1️⃣ Create CSV file
        FileWriter fw = new FileWriter("admission_list.csv");

        // 2️⃣ Write header
        fw.write("Student Name,Course,Status\n");

        // 3️⃣ Write data row by row
        while (rs.next()) {
            fw.write(
                rs.getString("name") + "," +
                rs.getString("course_name") + "," +
                rs.getString("status") + "\n"
            );
        }

        // 4️⃣ Close file
        fw.close();

        System.out.println("✅ admission_list.csv generated successfully");
    }

}


