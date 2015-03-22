package pdfbox.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ParagraphExemple {
	
	public static void main(String[] args) {
		
		String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et "
		        + "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea "
		        + "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
		        + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		
		File pdf = new File("src/main/resources/PDFInput/boot.pdf");
		PDDocument doc = null;
		PDPage paginaToEdit = null;
		PDFont font = PDType1Font.HELVETICA;
		int fontSize = 11;
		Color color = new Color(16225054);
		
		try {
			doc = PDDocument.load(pdf);
			paginaToEdit = ( PDPage ) doc.getDocumentCatalog().getAllPages().get(1);
			
			Paragraph paragraph = new Paragraph(300, font, fontSize, texto);
			PDPageContentStream contentStream = new PDPageContentStream(doc, paginaToEdit, true, false);
			
			// posição inicial
			float initY = 0f;
			for (String line : paragraph.getLines()) {
				new TextPdfElement(line, font, fontSize, color, 0.8f, initY, TextPdfElement.TextAlignment.LEFT).draw(
				        contentStream, new PDRectangle(500, 550));
				
				initY += 0.15f;
			}
			
			contentStream.close();
			doc.save("src/main/resources/PDFOutput/test.pdf");
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (COSVisitorException e) {
			e.printStackTrace();
		}
		
	}
	
}
