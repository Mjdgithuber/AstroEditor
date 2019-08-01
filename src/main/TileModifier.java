package main;

import javax.swing.ImageIcon;

public class TileModifier {
	
	private ImageIcon image;
	private String name;
	private Action action;
	private int regNum;
	
//	public Tile(ImageIcon image, String name){
//		this.image = image;
//		this.name = name;
//	}
	
	public TileModifier(String name, Action action, int regNum){
		setName(name, action);
		this.regNum = regNum;
	}
	
	public ImageIcon getImage(){
		return image;
	}
	
	public String getName(){
		return name;
	}
	
	private void setImage(ImageIcon img){
		image = img;
	}
	
	public void setName(String s, Action action){
		name = s;
		setImage(TileModifierManager.getImage(s));
		this.action = action;
	}

}
