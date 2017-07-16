package Operation;

import mainpart.*;

public class conHistory {
	public static void update(String str) {
		Constant.history += str;
	}

	public static void display() {
		ui.View.setOut("~~~~~~~~~~~~~~~~~~~~~~\n");
		ui.View.setOut(Constant.history);
		ui.View.setOut("~~~~~~~~~~~~~~~~~~~~~~\n");
	}
}
