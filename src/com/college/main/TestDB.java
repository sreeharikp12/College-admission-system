package com.college.main;

import java.sql.Connection;          
import com.college.db.DBConnection;

public class TestDB {
    public static void main(String[] args) throws Exception {
        Connection con = DBConnection.getConnection();
        System.out.println("Database Connected Successfully");
    }
}

 

