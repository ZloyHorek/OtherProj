package jdbc;

import java.util.List;

public class Client {

    public static void main(String[] args) {
//        OfficesDAO officesDAO = new OfficesDAO();
//        Office office = officesDAO.getOfficeByID("2");
//        System.out.println(office);
//
//        List<Office> all = officesDAO.getAllOffices();
//        System.out.println("SIZE: " + all.size());
//        for (Office o :all){
//            System.out.println(o.getCountry() + " : " + o.getCity());
//        }
//
//
////        Office officeNew = officesDAO.getOfficeByID("9");
////        officeNew.setAddressLine2("Floor #3");
////        officeNew.setPhone("+375173423524");
////
////        officesDAO.updateOffice(officeNew);
//
//        Office officeDelete = officesDAO.getOfficeByID("9");
//        officesDAO.deleteOfficeByID("9");
//
//
//        officesDAO.deleteOfficeByID("100");
//        Office office100= new Office("100","1","1","1","1","1","1","1","1");
//        officesDAO.createOffice(office100);
//
////        Office officeFromDb = officesDAO.getOfficeByID("100"){
////
////        }
//
//    }

        EmployeesDAO employeesDAO = new EmployeesDAO();
        Employee empl = employeesDAO.getEmployeeById(1102);
        System.out.println(empl);


        empl.setJobTitle("TEST");
        employeesDAO.updateEmployee(empl);
    }
}
