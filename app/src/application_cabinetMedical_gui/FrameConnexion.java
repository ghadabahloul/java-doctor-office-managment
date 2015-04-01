 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_cabinetMedical_gui;

import application_cabinetMedical_DAO.Medecin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 *
 * @author ghada
 */
public class FrameConnexion extends JFrame {
    
    private JButton btAnnulerConnexion = new JButton();
    private JButton btConnecterConnexion = new JButton();
    private JButton btNouveauMedecin = new JButton();
    private JLabel l1 = new JLabel();
    private JLabel l2 = new JLabel();
    private JLabel l3 = new JLabel();
    private JLabel l4 = new JLabel();
    private JTextField txtLogin = new JTextField();
    private JTextField txtPassword = new JTextField();
    
     

    public FrameConnexion() {
        
        this.setLocation(500, 100);
        this.setSize(500,200);
  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1.setFont(new Font("Tahoma", 1, 11)); 
        l1.setText("Login :");

        l2.setFont(new Font("Tahoma", 1, 11)); 
        l2.setText("Mot de passe :");
        
        l3.setBackground(new Color(240, 20, 107));
        l3.setFont(new Font("Tahoma", 3, 24)); 
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setText("Connection");
        
        l4.setIcon(new ImageIcon(getClass().getResource("/Pictures/BitLocker_icon.gif"))); 

        btConnecterConnexion.setIcon(new ImageIcon(getClass().getResource("/Pictures/OK.gif"))); 
        btConnecterConnexion.setText("Connecter");
        btConnecterConnexion.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
               Connexion(e);
            }
        });

        btAnnulerConnexion.setIcon(new ImageIcon(getClass().getResource("/Pictures/Cancel.gif"))); 
        btAnnulerConnexion.setText("Annuler");
        btAnnulerConnexion.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
               Annuler(e);
            }
        });

       

        btNouveauMedecin.setIcon(new ImageIcon(getClass().getResource("/Pictures/New document.gif"))); 
        btNouveauMedecin.setText("Nouveau Medecin"); 
        btNouveauMedecin.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
              
                FrameNewMedecin frameNewMedecin = new FrameNewMedecin();
                 
                frameNewMedecin.show();
              
            }
        });

        

        this.setLayout(new BorderLayout());
        
        JPanel p=new JPanel(new GridLayout(2, 2));
        p.add(l1);
        p.add(txtLogin);
        p.add(l2);
        p.add(txtPassword);
        
        JPanel p2 =new JPanel(new FlowLayout());
        p2.add(btConnecterConnexion);
        p2.add(btAnnulerConnexion);
        
         JPanel p3 =new JPanel(new FlowLayout());
         p2.add(btNouveauMedecin);
         p2.add(btConnecterConnexion);
         p2.add(btAnnulerConnexion);
       
        
        this.add(p);
        this.add(p2);
        
        add(l3,BorderLayout.NORTH);
        add(l4,BorderLayout.WEST);
        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        
        
        pack();
        
    }

   private void Annuler(ActionEvent evt) {
        this.hide();
    }                         
                       
 private void Connexion(ActionEvent evt) {
      
         ResultSet res;
		if(getTxtLogin().getText().equals("") || getTxtPassword().getText().equals(""))
		{
                    JOptionPane.showMessageDialog(null,"Il manque des attributs"); 
		}else{
                    Medecin med = new Medecin();
                    Medecin med1 = med.getMedecin(getTxtLogin().getText(), getTxtPassword().getText());
                    if(getTxtLogin().getText().equals(med1.getLogin()) && getTxtLogin().getText().equals(med1.getPassword())){
                        FenPrincipale fenP = new FenPrincipale(med1.getIdMedecin());
                        this.hide();
                        fenP.show();
                    }else{
                        JOptionPane.showMessageDialog(null,"Login ou Mot de passe incorrecte.");
                    }
		}
    
    }
                                               
    public JTextField getTxtLogin() {
        return txtLogin;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }
  
    
    
    public static void main(String args[]) {
      
              FrameConnexion frameConnexion  =new FrameConnexion();
              frameConnexion.setVisible(true);
              
            
    }
                    
}
        
        