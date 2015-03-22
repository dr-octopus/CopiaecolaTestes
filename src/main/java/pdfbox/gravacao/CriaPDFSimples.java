package pdfbox.gravacao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class CriaPDFSimples {
	
	public static void criaPDF(String texto) throws IOException, FileNotFoundException, COSVisitorException {
		PDDocument doc = new PDDocument();
		PDPage page = new PDPage();
		doc.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		
		PDType1Font font = PDType1Font.HELVETICA;
		contentStream.setFont(font, 12);
		contentStream.beginText();
		contentStream.moveTextPositionByAmount(100, 400);
		contentStream.drawString(texto);
		contentStream.endText();
		contentStream.close();
		
		doc.save("src/main/resources/PDFOutput/test.pdf");
		doc.close();
	}
	
	public static void main(String[] args) {
		try {
			criaPDF("Texto Bonito");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (COSVisitorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
