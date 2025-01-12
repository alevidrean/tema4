package ex1;

import java.io.Serializable;

enum Tip{
    achizitionat,
    expus,
    vandut
}

/**
 * Aceasta clasa reprezinta un echipament implementeaza interfata Serializable
 * @author Vidrean Alexandra-Maria
 * @version 1
 * @since 2024
 */


public class Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona;
    private Tip t;
public String tip;


    /**
     * Constructor clasa echipamente
     * @param denumire - numele echipamentului
     * @param nr_inv - numarul de inventar al echipamentului
     * @param pret - pretul echipamentului
     * @param zona - zona din magazie in care este plasat echipamentul
     * @param t- situatia in care este echipamentul
     */

    public Echipament(String denumire,int nr_inv,double pret,String zona,Tip t)
    {
        this.denumire=denumire;
        this.nr_inv=nr_inv;
        this.pret=pret;
        this.zona=zona;
        this.t=t;
    }
    /**
     * Getter care da acces de citire a variabilei membre care contine denumirea echipamentului electronic din firma
     * @return denumirea echipamentului
     */

public String getDenumire()
{
    return  denumire;
}

    /**
     * Getter care da acces de citire a variabilei membre care contine situatia in case afla un echipament
     * @return situatia echipamentului
     */

public Tip getT()
{
    return t;
}


    /**
     * Seteaza situatia in care se poate afla un echipament: achizitionat, expus sau vandut
     * @param stare
     */
    public void modificarestare(Tip stare)
    {
        this.t=stare;

    }


    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile echipamentelor electronice
     */

@Override
    public String toString()
{
    return  denumire + "," + nr_inv + "," + pret + "," + zona + "," + t.toString();
}



}
