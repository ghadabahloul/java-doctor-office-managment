
package application_cabinetMedical_DAO;

import application_cabinetMedical_connexion.connexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;




public class Etablissement  {
   
    private Integer idEtab;
    private String nomEtab;
    private String adresseEtab;
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
