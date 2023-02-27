package com.example.excelreaderdbwriter.service;

import org.springframework.stereotype.Service;

import com.example.excelreaderdbwriter.dto.ReadExcelWriteDBDTO;
import com.example.excelreaderdbwriter.util.ReadExcelWriteDBUtil;

@Service
public class ReadExcelWriteDBService {
	
    
	public void readExcelFile(ReadExcelWriteDBDTO readExcelWriteDBDTO) {
		
		 ReadExcelWriteDBUtil.readExcelFile(readExcelWriteDBDTO.getFile());

		}



}
