package view.label;

import static controller.MapController.getInstance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import bean.item.Player;
import view.map.*;

//显示地图所有格子的信息，地图格子初始化
@SuppressWarnings("serial")
public class MapLabel extends JLabel {
	public Map[] map = new Map[42];// 地图格子
	private mapMess jlMap = new mapMess();

	public MapLabel() {
		setLayout(null);
		setSize(860, 700);

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
			add(((MapHouse) map[i]).getLv());
			((MapHouse) map[i]).getLv().setLocation(150 + 50 * (i - 1), 50);
		}
		add(map[6]);
		map[6].setLocation(400, 20);
		add(map[7]);
		map[7].setLocation(480, 150);
		add(((MapHouse) map[7]).getLv());
		((MapHouse) map[7]).getLv().setLocation(430, 150);
		for (int i = 8; i <= 10; i++) {
			add(map[i]);
			map[i].setLocation(480 + 50 * (i - 8), 200);
			add(((MapHouse) map[i]).getLv());
			((MapHouse) map[i]).getLv().setLocation(480 + 50 * (i - 8), 250);
		}
		add(map[11]);
		map[11].setLocation(580, 150);
		add(((MapHouse) map[11]).getLv());
		((MapHouse) map[11]).getLv().setLocation(630, 150);
		add(map[12]);
		map[12].setLocation(580, 20);
		add(map[13]);
		map[13].setLocation(710, 20);
		add(((MapHouse) map[13]).getLv());
		((MapHouse) map[13]).getLv().setLocation(710, 70);
		for (int i = 14; i <= 18; i++) {
			if (i != 15) {
				add(map[i]);
				map[i].setLocation(760, 20 + 50 * (i - 14));
				add(((MapHouse) map[i]).getLv());
				((MapHouse) map[i]).getLv()
						.setLocation(810, 20 + 50 * (i - 14));
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
			add(((MapHouse) map[i]).getLv());
			((MapHouse) map[i]).getLv().setLocation(730, 400 + 50 * (i - 20));
		}
		add(map[24]);
		map[24].setLocation(630, 550);
		add(((MapHouse) map[24]).getLv());
		((MapHouse) map[24]).getLv().setLocation(630, 600);
		add(map[25]);
		map[25].setLocation(500, 470);
		for (int i = 26; i <= 28; i++) {
			add(map[i]);
			map[i].setLocation(450 - 50 * (i - 26), 550);
			add(((MapHouse) map[i]).getLv());
			((MapHouse) map[i]).getLv().setLocation(450 - 50 * (i - 26), 600);
		}
		add(map[29]);
		map[29].setLocation(350, 500);
		add(((MapHouse) map[29]).getLv());
		((MapHouse) map[29]).getLv().setLocation(350, 450);
		add(map[30]);
		map[30].setLocation(300, 500);
		add(((MapHouse) map[30]).getLv());
		((MapHouse) map[30]).getLv().setLocation(300, 450);
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

		for (int i = 0; i < map.length; i++) {
			int f = i;
			map[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					jlMap.setText(map[f].getMessage());
					jlMap.repaint();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					jlMap.setText("");
					jlMap.repaint();
				}
			});
		}

		this.refresh();
		/*
		 * ImageIcon icon=new ImageIcon("picture/person/人物1.png");
		 * Map[0].putImage(icon.getImage()); Map[0].repaint();
		 */
		add(jlMap);
		jlMap.setLocation(50, 600);
	}

	public void refresh() {
		for (int i = 0; i < map.length; i++) {
			map[i].repaint();
		}
	}

	public void event(Player player) {
		map[player.getPoi()].event(player);

	}

	class mapMess extends JLabel {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		mapMess() {
			super("信息栏");
			setSize(800, 100);
			setForeground(Color.WHITE);
			setFont(new Font("幼圆", Font.PLAIN, 20));
		}
	}

	public boolean preEvent(Player player) {
		return map[player.getPoi()].preEvent(player);
	}

}
