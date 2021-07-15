import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream f = new FileOutputStream("D:/test.zip"); //����һ��zip�ļ�
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(f)); //��zip�ļ���д��ѹ���ļ���׼��
		for (int i = 0; i < args.length; i++)
		{
			System.out.println("Writing file " + args[i]);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[i])); //��Ҫѹ�����ļ�
			out.putNextEntry(new ZipEntry(args[i])); //ÿһ���ļ�����һ����ڣ���ѹ��Ҳ�ǿ����ʶ���ļ��ָ�
			
			int c;
			while ((c = in.read()) != -1) { //д��ѹ���ļ�
				out.write(c);
			}
			in.close();
		}
		out.close();
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream("D:/test.zip");
		ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(fi)); //��ѹ������װ��zip����������оͿ���
		ZipEntry ze;
		while ((ze = in2.getNextEntry()) != null) { //��ԭÿ���ļ�
			System.out.println("Reading file " + ze.getName()); //��ʾ�ļ�ԭ��������
			int x;
			while ((x = in2.read()) != -1) { //�������Ļ
				System.out.write(x);
			}
			System.out.println();
		}
		in2.close();
	}
}
