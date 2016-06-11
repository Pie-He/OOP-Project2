package view.label;

import javax.swing.JLabel;

import view.map.*;

@SuppressWarnings("serial")
public class MapLabel extends JLabel{
	public MapJLabel[] Map = new MapJLabel[42];// µØÍ¼¸ñ×Ó
	
	public  MapLabel() {
		setLayout(null);
		setSize(800, 610);
		
		
		
		Map[0] = new MapHospital();
		Map[0].setLocation(20, 20);
		for (int i = 1; i <= 5; i++) {
			Map[i] = new MapHouse();
			/*Map[i].type.street = "Lancer";
			Map[i].type.name = Map[i].type.street + i;
			Map[i].type.setInit(1000);*/
		}
		for (int i = 7; i <= 11; i++) {
			Map[i] = new MapHouse();
			/*Map[i].type.street = "Assassin";
			Map[i].type.name = Map[i].type.street + (i - 6);
			Map[i].type.setInit(1500);*/

		}
		for (int i = 13; i <= 14; i++) {
			Map[i] = new MapHouse();
		/*	Map[i].type.street = "Berserker";
			Map[i].type.name = Map[i].type.street + (i - 12);
			Map[i].type.setInit(3000);*/
		}
		for (int i = 16; i <= 18; i++) {
			Map[i] = new MapHouse();
			/*Map[i].type.street = "Berserker";
			Map[i].type.name = Map[i].type.street + (i - 13);
			Map[i].type.setInit(3000);*/
		}
		for (int i = 20; i <= 24; i++) {
			Map[i] = new MapHouse();
			/*Map[i].type.street = "Caster";
			Map[i].type.name = Map[i].type.street + (i - 19);
			Map[i].type.setInit(2000);*/
		}
		for (int i = 26; i <= 30; i++) {
			Map[i] = new MapHouse();
			/*Map[i].type.street = "Avenger";
			Map[i].type.name = Map[i].type.street + (i - 25);
			Map[i].type.setInit(2500);*/
		}
		Map[6] = new MapShop();
		Map[25] = new MapSpace();
		Map[12] = new MapNews();
		Map[15] = new MapBank();
		Map[19] = new MapCardPrize();
		Map[34] = new MapLottery();
		Map[37] = new MapBank();
		for (int i = 31; i <= 33; i++) {
			Map[i] = new MapCoupon();
			Map[35] = new MapCoupon();
			Map[36] = new MapCoupon();
		}
		for (int i = 38; i <= 41; i++) {
			Map[i] = new MapCoupon();
		}
		
		add(Map[0]);
		Map[0].setLocation(20, 20);
		for (int i = 1; i <= 5; i++) {
			add(Map[i]);
			Map[i].setLocation(150 + 50 * (i - 1), 100);
			add(Map[i].getLv());
			Map[i].getLv().setLocation(150 + 50 * (i - 1), 50);
		}
		add(Map[6]);
		Map[6].setLocation(400, 20);
		add(Map[7]);
		Map[7].setLocation(480, 150);
		add(Map[7].getLv());
		Map[7].getLv().setLocation(430, 150);
		for (int i = 8; i <= 10; i++) {
			add(Map[i]);
			Map[i].setLocation(480 + 50 * (i - 8), 200);
			add(Map[i].getLv());
			Map[i].getLv().setLocation(480 + 50 * (i - 8), 250);
		}
		add(Map[11]);
		Map[11].setLocation(580, 150);
		add(Map[11].getLv());
		Map[11].getLv().setLocation(630, 150);
		add(Map[12]);
		Map[12].setLocation(580, 20);
		add(Map[13]);
		Map[13].setLocation(710, 20);
		add(Map[13].getLv());
		Map[13].getLv().setLocation(710, 70);
		for (int i = 14; i <= 18; i++) {
			if (i != 15) {
				add(Map[i]);
				Map[i].setLocation(760, 20 + 50 * (i - 14));
				add(Map[i].getLv());
				Map[i].getLv().setLocation(810, 20 + 50 * (i - 14));
			} else {
				add(Map[i]);
				Map[i].setLocation(760, 20 + 50 * (i - 14));
			}
		}
		add(Map[19]);
		Map[19].setLocation(680, 270);
		for (int i = 20; i <= 23; i++) {
			add(Map[i]);
			Map[i].setLocation(680, 400 + 50 * (i - 20));
			add(Map[i].getLv());
			Map[i].getLv().setLocation(730, 400 + 50 * (i - 20));
		}
		add(Map[24]);
		Map[24].setLocation(630, 550);
		add(Map[24].getLv());
		Map[24].getLv().setLocation(630, 600);
		add(Map[25]);
		Map[25].setLocation(500, 470);
		for (int i = 26; i <= 28; i++) {
			add(Map[i]);
			Map[i].setLocation(450 - 50 * (i - 26), 550);
			add(Map[i].getLv());
			Map[i].getLv().setLocation(450 - 50 * (i - 26), 600);
		}
		add(Map[29]);
		Map[29].setLocation(350, 500);
		add(Map[29].getLv());
		Map[29].getLv().setLocation(350, 450);
		add(Map[30]);
		Map[30].setLocation(300, 500);
		add(Map[30].getLv());
		Map[30].getLv().setLocation(300, 450);
		for (int i = 31; i <= 33; i++) {
			add(Map[i]);
			Map[i].setLocation(250 - 50 * (i - 31), 500);
		}
		add(Map[34]);
		Map[34].setLocation(20, 500);
		for (int i = 35; i <= 41; i++) {
			add(Map[i]);
			Map[i].setLocation(20, 450 - 50 * (i - 35));
		}
	}
}
