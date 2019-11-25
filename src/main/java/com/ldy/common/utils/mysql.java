package com.ldy.common.utils;

import java.awt.*;
import java.sql.*;

public class mysql {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nack?characterEncoding=utf8&useSSL=false&zerotimestampBehavior=convertToNull", "root", "19951221ldy");
        Statement statement = connection.createStatement();
        statement.setFetchSize(100);
        ResultSet result = statement.executeQuery("SELECT * FROM user ");
        while (result.next()) {
            System.out.println(result.getString(1) + result.getString(2)+result.getString(3)+result.getString(4));
        }
    }
}
