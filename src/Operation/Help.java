package Operation;

public class Help {
	public static void run() {
		ui.View.setOut("+--------------------------------------------------------------------+\n");
		
		ui.View.setOut("create【创建表、视图、库】 : CREATE TABLE <表名>\n");
		ui.View.setOut("                ([<列名><数据类型>[<列完整性约束条件>]，\n");
		ui.View.setOut("                 [···]，\n");
		ui.View.setOut("                 [表级完整性约束条件]);\n");
		ui.View.setOut("                     CREATE DATABASE <库名>;\n");
		ui.View.setOut("                     CREATE VIEW <视图名> AS SLECT 属性··· FROM <表名>\n");
		ui.View.setOut("alter【增加、删除，修改列操作】 : ALTER TABLE <表名> \n");
		ui.View.setOut("                                [ADD <新列名><数据类型><列完整性约束>];\n");
		ui.View.setOut("                                [DROP <列完整性约束名>];\n");
		ui.View.setOut("                                [MODIFY <列名><数据类型>];\n");
		ui.View.setOut("use【选择使用的库】 : use <库名>; \n");
		ui.View.setOut("show【显示所有表的内容】 : show;\n");
		ui.View.setOut("history【显示历史操作】 : history;\n");
		
		ui.View.setOut("+--------------------------------------------------------------------+\n");
		
	}
}
