package Knjiznica;

import java.util.Comparator;

public class Knjiga implements PosudbaKnjige, Comparable<Knjiga> {
    private String naslovKnjige;
    private boolean dostupno;

    public Knjiga(String naslovKnjige,boolean dostupno) {
        this.naslovKnjige = naslovKnjige;
        this.dostupno = dostupno; //po defaultu je knjiga dostupna
    }

    @Override
    public void posudiKnjigu() {
        setDostupno(false);
    }

    @Override
    public void vratiKnjigu() {
        setDostupno(true);
    }

    @Override
    public int compareTo(Knjiga o) {
        return this.naslovKnjige.compareTo(o.naslovKnjige);
    }

    public void ispisiStanje(Knjiga knjiga){
        String output = "Knjiga '" + knjiga.getNaslovKnjige();
        output+=(knjiga.isDostupno())?"' je dostupna.":"' je posuđena.";
        System.out.println(output);
    }

    public String getNaslovKnjige() {
        return naslovKnjige;
    }

    public boolean isDostupno() {
        return dostupno;
    }

    public void setNaslovKnjige(String naslovKnjige) {
        this.naslovKnjige = naslovKnjige;
    }

    public void setDostupno(boolean dostupno) {
        this.dostupno = dostupno;
    }
}
