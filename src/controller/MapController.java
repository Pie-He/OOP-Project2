package controller;

import java.util.List;

public class MapController extends IController{

	private static final MapController CONTROLLER = new MapController();

	public static MapController getInstance() {
		return CONTROLLER;
	}
	
	public String getSymbol(){
		return "";
	}
	
	public List<String> getInitMap(){
		return null;		
	}
	
	
}
