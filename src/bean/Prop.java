package bean;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import controller.PlayerController;
import controller.Session;
import bean.item.Player;
import bean.item.RoadBlock;
import util.Const;
import util.IO;

public enum Prop {
	roadBlock("·��", 15, 0, "·��:������ǰ��8��֮�ڰ���һ��·�ϣ�������Ҿ���·��ʱ��ͣ��·������λ�ò���ǰ��"), remoteBoson(
			"ң������", 30, 1, "ң������:ʹ��ʱ��������������ӵĽ�������ֻ����1-6"), reverseCard("ת��",
			15, 2, "ת��:ʹ�Լ�������Լ��岽���ڵĶ��ֱ��ת����"), stopCard("������", 20, 3,
			"������:�ûغ�ͣ����ԭ�أ����ٴδ���ԭ���¼�"), taxInspectionCard("��˰��", 20, 4,
			"��˰��:ǿ�н������Լ��岽���ڵĶ���30%�Ĵ���˰(����˰�������˰���ķ�����)"), averageRichCard(
			"������", 80, 5, "������:�������˵��ֽ�ƽ������"), plunderCard("�ӶῨ", 20, 6,
			"�ӶῨ:�����Լ��岽���ڵĶ��� ��������ֵ�һ�ſ��ƾ�Ϊ����");
	private String name;
	private int price;
	private ImageIcon image;
	private ImageIcon imageSelected;
	private String description;

	private Prop(String name, int price, int path, String description) {
		this.name = name;
		this.price = price;
		this.image = new ImageIcon("picture/prop/" + path + ".jpg");
		this.imageSelected = new ImageIcon("picture/prop/" + path + "_����.jpg");
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public Session use(Player p, Session session) {
		switch (this) {
		case roadBlock:
			return this.useRoadBlock(p);
		case remoteBoson:
			return this.useRemoteBoson(p);
		case reverseCard:
			return this.useReverseCard(session);
		case stopCard:
			return this.useStopCard(p);
		case taxInspectionCard:
			return this.useTaxInspectionCard(session);
		case averageRichCard:
			return this.useAverageRichCard();
		case plunderCard:
			return this.usePlunderCard(p, session);
		default:
			return null;
		}
	}

	private Session usePlunderCard(Player p, Session session) {
		Player aim = session.getPlayer("aimPlayer");
		int random = (int) (Math.random() * aim.getpropNum());
		Prop prop = aim.removeProp(random);
		p.addProp(prop);
		String[] message = { aim.getName() + "ʧȥһ��" + prop.name,
				p.getName() + "���һ��" + prop.name };

		return new Session("message", message);
	}

	private Session useAverageRichCard() {
		List<Player> list = PlayerController.getInstance().getPlayerList();
		int all = list.stream().mapToInt(i -> i.getCash()).sum();
		list.stream().forEach(i -> i.setCash(all / list.size()));
		return null;
	}

	private Session useTaxInspectionCard(Session session) {
		Player aim = session.getPlayer("aimPlayer");
		aim.addDeposit(-aim.getDeposit() * 3 / 10);
		return null;
	}

	private Session useStopCard(Player p) {
		return null;
	}

	private Session useReverseCard(Session session) {
		Player aim = session.getPlayer("aimPlayer");
		aim.reverse();
		return null;
	}

	private Session useRemoteBoson(Player p) {
		return null;
	}

	private Session useRoadBlock(Player p) {
		int dis = IO.getDistanceChoice(Const.PROP_CHOOSE.toString(), -8, 8);
		if (dis > 8)
			return null;
		// int poi = p.getPrePoi(dis);
		int poi = 0;
		if (!Map.getInstance().addBlock(new RoadBlock(poi))) {
			IO.printString(Const.BLOCK_EXSITED);
			return null;
		}
		return null;
	}

	private Player getChoosePlayer(Player p, int range, boolean includeSelf) {
		LinkedList<Player> l = new LinkedList<Player>();
		LinkedList<String> strs = new LinkedList<String>();
		PlayerController.getInstance().getPlayerList().stream()
				.filter(i -> p.isInView(i, range, 0)).forEach(i -> {
					if (includeSelf || i != p) {
						l.add(i);
						strs.add(i.getName());
					}
				});
		int choice = IO.getChoosePlayer(strs);
		if (choice >= l.size()) {
			return null;
		}
		return l.get(choice);
	}

	public String toText() {
		return name;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public ImageIcon getImageSelected() {
		return imageSelected;
	}

	public void setImageSelected(ImageIcon imageSelected) {
		this.imageSelected = imageSelected;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
