package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Constants.FrameworkConstants;

public class ExcelReaderUtils {

    public static String getCellData(String sheetName, int row, int col) {
        String value = null;

        // Use try-with-resources to automatically close the stream
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row r = sheet.getRow(row);
            Cell c = r.getCell(col);

            if (c != null) {
                value = c.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }
}
