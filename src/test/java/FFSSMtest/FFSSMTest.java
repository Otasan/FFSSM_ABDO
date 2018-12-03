/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSMtest;

import FFSSM.*;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aabdo
 */
public class FFSSMTest {
    
    Calendar naissance;
    Calendar licence;
    Calendar embauche;
    Personne p1;
    Plongeur pj1;
    Moniteur m1;
    Club emp1;
    Embauche emb1;
    Licence l1;
    Plongee pl1;
    
    @Before
    public void setUp() {
        naissance=Calendar.getInstance();
        naissance.set(1980, 12, 12);
        licence=Calendar.getInstance();
        licence.set(2000, 12, 12);
        embauche = Calendar.getInstance();
        embauche.set(2000, 06, 01);
        p1=new Personne("1","Palleschi","Jordan","Belgique","0123456789", naissance);
        l1 = new Licence(p1,"1",licence,12,null);
        pj1 = new Plongeur(p1, GroupeSanguin.AMOINS, 12, l1);
        m1 = new Moniteur(p1, GroupeSanguin.AMOINS, 12, l1, 1);
        emp1= new Club(m1,"Fesssesssm","9876543210");
        pl1= new Plongee(null,m1,embauche,9000,1);
        pl1.ajouteParticipant(pj1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testPlongeurValide(){
        Calendar date = (Calendar) licence.clone();
        date.add(Calendar.MONTH, 1);
        assertTrue("n'est pas valide",pj1.estValide(date));
        date.add(Calendar.YEAR, 1);
        assertFalse("est valide",pj1.estValide(date));
    }
    
    @Test
    public void testAjouterLicenLicences(){
        assertEquals(1, pj1.nbLicences());
        pj1.ajouteLicence(new Licence(pj1,"1",embauche,12,null));
        assertEquals(2, pj1.nbLicences());
    }
}
