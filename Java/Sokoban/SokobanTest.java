import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SokobanTest extends Sokoban{


    @org.junit.jupiter.api.Test
    @Test
   public void findPlayerTest(){
        char[][] sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();
        System.out.println("[Test findPlayer]");
        sokobanToString(sokoban);
        System.out.println(findPlayer(sokoban) + "\n");
        assertEquals(findPlayer(sokoban), new Pair<>(3,3));

        char[][] sokoban2 = new char[7][];
        sokoban2[0] = "#######".toCharArray();
        sokoban2[1] = "#.....#".toCharArray();
        sokoban2[2] = "#..$..#".toCharArray();
        sokoban2[3] = "#.$.$.#".toCharArray();
        sokoban2[4] = "#..$..#".toCharArray();
        sokoban2[5] = "#....@#".toCharArray();
        sokoban2[6] = "#######".toCharArray();
        System.out.println("[Test findPlayer]");
        sokobanToString(sokoban2);
        System.out.println(findPlayer(sokoban2) + "\n");
        assertEquals(findPlayer(sokoban2), new Pair<>(5,5));
    }
    @org.junit.jupiter.api.Test
    @Test
    public void moveNorthTest(){
        char[][] sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();

        char[][] sokobanExp = new char[7][];
        sokobanExp[0] = "#######".toCharArray();
        sokobanExp[1] = "#..$..#".toCharArray();
        sokobanExp[2] = "#..@..#".toCharArray();
        sokobanExp[3] = "#.$.$.#".toCharArray();
        sokobanExp[4] = "#..$..#".toCharArray();
        sokobanExp[5] = "#.....#".toCharArray();
        sokobanExp[6] = "#######".toCharArray();

        System.out.println("[Test moveNorth (1)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp);
        moveNorth(sokoban);
        System.out.println("Actual: ");
        sokobanToString(sokoban);
        System.out.println(findPlayer(sokoban) + "\n");
        assertEquals(findPlayer(sokoban), new Pair<>(2,3));

        char[][] sokoban2 = new char[7][];
        sokoban2[0] = "#######".toCharArray();
        sokoban2[1] = "#.....#".toCharArray();
        sokoban2[2] = "#..$..#".toCharArray();
        sokoban2[3] = "#.$.$.#".toCharArray();
        sokoban2[4] = "#..$..#".toCharArray();
        sokoban2[5] = "#....@#".toCharArray();
        sokoban2[6] = "#######".toCharArray();

        char[][] sokobanExp2 = new char[7][];
        sokobanExp2[0] = "#######".toCharArray();
        sokobanExp2[1] = "#.....#".toCharArray();
        sokobanExp2[2] = "#..$..#".toCharArray();
        sokobanExp2[3] = "#.$.$.#".toCharArray();
        sokobanExp2[4] = "#..$.@#".toCharArray();
        sokobanExp2[5] = "#.....#".toCharArray();
        sokobanExp2[6] = "#######".toCharArray();

        System.out.println("[Test moveNorth (2)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp2);
        moveNorth(sokoban2);
        System.out.println("Actual: ");
        sokobanToString(sokoban2);
        System.out.println(findPlayer(sokoban2) + "\n");
        assertEquals(findPlayer(sokoban2), new Pair<>(4,5));
    }

    @org.junit.jupiter.api.Test
    @Test
    public void moveEastTest(){
        char[][] sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();

        char[][] sokobanExp = new char[7][];
        sokobanExp[0] = "#######".toCharArray();
        sokobanExp[1] = "#.....#".toCharArray();
        sokobanExp[2] = "#..$..#".toCharArray();
        sokobanExp[3] = "#.$.@$#".toCharArray();
        sokobanExp[4] = "#..$..#".toCharArray();
        sokobanExp[5] = "#.....#".toCharArray();
        sokobanExp[6] = "#######".toCharArray();

        System.out.println("[Test moveEast (1)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp);
        moveEast(sokoban);
        System.out.println("Actual: ");
        sokobanToString(sokoban);
        System.out.println(findPlayer(sokoban) + "\n");
        assertEquals(findPlayer(sokoban), new Pair<>(3,4));

        char[][] sokoban2 = new char[7][];
        sokoban2[0] = "#######".toCharArray();
        sokoban2[1] = "#.....#".toCharArray();
        sokoban2[2] = "#..$..#".toCharArray();
        sokoban2[3] = "#.$.$.#".toCharArray();
        sokoban2[4] = "#..$..#".toCharArray();
        sokoban2[5] = "#....@#".toCharArray();
        sokoban2[6] = "#######".toCharArray();

        char[][] sokobanExp2 = new char[7][];
        sokobanExp2[0] = "#######".toCharArray();
        sokobanExp2[1] = "#.....#".toCharArray();
        sokobanExp2[2] = "#..$..#".toCharArray();
        sokobanExp2[3] = "#.$.$.#".toCharArray();
        sokobanExp2[4] = "#..$..#".toCharArray();
        sokobanExp2[5] = "#....@#".toCharArray();
        sokobanExp2[6] = "#######".toCharArray();

        System.out.println("[Test moveEast (2)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp2);
        moveEast(sokoban2);
        System.out.println("Actual: ");
        sokobanToString(sokoban2);
        System.out.println(findPlayer(sokoban2) + "\n");
        assertEquals(findPlayer(sokoban2), new Pair<>(5,5));
    }
    @org.junit.jupiter.api.Test
    @Test
    public void moveSouthTest(){
        char[][] sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();

        char[][] sokobanExp = new char[7][];
        sokobanExp[0] = "#######".toCharArray();
        sokobanExp[1] = "#.....#".toCharArray();
        sokobanExp[2] = "#..$..#".toCharArray();
        sokobanExp[3] = "#.$.$.#".toCharArray();
        sokobanExp[4] = "#..@..#".toCharArray();
        sokobanExp[5] = "#..$..#".toCharArray();
        sokobanExp[6] = "#######".toCharArray();

        System.out.println("[Test moveSouth (1)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp);
        moveSouth(sokoban);
        System.out.println("Actual: ");
        sokobanToString(sokoban);
        System.out.println(findPlayer(sokoban) + "\n");
        assertEquals(findPlayer(sokoban), new Pair<>(4,3));

        char[][] sokoban2 = new char[7][];
        sokoban2[0] = "#######".toCharArray();
        sokoban2[1] = "#.....#".toCharArray();
        sokoban2[2] = "#..$..#".toCharArray();
        sokoban2[3] = "#.$.$.#".toCharArray();
        sokoban2[4] = "#..$..#".toCharArray();
        sokoban2[5] = "#....@#".toCharArray();
        sokoban2[6] = "#######".toCharArray();

        char[][] sokobanExp2 = new char[7][];
        sokobanExp2[0] = "#######".toCharArray();
        sokobanExp2[1] = "#.....#".toCharArray();
        sokobanExp2[2] = "#..$..#".toCharArray();
        sokobanExp2[3] = "#.$.$.#".toCharArray();
        sokobanExp2[4] = "#..$..#".toCharArray();
        sokobanExp2[5] = "#....@#".toCharArray();
        sokobanExp2[6] = "#######".toCharArray();

        System.out.println("[Test moveSouth (2)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp2);
        moveSouth(sokoban2);
        System.out.println("Actual: ");
        sokobanToString(sokoban2);
        System.out.println(findPlayer(sokoban2) + "\n");
        assertEquals(findPlayer(sokoban2), new Pair<>(5,5));
    }
    @org.junit.jupiter.api.Test
    @Test
    public void moveWestTest(){
        char[][] sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();

        char[][] sokobanExp = new char[7][];
        sokobanExp[0] = "#######".toCharArray();
        sokobanExp[1] = "#.....#".toCharArray();
        sokobanExp[2] = "#..$..#".toCharArray();
        sokobanExp[3] = "#$@.$.#".toCharArray();
        sokobanExp[4] = "#..$..#".toCharArray();
        sokobanExp[5] = "#.....#".toCharArray();
        sokobanExp[6] = "#######".toCharArray();

        System.out.println("[Test moveWest (1)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp);
        moveWest(sokoban);
        System.out.println("Actual: ");
        sokobanToString(sokoban);
        System.out.println(findPlayer(sokoban) + "\n");
        assertEquals(findPlayer(sokoban), new Pair<>(3,2));

        char[][] sokoban2 = new char[7][];
        sokoban2[0] = "#######".toCharArray();
        sokoban2[1] = "#.....#".toCharArray();
        sokoban2[2] = "#..$..#".toCharArray();
        sokoban2[3] = "#.$.$.#".toCharArray();
        sokoban2[4] = "#..$..#".toCharArray();
        sokoban2[5] = "#....@#".toCharArray();
        sokoban2[6] = "#######".toCharArray();

        char[][] sokobanExp2 = new char[7][];
        sokobanExp2[0] = "#######".toCharArray();
        sokobanExp2[1] = "#.....#".toCharArray();
        sokobanExp2[2] = "#..$..#".toCharArray();
        sokobanExp2[3] = "#.$.$.#".toCharArray();
        sokobanExp2[4] = "#..$..#".toCharArray();
        sokobanExp2[5] = "#...@.#".toCharArray();
        sokobanExp2[6] = "#######".toCharArray();

        System.out.println("[Test moveWest (2)]");
        System.out.println("Expected: ");
        sokobanToString(sokobanExp2);
        moveWest(sokoban2);
        System.out.println("Actual: ");
        sokobanToString(sokoban2);
        System.out.println(findPlayer(sokoban2) + "\n");
        assertEquals(findPlayer(sokoban2), new Pair<>(5,4));
    }
}