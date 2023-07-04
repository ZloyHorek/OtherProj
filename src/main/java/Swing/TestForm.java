package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TestForm {
    private JButton testButton;
    private JPanel myPanel;

    public TestForm() {
        testButton.addActionListener(new ActionListener() { // создает экземпл€р интерфейса и метод об€зательный к реализации

            @Override
            public void actionPerformed(ActionEvent e) { //выполн€етс€ в момент нажати€ на кнопку
                System.out.println(new Date());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // создание объекта (окошка)
        frame.setBounds(600,400,700,400);

        frame.setTitle("My First Swing");
        frame.setName("Myapp");
        frame.setContentPane(new TestForm().myPanel); //создает фрейм и переносит нашу панель
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); // делает видимой нашу панель
//        JButton button = new JButton();
//        button.setBackground(Color.BLUE);

    }
}
