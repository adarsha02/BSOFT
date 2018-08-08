package com.sahil;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Teller extends JFrame {
    private JPanel FramePanel;
    private  JPanel ClientInfoPanel ;
    private JTable tellerclientinfotable;
    private JPanel clientinfopanel;
    private JSeparator tableSeperator;
    private JButton tellertranscationbutton;
    private JLabel lblNewLabel;
    private JTextField tellerfirstnametextfield;
    private JTextField tellermiddlenametextfield;
    private JTextField tellerlastnametextfield;
    private JTextField telleraccountnumbertextfield;
    public  Long acc_no;
    public Teller()
    {
        setAlwaysOnTop(true);
        itscustomerdetailframe();
    }
    public Long getaccno()
    {
        return acc_no;
    }
    public void itscustomerdetailframe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 745, 541);
        FramePanel = new JPanel();
        FramePanel.setLayout(null);
        setContentPane(FramePanel);
        FramePanel.setLayout(null);
        ClientInfoPanel = new JPanel();
        setTitle("Teller");
        FramePanel.add(ClientInfoPanel);
        ClientInfoPanel.setLayout(null);
        ClientInfoPanel.setBounds(0, 0, 723, 541);
        ClientInfoPanel.setBackground(new Color(0, 102, 153));

        clientinfopanel = new JPanel();
        clientinfopanel.setBackground(new Color(0, 153, 153));
        clientinfopanel.setBounds(0, 0, 236, 501);
        ClientInfoPanel.add(clientinfopanel);
        clientinfopanel.setLayout(null);

        JButton searchBtn = new JButton("Search");

        searchBtn.setForeground(new Color(0, 153, 153));
        searchBtn.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        searchBtn.setBounds(111, 444, 119, 35);
        clientinfopanel.add(searchBtn);

        JLabel labelEmployeeID = new JLabel(" Enter Client Info");
        labelEmployeeID.setBounds(6, 207, 191, 34);
        clientinfopanel.add(labelEmployeeID);
        labelEmployeeID.setForeground(Color.WHITE);
        labelEmployeeID.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));

        lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon("B:\\BSoft\\src\\com\\sahil\\BSOFTLogo.png"));
        lblNewLabel.setBounds(38, 23, 146, 149);
        clientinfopanel.add(lblNewLabel);

        tellerfirstnametextfield = new JTextField();
        tellerfirstnametextfield.setText(" First Name");
        tellerfirstnametextfield.setForeground(new Color(0, 102, 51));
        tellerfirstnametextfield.setFont(new Font("Tahoma", Font.ITALIC, 13));
        tellerfirstnametextfield.setColumns(10);
        tellerfirstnametextfield.setBorder(null);
        tellerfirstnametextfield.setBackground(new Color(255, 255, 255));
        tellerfirstnametextfield.setBounds(16, 253, 214, 35);
        clientinfopanel.add(tellerfirstnametextfield);

        tellermiddlenametextfield = new JTextField();
        tellermiddlenametextfield.setHorizontalAlignment(SwingConstants.LEFT);
        tellermiddlenametextfield.setText(" Middle Name");
        tellermiddlenametextfield.setForeground(new Color(0, 102, 102));
        tellermiddlenametextfield.setFont(new Font("Tahoma", Font.ITALIC, 13));
        tellermiddlenametextfield.setColumns(10);
        tellermiddlenametextfield.setBorder(null);
        tellermiddlenametextfield.setBackground(new Color(255, 255, 255));
        tellermiddlenametextfield.setBounds(16, 298, 214, 35);
        clientinfopanel.add(tellermiddlenametextfield);

        tellerlastnametextfield = new JTextField();
        tellerlastnametextfield.setText(" Last Name");
        tellerlastnametextfield.setForeground(new Color(0, 102, 51));
        tellerlastnametextfield.setFont(new Font("Tahoma", Font.ITALIC, 12));
        tellerlastnametextfield.setColumns(10);
        tellerlastnametextfield.setBorder(null);
        tellerlastnametextfield.setBackground(new Color(255, 255, 255));
        tellerlastnametextfield.setBounds(16, 339, 214, 35);
        clientinfopanel.add(tellerlastnametextfield);

        JLabel warningText = new JLabel("");
        warningText.setForeground(Color.RED);
        warningText.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
        warningText.setBounds(12, 381, 218, 14);
        clientinfopanel.add(warningText);

        telleraccountnumbertextfield = new JTextField();
        telleraccountnumbertextfield.setText(" Account Number");
        telleraccountnumbertextfield.setForeground(new Color(0, 102, 51));
        telleraccountnumbertextfield.setFont(new Font("Tahoma", Font.ITALIC, 12));
        telleraccountnumbertextfield.setColumns(10);
        telleraccountnumbertextfield.setBorder(null);
        telleraccountnumbertextfield.setBackground(new Color(255, 255, 255));
        telleraccountnumbertextfield.setBounds(16, 397, 214, 35);
        clientinfopanel.add(telleraccountnumbertextfield);

        tableSeperator = new JSeparator();
        tableSeperator.setBounds(234, 438, 493, 2);
        ClientInfoPanel.add(tableSeperator);

        tellertranscationbutton = new JButton("Transaction");
        tellertranscationbutton.setBounds(417, 450, 138, 35);
        ClientInfoPanel.add(tellertranscationbutton);
        tellertranscationbutton.setForeground(new Color(0, 102, 153));
        tellertranscationbutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));

        String[] columns= {
                "AccountNum","ClientFirstName","ClientMiddleName","ClientLastName","CitizenshipNum","ClientAmount"
        };
        Object[][] data= {};
        tellerclientinfotable = new JTable(data,columns);
        tellerclientinfotable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tellerclientinfotable.getColumnModel().getColumn(0).setPreferredWidth(50);
        tellerclientinfotable.getColumnModel().getColumn(1).setPreferredWidth(300);
        tellerclientinfotable.getColumnModel().getColumn(2).setPreferredWidth(300);
        tellerclientinfotable.getColumnModel().getColumn(3).setPreferredWidth(300);
        tellerclientinfotable.getColumnModel().getColumn(4).setPreferredWidth(300);
        tellerclientinfotable.getColumnModel().getColumn(5).setPreferredWidth(300);

        JScrollPane scrollPane = new JScrollPane(tellerclientinfotable);
        scrollPane.setBounds(248, 21, 455, 405);
        ClientInfoPanel.add(scrollPane);
        JButton ExitButton = new JButton("Log Out");
        ExitButton.setForeground(new Color(0, 102, 153));
        ExitButton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
        ExitButton.setBounds(572, 452, 119, 35);
        ClientInfoPanel.add(ExitButton);
        telleraccountnumbertextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();
                    warningText.setText("** Enter the numeric value **");
                }
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    warningText.setText("");
                }
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int result=JOptionPane.showConfirmDialog(Teller.this,"Are you sure? ","Confirm Logout",JOptionPane.OK_CANCEL_OPTION);
                if(result==0)
                {
                    Login lg=new Login();
                    lg.setVisible(true);
                    setVisible(false);
                }
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchindatabase();
            }
        });
        tellertranscationbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ee) {
                String firstname = tellerfirstnametextfield.getText();
                String lastname= tellerlastnametextfield.getText();
                if ((telleraccountnumbertextfield.getText().equals("")) && firstname.equals("") && lastname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER NAME AND ACCOUNT NUMBER"));
                    tellerfirstnametextfield.requestFocus();
                }
                else if (telleraccountnumbertextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER ACCOUNT NUMBER"));
                    telleraccountnumbertextfield.requestFocus();
                }
                else if(firstname.equals("") && lastname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER THE NAME"));
                    tellerfirstnametextfield.requestFocus();
                }
                else if(firstname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER FIRST NAME"));
                    tellerfirstnametextfield.requestFocus();
                }
                else if(lastname.equals("")) {
                    JOptionPane.showMessageDialog(Teller.this, String.format("PLEASE ENTER LAST NAME"));
                    tellerlastnametextfield.requestFocus();
                }

                else {

                    checkAccountNumber();
                }
            }
        });

        tellerfirstnametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if(tellerfirstnametextfield.getText().equals(" First Name")) {
                    tellerfirstnametextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tellerfirstnametextfield.getText().equals("")) {
                    tellerfirstnametextfield.setText(" First Name");
                }
            }
        });

        tellermiddlenametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg1) {
                if(tellermiddlenametextfield.getText().equals(" Middle Name")) {
                    tellermiddlenametextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent ee) {
                if(tellermiddlenametextfield.getText().equals("")) {
                    tellermiddlenametextfield.setText("");
                }
            }
        });
        tellerlastnametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg1) {
                if(tellerlastnametextfield.getText().equals(" Last Name")) {
                    tellerlastnametextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent ee) {
                if(tellerlastnametextfield.getText().equals("")) {
                    tellerlastnametextfield.setText(" Last Name");
                }
            }
        });
        telleraccountnumbertextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg1) {
                if(telleraccountnumbertextfield.getText().equals(" Account Number")) {
                    telleraccountnumbertextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent ee) {
                if(telleraccountnumbertextfield.getText().equals("")) {
                    telleraccountnumbertextfield.setText(" Account Number");
                }
            }
        });
        setVisible(true);
        showallintable();
    }
    public Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
        }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
        return con;
    }
    public void showallintable()
    {
        try{
            Connection connection=getConnection();
            PreparedStatement pst=connection.prepareStatement("Select AccountNum,ClientFirstName,ClientMiddleName," +
                    "ClientLastName,ClientCitizenshipNum,ClientAmount from clientpersonalinfo where isdeleted='0'");
            ResultSet rst=pst.executeQuery();
            tellerclientinfotable.setModel(DbUtils.resultSetToTableModel(rst));
            rst.close();
            connection.close();
            }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
    }
    public void searchindatabase()
    {
        int tempaccountnum=0;
        try{
            Connection connection=getConnection();
            try
            {
                tempaccountnum = Integer.parseInt(telleraccountnumbertextfield.getText());
            }
            catch (Exception ep)
            {
                JOptionPane.showMessageDialog(Teller.this,"Please Enter valid datatype(INTEGER) in Account Textfield.","Error",JOptionPane.ERROR_MESSAGE);
            }

            PreparedStatement pst= connection.prepareStatement("Select AccountNum,ClientFirstName,ClientMiddleName," +
                    "ClientLastName,ClientCitizenshipNum,ClientAmount from clientpersonalinfo where isdeleted='0' AND AccountNum='"+tempaccountnum+"'");
            ResultSet rst=pst.executeQuery();
            if(!rst.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(Teller.this, String.format("No Client Found For The Client Details Entered. Enter Client Details Again!"),"Database Error",JOptionPane.ERROR_MESSAGE);
                tellerfirstnametextfield.setText("");
                tellerlastnametextfield.setText("");
                tellermiddlenametextfield.setText("");
                telleraccountnumbertextfield.setText("");
                tellerfirstnametextfield.requestFocus();
                showallintable();
            }
            else{
                tellerclientinfotable.setModel(DbUtils.resultSetToTableModel(rst));
            }
            }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
    }

    public void checkAccountNumber() {
        try {
            String firstname = tellerfirstnametextfield.getText();
            Connection con=getConnection();
            int accountnumber=Integer.parseInt(telleraccountnumbertextfield.getText());
            PreparedStatement pst2 = con.prepareStatement
                    ("Select ClientFirstName FROM clientpersonalinfo where isDeleted='0' AND AccountNum='"+accountnumber+"'");
            ResultSet rst2 =pst2.executeQuery();
            if (rst2.next()) {
                System.out.println("entered the while loop" + rst2.getString("ClientFirstName"));
                if (firstname.equals(rst2.getString("ClientFirstName"))) {
                    Teller2 ts = new Teller2(accountnumber);
                    ts.setVisible(true);
                    setVisible(false);
                    System.out.println("successful !!");
                }
                else {
                    JOptionPane.showMessageDialog(Teller.this, String.format("First name doesn't match with the provided acc number"));
                }
            }
            else {
                JOptionPane.showMessageDialog(Teller.this, String.format("Please provide valid information"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}