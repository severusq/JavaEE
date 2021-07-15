import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.TitledBorder;

public class SimpleCalculator implements ActionListener, ItemListener {
	static JFrame f = null; //要在main中被引用，所以要设置为static
	ButtonGroup bg; //按钮组，可组合若干单选按钮
	JComboBox combo; //下拉式列表框
	JSpinner s1; //有序变化选择框
	JLabel L3; //显示计算结果的标签
	JRadioButton r1, r2, r3, r4; //单选按钮
	int op = 0;
	public SimpleCalculator() {
		f = new JFrame("第二类原子组件演示"); //新建一个窗体
		Container contentPane = f.getContentPane();
		JPanel p1 = new JPanel(); //新建一个Panel
		p1.setLayout(new GridLayout(1, 4));
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 2),
				"选择运算种类", TitledBorder.CENTER, TitledBorder.TOP)); //设置边框
		r1 = new JRadioButton("+"); //单选按钮
		r2 = new JRadioButton("-");
		r3 = new JRadioButton("*");
		r4 = new JRadioButton("/");
		p1.add(r1);
		p1.add(r2);
		p1.add(r3);
		p1.add(r4);
		bg = new ButtonGroup(); //组合四个单选按钮，一个只能选一个
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
		r4.addItemListener(this);
		
		JPanel p2 = new JPanel(); //新建第二个Panel
		p2.setLayout(new GridLayout(2, 3));
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 2),
				"选择或输入操作数", TitledBorder.CENTER, TitledBorder.TOP));
		JLabel L1 = new JLabel("第一个操作数");
		JLabel L2 = new JLabel("第二个操作数");
		String[] data1 = {"0", "10", "20","30","40","50","60","70","80","90","100"};
		combo = new JComboBox(data1); //下拉式列表框
		combo.setEditable(true);
		ComboBoxEditor editor = combo.getEditor();
		combo.configureEditor(editor, "请选择或直接输入数字");
		
		SpinnerModel sM1 = new SpinnerNumberModel(50, 0, 100, 1);
		
		s1 = new JSpinner(sM1); //有序变化选择框
		
		p2.add(L1);
		p2.add(combo);
		p2.add(L2);
		p2.add(s1);
		JPanel p3 = new JPanel(); //创建新的Panel
		p3.setLayout(new GridLayout(1, 2));
		JButton button1 = new JButton("计算");
		L3 = new JLabel("", SwingConstants.CENTER);
		p3.add(button1);
		p3.add(L3);
		button1.addActionListener(this);
		
		contentPane.add(p1, BorderLayout.NORTH); //把三个Panel加在内容面板上
		contentPane.add(p2, BorderLayout.CENTER);
		contentPane.add(p3, BorderLayout.SOUTH);
		
		f.getRootPane().setDefaultButton(button1); //设置窗体回车对应按钮
		f.pack(); //排版
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
	}
	public void itemStateChanged(ItemEvent e) { //单选钮被单击时触发
		if (e.getSource() == r1) {
			op = 1;
		}
		if (e.getSource() == r2) {
			op = 2;
		}
		if (e.getSource() == r3) {
			op = 3;
		}
		if (e.getSource() == r4) {
			op = 4;
		}
	}
	public void actionPerformed(ActionEvent e) { //计算被单击时触发
		double a = Double.parseDouble(combo.getSelectedItem().toString());
		double b = Double.parseDouble(s1.getValue().toString());
		double c;
		switch (op) {
		case 1:
			c = a + b;
			L3.setText(""+c);
			break;
		case 2:
			c = a - b;
			L3.setText(""+c);
			break;
		case 3:
			c = a * b;
			L3.setText(""+c);
			break;
		case 4:
			c = a / b;
			L3.setText(""+c);
			break;
		default:
			L3.setText("请选择运算符");
		}
	}
	public static void main(String args[]) {
		new SimpleCalculator();
		new PassWord(f); //新建密码输入对话框
	}
}
class PassWord implements ActionListener { //输入密码对话框
	JTextField user;
	JPasswordField passWd;
	JButton b1, b2;
	Container dialogPane;
	JDialog d;
	JFrame f;
	public PassWord(JFrame f) {
		d = new JDialog(); //新建对话框
		d.setTitle("请输入用户名和密码"); //设置标题
		dialogPane = d.getContentPane();
		dialogPane.setLayout(new GridLayout(3, 2));
		dialogPane.add(new JLabel("用户名", SwingConstants.CENTER));
		user = new JTextField();
		dialogPane.add(user);
		dialogPane.add(new JLabel("密码", SwingConstants.CENTER));
		passWd = new JPasswordField();
		dialogPane.add(passWd);
		b1 = new JButton("确定");
		b2 = new JButton("退出");
		dialogPane.add(b1);
		dialogPane.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		d.setBounds(200, 150, 400, 130); //设定大小
		d.getRootPane().setDefaultButton(b1); //设定回车对应按钮
		d.setVisible(true);
		this.f = f;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("确定")) {
			String name = user.getText();
			char[] c = passWd.getPassword();
			String passWord = new String(c);
			if((name.equals("test")) && (passWord.equals("1234"))) { //用户名和密码正确
				d.dispose(); //关闭对话窗体
				f.setVisible(true); //显示主窗体
				return;
			}
			else { //输入错误，清空输入，出现错误信息对话框
				JOptionPane.showMessageDialog(d,  "错误的用户名或密码");
				user.setText("");
				passWd.setText("");
			}
		}
		if (cmd.equals("退出")) {
			System.exit(0);
		}
	}
}
