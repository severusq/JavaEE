import java.io.*;

class Employee {
	char name[] = {'\u0000', '\u0000', '\u0000', '\u0000',
			'\u0000', '\u0000', '\u0000', '\u0000'}; //��ʼ��λ8���ո�16�ֽ�
	int age; //4���ֽڣ�����һ������20B��20�ֽ�
	public Employee(String name, int age) throws Exception {
		if(name.toCharArray().length > 8) { //������ֳ��ȴ���8��ֻȡǰ8���ַ�
			System.arraycopy(name.toCharArray(), 0, this.name, 0, 8); //���ƺ���
		}
		else { //�����м������
			System.arraycopy(name.toCharArray(), 0, this.name, 0, name.toCharArray().length);
		}
		this.age = age;
	}
}
public class RandomAccessFileTester { //��������ļ���ȡ����
	String filename;
	public RandomAccessFileTester(String filename) {
		this.filename = filename;
	}
	public void writeEmployee(Employee e, int n) throws Exception {
		RandomAccessFile ra = new RandomAccessFile(filename, "rw"); //�����д�ķ�ʽ����
		ra.seek(n*20); //��λ����n����¼��λ��
		for(int i = 0; i < 8; i++) {
			ra.writeChar(e.name[i]); //���ֽ�д�뵽�ļ���
		}
		ra.writeInt(e.age); //������д�뵽�ļ���
		ra.close();
	}
	public void readEmployee(int n) throws Exception { //��ȡ��¼
		char buf[] = new char[8];
		RandomAccessFile ra = new RandomAccessFile(filename, "r"); //��ֻ����
		ra.seek(n*20); //��λλ��
		for(int i = 0; i < 8; i++) {
			buf[i] = ra.readChar(); //��ȡ�ֽڸ�buf
		}
		System.out.print("name:");
		System.out.println(buf);
		System.out.println("age:"+ra.readInt());
		ra.close();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RandomAccessFileTester t = new RandomAccessFileTester("1.txt");
		Employee e1 = new Employee("ZhangSantt", 23);
		Employee e2 = new Employee("little one", 44);
		t.writeEmployee(e1, 0); //���浽��1����¼��λ��
		t.writeEmployee(e2, 2); //���浽��3����¼��λ��
		t.readEmployee(0);
		t.readEmployee(1); //���Ե�2����¼Ϊ��
		t.readEmployee(2);
	}

}
