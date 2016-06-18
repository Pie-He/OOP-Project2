package controller;

import java.util.List;

import util.Const;
import bean.Map;
import bean.item.Player;
import bean.item.RoadBlock;
import bean.place.House;
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
		// System.out.println("1个数:" + map.getMap().get(1).getItems().size());
	}

	public void move(Player player, int poi) {
		this.map.removePlayer(player);
		player.setPoi(0);	
		this.map.setPlayerPoi(player, poi);
		// System.out.println("1个数:" + map.getMap().get(1).getItems().size());
	}

	public void moveToHospital(Player player) {
		move(player, 0);
	}

	public EventSession event(Place place, EventSession session) {
		// this.map.event(session);
		return place.event(session);
	}

	public Const getHouseState(Player player, House house) {
		if (house.getOwner() == null)
			return Const.HOUSE_STATE_NULL;
		else if (house.getOwner() == player)
			return Const.HOUSE_STATE_SELF;
		else
			return Const.HOUSE_STATE_OTHERS;
	}

}
