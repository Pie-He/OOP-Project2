package view.map;

import javax.swing.JLabel;

import bean.item.Player;
//��ͼ������
public abstract class Map extends JLabel{
	abstract MapLv getLv();
	abstract void setLv(int i);
}
