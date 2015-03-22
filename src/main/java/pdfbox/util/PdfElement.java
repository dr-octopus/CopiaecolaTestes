package pdfbox.util;

import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
 
public interface PdfElement {
	
    public void draw(PDPageContentStream stream, PDRectangle region);
    
}