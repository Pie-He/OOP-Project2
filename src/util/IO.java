package util;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import type.*;

public class IO {
	private final static String[] MAINMENU = { "0-�鿴��ͼ", "1-�鿴ԭʼ��ͼ", "2-ʹ�õ���",
			"3-�鿴10��ʮ������ʾ��", "4-�鿴ǰ��ָ�������ľ�����Ϣ", "5-�鿴��ҵ��ʲ���Ϣ",
			"6-�뿴�Ķ����ˣ����������������", "7-�����ˣ�����", "8-��Ʊ" };
	private final static String[] propHelp = {
			"·��:������ǰ��8��֮�ڰ���һ��·�ϣ�������Ҿ���·��ʱ��ͣ��·������λ�ò���ǰ��",
			"ң������:ʹ��ʱ��������������ӵĽ�������ֻ����1-6", "ת��:ʹ�Լ�������Լ��岽���ڵĶ��ֱ��ת����",
			"������:�ûغ�ͣ����ԭ�أ����ٴδ���ԭ���¼�",
			"��˰��:ǿ�н������Լ��岽���ڵĶ���30%�Ĵ���˰(����˰�������˰���ķ�����)", "������:�������˵��ֽ�ƽ������",
			"�ӶῨ:�����Լ��岽���ڵĶ��� ��������ֵ�һ�ſ��ƾ�Ϊ����" };
	private static Scanner input = new Scanner(System.in);

	public static int getPlayerNumber() {
		return getAndCheck("�������������(2-4):", 2, 4);
	}

	public static Collection<String> getPlayerName(int number) {
		Deque<String> players = new LinkedList<String>();
		for (int i = 0; i < number; i++) {
			String name = getAndCheck("���������" + (i + 1) + "����(���֡���ĸ���»���):",
					"^\\w+$");
			players.add(name);
		}
		return players;
	}

	public static void getReady() throws IOException {
		System.out.println("׼���ú��밴�س�����ʼ��Ϸ");
		input.nextLine();
		System.out.println("==============��  Ϸ  ��  ʼ==============");
		System.out.println("����Ϊ��ҳ�ʼ������Ϣ��");
	}

	public static int getMenuChoice() {
		for (int i = 0; i < MAINMENU.length; i++) {
			System.out.println(MAINMENU[i]);
		}
		int choice = getAndCheck("���������ֱ�ʾѡ��", 0, MAINMENU.length - 1);
		return choice;
	}

	public static int getProp(ArrayList<String> strs) {
		if (strs.size() < 1) {
			System.out.println("�޵���");
			return -1;
		}
		for (int i = 0; i < strs.size(); i++) {
			System.out.printf("%d-%s  ", i, strs.get(i));
			if (i % 5 == 4)
				System.out.println();
		}
		System.out.println();
		// String reg = "^[0-" + (strs.size() - 1) + "xXhH]$";
		String rs;
		while ((rs = getAndCheck("����������Ҫ�Ŀ�Ƭ���(����h��ð���������x������һ��)", 0,
				strs.size() - 1, "x", "h")).equals("h")) {
			for (String str : propHelp)
				System.out.println(str);
			System.out.println();
		}
		if (rs.equals("x")) {
			return -1;
		} else {
			return Integer.parseInt(rs);
		}
	}

	public static int getBuyProp() {
		for (int i = 0; i < Prop.values().length; i++) {
			System.out.printf("%d-%s  %s\n", i, Prop.values()[i].toText(),
					Prop.values()[i].getPrice() + "��ȯ");
		}
		System.out.println();
		// String reg = "^[0-" + (Prop.values().length - 1) + "xX]$";
		String rs;
		while ((rs = getAndCheck("����������Ҫ�Ŀ�Ƭ���(����h��ð���������x������һ��)", 0,
				Prop.values().length - 1, "x", "h")).equals("h")) {
			for (String str : propHelp)
				System.out.println(str);
			System.out.println();
		}
		if (rs.equals("x")) {
			return -1;
		} else if (rs.equals("h")) {
			return -2;
		} else {
			return Integer.parseInt(rs);
		}
	}

	public static int getSaveOrDrawMoney() {
		String choiceStr = getAndCheck("x-�˳�	1-ȡǮ	2-��Ǯ\n��ѡ��:", 1, 2, "x");
		if (choiceStr.equals("x"))
			return 0;
		int choice = Integer.parseInt(choiceStr);
		int saveMoney = getAndCheck("��������Ҫ��/ȡ����Ŀ:", 0, Integer.MAX_VALUE);
		if (choice == 1)
			saveMoney = -saveMoney;
		return saveMoney;
	}

	public static int getChoosePlayer(LinkedList<String> l) {
		if (l.size() == 0) {
			System.out.println("��Ŀ��");
			return 0;
		}
		int[] index = { 0 };
		l.stream().forEach(i -> {
			System.out.printf("%d-%s\n", (index[0]++), i);
		});
		return getDistanceChoice("��������ұ��(x-ȡ��)", 0, l.size() - 1);
	}

	public static boolean getYesOrNo(Const houseLevelupOrNot) {
		return getAndCheck(houseLevelupOrNot + "(0-ȡ��	1-ȷ��)", 0, 1) == 1;
		// return Integer.parseInt(getAndCheck(str + "(0-ȡ��	1-ȷ��)", "^[0-1]$"))
		// == 1;
	}

	public static int getDistanceChoice(String str, int lb, int ub) {
		String rs = getAndCheck(str, lb, ub, "x");
		if (rs.equals("x"))
			return ub + 1;
		return Integer.parseInt(rs);
	}

	public static int getDice() {
		String dice = getAndCheck("������Ͷ���ĵ���(x-ȡ��):", 1, 6, "x");
		if (dice.equals("x"))
			return 7;
		return Integer.parseInt(dice);
	}

	public static int[] getStock(int[] amount) {
		System.out.print(Tools.stringCover(16, "Order Number"));
		System.out.println(Tools.stringCover(16, "Name", "Price",
				"Rise and Fall", "Holds"));
		// System.out.println("���\t��Ʊ��\t\t����\t\t�ǵ���\t\t������");
		for (int i = 0; i < Stock.values().length; i++) {
			System.out.println(Tools.stringCover(16, String.valueOf(i),
					Stock.values()[i].getDescription(),
					String.valueOf(amount[i])));
		}
		System.out.println("�밴���¸�ʽ���룺");
		System.out
				.println("����b x n��ʾ�������Ϊx�Ĺ�Ʊn��,s x n��ʾ�������Ϊx�Ĺ�Ʊ�Ĺ�Ʊ n��,ֱ������x-�˳�");
		while (true) {
			String inputStr = input.nextLine();
			String[] strs = inputStr.split(" +");
			int[] data = { -1, 0, 0 };
			if (strs[0].equals("x"))
				return data;
			if (strs.length != 3) {
				System.out.println("�������");
				continue;
			}
			// System.out.println(strs.length + strs[0]);
			if (strs[0].equals("s")) {
				data[0] = 1;
			} else if (strs[0].equals("b")) {
				data[0] = 0;
			} else {
				System.out.println("�������");
				continue;
			}
			if (!(checkInteger(strs[1]) && checkInteger(strs[2]))) {
				System.out.println("�������");
				continue;
			}
			data[2] = Integer.parseInt(strs[2]);
			data[1] = Integer.parseInt(strs[1]);
			if (data[1] < 0 || data[1] > amount.length) {
				System.out.println("�������");
				continue;
			}
			return data;
		}
	}

	public static void printString(String str) {
		System.out.println(str);
	}

	public static void printString(Object o) {
		System.out.println(o);
	}

	public static void printStringArray2(String[][] str) {
		for (int y = 0; y < str[y].length; y++) {
			for (int x = 0; x < str.length; x++) {
				System.out.print(str[x][y]);
			}
			System.out.println();
		}
	}

	public static void inputClose() {
		input.close();
	}

	private static int getAndCheck(String message, int lb, int ub) {
		while (true) {
			System.out.println(message);
			String inputStr = input.nextLine();
			if (checkInteger(inputStr)) {
				int rs = Integer.parseInt(inputStr);
				if (rs >= lb && rs <= ub)
					return rs;
			}
			System.out.println("�������");
		}
	}

	private static String getAndCheck(String message, int lb, int up,
			String... strs) {
		while (true) {
			System.out.println(message);
			String inputStr = input.nextLine().toLowerCase();
			for (String str : strs) {
				if (inputStr.equals(str))
					return inputStr;
			}
			if (checkInteger(inputStr)) {
				int rs = Integer.parseInt(inputStr);
				if (rs >= lb && rs <= up)
					return String.valueOf(rs);
			}
			System.out.println("�������");
		}
	}

	private static String getAndCheck(String message, String regular) {
		while (true) {
			System.out.println(message);
			String inputStr = input.nextLine();
			if (check(inputStr, regular)) {
				return inputStr;
			}
			System.out.println("�������," + message);
		}
	}

	private static boolean checkInteger(String input) {
		Pattern pattern = Pattern.compile("^[+-]?[0-9]+$");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	private static boolean check(String inputStr, String regular) {
		Pattern pattern = Pattern.compile(regular);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();
	}
}
