package bean;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import util.Const;
import util.IO;
import bean.item.Player;
import bean.item.RoadBlock;
import bean.place.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Map {
	/*����ģʽ*/
	private static final Map MAP = new Map();

	private Map() {
		places = new ArrayList<Place>();
		getMapData();
		mapLength = places.size();
	}
	public static Map getInstance() {
		return MAP;
	}

	private ArrayList<Place> places;
	private String[][] staticMap;
	//private int width;
	//private int height;
	public final int mapLength;


	public String[][] getInitalMap() {
		return this.staticMap;
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

	public void removePlayer(Player player){
		places.get(player.getPoi()).remove(player);
	}
	public void init(Collection<Player> players) {
		players.stream().forEach(item -> places.get(item.getPoi()).put(item));
	}

	// ����ܼ����ƶ�����true�����򷵻�false,����Խ�������ʱ��ͼ�긲������
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

	private void getMapData() {
		File file = new File("places.txt");
		String str;
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((str = br.readLine()) != null) {
					JSONObject jo = JSON.parseObject(str);
					Place place = getRealInstance(jo);
					places.add(place);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private Place getRealInstance(JSONObject jo) {
		String symbol = jo.get("symbol").toString();
		for (PlaceEnum p : PlaceEnum.values()) {
			if (p.getSymbol().equals(symbol)) {
				return JSON.toJavaObject(jo, p.getRealClass());
			}
		}
		return null;
	}
}
