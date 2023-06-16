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
    }

}
