package com.sahil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeSQLConnection {
    public void insertintodatabase(String tempusername,String temppassword,String temptype,String tempname,String tempaddress,String tempcontactnum)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeelogindatabase", "root", "");
            PreparedStatement statement = con.prepareStatement("Insert into employeelogintable(EmployeeUsername,EmployeePassword, EmployeeCategory,EmployeeName,EmployeeAddress,EmployeeContactNum)VALUES(?,?,?,?,?,?)");
                    statement.setString(1,tempusername);
                    statement.setString(2,temppassword);
                    statement.setString(3,temptype);
                    statement.setString(4,tempname);
                    statement.setString(5,tempaddress);
                    statement.setString(6,tempcontactnum);
                    statement.executeUpdate();
                    statement.close();
                    con.close();
        }
        catch (Exception ep)
        {
            ep.printStackTrace();
        }
    }
}
