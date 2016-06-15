package bean.place;

import controller.EventSession;
import bean.PlaceEnum;

public class Hospital extends Place {
	public Hospital() {
		super(PlaceEnum.HOSPITAL.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		// TODO Auto-generated method stub
		return null;
	}
}
