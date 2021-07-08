package uacm.edu.mx.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.service.GenerateExcelFileCorrRecPorFechaRecepService;


@Service
public class GenerateExcelFileCorrRecPorFechaRecepImpl implements GenerateExcelFileCorrRecPorFechaRecepService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ByteArrayInputStream export(List<CorrespondenciaRecibida> corrRecPorFechaRecep) {
		// TODO Auto-generated method stub
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Correspondencias-FechaRecepción");
			Row row = sheet.createRow(0);
			
			// Define el estilo del encabezado de la celda
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
	        // Crear el encabezado de las celdas
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Fecha de recepción");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Turno");
	        cell.setCellStyle(headerCellStyle);
	
	        cell = row.createCell(2);
	        cell.setCellValue("Referencia");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(3);
	        cell.setCellValue("Area que envía");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(4);
	        cell.setCellValue("Asunto");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Turnado a");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(6);
	        cell.setCellValue("Expediente");
	        cell.setCellStyle(headerCellStyle);
	        
	     // Creating data rows for each contact
	        for(int i = 0; i < corrRecPorFechaRecep.size(); i++) {
	        	Row dataRow = sheet.createRow(i + 1);
	        	dataRow.createCell(0).setCellValue(corrRecPorFechaRecep.get(i).getFechaRecepcion());
	        	dataRow.createCell(1).setCellValue(corrRecPorFechaRecep.get(i).getTurno());
	        	dataRow.createCell(2).setCellValue(corrRecPorFechaRecep.get(i).getReferenciaDocumento());
	        	//dataRow.createCell(3).setCellValue(corrRecPorFechaRecep.get(i).getIdAreaEnvia().getNombre());
	        	dataRow.createCell(4).setCellValue(corrRecPorFechaRecep.get(i).getAsunto());
	        	//dataRow.createCell(5).setCellValue(corrRecPorFechaRecep.get(i).getIdTurnadoA().getNombre());
	        	dataRow.createCell(6).setCellValue(corrRecPorFechaRecep.get(i).getIdExpediente().getNombreExpediente());
	        }
	     // Making size of column auto resize to fit with data
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        sheet.autoSizeColumn(4);
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			logger.error("Error during export Excel file", ex);
			return null;
		}
	}

}
