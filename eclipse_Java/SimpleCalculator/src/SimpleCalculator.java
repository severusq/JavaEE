import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.TitledBorder;

public class SimpleCalculator implements ActionListener, ItemListener {
	static JFrame f = null; //Ҫ��main�б����ã�����Ҫ����Ϊstatic
	ButtonGroup bg; //��ť�飬��������ɵ�ѡ��ť
	JComboBox combo; //����ʽ�б��
	JSpinner s1; //����仯ѡ���
	JLabel L3; //��ʾ�������ı�ǩ
	JRadioButton r1, r2, r3, r4; //��ѡ��ť
	int op = 0;
	public SimpleCalculator() {
		f = new JFrame("�ڶ���ԭ�������ʾ"); //�½�һ������
		Container contentPane = f.getContentPane();
		JPanel p1 = new JPanel(); //�½�һ��Panel
		p1.setLayout(new GridLayout(1, 4));
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 2),
				"ѡ����������", TitledBorder.CENTER, TitledBorder.TOP)); //���ñ߿�
		r1 = new JRadioButton("+"); //��ѡ��ť
		r2 = new JRadioButton("-");
		r3 = new JRadioButton("*");
		r4 = new JRadioButton("/");
		p1.add(r1);
		p1.add(r2);
		p1.add(r3);
		p1.add(r4);
		bg = new ButtonGroup(); //����ĸ���ѡ��ť��һ��ֻ��ѡһ��
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
		r4.addItemListener(this);
		
		JPanel p2 = new JPanel(); //�½��ڶ���Panel
		p2.setLayout(new GridLayout(2, 3));
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 2),
				"ѡ������������", TitledBorder.CENTER, TitledBorder.TOP));
		JLabel L1 = new JLabel("��һ��������");
		JLabel L2 = new JLabel("�ڶ���������");
		String[] data1 = {"0", "10", "20","30","40","50","60","70","80","90","100"};
		combo = new JComboBox(data1); //����ʽ�б��
		combo.setEditable(true);
		ComboBoxEditor editor = combo.getEditor();
		combo.configureEditor(editor, "��ѡ���ֱ����������");
		
		SpinnerModel sM1 = new SpinnerNumberModel(50, 0, 100, 1);
		
		s1 = new JSpinner(sM1); //����仯ѡ���
		
		p2.add(L1);
		p2.add(combo);
		p2.add(L2);
		p2.add(s1);
		JPanel p3 = new JPanel(); //�����µ�Panel
		p3.setLayout(new GridLayout(1, 2));
		JButton button1 = new JButton("����");
		L3 = new JLabel("", SwingConstants.CENTER);
		p3.add(button1);
		p3.add(L3);
		button1.addActionListener(this);
		
		contentPane.add(p1, BorderLayout.NORTH); //������Panel�������������
		contentPane.add(p2, BorderLayout.CENTER);
		contentPane.add(p3, BorderLayout.SOUTH);
		
		f.getRootPane().setDefaultButton(button1); //���ô���س���Ӧ��ť
		f.pack(); //�Ű�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
	}
	public void itemStateChanged(ItemEvent e) { //��ѡť������ʱ����
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
	public void actionPerformed(ActionEvent e) { //���㱻����ʱ����
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
			L3.setText("��ѡ�������");
		}
	}
	public static void main(String args[]) {
		new SimpleCalculator();
		new PassWord(f); //�½���������Ի���
	}
}
class PassWord implements ActionListener { //��������Ի���
	JTextField user;
	JPasswordField passWd;
	JButton b1, b2;
	Container dialogPane;
	JDialog d;
	JFrame f;
	public PassWord(JFrame f) {
		d = new JDialog(); //�½��Ի���
		d.setTitle("�������û���������"); //���ñ���
		dialogPane = d.getContentPane();
		dialogPane.setLayout(new GridLayout(3, 2));
		dialogPane.add(new JLabel("�û���", SwingConstants.CENTER));
		user = new JTextField();
		dialogPane.add(user);
		dialogPane.add(new JLabel("����", SwingConstants.CENTER));
		passWd = new JPasswordField();
		dialogPane.add(passWd);
		b1 = new JButton("ȷ��");
		b2 = new JButton("�˳�");
		dialogPane.add(b1);
		dialogPane.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		d.setBounds(200, 150, 400, 130); //�趨��С
		d.getRootPane().setDefaultButton(b1); //�趨�س���Ӧ��ť
		d.setVisible(true);
		this.f = f;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("ȷ��")) {
			String name = user.getText();
			char[] c = passWd.getPassword();
			String passWord = new String(c);
			if((name.equals("test")) && (passWord.equals("1234"))) { //�û�����������ȷ
				d.dispose(); //�رնԻ�����
				f.setVisible(true); //��ʾ������
				return;
			}
			else { //�������������룬���ִ�����Ϣ�Ի���
				JOptionPane.showMessageDialog(d,  "������û���������");
				user.setText("");
				passWd.setText("");
			}
		}
		if (cmd.equals("�˳�")) {
			System.exit(0);
		}
	}
}
