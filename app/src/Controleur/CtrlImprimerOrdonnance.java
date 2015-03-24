/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Consultation;
import Modele.Etablissement;
import Modele.Medecin;
import Modele.Patient;
import Vue.FenPrincipale;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author GHAWAR
 */
public class CtrlImprimerOrdonnance {
    private FenPrincipale Fen;
    public CtrlImprimerOrdonnance(FenPrincipale Fen){
        this.Fen = Fen;
    }
    public void RemplirOrdonnance(){
        ResultSet res;
        String nomEtablissement = "";
        String adresseEtablissement = "";
        int telEtablissement = 0;
        String nomPatient = "";
        String prenomPatient = "";
        String dateNaissPatient = null;
        String traitement = "";
        Etablissement etab = new Etablissement();
        try{
            res=etab.getEtablissement();
            nomEtablissement = res.getString("nomEtab");
            adresseEtablissement = res.getString("adresseEtab");
            telEtablissement = res.getInt("telEtab");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"erreur \n"+e.getMessage());
        }
        Medecin med1 = new Medecin();
        Medecin med2 = med1.getMedecinById(Fen.getIdm());
        String nomMedecin = med2.getNomMedecin();
        String prenomMedecin = med2.getPrenomMedecin();
        String specialiteMedecin = med2.getSpecialite();
        Patient patient  = new Patient();
        res = patient.getPatient(Fen.getIdp());
        try{
        res.next();
        nomPatient = res.getString("nomPatient");
        prenomPatient = res.getString("prenomPatient");
        dateNaissPatient = res.getString("dateNaissance");
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"erreur \n"+e.getMessage());
        }
        
        traitement = Fen.getTxtTraitement().getText();
        
        Document document = new Document(PageSize.A4);
        try {
          PdfWriter.getInstance(document, new FileOutputStream("./ordonnance.pdf"));
          document.open();
          Date d = new Date();
          Paragraph paragraph = new Paragraph(d.toLocaleString(),FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD));
          paragraph.setAlignment(Element.ALIGN_RIGHT);
          paragraph.setIndentationRight(50f);
          document.add(paragraph);
          paragraph = new Paragraph("Dr "+nomMedecin+" "+prenomMedecin,FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD));
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph("SPECIALISTE EN "+specialiteMedecin);
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph(nomEtablissement);
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph(adresseEtablissement);
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph("Tél : "+telEtablissement);
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph("                      ");
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph("nom & prenom :"+nomPatient+" "+prenomPatient,FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD));
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          paragraph = new Paragraph("Ne(e) le :"+dateNaissPatient);
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
          paragraph = new Paragraph(traitement);
          paragraph.setIndentationLeft(50f);
          document.add(paragraph);
          
          Runtime r = Runtime.getRuntime();
	  r.exec("cmd /C ordonnance.pdf");
        } catch (DocumentException de) {
          de.printStackTrace();
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
            document.close();
        }
}
