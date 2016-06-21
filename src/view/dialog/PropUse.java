package view.dialog;

import static controller.PlayerController.getInstance;

import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controller.MapController;
import controller.PlayerController;
import controller.Session;
import util.Const;
import view.ViewController;
import bean.item.Player;
import bean.other.Prop;
import igui.IDialog;
import igui.IOption;

//����ʹ�ô������
@SuppressWarnings("serial")
public class PropUse extends IDialog {

	PropUse() {
		super(400, 300);
	}

	public static void use(Prop prop, Player player, JDialog dialog) {
		switch (prop) {
		case roadBlock:
			userRoadBlock(player);
			break;
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
		Integer[] ints = new Integer[17];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = i - 8;
		}
		Integer dis = (int) JOptionPane.showInputDialog(null,
				"��ѡ����Ҫ���õ�λ�ã�������ʾǰ����������ʾ��:\n", "·��", JOptionPane.PLAIN_MESSAGE,
				null, ints, ints[0]);
		if (dis == null)
			return;
		int poi = player
				.getPrePoi(dis, MapController.getInstance().mapLength());
		if (MapController.getInstance().isBlock(poi)) {
			IOption.showMessage(Const.BLOCK_EXSITED.toString());
			return;
		}
		Session session = new Session("poi", poi);
		getInstance().userProp(player, Prop.roadBlock, session);
	}

	private static void usePlunderCard(Player player) {
		Player aim = getChoosePlayer(player, 5, false);
		if (aim == null)
			return;
		if (aim.getpropNum() <= 0) {
			IOption.showMessage(aim.getName() + Const.PROP_NO_PROP);
			return;
		}
		IOption.showMessage("��" + aim.getName() + "ʹ�����ӶῨ");
		Session session = new Session("aimPlayer", aim);
		String[] message = getInstance().userProp(player, Prop.plunderCard,
				session).getStrings("message");
		IOption.showMessage(message);

	}

	private static void userAverageRichCard(Player player) {
		IOption.showMessage("ʹ���˾�����");
		getInstance().userProp(player, Prop.averageRichCard, null);
	}

	private static void useTaxInspectionCard(Player player) {
		Player aim = getChoosePlayer(player, 5, false);
		if (aim != null) {
			Session session = new Session("aimPlayer", aim);
			getInstance().userProp(player, Prop.taxInspectionCard, session);
			IOption.showMessage("��" + aim.getName() + "ʹ���˲�˰��");
		}
	}

	private static void userStopCard(Player player, JDialog dialog) {
		IOption.showMessage("ʹ����������");
		getInstance().userProp(player, Prop.stopCard, null);
		dialog.dispose();
		ViewController.getInstance().move(0);

	}

	private static void useReverseCard(Player player) {
		Player aim = getChoosePlayer(player, 5, true);
		if (aim != null) {
			Session session = new Session("aimPlayer", aim);
			getInstance().userProp(player, Prop.reverseCard, session);
			IOption.showMessage("��" + aim.getName() + "ʹ����ת��");
		}
	}

	private static void useRemoteBoson(Player player, JDialog dialog) {
		Object[] num = { "1", "2", "3", "4", "5", "6" };
		String num0 = (String) JOptionPane.showInputDialog(null,
				"��ѡ����Ҫ���ĵ���:\n", "ң������", JOptionPane.PLAIN_MESSAGE, null, num,
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
		PlayerController
				.getInstance()
				.getPlayerList()
				.stream()
				.filter(i -> p.isInView(i, range, MapController.getInstance()
						.mapLength())).forEach(i -> {
					if (includeSelf || i != p) {
						l.add(i);
					}
				});
		Player[] ss = l.toArray(new Player[l.size()]);
		Player choice = (Player) JOptionPane.showInputDialog(null,
				"��ѡ��ʹ�ö���:\n", null, JOptionPane.PLAIN_MESSAGE, null, ss, "1");
		return choice;
	}

}