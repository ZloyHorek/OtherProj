package Swing;

import javax.swing.*;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame(String msg){
        JLabel msgLbl = new JLabel("");
        msgLbl.setBounds(100,65,200,20);
        msgLbl.setText(msg);
        setTitle("Main Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 340, 200);
        setLayout(null);
        add(msgLbl);

        setVisible(true);

    }


}
