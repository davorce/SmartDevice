package Studenti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Pero", 4));
        studenti.add(new Student("Mia", 5));
        studenti.add(new Student("Ivica", 2));

        Collections.sort(studenti);//Prvi nacin sortiranja

        studenti.sort(Comparator.reverseOrder());//Drugi nacin za soritiranje

        for (Student s : studenti) {
            System.out.println(s);
        }

    }
}
