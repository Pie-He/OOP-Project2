package bean.place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.EventSession;
import bean.PlaceEnum;
import bean.item.Player;

public class Hospital extends Place {
	private Map<Player, Integer> patientList = new HashMap<Player, Integer>();

	public Hospital() {
		super(PlaceEnum.HOSPITAL.ordinal());
		patientList = new HashMap<Player, Integer>();
	}

	@Override
	public EventSession event(EventSession session) {
		Player player = (Player) session.get("player");
		System.out.println(player);
		EventSession response = new EventSession();
		System.out.println(patientList.containsKey(player));
		System.out.println("[event]"+patientList.get(player));
		System.out.println("[event size]"+patientList.size());
		System.out.println(patientList);
		if (patientList.containsKey(player)) {
			response.put("message", relax(player));
		}

		return response;
	}

	private String relax(Player player) {
		int days = patientList.get(player);
		String message = player.getName() + "住院中," + days + "天后出院";
		days--;
		if (days <= 0) {
			patientList.remove(player);
		} else {
			patientList.put(player, days);
		}
		return message;
	}

	public void addPatient(Player player, int days) {
		//System.out.println(player + " " + days);
		patientList.put(player, days);
		//System.out.println("is " + patientList.containsKey(player));
		// player.setStopRound(days);
	}
}
