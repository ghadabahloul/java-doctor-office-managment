
package DAO;

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
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e"),
    @NamedQuery(name = "Etablissement.findByIdEtab", query = "SELECT e FROM Etablissement e WHERE e.idEtab = :idEtab"),
    @NamedQuery(name = "Etablissement.findByNomEtab", query = "SELECT e FROM Etablissement e WHERE e.nomEtab = :nomEtab"),
    @NamedQuery(name = "Etablissement.findByAdresseEtab", query = "SELECT e FROM Etablissement e WHERE e.adresseEtab = :adresseEtab"),
    @NamedQuery(name = "Etablissement.findByTelEtab", query = "SELECT e FROM Etablissement e WHERE e.telEtab = :telEtab")})
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEtab")
    private Integer idEtab;
    @Basic(optional = false)
    @Column(name = "nomEtab")
    private String nomEtab;
    @Basic(optional = false)
    @Column(name = "adresseEtab")
    private String adresseEtab;
    @Basic(optional = false)
    @Column(name = "telEtab")
    private int telEtab;

    public Etablissement() {
    }

    public Etablissement(Integer idEtab) {
        this.idEtab = idEtab;
    }

    public Etablissement(Integer idEtab, String nomEtab, String adresseEtab, int telEtab) {
        this.idEtab = idEtab;
        this.nomEtab = nomEtab;
        this.adresseEtab = adresseEtab;
        this.telEtab = telEtab;
    }

    public Integer getIdEtab() {
        return idEtab;
    }

    public void setIdEtab(Integer idEtab) {
        this.idEtab = idEtab;
    }

    public String getNomEtab() {
        return nomEtab;
    }

    public void setNomEtab(String nomEtab) {
        this.nomEtab = nomEtab;
    }

    public String getAdresseEtab() {
        return adresseEtab;
    }

    public void setAdresseEtab(String adresseEtab) {
        this.adresseEtab = adresseEtab;
    }

    public int getTelEtab() {
        return telEtab;
    }

    public void setTelEtab(int telEtab) {
        this.telEtab = telEtab;
    }
    
    public ResultSet getEtablissement()
    {
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from etablissement");
        try{
        resSect.next();
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"erreur \n"+e.getMessage());
        }
        return resSect;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtab != null ? idEtab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.idEtab == null && other.idEtab != null) || (this.idEtab != null && !this.idEtab.equals(other.idEtab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modele.Etablissement[ idEtab=" + idEtab + " ]";
    }
    
}
