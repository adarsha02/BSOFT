package com.sahil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ClientSqlConnection {

    public void insertintodatabase(String clientfirstname, String clientmiddlename, String clientlastname,
                                  java.sql.Date clientdateofbirth, String clientsex, String clientdistrict,
                                  String clientcity, int clientwardnumber,long clientcitizenshipnumber, Long clientcontactnumber ) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase","root","");
                PreparedStatement statement= connection.prepareStatement("INSERT INTO clientpersonalinfo(ClientFirstName,ClientMiddleName,ClientLastName,ClientDateofBirth,ClientSex,ClientDistrict,ClientCity,ClientWardNum,ClientCitizenshipNum,ClientContactNum,isDeleted) Values(?,?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1,clientfirstname);
                statement.setString(2,clientmiddlename);
                statement.setString(3,clientlastname);
                statement.setDate(4,clientdateofbirth);
                statement.setString(5,clientsex);
                statement.setString(6,clientcity);
                statement.setString(7,clientdistrict);
                statement.setInt(8,clientwardnumber);
                statement.setLong(9,clientcitizenshipnumber);
                statement.setLong(10,clientcontactnumber);
                statement.setBoolean(11,false);
                statement.executeUpdate();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
