package com.example.excelreaderdbwriter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.excelreaderdbwriter.dto.ReadExcelWriteDBDTO;
import com.example.excelreaderdbwriter.service.ReadExcelWriteDBService;

@RestController
public class ReadExcelWriteDBController {
	
	@Autowired
	private final ReadExcelWriteDBService readExcelWriteDBService;
	
	public ReadExcelWriteDBController(
			ReadExcelWriteDBService readExcelWriteDBService
			)
	{
		this.readExcelWriteDBService   = readExcelWriteDBService;
	}
	
	@RequestMapping(value =  "/readexcelwritedb")
    public ModelAndView dataReadRxcelWritedb(ModelMap model)
    {
		return new ModelAndView("html/index");
    }
	
	@PostMapping("/read")
	    public void readExcel(@ModelAttribute ReadExcelWriteDBDTO readExcelWriteDBDTO) throws Exception {
		readExcelWriteDBService.readExcelFile(readExcelWriteDBDTO);
	}
	
}
