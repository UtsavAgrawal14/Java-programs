package com.pdf.generate;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {

	public static void generate(String name, String content) throws IOException, DocumentException {

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter.getInstance(document, new FileOutputStream("D:\\" + name + ".pdf"));
		document.open();
		Paragraph para = new Paragraph(content);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		document.close();
	}

	public static void main(String[] args) throws IOException, DocumentException {
		generate("header", "some content");
	}
}
