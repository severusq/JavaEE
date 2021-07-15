import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream f = new FileOutputStream("D:/test.zip"); //创建一个zip文件
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(f)); //向zip文件中写入压缩文件的准备
		for (int i = 0; i < args.length; i++)
		{
			System.out.println("Writing file " + args[i]);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[i])); //打开要压缩的文件
			out.putNextEntry(new ZipEntry(args[i])); //每一个文件都是一个入口，解压缩也是靠入口识别文件分隔
			
			int c;
			while ((c = in.read()) != -1) { //写入压缩文件
				out.write(c);
			}
			in.close();
		}
		out.close();
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream("D:/test.zip");
		ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(fi)); //解压缩，包装在zip的输入输出中就可以
		ZipEntry ze;
		while ((ze = in2.getNextEntry()) != null) { //复原每个文件
			System.out.println("Reading file " + ze.getName()); //显示文件原本的名称
			int x;
			while ((x = in2.read()) != -1) { //输出至屏幕
				System.out.write(x);
			}
			System.out.println();
		}
		in2.close();
	}
}
