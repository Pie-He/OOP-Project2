package bean.place;

import controller.Session;

public class Space extends Place {

	public Space() {
		super(PlaceEnum.SPACE.ordinal());
	}

	@Override
	public Session event(Session session) {
		return null;
	}
}
