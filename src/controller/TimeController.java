package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.other.Stock;

public class TimeController extends IController {

	private static final TimeController CONTROLLER = new TimeController();

	public static TimeController getInstance() {
		return CONTROLLER;
	}

	final private static SimpleDateFormat SDF = new SimpleDateFormat(
			"yyyy/MM/dd/ EE");
	private Calendar calendar = Calendar.getInstance();

	private TimeController() {
		calendar.set(2016, 0, 4);
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

	public boolean isWeekend() {
		return calendar.get(Calendar.DAY_OF_WEEK) == 1
				|| calendar.get(Calendar.DAY_OF_WEEK) == 7;
	}

	public boolean isMonthLast() {
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		boolean is = false;
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
			is = true;
		}
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return is;
	}

	public boolean isEnd() {
		return calendar.get(Calendar.YEAR) >= 2017;
		//return false;
	}
}
