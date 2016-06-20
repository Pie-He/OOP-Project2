package view.map;

import static controller.MapController.getInstance;
import igui.IOption;

import javax.swing.ImageIcon;

import controller.Session;
import bean.Prop;
import bean.item.Player;

//�������ߵ�
@SuppressWarnings("serial")
public class MapCardPrize extends Map {
	private final static ImageIcon ICON = new ImageIcon("picture/place/ʥ��.png");
	static String[] pName = { "������", "�ڹ꿨", "ת��", "��Ǩ��", "���ؿ�", "��˰��", "�ӶῨ",
			"ң������", "����", "����", "���ؿ�", "���޿�", "��ħ��", "������" };

	public MapCardPrize() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
		// type=new CardPrize();
	}

	public void event(final Player p) {

		Session session = new Session("player", p);
		Session response = getInstance().event(type, session);
		Prop prop = (Prop) response.get("prop");
		IOption.showMessage("��ϲ�����" + prop.toText() + "1��");
	}

}