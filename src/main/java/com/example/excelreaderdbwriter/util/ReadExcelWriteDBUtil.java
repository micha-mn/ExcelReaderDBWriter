package com.example.excelreaderdbwriter.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.excelreaderdbwriter.dto.DataDTO;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import jakarta.servlet.http.HttpServletResponse;

public class ReadExcelWriteDBUtil {

   private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
   
   public static List<DataDTO> readExcelFile(MultipartFile file) {
	   
       List<DataDTO> rowData = new ArrayList<>();
       
      
       List<List<String>> records = new ArrayList<List<String>>();
       try  {
    	   Reader reader = new InputStreamReader(file.getInputStream());
    	   CSVReader csvReader =  new CSVReaderBuilder(reader).withSkipLines(1).build();
           String[] values = null;
           while ((values = csvReader.readNext()) != null) {
               records.add(Arrays.asList(values));
           }
           System.out.println("records: "+records);
       }catch (Exception e) {
		System.out.println("exception: "+e);
	}
        
        return null;

   }
// new
public static void exportExcelFile(List<DataDTO> dataList, HttpServletResponse response) {
	// create workbook and sheet
	response.setHeader("Content-Disposition", "attachment; filename=Emkan-IVR-Process-Job-Result-Data-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm")) +".xlsx");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    
    try {
    	
    
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Data");

    // create header row
    Row header = sheet.createRow(0);
    header.createCell(0).setCellValue("DATE");
    header.createCell(1).setCellValue("VALUE");

    // retrieve data from JPA list and populate rows
   
    int rowNum = 1;
    for (DataDTO data : dataList) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(data.getDate());
        row.createCell(1).setCellValue(data.getValue());
    }

    workbook.write(response.getOutputStream());
    workbook.close();
    } catch (Exception e) {
        e.printStackTrace();
    } 
}

}
