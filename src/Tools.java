import java.io.*;
import type.place.*;

import com.alibaba.fastjson.*;

public class Tools {

	public static void main(String[] args) throws IOException {
		writeMap();
	}

	public static void writeMap() throws IOException {
		Place[] places = new Place[68];
		// ��ʼ������
		{
			for (int i = 0; i <= 4; i++) {
				places[i] = new House(2 * i, 0, "��", 500, "����·" + (i + 1));
			}

			for (int i = 6; i <= 7; i++) {
				places[i] = new House(2 * i, 0, "��", 800, "��ɽ·" + (i - 5));
			}
			for (int i = 8; i <= 10; i++) {
				places[i] = new House(2 * i - 2, 2, "��", 800, "��ɽ·" + (i - 5));
			}

			for (int i = 12; i <= 14; i++) {
				places[i] = new House(20, 2 * i - 20, "��", 1500, "�ƶ�·"
						+ (i - 11));
			}

			for (int i = 15; i <= 16; i++) {
				places[i] = new House(2 * i - 8, 8, "��", 1500, "�ƶ�·" + (i - 11));
			}

			for (int i = 18; i <= 22; i++) {
				places[i] = new House(28, -2 * i + 44, "��", 2000, "����·"
						+ (i - 17));
			}

			for (int i = 36; i <= 38; i++) {
				places[i] = new House(32, 2 * i - 60, "��", 1500, "����·"
						+ (i - 35));
			}

			for (int i = 39; i <= 40; i++) {
				places[i] = new House(-2 * i + 108, 16, "��", 1500, "����·"
						+ (i - 35));
			}

			for (int i = 42; i <= 44; i++) {
				places[i] = new House(-2 * i + 112, 12, "��", 1200, "��Ȩ·"
						+ (i - 41));
			}
			places[45] = new House(24, 14, "��", 1200, "��Ȩ·" + 4);
			places[46] = new House(24, 16, "��", 1200, "��Ȩ·" + 5);

			for (int i = 48; i <= 50; i++) {
				places[i] = new House(-2 * i + 118, 18, "��", 2500, "��ͨ·"
						+ (i - 47));
			}
			places[51] = new House(18, 16, "��", 2500, "��ͨ·" + 4);
			places[52] = new House(18, 14, "��", 2500, "��ͨ·" + 5);

			for (int i = 54; i <= 56; i++) {
				places[i] = new House(-2 * i + 124, 12, "��", 2000, "�Ͼ�·"
						+ (i - 53));
			}
			places[57] = new House(12, 10, "��", 2000, "�Ͼ�·" + 4);
			places[58] = new House(10, 10, "��", 2000, "�Ͼ�·" + 5);

			places[60] = new House(6, 10, "��", 800, "�ڷ�·" + 1);
			for (int i = 61; i <= 64; i++) {
				places[i] = new House(4, -2 * i + 132, "��", 800, "�ڷ�·"
						+ (i - 59));
			}

			for (int i = 24; i <= 27; i++) {
				places[i] = new Coupon(2 * i - 16, 0, "ȯ");
			}
			places[28] = new Coupon(38, 2, "ȯ");
			for (int i = 30; i <= 33; i++) {
				places[i] = new Coupon(38, 2 * i - 54, "ȯ");
			}
			places[34] = new Coupon(36, 12, "ȯ");
			places[66] = new Coupon(0, 4, "ȯ");
			places[67] = new Coupon(0, 2, "ȯ");

			places[5] = new Shop(10, 0, "��");
			places[11] = new News(20, 2, "��");
			places[17] = new Bank(26, 8, "��");
			places[23] = new Lottery(30, 0, "��");
			places[29] = new Space(38, 4, "��");
			places[35] = new Space(34, 12, "��");
			places[41] = new Shop(28, 14, "��");
			places[47] = new CardPrize(24, 18, "��");
			places[53] = new News(18, 12, "��");
			places[59] = new Bank(8, 10, "��");
			places[65] = new Lottery(2, 4, "��");
		}
		File file = new File("places.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		if (file.exists()) {
			for (int i = 0; i < places.length; i++) {
				bw.write(JSON.toJSONString(places[i]));
				bw.write("\r\n");
			}
		}
		bw.close();
	}

}
