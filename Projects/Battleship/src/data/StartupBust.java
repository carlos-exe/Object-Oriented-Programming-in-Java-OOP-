package data;

import java.util.ArrayList;

public class StartupBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<Startup> startups = new ArrayList<Startup>();
	private int numOfGuesses = 0;
	private int numOfGoods = 0;
	
	public void setUpGame() {
		// first make some Startups and give them locations
		Startup one = new Startup();
		one.setName("poniez");
		Startup two = new Startup();
		two.setName("hacqi");
		Startup three = new Startup();
		three.setName("cabista");
		startups.add(one);
		startups.add(two);
		startups.add(three);
		System.out.println("Tu objetivo es hundir los 3 barcos.");
		System.out.println("poniez, hacqi, cabista");
		System.out.println("Intenta hundirlos en la menor cantidad de intentos.");
		for (Startup startup : startups) {
			ArrayList<String> newLocation = helper.placeStartup(3);
			startup.setLocationCells(newLocation);
		} // close for loop
	} // close setUpGame method

	public void startPlaying() {
		while (!startups.isEmpty()) {
			String userGuess = helper.getUserInput("Ingresa tu suposición");
			checkUserGuess(userGuess);
		} // close while
		finishGame();
	} // close startPlaying method	
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "Fallo";
		for (Startup startupToTest : startups) {
			result = startupToTest.checkYourself(userGuess);
			if (result.equals("Acierto")) {
				numOfGoods++;
				break;
			}
			if (result.equals("Destruido")) {
				numOfGoods++;
				startups.remove(startupToTest);
				break;
			}
		} // close for
		System.out.println(result + ", has disparado " + numOfGuesses + " veces y has acertado " + numOfGoods + " veces.\n");
	} // close method
	
	private void finishGame() {
		System.out.println("Hundiste todos los barcos");
		if (numOfGuesses <= 18) {
			System.out.println("Solo te tomó " + numOfGuesses + " suposiciones.");
		} else {
			System.out.println("Te tomó demasiado. " + numOfGuesses + " suposiciones.");
		}
	} // close method
}
