package ex1;

import java.io.Serializable;

enum Mod {
    color,
    alb_negru
}

/**
 * Clasa derivata din clasa de baza Echipament
 * @author Vidrean Alexandra-Maria
 */

public class Imprimanta extends Echipament implements Serializable {
    private int nppm;
    private String rezolutie;
    private int cartus;
    private Mod m;

    /**
     * Constructor ce il extinde pe cel din clasa de baza
     * @param denumire - denumire echipament
     * @param nr_inv -nr inventar
     * @param pret - pret echipament
     * @param zona - zona magazin
     * @param t - tip echipament
     * @param tip - tip echipament
     * @param nppm - pagini scrise pe minut
     * @param rezolutie - rezolutie(numar de puncte per inch)
     * @param cartus - numarul de pagini/cartus
     * @param m - modul de tiparire
     */

    public Imprimanta(String denumire, int nr_inv, double pret, String zona, Tip t,String tip,int nppm,String rezolutie,int cartus,Mod m) {

        super(denumire, nr_inv, pret, zona, t);
this.nppm=nppm;
this.rezolutie=rezolutie;
this.cartus=cartus;
this.m=m;

    }

    /**
     * Setter care seteaza modul de tiparire al imprimantelor, acesta poate fi color sau alb negru
     * @param scriere
     */
    public void modificaremodscriere(Mod scriere)
    {
        this.m=scriere;
    }
    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile imprimantelor
     */
    @Override
    public String toString()
    {
return  super.toString() + "," + nppm + "," + rezolutie + "," + cartus + "," + m ;
    }
}
