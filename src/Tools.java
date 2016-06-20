import java.io.*;
import bean.place.*;

import com.alibaba.fastjson.*;
//手动写入地图信息
public class Tools {

	public static void main(String[] args) throws IOException {
		writeMap();
	}

	public static void writeMap() throws IOException {
		Place[] places = new Place[42];
		places[0] = new Hospital();
		for (int i = 1; i <= 5; i++) {
			places[i] = new House(1000, "Lancer" + i);
			/*
			 * places[i].type.street = "Lancer"; places[i].type.name =
			 * places[i].type.street + i; places[i].type.setInit(1000);
			 */
		}
		for (int i = 7; i <= 11; i++) {
			places[i] = new House(1500, "Assassin" + (i - 6));
			/*
			 * places[i].type.street = "Assassin"; places[i].type.name =
			 * places[i].type.street + (i - 6); places[i].type.setInit(1500);
			 */

		}
		for (int i = 13; i <= 14; i++) {
			places[i] = new House(3000, "Berserker" + (i - 12));
			/*
			 * places[i].type.street = "Berserker"; places[i].type.name =
			 * places[i].type.street + (i - 12); places[i].type.setInit(3000);
			 */
		}
		for (int i = 16; i <= 18; i++) {
			places[i] = new House(3000, "Berserker" + (i - 13));
			/*
			 * places[i].type.street = "Berserker"; places[i].type.name =
			 * places[i].type.street ; places[i].type.setInit();
			 */
		}
		for (int i = 20; i <= 24; i++) {
			places[i] = new House(2000, "Caster" + (i - 19));
			/*
			 * places[i].type.street = ; places[i].type.name =
			 * places[i].type.street; places[i].type.setInit(2000);
			 */
		}
		for (int i = 26; i <= 30; i++) {
			places[i] = new House(2500, "Avenger" + (i - 25));
			/*
			 * places[i].type.street = ; places[i].type.name =
			 * places[i].type.street ; places[i].type.setInit(2500);
			 */
		}
		places[0] = new Hospital();
		places[6] = new Shop();
		places[25] = new Space();
		places[12] = new News();
		places[15] = new Bank();
		places[19] = new CardPrize();
		places[34] = new Lottery();
		places[37] = new Bank();
		for (int i = 31; i <= 33; i++) {
			places[i] = new Coupon();
			places[35] = new Coupon();
			places[36] = new Coupon();
		}
		for (int i = 38; i <= 41; i++) {
			places[i] = new Coupon();
		}

		// 初始化土地
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
