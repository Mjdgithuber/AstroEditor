package managers;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TileManager {
	
	public static final String pathToTiles = "assets/blocks/";
	
	private static ArrayList<ImageIcon> tileImages;
	private static ArrayList<String> tileNames;
	
	private static String DEFAULT_TILE;

	static {
		init();
	}
	
	public static ImageIcon getImage(String path){
		int index = tileNames.indexOf(path);
		return tileImages.get(index);
	}
	
	public static String getDefaultTileName(){
		return DEFAULT_TILE;
	}

	private static void init() {
		tileImages = new ArrayList<ImageIcon>();
		tileNames = new ArrayList<String>();

		final File assetFolder = new File(pathToTiles);
		final File[] assets = assetFolder.listFiles();

		for (File f : assets){
			try{
				String path = f.toString();					
				tileImages.add(new ImageIcon(path));
				
				path = path.substring(pathToTiles.length());
				path = path.substring(0, path.length()-4);
				System.out.println(path);
				if(path.endsWith("NULL"))
					DEFAULT_TILE = path;
				tileNames.add(path);
			}catch(Exception e){}
			//System.out.println(f.toString());
		}
	}
	
	public static ImageIcon getTileImage(int i){
		return tileImages.get(i);
	}
	
	public static String getTileName(int i){
		return tileNames.get(i);
	}
	
//	public static ImageIcon getBlockImage(int i, int width, int height){
//		ImageIcon imageIcon = tileImages.get(i); // load the image to a imageIcon
//		Image image = imageIcon.getImage(); // transform it 
//		Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		imageIcon = new ImageIcon(newimg);
//		return imageIcon;
//	}
//	
	public static int getNumberOfBlocks(){
		return tileImages.size();
	}

}