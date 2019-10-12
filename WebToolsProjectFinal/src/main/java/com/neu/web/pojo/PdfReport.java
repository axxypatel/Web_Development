package com.neu.web.pojo;


import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Font  helvetica_18_blue = new Font(Font.HELVETICA, 18, Font.BOLDITALIC, Color.BLUE);
		Font  helvetica_14_blue = new Font(Font.HELVETICA, 14, Font.NORMAL, Color.BLACK);
		
		List<Drug> drugtlist = (List<Drug>) model.get("drugList");
		Patient patient = (Patient) model.get("finalPatient");
		Paragraph title = new Paragraph("Order Summary", helvetica_18_blue);
		
		Phrase producttitle = new Phrase("Below you will find patient summary");
		
		Paragraph name = new Paragraph("Patient Name: ", helvetica_14_blue);
		Phrase producttitle1 = new Phrase(patient.getPatientName());
		Paragraph mobile = new Paragraph("Patient mobile: ", helvetica_14_blue);
		Phrase producttitle2 = new Phrase(patient.getPatientMobile());
		Paragraph age = new Paragraph("Patient Age: ", helvetica_14_blue);
		Phrase producttitle3 = new Phrase(patient.getPatientAge());
			
		PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 1.0f});
        table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
		
        cell.setPhrase(new Phrase("Drug ID", helvetica_18_blue));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Drug Name", helvetica_18_blue));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Drug Dosage", helvetica_18_blue));
        table.addCell(cell);
        
        for (Drug ccc : drugtlist) {
            table.addCell(ccc.getDrugcomid());
            table.addCell(ccc.getDrugName());
            table.addCell(ccc.getDosageValue());
        }
        
		pdfdoc.add(title);
		pdfdoc.add(producttitle);
		pdfdoc.add(name);
		pdfdoc.add(producttitle1);
		pdfdoc.add(mobile);
		pdfdoc.add(producttitle2);
		pdfdoc.add(age);
		pdfdoc.add(producttitle3);
		pdfdoc.add(table);
	}

	
}