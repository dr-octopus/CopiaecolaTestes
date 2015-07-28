package itext.gravacao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Exemplo de criação de um arquivo PDF simples utilizando iTEXT 2.1.7
 * 
 * @author Android learner
 * @see <a
 *      href="http://stackoverflow.com/questions/8435103/how-to-create-pdf-file-using-itext-or-some-other-library-on-android">Fonte</a>
 */
public class ItextPdfSimples {
	
	static String paragrafo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " + "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " + "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	
	public static void main(String[] args) {
		Document document = new Document();
		
		try {
			// Referencia um ovo arquivo no diretório especificado.
			File file = new File("src/main/resources/PDFOutput/test_itext.pdf");
			
			// Cria o stream de saída.
			FileOutputStream fOut = new FileOutputStream(file);
			
			// Cria o gravador para o documento.
			PdfWriter.getInstance(document, fOut);
			
			// Abre o documento para edição.
			document.open();
			
			// Cria um parágrafo, configurando a fonte, alinhamento e adicionando textos.
			Paragraph p1 = new Paragraph("Este é um parágrafo simples\n");
			Font paraFont = new Font(Font.HELVETICA);
			p1.setAlignment(Paragraph.ALIGN_CENTER);
			p1.setFont(paraFont);
			p1.add(paragrafo);
			
			// Adiciona o parágrafo ao documento.
			document.add(p1);
			
			Paragraph p2 = new Paragraph("This is an example of a simple paragraph");
			Font paraFont2 = new Font(Font.HELVETICA, 14.0f, 0, CMYKColor.GREEN);
			p2.setAlignment(Paragraph.ALIGN_CENTER);
			p2.setFont(paraFont2);
			
			document.add(p2);
			
//			ByteArrayOutputStream stream = new ByteArrayOutputStream();
//			bitmap bitmap =BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.ic_launcher);
//			bitmap.compress(bitmap.CompressFormat.JPEG, 100, stream);
//			Image myImg = Image.getInstance(stream.toByteArray());
//			myImg.setAlignment(Image.MIDDLE);
			
			// add image to document
//			document.add(myImg);
			
			Image img = Image.getInstance("src/main/resources/PDFInput/copiaecola.png");
			img.setAlignment(Image.MIDDLE);
			document.add(img);
			
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		} finally {
			// A gravação é findada ao fechar o documento.
			document.close();
		}
		
	}
}
