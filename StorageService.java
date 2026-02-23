/**
* Use Case 5: Game Result Stoage
*
* This class is responsible for persisting the final game after the
* game ends.
*
*Results are stored in a file so that game history is not lost after exit.
*/


class StorageService{
	public static void saveresult(String player,int attempts,boolean win)
	{
		try(BufferedWriter writer=new BufferedWriter(new FileWriter("game_reults.txt", true))){
			writer.write("Player: "+player+", Attempts: "+attempts+", Result: "+(win? "WIN" : "LOSE"));
			writer.newLine();
		}catch(IOException e){
			System.out.println("Unable to save game result.");
		}
	}
}