package com.sahil;


//import javax.swing.GroupLayout.Alignment;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//import javax.swing.ImageIcon;


public class SplashScreen extends javax.swing.JFrame {
    public JProgressBar progressBar;

    public SplashScreen() {
        getContentPane().setForeground(new Color(0, 102, 153));
        getContentPane().setBackground(new Color(0, 102, 153));
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(516, 415));
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 102, 153), 7));
        panel.setBackground(new Color(32, 178, 170));
        panel.setBounds(10, 10, 498, 397);
        getContentPane().add(panel);
        panel.setLayout(null);
        JLabel lblLoading = new JLabel("Loading...");
        lblLoading.setForeground(new Color(0, 102, 153));
        lblLoading.setFont(new Font("Sylfaen", Font.ITALIC, 28));
        lblLoading.setBounds(178, 281, 146, 49);
        panel.add(lblLoading);

        progressBar = new JProgressBar();
        progressBar.setForeground(Color.WHITE);
        progressBar.setBounds(22, 251, 438, 27);
        panel.add(progressBar);

        JLabel lblTheBankingSolution = new JLabel("A MICROFINANCE BANKING SOLUTION");
        lblTheBankingSolution.setFont(new Font("Sylfaen", Font.BOLD, 22));
        lblTheBankingSolution.setForeground(new Color(0, 102, 153));
        lblTheBankingSolution.setBackground(new Color(0, 102, 153));
        lblTheBankingSolution.setBounds(22, 187, 453, 49);
        panel.add(lblTheBankingSolution);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon("B:\\BSoft\\src\\com\\sahil\\SplashScreenImage.png"));
        lblNewLabel.setBounds(131, 6, 233, 180);
        panel.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(255, 250, 250));
        separator.setBackground(new Color(248, 248, 255));
        separator.setBounds(20, 227, 439, 12);
        panel.add(separator);

    }

    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SplashScreen sc = new SplashScreen();
        Login lg=new Login();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }

        });
        try {
            for(int i=0;i<=100;i++){
                Thread.sleep(10);
                sc.setVisible(true);
                sc.progressBar.setValue(i);
                //    sc.percBar.setText(Integer.toString(i)+"%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.setVisible(false);
        lg.setVisible(true);
        sc.dispose();
    }
}

