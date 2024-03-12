package com.nt.viewComponents;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.entity.StudentInfo;

@Component("excel_stud_info")
public class ExcelStudentInfo extends AbstractXlsView {
	private int rowNum = 0;

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Page<StudentInfo> stuInfo = (Page<StudentInfo>) map.get("studData");
		Sheet sheet1 = workbook.createSheet("Sheet1");
		stuInfo.forEach(info -> {
			Row row = sheet1.createRow(rowNum);
			row.createCell(0).setCellValue(info.getStudentId());
			row.createCell(1).setCellValue(info.getStudName());
			row.createCell(2).setCellValue(info.getStudCourse());
			if (info.getStudAge() != null)
				row.createCell(3).setCellValue(info.getStudAge());
			if (info.getStudAge() != null)
				row.createCell(4).setCellValue(info.getStudFees());
			row.createCell(5).setCellValue(info.getStudMobile());
			row.createCell(6).setCellValue(String.valueOf(info.getStudDof()));
			rowNum++;
		}

		);

	}

}
