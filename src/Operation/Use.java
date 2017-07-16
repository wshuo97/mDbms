package Operation;

import mainpart.Constant;

public class Use {
	public static void dbUse(String str) {
		String[] cnt = str.split(" ");
		cnt[1] = cnt[1].trim();
		Constant.CUR_PATH = Constant.ROOT_PATH + cnt[1] + "/";
		Constant.CUR_DB = cnt[1] + ".xls";
	}
}
