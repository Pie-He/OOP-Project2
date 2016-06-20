package bean;

import java.util.List;

import javax.swing.ImageIcon;

import controller.MapController;
import controller.PlayerController;
import controller.Session;
import bean.item.Player;


//保存道具及各种道具的使用
public enum Prop {
	roadBlock("路障", 15, 0, "路障:可以在前后8步之内安放一个路障，任意玩家经过路障时会停在路障所在位置不能前行"), remoteBoson(
			"遥控骰子", 30, 1, "遥控骰子:使用时可以任意控制骰子的结果，结果只能是1-6"), reverseCard("转向卡",
			15, 2, "转向卡:使自己或距离自己五步以内的对手标掉转方向"), stopCard("滞留卡", 20, 3,
			"滞留卡:该回合停留在原地，并再次触发原地事件"), taxInspectionCard("查税卡", 20, 4,
			"查税卡:强行将距离自己五步以内的对手30%的存款缴税(所缴税款并不给查税卡的发动者)"), averageRichCard(
			"均富卡", 80, 5, "均富卡:将所有人的现金平均分配"), plunderCard("掠夺卡", 20, 6,
			"掠夺卡:距离自己五步以内的对手 随机将对手的一张卡牌据为己有");
	private String name;
	private int price;
	private ImageIcon image;
	private ImageIcon imageSelected;
	private String description;

	private Prop(String name, int price, int path, String description) {
		this.name = name;
		this.price = price;
		this.image = new ImageIcon("picture/prop/" + path + ".jpg");
		this.imageSelected = new ImageIcon("picture/prop/" + path + "_副本.jpg");
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public Session use(Player p, Session session) {
		switch (this) {
		case roadBlock:
			return this.useRoadBlock(session);
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
		String[] message = { aim.getName() + "失去一张" + prop.name,
				p.getName() + "获得一张" + prop.name };

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

	private Session useRoadBlock(Session session) {
		int poi = session.getInteger("poi");
		MapController.getInstance().addBlock(poi);
		return null;
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
