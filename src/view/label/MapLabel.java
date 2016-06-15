package view.label;

import static controller.MapController.getInstance;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bean.item.Player;
import controller.PlayerController;
import view.map.*;

@SuppressWarnings("serial")
public class MapLabel extends JLabel {
	public Map[] map = new Map[42];// 地图格子

	public MapLabel() {
		setLayout(null);
		setSize(800, 610);

		map[0] = new MapHospital();
		map[0].setLocation(20, 20);
		for (int i = 1; i <= 5; i++) {
			map[i] = new MapHouse();
			/*
			 * Map[i].type.street = "Lancer"; Map[i].type.name =
			 * Map[i].type.street + i; Map[i].type.setInit(1000);
			 */
		}
		for (int i = 7; i <= 11; i++) {
			map[i] = new MapHouse();
			/*
			 * Map[i].type.street = "Assassin"; Map[i].type.name =
			 * Map[i].type.street + (i - 6); Map[i].type.setInit(1500);
			 */

		}
		for (int i = 13; i <= 14; i++) {
			map[i] = new MapHouse();
			/*
			 * Map[i].type.street = "Berserker"; Map[i].type.name =
			 * Map[i].type.street + (i - 12); Map[i].type.setInit(3000);
			 */
		}
		for (int i = 16; i <= 18; i++) {
			map[i] = new MapHouse();
			/*
			 * Map[i].type.street = "Berserker"; Map[i].type.name =
			 * Map[i].type.street + (i - 13); Map[i].type.setInit(3000);
			 */
		}
		for (int i = 20; i <= 24; i++) {
			map[i] = new MapHouse();
			/*
			 * Map[i].type.street = "Caster"; Map[i].type.name =
			 * Map[i].type.street + (i - 19); Map[i].type.setInit(2000);
			 */
		}
		for (int i = 26; i <= 30; i++) {
			map[i] = new MapHouse();
			/*
			 * Map[i].type.street = "Avenger"; Map[i].type.name =
			 * Map[i].type.street + (i - 25); Map[i].type.setInit(2500);
			 */
		}
		map[6] = new MapShop();
		map[25] = new MapSpace();
		map[12] = new MapNews();
		map[15] = new MapBank();
		map[19] = new MapCardPrize();
		map[34] = new MapLottery();
		map[37] = new MapBank();
		for (int i = 31; i <= 33; i++) {
			map[i] = new MapCoupon();
			map[35] = new MapCoupon();
			map[36] = new MapCoupon();
		}
		for (int i = 38; i <= 41; i++) {
			map[i] = new MapCoupon();
		}

		add(map[0]);
		map[0].setLocation(20, 20);
		for (int i = 1; i <= 5; i++) {
			add(map[i]);
			map[i].setLocation(150 + 50 * (i - 1), 100);
			add(map[i].getLv());
			map[i].getLv().setLocation(150 + 50 * (i - 1), 50);
		}
		add(map[6]);
		map[6].setLocation(400, 20);
		add(map[7]);
		map[7].setLocation(480, 150);
		add(map[7].getLv());
		map[7].getLv().setLocation(430, 150);
		for (int i = 8; i <= 10; i++) {
			add(map[i]);
			map[i].setLocation(480 + 50 * (i - 8), 200);
			add(map[i].getLv());
			map[i].getLv().setLocation(480 + 50 * (i - 8), 250);
		}
		add(map[11]);
		map[11].setLocation(580, 150);
		add(map[11].getLv());
		map[11].getLv().setLocation(630, 150);
		add(map[12]);
		map[12].setLocation(580, 20);
		add(map[13]);
		map[13].setLocation(710, 20);
		add(map[13].getLv());
		map[13].getLv().setLocation(710, 70);
		for (int i = 14; i <= 18; i++) {
			if (i != 15) {
				add(map[i]);
				map[i].setLocation(760, 20 + 50 * (i - 14));
				add(map[i].getLv());
				map[i].getLv().setLocation(810, 20 + 50 * (i - 14));
			} else {
				add(map[i]);
				map[i].setLocation(760, 20 + 50 * (i - 14));
			}
		}
		add(map[19]);
		map[19].setLocation(680, 270);
		for (int i = 20; i <= 23; i++) {
			add(map[i]);
			map[i].setLocation(680, 400 + 50 * (i - 20));
			add(map[i].getLv());
			map[i].getLv().setLocation(730, 400 + 50 * (i - 20));
		}
		add(map[24]);
		map[24].setLocation(630, 550);
		add(map[24].getLv());
		map[24].getLv().setLocation(630, 600);
		add(map[25]);
		map[25].setLocation(500, 470);
		for (int i = 26; i <= 28; i++) {
			add(map[i]);
			map[i].setLocation(450 - 50 * (i - 26), 550);
			add(map[i].getLv());
			map[i].getLv().setLocation(450 - 50 * (i - 26), 600);
		}
		add(map[29]);
		map[29].setLocation(350, 500);
		add(map[29].getLv());
		map[29].getLv().setLocation(350, 450);
		add(map[30]);
		map[30].setLocation(300, 500);
		add(map[30].getLv());
		map[30].getLv().setLocation(300, 450);
		for (int i = 31; i <= 33; i++) {
			add(map[i]);
			map[i].setLocation(250 - 50 * (i - 31), 500);
		}
		add(map[34]);
		map[34].setLocation(20, 500);
		for (int i = 35; i <= 41; i++) {
			add(map[i]);
			map[i].setLocation(20, 450 - 50 * (i - 35));
		}
		for (int i = 0; i < this.map.length; i++) {
			map[i].setType(getInstance().getInitMap().get(i));
		}
		this.refresh();
		/*
		 * ImageIcon icon=new ImageIcon("picture/person/人物1.png");
		 * Map[0].putImage(icon.getImage()); Map[0].repaint();
		 */
	}


	public void refresh() {
		/*
		 * p1.resetP(GloVar.p1); p2.resetP(GloVar.p2); p1.refresh();
		 * p2.refresh();
		 */
		for (int i = 0; i < map.length; i++) {
			map[i].repaint();
		}
		for (int i = 1; i <= 5; i++) {
			map[i].getLv().repaint();
		}
		for (int i = 7; i <= 11; i++) {
			map[i].getLv().repaint();
		}
		for (int i = 13; i <= 18; i++) {
			if (i != 15)
				map[i].getLv().repaint();
		}
		for (int i = 20; i <= 24; i++) {
			map[i].getLv().repaint();
		}
		for (int i = 26; i <= 30; i++) {
			map[i].getLv().repaint();
		}
		// GloVarGUI.time.refresh();
	}


	public void event(Player player) {
		map[player.getPoi()].event(player);
		
	}
}
