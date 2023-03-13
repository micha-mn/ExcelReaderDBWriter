package com.example.excelreaderdbwriter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.excelreaderdbwriter.dto.ExportExcelDTO;
import com.example.excelreaderdbwriter.dto.ReadExcelWriteDBDTO;
import com.example.excelreaderdbwriter.service.ReadExcelWriteDBService;
import com.example.excelreaderdbwriter.util.ExportExcelEditor;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

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
	
	@GetMapping("/getdbconfig")
		public ReadExcelWriteDBDTO getDBConfig(){
		 return readExcelWriteDBService.getDBConfig();
		}
	// new 

	 private ObjectMapper objectMapper;
	 @Autowired
	    public void setObjectMapper(ObjectMapper objectMapper) {
	        this.objectMapper = objectMapper;
	    }
	 
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	     binder.registerCustomEditor(ExportExcelDTO.class, new ExportExcelEditor(objectMapper));
	 }
	 
	@GetMapping("/export")
	public void exportToExcel(@RequestParam ExportExcelDTO exportExcelDTO, HttpServletResponse response) throws IOException {
	     readExcelWriteDBService.exportExcelFile(exportExcelDTO ,response);
    }

}
