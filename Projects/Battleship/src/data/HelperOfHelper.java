package data;

import java.util.ArrayList;

public class HelperOfHelper {
	private static final String ALPHABET = "abcdefg";
	private static final int GRID_LENGTH = 7;
	private static final int GRID_SIZE = 49;
	static final int HORIZONTAL_INCREMENT = 1; // A better way to represent these two
	static final int VERTICAL_INCREMENT = GRID_LENGTH; // things is an enum (see Appendix B)
	private final int[] grid = new int[GRID_SIZE];
	private int startupCount = 0;
	
	public boolean startupFits(int[] startupCoords, int increment) {
		int finalLocation = startupCoords[startupCoords.length - 1];
		if (increment == HORIZONTAL_INCREMENT) {
			// check end is on same row as start
			return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
		} else {
			return finalLocation < GRID_SIZE; // check end isn't off the bottom
		}
		
	} //end startupFits
	
	public boolean coordsAvailable(int[] startupCoords) {
		for (int coord : startupCoords) { // check all potential positions
			if (grid[coord] != 0) { // this position already taken
				// System.out.println("position: " + coord + " already taken.");
				return false; // NO success
			}
		}
		return true; // there were no clashes, yay!
		
	} //end coordsAvailable
	
	public void savePositionToGrid(int[] startupCoords) {
		for (int index : startupCoords) {
			grid[index] = 1; // mark grid position as 'used'
		}
	} //end savePositionToGrid
	
	public ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		for (int index : startupCoords) { // for each grid coordinate
			String alphaCoords = getAlphaCoordsFromIndex(index); // turn it into an "a0" style
			alphaCells.add(alphaCoords); // add to a list
		}
		return alphaCells; // return the "a0"-style coords
	} // end convertCoordsToAlphaFormat
	
	public String getAlphaCoordsFromIndex(int index) {
		int row = calcRowFromIndex(index) + 1; // get row value
		int column = index % GRID_LENGTH; // get numeric column value
		String letter = ALPHABET.substring(column, column + 1); // convert to letter
		return letter + row;
	} // end getAlphaCoordsFromIndex
	
	private int calcRowFromIndex(int index) {
		return index / GRID_LENGTH;
	} // end calcRowFromIndex
	
	public int getIncrement() {
		if (startupCount % 2 == 0) { // if EVEN Startup
			return HORIZONTAL_INCREMENT; // place horizontally
		} else { // else ODD
			return VERTICAL_INCREMENT; // place vertically
		}
	} //end getIncrement
	
	public String getAlphabet() {
		return ALPHABET;
	}
	
	public int getGridLength() {
		return GRID_LENGTH;
	}
	
	public int getstartupCount() {
		return startupCount;
	}
	
	public int getGridSize() {
		return GRID_SIZE;
	}
}
