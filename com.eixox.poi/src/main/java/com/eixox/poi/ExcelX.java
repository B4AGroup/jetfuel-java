package com.eixox.poi;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelX {

	public static final <T> T process(InputStream xls, ExcelProcessor<T> processor) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(xls);
			try {
				XSSFSheet sheet = workbook.getSheetAt(0);
				ExcelProcessorState state = new ExcelProcessorState();
				state.firstRowNumber = sheet.getFirstRowNum();
				state.lastRowNumber = sheet.getLastRowNum();
				state.rowCount = state.lastRowNumber - state.firstColNumber;

				XSSFRow headers = sheet.getRow(state.firstRowNumber);

				state.firstColNumber = headers.getFirstCellNum();
				state.lastColNumber = headers.getLastCellNum();
				state.colCount = state.lastColNumber - state.firstColNumber;
				state.cols = new ArrayList<String>(state.colCount);

				// get cell headers
				for (int i = state.firstColNumber; i < state.lastColNumber; i++) {
					XSSFCell cell = headers.getCell(i);
					if (cell != null)
						state.cols.add(cell.getStringCellValue());
					else
						state.cols.add("[UNDEFINED]");
				}
				processor.init(state);

				// get table body
				for (int i = state.currentRowNumber + 1; i <= state.lastRowNumber && !state.cancel; i++) {
					XSSFRow cells = sheet.getRow(i);

					state.currentRowNumber = i;
					state.row = new Object[state.colCount];

					int cellindex = 0;
					for (int j = state.firstColNumber; j < state.lastColNumber; j++) {
						XSSFCell cell = cells.getCell(j);
						if (cell != null)
							switch (cell.getCellType()) {
							case XSSFCell.CELL_TYPE_NUMERIC:
								state.row[cellindex++] = cell.getNumericCellValue();
								break;
							case XSSFCell.CELL_TYPE_BOOLEAN:
								state.row[cellindex++] = cell.getBooleanCellValue();
								break;
							default:
								state.row[cellindex++] = cell.getStringCellValue();
								break;
							}
						else
							state.row[cellindex++] = null;

					}
					processor.process(state);
				}
			} finally {
				workbook.close();
				processor.finish();
			}
			return processor.getOutput();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
