/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;



import Modele.Etablissement;
import Modele.Rdv;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.text.DefaultFormatterFactory;


/**
 *
 * @author ghada
 */
public class AjoutModifRDV extends JFrame {

    public AjoutModifRDV(FenPrincipale fen) {
          
      
        
        this.fen = fen;
        this.setIdm(fen.getIdm());
        this.setIdp(fen.getIdp());
        this.majRDV = fen.getMajRDV();
        this.setIdRDV(fen.getIdRDV());
        
        FenRDV();
        this.setSize(800,300);
        this.setLocation(500, 100);
        
        if(this.getMajRDV().equals("modifier")){
            this.txtNumRDV.setText(fen.getTableRDV().getValueAt(fen.getTableRDV().getSelectedRow(),1).toString());
            this.txtDateRDV.setText(fen.getTableRDV().getValueAt(fen.getTableRDV().getSelectedRow(),0).toString());
        }
    }

    
                         
    private void FenRDV() {
         
        
        lt3 = new JLabel();
        jLabel1 = new JLabel();
        txtNumRDV = new JTextField();
        jLabel2 = new JLabel();
        btEnregistrerRDV = new JButton();
        btAnnulerRDV = new JButton();
        txtDateRDV = new JFormattedTextField();
        jLabel11 = new JLabel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setName("Details RDV"); 

        jLabel1.setFont(new Font("Tahoma", 1, 11)); 
        jLabel1.setText("Numero RDV :");
        
       lt3.setFont(new Font("Tahoma", 1, 18)); 
       lt3.setHorizontalAlignment(SwingConstants.CENTER);
        lt3.setText("Rendez Vous ");

        txtNumRDV.setName("txtNumRDV"); 

        jLabel2.setFont(new Font("Tahoma", 1, 11)); 
        jLabel2.setText("Date RDV :");

        btEnregistrerRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/OK.gif"))); 
        btEnregistrerRDV.setText("Enregistrer");
        btEnregistrerRDV.setName("btEnregistrerRDV"); 
        btEnregistrerRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enregistrer(e);
            }
        });

        btAnnulerRDV.setIcon(new ImageIcon(getClass().getResource("/Pictures/Cancel.gif"))); 
        btAnnulerRDV.setText("Annuler");
        btAnnulerRDV.setName("btAnnulerRDV"); 
        btAnnulerRDV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Annuler(e);
            }
        });

        txtDateRDV.setFormatterFactory(new DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        txtDateRDV.setName("txtDateRDV"); 

        jLabel11.setText("respecter le format : yyyy-mm-dd");

        
this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new GridLayout(2, 2));
        p.add(jLabel1);
        p.add(txtNumRDV);
        p.add(jLabel2);
        p.add(txtDateRDV);
        
        JPanel p2 =new JPanel(new FlowLayout());
        p2.add(btEnregistrerRDV);
        p2.add(btAnnulerRDV);
        
         
       
        
        this.add(p);
        this.add(p2);
        
        add(lt3,BorderLayout.NORTH);
        
        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        
        pack();
    }                       

    private void Annuler(ActionEvent evt) {                                             
       
        this.hide();
    }                                            

    private void Enregistrer(ActionEvent evt) {                                                 
       
        if(this.getMajRDV().equals("ajouter"))
        {
             ResultSet res;
        int idE = 0;
	if(getTxtNumRDV().getText().equals("") || getTxtDateRDV().getText().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Etablissement etab = new Etablissement();
            try{
                res=etab.getEtablissement();
                idE = res.getInt("idEtab");
            }catch(SQLException e){}
            Rdv rdv = new Rdv(Integer.parseInt(getTxtNumRDV().getText()),getTxtDateRDV().getText(),getIdp(),getIdm(),idE);
            rdv.ajoutRDV(rdv);
            this.hide();
	}
            
            
            
            fen.remplirTableRdvByTableMalade();
        }else{
            
            ResultSet res;
        int idE = 0;
	if(getTxtNumRDV().getText().equals("") || getTxtDateRDV().getText().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Etablissement etab = new Etablissement();
            try{
                res=etab.getEtablissement();
                idE = res.getInt("idEtab");
            }catch(SQLException e){}
            Rdv rdv = new Rdv(Integer.parseInt(getTxtNumRDV().getText()),getTxtDateRDV().getText(),getIdp(),getIdm(),idE);
            rdv.modifierRDV(rdv,idRDV);
            this.hide();
	}
            
            
            fen.remplirTableRdvByTableMalade();
        }
    }                                                

    public JFormattedTextField getTxtDateRDV() {
        return txtDateRDV;
    }

    public void setTxtDateRDV(JFormattedTextField txtDateRDV) {
        this.txtDateRDV = txtDateRDV;
    }

    public JTextField getTxtNumRDV() {
        return txtNumRDV;
    }

    public void setTxtNumRDV(JTextField txtNumRDV) {
        this.txtNumRDV = txtNumRDV;
    }
    
   
    public static void main(String args[]) {
       
       
                AjoutModifRDV AjoutModifRDV = new AjoutModifRDV(fen);
                AjoutModifRDV.setVisible(true);
           
       
    }

    public String getMajRDV() {
        return majRDV;
    }

    public void setMajRDV(String majRDV) {
        this.majRDV = majRDV;
    }

    public int getIdp() {
        return idp;
    }

    public int getIdRDV() {
        return idRDV;
    }

    public void setIdp(int idp) {
        AjoutModifRDV.idp = idp;
    }
    

    public void setIdRDV(int idRDV) {
       AjoutModifRDV.idRDV = idRDV;
    }

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        AjoutModifRDV.idm = idm;
    }
    
    private String majRDV;
    private static int idp;
    private static FenPrincipale fen;
    private static int idRDV;
    private static int idm;
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton btAnnulerRDV;
    private javax.swing.JButton btEnregistrerRDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lt3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField txtDateRDV;
    private javax.swing.JTextField txtNumRDV;
    // End of variables declaration                   
}
