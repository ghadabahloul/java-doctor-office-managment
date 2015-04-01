/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_cabinetMedical_DAO;

import application_cabinetMedical_connexion.connexionBD;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


/**
 *
 * @author ghada
 */
public class Consultation  {
    private Integer codeConsultation;
    private String dateConsultation;
    private String motif;
    private String resultExamClinique;
    private String diagnostic;
    private String resultExamParaclinique;
    private String traitementPatient;
    private int codeRDV;
    private int codePatient;
    private int idEtab;

    public Consultation() {
    }

    public Consultation(Integer codeConsultation) {
        this.codeConsultation = codeConsultation;
    }

    public Consultation(String dateConsultation,String motif, String resultExamClinique, String diagnostic, String resultExamParaclinique, String traitementPatient, int codeRDV, int codePatient, int idEtab) {
        this.dateConsultation = dateConsultation;
        this.motif = motif;
        this.resultExamClinique = resultExamClinique;
        this.diagnostic = diagnostic;
        this.resultExamParaclinique = resultExamParaclinique;
        this.traitementPatient = traitementPatient;
        this.codeRDV = codeRDV;
        this.codePatient = codePatient;
        this.idEtab = idEtab;
    }

    public Integer getCodeConsultation() {
        return codeConsultation;
    }

    public void setCodeConsultation(Integer codeConsultation) {
        this.codeConsultation = codeConsultation;
    }

    public String getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(String dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getResultExamClinique() {
        return resultExamClinique;
    }

    public void setResultExamClinique(String resultExamClinique) {
        this.resultExamClinique = resultExamClinique;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getResultExamParaclinique() {
        return resultExamParaclinique;
    }

    public void setResultExamParaclinique(String resultExamParaclinique) {
        this.resultExamParaclinique = resultExamParaclinique;
    }

    public String getTraitementPatient() {
        return traitementPatient;
    }

    public void setTraitementPatient(String traitementPatient) {
        this.traitementPatient = traitementPatient;
    }

    public int getCodeRDV() {
        return codeRDV;
    }

    public void setCodeRDV(int codeRDV) {
        this.codeRDV = codeRDV;
    }

    public int getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(int codePatient) {
        this.codePatient = codePatient;
    }

    public int getIdEtab() {
        return idEtab;
    }

    public void setIdEtab(int idEtab) {
        this.idEtab = idEtab;
    }
    
    public ResultSet getConsultation(int idp,int idRDV)
    {
        ajoutConsultation(this);
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from consultation where codePatient="+idp+" and codeRDV+"+idRDV);
        return resSect;
    }

    
    public void ajoutConsultation(Consultation consult)
    {
        connexionBD connexion = new connexionBD();
        String req ="insert into consultation(dateConsultation,motif,resultExamClinique,diagnostic,resultExamParaclinique,traitementPatient,codeRDV,codePatient,idEtab) values('"
                +consult.getDateConsultation()+"','"+consult.getMotif()+"','"+consult.getResultExamClinique()+"','"
                +consult.getDiagnostic()+"','"+consult.getResultExamParaclinique()+"','"+consult.getTraitementPatient()+"',"
                +consult.getCodeRDV()+","+consult.getCodePatient()+","+consult.getIdEtab()+")";
        JOptionPane.showMessageDialog(null,consult.getDateConsultation());
        connexion.reqUpdate(req);
    }
    
    public void modifierConsultation(Consultation consult,int idRDV)
    {
        connexionBD connexion = new connexionBD();
       String req ="update consultation set  dateConsultation='"+consult.getDateConsultation()
               +"', motif='"+consult.getMotif()+"', resultExamClinique='"+consult.getResultExamClinique()
               +"', diagnostic='"+consult.getDiagnostic()
               +"', resultExamParaclinique='"+consult.getResultExamParaclinique()
               +"' where codeRDV="+idRDV;
        connexion.reqUpdate(req);
    }
    
    public void SupprimerConsultation(int idRDV)
    {
        connexionBD connexion = new connexionBD();
        String req ="delete from rdv where codeRDV="+idRDV;
        connexion.reqUpdate(req);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeConsultation != null ? codeConsultation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.codeConsultation == null && other.codeConsultation != null) || (this.codeConsultation != null && !this.codeConsultation.equals(other.codeConsultation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modele.consultation_1[ codeConsultation=" + codeConsultation + " ]";
    }
    
}
