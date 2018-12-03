package FFSSM;

import java.util.Calendar;
import java.util.HashSet;

public class Plongeur extends Personne{
    
    private int niveau;
    private GroupeSanguin myGroupe;
    private HashSet<Licence> myLicences;
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, GroupeSanguin groupe, int niveau, Licence l) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        myLicences = new HashSet();
        myLicences.add(l);
        myGroupe=groupe;
    }
    
    public Plongeur(Personne p,GroupeSanguin groupe, int niveau, Licence l){
        super(p);
        this.niveau = niveau;
        myLicences = new HashSet();
        myLicences.add(l);
        myGroupe=groupe;
    }
    
    public void ajouteLicence(Licence l){
        myLicences.add(l);
    }
    
    public int nbLicences(){
        return myLicences.size();
    }
    
    public int getNiveau(){
        return niveau;
    }
    
    public HashSet<Licence> getLicence(){
        return myLicences;
    }
    
    public boolean estValide(Calendar d){
        boolean res = false;
        for(Licence l :myLicences){
            if(l.estValide(d)){
                res=true;
            }
        }
        return res;
    }
    
    public GroupeSanguin getGroupe(){
        return myGroupe;
    }
    
    @Override
    public String toString(){
        return nom;
    }
}
