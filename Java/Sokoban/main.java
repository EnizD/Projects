import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main extends Sokoban {
    public static void main(String[] args) {
        char[][] sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();
        System.out.println(findPlayer(sokoban));
        sokobanToString(sokoban);
        move(sokoban, "north");
        move(sokoban, "east");
        move(sokoban, "north");
        move(sokoban, "west");
        move(sokoban, "south");
        move(sokoban, "west");
        move(sokoban, "south");
        move(sokoban, "west");
        move(sokoban, "south");
        move(sokoban, "east");
        move(sokoban,"west");

        /* LocalDate Uebungen */

        LocalDate time = LocalDate.now();
        System.out.println(time);                                      // Aktuelle Datum

        LocalDate time4 = time.minusWeeks(4);           // Datum vor Vier Wochen
        System.out.println(time4);

        LocalDate time1M = time.minusMonths(1);         // Datum vor einem Monat
        System.out.println(time1M + "\n");

        DayOfWeek timeWeek = time.getDayOfWeek();                      // Wochentag vom aktuellen Datum
        System.out.println(timeWeek);

        DayOfWeek timeWeek4 = time4.getDayOfWeek();                    // Wochentag von vier Wochen
        System.out.println(timeWeek4);

        DayOfWeek timeWeek1M = time1M.getDayOfWeek();                  // Wochentag vor einem Monat
        System.out.println(timeWeek1M);

        /* Java Collections API */

        List pairList = new ArrayList<Pair>();

        Pair pair1 = new Pair(3,3);
        Pair pair2 = new Pair(3,3);
        Pair pair3 = new Pair(1,2);
        Pair pair4 = new Pair(4,7);
        Pair pair5 = new Pair(2,9);
        Pair pair6 = new Pair(1,10);
        Pair pair7 = new Pair(2,1);

        pairList.add(0,pair1);
        pairList.add(1,pair2);
        pairList.add(2,pair3);
        pairList.add(3,pair4);
        pairList.add(4,pair5);
        pairList.add(5,pair6);
        pairList.add(6,pair7);

        Collections.sort(pairList);
        System.out.println(pairList);


    }


}
