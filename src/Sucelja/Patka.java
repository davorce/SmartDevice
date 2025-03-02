package Sucelja;

public class Patka implements Leti, Pliva {

    @Override
    public void leti() {
        System.out.println("Patka leti.");
    }

    @Override
    public void pliva() {
        System.out.println("Patka pliva.");
    }
}
