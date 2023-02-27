package com.example.excelreaderdbwriter.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.excelreaderdbwriter.dto.DataDTO;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

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

}
