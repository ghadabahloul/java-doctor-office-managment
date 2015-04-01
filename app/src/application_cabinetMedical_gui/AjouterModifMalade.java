/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_cabinetMedical_gui;

import application_cabinetMedical_connexion.connexionBD;
import Controleur.*;
import application_cabinetMedical_DAO.Medecin;
import application_cabinetMedical_DAO.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author ghada
 */
public class AjouterModifMalade extends JFrame {

    
    private int tabMedecin[];
    private static String majMalade;
    private static FenPrincipale fen;
    private static int idp;
                      
    private JButton btAnnulerMalade = new JButton();
    private JButton btEnregistrerMalade = new JButton();
    private JCheckBox chkAssure = new JCheckBox();
    private JComboBox comboMedecinTraitant = new JComboBox();
    private JComboBox comboSexe = new JComboBox();
    private JComboBox comboSituationFamiliale = new JComboBox();
    private JLabel l1 = new JLabel();
    private JLabel l10 = new JLabel();
    private JLabel l11 = new JLabel();
    private JLabel l2 = new JLabel();
    private JLabel l3 = new JLabel();
    private JLabel l4 = new JLabel();
    private JLabel l5 = new JLabel();
    private JLabel l6 = new JLabel();
    private JLabel l7 = new JLabel();
    private JLabel l8 = new JLabel();
    private JLabel l9 = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea txtAdresse = new JTextArea();
    private JFormattedTextField txtDateNaissance = new JFormattedTextField();
    private JTextField txtNomMalade = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtProfession = new JTextField();
    private JFormattedTextField txtTel = new JFormattedTextField();
                    
    
    public AjouterModifMalade(FenPrincipale fen) {
        
        
         FenAjout();
        this.setLocation(500, 100);
        this.setSize(800, 400);
        
        this.fen = fen;
        this.majMalade = fen.getMajMalade();
        this.setIdp(fen.getIdp());
        
       
        
        remplirComboMedecinTraitant();  
        
        if(this.getMajMalade().equals("modifier")){
            this.txtNomMalade.setText(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),0).toString());
            this.txtPrenom.setText(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),1).toString());
            this.txtDateNaissance.setText(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),2).toString());
            this.txtTel.setText(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),3).toString());
            this.comboSexe.setSelectedItem(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),4).toString());
            this.comboSituationFamiliale.setSelectedItem(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),5).toString());
            this.txtProfession.setText(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),6).toString());
            this.txtAdresse.setText(fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),8).toString());
            if((boolean)fen.getTableMalade().getValueAt(fen.getTableMalade().getSelectedRow(),7) == true)
                this.chkAssure.setSelected(true);
            else
                this.chkAssure.setSelected(false);
            Medecin medecin = new Medecin();
            Medecin medecin2 = medecin.getMedecinById(fen.getIdm());
            String nomMed = "Dr "+medecin2.getNomMedecin()+" "+medecin2.getPrenomMedecin();
            this.comboMedecinTraitant.setSelectedItem(nomMed);
        }
    }

   
                          
    private void FenAjout() {

    
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1.setFont(new Font("Tahoma", 1, 14)); 
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setText("L'état civil de patient");

        l2.setFont(new Font("Tahoma", 1, 11)); 
        l2.setText("Le nom de Malade :");

        l3.setFont(new Font("Tahoma", 1, 11)); 
        l3.setText("Date de naissance :");

        l4.setFont(new Font("Tahoma", 1, 11));
        l4.setText("Prenom");

        l5.setFont(new Font("Tahoma", 1, 11)); 
        l5.setText("Telephone :");

        txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
 

        l6.setFont(new Font("Tahoma", 1, 11));
        l6.setText("Sexe :");

        l7.setFont(new Font("Tahoma", 1, 11)); 
        l7.setText("Situation familiale :");

        comboSexe.setModel(new DefaultComboBoxModel(new String[] { "Masculin", "Féminin" }));
        comboSexe.setName("comboSexe"); 

        comboSituationFamiliale.setModel(new DefaultComboBoxModel(new String[] { "Célibataire", "Marié", "Divorcé", "Veuf" }));
        comboSituationFamiliale.setName("comboSituationFamiliale"); 

        l8.setFont(new Font("Tahoma", 1, 11)); 
        l8.setText("Profession :");

        txtProfession.setName("txtProfession"); 

        chkAssure.setFont(new Font("Tahoma", 1, 11)); 
        chkAssure.setText("Assuré");
       

        l9.setFont(new Font("Tahoma", 1, 11)); 
        l9.setText("Adresse :");

        txtAdresse.setColumns(20);
        txtAdresse.setRows(5);
       
        jScrollPane1.setViewportView(txtAdresse);

        l10.setFont(new Font("Tahoma", 1, 11)); 
        l10.setText("Medecin traitant :");

        btEnregistrerMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/OK.gif"))); 
        btEnregistrerMalade.setText("Enregistrer");
        btEnregistrerMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EnregistrerMalade(e);
            }
        });

        btAnnulerMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/Cancel.gif")));
        btAnnulerMalade.setText("Annuler");
        btAnnulerMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Annuler(e);
            }
        });

        txtDateNaissance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtDateNaissance.setName("txtDateNaissance"); 

       // l11.setText("respecter le format : yyyy-mm-dd");

        
        this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new GridLayout(3, 4));
        p.add(l2);
        p.add(txtNomMalade);
        p.add(l4);
        p.add(txtPrenom);
        p.add(l3);
        p.add(txtDateNaissance);
        p.add(l5);
        p.add(txtTel);
        p.add(l6);
        p.add(comboSexe);
        p.add(l7);
        p.add(comboSituationFamiliale);
         
        
        
        JPanel p2 =new JPanel(new GridLayout(1, 3));
        p2.add(l8);
        p2.add(txtProfession);
        p2.add(chkAssure);
        
        JPanel p3 =new JPanel(new FlowLayout());
        p3.add(btEnregistrerMalade);
        p3.add(btAnnulerMalade);
        
       
        JPanel p4=new JPanel(new GridLayout(2, 2));
        p4.add(l9);
        p4.add(txtAdresse);
        p4.add(l10);
        p4.add(comboMedecinTraitant);
      
        
        JPanel p5=new JPanel(new BorderLayout()); 
       
       p5.add(p,BorderLayout.NORTH);
        p5.add(p2,BorderLayout.CENTER);
         p5.add(p4,BorderLayout.SOUTH);
        
      //  this.add(p);
        //this.add(p2);
        this.add(p3);
      //  this.add(p4);
        this.add(p5);
        
        add(l1,BorderLayout.NORTH);
     
        add(p5, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        

        pack();
    }                       

    private void Annuler(ActionEvent evt) {                                                
        
        this.hide();
    }                                               

    private void EnregistrerMalade(ActionEvent evt) {                                                    
        
        if(this.getMajMalade().equals("ajouter"))
        {
            if(this.getTxtNomMalade().getText().equals("") || this.getTxtPrenom().getText().equals("") || this.getTxtAdresse().getText().equals("") || this.getTxtTel().getText().equals("") || this.getTxtDateNaissance().getText().equals("") || this.getTxtProfession().getText().equals("") || this.getComboMedecinTraitant().getSelectedItem().equals("") || this.getComboSexe().getSelectedItem().equals("") || this.getComboSituationFamiliale().getSelectedItem().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Medecin medecin = new Medecin();
            Patient patient = new Patient(this.getTxtNomMalade().getText(),this.getTxtPrenom().getText(),this.getTxtDateNaissance().getText(),Integer.parseInt(getTxtTel().getText()),(String)this.getComboSexe().getSelectedItem(),(String) this.getComboSituationFamiliale().getSelectedItem(),this.getTxtProfession().getText(),this.getChkAssure().isSelected(),this.getTxtAdresse().getText(),this.getIdMedecin(getComboMedecinTraitant().getSelectedIndex()));
            patient.ajoutPatient(patient);
            this.hide();
	}
    
            fen.remplirtableMalade();
            
        }else{
            
            if(this.getTxtNomMalade().getText().equals("") || this.getTxtPrenom().getText().equals("") || this.getTxtAdresse().getText().equals("") || this.getTxtTel().getText().equals("") || this.getTxtDateNaissance().getText().equals("") || this.getTxtProfession().getText().equals("") || this.getComboMedecinTraitant().getSelectedItem().equals("") || this.getComboSexe().getSelectedItem().equals("") || this.getComboSituationFamiliale().getSelectedItem().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Medecin medecin = new Medecin();
            Patient patient = new Patient(this.getTxtNomMalade().getText(),this.getTxtPrenom().getText(),this.getTxtDateNaissance().getText(),Integer.parseInt(getTxtTel().getText()),(String) this.getComboSexe().getSelectedItem(),(String) this.getComboSituationFamiliale().getSelectedItem(), this.getTxtProfession().getText(),this.getChkAssure().isSelected(),this.getTxtAdresse().getText(), this.getIdMedecin(getComboMedecinTraitant().getSelectedIndex()));
            patient.modifierPatient(patient,idp);
            this.hide();
	}
    
            fen.remplirtableMalade();
        }
    }                                                   

    public void remplirComboMedecinTraitant(){
        connexionBD con = new connexionBD();
    	ResultSet res;
        try{
        	res =con.reqSelection("select * From medecin");
        	tabMedecin = new int[100];
        	int i=0;
	        while(res.next()){
	        	tabMedecin[i]=res.getInt("idMedecin");
	        	comboMedecinTraitant.addItem("Dr "+res.getString("nomMedecin")+" "+res.getString("prenomMedecin"));
	        	i += 1;
	        }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erreur");			
        }
    }
    
    
    public static void main(String args[]) {
       
       
               AjouterModifMalade AjouterMalade = new AjouterModifMalade(fen);
               AjouterMalade.setVisible(true);
               AjouterMalade.setName("Ajout Malade"); 
            } 
      
    
    
    
    
    
    

    public JCheckBox getChkAssure() {
        return chkAssure;
    }

    public void setChkAssure(JCheckBox chkAssure) {
        this.chkAssure = chkAssure;
    }

    public JComboBox getComboSexe() {
        return comboSexe;
    }

    public void setComboSexe(JComboBox comboSexe) {
        this.comboSexe = comboSexe;
    }

    public JComboBox getComboSituationFamiliale() {
        return comboSituationFamiliale;
    }

    public void setComboSituationFamiliale(JComboBox comboSituationFamiliale) {
        this.comboSituationFamiliale = comboSituationFamiliale;
    }

    public JTextArea getTxtAdresse() {
        return txtAdresse;
    }

    public void setTxtAdresse(JTextArea txtAdresse) {
        this.txtAdresse = txtAdresse;
    }

    public JFormattedTextField getTxtDateNaissance() {
        return txtDateNaissance;
    }

    public void setTxtDateNaissance(JFormattedTextField txtDateNaissance) {
        this.txtDateNaissance = txtDateNaissance;
    }
    
    public JTextField getTxtNomMalade() {
        return txtNomMalade;
    }

    public void setTxtNomMalade(JTextField txtNomMalade) {
        this.txtNomMalade = txtNomMalade;
    }

    public JTextField getTxtPrenom() {
        return txtPrenom;
    }

    public void setTxtPrenom(JTextField txtPrenom) {
        this.txtPrenom = txtPrenom;
    }

    public JTextField getTxtProfession() {
        return txtProfession;
    }

    public void setTxtProfession(JTextField txtProfession) {
        this.txtProfession = txtProfession;
    }

    public JFormattedTextField getTxtTel() {
        return txtTel;
    }

    public void setTxtTel(JFormattedTextField txtTel) {
        this.txtTel = txtTel;
    }

    public JComboBox getComboMedecinTraitant() {
        return comboMedecinTraitant;
    }

    public void setComboMedecinTraitant(JComboBox comboMedecinTraitant) {
        this.comboMedecinTraitant = comboMedecinTraitant;
    }
    
    public String getMajMalade() {
        return majMalade;
    }

    public int getIdMedecin(int indice) {
        return tabMedecin[indice];
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        AjouterModifMalade.idp = idp;
    }
    
    
    
    
    
}
