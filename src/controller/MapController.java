package controller;

import java.util.List;

import bean.Map;
import bean.place.Place;
import dao.MapDao;

public class MapController extends IController {

	private static final MapController CONTROLLER = new MapController();
	private MapDao mapDao = new MapDao();
	private Map map = new Map();

	public static MapController getInstance() {
		return CONTROLLER;
	}

	public String getSymbol() {
		return "";
	}

	public List<Place> getInitMap() {
		return this.map.getMap();
	}

	public void init() {
		this.map.setMap(mapDao.getMapData());
	}

}
