package itext.leitura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

import aleatoriedades.regex.DivideLinhas;

public class ItextImprimeParagrafos {
	
	public static void main(String[] args) {
		List<String> conteudo = new ArrayList<>();
		
		try {
//			PdfReader reader = new PdfReader("src/main/resources/PDFInput/boot.pdf");
			PdfReader reader = new PdfReader("PDFInput/Desenvolvimento_Iterativo_e_Incremental.pdf");
			PdfTextExtractor extractor = new PdfTextExtractor(reader);
			
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				String txt = extractor.getTextFromPage(i);
				conteudo.addAll(Arrays.asList(toParagrafos(txt)));
			}
			
		} catch (IOException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		}
		
		for (String s : conteudo) {
			if (s.length() >= 100) {
				System.out.println(s);
			}
		}
	}
	
	public static String[] toParagrafos(String texto) {
		String[] textoSplitado = DivideLinhas.removeLinhasPequenas(texto);
		
		for (int i = 0; i < textoSplitado.length; i++) {
			textoSplitado[i] = ("[ " + i + " = " + textoSplitado[i] + "]");
		}
		
		return textoSplitado;
	}
	
}
