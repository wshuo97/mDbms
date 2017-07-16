package ui;

import java.awt.Font;

import mainpart.Init;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View extends JFrame {
	/**
	 * 实现窗口化
	 */
	private static final long serialVersionUID = -30969714760891598L;
	private JFrame frame; // 主窗口
	private JButton submit; // 提交按钮
	private JButton remove; // 删除按钮
	private JTextArea input; // 输入框
	private static JTextArea output; // 输出框

	public View() {
		initwin();
	}

	// 输出框逐行添加
	public static void setOut(String s) {
		output.append(s);
		output.setCaretPosition(output.getDocument().getLength());
	}

	// 窗口初始化
	private void initwin() {
		frame = new JFrame();
		submit = new JButton("input");
		remove = new JButton("clear");
		input = new JTextArea();
		output = new JTextArea();

		// 主窗口
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 900);
		frame.getContentPane().setLayout(null);
		frame.setTitle("myDbms");
		frame.setLocationRelativeTo(null);
		// JPanel panel = new JPanel();
		// panel.setLayout(new GridLayout());
		// frame.add(panel);

		// 提交按钮
		submit.setBounds(300, 120, 100, 50);
		submit.addActionListener(new listensubmit());
		frame.add(submit);

		// 删除按钮
		remove.setBounds(800, 120, 100, 50);
		remove.addActionListener(new listenremove());
		frame.add(remove);

		// 输出框
		output.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 24));
		// int len = output.getText().length();
		// output.setCaretPosition(len);
		JScrollPane jsp2 = new JScrollPane(output);
		jsp2.setAutoscrolls(true);
		jsp2.setBounds(100, 200, 1000, 600);
		// Point p = new Point();
		// p.setLocation(100, output.getLineCount() * 100);
		// jsp2.getViewport().setViewPosition(p);
		frame.add(jsp2);

		// 输入框
		input.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 17));
		
		// 输入框Enter键监听
		input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String sql = input.getText();
					sql = sql.trim();
					if (sql.isEmpty())
						return;
					if (sql.charAt(sql.length() - 1) != ';') {
						Init.handleSql(sql);
						input.setText("");
					}
				}
			}
		});
		
		JScrollPane jsp1 = new JScrollPane(input);
		jsp1.setAutoscrolls(true);
		jsp1.setBounds(100, 50, 1000, 50);

		frame.add(jsp1);

		// 显示窗口
		frame.setVisible(true);
	}

	// 监听按钮事件
	// 提交
	private class listensubmit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String sql = input.getText();
			if (!sql.equals("")) {
				Init.handleSql(sql);
				input.setText("");
			}
		}
	}

	// 删除
	private class listenremove implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			input.setText("");
			output.setText("");
		}
	}

}
