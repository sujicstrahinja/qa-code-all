package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    public static void main(String[] args) throws IOException {

        Object[][] valueToWrite = new Object[][] {
                { "Dr Mr", "Tamo Amo"}
        };

        String fileName = "ExcelBasicWorkbook.xlsx";
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\excel";
        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook;
        workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Sheet2");

        for (int i = 0; i < valueToWrite.length; i++) {
            Row rowToWrite = sheet.createRow(sheet.getLastRowNum()+1);
            for (int j = 0; j < 2; j++) {
                Cell cell = rowToWrite.createCell(j);
                cell.setCellValue(valueToWrite[i][j].toString());
            }
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);

        outputStream.close();
    }
}
