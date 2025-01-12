package ex1;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clasa principala
 * @author Vidrean Alexandra-Maria
 * @version 1
 * @since 2024
 */


public class Lab4 {


    /**
     * Metoda statica pentru serializare
     * @param o - Obiectul de serializat
     * @param fis - fisierul cu extensia ".bin" in care se scrie obiectul
     */
 public static void scrie(Object o, String fis) {
            try{
                FileOutputStream f= new FileOutputStream(fis);
                ObjectOutputStream oos= new ObjectOutputStream(f);
                oos.writeObject(o);
                oos.close();
                f.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * Metoda statica pentru deserializare
     * @param fis - fisierul cu extensia ".bin" din care se citeste obiectul
     * @return obiectele deserializare
     */

    static Object citeste(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("src/ex1/electronice.txt"));


        List<Echipament> echipamentList = new ArrayList<Echipament>();
String[] val;
String tip;
while(scanner.hasNext()) {
     val=scanner.nextLine().split(",");
   String denumire =val[0];
  int nr_inv = Integer.parseInt(val[1]);
   double pret = Double.parseDouble(val[2]);
     String zona = val[3];
     Tip t=Tip.valueOf(val[4]);
      tip=val[5];
     if(tip.equals("Imprimanta"))
     {
         int nppm=Integer.parseInt(val[6]);
         String rezolutie= val[7];
         int cartus=Integer.parseInt(val[8]);
         Mod m=Mod.valueOf(val[9]);
         Imprimanta imprimanta=new Imprimanta(denumire,nr_inv,pret,zona,t,tip,nppm,rezolutie,cartus,m);
         echipamentList.add((Echipament) imprimanta);
     } else if (tip.equals("Copiator")) {
         int nrpag=Integer.parseInt(val[6]);
         Copiere c=Copiere.valueOf(val[7]);
         Copiator copiator=new Copiator(denumire,nr_inv,pret,zona,t,tip,nrpag,c);
         echipamentList.add((Echipament) copiator);
     }
     else if(tip.equals("Sistem"))
     {
         String tip_mon=val[6];
         double tip_proc= Double.parseDouble(val[7]);
         double c_hdd=Double.parseDouble(val[8]);
         Sisteme s=Sisteme.valueOf(val[9]);
         Sistem sistem=new Sistem(denumire,nr_inv,pret,zona,t,tip,tip_mon,tip_proc,c_hdd,s);
         echipamentList.add((Echipament) sistem);
     }
     else
         System.out.println("Nu exista tipul acesta de echipament!");


}
Scanner scanner1=new Scanner(System.in);

do{
    System.out.println("0.exit");
    System.out.println("1.Afisarea tuturor echipamentelor");
    System.out.println("2.Afisarea imprimantelor");
    System.out.println("3.Afisarea copiatoarelor");
    System.out.println("4.Afisarea sistemelor de calcul");
    System.out.println("5.Modificarea starii unui echipament");
    System.out.println("6.Setarea modului de sciere pt imprimanta");
    System.out.println("7.Setarea formatului de copiere pt copiatoare");
    System.out.println("8.Instalarea unui anumit sistem de operare");
    System.out.println("9.Afisarea echipamentelor vandute");
    System.out.println("10.Serializarea");
    System.out.println("11.Deserializarea");
    int opt=scanner1.nextInt();
    switch (opt)
    {
        case 0:System.exit(0);
            break;
        case 1:
for(Echipament e: echipamentList)
{
    System.out.println(e.toString());
}

            break;
        case 2:
            for(Echipament e:echipamentList)
            {
                if(e instanceof Imprimanta)
                    System.out.println(e.toString());
            }
            break;
        case 3:for(Echipament e:echipamentList)
        {
            if(e instanceof Copiator)
                System.out.println(e.toString());
        }
            break;
        case 4:for(Echipament e:echipamentList)
        {
            if(e instanceof Sistem)
                System.out.println(e.toString());
        }
            break;
        case 5:
            System.out.println("Introduceti echipamentul caruia vreti sa ii modificati starea:");
            String denumire=scanner1.next();
            System.out.println("Starea noua:");
            String stare=scanner1.next();

            for(Echipament e: echipamentList)
            {
                if(e.getDenumire().equals(denumire)) {
                    e.modificarestare(Tip.valueOf(stare));
                    System.out.println(e.toString());
                }
            }
            System.out.println();
                break;
        case 6:
            System.out.println("Introduceti Imprimanta caruia vreti sa ii setati modul de scriere");
            String denum=scanner1.next();
            System.out.println("Modul de scriere:");
            String modsci=scanner1.next();
            for(Echipament e:echipamentList)
            {
                if(e instanceof Imprimanta)
                {
                    if(e.getDenumire().equals(denum))
                    {
                        ((Imprimanta) e).modificaremodscriere(Mod.valueOf(modsci));
                        System.out.println(e.toString());
                    }
                }
            }

            break;
        case 7:
            System.out.println("Introduceti numele pentru setarea formatului de copiere");
            String denu=scanner1.next();
            System.out.println("Mod copiere:");
            String copiere=scanner1.next();
            for(Echipament e:echipamentList)
            {
                if(e instanceof Copiator)
                {
                    if(e.getDenumire().equals(denu))
                    {
                        ((Copiator) e).setModcopiere(Copiere.valueOf(copiere));
                        System.out.println(e.toString());
                    }
                }
            }
            break;
        case 8:
            System.out.println("Introduceti numele pentru instalarea sistemului de operare:");
            String den=scanner1.next();
            System.out.println("Introduceti noul sistem de operare:");
            String sist=scanner1.next();
            for(Echipament e:echipamentList)
            {
                if(e instanceof Sistem)
                {
                    if(e.getDenumire().equals(den))
                    {
                        ((Sistem) e).instalare(Sisteme.valueOf(sist));
                        System.out.println(e.toString());
                    }
                }
            }

            break;
        case 9:
            for(Echipament e:echipamentList)
            {
                if(e.getT().equals(Tip.valueOf("vandut")))
                    System.out.println(e.toString());
            }
            break;
        case 10: scrie(echipamentList,"src/ex1/echip.bin");
            System.out.println("Obiectele au fost serializate!");
            break;
        case 11:
            List<Echipament> deserial=new ArrayList<>();
            deserial=(List<Echipament>) citeste("src/ex1/echip.bin");
            System.out.println("Echipamentele au fost deserializate");
            for(Echipament e:echipamentList)
            {
                System.out.println(e.toString());
            }
            break;
        default:
            System.out.println("Ati introdus optiunea gresita!");
            break;
    }

}while(true);


    }
}
