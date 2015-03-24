/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;



/**
 *
 * @author GHAWAR
 */
public class TestIText1 {
    public static void main(String[] args) {

    Document document = new Document(PageSize.A4);
    try {
      PdfWriter.getInstance(document, new FileOutputStream("c:/test.pdf"));
      document.open();
      
      Paragraph paragraph = new Paragraph("ligne 1",FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD));
      paragraph.setAlignment(Element.ALIGN_RIGHT);
      paragraph.setIndentationRight(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 1 test de phrase",FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD));
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 2 test de phrase");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 3 test de phrase");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 4 test de phrase");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 5 test de phrase");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("                      ");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 7 test de phrase");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("ligne 8 test de phrase");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      paragraph = new Paragraph("                       ");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
      
      Chunk chunk = new Chunk("Ordonnance",FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD));
      chunk.setUnderline(Color.BLACK, 3.0f, 0.0f, 0.0f, -0.2f, PdfContentByte.LINE_CAP_BUTT);
      paragraph = new Paragraph();
      paragraph.setAlignment(Element.ALIGN_CENTER);
      paragraph.add(chunk);
      document.add(paragraph);
      
      paragraph = new Paragraph("                       ");
      paragraph.setIndentationLeft(50f);
      document.add(paragraph);
    } catch (DocumentException de) {
      de.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    document.close();
  }
}
