
package Vue;

import Controleur.*;
import Modele.Etablissement;
import Modele.Medecin;
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
public class FrameNewMedecin extends JFrame {
    
    private JButton btAnnulerNewMedecin;
    private JButton btEnregistrerNewMedecin;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;
    private JLabel l7;
    private JTextField txtLoginMedecin;
    private JTextField txtNomMedecin;
    private JTextField txtPasswordMedecin;
    private JTextField txtPrenomMedecin;
    private JTextField txtSpecialite;
    private JTextField txtTelMedecin;
    
 
   
    public FrameNewMedecin() {
        framenew();
       this.setLocation(500, 100);
        this.setSize(800, 300);
        
    }

    
                        
    private void framenew() {

        l1 = new JLabel();
        txtNomMedecin = new JTextField();
        l2 = new JLabel();
        txtPrenomMedecin = new JTextField();
        l3 = new JLabel();
        txtSpecialite = new JTextField();
        l4 = new JLabel();
        txtTelMedecin = new JTextField();
        l5 = new JLabel();
        l6 = new JLabel();
        txtLoginMedecin = new JTextField();
        l7 = new JLabel();
        txtPasswordMedecin = new JTextField();
        btAnnulerNewMedecin = new JButton();
        btEnregistrerNewMedecin = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        l1.setText("Nom de medecin :");

        l2.setText("Prenom :");

        l3.setText("Specialite :");

        l4.setText("Telephone :");

        l5.setFont(new Font("Tahoma", 3, 24)); 
        l5.setText("Nouveau Medecin");
        l5.setHorizontalAlignment(SwingConstants.CENTER);

        l6.setText("Login :");

        l7.setText("Mot de passe :");

        btAnnulerNewMedecin.setText("Annuler");
        btAnnulerNewMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Annuler(e);
            }
        });

        btEnregistrerNewMedecin.setText("Enregistrer");
        btEnregistrerNewMedecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enregistrer(e);
            }
        });

        
        this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new GridLayout(3, 4));
        p.add(l1);
        p.add(txtNomMedecin);
        p.add(l2);
        p.add(txtPrenomMedecin);
        p.add(l3);
        p.add(txtSpecialite);
        p.add(l4);
        p.add(txtTelMedecin);
         p.add(l6);
        p.add(txtLoginMedecin);
         p.add(l7);
        p.add(txtPasswordMedecin);
        
        
        JPanel p2 =new JPanel(new FlowLayout());
        p2.add(btEnregistrerNewMedecin);
        p2.add(btAnnulerNewMedecin);
        
         
       
        
        this.add(p);
        this.add(p2);
        
        add(l5,BorderLayout.NORTH);
     
        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        pack();
    }                        

                                                     

                                                       

    public JTextField getTxtLoginMedecin() {
        return txtLoginMedecin;
    }

    public JTextField getTxtNomMedecin() {
        return txtNomMedecin;
    }

    public JTextField getTxtPasswordMedecin() {
        return txtPasswordMedecin;
    }

    public JTextField getTxtPrenomMedecin() {
        return txtPrenomMedecin;
    }

    public JTextField getTxtSpecialite() {
        return txtSpecialite;
    }

    public JTextField getTxtTelMedecin() {
        return txtTelMedecin;
    }
    
    private void Annuler(ActionEvent evt) {
        this.hide();
    }
    
    private void Enregistrer(ActionEvent evt) {
        
       ResultSet res;
        int idE = 0;
	if(getTxtLoginMedecin().getText().equals("") || getTxtPasswordMedecin().getText().equals("") || getTxtNomMedecin().getText().equals("") || getTxtPrenomMedecin().getText().equals("") || getTxtSpecialite().getText().equals("") || getTxtTelMedecin().getText().equals(""))
	{
            JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
        }else{
            Etablissement etab = new Etablissement();
            try{
                res=etab.getEtablissement();
                res.next();
                idE = res.getInt("idEtab");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"erreur \n"+e.getMessage());
            }
            Medecin med = new Medecin(getTxtLoginMedecin().getText(),getTxtPasswordMedecin().getText(),getTxtNomMedecin().getText(),getTxtPrenomMedecin().getText(),getTxtSpecialite().getText(),Integer.parseInt(getTxtTelMedecin().getText()),idE);
            med.ajoutMedecin(med);
            this.hide();
	}
   
        
        
        
    }
    
    
   
    public static void main(String args[]) {
        
        
               FrameNewMedecin frameNewMedecin = new FrameNewMedecin();
               frameNewMedecin.setVisible(true);
            }
       

                 
}

