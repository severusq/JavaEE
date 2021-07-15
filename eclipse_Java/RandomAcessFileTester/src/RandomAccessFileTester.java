import java.io.*;

class Employee {
	char name[] = {'\u0000', '\u0000', '\u0000', '\u0000',
			'\u0000', '\u0000', '\u0000', '\u0000'}; //初始化位8个空格，16字节
	int age; //4个字节，所以一个对象20B，20字节
	public Employee(String name, int age) throws Exception {
		if(name.toCharArray().length > 8) { //如果名字长度大于8，只取前8个字符
			System.arraycopy(name.toCharArray(), 0, this.name, 0, 8); //复制函数
		}
		else { //否则有几个填几个
			System.arraycopy(name.toCharArray(), 0, this.name, 0, name.toCharArray().length);
		}
		this.age = age;
	}
}
public class RandomAccessFileTester { //测试随机文件读取的类
	String filename;
	public RandomAccessFileTester(String filename) {
		this.filename = filename;
	}
	public void writeEmployee(Employee e, int n) throws Exception {
		RandomAccessFile ra = new RandomAccessFile(filename, "rw"); //随机读写的方式打开流
		ra.seek(n*20); //定位到第n条记录的位置
		for(int i = 0; i < 8; i++) {
			ra.writeChar(e.name[i]); //按字节写入到文件中
		}
		ra.writeInt(e.age); //将年龄写入到文件中
		ra.close();
	}
	public void readEmployee(int n) throws Exception { //读取记录
		char buf[] = new char[8];
		RandomAccessFile ra = new RandomAccessFile(filename, "r"); //打开只读流
		ra.seek(n*20); //定位位置
		for(int i = 0; i < 8; i++) {
			buf[i] = ra.readChar(); //读取字节给buf
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
		t.writeEmployee(e1, 0); //保存到第1条记录的位置
		t.writeEmployee(e2, 2); //保存到第3条记录的位置
		t.readEmployee(0);
		t.readEmployee(1); //所以第2条记录为空
		t.readEmployee(2);
	}

}
