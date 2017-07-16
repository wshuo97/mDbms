package mainpart;

import Operation.CheckFile;
import ui.View;

public class Main {

	public static void main(String[] args) {
		new View();
		CheckFile.run("./db");
	}
}
