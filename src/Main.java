interface Zivotinje {
    void glasanje();
}

class Pas implements Zivotinje{
    public void glasanje() {
        System.out.println("wuff wuff");
    }
}

public class Main {
    public static void main(String[] args) {

        Pas pas = new Pas();
        pas.glasanje();
    }
}