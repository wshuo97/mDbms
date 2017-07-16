package Operation;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import mainpart.*;


public class showTables {
	static Workbook book = null;
	static Sheet sheet = null;

	public static void run() {

		String filepath = Constant.CUR_PATH + Constant.CUR_DB;

		try {
			book = Workbook.getWorkbook(new File(filepath));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int sheetsNum = book.getNumberOfSheets();
		
		if(sheetsNum == 1) {
			ui.View.setOut("+------------------------------------+\n");
			ui.View.setOut("The " + Constant.CUR_DB.substring(0, Constant.CUR_DB.indexOf(".")) + " is empty!\n");
			ui.View.setOut("+------------------------------------+\n");
			return ;
		}
		
		for (int i = 1; i < sheetsNum; i++) {
			sheet = book.getSheet(i);
			showContent();
		}
	}

	public static void showContent() {
		int r = sheet.getRows(), c = sheet.getColumns();
		Vector<Vector<String>> text = new Vector<>();

		int maxLen = 0;
		for (int i = 0; i < r; i++) {
			Vector<String> cnt = new Vector<>();
			for (int j = 0; j < c; j++) {
				Cell cell = sheet.getCell(j, i);
				String tmp = cell.getContents().trim();
				maxLen = Math.max(maxLen, tmp.length());
				cnt.add(tmp);
			}
			text.add(cnt);
		}
		String allData = "",deco = "+";
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				String tmp = text.get(i).get(j).trim();
				int len = tmp.length();
				for(int l = 0; l<maxLen - len; l++)
					tmp += " ";
				tmp += "  ";
				allData += tmp;
			}
			allData += "\n";
		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<maxLen+2; j++) {
				deco += "-";
			}
		}
		deco += "+\n";
		
		ui.View.setOut(deco);
		ui.View.setOut("The tables's name is \""+ sheet.getName().toUpperCase() + "\" :\n");
		ui.View.setOut(allData);
		ui.View.setOut(deco);
	}
}
