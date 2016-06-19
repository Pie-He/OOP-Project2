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

	public boolean isBlock(int poi) {
		return this.map.isBlock(poi);
	}

	public Const move(Player player) {
		this.map.removePlayer(player);
		int poi = player.walk(map.mapLength());
		this.map.setPlayerPoi(player, poi);
		if (this.map.isBlock(poi)) {
			this.map.removeBlock(poi);
			return Const.MOVE_EVENT_BLOCK;
		}
		if (this.map.isBank(poi)) {
			return Const.MOVE_EVENT_BANK;
		}
		return Const.MOVE_EVNET_NULL;
		// System.out.println("1个数:" + map.getMap().get(1).getItems().size());
	}

	public void move(Player player, int poi) {
		this.map.removePlayer(player);
		player.setPoi(poi);
		this.map.setPlayerPoi(player, poi);
		// System.out.println("1个数:" + map.getMap().get(1).getItems().size());
	}

	public void moveToHospital(Player player, int days) {
		map.moveToHospital(player, days);
		player.setDeposit(1);
	}

	public Session event(Place place, Session session) {
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

	public int mapLength() {
		return this.map.mapLength();
	}

	public void remove(Player player) {
		this.map.removePlayer(player);
	}
}
