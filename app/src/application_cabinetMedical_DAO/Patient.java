
package application_cabinetMedical_DAO;
import application_cabinetMedical_connexion.connexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class Patient {
    private Integer codePatient;
    private String nomPatient;
    private String prenomPatient;
    private String dateNaissance;
    private int telPatient;
    private String sexe;
    private String situationFamiliale;
    private String profession;
    private boolean assure;
    private String adressePatient;
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
        String req ="update patient set "
                + "nomPatient='"+patient.getNomPatient()+
                "' , prenomPatient='" +patient.getPrenomPatient()+
                "' , dateNaissance='"+patient.getDateNaissance()+
                "' ,telPatient="  +patient.getTelPatient()+
                " , sexe='"+patient.getSexe()+
                "' ,situationFamiliale='"  +patient.getSituationFamiliale()+
                "' ,profession='"+patient.getProfession()+
                "' , assure=" +patient.getAssure()+
                " , adressePatient='"+patient.getAdressePatient()+
                "' , idMedecin=" +patient.getIdMedecin()+""
               + " where codePatient="+idp;
        connexion.reqUpdate(req);
    }
    
    public void SupprimerPatient(int idp)
    {
        connexionBD connexion = new connexionBD();
        String req ="delete from patient where codePatient="+idp;
        connexion.reqUpdate(req);
    }
    
    
    public Vector<Patient> find(String choix, String val)throws SQLException{
         String req;
         Vector v=new Vector();
          connexionBD connexion = new connexionBD();
        if(choix.equals("nom")||choix.equals("prenom"))
            req="SELECT * from patient where "+choix+"="+val+"";
        else
            req="SELECT * from patient where "+choix+"='"+val+"'";
        
        ResultSet rs=connexion.St.executeQuery(req);
        while(rs.next()){
            Vector vi=new Vector();
            vi.add(rs.getString("nomPatient"));
            vi.add(rs.getString("prenomPatient"));
            vi.add(rs.getString("dateNaissance"));
            vi.add(rs.getString("telPatient"));
            vi.add(rs.getString("sexe"));
            vi.add(rs.getString("situationFamiliale"));
            vi.add(rs.getString("profession"));
            vi.add(rs.getString("assure"));
            vi.add(rs.getString("adressePatient"));
            v.add(vi);
            
        }
        return v;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codePatient != null ? codePatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
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
        return "Modele.patient[ codePatient=" + codePatient + " ]";
    }
    
}
