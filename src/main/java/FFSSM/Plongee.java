/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    public HashSet<Plongeur> palanquee;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        palanquee = new HashSet();
    }

    public void ajouteParticipant(Plongeur participant) {
        palanquee.add(participant);
    }

    public Calendar getDate() {
        return date;
    }
    
    public HashSet<Plongeur> getParticipants(){
        return palanquee;
    }

    public boolean estConforme() {
        if(!chefDePalanquee.estValide(date)){
            return false;
        }
        boolean res = true;
        for(Plongeur p: palanquee){
            if(!p.estValide(date)){
                res=false;
            }
        }
        return res;
    }

}
