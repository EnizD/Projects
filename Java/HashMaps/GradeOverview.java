package src.main.java.de.uulm.sp.oop.exercises.e06;
import main.java.de.uulm.sp.oop.exercises.e06.util.Pair;
import java.util.HashMap;
import java.util.Optional;

public class GradeOverview {

	HashMap<String, Pair<Double,Integer>> GradeOverview = new HashMap<String,Pair<Double,Integer>>();
    public Pair<Double,Integer> addTestResult(String lecturename, Pair<Double,Integer> gradeAndECTS){
        GradeOverview.put(lecturename, gradeAndECTS);
        return gradeAndECTS;
    }

    public int currentECTS(){
        int result = 0;
        for (String key : GradeOverview.keySet()) {
            Pair<Double,Integer> value = GradeOverview.get(key);
            int ECTS = value.getSecond();
            result += ECTS;
        }
        return result;
    }

    public Optional<Pair<Double,Integer>> getExamResults(String lecturename){
        if (GradeOverview.containsKey(lecturename)) {
            return Optional.ofNullable(GradeOverview.get(lecturename));
        }
        return Optional.empty();
    }

    public double totalGradeAverage(){
        double result = 0;
        double gewichtung = 0;
        for (String key : GradeOverview.keySet()) {
            Pair<Double,Integer> value = GradeOverview.get(key);
            double grade = value.getFirst();
            int ECTS = value.getSecond();
            result += ECTS * grade;
        }

        gewichtung = currentECTS();

        return result/(GradeOverview.size()+gewichtung);
    }
}
