package IO.xlsx;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;

@lombok.Data
@AllArgsConstructor // ������ ���� � ����� ������� ����������� � ��, ����� ����� ������
@NoArgsConstructor

public class Car {

    private int id ;
    private String model ;
    private double price ;
    private Date date ;



}
