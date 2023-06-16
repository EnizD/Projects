public class Sokoban {

	public static void  sokobanToString(char sokoban[][]){
		for(int i = 0; i < sokoban.length; i++) {
			System.out.println(sokoban[i]);
		}
		System.out.printf("\n");
	}

	public static Pair<Integer,Integer> findPlayer(char sokoban[][]){
		for(int i = 0; i < sokoban.length; i++){
			for(int j = 0; j < sokoban.length; j++){
				if(sokoban[i][j] == '@'){
					return new Pair<>(i,j);
				}
			}
		}
		return new Pair<>(-1, -1);
	 }

	public static boolean moveNorth(char sokoban[][]){
		var playerPosition = findPlayer(sokoban);

		int x = playerPosition.getFirst();
		int y = playerPosition.getSecond();

		if(sokoban[x-1][y] == '.') {
			sokoban[x][y] = '.';
			sokoban[x-1][y] = '@';
			return true;
		}
		if(sokoban[x-1][y] == '$' && sokoban[x-2][y] == '.' && sokoban[x-3][y] != '$'){
			sokoban[x][y] = '.';
			sokoban[x-1][y] = '@';
			sokoban[x-2][y] = '$';
			return true;
		}
		else return false;
	}

	public static boolean moveEast(char sokoban[][]){
		var playerPosition = findPlayer(sokoban);

		int x = playerPosition.getFirst();
		int y = playerPosition.getSecond();

		if(sokoban[x][y+1] == '.') {
			sokoban[x][y] = '.';
			sokoban[x][y+1] = '@';
			return true;
		}
		if(sokoban[x][y+1] == '$' && sokoban[x][y+2] == '.' && sokoban[x][y+3] != '$'){
			sokoban[x][y] = '.';
			sokoban[x][y+1] = '@';
			sokoban[x][y+2] = '$';
			return true;
		}
		else return false;
	}
	public static boolean moveSouth(char sokoban[][]){
		var playerPosition = findPlayer(sokoban);

		int x = playerPosition.getFirst();
		int y = playerPosition.getSecond();

		if(sokoban[x+1][y] == '.') {
			sokoban[x][y] = '.';
			sokoban[x+1][y] = '@';
			return true;
		}
		if(sokoban[x+1][y] == '$' && sokoban[x+2][y] == '.' && sokoban[x+3][y]!= '$'){
			sokoban[x][y] = '.';
			sokoban[x+1][y] = '@';
			sokoban[x+2][y] = '$';
			return true;
		}
		else return false;
	}

	public static boolean moveWest(char sokoban[][]){
		var playerPosition = findPlayer(sokoban);

		int x = playerPosition.getFirst();
		int y = playerPosition.getSecond();

		if(sokoban[x][y-1] == '.') {
			sokoban[x][y] = '.';
			sokoban[x][y-1] = '@';
			return true;
		}
		if(sokoban[x][y-1] == '$' && sokoban[x][y-2] == '.' && sokoban[x][y-3] != '$'){
			sokoban[x][y] = '.';
			sokoban[x][y-1] = '@';
			sokoban[x][y-2] = '$';
			return true;
		}
		else return false;
	}

	public static boolean move(char sokoban[][], String direction){
		if(!direction.equals("north") && !direction.equals("west") && !direction.equals("east") && !direction.equals("south")){
			return false;
		}
		if(direction.equals("north")){
			moveNorth(sokoban);
			sokobanToString(sokoban);
			return true;
		}
		if(direction.equals("east")){
			moveEast(sokoban);
			sokobanToString(sokoban);
			return true;
		}
		if(direction.equals("south")){
			moveSouth(sokoban);
			sokobanToString(sokoban);
			return true;
		}
		if(direction.equals("west")){
			moveWest(sokoban);
			sokobanToString(sokoban);
			return true;
		}
		else return false;
	}
}
