package bean.place;

import controller.Session;
import bean.PlaceEnum;

public class Space extends Place {

	public Space() {
		super(PlaceEnum.SPACE.ordinal());
	}

	@Override
	public Session event(Session session) {
		return null;
	}
}
