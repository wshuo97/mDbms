package Operation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mainpart.*;

public class creView {
	// ¥¥Ω® ”Õº
	public static void run(String str) {
		String[] tmp = str.split(" ");
		tmp[2] = tmp[2].trim();
		String textPath = Constant.CUR_PATH + tmp[2] + ".txt";
		File file = new File(textPath);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String content = "", cat = "";
		int index = 4;
		for (; index < tmp.length; index++) {
			tmp[index] = tmp[index].trim();
			if (tmp[index].equals("from"))
				break;
			if (tmp[index].charAt(tmp[index].length() - 1) == ',')
				tmp[index] = tmp[index].substring(0, tmp[index].length() - 1);
			content += (" " + tmp[index]);
		}
		cat = tmp[index + 1].trim() + content;
		try {
			out.write(cat);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
