//package IO.xlsx;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//public class XLSX_Currency_Util {
//    public static List<Currency> loadCurrency() {
//        List<Currency> currencies = new ArrayList<>();
//        try ( InputStream in = new FileInputStream("D:\\currency_parser.xlsx")){
//            Workbook wb = null;
//            wb = new XSSFWorkbook(in);
//
//            for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
//                Sheet sheet = wb.getSheetAt(sheetNum);
//                System.out.println("Processing :" + sheet.getSheetName());
//
//                Iterator<Row> rowsIter = sheet.rowIterator();
//                while (rowsIter.hasNext()) {
//                    Row row = rowsIter.next();
//                    int rowNum = row.getRowNum();
//                    System.out.println("Row #" + rowNum);
//                    if(rowNum == 0)//skip first headers row
//                        continue;
//                    //data
////                    String numCode = row.getCell(0).getNumericCellValue();
////                    String charCode = row.getCell(0).getNumericCellValue();
////                    tring numCode = row.getCell(0).getNumericCellValue();
////                    tring numCode = row.getCell(0).getNumericCellValue();
////                    String model = row.getCell(1).getStringCellValue();
////                    double price = row.getCell(2).getNumericCellValue();
////                    Date date = row.getCell(3).getDateCellValue();
//
//                    Currency currency = new Currency(numCode, charCode, scale, name,rate,date);
//                    System.out.println(currency);
//                    currencies.add(currency);
//                }
//            }
//        } catch (
//                FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//
//        return currency;
//    }
//}
