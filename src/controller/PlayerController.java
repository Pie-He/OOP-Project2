package controller;

import java.util.ArrayList;
import java.util.List;

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

	public void createPlayer(String name, String symbolUrl, String hsSymbolUrl,
			String imageUrl, String nameUrl) {
		Player p = new Player(name, symbolUrl, hsSymbolUrl, imageUrl, nameUrl);
		p.setPoi(0);
		this.players.add(p);
	}

	public Player nextPlayer() {
		//index++;
		if (++index >= players.size())
			index %= players.size();
		return players.get(index);
	}

	public List<Player> getPlayerList() {
		return this.players;
	}

	public Player getCurrentPlayer() {
		return this.players.get(index);
	}
}
