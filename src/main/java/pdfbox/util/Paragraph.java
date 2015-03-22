package pdfbox.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.font.PDFont;

/**
 * Classe que representa um parágrafo com uma largura máxima definida. É‰ responsável pelas quebras de linha.
 * 
 * @author Thor
 * @see <a href="http://www.just-thor.com/2014/04/07/how-to-wrap-text-in-pdfbox/">Fonte</a>
 */
public class Paragraph {
	
	/** Largura máxima do parágrafo */
	private final int width;
	
	/** Texto do parágrado */
	private final String text;
	
	private final PDFont font;
	
	private final int fontSize;
	
	public Paragraph(int width, PDFont font, int fontSize, String text) {
		this.text = text;
		this.font = font;
		this.width = width;
		this.fontSize = fontSize;
	}
	
	/**
	 * Quebra o texto em linhas, baseado na largura máxima. Quando excede a largura, o texto é quebrado para a próxima
	 * linha.
	 * 
	 * @return
	 */
	public List<String> getLines() throws IOException {
		List<String> result = new ArrayList<>();
		
		String[] split = text.split("(?<=\\W)");
		int[] possibleWrapPoints = new int[split.length];
		possibleWrapPoints[0] = split[0].length();
		for (int i = 1; i < split.length; i++) {
			possibleWrapPoints[i] = possibleWrapPoints[i - 1] + split[i].length();
		}
		
		int start = 0;
		int end = 0;
		for (int i : possibleWrapPoints) {
			float width = font.getStringWidth(text.substring(start, i)) / 1000 * fontSize;
			if (start < end && width > this.width) {
				result.add(text.substring(start, end));
				start = end;
			}
			end = i;
		}
		// Texto restante, Ãºltima linha
		result.add(text.substring(start));
		return result;
	}
	
	public float getFontHeight() {
		return font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
	}
	
	public int getWidth() {
		return width;
	}
	
	public String getText() {
		return text;
	}
	
	public PDFont getFont() {
		return font;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
}
