package pdfbox.gravacao;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class EditaPDFSimples {
	
	public static void main(String[] args) {
		File pdf = new File("src/main/resources/PDFInput/boot.pdf");
		
		PDDocument doc = null;
		try {
			doc = PDDocument.load(pdf);
			PDPage paginaToEdit = ( PDPage ) doc.getDocumentCatalog().getAllPages().get(0);
			PDFont font = PDType1Font.HELVETICA_BOLD;
			PDPageContentStream contentStream = new PDPageContentStream(doc, paginaToEdit, true, true);
			
			// Inicia ediçãoo
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.moveTextPositionByAmount(100, 100);
			contentStream.drawString("Hello");
			contentStream.endText();
			contentStream.close();
			
			doc.save("src/main/resources/PDFOutput/boot2.pdf"); // Diretório onde será salvo o arquivo, novo ou
			                                                    // existente
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (COSVisitorException e) {
			e.printStackTrace();
		}
		
	}
	
}
