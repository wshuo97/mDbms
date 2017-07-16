package Operation;

import java.io.File;
import mainpart.Constant;

public class CheckFile {
	public static void run(String filepath) {
		File file = new File(filepath);
		
		ui.View.setOut("**********************************************************\n");
		ui.View.setOut("The Author of this Dbms is 王硕(物联网工程一班 201501061321)\n");
		ui.View.setOut("**********************************************************\n");
		
		if (!file.exists()) {
			creDatabase.run("create database db");
		} else {
			Constant.CUR_DB = "db" + ".xls";
			String filePath = Constant.ROOT_PATH + "db";
			Constant.CUR_PATH = filePath + '/';
		}
	}
}
