import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExport {
    public static void exportAccountsToExcel(List<Account> accounts, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Bank Accounts");

            Row headerRow = sheet.createRow(0);
            String[] columns = {"Account number", "Client name", "Account type", "Balance"};

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Account account : accounts) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(account.getAccountNumber());

                if (account.getOwner() != null) {
                    row.createCell(1).setCellValue(account.getOwner().getName());
                } else {
                    row.createCell(1).setCellValue("Inconnu");
                }

                row.createCell(2).setCellValue(account.getAccountType());

                row.createCell(3).setCellValue(account.getBalance());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("✅ Export succes ! File created : " + filePath);
            }

        } catch (IOException e) {
            System.err.println("❌ Error while exporting : " + e.getMessage());
        }
    }
}