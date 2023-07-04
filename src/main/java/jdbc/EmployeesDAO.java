package jdbc;
import java.sql.*;

public class EmployeesDAO {
    private  OfficesDAO officesDAO =new OfficesDAO();
    public Employee getEmployeeById(int id) {


        String select = "Select*from classicmodels.Employees where employeeNumber = ?"; //? ���� �� ����� ��� �� ��������
        Employee empl = null;

        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(select); // ����� ��� Statement-� ����� �������� �������� ����� � ���� ������
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                empl = new Employee();
                empl.setEmployeeNumber(id);
                empl.setEmail(rs.getString("email"));
                empl.setExtension(rs.getString("extension"));
                empl.setFirstName(rs.getString("firstName"));
                empl.setLastName(rs.getString("lastName"));
                empl.setJobTitle(rs.getString("jobTitle"));

                int reportsTo = rs.getInt("reportsTo");
                if(reportsTo!=0) {
                    Employee employee = getEmployeeById(reportsTo);
                    empl.setReportsTo(employee);
                }
                else {
                    empl.setReportsTo(null);
                }




                //�������� �����
                String officeCode = rs.getString("officeCode"); // �������� ����
                Office office = officesDAO.getOfficeByID(officeCode);//��������� ��� � ������ ���� ����� �������
                empl.setOffice(office); //�������� ����
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empl;
    }

    public void updateEmployee(Employee employee){
        String sql = "UPDATE classicmodels.employees SET lastName = ?, firstName = ?" +
                ", extension = ?," + " email = ?, officeCode = ?, " +
                "reportsTo = ?," + " jobTitle = ? WHERE employeeNumber = ?";
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql); // ����� ��� Statement-� ����� �������� �������� ����� � ���� ������
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getExtension());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getOffice().getOfficeCode());
            Employee rep = employee.getReportsTo();

            pstmt.setInt(6, rep ==null? 0:rep.getEmployeeNumber());
            pstmt.setString(7, employee.getJobTitle());
            pstmt.setInt(8, employee.getEmployeeNumber());

            int result =  pstmt.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
