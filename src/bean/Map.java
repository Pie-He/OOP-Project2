package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import util.Const;
import util.IO;
import bean.item.Player;
import bean.item.RoadBlock;
import bean.place.*;

public class Map {
	/* 单例模式 */
	private static final Map MAP = new Map();

	public Map() {
		places = new ArrayList<Place>();
		mapLength = places.size();
	}

	public static Map getInstance() {
		return MAP;
	}

	private List<Place> places;
	// private int width;
	// private int height;
	public final int mapLength;

	public void setMap(List<Place> places) {
		this.places = places;
	}

	public List<Place> getMap() {
		return this.places;
	}

	public boolean event(Player player, int dice) {
		for (int i = 0; i < dice; i++) {
			if (!movePlayer(player))
				return true;
		}
		if (!(places.get(player.getPoi()) instanceof Bank))
			return places.get(player.getPoi()).event(player);
		return true;
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
	private boolean movePlayer(Player p) {
		int poi0 = p.getPoi();
		places.get(poi0).remove(p);
		int poi = p.walk();
		places.get(poi).put(p);
		if (places.get(poi).removeBlock()) {
			IO.printString(Const.BLOCK_YES);
			places.get(poi).event(p);
			return false;
		}
		if (places.get(poi) instanceof Bank)
			places.get(poi).event(p);
		return true;
	}

}
