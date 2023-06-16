package src.main.java.de.uulm.sp.oop.exercises.e06;

import main.java.de.uulm.sp.oop.exercises.e06.util.Pair;

public class Main {

    public static void main(String[] args) {
        HashMapArray hash = new HashMapArray<String>();

        hash.add(0,"hallo");
        hash.add(1,"Morgen");


        System.out.println(hash.get(0));
        System.out.println(hash.get(1));
        System.out.println(hash.size());

        GradeOverview yo = new GradeOverview();

        main.java.de.uulm.sp.oop.exercises.e06.util.Pair pair1 = new Pair(1.0,1);
        main.java.de.uulm.sp.oop.exercises.e06.util.Pair pair2 = new Pair(3.0,10);

        yo.addTestResult("Mathe", pair1);
        yo.addTestResult("OOP", pair2);

        System.out.println(yo.currentECTS());

        System.out.println(yo.getExamResults("Mathe"));
        System.out.println(yo.getExamResults("Math"));

        System.out.println(yo.totalGradeAverage());
    }
}
