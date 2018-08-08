package com.sahil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Practice  extends JFrame implements ActionListener {
    JTextField tf;
    public Connection getConnection()
    {
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","");
        }
        catch (Exception ep)
        {
            ep.printStackTrace();
        }
        return connection;

    }
     public Practice()
     {
         JButton click=new JButton();
         click.addActionListener(this);
         setVisible(true);
         setSize(300,200);
         add(click);
         tf= new JTextField(25);
         add(tf);
         setLayout(new FlowLayout());
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        float temp = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "");
            float float2=Float.parseFloat(tf.getText());
            PreparedStatement pst = con.prepareStatement("Select Amount FROM abc WHERE ID='10'");
            ResultSet rst = pst.executeQuery();

            while (rst.next()){
                temp = rst.getFloat("Amount");
            }
            temp+=float2;
            System.out.println(temp);
            PreparedStatement pst1=con.prepareStatement("Update abc set Amount='"+temp+"' WHERE ID='10'");
            pst1.executeUpdate();
        }
        catch (Exception ep) {
        ep.printStackTrace();
        }
        }
    }
class test
{
    public static void main(String []args)
    {
        Practice pc=new Practice();
    }
}

