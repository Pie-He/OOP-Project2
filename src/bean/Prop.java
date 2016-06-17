package bean;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import bean.item.Player;
import bean.item.RoadBlock;
import util.Const;
import util.IO;

public enum Prop {
	roadBlock("·��", 15, 0, "·��:������ǰ��8��֮�ڰ���һ��·�ϣ�������Ҿ���·��ʱ��ͣ��·������λ�ò���ǰ��"), 
	remoteBoson("ң������", 30, 1, "ң������:ʹ��ʱ��������������ӵĽ�������ֻ����1-6"), 
	reverseCard("ת��",15, 2, "ת��:ʹ�Լ�������Լ��岽���ڵĶ��ֱ��ת����"), 
	stopCard("������", 20, 3,"������:�ûغ�ͣ����ԭ�أ����ٴδ���ԭ���¼�"), 
	taxInspectionCard("��˰��", 20, 4,"��˰��:ǿ�н������Լ��岽���ڵĶ���30%�Ĵ���˰(����˰�������˰���ķ�����)"), 
	averageRichCard("������", 80, 5, "������:�������˵��ֽ�ƽ������"), 
	plunderCard("�ӶῨ", 20, 6,"�ӶῨ:�����Լ��岽���ڵĶ��� ��������ֵ�һ�ſ��ƾ�Ϊ����");
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

	public boolean use(Player p) {
		switch (this) {
		case roadBlock:
			return this.useRoadBlock(p);
		case remoteBoson:
			return this.useRemoteBoson(p);
		case reverseCard:
			return this.useReverseCard(p);
		case stopCard:
			return this.useStopCard(p);
		case taxInspectionCard:
			return this.useTaxInspectionCard(p);
		case averageRichCard:
			return this.useAverageRichCard(p);
		case plunderCard:
			return this.usePlunderCard(p);
		default:
			return false;
		}
	}

	private boolean usePlunderCard(Player p) {
		Player aim;
		if ((aim = getChoosePlayer(p, 5, false)) == null)
			return false;
		if (aim.getpropNum() <= 0) {
			IO.printString(aim.getName() + Const.PROP_NO_PROP);
			return false;
		}
		int random = (int) (Math.random() * aim.getpropNum());
		Prop prop = aim.removeProp(random);
		p.addProp(prop);
		IO.printString(aim.getName() + "ʧȥһ��" + prop.name);
		IO.printString(p.getName() + "���һ��" + prop.name);
		return true;
	}

	private boolean useAverageRichCard(Player p) {
		IO.printString(Const.PROP_AVERAGE);
		int all = Manager.players.stream().mapToInt(i -> i.getCash()).sum();
		Manager.players.stream().forEach(
				i -> i.setCash(all / Manager.players.size()));
		return true;
	}

	private boolean useTaxInspectionCard(Player p) {
		Player aim;
		if ((aim = getChoosePlayer(p, 5, false)) == null)
			return false;
		IO.printString(aim.getName() + Const.PROP_DEPO_FINE);
		aim.addDeposit(-aim.getDeposit() * 3 / 10);
		return true;
	}

	private boolean useStopCard(Player p) {
		Manager.diceFlag = 0;
		return true;
	}

	private boolean useReverseCard(Player p) {
		Player aim;
		if ((aim = getChoosePlayer(p, 5, true)) == null)
			return false;
		IO.printString("��" + aim.getName() + "ʹ����ת��");
		aim.reverse();
		return true;
	}

	private boolean useRemoteBoson(Player p) {
		int dice = IO.getDice();
		if (dice > 6)
			return false;
		Manager.diceFlag = dice;
		return true;
	}

	private boolean useRoadBlock(Player p) {
		int dis = IO.getDistanceChoice(Const.PROP_CHOOSE.toString(), -8, 8);
		if (dis > 8)
			return false;
		// int poi = p.getPrePoi(dis);
		int poi = 0;
		if (!Map.getInstance().addBlock(new RoadBlock(poi))) {
			IO.printString(Const.BLOCK_EXSITED);
			return false;
		}
		return true;
	}

	private Player getChoosePlayer(Player p, int range, boolean includeSelf) {
		LinkedList<Player> l = new LinkedList<Player>();
		LinkedList<String> strs = new LinkedList<String>();
		Manager.players.stream().filter(i -> p.isInView(i, range, 0))
				.forEach(i -> {
					// if(!includeSelf&&i==p)
					// continue;
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
