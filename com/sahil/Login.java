package com.sahil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame
{
    public JTextField loginusernametextfield;
    public JPasswordField loginpasswordtextfield;
    public JButton loginexitbtn1;
    public JButton loginbtn1;
    public Login() {
        setAlwaysOnTop(true);
        setTitle("Log In");
        setResizable(false);
        getContentPane().setBackground(new Color(0, 102, 153));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 723, 498);
        getContentPane().setLayout(null);
        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(0, 153, 153));
        subPanel.setBounds(0, 0, 192, 469);
        getContentPane().add(subPanel);
        subPanel.setLayout(null);

        JLabel logoBsoftLabel = new JLabel("");
        logoBsoftLabel.setIcon(new ImageIcon("B:\\BSoft\\src\\com\\sahil\\BSOFTLogo.png"));
        logoBsoftLabel.setBounds(7, 144, 156, 152);
        subPanel.add(logoBsoftLabel);

        JLabel lblBsoft = new JLabel("BSOFT");
        lblBsoft.setHorizontalAlignment(SwingConstants.CENTER);
        lblBsoft.setForeground(new Color(255, 255, 255));
        lblBsoft.setFont(new Font("Sylfaen", Font.PLAIN, 50));
        lblBsoft.setBounds(6, 36, 157, 55);
        subPanel.add(lblBsoft);

        JLabel lblLogIn = new JLabel("Log In");
        lblLogIn.setForeground(new Color(255, 255, 255));
        lblLogIn.setFont(new Font("Sylfaen", Font.PLAIN, 50));
        lblLogIn.setBounds(359, 36, 171, 61);
        getContentPane().add(lblLogIn);
        JPanel secondSubPanel = new JPanel();
        secondSubPanel.setBorder(new LineBorder(new Color(0, 153, 153), 10));
        secondSubPanel.setBackground(new Color(255, 255, 255));
        secondSubPanel.setBounds(249, 121, 433, 293);
        getContentPane().add(secondSubPanel);
        secondSubPanel.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(new Color(0, 102, 153));
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblUsername.setBounds(21, 26, 189, 33);
        secondSubPanel.add(lblUsername);

        loginusernametextfield = new JTextField("Username");
        loginusernametextfield.setFont(new Font("Sylfaen", Font.PLAIN, 23));
        loginusernametextfield.setText("");
        loginusernametextfield.setBackground(new Color(255, 255, 255));
        loginusernametextfield.setForeground(new Color(52, 73, 94));
        loginusernametextfield.setBounds(56, 66, 214, 26);
        loginusernametextfield.setBorder(null);
        secondSubPanel.add(loginusernametextfield);
        loginusernametextfield.setColumns(10);

        loginpasswordtextfield = new JPasswordField("");
        loginpasswordtextfield.setBackground(new Color(255, 255, 255));
        loginpasswordtextfield.setToolTipText("");
        loginpasswordtextfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginpasswordtextfield.setForeground(new Color(52, 73, 94));
        loginpasswordtextfield.setBounds(65, 160, 225, 26);
        loginpasswordtextfield.setText("");
        loginpasswordtextfield.setBorder(null);
        secondSubPanel.add(loginpasswordtextfield);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(new Color(0, 102, 153));
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblPassword.setBounds(21, 115, 189, 33);
        secondSubPanel.add(lblPassword);

        JSeparator usernameSeparator = new JSeparator();
        usernameSeparator.setBackground(new Color(0, 102, 153));
        usernameSeparator.setBounds(56, 90, 214, 2);
        secondSubPanel.add(usernameSeparator);

        JSeparator passwordSeparator = new JSeparator();
        passwordSeparator.setBackground(new Color(0, 102, 153));
        passwordSeparator.setBounds(56, 184, 214, 2);
        secondSubPanel.add(passwordSeparator);
        loginbtn1=new JButton("LOGIN");
        loginbtn1.setBounds(149, 231, 115, 33);
        secondSubPanel.add(loginbtn1);
        loginbtn1.setForeground(new Color(0, 102, 153));
        loginbtn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        loginexitbtn1 = new JButton("EXIT");
        loginexitbtn1.setBounds(283, 231, 115, 33);
        secondSubPanel.add(loginexitbtn1);

        loginusernametextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if((c==KeyEvent.VK_ENTER)) {
                    loginpasswordtextfield.grabFocus();
                }

            }
        });

        loginpasswordtextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if((c==KeyEvent.VK_ENTER)) {
                   loginbtn1.doClick();
                }

            }
        });

        loginexitbtn1.setForeground(new Color(0, 102, 153));
        loginexitbtn1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel labelCopyright = new JLabel("Copyright © 2018 BSOFT. All rights reserved.");
        labelCopyright.setForeground(Color.WHITE);
        labelCopyright.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        labelCopyright.setBounds(330, 436, 305, 27);
        getContentPane().add(labelCopyright);
        loginusernametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if(loginusernametextfield.getText().equals("Username")) {
                    loginusernametextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(loginusernametextfield.getText().equals("")) {
                    loginusernametextfield.setText("Username");
                }
            }
        });
        loginbtn1.addActionListener(this::actionPerformed);
        loginexitbtn1.addActionListener(this::actionPerformed);
        loginpasswordtextfield.requestFocus(false);
    }
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("LOGIN")) {
            String tempusername = loginusernametextfield.getText();
            String temppassword = loginpasswordtextfield.getText();

            if (loginusernametextfield.getText().equals("") && loginpasswordtextfield.getText().equals("")) {

                JOptionPane.showMessageDialog(Login.this, String.format("Username and Password field left empty"),"All fields left empty",JOptionPane.ERROR_MESSAGE);
                loginusernametextfield.requestFocus();//sets the focus back to username field
            } else if (tempusername.equals("")) {
                JOptionPane.showMessageDialog(Login.this, String.format("Username field left empty"),"Username Empty",JOptionPane.ERROR_MESSAGE);
                loginusernametextfield.requestFocus();// sets the focus back to username field
            } else if (temppassword.equals("")) {
                JOptionPane.showMessageDialog(Login.this, String.format("Password field left empty"),"Password Empty",JOptionPane.ERROR_MESSAGE);
                loginpasswordtextfield.requestFocus();// sets the focus back to password field

            } else {
                LoginSqlConnection msc = new LoginSqlConnection();
                int returnvalue;
                returnvalue = msc.authenticateemployees(getusername(), getpassword());
                switch (returnvalue) {
                    case 1:
                        admin adn = new admin();
                        setVisible(false);
                        break;
                    case 2:
                        Manager mgr = new Manager();
                        setVisible(false);
                        break;
                    case 3:
                        Teller tllr = new Teller();
                        setVisible(false);
                        break;
                    case 4:
                        SystemAdmin san = new SystemAdmin();
                        san.setVisible(true);
                        setVisible(false);
                        break;
                    case 5:
                        CustomerService cse = new CustomerService();
                        cse.setVisible(true);
                        setVisible(false);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(Login.this, String.format("Username/Password incorrect"),"Incorrect Username/Passowrd",JOptionPane.ERROR_MESSAGE);
                        loginpasswordtextfield.setText("");
                        loginusernametextfield.setText("");
                        loginusernametextfield.requestFocus();
                }
            }
        }
    }
    public String getusername()
    {
        return loginusernametextfield.getText();
    }
    public String getpassword()
    {
        return loginpasswordtextfield.getText();
    }
}
