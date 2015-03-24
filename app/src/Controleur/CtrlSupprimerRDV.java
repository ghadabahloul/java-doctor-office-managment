/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DAO.Rdv;

/**
 *
 * @author GHAWAR
 */
public class CtrlSupprimerRDV {
    public CtrlSupprimerRDV(){
    }
    
    public void supprimerRDV(int idRDV){
            Rdv rdv = new Rdv();
            rdv.SupprimerRDV(idRDV);
    }
}
