package pdfbox.util;

import java.awt.Color;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

public class TextPdfElement implements PdfElement {
	public enum TextAlignment {
		CENTER,
		LEFT,
		RIGHT
	};
	
	private String message;
	
	private PDFont font;
	
	private float fontSize;
	
	private Color fontcolor;
	
	private float x;
	
	private float y;
	
	private TextAlignment align = TextAlignment.LEFT;
	
	public TextPdfElement() {}
	
	public TextPdfElement(String message, PDFont font, float fontSize, Color fontColor, float x, float y, TextAlignment align) {
		this.message = message;
		this.font = font;
		this.fontSize = fontSize;
		this.fontcolor = fontColor;
		this.x = x;
		this.y = y;
		this.align = align;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setFont(PDFont font) {
		this.font = font;
	}
	
	public void setFontSize(float fontSize) {
		this.fontSize = fontSize;
	}
	
	public void setFontColor(Color fontColor) {
		this.fontcolor = fontColor;
	}
	
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setTextAlignment(TextAlignment align) {
		this.align = align;
	}
	
	/**
	 * Escreve a linha no documento, é aqui onde decide-se qual a posição que o texto vai ser impresso. Alinhamento,
	 * altura de linha, etc.
	 */
	@Override
	public void draw(PDPageContentStream contentStream, PDRectangle region) {
		if (this.message == null)
			return;
		
		try {
			contentStream.beginText();
			
			contentStream.setFont(this.font, this.fontSize);
			contentStream.setNonStrokingColor(this.fontcolor);
			if (this.align == TextAlignment.CENTER) {
				float stringWidth = font.getStringWidth(this.message) * fontSize / 1000f;
				float centerXPos = (region.getWidth() - stringWidth) / 2f;
				contentStream.setTextTranslation(centerXPos, region.getHeight() - (this.y * 72));
			} else {
				contentStream.setTextTranslation(this.x * 72, region.getHeight() - (this.y * 72));
			}
			
			contentStream.drawString(this.message);
			contentStream.endText();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}