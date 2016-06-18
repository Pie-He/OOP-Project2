package view;

import static controller.PlayerController.getInstance;

import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.PlayerController;
import controller.Session;
import util.Const;
import bean.Prop;
import bean.item.Player;
import igui.IDialog;
import igui.IOption;

@SuppressWarnings("serial")
public class PropUse extends IDialog {

	PropUse() {
		super(400, 300);
	}

	public static void use(Prop prop, Player player, JDialog dialog) {
		switch (prop) {
		case roadBlock:
			userRoadBlock(player);
		case remoteBoson:
			useRemoteBoson(player, dialog);
			break;
		case reverseCard:
			useReverseCard(player);
			break;
		case stopCard:
			userStopCard(player, dialog);
			break;
		case taxInspectionCard:
			useTaxInspectionCard(player);
			break;
		case averageRichCard:
			userAverageRichCard(player);
			break;
		case plunderCard:
			usePlunderCard(player);
		default:
		}
	}

	private static void userRoadBlock(Player player) {
		
	}

	private static void usePlunderCard(Player player) {
		Player aim = getChoosePlayer(player, 5, false);
		if (aim == null)
			return;
		if (aim.getpropNum() <= 0) {
			IOption.showMessage(aim.getName() + Const.PROP_NO_PROP);
			return;
		}
		IOption.showMessage("对" + aim.getName() + "使用了掠夺卡");
		Session session = new Session("aimPlayer", aim);
		String[] message = getInstance().userProp(player, Prop.plunderCard,
				session).getStrings("message");
		IOption.showMessage(message);

	}

	private static void userAverageRichCard(Player player) {
		IOption.showMessage("使用了均富卡");
		getInstance().userProp(player, Prop.averageRichCard, null);
	}

	private static void useTaxInspectionCard(Player player) {
		Player aim = getChoosePlayer(player, 5, false);
		if (aim != null) {
			Session session = new Session("aimPlayer", aim);
			getInstance().userProp(player, Prop.taxInspectionCard, session);
			IOption.showMessage("对" + aim.getName() + "使用了查税卡");
		}
	}

	private static void userStopCard(Player player, JDialog dialog) {
		IOption.showMessage("使用了滞留卡");
		getInstance().userProp(player, Prop.stopCard, null);
		dialog.dispose();
		ViewController.getInstance().move(0);

	}

	private static void useReverseCard(Player player) {
		Player aim = getChoosePlayer(player, 5, true);
		if (aim != null) {
			Session session = new Session("aimPlayer", aim);
			getInstance().userProp(player, Prop.reverseCard, session);
			IOption.showMessage("对" + aim.getName() + "使用了转向卡");
		}
	}

	private static void useRemoteBoson(Player player, JDialog dialog) {
		Object[] num = { "1", "2", "3", "4", "5", "6" };
		String num0 = (String) JOptionPane.showInputDialog(null,
				"请选择你要掷的点数:\n", "遥控骰子", JOptionPane.PLAIN_MESSAGE, null, num,
				"1");
		if (num0 != null) {
			getInstance().userProp(player, Prop.remoteBoson, null);
			int dice = Integer.parseInt(num0);
			dialog.dispose();
			ViewController.getInstance().move(dice);
		}
	}

	private static Player getChoosePlayer(Player p, int range,
			boolean includeSelf) {
		LinkedList<Player> l = new LinkedList<Player>();
		PlayerController.getInstance().getPlayerList().stream()
				.filter(i -> p.isInView(i, range, 0)).forEach(i -> {
					if (includeSelf || i != p) {
						l.add(i);
					}
				});
		Player[] ss = l.toArray(new Player[l.size()]);
		Player choice = (Player) JOptionPane.showInputDialog(null,
				"请选择你要掷的点数:\n", "遥控骰子", JOptionPane.PLAIN_MESSAGE, null, ss,
				"1");
		return choice;
	}

}
