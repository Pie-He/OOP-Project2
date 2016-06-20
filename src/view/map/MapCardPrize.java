package view.map;

import static controller.MapController.getInstance;
import igui.IOption;

import javax.swing.ImageIcon;

import controller.Session;
import bean.Prop;
import bean.item.Player;

//奖励道具点
@SuppressWarnings("serial")
public class MapCardPrize extends Map {
	private final static ImageIcon ICON = new ImageIcon("picture/place/圣剑.png");
	static String[] pName = { "滞留卡", "乌龟卡", "转向卡", "拆迁卡", "购地卡", "查税卡", "掠夺卡",
			"遥控骰子", "福神卡", "财神卡", "土地卡", "怪兽卡", "恶魔卡", "均富卡" };

	public MapCardPrize() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
		// type=new CardPrize();
	}

	public void event(final Player p) {

		Session session = new Session("player", p);
		Session response = getInstance().event(type, session);
		Prop prop = (Prop) response.get("prop");
		IOption.showMessage("恭喜！获得" + prop.toText() + "1个");
	}

}