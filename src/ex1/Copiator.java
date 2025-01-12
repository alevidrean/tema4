package ex1;

import java.io.Serializable;

enum Copiere{
    A3,
    A4
}

/**
 * Clasa derivata din clasa de baza EchipamenteElectronice
 * @author Vidrean Alexandra-Maria
 */
public class Copiator extends Echipament implements Serializable {

    private int nrpag;
    private Copiere modcopiere;
    /**
     * Constructor ce il extinde pe cel din clasa de baza
     * @param denumire - denumire echipament
     * @param nr_inv - numar inventar
     * @param pret - pret echipament
     * @param zona - zona magazin
     * @param t - situatie echipament
     * @param tip situatie echipament
     * @param nrpag - numarul de pagini/toner
     * @param modcopiere - formatul de copiere
     */

    public Copiator(String denumire, int nr_inv, double pret, String zona, Tip t,String tip,int nrpag,Copiere modcopiere) {
        super(denumire, nr_inv, pret, zona, t);
        this.nrpag=nrpag;
        this.modcopiere=modcopiere;
    }


    /**
     * Setter care seteaza formatul de copiere
     * @param format
     */
public void setModcopiere(Copiere format)
{
    this.modcopiere=format;
}


    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile copiatoarelor
     */
    @Override
    public String toString()
    {
        return super.toString() + "," + nrpag + "," + modcopiere ;

    }
}
