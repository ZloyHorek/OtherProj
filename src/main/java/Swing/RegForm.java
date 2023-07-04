package Swing;

import javax.swing.*;

public class RegForm extends JFrame {

//    private  JButton Reg =  new JButton;
    JLabel pwd1 = new JLabel("Password");
    JLabel pwd1re = new JLabel("");
    JLabel pwd2 = new JLabel("");
    JLabel pwd2re = new JLabel("");
    public RegForm() {
        setTitle("Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 400);
        setLayout(null);


        pwd1.setBounds(80, 65, 200, 20 );
        pwd1re.setBounds(80, 90, 100, 20 );
        pwd2.setBounds(80, 135, 100, 20 );
        pwd2re.setBounds(80, 120, 100, 20 );

        setVisible(true);
    }
}
class check{
    public static void main(String[] args) {
        RegForm re = new RegForm();
    }
}
