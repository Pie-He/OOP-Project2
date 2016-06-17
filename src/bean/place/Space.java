package bean.place;

import controller.EventSession;
import bean.PlaceEnum;

public class Space extends Place {

	public Space() {
		super(PlaceEnum.SPACE.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		return null;
	}
}
