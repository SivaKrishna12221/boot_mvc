package com.nt.viewComponents;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.entity.StudentInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excelreport")
public class ExcelEmployeeRepor extends AbstractXlsView {
	private int rowNum = 1;

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page<StudentInfo> stud = (Page<StudentInfo>) map.get("pageData");
		Sheet sheet = workbook.createSheet("Sheet1");
		Row row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("studentId");
		row1.createCell(1).setCellValue("studentName");
		row1.createCell(2).setCellValue("course");
		row1.createCell(3).setCellValue("age");
		row1.createCell(4).setCellValue("mobile");
		row1.createCell(5).setCellValue("fees");
		row1.createCell(6).setCellValue("dof");
		stud.forEach(sinfo -> {
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(sinfo.getStudentId());
			row.createCell(1).setCellValue(sinfo.getStudName());
			row.createCell(2).setCellValue(sinfo.getStudCourse());
			if (sinfo.getStudAge() != null)
				row.createCell(3).setCellValue(sinfo.getStudAge());
			row.createCell(4).setCellValue(sinfo.getStudMobile());
			if (sinfo.getStudFees() != null)
				row.createCell(5).setCellValue(sinfo.getStudFees());
			row.createCell(6).setCellValue(String.valueOf(sinfo.getStudDof()));
			rowNum++;
		});
	}
}
