package excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    public static void main(String[] args) throws IOException {

        String fileName = "ExcelBasicWorkbook.xlsx";
        String sheetName = "ExcelBascSheet1";
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\excel";

        File file = new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstSheet = workbook.getSheet(sheetName);
        int firstSheetRowCount = firstSheet.getLastRowNum()-firstSheet.getFirstRowNum();

        for (int i = 0; i < firstSheetRowCount+1; i++) {
            Row row = firstSheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue()+"|| ");
            }
            System.out.println();
        }

    }
}