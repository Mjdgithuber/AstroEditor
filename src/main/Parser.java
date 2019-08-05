package main;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import register.Register;

public class Parser extends DefaultHandler {

	private World world;

	
	public Parser() {
		try{
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();

			JFileChooser chooser = new JFileChooser("assets/saves");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Save Files", "sv");
			chooser.setFileFilter(filter);
			
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				parser.parse(chooser.getSelectedFile(), this);
			
			for(String[] n : tileNames)
				for(String s : n)
					System.out.println(s);
			
			world = new World(tileNames, tileModifiers, tileScripts, buildingNames);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public World getWorld() {
		return world;
	}

	private String[][] tileNames = null;
	private String[][] tileModifiers = null;
	private String[][] tileScripts = null;
	private String[][] buildingNames = null;
	@Override
	// A start tag is encountered.
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		switch (qName) {
			case "Level": {
				break;
			}
			case "Size": {
				int width = Integer.parseInt(attributes.getValue("width"));
				int height = Integer.parseInt(attributes.getValue("height"));
				tileNames = new String[width][height];
				tileModifiers = new String[width][height];
				tileScripts = new String[width][height];
				buildingNames = new String[width][height];
				break;
			}
			case "Tile": {
				int x = Integer.parseInt(attributes.getValue("x"));
				int y = Integer.parseInt(attributes.getValue("y"));
				int modRegNum = Integer.parseInt(attributes.getValue("modifier_reg_num"));
				tileModifiers[x][y] = Register.getModifierName(modRegNum);
				System.out.println(tileModifiers[x][y]);
				tileNames[x][y] = attributes.getValue("name");
				tileScripts[x][y] = attributes.getValue("script");
				break;
			}
			case "Building": {
				int x = Integer.parseInt(attributes.getValue("x"));
				int y = Integer.parseInt(attributes.getValue("y"));
				buildingNames[x][y] = attributes.getValue("name");
				break;
			}
		}
	}
	
	@Override
	// An end tag is encountered.
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
//			case "Graph": {
//				break;
//			}
		}
	}
	
	@Override
	// This is the data between tags.
	public void characters(char[] ch, int start, int length) throws SAXException {
//			text = String.copyValueOf(ch, start, length).trim();
	}
}

