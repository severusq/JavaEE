import java.io.*;

class Book implements Serializable { //ʵ����serializable�ӿڲſ���ʹ�ö������������
	int id;
	String name;
	String author;
	float price;
	transient int borrowid; //����Ͷ�������ʱ�����������д���
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

	public static void main(String[] args) throws IOException, ClassNotFoundException { //û���쳣����ᱨ��
		// TODO Auto-generated method stub
		Book book = new Book(10032, "java", "Wang sir", 40);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
		//ר�����ڶ���洢�������
		oos.writeObject(book); //������д�����
		oos.close(); //�ر������
		book = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat")); //��������������
		book = (Book) ois.readObject(); //�������
		ois.close(); //�ر�������
		System.out.println(book.id+"\t"+book.name+"\t"+book.author+"\t"+book.price); //�Ϳ��Ե�����ͨ����ʹ��
	}

}
