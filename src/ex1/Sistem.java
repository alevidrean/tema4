package ex1;

import java.io.Serializable;

enum Sisteme{
    windows,
    linux
}

/**
 * Clasa derivata din clasa de baza Echipament care extinde Serializable
 * @author Vidrean Alexandra-Maria
 */
public  class Sistem extends Echipament implements Serializable {
    private String tip_mon;
    private double tip_proc;
    private double c_hdd;
    private Sisteme s;

    /**
     * Constructor ce il extinde pe cel din clasa de baza
     * @param denumire  - denumire echipament
     * @param nr_inv  - nr inventar
     * @param pret - pret echipament
     * @param zona  -zona magazin
     * @param t - tip echipament
     * @param tip -tip echipament
     * @param tip_mon - tipul de monitor al sistemelor de calcul
     * @param tip_proc - viteza unui procesor
     * @param c_hdd - capacitate a HDD
     * @param s - sistemul de operare al sistemelor de calcul
     */
    public Sistem(String denumire, int nr_inv, double pret, String zona, Tip t,String tip,String tip_mon,double tip_proc,double c_hdd,Sisteme s)
    {
        super(denumire, nr_inv, pret, zona, t);
        this.tip_mon=tip_mon;
        this.tip_proc=tip_proc;
        this.c_hdd=c_hdd;
        this.s=s;
    }
    /**
     * Seteaza sistemul de operare al sistemelor de calcul, care poate fi Windows sau Linux
     * @param sisteme
     */
    public void instalare(Sisteme sisteme)
    {
        this.s=sisteme;
    }

    /**
     * Redefinirea metodei toString() din clasa Object, metodă care va fi utilizată pentru afișare
     * @return caracteristicile sistemelor de calcul
     */

    @Override
    public  String toString()
    {
        return  super.toString() + "," + tip_mon + "," + tip_proc + "," + c_hdd + "," + s ;
    }
}
