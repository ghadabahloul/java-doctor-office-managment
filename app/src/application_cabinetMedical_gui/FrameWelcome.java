
package application_cabinetMedical_gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author  ghada
 */

public class FrameWelcome extends JFrame {


    private JLabel l2 = new JLabel();
    private JLabel l3 = new JLabel();
    private JLabel l4 = new JLabel();
    private JProgressBar progress = new JProgressBar();
    
    Thread monThread;
    int rappidite;

    private static FrameWelcome frameWelcome;
   
    public FrameWelcome() {
        
        this.setLocation(500, 100);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        progress.setForeground(new Color(255, 51, 51));

      

        l2.setFont(new Font("Algerian", 1, 16)); 
        l2.setForeground(new Color(255, 0, 0));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setText("Cabinet medicale");

        l3.setFont(new Font("Elephant", 1, 18)); 
        l3.setForeground(new Color(0, 51, 255));
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setText("Realisé par Ghada Bahloul");

        l4.setIcon(new ImageIcon(getClass().getResource("/Pictures/caducee-soins-medicaux.GIF"))); 

            this.setLayout(new BorderLayout());
           
            JPanel p = new JPanel();
            
            
            p.setLayout(new GridLayout(2,1));
            p.add(l2);
            p.add(l3);

            this.add(p);
        
            
        add(l4,BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(progress, BorderLayout.SOUTH);

        pack();
    }

    
     

    public void showFrame(){
        frameWelcome.show();
    }
    public void hideFrame(){
        frameWelcome.hide();
    }
    
    
    
    public static void main(String args[]) {
        
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                frameWelcome=new FrameWelcome();
                frameWelcome.setVisible(true);
                frameWelcome.go(150);
            }
        });
    }

    public void go(int rappid) {
        rappidite = rappid;
        
        monThread = new Thread(new MonRunnable());
        monThread.start();
    }

    public class MonRunnable implements Runnable {

        public void run() {
            for (int j = 1; j <= 100; j++) // on fait une boucle pour que la JProgressBar "avance"
            {
                progress.setValue(j);
                try {
                    monThread.sleep(rappidite);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            frameWelcome.hide();
            FrameConnexion fen = new FrameConnexion();
            fen.show();
        }
    }
  
   
   

}