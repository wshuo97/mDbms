package Operation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import mainpart.*;

public class creTable {

	public static void run(String str) {
		Workbook tra = null;
		WritableWorkbook book = null;
		WritableSheet sheet = null;
		BufferedWriter out = null;

		String[] tmp = str.split(" ");
		String aimName = tmp[2];
		String path = Constant.CUR_PATH + Constant.CUR_DB;

		try {
			tra = Workbook.getWorkbook(new File(path));
		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}
		try {
			book = Workbook.createWorkbook(new File(path), tra);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		sheet = book.createSheet(aimName, 1);

		int len = tmp.length;
		tmp[3] = tmp[3].substring(1, tmp[3].length());
		tmp[len - 1] = tmp[len - 1].substring(0, tmp[len - 1].length() - 1);

		String cnt = "";
		for (int i = 3; i < len; i++)
			cnt += (tmp[i] + " ");

		cnt = cnt.trim();
		tmp = null;
		tmp = cnt.split(",");

		String lspath = Constant.CUR_PATH + aimName + "sx.txt";
		File file = new File(lspath);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String tag = "";
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i].trim();

			if (tmp[i].indexOf("foreign key") == 0) {

			} else if (tmp[i].indexOf("primary key") == 0) {

			} else if (tmp[i].indexOf("not null") == 0) {

			} else if (tmp[i].indexOf("unique") == 0) {

			} else {
				String[] tem = tmp[i].split(" ");
				if (tem.length < 2)
					continue;
				Label label1 = new Label(i, 0, tem[0]);
				Label label2 = new Label(i, 1, tem[1]);
				try {
					sheet.addCell(label1);
					sheet.addCell(label2);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}

				if (tem.length > 2) {
					String cat = "";
					for (int j = 2; j < tem.length; j++) {
						cat += tem[j];
					}

					Label label3 = new Label(i, 2, cat);
					try {
						sheet.addCell(label3);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}
		}

		try {
			out.write(tag);
			out.flush();
			out.close();
		} catch (IOException e) {
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
