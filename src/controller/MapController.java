package controller;

import java.util.List;

import bean.Map;
import bean.item.Player;
import bean.item.RoadBlock;
import bean.place.Place;
import dao.MapDao;

public class MapController extends IController {

	private static final MapController CONTROLLER = new MapController();
	private MapDao mapDao = new MapDao();
	private Map map = new Map();

	public static MapController getInstance() {
		return CONTROLLER;
	}

	private MapController() {
		this.map.setMap(mapDao.getMapData());

		// this.init();
	}

	public String getSymbol() {
		return "";
	}

	public List<Place> getInitMap() {
		return this.map.getMap();
	}

	public void init() {
		this.map.init(PlayerController.getInstance().getPlayerList());
	}

	public boolean addBlock(int poi) {
		RoadBlock block = new RoadBlock(poi);
		return this.map.addBlock(block);
	}

	public void move(Player player) {
		this.map.removePlayer(player);
		this.map.setPlayerPoi(player, player.walk(map.mapLength()));
		System.out.println("1����:" + map.getMap().get(1).getItems().size());
	}

	public void event(Player player, int dice) {

	}

}
