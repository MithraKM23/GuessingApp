class GuessValidator{
	public static String vaidateGuess(int guess,int target){
		if(guess==target){
			return "CORRECT";
		}
		else if(guess<target)
		{
			return "LOW";
		}
		return "HIGH";
	}
}