package controller;

import java.util.ArrayList;
import java.util.List;

import bean.item.Player;

public class PlayerController extends IController {
	
	private List<Player> players;
	
	PlayerController(){
		players=new ArrayList<Player>();
	}
	
	public void createPlayer(String name,String symbolUrl,String hsSymbolUrl){
		Player p=new Player(name,symbolUrl,hsSymbolUrl);
		this.players.add(p);
	}
}
