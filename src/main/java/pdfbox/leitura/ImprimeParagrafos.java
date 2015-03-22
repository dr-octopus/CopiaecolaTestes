package pdfbox.leitura;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.util.PDFTextStripper;

public class ImprimeParagrafos {
	
	public static void main(String[] args) {
		
		File pdf = new File("src/main/resources/PDFInput/boot_CopiaECola.pdf");
		
		try {
			PDDocument doc = PDDocument.load(pdf);
			
			// Imprime as fontes e tamanhos aproximados
			PDPage page = ( PDPage ) doc.getDocumentCatalog().getAllPages().get(0);
			Map<String, PDFont> pageFonts = page.getResources().getFonts();
			for (PDFont f : pageFonts.values()) {
				String size = String.valueOf(f.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * 14);
				size = (size.contains(".") ? size.substring(0, size.indexOf(".")) : size);
				
				System.out.println("Nome: " + f.getFontDescriptor().getFontName() + " | Tamanho: " + size);
			}
			
			// Imprime parágrafos
			PDFTextStripper stripper = new PDFTextStripper();
			
			stripper.setParagraphEnd("_pEnds_");
			
			System.out.println();
			for (String paragrafo : stripper.getText(doc).split("_pEnds_")) {
				if (paragrafo.length() > 60) {
					System.out.println(paragrafo.replace("_pEnds_", ""));
				}
			}
			
			if (doc != null) {
				doc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
