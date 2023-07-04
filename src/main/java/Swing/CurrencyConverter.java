package Swing;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JComboBox <String> comboBox; //���������� ���� J �� ������ ����������
    private JTextField textField;
    private JTextField textFieldResult;
    private JButton convertButton;
    CurrencyConverter(){
        textFieldResult = new JTextField();
        convertButton = new JButton("Convert");
        textField = new JTextField("Input BYN");
        comboBox=new JComboBox();
        comboBox.addItem("USD");
        comboBox.addItem("EUR");
        comboBox.addItem("RUB");

        setTitle("CurrencyConverter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������� ����� ��� ������� �� �������
        setBounds(300, 300, 300, 400); // ����� ����
        setLayout(null); //����� ��� �������������� ������
        setVisible(true); // ������ ������� ����

        add(comboBox); //��������� ���. ���� � ���������� ������� ���� combo box
        add(textField);
        add(convertButton);
        add(textFieldResult);

        textField.setBounds(30,150,100,20); // ���� � �������
        textFieldResult.setBounds(170,150,100,20); // ��� ��������� (�� ����������)
        comboBox.setBounds(200,20,60,20); // ���� � ���������� �������
        convertButton.setBounds(100,200,80,20); // ������ �� ������ �����������

        convertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //���������� ������ � �������� �� ��������� ������, ���� ��� ����� ������� �������� �� ��������� ������ � ����
                long userAmount = 0;
                try { // ��������� ���� � ���� ��� �������� �������� � ��������� ������
                     userAmount = Integer.parseInt(textField.getText().trim()); // ��������� ���� ��� �������� �������
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Incorrect amount!");
                }
                if(userAmount>0){
                    String currencyCode = comboBox.getSelectedItem().toString();
                    String value = XMLCurrencyParser.getCurrency(currencyCode); // ����� �������� ������������ �����������


                    double currencyValue = Double.parseDouble(value); // ���������� ��� �������� ������ � ����
                    double result =0.0;
                    if(currencyCode.equals("RUB")){
                    result =userAmount/currencyValue*100;
                        textFieldResult.setText(String.format("%.2f",result)); //����� ���������� � ������ result
                        textFieldResult.setVisible(true); // ���������� ��������� ������ result
                    }
                    else {
                        result = userAmount / currencyValue; //������� ��� �������� ������
                        textFieldResult.setText(String.format("%.2f",result)); //����� ���������� � ������ result
                        textFieldResult.setVisible(true); // ���������� ��������� ������ result
                    }
                }
            }
        }); // ���� ���������� �������� �� ������, ������� ������ ����������� ���� Override

        textFieldResult.setVisible(false);
    }
}
class Test{
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
    }
}
