package bean.place;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import controller.Session;
import bean.item.Player;
import bean.item.RoadBlock;

public class Map {
	private List<Place> places;

	public Map() {
		places = new ArrayList<Place>();
	}

	public void setMap(List<Place> places) {
		this.places = places;
	}

	public List<Place> getMap() {
		return this.places;
	}

	public void setPlayerPoi(Player player, int poi) {
		places.get(poi).put((player));
	}

	public Session event(int poi, Session session) {
		return places.get(poi).event(session);
	}

	public boolean addBlock(RoadBlock r) {
		if (this.places.get(r.getPoi()).isBlock())
			return false;
		this.places.get(r.getPoi()).put(r);
		return true;
	}

	public boolean isBlock(int poi) {
		return this.places.get(poi).isBlock();
	}

	public String getDescription(int poi) {
		return places.get(poi).getDescription();
	}

	public void removePlayer(Player player) {
		places.get(player.getPoi()).remove(player);
	}

	public void init(Collection<Player> players) {
		players.stream().forEach(item -> places.get(item.getPoi()).put(item));
	}

	// 如果能继续移动返回true，否则返回false,当超越其他玩家时，图标覆盖问题

	public int mapLength() {
		return this.places.size();
	}

	public void moveToHospital(Player player, int days) {
		removePlayer(player);
		player.setPoi(0);
		setPlayerPoi(player, 0);
		((Hospital) (places.get(0))).addPatient(player, days);
	}

	public void removeBlock(int poi) {
		places.get(poi).removeBlock();
	}

	public boolean isBank(int poi) {
		return places.get(poi) instanceof Bank;
	}
}
