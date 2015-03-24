/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DAO.Patient;

/**
 *
 * @author GHAWAR
 */
public class CtrlSupprimerPatient {
    public CtrlSupprimerPatient(){
    }
    
    public void supprimerPatient(int idp){
            Patient patient = new Patient();
            patient.SupprimerPatient(idp);
    }
}
