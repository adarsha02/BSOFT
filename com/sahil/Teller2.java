package com.sahil;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Teller2 extends JFrame {

    private JPanel framePanel;
    private JPanel frameSubPanel;
    private JTextField depositeTextfield;
    private JTextField withdrawTextfield;
    private int received_acc_from_TellerFirst;
    private JLabel TellerSecondLabel1;
    private JLabel ClientName;
    private JLabel contact;
    private JLabel dob ;
    private JLabel city;
    private JLabel sx;
    private JLabel warningTextfiled;
    private JComboBox comboBox;



    /**
     * Launch the application.
     */
    public Teller2(int a) {
        received_acc_from_TellerFirst = a;
        setAlwaysOnTop(true);
        itstransactionframe();
        topinfo();
        itsotherdetail();
    }

    public void itstransactionframe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 745, 541);
        framePanel = new JPanel();
        framePanel.setBackground(new Color(0, 102, 153));
        //framePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(framePanel);
        framePanel.setLayout(null);

        frameSubPanel = new JPanel();
        frameSubPanel.setBackground(new Color(0, 153, 153));
        frameSubPanel.setBounds(0, 0, 274, 502);
        framePanel.add(frameSubPanel);
        frameSubPanel.setLayout(null);

        JLabel lblClientInfo = new JLabel("Client Info ");
        lblClientInfo.setForeground(Color.WHITE);
        lblClientInfo.setFont(new Font("Sylfaen", Font.PLAIN, 30));
        lblClientInfo.setBounds(5, 227, 191, 34);
        frameSubPanel.add(lblClientInfo);

        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        lblName.setBounds(5, 286, 67, 25);
        frameSubPanel.add(lblName);

        JLabel lblDateOfBirth = new JLabel("Date of birth :");
        lblDateOfBirth.setForeground(Color.WHITE);
        lblDateOfBirth.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        lblDateOfBirth.setBounds(5, 323, 121, 25);
        frameSubPanel.add(lblDateOfBirth);

        JLabel lblCity = new JLabel("Sex :");
        lblCity.setForeground(Color.WHITE);
        lblCity.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        lblCity.setBounds(5, 364, 53, 25);
        frameSubPanel.add(lblCity);

        JLabel lblContact = new JLabel("Contact :");
        lblContact.setForeground(Color.WHITE);
        lblContact.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        lblContact.setBounds(5, 445, 87, 25);
        frameSubPanel.add(lblContact);

        JSeparator separator = new JSeparator();
        separator.setBounds(5, 254, 141, 2);
        frameSubPanel.add(separator);

        JLabel lblSex = new JLabel("City :");
        lblSex.setForeground(Color.WHITE);
        lblSex.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
        lblSex.setBounds(5, 408, 53, 25);
        frameSubPanel.add(lblSex);

        JLabel city = new JLabel();
        city.setForeground(Color.WHITE);
        city.setFont(new Font("Tahoma", Font.ITALIC, 16));
        city.setBounds(59, 413, 215, 20);
        frameSubPanel.add(city);

        JLabel TellerSecondLabel1 = new JLabel();
        TellerSecondLabel1.setForeground(Color.WHITE);
        TellerSecondLabel1.setFont(new Font("Tahoma", Font.PLAIN, 34));
        TellerSecondLabel1.setBounds(309, 82, 391, 56);
        framePanel.add(TellerSecondLabel1);

        JLabel labelHelp = new JLabel("Help");
        labelHelp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

            }
        });
        labelHelp.setForeground(Color.WHITE);
        labelHelp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        labelHelp.setBounds(680, 6, 43, 25);
        labelHelp.setCursor(new Cursor(HAND_CURSOR));
        framePanel.add(labelHelp);

        JSeparator separatorHelp = new JSeparator();
        separatorHelp.setBounds(678, 24, 35, 2);
        framePanel.add(separatorHelp);

        setVisible(true);

    }


    public void topinfo() {

        TellerSecondLabel1 = new JLabel();
        TellerSecondLabel1.setForeground(Color.WHITE);
        TellerSecondLabel1.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 34));
        TellerSecondLabel1.setBounds(286, 68, 427, 56);

        framePanel.add(TellerSecondLabel1);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 153, 153), 6));
        panel.setBackground(Color.WHITE);
        panel.setBounds(309, 171, 391, 282);
        framePanel.add(panel);
        panel.setLayout(null);

        JLabel lblChooseOption = new JLabel("Choose option :");
        lblChooseOption.setBounds(10, 33, 153, 25);
        panel.add(lblChooseOption);
        lblChooseOption.setForeground(new Color(0, 102, 153));
        lblChooseOption.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
        String[] option = { "SELECT","WITHDRAW", "DEPOSIT" };
        comboBox = new JComboBox(option);
        comboBox.setBounds(175, 31, 193, 37);
        panel.add(comboBox);


        JLabel lblDeposit = new JLabel("Deposit :");
        lblDeposit.setBounds(73, 112, 90, 25);
        panel.add(lblDeposit);
        lblDeposit.setForeground(new Color(0, 102, 153));
        lblDeposit.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

        depositeTextfield = new JTextField();
        depositeTextfield.setBounds(175, 114, 193, 29);
        panel.add(depositeTextfield);
        depositeTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();
                    warningTextfiled.setText("***Please enter the numeric value***");
                }
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    warningTextfiled.setText("");
                }
            }
        });
        depositeTextfield.setEnabled(false);
        depositeTextfield.setColumns(10);

        JLabel lblWithdraw = new JLabel("Withdraw :");
        lblWithdraw.setBounds(55, 153, 112, 25);
        panel.add(lblWithdraw);
        lblWithdraw.setForeground(new Color(0, 102, 153));
        lblWithdraw.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));

        withdrawTextfield = new JTextField();
        withdrawTextfield.setBounds(175, 155, 193, 29);
        panel.add(withdrawTextfield);
        withdrawTextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char  c= evt.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    evt.consume();
                    warningTextfiled.setText("***Please enter the numeric value***");
                }
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    warningTextfiled.setText("");
                }
            }
        });
        withdrawTextfield.setEnabled(false);
        withdrawTextfield.setColumns(10);

        warningTextfiled = new JLabel("");
        warningTextfiled.setBounds(64, 82, 304, 18);
        panel.add(warningTextfiled);
        warningTextfiled.setForeground(new Color(0, 102, 153));
        warningTextfiled.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));

        JButton btnDeposite = new JButton("DEPOSIT");
        btnDeposite.setBounds(27, 219, 128, 29);
        panel.add(btnDeposite);
        btnDeposite.setForeground(new Color(0, 102, 153));
        btnDeposite.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btnDeposite.setEnabled(false);
        btnDeposite.setBackground(Color.LIGHT_GRAY);

        JButton btnWithdraw = new JButton("WITHDRAW");
        btnWithdraw.setBounds(188, 219, 128, 29);
        panel.add(btnWithdraw);
        btnWithdraw.setForeground(new Color(0, 102, 153));
        btnWithdraw.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        btnWithdraw.setEnabled(false);
        btnWithdraw.setBackground(Color.LIGHT_GRAY);

       JButton backBtn = new JButton("Back");
       backBtn.setBounds(603, 465, 82, 29);
        framePanel.add(backBtn);
        backBtn.setForeground(new Color(0, 102, 153));
        backBtn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
        backBtn.setEnabled(true);
        backBtn.setBackground(Color.LIGHT_GRAY);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Teller tt = new Teller();
                tt.setVisible(true);
                setVisible(false);


            }
        } );


        btnWithdraw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {



                if(comboBox.getSelectedItem().equals("WITHDRAW")) {
                    if(withdrawTextfield.getText().equals("")) {
                        JOptionPane.showMessageDialog(Teller2.this, String.format("PLEASE ENTER WITHDRAW AMOUNT"));
                        withdrawTextfield.requestFocus();
                    }
                }
                withdrawLogic();
            }
        });
        btnDeposite.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {



                if(comboBox.getSelectedItem().equals("DEPOSIT")) {

                    if(depositeTextfield.getText().equals("")) {
                        JOptionPane.showMessageDialog(Teller2.this, String.format("PLEASE ENTER DEPOSITE AMOUNT"));
                        depositeTextfield.requestFocus();
                    }
                }

                depositeLogic();
            }
        });


        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource()==comboBox) {
                    if(comboBox.getSelectedItem().equals("WITHDRAW")) {
                        btnDeposite.setEnabled(false);
                        depositeTextfield.setEnabled(false);
                        btnWithdraw.setEnabled(true);
                        withdrawTextfield.setEnabled(true);

                    }

                    else if(comboBox.getSelectedItem().equals("DEPOSIT")) {
                        btnDeposite.setEnabled(true);
                        depositeTextfield.setEnabled(true);
                        btnWithdraw.setEnabled(false);
                        withdrawTextfield.setEnabled(false);

                    }
                    else if(comboBox.getSelectedItem().equals("SELECT")) {
                        btnDeposite.setEnabled(false);
                        depositeTextfield.setEnabled(false);
                        btnWithdraw.setEnabled(false);
                        withdrawTextfield.setEnabled(false);
                    }

                }

            }
        });

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            PreparedStatement pst1 = con.prepareStatement
                    ("Select ClientAmount FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            ResultSet rst = pst1.executeQuery();

            while (rst.next()){
                float temp1 = rst.getFloat("ClientAmount");

                TellerSecondLabel1.setText("BALANCE : RS "+temp1);
            }
        }

        catch (Exception ep) {
            ep.printStackTrace();
        }




    }

    public void itsotherdetail() {

        try {
            ClientName = new JLabel();
            ClientName.setFont(new Font("Sylfaen", Font.PLAIN, 16));
            ClientName.setForeground(Color.WHITE);
            ClientName.setBounds(61, 290, 216, 25);
            frameSubPanel.add(ClientName);

            dob = new JLabel();
            dob.setForeground(Color.WHITE);
            dob.setFont(new Font("Sylfaen", Font.PLAIN, 16));
            dob.setBounds(122, 327, 155, 20);
            frameSubPanel.add(dob);

            JLabel city = new JLabel();
            city.setForeground(Color.WHITE);
            city.setFont(new Font("Sylfaen", Font.PLAIN, 16));
            city.setBounds(59, 413, 215, 20);
            frameSubPanel.add(city);



            contact = new JLabel();
            contact.setForeground(Color.WHITE);
            contact.setFont(new Font("Sylfaen", Font.PLAIN, 16));
            contact.setBounds(84, 450, 169, 20);
            frameSubPanel.add(contact);

            sx = new JLabel();
            sx.setForeground(Color.WHITE);
            sx.setFont(new Font("Sylfaen", Font.ITALIC, 16));
            sx.setBounds(72, 369, 202, 20);
            frameSubPanel.add(sx);

            JLabel logolabel = new JLabel("");
            logolabel.setBounds(50, 33, 156, 152);
            frameSubPanel.add(logolabel);
            logolabel.setIcon(new ImageIcon("B:\\BSoft\\src\\com\\sahil\\BSOFTLogo.png"));


            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            PreparedStatement pst1 = con.prepareStatement
                    ("Select ClientFirstName FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst2 = con.prepareStatement
                    ("Select ClientMiddleName FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst3 = con.prepareStatement
                    ("Select ClientLastName FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst4 = con.prepareStatement
                    ("Select ClientDateofBirth FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst5 = con.prepareStatement
                    ("Select ClientSex FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst6 = con.prepareStatement
                    ("Select ClientCity FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            PreparedStatement pst7 = con.prepareStatement
                    ("Select ClientContactNum FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");


            ResultSet rst1 = pst1.executeQuery();
            ResultSet rst2 = pst2.executeQuery();
            ResultSet rst3 = pst3.executeQuery();
            ResultSet rst4 = pst4.executeQuery();
            ResultSet rst5 = pst5.executeQuery();
            ResultSet rst6 = pst6.executeQuery();
            ResultSet rst7 = pst7.executeQuery();
            while(rst1.next() && rst2.next() && rst3.next()) {
                System.out.println("after  while loop");
                String firstname = rst1.getString("ClientFirstName");
                String middlename = rst2.getString("ClientMiddleName");
                String lastname = rst3.getString("ClientLastName");
                ClientName.setText(firstname+" "+middlename+" "+lastname);
            }
            while(rst4.next()) {
                Date dateofbirth = rst4.getDate("ClientDateofBirth");
                String dobs = dateofbirth.toString();
                dob.setText(dobs);
            }
            while(rst5.next()) {
                String sex = rst5.getString("ClientSex");
                sx.setText(sex);

            }
            while(rst6.next()) {
                String cty = rst6.getString("ClientCity");
                city.setText(cty);
            }
            while(rst7.next()) {
                Long cntc = rst7.getLong("ClientContactNum");
                String cn = cntc.toString();
                contact.setText(cn);
            }
        }

        catch (Exception ep) {
            ep.printStackTrace();
        }


    }


    public void withdrawLogic() {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            float withamount=Float.parseFloat(withdrawTextfield.getText());
            PreparedStatement pst = con.prepareStatement
                    ("Select ClientAmount FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                float temp = rst.getFloat("ClientAmount");
                if (!(temp < 301)) {
                    TellerSecondLabel1.setText("BALANCE: RS  " + temp);
                    temp -= withamount;
                    PreparedStatement pst1 = con.prepareStatement
                            ("Update clientpersonalinfo set ClientAmount='" + temp + "' WHERE AccountNum='" + received_acc_from_TellerFirst + "'");
                    pst1.executeUpdate();
                    TellerSecondLabel1.setText("BALANCE: RS" + temp);
                }
                else {
                    JOptionPane.showMessageDialog(Teller2.this, String.format("NO SUFFICIENT BALANCE"));
                }
            }
        }
        catch (Exception ep) {
            ep.printStackTrace();
        }


    }



    public void depositeLogic(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase", "root", "");
            float depoamount=Float.parseFloat(depositeTextfield.getText());
            PreparedStatement pst = con.prepareStatement
                    ("Select ClientAmount FROM clientpersonalinfo WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
            ResultSet rst = pst.executeQuery();

            while (rst.next()){
                float temp = rst.getFloat("ClientAmount");
                TellerSecondLabel1.setText("BALANCE: RS "+temp);
                temp+=depoamount;
                PreparedStatement pst1=con.prepareStatement
                        ("Update clientpersonalinfo set ClientAmount='"+temp+"' WHERE AccountNum='"+received_acc_from_TellerFirst+"'");
                pst1.executeUpdate();
                TellerSecondLabel1.setText("BALANCE: RS "+temp);
            }
        }
        catch (Exception ep) {
            ep.printStackTrace();
        }


    }
}

