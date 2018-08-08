package com.sahil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSqlConnection
{
    public int authenticateemployees(String tempusername1, String temppassword1) {
        int returnvalue=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeelogindatabase", "root", "");
            PreparedStatement statement = con.prepareStatement("Select EmployeeUsername, EmployeePassword, EmployeeCategory from employeelogintable");
            ResultSet result = statement.executeQuery();
            boolean isfound=false;
            while (result.next() && isfound==false)
            {
                String tempusername = result.getString(1);
                String temppassword = result.getString(2);
                String tempcategory = result.getString(3);

                    if (tempusername.equals(tempusername1) && temppassword.equals(temppassword1) && tempcategory.equals("admin")) {

                        returnvalue = 1;
                        isfound=true;

                    } else if (tempusername.equals(tempusername1) && temppassword.equals(temppassword1) && tempcategory.equals("Manager")) {
                        returnvalue = 2;
                        isfound=true;

                    } else if (tempusername.equals(tempusername1) && temppassword.equals(temppassword1) && tempcategory.equals("Teller")) {
                        returnvalue = 3;
                        isfound=true;

                    } else if (tempusername.equals(tempusername1) && temppassword.equals(temppassword1) && tempcategory.equals("System Admin")) {
                        returnvalue = 4;
                        isfound=true;


                    } else if (tempusername.equals(tempusername1) && temppassword.equals(temppassword1) && tempcategory.equals("Customer Service")) {

                        returnvalue = 5;
                        isfound=true;
                    }
                    else
                        {
                        returnvalue=6;
                        }
                }

        } catch (Exception ep)
            {
            ep.printStackTrace();
            }

        return returnvalue;

    }

}
