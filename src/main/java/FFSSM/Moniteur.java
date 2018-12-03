/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    
    private LinkedList<Embauche> myEmployeurs;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, GroupeSanguin groupe, int niveau, Licence l, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, groupe, niveau, l);
        this.numeroDiplome = numeroDiplome;
        myEmployeurs = new LinkedList();
    }
    
    public Moniteur(Personne p, GroupeSanguin groupe, int niveau, Licence l, int numeroDiplome){
        super(p, groupe, niveau,    l);
        this.numeroDiplome = numeroDiplome;
        myEmployeurs = new LinkedList();
    }

    public Club employeur() {
        int res = -1;
        for(int i=0;i<myEmployeurs.size();i++){
            if(!myEmployeurs.get(i).estTerminee()){
                res = i;
            }
        }
        if(res<0){
            return null;
        }
        else{
            return myEmployeurs.get(res).getEmployeur();
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
        myEmployeurs.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return myEmployeurs;
    }

}
