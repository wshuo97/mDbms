package Operation;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import mainpart.Constant;

public class altDrop {
	public static void run(String str) {
		Workbook tra = null;
		WritableWorkbook book = null;
		WritableSheet sheet = null;
		
		String[] tmp = str.split(" ");
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i].trim();
		}

		String name = tmp[2].trim();

		String path = Constant.CUR_PATH + Constant.CUR_DB;
		// ui.View.setOut(path+"\n");

		try {
			tra = Workbook.getWorkbook(new File(path));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			book = Workbook.createWorkbook(new File(path), tra);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String tname = tmp[4].trim();
		sheet = book.getSheet(name);

		int sheetNum = sheet.getColumns();
		for (int i = 0; i < sheetNum; i++) {
			Cell cell = sheet.getCell(i, 0);
			String cnt = cell.getContents().trim();
			if (cnt.equals(tname)) {
				sheet.removeColumn(i);
				break;
			}
		}

		try {
			book.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			book.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tra.close();
	}
}
