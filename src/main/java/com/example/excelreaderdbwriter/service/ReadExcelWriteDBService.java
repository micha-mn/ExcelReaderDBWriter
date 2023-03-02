package com.example.excelreaderdbwriter.service;

import org.springframework.stereotype.Service;

import com.example.excelreaderdbwriter.dto.ReadExcelWriteDBDTO;
import com.example.excelreaderdbwriter.util.ReadExcelWriteDBUtil;

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



}
