package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.Stock;
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
		if (!isWeekend())
			Stock.changes();
		return SDF.format(calendar.getTime());
	}

	public void fail(Player p) {

	}

	public boolean isWeekend() {
		return calendar.get(Calendar.DAY_OF_WEEK) == 1
				|| calendar.get(Calendar.DAY_OF_WEEK) == 7;
	}
}
