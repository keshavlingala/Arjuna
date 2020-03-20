package com.elite.old;

import java.sql.*;

public class Server {
    public static void main(String[] args) {
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        try {   
            Class.forName(driver);
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
                Statement st = con.createStatement();
                ResultSet rs=st.executeQuery("SELECT * from stds");
                System.out.println(rs.toString());

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
