package Swing;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.util.Properties;

class EmailSender extends JFrame {
    private final static String HOST_NAME = "smtp.rambler.ru";
    private final static String EMAIL_REGEX = "^(.+)@(\\\\S+)$";
    private final String EMAIL_ACC = "j2022.java@rambler.ru";
    private final static String EMAIL_PWD = "2023JAVA";
//    private final static char[] EMAIL_PWD = {'2','0','2','3','J','a','v','a'};
    private JButton sendButton;
    private JTextField textFieldWho; //кому
    private JTextField textFieldCopy;//кому копия
    private JTextField textFieldHide;//скрытая копия
    private JTextField textFieldMessage;//сообщение

    private JLabel labelWho;
    private JLabel labelCopy;
    private JLabel labelHide;
    private JLabel labelTopic;

    private JComboBox topicBox;

    EmailSender() throws MessagingException {
        sendButton = new JButton("Send");
        textFieldWho = new JTextField("Who");
        textFieldCopy = new JTextField("Copy");
        textFieldHide = new JTextField("Hidden");
        textFieldMessage = new JTextField("Your message");
        labelWho = new JLabel("Who");
        labelCopy = new JLabel("Copy");
        labelHide = new JLabel("Hidden");
        labelTopic = new JLabel("Topic");
        topicBox = new JComboBox();
        topicBox.addItem("Work");
        topicBox.addItem("Love");
        topicBox.addItem("Relax");


        setTitle("EmailSender");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 80, 600, 500);

        setLayout(null);
        setVisible(true);


        add(textFieldWho);
        add(textFieldCopy);
        add(textFieldHide);
        add(labelWho);
        add(labelCopy);
        add(labelHide);
        add(labelTopic);
        add(sendButton);
        add(textFieldMessage);
        add(topicBox);
        sendButton.setBounds(450, 400, 80, 20);
        textFieldWho.setBounds(100, 50, 300, 20);
        textFieldCopy.setBounds(100, 85, 300, 20);
        textFieldHide.setBounds(100, 120, 300, 20);
        labelWho.setBounds(30, 50, 300, 20);
        labelCopy.setBounds(30, 85, 300, 20);
        labelHide.setBounds(30, 120, 300, 20);
        labelTopic.setBounds(30, 155, 300, 20);
        textFieldMessage.setBounds(100, 200, 350, 120);
        topicBox.setBounds(100, 155, 300, 20);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", HOST_NAME);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.auth", "587");//465

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(EMAIL_ACC, EMAIL_PWD);
                    }
                });

        String sendingMassage = textFieldMessage.getText().trim();
        String email = textFieldWho.getText().trim();

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_ACC));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject(topicBox.getSelectedItem().toString());
        message.setText(sendingMassage);

        //send the message
        Transport.send(message);

        System.out.println("message sent successfully...");





    }
}
class TestEmail {
    public static void main(String[] args) throws MessagingException {
        EmailSender emailSender = new EmailSender();

    }
}
