package src.test.java.de.uulm.sp.oop.exercises.e06;
import main.java.de.uulm.sp.oop.exercises.e06.util.Pair;
import org.junit.Test;
import src.main.java.de.uulm.sp.oop.exercises.e06.GradeOverview;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
public class GradeOverviewTests {
    @org.junit.jupiter.api.Test
    public void addTestResultsTest(){
        GradeOverview test1 = new GradeOverview();
        var add1 = test1.addTestResult("Mathe", new Pair<Double, Integer>(2.0,10));
        System.out.println("[Test addTestResult (1)]");
        System.out.printf("Expected: " + "%s", new Pair<>(2.0,10).toString() + "\n");
        System.out.printf("Actual: " + "%s", add1.toString() + "\n");

        assertEquals(add1, new Pair<Double, Integer>(2.0,10));

        var add2 = test1.addTestResult("OOP", new Pair<Double, Integer>(1.0,20));
        System.out.println("[Test addTestResult (2)]");
        System.out.printf("Expected: " + "%s", new Pair<>(1.0,20).toString() + "\n");
        System.out.printf("Actual: " + "%s", add2.toString() + "\n");

        assertEquals(add2, new Pair<Double, Integer>(1.0,20));

        var add3 = test1.addTestResult("RA", new Pair<Double, Integer>(3.0,10));
        System.out.println("[Test addTestResult (1)]");
        System.out.printf("Expected: " + "%s", new Pair<>(3.0,10).toString() + "\n");
        System.out.printf("Actual: " + "%s" + "\n", add3.toString());

        assertEquals(add3, new Pair<Double, Integer>(3.0,10));
    }

    @org.junit.jupiter.api.Test
    public void currentECTSTest(){
        GradeOverview test2 = new GradeOverview();

        test2.addTestResult("Mathe", new Pair<Double, Integer>(2.0,10));
        test2.addTestResult("OOP", new Pair<Double, Integer>(2.0,10));
        test2.addTestResult("RA", new Pair<Double, Integer>(2.0,10));

        System.out.println("[Test currentECTS (1)]");
        System.out.printf("Expected: " + "%d" + "\n", 30);
        System.out.printf("Actual: " + "%d" + "\n", test2.currentECTS());

        assertEquals(test2.currentECTS(), 30);

        test2.addTestResult("Deutsch", new Pair<Double, Integer>(2.0,10));
        test2.addTestResult("English", new Pair<Double, Integer>(2.0,10));
        test2.addTestResult("Physik", new Pair<Double, Integer>(2.0,10));

        System.out.println("[Test currentECTS (2)]");
        System.out.printf("Expected: " + "%d" + "\n", 60);
        System.out.printf("Actual: " + "%d" + "\n", test2.currentECTS());

        assertEquals(test2.currentECTS(), 60);

        test2.addTestResult("Physik", new Pair<Double, Integer>(2.0,10));

        System.out.println("[Test currentECTS (2)]");
        System.out.printf("Expected: " + "%d" + "\n", 60);
        System.out.printf("Actual: " + "%d" + "\n", test2.currentECTS());

        assertEquals(test2.currentECTS(), 60);
    }

    @org.junit.jupiter.api.Test
    public void getExamResultsTest(){
        GradeOverview test3 = new GradeOverview();

        test3.addTestResult("Mathe", new Pair<Double, Integer>(2.0,10));
        test3.addTestResult("OOP", new Pair<Double, Integer>(2.0,10));
        test3.addTestResult("RA", new Pair<Double, Integer>(2.0,10));

        System.out.println("[Test getExamResutlts (1)]");
        System.out.printf("Expected: " + "%s" + "\n", new Pair<>(2.0,0).toString());
        System.out.printf("Actual: " + "%s" + "\n", test3.getExamResults("Mathe").toString());

        assertEquals(test3.getExamResults("Mathe").toString(), new Pair<>(2.0,0).toString());
    }
}
