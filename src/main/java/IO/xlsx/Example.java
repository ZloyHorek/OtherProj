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
//            InputStream in = new FileInputStream("D:\\cars_table.xlsx"); // обращение к файлу
//            Workbook wb = new XSSFWorkbook(in); // wordbook изучить
//            Sheet sheet =  wb.getSheetAt(0); // создаем объект Sheet (лист) дл€ получени€ листа с данными
//
//            System.out.println(sheet.getSheetName());
//            // итератор это способ обойти какую нибудь коллекцию, удобный способ
//            Iterator<Row>rowIter = sheet.rowIterator(); // полный путь дл€ "доставани€" строк - полос
////            sheet.rowIterator(); // через лист достаем строку
//            // чтобы достать содержимое из €чеек
//            while (rowIter.hasNext()){
//                Row row = rowIter.next(); //присвоение объекту Row  значение строки
//                System.out.println("Row #: "+ row.getRowNum());// все достаетс€ очень сложно
//                Iterator<Cell> cellIterator = row.cellIterator(); // €чейка Cell способ ее достать
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
//            /* —начала достаем лист (Sheet)
//            * потом достаем строку (Row)
//            * потом €чейку(Cell)
//            * по сути прыгаем по массиву */
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




