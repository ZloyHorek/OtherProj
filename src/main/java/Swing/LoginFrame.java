package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JButton loginButton = new JButton("ENTER");
    private JTextField loginTextFiled = new JTextField();
    private JTextField pwdTextFiled = new JPasswordField();
    private JLabel loginLbl = new JLabel("Login:");
    private JLabel pwdLbl = new JLabel("Password:");
    private JLabel msgLbl = new JLabel("");
    private JButton regMeButton = new JButton("Registration");
    private static final String USER_NAME = "Admin";
    private static final String USER_PWD = "123";
    private JTextField RegName = new JTextField();
    private JTextField RegEmail = new JTextField();
    private JTextField RegPass = new JPasswordField();
    private JTextField RegPass2 = new JPasswordField();
    private JLabel RegLbl1 = new JLabel("Name:");
    private JLabel RegLbl2 = new JLabel("Email:");
    private JLabel RegLbl3 = new JLabel("Password:");
    private JLabel RegLbl4 = new JLabel("Conform:");
    private JButton RegButton = new JButton("Remember");



    {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = loginTextFiled.getText().trim();
                String userPwd = pwdTextFiled.getText();
                if(!userName.equalsIgnoreCase(USER_NAME)){
                    msgLbl.setText("Wrong User Name");
                }
                else if(!userPwd.equals(USER_PWD)){
                    msgLbl.setText("Wrong Password");
                }
                else {
                    WelcomeFrame wf=new WelcomeFrame("Welcome Back"+" "+userName);
                }
            }
        });
        regMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reg = new JFrame();
                reg.setTitle("Registration");
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setLayout(null);
                reg.setBounds(500,500,400,400);

                RegName.setBounds(130, 60, 200, 20 );
                RegEmail.setBounds(130, 100, 200, 20 );
                RegPass.setBounds(130, 140, 200, 20 );
                RegPass2.setBounds(130, 180, 200, 20 );
                RegLbl1.setBounds(30,60,60,20);
                RegLbl2.setBounds(30,100,60,20);
                RegLbl3.setBounds(30,140,60,20);
                RegLbl4.setBounds(30,180,60,20);
                RegButton.setBounds(150,250,140,50);

                reg.add(RegName);
                reg.add(RegEmail);
                reg.add(RegPass);
                reg.add(RegPass2);
                reg.add(RegLbl1);
                reg.add(RegLbl2);
                reg.add(RegLbl3);
                reg.add(RegLbl4);
                reg.add(RegButton);

                reg.setVisible(true);
            }
        });
        RegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeFrame wf=new WelcomeFrame("Registration was successful");
            }
        });
    }

    public LoginFrame(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 200, 300, 400);
        setLayout(null);

        msgLbl.setBounds(80, 65, 200, 20 );
        loginLbl.setBounds(80, 90, 150, 20 );
        pwdLbl.setBounds(80, 135, 150, 20 );
        loginTextFiled.setBounds(80, 120, 150, 20 );
        pwdTextFiled.setBounds(80, 160, 150, 20 );
        loginButton.setBounds(80, 250, 150, 20 );
        regMeButton.setBounds(80, 220, 150, 20 );

        add(msgLbl);
        add(loginTextFiled);
        add(pwdTextFiled);
        add(loginButton);
        add(loginLbl);
        add(pwdLbl);
        add(regMeButton);
        setVisible(true);
    }
}
class GUITester {
    public static void main(String[] args) {
        LoginFrame login = new LoginFrame();
    }
}

