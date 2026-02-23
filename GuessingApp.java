/*
*author Developer
*version 2
*/
import java.util.*;
public class GuessingApp{
	public static void main(String[] args){
		System.out.println("Welcome to the guessing App");
		GameConfig gameconfig=new GameConfig();
		gameconfig.showRules();
		Scanner scanner=new Scanner(System.in);
		int attempts=0;
		while(attempts<confg.getMaxAttempts())
		{
			System.out.println("Enter your Guess:");
			int guess=scanner.nextInt();
			attempts++;
			String result=GuessValidator.validateGuess(guess,config.getTaregetNumber());
			System.out.println(result);
			if("CORRECT".equals(result))
			{
				break;
			}
		}
			
	}
}