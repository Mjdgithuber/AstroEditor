package managers;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TileModifierManager {
	
	public static final String pathToModifiers = "assets/tile_modifiers/";
	
	private static ArrayList<ImageIcon> tileModImages;
	private static ArrayList<String> tileModNames;
	
	private static String DEFAULT_MODIFIER;
	private static String EXTERNAL_MODIFIER;

	static {
		init();
	}
	
	public static ImageIcon getImage(String path){
		int index = tileModNames.indexOf(path);
		return tileModImages.get(index);
	}
	
	public static String getDefaultModifierName(){
		return DEFAULT_MODIFIER;
	}
	
	public static String getExternalModifierName() {
		return EXTERNAL_MODIFIER;
	}
	
	private static void init() {
		tileModImages = new ArrayList<ImageIcon>();
		tileModNames = new ArrayList<String>();

		final File assetFolder = new File(pathToModifiers);
		final File[] assets = assetFolder.listFiles();

		for (File f : assets){
			try{
				String path = f.toString();
				
				// gets the image at the file path
				tileModImages.add(new ImageIcon(path));
				
				// strip the .png and path off of file name
				path = path.substring(pathToModifiers.length());
				path = path.substring(0, path.length()-4);
				
				if(path.endsWith("CLEAR"))
					DEFAULT_MODIFIER = path;
				else if(path.endsWith("EXTERNAL"))
					EXTERNAL_MODIFIER = path;
				
				System.out.println(path);
				tileModNames.add(path);				
				
			}catch(Exception e){ e.printStackTrace(); }
		}
	}
	
	public static ImageIcon getModifierImage(int i){
		return tileModImages.get(i);
	}
	
	public static String getModifierName(int i){
		return tileModNames.get(i);
	}
	
	private static JPanel levelPanel(String savedText){
		JPanel panel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(new GridBagLayout());
		
		gbc.gridy=0;
		gbc.gridx=0;
		panel.add(new JLabel("Script Location: "), gbc);
		gbc.gridx++;
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(135, 25));
		text.setText(savedText);
		panel.add(text, gbc);
		
		return panel;
	}
	
	static String script = null;
	public static String openScriptDialog(String savedText) {
		
		
		JDialog teleporterDialog;
		GridBagConstraints gbc = new GridBagConstraints();
		
		JFrame f = new JFrame();
		teleporterDialog = new JDialog(f, "New External Script", true);
		
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		teleporterDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		teleporterDialog.setMinimumSize(new Dimension(250, 200));
		teleporterDialog.setResizable(false);
		
		teleporterDialog.setLayout(new GridBagLayout());
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		
		teleporterDialog.setAlwaysOnTop(true);
		teleporterDialog.setLocationRelativeTo(null);
		
		gbc.gridwidth = 2;
		JPanel levelPanel = levelPanel(savedText);
		teleporterDialog.add(levelPanel, gbc);
		
		gbc.gridy++;
		JButton set = new JButton("Set");
		set.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				script = ((JTextField)levelPanel.getComponents()[1]).getText();
				System.out.println(script);

				teleporterDialog.dispose();
			}
		});
		teleporterDialog.add(set, gbc);
		
		teleporterDialog.setVisible(true);
		
		return script;
	}
	
	public static int getNumberOfModifiers(){
		return tileModImages.size();
	}
}
