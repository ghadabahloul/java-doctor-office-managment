

package application_cabinetMedical_DAO;
import application_cabinetMedical_connexion.connexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;



 public class Medecin  {
      
    private Integer idMedecin;
    private String login;
    private String password;
    private String nomMedecin;
    private String prenomMedecin;
    private String specialite;
    private int telMedecin;
    private int idEtab;

    public Medecin() {
    }

    public Medecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Medecin(String login, String password, String nomMedecin, String prenomMedecin, String specialite, int telMedecin, int idEtab) {
        /*int id = 0;
        try{
            ResultSet res;
            connexionBD connexion = new connexionBD();
            res = connexion.reqSelection("select * from medecin");
            id = res.getRow();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        this.idMedecin = id+1;*/
        this.login = login;
        this.password = password;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
        this.specialite = specialite;
        this.telMedecin = telMedecin;
        this.idEtab = idEtab;
    } 
    
    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public void setPrenomMedecin(String prenomMedecin) {
        this.prenomMedecin = prenomMedecin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getTelMedecin() {
        return telMedecin;
    }

    public void setTelMedecin(int telMedecin) {
        this.telMedecin = telMedecin;
    }

    public int getIdEtab() {
        return idEtab;
    }

    public void setIdEtab(int idEtab) {
        this.idEtab = idEtab;
    }
    
    public Medecin getMedecin(String login,String pwd)
    {
        Medecin med = null;
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        try{
            resSect = connexion.reqSelection("select * from medecin where login='"+login+"' and password='"+pwd+"'");
            resSect.next();
            med = new Medecin(resSect.getString("login"),resSect.getString("password"),resSect.getString("nomMedecin"),resSect.getString("prenomMedecin"),resSect.getString("specialite"),resSect.getInt("telMedecin"),resSect.getInt("idEtab"));
            med.setIdMedecin(resSect.getInt("idMedecin"));
        }catch(SQLException ex){
                
        }
        return med;
    }
    
    public int getIdMedecin(String nomMedecin)
    {
        ResultSet resSect;
        int id =0;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from medecin where nomMedecin='"+nomMedecin+"'");
        try{
            resSect.next();
            id = resSect.getInt("idMedecin");
        }catch(SQLException ex){
                
        }
        return id;
    }
    
    public Medecin getMedecinById(int idm)
    {
        Medecin med = null;
        ResultSet resSect;
        connexionBD connexion = new connexionBD();
        resSect = connexion.reqSelection("select * from medecin where idMedecin="+idm);
        try{
            resSect.next();
            med = new Medecin(resSect.getString("login"),resSect.getString("password"),resSect.getString("nomMedecin"),resSect.getString("prenomMedecin"),resSect.getString("specialite"),resSect.getInt("telMedecin"),resSect.getInt("idEtab"));
        }catch(SQLException ex){}
        return med;
    }
	
    public void ajoutMedecin(Medecin medecin)
    {
        connexionBD connexion = new connexionBD();
        String req ="insert into medecin(login,password,nomMedecin,prenomMedecin,specialite,telMedecin,idEtab) values('"+medecin.getLogin()+"','"+medecin.getPassword()+"','"+medecin.getNomMedecin()+"','"+medecin.getPrenomMedecin()+"','"+medecin.getSpecialite()+"',"+medecin.getTelMedecin()+","+medecin.getIdEtab()+")";
        connexion.reqUpdate(req);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedecin != null ? idMedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Medecin)) {
            return false;
        }
        Medecin other = (Medecin) object;
        if ((this.idMedecin == null && other.idMedecin != null) || (this.idMedecin != null && !this.idMedecin.equals(other.idMedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modele.Medecin[ idMedecin=" + idMedecin + " ]";
    }
    
}
