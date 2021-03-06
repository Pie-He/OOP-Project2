package controller;

import java.util.ArrayList;
import java.util.List;

import bean.item.PersonType;
import bean.item.Player;
import bean.other.Prop;

public class PlayerController extends IController {
	private static final PlayerController CONTROLLER = new PlayerController();

	public static PlayerController getInstance() {
		return CONTROLLER;
	}

	private List<Player> players;
	private int index = 0;
	private boolean flag = false;

	private PlayerController() {
		players = new ArrayList<Player>();
	}

	public void createPlayer(String name, int type) {
		Player p = new Player(name, PersonType.values()[type]);
		p.setPoi(0);
		/*if (players.size() == 1) {
			p.setCash(10);
			p.setDeposit(10);
		}*/
		this.players.add(p);
	}

	public Player nextPlayer() {
		if (++index >= players.size()) {
			flag = true;
			index %= players.size();
		}

		return players.get(index);
	}

	public List<Player> getPlayerList() {
		return this.players;
	}

	public Player getCurrentPlayer() {
		return this.players.get(index);
	}

	public Session userProp(Player player, Prop prop, Session session) {
		player.removeProp(prop);
		return prop.use(player, session);
	}

	public void removePlayer(Player player) {
		this.players.remove(player);
		if (--index < 0)
			index %= players.size();
	}
	
	public boolean isNextDay(){
		if(flag){
			flag=false;
			return true;
		}
		return false;
	}
}
