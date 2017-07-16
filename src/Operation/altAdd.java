package Operation;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import mainpart.Constant;

public class altAdd {
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

		sheet = book.getSheet(name);
		int sheetNum = sheet.getColumns();

		Label lab1 = new Label(sheetNum, 0, tmp[4]);
		Label lab2 = new Label(sheetNum, 1, tmp[5]);

		String cnt = "";
		for (int i = 6; i < tmp.length; i++) {
			cnt += tmp[i] + " ";
		}
		cnt = cnt.trim();
		Label lab3 = new Label(sheetNum, 2, cnt);

		try {
			sheet.addCell(lab1);
			sheet.addCell(lab2);
			sheet.addCell(lab3);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
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
