import java.io.*;

public class FileTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "D:/data1.dat"; //可以用/或\\来表示路径
		DataOutputStream out; //字节输出对象
		int sum = 0;
		int value0 = 255, value1 = -1;
		try {
			out = new DataOutputStream(new FileOutputStream(fileName)); //打开二进制文件，有就先删除
			out.writeInt(value0); //DataOutputStream和FileOuptStream结合可以写入多种数据，下同
			out.writeInt(value1); //写入int数据，4个字节
			out.close(); //关闭文件
		}
		catch (IOException iox) {
			System.out.println("Problem writing " + fileName);
		}
		try {
			DataInputStream instr = new DataInputStream( //以只读方式打开一个文件
									new BufferedInputStream(new FileInputStream(fileName)));
			try {
				while (true) {
					sum += instr.readInt(); //读取4个字节并当做是int型
				}
			}
			catch (EOFException eof) { //到了末尾还要读取就产生EOF异常
				System.out.println("The sum is: " + sum);
				instr.close(); //关闭文件，和c++不同，不会结束文件
			}
		}
		catch (IOException iox) { //嵌套try语句可以捕捉上个catch的close异常
			System.out.println("IO problem with " + fileName);
		}
		try {
			out = new DataOutputStream(new FileOutputStream(fileName)); //重新打开文件，清空
			out.writeByte(-1); //写入一个字节
			out.close();
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			int a = in.readByte(); //读取一个字节，高24位都会补1
			System.out.println(Integer.toHexString(a)); //所以是ffffffff
			System.out.println(a); //结果还是-1
			in.skip(-1); //向后一个位置
			a = in.readUnsignedByte(); //但是抛出了异常不知道为什么
			System.out.println(Integer.toHexString(a)); //理论上是ff因为readUnsignedByte将高24位补0
			System.out.println(a); //a=255
			in.close();
		}
		catch (IOException iox) {
			System.out.println("Problem3 with " + fileName);
		}
		File f = new File("D:" + File.separator + "Hello.txt"); //File类，有很多API
		if(f.exists()) { //如果文件存在
			f.delete(); //删除这个文件
			System.out.println("File exits, delete it");
		}
		else {
			System.out.println("File not exits, create it");
			try {
				f.createNewFile(); //创建一个新文件
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
