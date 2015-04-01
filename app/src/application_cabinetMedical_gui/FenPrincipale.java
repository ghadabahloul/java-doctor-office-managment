/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_cabinetMedical_gui;

import Controleur.CtrlImprimerOrdonnance;


import application_cabinetMedical_DAO.Patient;
import application_cabinetMedical_DAO.Rdv;
import application_cabinetMedical_connexion.connexionBD;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ghada
 */
public class FenPrincipale extends JFrame {
    
     private String majMalade ,majConsultation , majRDV;
  
    private DefaultTableModel dt, dt1;
   
    private int tp[];
    private int trdv[];
    private String Nom ,Prenom ,Sexe,Situation_familiale,Profession,Adresse;
    private Date Date_Naissance,Date_RDV;
    private int Telephone;
    private Boolean Assure;
    private int Numero_RDV;
    private String nomMedecin;
    private static int idm,idp,idRDV;

                       
    private JButton btAjouterConsultation= new JButton();
    private JButton btAjouterMalade = new JButton();
    private JButton btAjouterRDV = new JButton();
    private JButton btAnnulerFiltre = new JButton();
    private JButton btFiltrer = new JButton();
    private JButton btImprimerOrdonnance = new JButton();
    private JButton btModifierConsultation = new JButton();
    private JButton btModifierMalade = new JButton();
    private JButton btModifierRDV = new JButton();
    private JButton btSupprimerMalade = new JButton();
    private JButton btSupprimerRDV = new JButton();
    private JComboBox comboFiltre = new JComboBox();
    private JInternalFrame jInternalFrame1= new JInternalFrame() ;
    private JLabel jLabel1= new JLabel();
    private JLabel jLabel2= new JLabel();
    private JLabel jLabel3= new JLabel();
    private JLabel jLabel4= new JLabel();
    private JLabel jLabel5= new JLabel();
    private JLabel jLabel6= new JLabel();
    private JLabel jLabel7= new JLabel();
    
    private JMenu jMenu1 = new JMenu();
    private JMenu jMenu2 = new JMenu();
    private JMenu jMenu3= new JMenu();
    private JMenu jMenu4= new JMenu();
    private JMenu jMenu5= new JMenu();
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenuItem jMenuItem1 = new JMenuItem();
   
    private JScrollPane jScrollPane2 =new JScrollPane();
    private JScrollPane jScrollPane5=new JScrollPane();
    private JScrollPane jScrollPane6=new JScrollPane();
    private JScrollPane jScrollPane8 =new JScrollPane();
    
    private JScrollPane jScrollTableMalade =new JScrollPane();
    private JScrollPane jScrollTableRDV =new JScrollPane();
    private JPopupMenu.Separator jSeparator1 =new JPopupMenu.Separator();
    
    private JMenuItem menuItemAjouterConsultation= new JMenuItem();
    private JMenuItem menuItemAjouterMalade = new JMenuItem();
    private JMenuItem menuItemAjouterRDV = new JMenuItem();
    private JMenuItem menuItemModifierConsultation = new JMenuItem();
    private JMenuItem menuItemModifierMalade = new JMenuItem();
    private JMenuItem menuItemModifierRDV = new JMenuItem();
    private JMenuItem menuItemOrdonnance = new JMenuItem();
    private JMenuItem menuItemParamImp = new JMenuItem();
    private JMenuItem menuItemQuitter= new JMenuItem();
    private JMenuItem menuItemSupprimerMalade = new JMenuItem();
    private JMenuItem menuItemSupprimerRDV = new JMenuItem();
    private JTable tableMalade = new JTable();
    private JTable tableRDV = new JTable();
    private JTextField txtDiagnostic = new JTextField();
    private JTextField txtFiltre = new JTextField();
    private JTextArea txtMotif =new JTextArea();
    private JTextArea txtResExamClinique =new JTextArea();
    private JTextArea txtResExamParaclinique =new JTextArea();
    private JTextArea txtTraitement=new JTextArea();
    
   
    
    public FenPrincipale(int idm) {
        fenPrincipal();
        this.idm = idm;
        

        dt = new DefaultTableModel();
        remplirtableMalade();
        tableMalade.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                remplirTableRdvByTableMalade();
                tableRDV.getSelectionModel().setSelectionInterval(0, 0);
            }
        });
        tableMalade.getSelectionModel().setSelectionInterval(0, 0);
        tableRDV.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                afficheInfosConsultationByTableRDV();
            }
        });
    }

                         
    private void fenPrincipal() {

      

        jInternalFrame1.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setName("Cabinet Medical"); 
        

     
        
        this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new FlowLayout());
        p.add(jScrollTableMalade);
        p.add(jScrollTableRDV);
       
        JPanel p2 =new JPanel(new FlowLayout());
        p2.add(jLabel6);
        p2.add(comboFiltre);
        p2.add(jLabel7);
        p2.add(txtFiltre);
        p2.add(btFiltrer);
        p2.add(btAnnulerFiltre);
       
        
        JPanel p3 =new JPanel(new FlowLayout());
        p3.add(btAjouterMalade);
        p3.add(btModifierMalade);
        p3.add(btSupprimerMalade);
        p3.add(btAjouterConsultation);
        p3.add(btModifierConsultation);
        p3.add(btAjouterRDV);
        p3.add(btModifierRDV);
        p3.add(btSupprimerRDV);
        p3.add(btImprimerOrdonnance);
        
            JPanel p5 =new JPanel(new GridLayout(2,1));
            p5.add(p3);
            p5.add(p2);
           
        JPanel p4 =new JPanel(new GridLayout(2,5));
        p4.add(jLabel2);
        p4.add(jLabel4);
        p4.add(jLabel3);
        p4.add(jLabel5);
        p4.add(jLabel1);
        p4.add(jScrollPane5);
        p4.add(txtDiagnostic);
        p4.add(jScrollPane6);
        p4.add(jScrollPane8);
        p4.add(jScrollPane2);
         
    
        
        this.add(p);
        this.add(p5);
        this.add(p4);
        
        add(p5,BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(p4, BorderLayout.SOUTH);
        
        
        
         jMenu1.add(jMenuItem1);
         jMenu1.add(menuItemParamImp);
         jMenu1.add(jSeparator1);
         jMenu1.add(menuItemQuitter);
         
         jMenu2.add(menuItemAjouterMalade);
         jMenu2.add(menuItemModifierMalade);
         jMenu2.add(menuItemSupprimerMalade);
         
         jMenu3.add(menuItemOrdonnance);
         
         jMenu4.add(menuItemAjouterConsultation);  
         jMenu4.add(menuItemModifierConsultation);
         
         jMenu5.add(menuItemAjouterRDV);
         jMenu5.add(menuItemModifierRDV);
         jMenu5.add(menuItemSupprimerRDV);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu5);
          
        setJMenuBar(jMenuBar1);
        
        

        btImprimerOrdonnance.setIcon(new ImageIcon(getClass().getResource("/Pictures/Print.gif"))); 
        btImprimerOrdonnance.setText("Imprimer Ordonnance");
        btImprimerOrdonnance.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btImprimerOrdonnance.setHorizontalAlignment(SwingConstants.LEFT);
        btImprimerOrdonnance.setBounds(850, 0, 130, 30);
        btImprimerOrdonnance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ImprimerOrdonnance(evt);
            }
        });
       
     

        btAjouterMalade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/New document.gif"))); // NOI18N
        btAjouterMalade.setText("Ajouter Malade");
        btAjouterMalade.setToolTipText("");
        btAjouterMalade.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btAjouterMalade.setHorizontalAlignment(SwingConstants.LEFT);
        btAjouterMalade.setHorizontalTextPosition(SwingConstants.RIGHT);
        btAjouterMalade.setBounds(0, 0, 100, 30);
        btAjouterMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjouterMalade(evt);
            }
        });
        
       
      //  btAjouterMalade.getAccessibleContext().setAccessibleName("btAjouterMalade");
        //btAjouterMalade.getAccessibleContext().setAccessibleDescription("btAjouterMalade");

        btAjouterRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/New document.gif")));
        btAjouterRDV.setText("Ajouter RDV");
        btAjouterRDV.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btAjouterRDV.setHorizontalAlignment(SwingConstants.LEFT);
        btAjouterRDV.setBounds(580, 0, 90, 30);
        btAjouterRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjouterRDV(evt);
            }
        });
        
        

        btModifierRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/Modify.gif"))); 
        btModifierRDV.setText("Modifier RDV");
        btModifierRDV.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btModifierRDV.setHorizontalAlignment(SwingConstants.LEFT);
        btModifierRDV.setBounds(670, 0, 87, 30);
        btModifierRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifierRDV(evt);
            }
        });
        
        

        btModifierMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/Modify.gif"))); 
        btModifierMalade.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btModifierMalade.setHorizontalAlignment(SwingConstants.LEFT);
        btModifierMalade.setText("Modifier Malade");
        btModifierMalade.setBounds(100, 0, 101, 30);
        btModifierMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifierMalade(evt);
            }
        });
       
       

        btSupprimerMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/Delete.gif"))); 
        btSupprimerMalade.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btSupprimerMalade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSupprimerMalade.setText("Supprimer Malade");
        btSupprimerMalade.setBounds(200, 0, 120, 30);
        btSupprimerMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SupprimerMalade(evt);
            }
        });
        
        

        btSupprimerRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/Delete.gif"))); 
        btSupprimerRDV.setText("Supprimer RDV");
        btSupprimerRDV.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btSupprimerRDV.setHorizontalAlignment(SwingConstants.LEFT);
        btSupprimerRDV.setBounds(757, 0, 100, 30);
        btSupprimerRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SupprimerRDV(evt);
            }
        });
        
       

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel1.setText("Traitement Préscrit :");
        jLabel1.setBounds(710, 390, 180, 14);

        txtTraitement.setColumns(20);
        txtTraitement.setRows(5);
        txtTraitement.setName("txtTraitement"); 
        jScrollPane2.setViewportView(txtTraitement);
        jScrollPane2.setBounds(710, 410, 400, 130);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel2.setText("Motif de consultation :");
        jLabel2.setBounds(10, 390, 140, 14);

        txtMotif.setColumns(20);
        txtMotif.setRows(5);
        txtMotif.setFocusCycleRoot(true);
        jScrollPane5.setViewportView(txtMotif);
        jScrollPane5.setBounds(10, 410, 320, 60);

        jLabel3.setFont(new Font("Tahoma", 1, 11)); 
        jLabel3.setText("Resultat de l'examen clinique :");
        jLabel3.setBounds(10, 480, 190, 14);

        jLabel4.setFont(new Font("Tahoma", 1, 11));
        jLabel4.setText("Diagnostic Médical :");
        jLabel4.setBounds(360, 390, 180, 14);

        txtResExamClinique.setColumns(20);
        txtResExamClinique.setRows(5);
        jScrollPane6.setViewportView(txtResExamClinique);
        jScrollPane6.setBounds(10, 500, 320, 70);

        txtResExamParaclinique.setColumns(20);
        txtResExamParaclinique.setRows(5);
        jScrollPane8.setViewportView(txtResExamParaclinique);
        jScrollPane8.setBounds(360, 500, 310, 70);

        jLabel5.setFont(new Font("Tahoma", 1, 11)); 
        jLabel5.setText("Resultats des examens paracliniques :");
        jLabel5.setBounds(360, 480, 220, 14);

        txtDiagnostic.setName("txtDiagnostic"); 
         txtDiagnostic.setBounds(360, 410, 310, 20);
        txtDiagnostic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtDiagnostic(evt);
            }
        });
      
       

        jLabel6.setFont(new Font("Tahoma", 1, 11)); 
        jLabel6.setText("Source de filtre :");
        jLabel6.setBounds(10, 40, 100, 14);

        comboFiltre.setModel(new DefaultComboBoxModel(new String[] { "Nom", "Prenom" }));
        comboFiltre.setBounds(120, 40, 100, 20);

        jLabel7.setFont(new Font("Tahoma", 1, 11)); 
        jLabel7.setText("Text de filtre :");
        jLabel7.setBounds(230, 40, 80, 14);

       
        txtFiltre.setBounds(320, 40, 190, 20);
        btFiltrer.setIcon(new ImageIcon(getClass().getResource("/Pictures/Filter.gif")));
        btFiltrer.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btFiltrer.setHorizontalAlignment(SwingConstants.LEFT);
        btFiltrer.setText("Filtrer");
        btFiltrer.setBounds(520, 40, 60, 23);
        btFiltrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Filter(e);
            }
        });

        btAnnulerFiltre.setIcon(new ImageIcon(getClass().getResource("/Pictures/Cancel.gif"))); 
        btAnnulerFiltre.setText("Annuler Filtre");
        btAnnulerFiltre.setHorizontalAlignment(SwingConstants.LEFT); 
        btAnnulerFiltre.setBounds(583, 40, 140, 25);
        btAnnulerFiltre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  Annuler(e);
            }
        });
        


        tableRDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date RDV", "Numero RDV"
            }
        ));

        jScrollTableRDV.setViewportView(tableRDV);
        jScrollTableRDV.setBounds(880, 70, 250, 310);


        tableMalade.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Date Naissance", "Telephone", "Sexe", "Situation familiale", "Profession", "Assuré", "Adresse"
            }
        ));
 
        jScrollTableMalade.setViewportView(tableMalade);

     
        jScrollTableMalade.setBounds(11, 70, 850, 310);

        btAjouterConsultation.setIcon(new ImageIcon(getClass().getResource("/Pictures/New document.gif"))); 
        btAjouterConsultation.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btAjouterConsultation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btAjouterConsultation.setText("Ajouter Consultation");
        btAjouterConsultation.setBounds(320, 0, 130, 30);
        btAjouterConsultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AjouterConsultation(evt);
            }
        });
      
        

        btModifierConsultation.setIcon(new ImageIcon(getClass().getResource("/Pictures/Modify.gif"))); 
        btModifierConsultation.setText("Modifier Consultation");
        btModifierConsultation.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        btModifierConsultation.setHorizontalAlignment(SwingConstants.LEFT);
        btModifierConsultation.setBounds(450, 0, 130, 30);
        btModifierConsultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifierConsultation(evt);
            }
        });
       
      
        jMenu1.setIcon(new ImageIcon(getClass().getResource("/Pictures/List.gif"))); 
        jMenu1.setText("Fichier");
        jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/Pictures/Go back.gif"))); 
        jMenuItem1.setText("Deconnecter");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1(evt);
            }
        });
       

        menuItemParamImp.setIcon(new ImageIcon(getClass().getResource("/Pictures/Wrench.gif"))); 
        menuItemParamImp.setText("Parametres de l'impression");
       

        menuItemQuitter.setIcon(new ImageIcon(getClass().getResource("/Pictures/Cancel.gif"))); 
        menuItemQuitter.setText("Quitter");
        menuItemQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Quitter(evt);
            }
        });
       

        jMenu2.setIcon(new ImageIcon(getClass().getResource("/Pictures/Folder.gif")));
        jMenu2.setText("Malade");

        menuItemAjouterMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/New document.gif"))); 
        menuItemAjouterMalade.setText("Ajouter Malade");
        menuItemAjouterMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemAjouterMalade(evt);
            }
        });
      

        menuItemModifierMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/Modify.gif"))); 
        menuItemModifierMalade.setText("Modifier Malade");
        menuItemModifierMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ModifierMalade(evt);
            }
        });
        

        menuItemSupprimerMalade.setIcon(new ImageIcon(getClass().getResource("/Pictures/Delete.gif")));
        menuItemSupprimerMalade.setText("Supprimer Malade");
        menuItemSupprimerMalade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemSupprimerMalade(evt);
            }
        });
        

        jMenu5.setIcon(new ImageIcon(getClass().getResource("/Pictures/Folder.gif"))); 
        jMenu5.setText("RDV");

        menuItemAjouterRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/New document.gif"))); 
        menuItemAjouterRDV.setText("Ajouter RDV"); 
        menuItemAjouterRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemAjouterRDV(evt);
            }
        });
       

        menuItemModifierRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/Modify.gif"))); 
        menuItemModifierRDV.setText("Modifier RDV");
        menuItemModifierRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemModifierRDV(evt);
            }
        });
       

        menuItemSupprimerRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/Delete.gif"))); 
        menuItemSupprimerRDV.setText("Supprimer RDV");
        menuItemSupprimerRDV.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSupprimerRDV(evt);
            }
        });
        

        jMenu4.setIcon(new ImageIcon(getClass().getResource("/Pictures/Folder.gif"))); 
        jMenu4.setText("Consultation");

        menuItemAjouterConsultation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/New document.gif"))); 
        menuItemAjouterConsultation.setText("Ajouter Consultation");
        menuItemAjouterConsultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemAjouterConsultation(evt);
            }
        });
       

        menuItemModifierConsultation.setIcon(new ImageIcon(getClass().getResource("/Pictures/Modify.gif"))); 
        menuItemModifierConsultation.setText("Modifier Consultation");
        menuItemModifierConsultation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemModifierConsultation(evt);
            }
        });
        

        jMenu3.setIcon(new ImageIcon(getClass().getResource("/Pictures/Report.gif"))); 
        jMenu3.setText("Rapport et Statistiques");

        menuItemOrdonnance.setIcon(new ImageIcon(getClass().getResource("/Pictures/Print.gif"))); 
        menuItemOrdonnance.setText("Ordonnance");
        menuItemOrdonnance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemOrdonnance(evt);
            }
        });
        

        pack();
    }                       

    private void txtDiagnostic(ActionEvent evt) {                                              
        
        
        
    }                                             

    private void menuItemAjouterMalade(ActionEvent evt) {                                                      
        
        this.setMajMalade("ajouter");
        AjouterModifMalade framedetailsMalade=new AjouterModifMalade(this);
        framedetailsMalade.show();
        
    }                                                     

    private void menuItemModifierMalade(ActionEvent evt) {                                                       
       
        this.setMajMalade("modifier");
        AjouterModifMalade framedetailsMalade=new AjouterModifMalade(this);
        framedetailsMalade.show();
        
    }                                                      

    private void menuItemAjouterConsultation(ActionEvent evt) {                                                            
  
        this.setMajConsultation("ajouter");
        AjoutModifConsultation frameDetailsConsultation=new AjoutModifConsultation(this);
        frameDetailsConsultation.show();
    }                                                           

    private void menuItemModifierConsultation(ActionEvent evt) {                                                             
      
        this.setMajConsultation("modifier");
        AjoutModifConsultation frameDetailsConsultation=new AjoutModifConsultation(this);
        frameDetailsConsultation.show();
    }                                                            

    private void AjouterMalade(ActionEvent evt) {                                                
       
        this.setMajMalade("ajouter");
        AjouterModifMalade framedetailsMalade=new AjouterModifMalade(this);
        framedetailsMalade.show();
        
    }                                               

    private void ModifierMalade(ActionEvent evt) {                                                 
    
        this.setMajMalade("modifier");
         this.setIdp(tp[tableMalade.getSelectedRow()]);
        AjouterModifMalade framedetailsMalade=new AjouterModifMalade(this);
        framedetailsMalade.show();
        
    }                                                

    private void AjouterRDV(ActionEvent evt) {                                             
        
        this.setMajRDV("ajouter");
        this.setIdp(tp[tableMalade.getSelectedRow()]);
        AjoutModifRDV frameAjoutModifRDV =new AjoutModifRDV(this);
        frameAjoutModifRDV.show();
        
    }                                            

    private void ModifierRDV(ActionEvent evt) {                                              
      
        this.setMajRDV("modifier");
        this.setIdp(tp[tableMalade.getSelectedRow()]);
        this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
        AjoutModifRDV frameDetailsRDV=new AjoutModifRDV(this);
        frameDetailsRDV.show();
    }                                             

    private void ImprimerOrdonnance(ActionEvent evt) {                                                     
       
        this.setIdp(this.tp[tableMalade.getSelectedRow()]);
        this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
        CtrlImprimerOrdonnance ctrlImprimerOrdonnance= new CtrlImprimerOrdonnance(this);
        ctrlImprimerOrdonnance.RemplirOrdonnance();
    }                                                    

    private void SupprimerMalade(ActionEvent evt) {                                                  
      
        this.setIdp(this.tp[tableMalade.getSelectedRow()]);
        Patient patient = new Patient();
        patient.SupprimerPatient(idp);
        remplirtableMalade();
    }                                                 

    private void SupprimerRDV(ActionEvent evt) {                                               

        this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);

        Rdv rdv = new Rdv();
        rdv.SupprimerRDV(idRDV);
        remplirTableRdvByTableMalade();
        
    }                                              

    
    private void AjouterConsultation(ActionEvent evt) {                                                      
        
        this.setMajConsultation("ajouter");
           this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
            this.setIdp(this.tp[tableMalade.getSelectedRow()]);
        AjoutModifConsultation frameDetailsConsultation=new AjoutModifConsultation(this);
        frameDetailsConsultation.show();
    }                                                     

    private void ModifierConsultation(ActionEvent evt) {                                                       
        
         this.setMajConsultation("modifier");
         this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
         this.setIdp(this.tp[tableMalade.getSelectedRow()]);
        AjoutModifConsultation frameDetailsConsultation=new AjoutModifConsultation(this);
        frameDetailsConsultation.show();
    }                                                      

    
     private void Filter(ActionEvent evt) {   
     
     
     
     }
    
    private void Quitter(ActionEvent evt) {                                                
       
        this.hide();
    }                                               

    private void menuItemSupprimerMalade(ActionEvent evt) {                                                        

        this.setIdp(this.tp[tableMalade.getSelectedRow()]);
        Patient patient = new Patient();
        patient.SupprimerPatient(idp);
        remplirtableMalade();
    }                                                       

    private void menuItemAjouterRDV(ActionEvent evt) {                                                   
       
        this.setMajRDV("ajouter");
        this.setIdp(trdv[tableMalade.getSelectedRow()]);
        AjoutModifRDV frameDetailsRDV=new AjoutModifRDV(this);
        frameDetailsRDV.show();
        
    }                                                  

    private void menuItemModifierRDV(ActionEvent evt) {                                                    
     
        this.setMajRDV("modifier");
        this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
        AjoutModifRDV frameDetailsRDV=new AjoutModifRDV(this);
        frameDetailsRDV.show();
    }                                                   

    private void menuItemSupprimerRDV(ActionEvent evt) {                                                     
      
        this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
         Rdv rdv = new Rdv();
        rdv.SupprimerRDV(idRDV);
        remplirTableRdvByTableMalade();
    }                                                    

    private void menuItemOrdonnance(ActionEvent evt) {                                                   
       
        this.setIdp(this.tp[tableMalade.getSelectedRow()]);
        this.setIdRDV(this.trdv[tableRDV.getSelectedRow()]);
        CtrlImprimerOrdonnance ctrlImprimerOrdonnance= new CtrlImprimerOrdonnance(this);
        ctrlImprimerOrdonnance.RemplirOrdonnance();
    }                                                  

    private void jMenuItem1(ActionEvent evt) {                                           
       
        this.hide();
        FrameConnexion frameConnexion = new FrameConnexion();
        frameConnexion.show();
    }                                          
    
    public String getMajMalade() {
		return majMalade;
    }
    public String getMajConsultation() {
		return majConsultation;
    }
    public String getMajRDV() {
		return majRDV;
    }

    public JTable getTableMalade() {
        return tableMalade;
    }

    public int getIdm() {
        return idm;
    }

    public void setMajMalade(String majMalade) {
        this.majMalade = majMalade;
    }

    public void setMajConsultation(String majConsultation) {
        this.majConsultation = majConsultation;
    }

    public void setMajRDV(String majRDV) {
        this.majRDV = majRDV;
    }

    public int getIdp() {
        return idp;
    }   

    public void setIdp(int idp) {
        FenPrincipale.idp = idp;
    }
    
    public JTable getTableRDV() {
        return tableRDV;
    }

    public int getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(int idRDV) {
        FenPrincipale.idRDV = idRDV;
    }

    public JTextField getTxtDiagnostic() {
        return txtDiagnostic;
    }

    public JTextArea getTxtMotif() {
        return txtMotif;
    }

    public JTextArea getTxtResExamClinique() {
        return txtResExamClinique;
    }

    public JTextArea getTxtResExamParaclinique() {
        return txtResExamParaclinique;
    }

    public JTextArea getTxtTraitement() {
        return txtTraitement;
    }    
        
    public void remplirtableMalade(){ 
        ResultSet Rs;
        connexionBD con = new connexionBD();
        dt = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Date Naissance", "Telephone", "Sexe", "Situation familiale", "Profession", "Assuré", "Adresse"
            }
        );
        tableMalade.setModel(dt);
        tableMalade.getTableHeader().setReorderingAllowed(false);
        jScrollTableMalade.setViewportView(tableMalade);
        try{
            dt.setRowCount(0);
            Rs =con.reqSelection("Select * From patient where idMedecin="+this.getIdm());
            tp = new int[100];
        	int i=0;
            while(Rs.next()){
                tp[i]=Rs.getInt("codePatient");
                Nom = Rs.getString("nomPatient");
                Prenom = Rs.getString("prenomPatient");
                Date_Naissance = Rs.getDate("dateNaissance");
                Telephone = Rs.getInt("telPatient");
                Sexe = Rs.getString("Sexe");
                Situation_familiale = Rs.getString("situationFamiliale");
                Profession = Rs.getString("profession");
                Assure = Rs.getBoolean("assure");
                Adresse = Rs.getString("adressePatient");
                Object[] objPatient={Nom,Prenom,Date_Naissance,Telephone,Sexe,Situation_familiale,Profession,Assure,Adresse};
                dt.addRow(objPatient);
                i +=1 ;
            }
        }catch(Exception e){
        	JOptionPane.showMessageDialog(null,"Erreur afficher la liste de patients\n"+e.getMessage());
        }  
    }
    public void remplirTableRdvByTableMalade(){
        ResultSet Rs;
        connexionBD con = new connexionBD();
        dt1 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date RDV", "Numero RDV"
            }
        );
        tableRDV.setModel(dt1);
        tableRDV.getTableHeader().setReorderingAllowed(false);
        jScrollTableRDV.setViewportView(tableRDV);
        try{
            dt1.setRowCount(0);
            Rs =con.reqSelection("Select * From rdv where idMedecin="+this.getIdm()+" and codePatient="+this.tp[tableMalade.getSelectedRow()]);
            trdv = new int[100];
            int i=0; 
            while(Rs.next()){
                trdv[i]=Rs.getInt("codeRDV");
                Numero_RDV = Rs.getInt("numRDV");
                Date_RDV = Rs.getDate("dateRDV");
                Object[] objRDV={Date_RDV,Numero_RDV};
                dt1.addRow(objRDV);
                i +=1 ;
            }
        }catch(Exception e){
        }  
    }
    public void afficheInfosConsultationByTableRDV(){
        ResultSet Rs;
        connexionBD con = new connexionBD();
        try{
            Rs =con.reqSelection("Select * From consultation where codeRDV="+this.trdv[tableRDV.getSelectedRow()]);
            Rs.next();
            if(Rs.getRow()!=0){
                this.txtMotif.setText(Rs.getString("motif"));
                this.txtResExamClinique.setText(Rs.getString("resultExamClinique"));
                this.txtResExamParaclinique.setText(Rs.getString("resultExamParaclinique"));
                this.txtTraitement.setText(Rs.getString("traitementPatient"));
                this.txtDiagnostic.setText(Rs.getString("diagnostic"));
            }else{
                this.txtMotif.setText("");
                this.txtResExamClinique.setText("");
                this.txtResExamParaclinique.setText("");
                this.txtTraitement.setText("");
                this.txtDiagnostic.setText("");
            }
        }catch(Exception e){}
    }
    
    
    public static void main(String args[]) {
       
      
                new FenPrincipale(idm).setVisible(true);
        
    }
    
    
   
                 
}