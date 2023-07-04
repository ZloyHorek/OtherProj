package IO.xlsx;

import Swing.XMLCurrencyParser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.List;

public class XlsxCurrency1Util {

    public static void writeCurrency(String filePath, List<Currency> currencies){

        Workbook wb = null;
        if (filePath.endsWith(".xls")) {
            wb = new HSSFWorkbook();
        } else if (filePath.endsWith(".xlsx")) {
            wb = new XSSFWorkbook();
        } else {
            throw new IllegalArgumentException("Not acceptable format. " + filePath
                    + ". Expected MS Excel format");
        }

        Sheet sheet = wb.createSheet("Currency");
        int rownum = 0;
        Row headersRow = sheet.createRow(rownum);
        headersRow.createCell(0).setCellValue("NumCode");
        headersRow.createCell(1).setCellValue("CharCode");
        headersRow.createCell(2).setCellValue("Scale");
        headersRow.createCell(3).setCellValue("Name");
        headersRow.createCell(4).setCellValue("Rate");
//        headersRow.createCell(5).setCellValue("Date");

        for (Currency currency:currencies) {
            rownum++;
            Row row = sheet.createRow(rownum);
            row.createCell(0).setCellValue(currency.getNumCode());
            row.createCell(1).setCellValue(currency.getCharCode());
            row.createCell(2).setCellValue(currency.getScale());
            row.createCell(3).setCellValue(currency.getName());
            row.createCell(4).setCellValue(currency.getRate());
//            row.createCell(5).setCellValue(currency.getDate());
        }

        try (OutputStream out = new FileOutputStream(filePath)){
            wb.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Test{
    public static void main(String[] args) {
        List<Currency>currencies = XMLCurrencyParser.getMainCurrency();
        XlsxCurrency1Util.writeCurrency("D:\\currency_parser.xlsx"+ new Date().getTime()+".xlsx",currencies );
    }
}


