package entry;

public class TileEntry {
	private String filename;
	private int registerNumber;
	private int spriteSheetX;
	private int spriteSheetY;
	
	public TileEntry(int regNum, String name, int x, int y) {
		registerNumber = regNum;
		filename = name;
		spriteSheetX = x;
		spriteSheetY = y;
	}
	
	public String toString() {
		return "Register Number: " + registerNumber + " Filename: " + filename + " X: " + spriteSheetX + " Y: " + spriteSheetY;
	}
}
