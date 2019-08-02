package entry;

public class ModifierEntry {
	private int registerNumber;
	private String filename;
	
	public ModifierEntry(int regNum, String name) {
		registerNumber = regNum;
		filename = name;
	}
	
	public int getRegisterNumber() {
		return registerNumber;
	}
	
	public String getName() {
		return filename;
	}
	
	public String toString() {
		return "Register Number: " + registerNumber + " Filename: " + filename;
	}
}