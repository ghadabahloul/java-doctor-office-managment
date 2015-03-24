/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connexion.connexionBD;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GHAWAR
 */
@Entity
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation_1.findAll", query = "SELECT c FROM Consultation_1 c"),
    @NamedQuery(name = "Consultation_1.findByCodeConsultation", query = "SELECT c FROM Consultation_1 c WHERE c.codeConsultation = :codeConsultation"),
    @NamedQuery(name = "Consultation_1.findByDateConsultation", query = "SELECT c FROM Consultation_1 c WHERE c.dateConsultation = :dateConsultation"),
    @NamedQuery(name = "Consultation_1.findByCodeRDV", query = "SELECT c FROM Consultation_1 c WHERE c.codeRDV = :codeRDV"),
    @NamedQuery(name = "Consultation_1.findByCodePatient", query = "SELECT c FROM Consultation_1 c WHERE c.codePatient = :codePatient"),
    @NamedQuery(name = "Consultation_1.findByIdEtab", query = "SELECT c FROM Consultation_1 c WHERE c.idEtab = :idEtab")})
public class Consultation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codeConsultation")
    private Integer codeConsultation;
    @Basic(optional = false)
    @Column(name = "dateConsultation")
    @Temporal(TemporalType.TIMESTAMP)
    private String dateConsultation;
    @Basic(optional = false)
    @Lob
    @Column(name = "motif")
    private String motif;
    @Basic(optional = false)
    @Lob
    @Column(name = "resultExamClinique")
    private String resultExamClinique;
    @Basic(optional = false)
    @Lob
    @Column(name = "diagnostic")
    private String diagnostic;
    @Basic(optional = false)
    @Lob
    @Column(name = "resultExamParaclinique")
    private String resultExamParaclinique;
    @Basic(optional = false)
    @Lob
    @Column(name = "traitementPatient")
    private String traitementPatient;
    @Basic(optional = false)
    @Column(name = "codeRDV")
    private int codeRDV;
    @Basic(optional = false)
    @Column(name = "codePatient")
    private int codePatient;
    @Basic(optional = false)
    @Column(name = "idEtab")
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
        String req ="insert into Consultation(dateConsultation,motif,resultExamClinique,diagnostic,resultExamParaclinique,traitementPatient,codeRDV,codePatient,idEtab) values('"
                +consult.getDateConsultation()+"','"+consult.getMotif()+"','"+consult.getResultExamClinique()+"','"
                +consult.getDiagnostic()+"','"+consult.getResultExamParaclinique()+"','"+consult.getTraitementPatient()+"',"
                +consult.getCodeRDV()+","+consult.getCodePatient()+","+consult.getIdEtab()+")";
        JOptionPane.showMessageDialog(null,consult.getDateConsultation());
        connexion.reqUpdate(req);
    }
    
    public void modifierConsultation(Rdv rdv,int idRDV)
    {
        connexionBD connexion = new connexionBD();
        String req ="update rdv set numRDV="+rdv.getNumRDV()+" and dateRDV='"+rdv.getDateRDV()
                +"' and codePatient="+rdv.getCodePatient()+" and idEtab="+rdv.getIdEtab()
                +" where codeRDV="+idRDV;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "Modele.Consultation_1[ codeConsultation=" + codeConsultation + " ]";
    }
    
}
