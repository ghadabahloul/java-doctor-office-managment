
package application_cabinetMedical_DAO;

import application_cabinetMedical_connexion.connexionBD;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



public class Rdv  {
    private Integer codeRDV;
    private int numRDV;
    private String dateRDV;
    private int codePatient;
    private int idEtab;
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
        this.idMedecin = idMedecin;
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
        String req ="update rdv set numRDV="+rdv.getNumRDV()+", dateRDV='"+rdv.getDateRDV()
               +"', codePatient="+rdv.getCodePatient()+", idMedecin="+rdv.getIdMedecin()
               +", idEtab="+rdv.getIdEtab()+" where codeRDV="+idRDV;
        
        
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
