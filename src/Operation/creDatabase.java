package Operation;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import mainpart.*;

public class creDatabase {
	private static WritableWorkbook book;
	
	public static void run(String str) {
		// ui.View.setOut("12111111111111111111\n");
		String[] tmp = str.split(" ");
		tmp[2] = tmp[2].trim();
		Constant.CUR_DB = tmp[2] + ".xls";
		String filePath = Constant.ROOT_PATH + tmp[2];
		Constant.CUR_PATH = filePath + '/';
		File file = new File(filePath);
		file.mkdir();

		String path = Constant.CUR_PATH + Constant.CUR_DB;
		try {
			book = Workbook.createWorkbook(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String aimName = tmp[2];
		String[] sheets = book.getSheetNames();
		int numOfSheets = sheets.length;
		book.createSheet(aimName, numOfSheets);

		try {
			book.write();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			book.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
