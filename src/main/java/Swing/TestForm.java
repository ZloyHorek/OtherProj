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
        testButton.addActionListener(new ActionListener() { // ������� ��������� ���������� � ����� ������������ � ����������

            @Override
            public void actionPerformed(ActionEvent e) { //����������� � ������ ������� �� ������
                System.out.println(new Date());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // �������� ������� (������)
        frame.setBounds(600,400,700,400);

        frame.setTitle("My First Swing");
        frame.setName("Myapp");
        frame.setContentPane(new TestForm().myPanel); //������� ����� � ��������� ���� ������
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); // ������ ������� ���� ������
//        JButton button = new JButton();
//        button.setBackground(Color.BLUE);

    }
}
