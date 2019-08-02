package main;

import javax.swing.ImageIcon;

import managers.TileManager;

public class Tile {
	
	private ImageIcon image;
	private String name;
	
	public Tile(String name){
		setName(name);
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
	
	public void setName(String s){
		name = s;
		setImage(TileManager.getImage(s));
	}

}
