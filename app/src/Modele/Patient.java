
package Modele;
import connexion.connexionBD;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByCodePatient", query = "SELECT p FROM Patient p WHERE p.codePatient = :codePatient"),
    @NamedQuery(name = "Patient.findByNomPatient", query = "SELECT p FROM Patient p WHERE p.nomPatient = :nomPatient"),
    @NamedQuery(name = "Patient.findByPrenomPatient", query = "SELECT p FROM Patient p WHERE p.prenomPatient = :prenomPatient"),
    @NamedQuery(name = "Patient.findByDateNaissance", query = "SELECT p FROM Patient p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Patient.findByTelPatient", query = "SELECT p FROM Patient p WHERE p.telPatient = :telPatient"),
    @NamedQuery(name = "Patient.findBySexe", query = "SELECT p FROM Patient p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Patient.findBySituationFamiliale", query = "SELECT p FROM Patient p WHERE p.situationFamiliale = :situationFamiliale"),
    @NamedQuery(name = "Patient.findByProfession", query = "SELECT p FROM Patient p WHERE p.profession = :profession"),
    @NamedQuery(name = "Patient.findByAssure", query = "SELECT p FROM Patient p WHERE p.assure = :assure"),
    @NamedQuery(name = "Patient.findByAdressePatient", query = "SELECT p FROM Patient p WHERE p.adressePatient = :adressePatient"),
    @NamedQuery(name = "Patient.findByIdMedecin", query = "SELECT p FROM Patient p WHERE p.idMedecin = :idMedecin")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codePatient")
    private Integer codePatient;
    @Basic(optional = false)
    @Column(name = "nomPatient")
    private String nomPatient;
    @Basic(optional = false)
    @Column(name = "prenomPatient")
    private String prenomPatient;
    @Basic(optional = false)
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private String dateNaissance;
    @Basic(optional = false)
    @Column(name = "telPatient")
    private int telPatient;
    @Basic(optional = false)
    @Column(name = "Sexe")
    private String sexe;
    @Basic(optional = false)
    @Column(name = "situationFamiliale")
    private String situationFamiliale;
    @Basic(optional = false)
    @Column(name = "profession")
    private String profession;
    @Basic(optional = false)
    @Column(name = "assure")
    private boolean assure;
    @Basic(optional = false)
    @Column(name = "adressePatient")
    private String adressePatient;
    @Basic(optional = false)
    @Column(name = "idMedecin")
    private int idMedecin;

    public Patient() {
    }

    public Patient(Integer codePatient) {
        this.codePatient = codePatient;
    }

    public Patient(String nomPatient, String prenomPatient, String dateNaissance, int telPatient, String sexe, String situationFamiliale, String profession, boolean assure, String adressePatient, int idMedecin) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance;
        this.telPatient = telPatient;
        this.sexe = sexe;
        this.situationFamiliale = situationFamiliale;
        this.profession = profession;
        this.assure = assure;
        this.adressePatient = adressePatient;
        this.idMedecin = idMedecin;
    }

    public Integer getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(Integer codePatient) {
        this.codePatient = codePatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getTelPatient() {
        return telPatient;
    }

    public void setTelPatient(int telPatient) {
        this.telPatient = telPatient;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean getAssure() {
        return assure;
    }

    public void setAssure(boolean assure) {
        this.assure = assure;
    }

    public String getAdressePatient() {
        return adressePatient;
    }

    public void setAdressePatient(String adressePatient) {
        this.adressePatient = adressePatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }
    
    public ResultSet getPatient(int idp)
    {
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from patient where codePatient="+idp);
        return resSect;
    }
    public ResultSet getlesPatient()
    {
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from patient");
        connexion.deconnection();
        return resSect;
    }
	
    public void ajoutPatient(Patient patient)
    {
        connexionBD connexion = new connexionBD();
        String req ="insert into patient(nomPatient,prenomPatient,dateNaissance,telPatient,sexe,situationFamiliale,profession,assure,adressePatient,idMedecin) values('"+patient.getNomPatient()+"','"+patient.getPrenomPatient()+"','"+patient.getDateNaissance()+"',"+patient.getTelPatient()+",'"+patient.getSexe()+"','"+patient.getSituationFamiliale()+"','"+patient.getProfession()+"',"+patient.getAssure()+",'"+patient.getAdressePatient()+"',"+patient.getIdMedecin()+")";
        connexion.reqUpdate(req);
    }
    
    public void modifierPatient(Patient patient,int idp)
    {
        connexionBD connexion = new connexionBD();
        String req ="update patient set nomPatient='"+patient.getNomPatient()+"' and prenomPatient='"
                +patient.getPrenomPatient()+"' and dateNaissance='"+patient.getDateNaissance()+"' and telPatient="
                +patient.getTelPatient()+" and sexe='"+patient.getSexe()+"' and situationFamiliale='"
                +patient.getSituationFamiliale()+"' and profession='"+patient.getProfession()+"' and assure="
                +patient.getAssure()+" and adressePatient='"+patient.getAdressePatient()+"' and idMedecin="
                +patient.getIdMedecin()+" where codePatient="+idp;
        connexion.reqUpdate(req);
    }
    
    public void SupprimerPatient(int idp)
    {
        connexionBD connexion = new connexionBD();
        String req ="delete from patient where codePatient="+idp;
        connexion.reqUpdate(req);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePatient != null ? codePatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.codePatient == null && other.codePatient != null) || (this.codePatient != null && !this.codePatient.equals(other.codePatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modele.Patient[ codePatient=" + codePatient + " ]";
    }
    
}
