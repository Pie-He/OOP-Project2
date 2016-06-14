package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import bean.PlaceEnum;
import bean.place.Place;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MapDao {

	public List<Place> getMapData() {
		List<Place> places = new LinkedList<Place>();
		File file = new File("places.txt");
		String str;
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((str = br.readLine()) != null) {
					JSONObject jo = JSON.parseObject(str);
					//System.out.println(jo);
					Place place = getRealInstance(jo);
					places.add(place);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return places;
	}

	public Place getRealInstance(JSONObject jo) {
		int type = Integer.parseInt(jo.get("type").toString());
		return JSON.toJavaObject(jo, PlaceEnum.values()[type].getRealClass());
	}

}
