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
		// Cria um novo documento.
		PDDocument doc = new PDDocument();
		
		// Cria uma página e atribui ao documento.
		PDPage page = new PDPage();
		doc.addPage(page);
		
		// Cria o Stream para construir o conteúdo da página.
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		
		// Atribui as configurações da fonte.
		PDType1Font font = PDType1Font.HELVETICA;
		contentStream.setFont(font, 12);
		
		// Inicia a operação.
		contentStream.beginText();
		
		// É necessário atribuir as coordenadas X e Y, respectivamente,
		// onde o elemento será gravado na página.
		contentStream.moveTextPositionByAmount(100, 400);
		contentStream.drawString(texto);
		
		// Finaliza a operação.
		contentStream.endText();
		contentStream.close();
		
		// Grava o documento no diretório informado.
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
