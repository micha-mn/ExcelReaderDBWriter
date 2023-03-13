package com.example.excelreaderdbwriter.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.example.excelreaderdbwriter.dto.DataDTO;
import com.example.excelreaderdbwriter.dto.ExportExcelDTO;
import com.example.excelreaderdbwriter.dto.ReadExcelWriteDBDTO;
import com.example.excelreaderdbwriter.util.ReadExcelWriteDBUtil;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReadExcelWriteDBService {
	
    
	public void readExcelFile(ReadExcelWriteDBDTO readExcelWriteDBDTO) {
		
		 ReadExcelWriteDBUtil.readExcelFile(readExcelWriteDBDTO.getFile());

		}

	public ReadExcelWriteDBDTO getDBConfig() {
		
		ReadExcelWriteDBDTO readExcelWriteDBDTO = ReadExcelWriteDBDTO.builder()
																	.periodOne("2023-03-02T14:02")
																	.periodTwo("2023-03-02T14:02")
																	.periodThree("2023-03-02T14:02")
																	.rateLimit("2")
																	.build();
		return readExcelWriteDBDTO;
		
	}
    // new 
	public void exportExcelFile(ExportExcelDTO exportExcelDTO, HttpServletResponse response) {
		
		 System.out.println("from "+exportExcelDTO.getFromPeriod() + " to "+ exportExcelDTO.getToPeriod());
		 // to be replace with the jpa list 
		 DataDTO data = DataDTO.builder().date("12/12/2020").value("123456").build();
		 List<DataDTO> dataList = new ArrayList<>();
		 dataList.add(data);
		 
		 ReadExcelWriteDBUtil.exportExcelFile(dataList ,response);
	}



}
