package managers;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.Building;
import main.Parser;
import main.Tile;
import main.World;
import register.Register;

public class SaveManager {
	
	private SaveManager(){}
	
	public static final World getWorld(){
		return new Parser().getWorld();
	}
	
	public static final void initiateSave(Tile[][] tiles, Building[][] buildings){
		try {
			JFileChooser chooser = new JFileChooser("assets/saves");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Save Files", "sv");
			chooser.setFileFilter(filter);
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to save this file: " +
						chooser.getSelectedFile().getName());
				//				  File file = chooser.getSelectedFile();
				PrintWriter wr = new PrintWriter(new FileWriter("assets/saves/"+chooser.getSelectedFile().getName()));
				wr.println("<Level>");
				wr.printf("<Size width=\"%d\" height=\"%d\"></Size>\n", tiles.length, tiles[0].length);
				for (int row=0; row<tiles[0].length; row++) {
					for(int col=0; col<tiles.length; col++){
						wr.printf("<Tile name=\"%s\" reg_num=\"%d\" x=\"%d\" y=\"%d\" modifier_reg_num=\"%s\" script=\"%s\"></Tile>\n", 
								tiles[col][row].getTileName(), Register.getTileRegisterNumber(tiles[col][row]), col, row,
								Register.getModifierRegisterNumber(tiles[col][row]), tiles[col][row].getScriptPath());
					}
				}
				for (int row=0; row<buildings[0].length; row++) {
					for(int col=0; col<buildings.length; col++){
						Building b = buildings[col][row];
						if(!b.isNull())
							wr.printf("<Building name=\"%s\" x=\"%d\" y=\"%d\"></Building>\n", b.getName(), col, row);
					}
				}
				

				wr.println("</Level>");
				wr.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
