package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // сначала драйвер менеджмент
            Connection con = DriverManager.getConnection( // потом идет конекшн
                    "jdbc:mysql://localhost:3306/classicmodels", "root", "");

            Statement stmt = con.createStatement(); // наши выборы statement, в данном случаи select
            ResultSet rs = stmt.executeQuery("select * from productlines");
            while (rs.next())
                System.out.println(rs.getString(1) +
                        "  " + rs.getString(2));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

