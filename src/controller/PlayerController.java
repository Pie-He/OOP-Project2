package controller;

import java.util.ArrayList;
import java.util.List;

import bean.Prop;
import bean.item.PersonType;
import bean.item.Player;

public class PlayerController extends IController {
	private static final PlayerController CONTROLLER = new PlayerController();

	public static PlayerController getInstance() {
		return CONTROLLER;
	}

	private List<Player> players;
	private int index = 0;

	private PlayerController() {
		players = new ArrayList<Player>();
	}

	public void createPlayer(String name, int type) {
		Player p = new Player(name, PersonType.values()[type]);
		p.setPoi(0);
		this.players.add(p);
	}

	public int nextPlayer() {
		// index++;
		if (++index >= players.size())
			index %= players.size();
		return index;
	}

	public List<Player> getPlayerList() {
		return this.players;
	}

	public Player getCurrentPlayer() {
		return this.players.get(index);
	}

	public Session userProp(Player player,Prop prop,Session session) {
		player.removeProp(prop);
		return prop.use(player, session);
	}
}
