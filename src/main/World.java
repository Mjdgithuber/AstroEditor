package main;

import managers.BuildingManager;

public class World {

	private Tile[][] tiles;
	private TileModifier[][] tilesModifiers;
	private Building[][] buildings;
	
	
	public World(String[][] tileImagePaths, String[][] tilesModifierPaths, String[][] buildingImagePaths){
		tiles = new Tile[tileImagePaths.length][tileImagePaths[0].length];
		generateTiles(tileImagePaths);
		
		tilesModifiers = new TileModifier[tilesModifierPaths.length][tilesModifierPaths[0].length];
		generateModifiers(tilesModifierPaths);
		
		buildings = new Building[buildingImagePaths.length][buildingImagePaths[0].length];
		generateBuilding(buildingImagePaths);
	}
	
	private void generateModifiers(String[][] tilesModifierPaths) {
		for(int i = 0; i<tilesModifierPaths.length; i++)
			for(int j = 0; j<tilesModifierPaths[0].length; j++)
				tilesModifiers[i][j] = new TileModifier(tilesModifierPaths[i][j], new Action(""));
	}
	
	private void generateBuilding(String[][] buildingImagePaths){
		for(int i = 0; i<buildingImagePaths.length; i++)
			for(int j = 0; j<buildingImagePaths[0].length; j++){
				if(buildingImagePaths[i][j] != null)
					buildings[i][j] = new Building(BuildingManager.getImage(buildingImagePaths[i][j]),
							buildingImagePaths[i][j]);
				else
					buildings[i][j] = new Building();
			}
				
	}
	
	private void generateTiles(String[][] tileImagePaths){
		for(int i = 0; i<tileImagePaths.length; i++)
			for(int j = 0; j<tileImagePaths[0].length; j++)
				tiles[i][j] = new Tile(tileImagePaths[i][j]);
	}
	
	public TileModifier[][] getModifiers() {
		return tilesModifiers;
	}
	
	public Building[][] getBuildings(){
		return buildings;
	}
	
	public Tile[][] getTiles(){
		return tiles;
	}

}
