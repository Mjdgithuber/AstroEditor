package main;

import javax.swing.ImageIcon;

import managers.TileManager;
import managers.TileModifierManager;

/**
 * This class holds all of the necessary information to store a tile. Which
 * includes the tile's image and modifier image as well as their respective
 * names. This class was completely overhauled as it was originally written
 * when I was in high school.
 * @author Matthew J. Dennerlein
 *
 */
public class Tile {
	/* the names correspond to their asset png's */
	private String tileName; 
	private String modifierName;
	private String scriptPath;
	
	/* images to render the tile and it's state modifier */
	private ImageIcon tileImage;
	private ImageIcon modifierImage;
	
	/** 
	 * Constructor for a new tile takes in names for the tile and modifier
	 * @param tileName The tile's name, must match register entry
	 * @param modifierName The tile modifer's name, must match register entry
	 */
	public Tile(String tileName, String modifierName){
		setTileName(tileName);
		setModifierName(modifierName);
		scriptPath = "undefined";
	}
	
	/** 
	 * Constructor for a new tile that additionally takes in a script path
	 * @param tileName The tile's name, must match register entry
	 * @param modifierName The tile modifer's name, must match register entry
	 * @param scriptPath The path to the tile's associated script
	 */
	public Tile(String tileName, String modifierName, String scriptPath){
		setTileName(tileName);
		setModifierName(modifierName);
		this.scriptPath = scriptPath;
	}
	
	/**
	 * @return The image icon of the tile, not the modifier
	 */
	public ImageIcon getTileImage(){
		return tileImage;
	}
	
	/**
	 * @return The modifier image, not the tile
	 */
	public ImageIcon getModifierImage(){
		return modifierImage;
	}
	
	/**
	 * @return The tile's name that matches the register entry
	 */
	public String getTileName(){
		return tileName;
	}
	
	/**
	 * @return The modifier's name that matches the register entry
	 */
	public String getModifierName(){
		return modifierName;
	}
	
	/** 
	 * @return The path to the associated script
	 */
	public String getScriptPath() {
		return scriptPath;
	}
	
	/**
	 * Will set the image of the tile
	 * @param tileName The tile name that matches the register entry for that tile
	 */
	public void setTileName(String tileName) {
		this.tileName = tileName;
		tileImage = TileManager.getImage(tileName);
	}
	
	/**
	 * Will set the image of the modifier for this tile
	 * @param modifierName The name of the modifier that matches the register's entry
	 */
	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
		modifierImage = TileModifierManager.getImage(modifierName);
	}
	
	/**
	 * Will set the script path for this tile. The script path is the path to a file
	 * that contains additional information about what this tile does, for instance
	 * maybe this tile can teleport an entity or an action can be performed upon it.
	 * @param scriptPath The path to the script. Note that this isn't validated and 
	 * must be implemented in the program that reads the generated file!
	 */
	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}
}