package mainpart;

import java.util.Vector;

import Operation.Help;
import Operation.Use;
import Operation.altAdd;
import Operation.altDrop;
import Operation.altModify;
import Operation.conHistory;
import Operation.creDatabase;
import Operation.creTable;
import Operation.creView;
import Operation.showTables;

public class Init {
	public static void handleSql(String sql) {
		
		sql = sql.replaceAll("[\\n\\r\\t ]+ ", " ").trim().toLowerCase();
		String[] cnt = sql.split(";");
		
		Vector<String> que = new Vector<>();
		for (int i = 0; i < cnt.length; i++) {
			cnt[i] = cnt[i].trim();
			if (cnt[i].isEmpty())
				continue;
			que.add(cnt[i]);
			Constant.kas++;
			String tmp = String.valueOf(Constant.kas);
			conHistory.update(tmp + ": " + cnt[i] + "\n");
		}
		cnt = null;
		for (int i = 0; i < que.size(); i++) {
			String str = que.get(i).trim();
			String[] cmd = str.split(" ");
			for (int j = 0; j < cmd.length; j++)
				cmd[j] = cmd[j].trim();
			if (cmd[0].equals("create")) {
				if (cmd[1].equals("table")) {
					creTable.run(str);
					ui.View.setOut("Create table successful!\n");
				} else if (cmd[1].equals("database")) {
					creDatabase.run(str);
					ui.View.setOut("Create database successful!\n");
				} else if (cmd[1].equals("view")) {
					creView.run(str);
					ui.View.setOut("Create view successful\n");
				} else {
					ui.View.setOut("ERROR INPUT!!\n");
				}
			} else if (cmd[0].equals("alter")) {
				if (cmd[3].equals("add")) {
					altAdd.run(str);
					ui.View.setOut("Add successful\n");
				} else if (cmd[3].equals("drop")) {
					altDrop.run(str);
					ui.View.setOut("Drop successful\n");
				} else if (cmd[3].equals("modify")) {
					altModify.run(str);
					ui.View.setOut("Modify successful\n");
				} else {
					ui.View.setOut("ERROR INPUT!!\n");
				}
			} else if (cmd[0].equals("use")) {
				Use.dbUse(str);
				ui.View.setOut("Database path set successful\n");
			} else if (cmd[0].equals("show")) {
				showTables.run();
				ui.View.setOut("Have shown all tables\n");
			} else if (cmd[0].equals("history")) {
				conHistory.display();
				ui.View.setOut("These are all operations\n");
			} else if (cmd[0].equals("help")) {
				Help.run();
			} else {
				ui.View.setOut("ERROR INPUT!!\n");
			}
		}
	}
}
