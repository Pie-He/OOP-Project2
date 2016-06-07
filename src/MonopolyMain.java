import java.io.IOException;

import bean.Manager;

public class MonopolyMain {

	public static void main(String[] args) throws IOException {
		Manager.getInstance().start();
	}
}
