package com.nt.viewComponents;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.StudentInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdfreport")
public class PdfReportViewClass extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Page<StudentInfo> studData = (Page<StudentInfo>) map.get("pageData");
		Paragraph para = new Paragraph("Student Information", new Font(Font.BOLD));
		document.add(para);
		Table tab = new Table(7, studData.getSize());
		tab.addCell("sid");
		tab.addCell("name");
		tab.addCell("course");
		tab.addCell("age");
		tab.addCell("mobile");
		tab.addCell("fees");
		tab.addCell("dof");
		for (StudentInfo sinfo : studData) {
			tab.addCell(String.valueOf(sinfo.getStudentId()));
			tab.addCell(sinfo.getStudName());
			tab.addCell(sinfo.getStudCourse());
			tab.addCell(String.valueOf(sinfo.getStudAge()));
			tab.addCell(sinfo.getStudMobile());
			tab.addCell(String.valueOf(sinfo.getStudFees()));
			tab.addCell(String.valueOf(sinfo.getStudDof()));

		}
		document.add(tab);

	}

}
