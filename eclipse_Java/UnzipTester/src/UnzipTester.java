import java.util.*;
import java.util.zip.*;
import java.lang.*;
import java.io.*;

class Unzip { //��ѹ������
	byte doc[] = null; //�洢��ѹ���Ļ����ֽ�����
	String fileName = null;
	String UnzipPath = null;
	public Unzip(String filename, String UnzipPath) { //���캯��
		this.fileName = filename;
		this.UnzipPath = UnzipPath;
		this.setUnzipPath(this.UnzipPath);
	}
	public Unzip(String filename) { //���캯��
		this.fileName = new String(filename);
		this.UnzipPath = null;
		this.setUnzipPath(this.UnzipPath);
	}
	private void setUnzipPath(String unZipPath) { //�趨��ѹ·�������һ��Ҫ��\\
		if (unZipPath.endsWith("\\")) { //String��ĺ���ensWith
			this.UnzipPath = new String(unZipPath);
		}
		else {
			this.UnzipPath = new String(unZipPath + "\\");
		}
	}
	public void doUnzip() { //��ѹ����
		try {
			ZipInputStream zipis = new ZipInputStream(new FileInputStream(fileName));
			ZipEntry fEntry = null; //�������
			while((fEntry = zipis.getNextEntry()) != null) { //����ȡ��һ�����
				if(fEntry.isDirectory()) { //��������Ŀ¼���ʹ���Ŀ¼
					checkFilePath(UnzipPath+fEntry.getName());
				}
				else {
					String fname = new String(UnzipPath + fEntry.getName()); //�����ļ�ԭ�����ļ��������ļ�
					try {
						FileOutputStream out = new FileOutputStream(fname);
						doc = new byte[512];
						int n;
						while ((n = zipis.read(doc, 0, 512)) != -1) { //read��������out��write�Ϳ�����
							out.write(doc, 0, n);
						}
						out.close();
						out = null;
						doc = null;
					}
					catch (Exception ex) {
						
					}
				}
			}
			zipis.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	private void checkFilePath(String dirName) throws IOException {
		File dir = new File(dirName); //�����ļ���
		if(!dir.exists()) { //���Ŀ¼������
			dir.mkdirs(); //����Ŀ¼
		}
	}
}

public class UnzipTester {
	public static void main(String[] args) { //���������е������ѹ��ָ��·��
		String zipFile = args[0];
		String unZipPath = args[1] + "\\";
		Unzip myzip = new Unzip(zipFile, unZipPath);
		myzip.doUnzip();
	}
}
