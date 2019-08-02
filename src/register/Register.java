/** Matthew J. Dennerlein
 *  This classes purpose is to hold all important information about the
 *  registers that are to be loaded from the XML register file.
 */

package register;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.Tile;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entry.ModifierEntry;
import entry.TileEntry;

public class Register {
	
	private static class RegisterParser extends DefaultHandler {
		
		/** Public constructor **/
		public RegisterParser() {}
		
		public void startParsing() {
			try{
				// gets a SAX parser to read XML file
				SAXParserFactory parserFactor = SAXParserFactory.newInstance();
				SAXParser parser = parserFactor.newSAXParser();
				
				final File registerFile = new File("assets/register/register.xml");
				
				parser.parse(registerFile, this);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@Override
		// A start tag is encountered.
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {		
			switch (qName) {
				case "AssetRegister": { break; }
				case "ModifierRegister": { break; }
				case "TileRegister": { break; }
				case "Modifier": {
					int regNum = Integer.parseInt(attributes.getValue("reg_num"));
					String filename = attributes.getValue("name");
					Register.addModifierEntry(new ModifierEntry(regNum, filename));
					break;
				}
				case "Tile": {
					int regNum = Integer.parseInt(attributes.getValue("reg_num"));
					String filename = attributes.getValue("name");
					int x = Integer.parseInt(attributes.getValue("spritesheet_x"));
					int y = Integer.parseInt(attributes.getValue("spritesheet_y"));
					Register.addTileEntry(new TileEntry(regNum, filename, x, y));
					break;
				}
			}
		}
	}
	
	/** Beginning of Register class */
	private static boolean loaded;
	private static ArrayList<TileEntry> TILE_ENTRIES;
	private static ArrayList<ModifierEntry> MODIFIER_ENTRIES;
	
	static {
		TILE_ENTRIES = new ArrayList<TileEntry>();
		MODIFIER_ENTRIES = new ArrayList<ModifierEntry>();
		loaded = false;
	}
	
	private static void addTileEntry(TileEntry t) {
		TILE_ENTRIES.add(t);
	}
	
	private static void addModifierEntry(ModifierEntry m) {
		MODIFIER_ENTRIES.add(m);
	}
	
	public static void loadRegister() {
		if(loaded) return;
	
		// parse register file
		new RegisterParser().startParsing();
		
		loaded = true;
	}
	
	public static int getTileRegisterNumber(Tile t) {
		for(TileEntry te : TILE_ENTRIES) {
			if(te.getName().equals(t.getName())) {
				return te.getRegisterNumber();
			}
		}
		return -1;
	}
	
	public static void printTileEntries() {
		System.out.println("Tiles:");
		for(TileEntry t : TILE_ENTRIES) {
			System.out.println(t);
		}
	}
	
	public static void printModifierEntries() {
		System.out.println("Modifiers:");
		for(ModifierEntry m : MODIFIER_ENTRIES) {
			System.out.println(m);
		}
	}

	/** Private constructor to disable instantiation  **/
	private Register() {}
	
}
