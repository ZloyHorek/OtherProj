package jdbc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	//private String officeCode;
	private Office office;
	private Employee reportsTo;
	//private int reportsTo; - �������� �� ������, ������� �����������, ������� ����� �������� ������ �����������
	private String jobTitle;

}
