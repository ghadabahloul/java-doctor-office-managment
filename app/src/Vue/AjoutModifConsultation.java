/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import DAO.Consultation;
import DAO.Etablissement;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


/**
 *
 * @author ghada
 */
public class AjoutModifConsultation extends JFrame {
    
    private String majConsultation;
    private static FenPrincipale fen;
    private static int idp;
    private static int idRDV;

                   
    private JButton btAnnulerConsultation;
    private JButton btEnregistrerConsultation;
    private JComboBox comboDiagnosticConsultation;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane8;
    private JFormattedTextField txtDateConsultation;
    private JTextArea txtMotifConsultation;
    private JTextArea txtResExamCliniqueConsultation;
    private JTextArea txtResExamParacliniqueConsultation;
    private JTextArea txtTraitementConsultation;
  

    
    public AjoutModifConsultation(FenPrincipale fen) {
        this.fen = fen;
        this.setMajConsultation(fen.getMajConsultation());
        this.setIdp(fen.getIdp());
        this.setIdRDV(fen.getIdRDV());
        
       fenConsultation();
       
        this.txtDateConsultation.setText(fen.getTableRDV().getValueAt(fen.getTableRDV().getSelectedRow(),0).toString());
        if(this.getMajConsultation().equals("modifier")){
            this.txtMotifConsultation.setText(fen.getTxtMotif().getText());
            this.txtResExamCliniqueConsultation.setText(fen.getTxtResExamClinique().getText());
            this.txtResExamParacliniqueConsultation.setText(fen.getTxtResExamParaclinique().getText());
            this.txtTraitementConsultation.setText(fen.getTxtTraitement().getText());
            this.comboDiagnosticConsultation.setSelectedItem(fen.getTxtDiagnostic());
        }
    }

   
    
    private void fenConsultation() {

        jLabel2 = new JLabel();
        jScrollPane5 = new JScrollPane();
        txtMotifConsultation = new JTextArea();
        jLabel3 = new JLabel();
        jScrollPane6 = new JScrollPane();
        txtResExamCliniqueConsultation = new JTextArea();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jScrollPane8 = new JScrollPane();
        txtResExamParacliniqueConsultation = new JTextArea();
        jScrollPane2 = new JScrollPane();
        txtTraitementConsultation = new JTextArea();
        jLabel6 = new JLabel();
        comboDiagnosticConsultation = new JComboBox();
        btEnregistrerConsultation = new JButton();
        btAnnulerConsultation = new JButton();
        txtDateConsultation = new JFormattedTextField();
        jLabel11 = new JLabel();
        jLabel7 = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setName("Details Consultation"); 

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel2.setText("Motif de consultation :");

        txtMotifConsultation.setColumns(20);
        txtMotifConsultation.setRows(5);
        txtMotifConsultation.setName("txtMotifConsultation"); 
        jScrollPane5.setViewportView(txtMotifConsultation);

        jLabel3.setFont(new Font("Tahoma", 1, 11)); 
        jLabel3.setText("Resultat de l'examen clinique :");

        txtResExamCliniqueConsultation.setColumns(20);
        txtResExamCliniqueConsultation.setRows(5);
        txtResExamCliniqueConsultation.setName("txtResExamCliniqueConsultation");
        jScrollPane6.setViewportView(txtResExamCliniqueConsultation);

        jLabel4.setFont(new Font("Tahoma", 1, 11)); 
        jLabel4.setText("Diagnostic Médical :");

        jLabel5.setFont(new Font("Tahoma", 1, 11)); 
        jLabel5.setText("Resultats des examens paracliniques :");

        txtResExamParacliniqueConsultation.setColumns(20);
        txtResExamParacliniqueConsultation.setRows(5);
        txtResExamParacliniqueConsultation.setName("txtResExamParacliniqueConsultation");
        jScrollPane8.setViewportView(txtResExamParacliniqueConsultation);

        txtTraitementConsultation.setColumns(20);
        txtTraitementConsultation.setRows(5);
        txtTraitementConsultation.setName("txtTraitementConsultation"); 
        jScrollPane2.setViewportView(txtTraitementConsultation);

        jLabel6.setFont(new Font("Tahoma", 1, 11)); 
        jLabel6.setText("Traitement Préscrit :");

        comboDiagnosticConsultation.setModel(new DefaultComboBoxModel(new String[] { "Angine", "PIC HYPERTENSIF > LOXEN IVD" }));
        comboDiagnosticConsultation.setName("comboDiagnosticConsultation"); 

        btEnregistrerConsultation.setIcon(new ImageIcon(getClass().getResource("/Pictures/OK.gif"))); 
        btEnregistrerConsultation.setText("Enregistrer");
        btEnregistrerConsultation.setName("btEnregistrerConsultation"); 
        btEnregistrerConsultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Enregistrer(evt);
            }
        });

        btAnnulerConsultation.setIcon(new ImageIcon(getClass().getResource("/Pictures/Cancel.gif"))); 
        btAnnulerConsultation.setText("Annuler");
        btAnnulerConsultation.setName("btAnnulerConsultation"); 
        btAnnulerConsultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Annuler(evt);
            }
        });

        txtDateConsultation.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(""))));
        txtDateConsultation.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        txtDateConsultation.setFocusable(false);
        txtDateConsultation.setName("txtDateConsultation"); 

      

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel7.setText("Date Consultaion :");

        
        this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new GridLayout(4, 2));
        p.add(jLabel2);
        p.add(jLabel3);
        p.add(txtMotifConsultation);
        p.add(txtResExamCliniqueConsultation);
        p.add(jLabel6);
        p.add(jLabel5);
        p.add(txtTraitementConsultation);
        p.add(txtResExamParacliniqueConsultation);
        
        
        JPanel p2 =new JPanel(new FlowLayout());
        p2.add(btEnregistrerConsultation);
        p2.add(btAnnulerConsultation);
        
        JPanel p3 =new JPanel(new FlowLayout());
        p3.add(jLabel4);
        p3.add(comboDiagnosticConsultation);
         p3.add(jLabel7);
        p3.add(txtDateConsultation);
        
         
       
        
        this.add(p);
        this.add(p2);
         this.add(p3);
        
        add(p3,BorderLayout.NORTH);
        
        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        
        
        
        
        
        pack();
    }                       

    private void Annuler(ActionEvent evt) {                                                      
       
        this.hide();
    }                                                     

    private void Enregistrer(ActionEvent evt) {                                                          
       
        if(this.getMajConsultation().equals("ajouter"))
        {
            
             ResultSet res;
        int idE = 0;
	if(getTxtMotifConsultation().getText().equals("") || getTxtResExamCliniqueConsultation().getText().equals("") || getTxtResExamParacliniqueConsultation().getText().equals("") || getTxtTraitementConsultation().getText().equals("") || getComboDiagnosticConsultation().getSelectedItem().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Etablissement etab = new Etablissement();
            try{
                res=etab.getEtablissement();
                idE = res.getInt("idEtab");
            }catch(SQLException e){}
            Consultation consult = new Consultation(getTxtDateConsultation().getText(),getTxtMotifConsultation().getText(),getTxtResExamCliniqueConsultation().getText(),(String)getComboDiagnosticConsultation().getSelectedItem(),getTxtResExamParacliniqueConsultation().getText(),getTxtTraitementConsultation().getText(),getIdRDV(),getIdp(),idE);
            consult.ajoutConsultation(consult);
            this.hide();
	}
            
            
        }else{
            
            /*if(getTxtNomMalade().getText().equals("") || getTxtPrenom().getText().equals("") || getTxtAdresse().getText().equals("") || getTxtTel().getText().equals("") || getTxtDateNaissance().getText().equals("") || getTxtProfession().getText().equals("") || getComboMedecinTraitant().getSelectedItem().equals("") || getComboSexe().getSelectedItem().equals("") || getComboSituationFamiliale().getSelectedItem().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Medecin medecin = new Medecin();
            Patient patient = new Patient(getTxtNomMalade().getText(),getTxtPrenom().getText(),Fen.getTxtDateNaissance().getText(),Integer.parseInt(getTxtTel().getText()),(String)getComboSexe().getSelectedItem(),(String)getComboSituationFamiliale().getSelectedItem(),getTxtProfession().getText(),getChkAssure().isSelected(),getTxtAdresse().getText(),Fen.getIdMedecin(getComboMedecinTraitant().getSelectedIndex()));
            patient.modifierPatient(patient,idp);
            this.hide();
	}*/
            
            
            
        }
    }                                                         

   
    public static void main(String args[]) {
   
       
              AjoutModifConsultation AjoutModifConsultation =  new AjoutModifConsultation(fen);
              AjoutModifConsultation.setVisible(true);
        
    }

    
    
    
    public String getMajConsultation() {
        return majConsultation;
    }

    public void setMajConsultation(String majConsultation) {
        this.majConsultation = majConsultation;
    }

    public JTextArea getTxtMotifConsultation() {
        return txtMotifConsultation;
    }

    public JTextArea getTxtResExamCliniqueConsultation() {
        return txtResExamCliniqueConsultation;
    }

    public JTextArea getTxtResExamParacliniqueConsultation() {
        return txtResExamParacliniqueConsultation;
    }

    public JTextArea getTxtTraitementConsultation() {
        return txtTraitementConsultation;
    }

    public JComboBox getComboDiagnosticConsultation() {
        return comboDiagnosticConsultation;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        AjoutModifConsultation.idp = idp;
    }

    public int getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(int idRDV) {
        AjoutModifConsultation.idRDV = idRDV;
    }

    public JFormattedTextField getTxtDateConsultation() {
        return txtDateConsultation;
    }

    public void setTxtDateConsultation(JFormattedTextField txtDateConsultation) {
        this.txtDateConsultation = txtDateConsultation;
    }
    
                 
}

