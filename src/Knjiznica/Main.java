package Knjiznica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Knjiga> popisKnjiga = new ArrayList<>();
        popisKnjiga.add(new Knjiga("Filozofija novca",true));
        popisKnjiga.add(new Knjiga("Kutija u obliku srca",true));
        popisKnjiga.add(new Knjiga("Atomske navike",false));
        popisKnjiga.add(new Knjiga("Mehanika fluida",false));
        popisKnjiga.add(new Knjiga("Statika II",true));

        Collections.sort(popisKnjiga);

        System.out.println("Sortirani popis knjiga i status iste: ");
        System.out.println("\n### Stanje knjiga ###");
        for (Knjiga k : popisKnjiga) {
            k.ispisiStanje(k);
        }
        System.out.println("\n### Popis knjiga ###");
        for (Knjiga k : popisKnjiga) {
            System.out.println(" * " + k.getNaslovKnjige());
        }

    }

}

