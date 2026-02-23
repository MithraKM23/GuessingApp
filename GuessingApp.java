
/** MAIN CLASS
* 
* use Case 6: Game Restart and Exit
*
* This class coordinatesthe complete game lifecycle, allowing the player to replay or exit gracefully.
*
* @author Developer
* @version 6.0
*/
public class GuessingApp{
	public static void main(String[] args) throws InvalidInputException{
		Scanner scanner=new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
		System.out.println("============================");
		/*
		*Player name is captured once
		* and stored along with game results.
		*/
		do
	{
		System.out.print("Enter Player Name: ");
		String player = scanner.nextLine();
		GameConfig config=new GameConfig();
		config.showRules();
		int attempts = 0;
		int hintsUsed = 0;
		/*
		*Tracks whether the user successfully gussed the number.
		*/
		boolean win=false;
		while(attempts<config.getmaxAttempts())
		{
			System.out.println("Enter your Guess:");
			int guess=scanner.nextInt();
			attempts++;
			String result=GuessValidator.validateGuess(guess,config.getTaregetNumber());
			//System.out.println(result);
			if(!"CORRECT".equals(result) && hintsUsed < config.getMaxHints())
			{
				hintsUsed++;
				System.out.println( HintService.generateHint(config.getTargetNumber(), hintsUsed));
				
			}
			System.out.println(result);
			if("CORRECT".equals(result)){
				break;
			
			}
		}
		/*
		* Final game result is persisted
		* after the current session ends.
		*/
		StorageService.saveResult(player, attempts, win);
		/**
		* Player decides whether to
		* restart the game or exit*/
		restart = GameController.restartGame(scanner);
	}while(restart);
	}
}
