package com.example.excelreaderdbwriter.util;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringUtils;

import com.example.excelreaderdbwriter.dto.ExportExcelDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExportExcelEditor extends PropertyEditorSupport {
	private ObjectMapper objectMapper;
	
	public ExportExcelEditor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
        	ExportExcelDTO report = new ExportExcelDTO();
            try {
            	report = objectMapper.readValue(text, ExportExcelDTO.class);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
            setValue(report);
        }
    }
}