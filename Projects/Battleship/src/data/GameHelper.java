package data;

import java.util.*;

public class GameHelper {

	private final Random random = new Random();
	private static final int MAX_ATTEMPTS = 200;
	private HelperOfHelper help = new HelperOfHelper();
	private int startupCount = help.getstartupCount();
	private int GRID_SIZE = help.getGridSize();
	
	public String getUserInput(String prompt) {
		System.out.print(prompt + ": ");
		Scanner scanner = new Scanner(System.in);
		
		return scanner.nextLine().toLowerCase();
	} //end getUserInput
	
	public ArrayList<String> placeStartup(int startupSize) {
		// holds index to grid (0 - 48)
		int[] startupCoords = new int[startupSize]; // current candidate co-ordinates
		int attempts = 0; // current attempts counter
		boolean success = false; // flag = found a good location?
		startupCount++; // nth Startup to place
		int increment = help.getIncrement(); // alternate vert & horiz alignment
		
		while (!success & attempts++ < MAX_ATTEMPTS) { // main search loop
			int location = random.nextInt(GRID_SIZE) + 1; // get random starting point
			for (int i = 0; i < startupCoords.length; i++) { // create array of proposed coords
				startupCoords[i] = location; // put current location in array
				location += increment; // calculate the next location
			}
		// System.out.println("Trying: " + Arrays.toString(startupCoords));
			if (help.startupFits(startupCoords, increment)) { // startup fits on the grid?
				success = help.coordsAvailable(startupCoords); // ...and locations aren't taken?
			} // end loop
		} // end while
		
		help.savePositionToGrid(startupCoords); // coords passed checks, save
		ArrayList<String> alphaCells = help.convertCoordsToAlphaFormat(startupCoords);
		// System.out.println("Placed at: "+ alphaCells);
		return alphaCells;
	} //end placeStartup
} //end class

