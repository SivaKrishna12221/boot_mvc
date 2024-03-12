package com.nt.viewComponents;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.StudentInfo;

@Component("stud_pdf_report")
public class PdfStudentInfo extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Page<StudentInfo> studata = (Page<StudentInfo>) map.get("studData");

		Paragraph para = new Paragraph("Student Info", new Font(Font.BOLDITALIC));
		document.add(para);

		Table table = new Table(7, studata.getSize());
		for (StudentInfo data : studata) {
			table.addCell(String.valueOf(data.getStudentId()));
			table.addCell(data.getStudName());
			table.addCell(String.valueOf(data.getStudAge()));
			table.addCell(data.getStudCourse());
			table.addCell(String.valueOf(data.getStudFees()));
			table.addCell(data.getStudMobile());
			table.addCell(String.valueOf(data.getStudDof()));
		}
		document.add(table);
	}
}
