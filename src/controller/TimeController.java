package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.item.Player;

public class TimeController extends IController {

	private static final TimeController CONTROLLER = new TimeController();

	public static TimeController getInstance() {
		return CONTROLLER;
	}

	final private static SimpleDateFormat SDF = new SimpleDateFormat(
			"yyyy/MM/dd/ EE");
	private Calendar calendar = Calendar.getInstance();

	private TimeController() {

	}

	public String getTime() {
		return SDF.format(calendar.getTime());
	}

	public String nextDay() {
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return SDF.format(calendar.getTime());
	}

	public void fail(Player p) {
		
	}
}
