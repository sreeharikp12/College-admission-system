package com.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.college.db.DBConnection;

public class StudentDAO {

    public void registerStudent(String name, String email, double marks) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO students(name, email, marks) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setDouble(3, marks);

        ps.executeUpdate();
    }
}

