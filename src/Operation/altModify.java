package Operation;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import mainpart.Constant;

public class altModify {
	public static void run(String str) {
		Workbook tra = null;
		WritableWorkbook book = null;
		WritableSheet sheet = null;
		
		String[] tmp = str.split(" ");
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
		// ui.View.setOut(name + '\n' + tname+"\n");

		int c = 0;
		for (int i = 0; i < sheet.getColumns(); i++) {
			Cell cell = sheet.getCell(i, 0);
			String cnt = cell.getContents().trim();
			if (cnt.equals(tname)) {
				c = i;
				break;
			}
		}

		Label lab = new Label(c, 1, tmp[5].trim());
		try {
			sheet.addCell(lab);
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
