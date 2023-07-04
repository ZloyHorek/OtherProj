package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSumma extends JFrame {
    private JTextField field1;
    private JTextField field2;
    private JButton action1;
    private JButton action2;
    private JButton action3;
    private JButton action4;
    private JButton action5;
    private JLabel result;

    SimpleSumma(){
        field1 = new JTextField();
        field2 = new JTextField();
        action1 = new JButton("+");
        action2 = new JButton("/");
        action3 = new JButton("*");
        action4 = new JButton("-");
        action5 = new JButton("=");
        result = new JLabel("0");

        setTitle("Сalculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Убивает поток при нажатии на крестик
        setBounds(300, 300, 300, 400); // сайзы окна
        setLayout(null); //сброс для редактирования окошка
        setVisible(true); // делает видимым окно

        add(field1);
        add(field2);
        add(action1);
        add(action2);
        add(action3);
        add(action4);
        add(action5);
        add(result);

        field1.setBounds(30,40,100,20);
        field2.setBounds(170,40,100,20);
        action1.setBounds(50,100,50,20);
        action2.setBounds(100,100,50,20);
        action3.setBounds(150,100,50,20);
        action4.setBounds(200,100,50,20);
        action5.setBounds(100,150,100,40);
        result.setBounds(150,200,200,80);

        action5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            result.setVisible(true);
            }
        });

        action1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(field1.getText());
            int num2 = Integer.parseInt(field2.getText());
            result.setText(String.valueOf(num1+num2));

            }
        });

        action2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(field1.getText());
                int num2 = Integer.parseInt(field2.getText());
                result.setText(String.valueOf(num1/num2));

            }
        });
        action3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(field1.getText());
                int num2 = Integer.parseInt(field2.getText());
                result.setText(String.valueOf(num1*num2));

            }
        });
        action4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(field1.getText());
                int num2 = Integer.parseInt(field2.getText());
                result.setText(String.valueOf(num1-num2));

            }
        });


result.setVisible(false);
    }
}


class Tester{
    public static void main(String[] args) {
        SimpleSumma summa=new SimpleSumma();
    }
}

