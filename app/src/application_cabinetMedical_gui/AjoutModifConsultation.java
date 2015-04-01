/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_cabinetMedical_gui;


import application_cabinetMedical_DAO.Consultation;
import application_cabinetMedical_DAO.Etablissement;
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

                   
    private JButton btAnnulerConsultation = new JButton();
    private JButton btEnregistrerConsultation = new JButton();
    private JComboBox comboDiagnosticConsultation= new JComboBox();
    private JLabel l11 = new JLabel();
    private JLabel l2 = new JLabel();
    private JLabel l3 = new JLabel();
    private JLabel l4 = new JLabel();
    private JLabel l5 = new JLabel();
    private JLabel l6 = new JLabel();
    private JLabel l7 = new JLabel();
    private JScrollPane ScrollPane2 = new JScrollPane();
    private JScrollPane ScrollPane5 = new JScrollPane();
    private JScrollPane ScrollPane6 = new JScrollPane();
    private JScrollPane ScrollPane8 = new JScrollPane();
    private JFormattedTextField txtDateConsultation= new JFormattedTextField();
    private JTextArea txtMotifConsultation = new JTextArea();
    private JTextArea txtResExamCliniqueConsultation = new JTextArea();
    private JTextArea txtResExamParacliniqueConsultation = new JTextArea();
    private JTextArea txtTraitementConsultation = new JTextArea();
  

    
    public AjoutModifConsultation(FenPrincipale fen) {
        this.fen = fen;
        this.setMajConsultation(fen.getMajConsultation());
        this.setIdp(fen.getIdp());
        this.setIdRDV(fen.getIdRDV());
        
       fenConsultation();
       this.setLocation(500, 100);
        this.setSize(800, 400);
       
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
       

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setName("Details Consultation"); 

        l2.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        l2.setText("Motif de consultation :");

        txtMotifConsultation.setColumns(20);
        txtMotifConsultation.setRows(5);
        txtMotifConsultation.setName("txtMotifConsultation"); 
        ScrollPane5.setViewportView(txtMotifConsultation);

        l3.setFont(new Font("Tahoma", 1, 11)); 
        l3.setText("Resultat de l'examen clinique :");

        txtResExamCliniqueConsultation.setColumns(20);
        txtResExamCliniqueConsultation.setRows(5);
        txtResExamCliniqueConsultation.setName("txtResExamCliniqueConsultation");
        ScrollPane6.setViewportView(txtResExamCliniqueConsultation);

        l4.setFont(new Font("Tahoma", 1, 11)); 
        l4.setText("Diagnostic Médical :");

        l5.setFont(new Font("Tahoma", 1, 11)); 
        l5.setText("Resultats des examens paracliniques :");

        txtResExamParacliniqueConsultation.setColumns(20);
        txtResExamParacliniqueConsultation.setRows(5);
        txtResExamParacliniqueConsultation.setName("txtResExamParacliniqueConsultation");
        ScrollPane8.setViewportView(txtResExamParacliniqueConsultation);

        txtTraitementConsultation.setColumns(20);
        txtTraitementConsultation.setRows(5);
        txtTraitementConsultation.setName("txtTraitementConsultation"); 
        ScrollPane2.setViewportView(txtTraitementConsultation);

        l6.setFont(new Font("Tahoma", 1, 11)); 
        l6.setText("Traitement Préscrit :");

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

      

        l7.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        l7.setText("Date Consultaion :");

        
        this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new GridLayout(4, 2));
        p.add(l2);
        p.add(l3);
        p.add(txtMotifConsultation);
        p.add(txtResExamCliniqueConsultation);
        p.add(l6);
        p.add(l5);
        p.add(txtTraitementConsultation);
        p.add(txtResExamParacliniqueConsultation);
        
        
        JPanel p2 =new JPanel(new FlowLayout());
        p2.add(btEnregistrerConsultation);
        p2.add(btAnnulerConsultation);
        
        JPanel p3 =new JPanel(new FlowLayout());
        p3.add(l4);
        p3.add(comboDiagnosticConsultation);
         p3.add(l7);
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
            fen.afficheInfosConsultationByTableRDV();
            
        }else{
            
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
            consult.modifierConsultation(consult,idRDV);
            this.hide();
	}
            fen.afficheInfosConsultationByTableRDV();
            
            
            
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

