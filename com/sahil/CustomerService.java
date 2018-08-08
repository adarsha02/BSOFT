package com.sahil;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class CustomerService extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JPanel createFramePanel;
    private JPanel deleteFramePanel;
    private JPanel deleteFrameSubPanel;
    private JTextField createcitizeshipnumbertextfield;
    private JTextField createcontactnumbertextfield;
    private JTextField createmiddlenametextfield;
    private JTextField createfirstnametextfield;
    private JTextField createlastnametextfield;
    private JTextField createdistricttextfield;
    private JTextField createcitytextfield;
    private JTextField createwardnumbertextfield;
    private JRadioButton createmaleradiobutton;
    private JRadioButton createfemaleradiobutton;
    private ButtonGroup createradioGroup;
    private JDateChooser createdatechooser;
    private JTextField deleteclientidtextfield;
    private JTable deletecustomerinfotable;
    private JTable detailtable;
    private JScrollPane deletetablescrollpane;
    private JScrollPane detailtablescrollpane;
    private JLabel deleteiconlogo;
    //create frame and design in it
    public CustomerService() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 736, 541);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Customer Service");
        setResizable(false);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(6, 6, 714, 489);
        contentPane.add(tabbedPane);

        JPanel CreatePanel = new JPanel();
        tabbedPane.addTab("Create", null, CreatePanel, null);
        CreatePanel.setLayout(null);

        //createframepanel design
        createFramePanel = new JPanel();
        createFramePanel.setVisible(true);
        createFramePanel.setBounds(0, 0, 709, 459);
        createFramePanel.setBackground(new Color(0, 102, 153));
        //framePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        createFramePanel.setLayout(null);
        CreatePanel.add(createFramePanel);

        JLabel createclientnamelabel = new JLabel("Client name :");
        createclientnamelabel.setForeground(Color.WHITE);
        createclientnamelabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createclientnamelabel.setBounds(36, 135, 136, 28);
        createFramePanel.add(createclientnamelabel);

        JLabel createdateofbirthlabel = new JLabel("Date of Birth :");
        createdateofbirthlabel.setForeground(Color.WHITE);
        createdateofbirthlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createdateofbirthlabel.setBounds(28, 188, 119, 28);
        createFramePanel.add(createdateofbirthlabel);

        JLabel createcitizenshiplabel = new JLabel("Citizenship no :");
        createcitizenshiplabel.setForeground(Color.WHITE);
        createcitizenshiplabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createcitizenshiplabel.setBounds(18, 319, 129, 28);
        createFramePanel.add(createcitizenshiplabel);

        JLabel createcontactnumberlabel = new JLabel("Contact no :");
        createcontactnumberlabel.setForeground(Color.WHITE);
        createcontactnumberlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createcontactnumberlabel.setBounds(37, 358, 110, 28);
        createFramePanel.add(createcontactnumberlabel);

        JButton createbutton = new JButton("Create");

        createbutton.setForeground(new Color(0, 153, 153));
        createbutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        createbutton.setBounds(101, 412, 119, 35);
        createFramePanel.add(createbutton);

        createcitizeshipnumbertextfield = new JTextField();
        createcitizeshipnumbertextfield.setText("Citizenship Number*");
        createcitizeshipnumbertextfield.setForeground(new Color(0, 102, 153));
        createcitizeshipnumbertextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createcitizeshipnumbertextfield.setColumns(15);
        createcitizeshipnumbertextfield.setBounds(182, 320, 190, 28);
        createFramePanel.add(createcitizeshipnumbertextfield);

        createcontactnumbertextfield = new JTextField();
        createcontactnumbertextfield.setText("Contact Number*");
        createcontactnumbertextfield.setForeground(new Color(0, 102, 153));
        createcontactnumbertextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createcontactnumbertextfield.setColumns(15);
        createcontactnumbertextfield.setBounds(182, 359, 190, 28);
        createFramePanel.add(createcontactnumbertextfield);

        createmiddlenametextfield = new JTextField();
        createmiddlenametextfield.setText("Middlename");
        createmiddlenametextfield.setForeground(new Color(0, 102, 153));
        createmiddlenametextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createmiddlenametextfield.setColumns(10);
        createmiddlenametextfield.setBounds(322, 136, 106, 28);
        createFramePanel.add(createmiddlenametextfield);

        createfirstnametextfield = new JTextField();
        createfirstnametextfield.setText("Firstname*");
        createfirstnametextfield.setForeground(new Color(0, 102, 153));
        createfirstnametextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createfirstnametextfield.setColumns(10);
        createfirstnametextfield.setBounds(182, 136, 106, 28);
        createFramePanel.add(createfirstnametextfield);

        createlastnametextfield = new JTextField();
        createlastnametextfield.setText("Lastname*");
        createlastnametextfield.setForeground(new Color(0, 102, 153));
        createlastnametextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createlastnametextfield.setColumns(15);
        createlastnametextfield.setBounds(477, 136, 106, 28);
        createFramePanel.add(createlastnametextfield);

        JLabel createsexlabel = new JLabel("Sex :");
        createsexlabel.setForeground(Color.WHITE);
        createsexlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createsexlabel.setBounds(101, 227, 57, 28);
        createFramePanel.add(createsexlabel);

        createmaleradiobutton = new JRadioButton("Male",true);
        createmaleradiobutton.setBackground(new Color(0, 102, 153));
        createmaleradiobutton.setForeground(new Color(255, 255, 255));
        createmaleradiobutton.setFont(new Font("Tahoma", Font.ITALIC, 18));
        createmaleradiobutton.setBounds(182, 230, 83, 23);
        createFramePanel.add(createmaleradiobutton);

        createfemaleradiobutton = new JRadioButton("Female", false);
        createfemaleradiobutton.setForeground(Color.WHITE);
        createfemaleradiobutton.setFont(new Font("Tahoma", Font.ITALIC, 18));
        createfemaleradiobutton.setBackground(new Color(0, 102, 153));
        createfemaleradiobutton.setBounds(285, 230, 83, 23);
        createFramePanel.add(createfemaleradiobutton);

        JLabel createaddresslabel = new JLabel("Address :");
        createaddresslabel.setForeground(Color.WHITE);
        createaddresslabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createaddresslabel.setBounds(68, 266, 76, 28);
        createFramePanel.add(createaddresslabel);

        createdistricttextfield = new JTextField();
        createdistricttextfield.setText("District*");
        createdistricttextfield.setToolTipText("");
        createdistricttextfield.setForeground(new Color(0, 102, 153));
        createdistricttextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createdistricttextfield.setColumns(20);
        createdistricttextfield.setBounds(182, 267, 142, 28);
        createFramePanel.add(createdistricttextfield);

        createcitytextfield = new JTextField();
        createcitytextfield.setToolTipText("");
        createcitytextfield.setText("City*");
        createcitytextfield.setForeground(new Color(0, 102, 153));
        createcitytextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createcitytextfield.setColumns(20);
        createcitytextfield.setBounds(361, 267, 97, 28);
        createFramePanel.add(createcitytextfield);

        createwardnumbertextfield = new JTextField();
        createwardnumbertextfield.setToolTipText("");
        createwardnumbertextfield.setText("Ward*");
        createwardnumbertextfield.setForeground(new Color(0, 102, 153));
        createwardnumbertextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        createwardnumbertextfield.setColumns(20);
        createwardnumbertextfield.setBounds(495, 267, 76, 28);
        createFramePanel.add(createwardnumbertextfield);

        JButton createbackbutton = new JButton("Back");
        createbackbutton.setForeground(new Color(0, 153, 153));
        createbackbutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        createbackbutton.setBounds(412, 412, 119, 35);
        createFramePanel.add(createbackbutton);

        JLabel createregisterclientslabel = new JLabel("Register Client");
        createregisterclientslabel.setForeground(Color.WHITE);
        createregisterclientslabel.setFont(new Font("Sylfaen", Font.PLAIN, 60));
        createregisterclientslabel.setBounds(144, 22, 398, 91);
        createFramePanel.add(createregisterclientslabel);

        JButton createresetbutton = new JButton("Reset");
        createresetbutton.setForeground(new Color(0, 153, 153));
        createresetbutton.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        createresetbutton.setBounds(262, 412, 119, 35);
        createFramePanel.add(createresetbutton);

        createdatechooser = new JDateChooser();
        Date tempdate = new Date();
        createdatechooser.setDate(tempdate);
        createdatechooser.setBounds(182, 188, 205, 28);
        createFramePanel.add(createdatechooser);
        createradioGroup = new ButtonGroup();
        createradioGroup.add(createmaleradiobutton);
        createradioGroup.add(createfemaleradiobutton);

        //deletepanel design
        JPanel DeletePanel = new JPanel();
        DeletePanel.setLayout(null);
        tabbedPane.addTab("Delete", null, DeletePanel, null);
        //createframepanel design
        //createframepanel design

        deleteFramePanel = new JPanel();
        deleteFramePanel.setVisible(true);
        deleteFramePanel.setBounds(0, 0, 709, 459);
        deleteFramePanel.setBackground(new Color(0, 102, 153));
        //framePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        deleteFramePanel.setLayout(null);
        DeletePanel.add(deleteFramePanel);
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(235, 393, 474, 2);
        deleteFramePanel.add(separator_3);


        String[] columns={"Account Number","First Name","Middle Name","Last Name","Date of Birth","District","City","Ward","Citizenship Number","Contact Number","isDeleted","Amount"};
        Object [][] data={};
        deletecustomerinfotable = new JTable(data,columns);
        deletetablescrollpane = new JScrollPane(deletecustomerinfotable);
        deletetablescrollpane.setBounds(241, 5, 462, 385);
        deleteFramePanel.add(deletetablescrollpane);
        deletecustomerinfotable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        deletecustomerinfotable.getColumnModel().getColumn(0).setPreferredWidth(100);
        deletecustomerinfotable.getColumnModel().getColumn(1).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(2).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(3).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(4).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(5).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(6).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(7).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(8).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(9).setPreferredWidth(200);
        deletecustomerinfotable.getColumnModel().getColumn(10).setPreferredWidth(200);


        deleteFrameSubPanel = new JPanel();
        deleteFrameSubPanel.setBackground(new Color(0, 153, 153));
        deleteFrameSubPanel.setBounds(0, 0, 235, 459);
        deleteFramePanel.add(deleteFrameSubPanel);
        deleteFrameSubPanel.setLayout(null);
        JLabel lblSearch = new JLabel("Search");
        lblSearch.setBounds(39, 25, 163, 62);
        deleteFrameSubPanel.add(lblSearch);
        lblSearch.setForeground(new Color(255, 255, 255));
        lblSearch.setFont(new Font("Sylfaen", Font.PLAIN, 50));

        JSeparator separator = new JSeparator();
        separator.setBounds(6, 74, 219, 2);
        deleteFrameSubPanel.add(separator);


        JLabel customerserviceaccountnumberlabel = new JLabel("Account Number:");
        customerserviceaccountnumberlabel.setBounds(10, 284, 191, 34);
        deleteFrameSubPanel.add(customerserviceaccountnumberlabel);
        customerserviceaccountnumberlabel.setForeground(Color.WHITE);
        customerserviceaccountnumberlabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));

        deleteclientidtextfield = new JTextField();
        deleteclientidtextfield.setBounds(12, 331, 219, 28);
        deleteFrameSubPanel.add(deleteclientidtextfield);
        deleteclientidtextfield.setText("Account N.O");
        deleteclientidtextfield.setForeground(new Color(0, 102, 153));
        deleteclientidtextfield.setFont(new Font("Tahoma", Font.ITALIC, 16));
        deleteclientidtextfield.setColumns(10);
        deleteclientidtextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if( deleteclientidtextfield.getText().equals("Account N.O")) {
                    deleteclientidtextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if( deleteclientidtextfield.getText().equals("")) {
                    deleteclientidtextfield.setText("Account N.O");
                }
            }
        });


        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(10, 400, 107, 35);
        deleteFrameSubPanel.add(btnSearch);
        btnSearch.setForeground(new Color(0, 153, 153));
        btnSearch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));

        deleteclientidtextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if((c==KeyEvent.VK_ENTER)) {
                           btnSearch.doClick();
                }

            }
        });

        deleteiconlogo=new JLabel("");
        deleteiconlogo.setHorizontalAlignment(SwingConstants.CENTER);
        deleteiconlogo.setIcon(new ImageIcon(getClass().getResource("/images/BSOFTLogo.png")));
        deleteiconlogo.setBounds(30,108,177,149);
        deleteFrameSubPanel.add(deleteiconlogo);


        JButton btnBack = new JButton("Back");
        btnBack.setBounds(144, 400, 93, 35);
        deleteFrameSubPanel.add(btnBack);
        btnBack.setForeground(new Color(0, 153, 153));
        btnBack.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(536, 407, 119, 35);
        deleteFramePanel.add(btnDelete);
        btnDelete.setForeground(new Color(0, 153, 153));
        btnDelete.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
        JPanel clientDetailPanel = new JPanel();
        tabbedPane.addTab("Client Detail", null, clientDetailPanel, null);
        clientDetailPanel.setLayout(null);
        detailtable = new JTable(data,columns);
        detailtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        detailtable.getColumnModel().getColumn(0).setPreferredWidth(100);
        detailtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(2).setPreferredWidth(800);
        detailtable.getColumnModel().getColumn(3).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(4).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(5).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(6).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(7).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(8).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(9).setPreferredWidth(200);
        detailtable.getColumnModel().getColumn(10).setPreferredWidth(200);
        detailtablescrollpane=new JScrollPane(detailtable);
        detailtablescrollpane.setBounds(0, 6, 708, 453);
        clientDetailPanel.add(detailtablescrollpane);
        btnBack.addActionListener(this);
        createbackbutton.addActionListener(this);
        btnSearch.addActionListener(this);
        createbutton.addActionListener(this);
        btnDelete.addActionListener(this);
        showalldetailintable();
        showallintable();
        createwardnumbertextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();

                }

            }
        });
        createcitizeshipnumbertextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();
                }

            }
        });
        createcontactnumbertextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent eee) {
                char  c= eee.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) {
                    eee.consume();

                }
            }
        });

        createfirstnametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if( createfirstnametextfield.getText().equals("Firstname*")) {
                    createfirstnametextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if( createfirstnametextfield.getText().equals("")) {
                    createfirstnametextfield.setText("Firstname*");
                }
            }
        });
        createmiddlenametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if( createmiddlenametextfield.getText().equals("Middlename")) {
                    createmiddlenametextfield.setText("");
                }
            }

        });
        createlastnametextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if( createlastnametextfield.getText().equals("Lastname*")) {
                    createlastnametextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if( createlastnametextfield.getText().equals("")) {
                    createlastnametextfield.setText("Lastname*");
                }
            }
        });

        createdistricttextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if( createdistricttextfield.getText().equals("District*")) {
                    createdistricttextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if( createdistricttextfield.getText().equals("")) {
                    createdistricttextfield.setText("District*");
                }
            }
        });
        createcitytextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if(  createcitytextfield.getText().equals("City*")) {
                    createcitytextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(  createcitytextfield.getText().equals("")) {
                    createcitytextfield.setText("City*");
                }
            }
        });
        createwardnumbertextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if( createwardnumbertextfield.getText().equals("Ward*")) {
                    createwardnumbertextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(  createwardnumbertextfield.getText().equals("")) {
                    createwardnumbertextfield.setText("Ward*");
                }
            }
        });

        createcitizeshipnumbertextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if(  createcitizeshipnumbertextfield.getText().equals("Citizenship Number*")) {
                    createcitizeshipnumbertextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(   createcitizeshipnumbertextfield.getText().equals("")) {
                    createcitizeshipnumbertextfield.setText("Citizenship Number*");
                }
            }
        });
        createcontactnumbertextfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                if(  createcontactnumbertextfield.getText().equals("Contact Number*")) {
                    createcontactnumbertextfield.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(   createcontactnumbertextfield.getText().equals("")) {
                    createcontactnumbertextfield.setText("Contact Number*");
                }
            }
        });

    }
    public void showalldetailintable()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase","root","");
            PreparedStatement pst1=connection.prepareStatement("SELECT * FROM clientpersonalinfo WHERE isdeleted='0'");
            ResultSet rst1=pst1.executeQuery();
            detailtable.setModel(DbUtils.resultSetToTableModel(rst1));
            connection.close();
        }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
    }
    public void showallintable()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase","root","");
            PreparedStatement pst1=connection.prepareStatement("SELECT * FROM clientpersonalinfo WHERE isdeleted='0'");
            ResultSet rst1=pst1.executeQuery();
            deletecustomerinfotable.setModel(DbUtils.resultSetToTableModel(rst1));
            connection.close();
        }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
    }
    public Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdatabase","root","");
        }
        catch (Exception ep)
        {
            ep.printStackTrace();
        }
        return  con;
    }
    public ArrayList<Users> ListUsers(int ValToSearch)
    {
        ArrayList<Users> userList= new ArrayList<Users>();
        PreparedStatement pst;
        ResultSet rst;
        try{
            Connection con=getConnection();
            pst=con.prepareStatement("SELECT * FROM `clientpersonalinfo` WHERE AccountNum='"+ValToSearch+"' AND isdeleted='0'");
            rst=pst.executeQuery();
            Users user;
            if(!rst.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(CustomerService.this, String.format("No Client Found For The Account Number Entered. Enter Account Number Again!"),"Database Error",JOptionPane.ERROR_MESSAGE);
                deleteclientidtextfield.setText("");
                deleteclientidtextfield.requestFocus();
                showallintable();
            }
            else {
                while (rst.next()) {
                    user = new Users(
                            rst.getInt("AccountNum"),
                            rst.getString("ClientFirstName"),
                            rst.getString("ClientMiddleName"),
                            rst.getString("ClientLastName"),
                            rst.getString("ClientSex"),
                            rst.getInt("ClientCitizenshipNum"),
                            rst.getInt("ClientContactNum"),
                            rst.getBoolean("isDeleted"),
                            rst.getDouble("ClientAmount"));
                    userList.add(user);
                }
            }

        }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
        return userList;
    }
    public void findUsers()
    {
        int tempclientid=Integer.parseInt(deleteclientidtextfield.getText());
        ArrayList<Users> users=ListUsers(tempclientid);
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"AccountNum","ClientFirstName","ClientMiddleName","ClientLastName","ClientSex","ClientCitizenshipNum","ClientContactNum","isdeleted","ClientAmount"});
        Object[] row=new Object[9];
        for(int i=0;i<users.size();i++)
        {
            row[0]=users.get(i).getAccountNum();
            row[1]=users.get(i).getClientFirstName();
            row[2]=users.get(i).getClientMiddleName();
            row[3]=users.get(i).getClientLastName();
            row[4]=users.get(i).getClientSex();
            row[5]=users.get(i).getClientCitizenshipNum();
            row[6]=users.get(i).getClientContactNum();
            row[7]=users.get(i).getisdeleted();
            row[8]=users.get(i).getClientAmount();
            model.addRow(row);
        }
        deletecustomerinfotable.setModel(model);
    }
    public void deleteUsers(int Valtosearch)
    {
        try{
            Connection con1=getConnection();
            PreparedStatement pst2=con1.prepareStatement("UPDATE clientpersonalinfo SET isdeleted='1' WHERE AccountNum='"+Valtosearch+"'");
            pst2.executeUpdate();
        }
        catch(Exception ep)
        {
            ep.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Back")) {
            Login lgn = new Login();
            lgn.setVisible(true);
            setVisible(false);
        } else if (command.equals("Create")) {
            try {
                java.sql.Date date = new java.sql.Date(createdatechooser.getDate().getTime());
                int tempwardnumber = Integer.parseInt(createwardnumbertextfield.getText());
                long tempcitizenshipnumber = Long.parseLong(createcitizeshipnumbertextfield.getText());
                long tempcontactnumber = Long.parseLong(createcontactnumbertextfield.getText());
                String tempcity = createcitytextfield.getText();
                String tempdistrict = createdistricttextfield.getText();
                ClientSqlConnection sqc = new ClientSqlConnection();

                String tempfirstname = createfirstnametextfield.getText();
                String templastname = createlastnametextfield.getText();
                String tempmiddlename = createmiddlenametextfield.getText();
                String stempwardnumber = createwardnumbertextfield.getText();
                String stempcitizenshipnumber = createcitizeshipnumbertextfield.getText();
                String stempcontactnum = createcontactnumbertextfield.getText();
                if (tempfirstname.equals("") && templastname.equals("") && tempcity.equals("") && tempdistrict.equals("")) {
                    JOptionPane.showMessageDialog(CustomerService.this, String.format("User Entry fields are left empty"),"Warning",JOptionPane.WARNING_MESSAGE);
                    createfirstnametextfield.requestFocus();
                } else if (tempfirstname.equals("")) {
                    JOptionPane.showMessageDialog(CustomerService.this, String.format("FirstName field left empty","Warning",JOptionPane.WARNING_MESSAGE));
                    createfirstnametextfield.requestFocus();
                } else if (templastname.equals("")) {
                    JOptionPane.showMessageDialog(CustomerService.this, String.format("LastName field left empty","Warning",JOptionPane.WARNING_MESSAGE));
                    createlastnametextfield.requestFocus();
                } else if (tempcity.equals("")) {
                    JOptionPane.showMessageDialog(CustomerService.this, String.format("City field left empty","Warning",JOptionPane.WARNING_MESSAGE));
                    createcitytextfield.requestFocus();
                } else if (tempdistrict.equals("")) {
                    JOptionPane.showMessageDialog(CustomerService.this, String.format("District field left empty","Warning",JOptionPane.WARNING_MESSAGE));
                    createdistricttextfield.requestFocus();
                } else {
                    if (createmaleradiobutton.isSelected()) {
                        sqc.insertintodatabase(tempfirstname, tempmiddlename, templastname, date, "Male", tempcity,
                                tempdistrict, tempwardnumber, tempcitizenshipnumber, tempcontactnumber);
                        JOptionPane.showMessageDialog(CustomerService.this, String.format("Client Registration Complete. All Values Added Into Database"));
                        showallintable();
                        showalldetailintable();
                    } else {
                        sqc.insertintodatabase(createfirstnametextfield.getText(), createmiddlenametextfield.getText(), createlastnametextfield.getText(), date, "Female", createcitytextfield.getText(),
                                createdistricttextfield.getText(), tempwardnumber, tempcitizenshipnumber, tempcontactnumber);
                        JOptionPane.showMessageDialog(CustomerService.this, String.format("Client Registration Complete. All Values Added Into Database"));
                        createfirstnametextfield.setText(" ");
                        createmiddlenametextfield.setText("");
                        createlastnametextfield.setText("");
                        createcitytextfield.setText("");
                        createdistricttextfield.setText("");
                        createfemaleradiobutton.setEnabled(true);
                        createmaleradiobutton.setEnabled(true);
                        createwardnumbertextfield.setText("");
                        createcitizeshipnumbertextfield.setText("");
                        createcontactnumbertextfield.setText("");
                        createdatechooser.setDate(null);
                        createmaleradiobutton.setEnabled(true);
                        createfemaleradiobutton.setEnabled(false);
                        createfirstnametextfield.requestFocus();
                        showallintable();
                        showalldetailintable();
                    }
                }
            } catch (Exception ep) {
                ep.printStackTrace();
                JOptionPane.showMessageDialog(CustomerService.this, String.format("PLEASE FILL OUT ALL REQUIRED FIELD"),"Warning",JOptionPane.WARNING_MESSAGE);
            }
        } else if (command.equals("Reset")) {
            createfirstnametextfield.setText(" ");
            createmiddlenametextfield.setText("");
            createlastnametextfield.setText("");
            createcitytextfield.setText("");
            createdistricttextfield.setText("");
            createfemaleradiobutton.setEnabled(true);
            createmaleradiobutton.setEnabled(true);
            createwardnumbertextfield.setText("");
            createcitizeshipnumbertextfield.setText("");
            createcontactnumbertextfield.setText("");
            createdatechooser.setDate(null);
            createmaleradiobutton.setEnabled(true);
            createfemaleradiobutton.setEnabled(false);
        }else if(command.equals("Search"))
        {
            if(deleteclientidtextfield.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, String.format("The Account Number field is left empty. Please Enter a value"),"Warning",JOptionPane.WARNING_MESSAGE);
                deleteclientidtextfield.requestFocus();
            }
            else{
                findUsers();
                deleteclientidtextfield.requestFocus();
            }
        }
        else if(command.equals("Delete")) {
            int deleteconfirmation = JOptionPane.showConfirmDialog(this, String.format("Are you sure you want to delete"));
            if (deleteconfirmation == JOptionPane.YES_OPTION) {
                int tempid = Integer.parseInt(deleteclientidtextfield.getText());
                deleteUsers(tempid);
                showallintable();
                showalldetailintable();
                deleteclientidtextfield.setText("");
                deleteclientidtextfield.requestFocus();
            } else if (deleteconfirmation == JOptionPane.NO_OPTION) {
                findUsers();
                deleteclientidtextfield.requestFocus();
            }
            else if(deleteconfirmation==JOptionPane.CANCEL_OPTION)
            {
                showallintable();
                deleteclientidtextfield.requestFocus();
            }
        }
    }

}
