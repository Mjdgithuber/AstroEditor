package entry;

public class ModifierEntry {
	private int registerNumber;
	private String filename;
	
	public ModifierEntry(int regNum, String name) {
		registerNumber = regNum;
		filename = name;
	}
	
	public String toString() {
		return "Register Number: " + registerNumber + " Filename: " + filename;
	}
}