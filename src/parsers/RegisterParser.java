package parsers;

/*import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.World;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import register.Register;
import entry.ModifierEntry;
import entry.TileEntry;

public class RegisterParser extends DefaultHandler {
	
	public RegisterParser() {}
	
	public void startParsing() {
		try{
			// gets a SAX parser to read XML file
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			
			final File registerFile = new File("register/register.xml");
			
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
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {}
}
*/
