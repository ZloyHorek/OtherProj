package Swing;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JComboBox <String> comboBox; //переменные типа J со своими свойствами
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ”бивает поток при нажатии на крестик
        setBounds(300, 300, 300, 400); // сайзы окна
        setLayout(null); //сброс дл€ редактировани€ окошка
        setVisible(true); // делает видимым окно

        add(comboBox); //добавл€ет доп. поле с выпадающей строкой типа combo box
        add(textField);
        add(convertButton);
        add(textFieldResult);

        textField.setBounds(30,150,100,20); // поле с текстом
        textFieldResult.setBounds(170,150,100,20); // наш результат (по конвертору)
        comboBox.setBounds(200,20,60,20); // поле с выпадающей валютой
        convertButton.setBounds(100,200,80,20); // кнопка на начала конвертации

        convertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //возвращает данные с которыми мы св€зываем данные, если нам нужно интовое значение то переводим строки в инты
                long userAmount = 0;
                try { // открываем трай и кетч дл€ проверки перевода и введенных данных
                     userAmount = Integer.parseInt(textField.getText().trim()); // добавл€ем трим дл€ удалени€ пробела
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Incorrect amount!");
                }
                if(userAmount>0){
                    String currencyCode = comboBox.getSelectedItem().toString();
                    String value = XMLCurrencyParser.getCurrency(currencyCode); // перем значени€ подсчитанное конвертором


                    double currencyValue = Double.parseDouble(value); // переменна€ дл€ перевода строки в дабл
                    double result =0.0;
                    if(currencyCode.equals("RUB")){
                    result =userAmount/currencyValue*100;
                        textFieldResult.setText(String.format("%.2f",result)); //вывод результата в €чейке result
                        textFieldResult.setVisible(true); // возвращаем видимость €чейке result
                    }
                    else {
                        result = userAmount / currencyValue; //формула дл€ перевода валюты
                        textFieldResult.setText(String.format("%.2f",result)); //вывод результата в €чейке result
                        textFieldResult.setVisible(true); // возвращаем видимость €чейке result
                    }
                }
            }
        }); // наше добавление действи€ на кнопку, создает пустой конструктор типа Override

        textFieldResult.setVisible(false);
    }
}
class Test{
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
    }
}
