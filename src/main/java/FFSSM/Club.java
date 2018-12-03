/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    private HashSet<Plongee> activites;

    public Club(Moniteur president, String nom, String telephone) {
        this.president = president;
        this.nom = nom;
        this.telephone = telephone;
        activites = new HashSet();
    }

    public Set<Plongee> plongeesNonConformes() {
        HashSet<Plongee> res = new HashSet();
        for(Plongee a:activites){
            if(!a.estConforme()){
                res.add(a);
            }
        }
        return res;
    }

    public void organisePlongee(Plongee p) {
        activites.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur president) {
        this.president = president;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "president=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
