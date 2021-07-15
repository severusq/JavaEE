import java.io.*;

class Book implements Serializable { //实现了serializable接口才可以使用对象输入输出流
	int id;
	String name;
	String author;
	float price;
	transient int borrowid; //保存和读出对象时都不会对其进行处理
	public Book(int id, String name, String author, float price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public void borrowbook(int id) {
		this.borrowid = id;
	}
}
public class SerializableTester {

	public static void main(String[] args) throws IOException, ClassNotFoundException { //没有异常处理会报错
		// TODO Auto-generated method stub
		Book book = new Book(10032, "java", "Wang sir", 40);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
		//专门用于对象存储的输出流
		oos.writeObject(book); //向流中写入对象
		oos.close(); //关闭输出流
		book = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat")); //创建对象输入流
		book = (Book) ois.readObject(); //读入对象
		ois.close(); //关闭输入流
		System.out.println(book.id+"\t"+book.name+"\t"+book.author+"\t"+book.price); //就可以当成普通对象使用
	}

}
