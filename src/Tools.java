import java.io.*;

import bean.place.*;

import com.alibaba.fastjson.*;

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
