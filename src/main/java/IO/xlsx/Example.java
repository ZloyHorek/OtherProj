package IO.xlsx;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Example {
    public static void main(String[] args) {
//        try {
//            InputStream in = new FileInputStream("D:\\cars_table.xlsx"); // ��������� � �����
//            Workbook wb = new XSSFWorkbook(in); // wordbook �������
//            Sheet sheet =  wb.getSheetAt(0); // ������� ������ Sheet (����) ��� ��������� ����� � �������
//
//            System.out.println(sheet.getSheetName());
//            // �������� ��� ������ ������ ����� ������ ���������, ������� ������
//            Iterator<Row>rowIter = sheet.rowIterator(); // ������ ���� ��� "����������" ����� - �����
////            sheet.rowIterator(); // ����� ���� ������� ������
//            // ����� ������� ���������� �� �����
//            while (rowIter.hasNext()){
//                Row row = rowIter.next(); //���������� ������� Row  �������� ������
//                System.out.println("Row #: "+ row.getRowNum());// ��� ��������� ����� ������
//                Iterator<Cell> cellIterator = row.cellIterator(); // ������ Cell ������ �� �������
//                while (cellIterator.hasNext()){
//                    Cell cell =cellIterator.next();
//                    switch (cell.getCellType()){
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.println("Number: "+cell.getNumericCellValue());
//                            break;
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.println("String: "+cell.getStringCellValue());
//                            break;
//                    }
//                }
//            }
//
//            System.out.println();
//
//            /* ������� ������� ���� (Sheet)
//            * ����� ������� ������ (Row)
//            * ����� ������(Cell)
//            * �� ���� ������� �� ������� */
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        List<Car> cars = XlsxCarUtil.loadCars("D:\\cars_table.xlsx");

        System.out.println(cars.size());

        cars.add(new Car(399, "BMW X7", 52354, new Date()));
        cars.add(new Car(123, "BMW Z3", 1233, new Date()));
        cars.add(new Car(452, "BMW Z1", 423, new Date()));

        XlsxCarUtil.writeCars("D:\\cars_table_"+new Date().getTime()+".xlsx", cars);
    }
}




