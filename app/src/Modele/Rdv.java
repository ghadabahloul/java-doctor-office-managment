
package Modele;

import connexion.connexionBD;
import java.io.Serializable;
import java.sql.ResultSet;
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
@Table(name = "rdv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rdv_1.findAll", query = "SELECT r FROM Rdv_1 r"),
    @NamedQuery(name = "Rdv_1.findByCodeRDV", query = "SELECT r FROM Rdv_1 r WHERE r.codeRDV = :codeRDV"),
    @NamedQuery(name = "Rdv_1.findByNumRDV", query = "SELECT r FROM Rdv_1 r WHERE r.numRDV = :numRDV"),
    @NamedQuery(name = "Rdv_1.findByDateRDV", query = "SELECT r FROM Rdv_1 r WHERE r.dateRDV = :dateRDV"),
    @NamedQuery(name = "Rdv_1.findByCodePatient", query = "SELECT r FROM Rdv_1 r WHERE r.codePatient = :codePatient"),
    @NamedQuery(name = "Rdv_1.findByIdMedecin", query = "SELECT r FROM Rdv_1 r WHERE r.idMedecin = :idMedecin"),
    @NamedQuery(name = "Rdv_1.findByIdEtab", query = "SELECT r FROM Rdv_1 r WHERE r.idEtab = :idEtab")})
public class Rdv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codeRDV")
    private Integer codeRDV;
    @Basic(optional = false)
    @Column(name = "numRDV")
    private int numRDV;
    @Basic(optional = false)
    @Column(name = "dateRDV")
    @Temporal(TemporalType.TIMESTAMP)
    private String dateRDV;
    @Basic(optional = false)
    @Column(name = "codePatient")
    private int codePatient;
    @Basic(optional = false)
    @Column(name = "idEtab")
    private int idEtab;
    @Basic(optional = false)
    @Column(name = "idMedecin")
    private int idMedecin;

    public Rdv() {
    }

    public Rdv(Integer codeRDV) {
        this.codeRDV = codeRDV;
    }

    public Rdv(int numRDV, String dateRDV, int codePatient, int idMedecin, int idEtab) {
        this.numRDV = numRDV;
        this.dateRDV = dateRDV;
        this.codePatient = codePatient;
        this.idEtab = idEtab;
    }

    public Integer getCodeRDV() {
        return codeRDV;
    }

    public void setCodeRDV(Integer codeRDV) {
        this.codeRDV = codeRDV;
    }

    public int getNumRDV() {
        return numRDV;
    }

    public void setNumRDV(int numRDV) {
        this.numRDV = numRDV;
    }

    public String getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(String dateRDV) {
        this.dateRDV = dateRDV;
    }

    public int getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(int codePatient) {
        this.codePatient = codePatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }
    
    public int getIdEtab() {
        return idEtab;
    }

    public void setIdEtab(int idEtab) {
        this.idEtab = idEtab;
    }
    
    public ResultSet getlesRDV()
    {
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from rdv");
        connexion.deconnection();
        return resSect;
    }
	
    public void ajoutRDV(Rdv rdv)
    {
        connexionBD connexion = new connexionBD();
        String req ="insert into rdv(numRDV,dateRDV,codePatient,idMedecin,idEtab) values("
                    +rdv.getNumRDV()+",'"+rdv.getDateRDV()+"',"+rdv.getCodePatient()+","
                    +rdv.getIdMedecin()+","+rdv.getIdEtab()+")";
        JOptionPane.showMessageDialog(null,req); 
        connexion.reqUpdate(req);
    }
    
    public void modifierRDV(Rdv rdv,int idRDV)
    {
        connexionBD connexion = new connexionBD();
        String req ="update rdv set numRDV="+rdv.getNumRDV()+" and dateRDV='"+rdv.getDateRDV()
                +"' and codePatient="+rdv.getCodePatient()+" and idMedecin="+rdv.getIdMedecin()
                +" and idEtab="+rdv.getIdEtab()+" where codeRDV="+idRDV;
        connexion.reqUpdate(req);
    }
    
    public void SupprimerRDV(int idRDV)
    {
        connexionBD connexion = new connexionBD();
        String req1 ="delete from rdv where codeRDV="+idRDV;
        connexion.reqUpdate(req1);
        String req2 ="delete from consultation where codeRDV="+idRDV;
        connexion.reqUpdate(req2);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeRDV != null ? codeRDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rdv)) {
            return false;
        }
        Rdv other = (Rdv) object;
        if ((this.codeRDV == null && other.codeRDV != null) || (this.codeRDV != null && !this.codeRDV.equals(other.codeRDV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modele.Rdv_1[ codeRDV=" + codeRDV + " ]";
    }
    
}
